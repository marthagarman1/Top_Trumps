package online.dwResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import java.util.Random;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import online.configuration.TopTrumpsJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import commandline.AIPlayer;
import commandline.Card;
import commandline.HumanPlayer;
import commandline.ImportDeckInformation;
import commandline.Player;
import db.DbDriver;
import db.GameResultDb;
import db.GameResultRepository;
import db.ParticipantDb;
import db.PlayerDb;
import db.PlayerRepository;
import db.PlayerType;

@Path("/toptrumps") // Resources specified here should be hosted at http://localhost:7777/toptrumps
@Produces(MediaType.APPLICATION_JSON) // This resource returns JSON content
@Consumes(MediaType.APPLICATION_JSON) // This resource can take JSON content as input
/**
 * This is a Dropwizard Resource that specifies what to provide when a user
 * requests a particular URL. In this case, the URLs are associated to the
 * different REST API methods that you will need to expose the game commands
 * to the Web page.
 * 
 * Below are provided some sample methods that illustrate how to create
 * REST API methods in Dropwizard. You will need to replace these with
 * methods that allow a TopTrumps game to be controled from a Web page.
 */
public class TopTrumpsRESTAPI {

	/** A Jackson Object writer. It allows us to turn Java objects
	 * into JSON strings easily. */
	ObjectWriter oWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();
	private int numAIPlayers;
	private ImportDeckInformation deckOfPlyer;
	private ArrayList<Player> players;
	private ArrayList<Card> cards;
	private String deckFile;
	private HumanPlayer humanPlayer;
	String activePlayer = "";
	private HumanPlayer user;
	private int currentWinner = 0;
	private ArrayList<Player> playerList;
	private String txt;
	private ArrayList<Card> commonPile;
	private ArrayList<Card> drawPile;
	private int roundCount = 1;
		
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) {
		numAIPlayers = conf.getNumAIPlayers() + 1;
		deckFile = conf.getDeckFile();
		
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}
	@Consumes(MediaType.APPLICATION_JSON)
	public void startGame() throws IOException {
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
	   	
	   	// Loop until the user wants to exit the game
	      while (!userWantsToQuit) {
	         //variables
	         
	         ArrayList<Card> deck = new ArrayList<Card>(); 
	          
	         ArrayList<String> fileOutput = new ArrayList<>();
	         PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
	      
	         // 1. Read in file and load information for cards 
	         File file = new File("StarCitizenDeck.txt"); 
	         ImportDeckInformation fI = new ImportDeckInformation(file); 
	         fileOutput.add("NEW GAME \nContents of new deck:" + fI.getDeck().toString().replace("[", "").replace("]", "")
	            + "\n--------------------\n"); 
	         
	         // 2. Return a shuffled Deck 
	         deck = fI.getShuffledDeck();
	         fileOutput.add("\nShuffled Deck: " + deck.toString().replace("[", "").replace("]", "")
	            +  "\n--------------------\n"); 
	              
	         // 3. Create Players and divide deck between players
	         ArrayList<Card> playerDeck = new ArrayList<>(deck.subList(0,8));  ///TESTING CHANGE BACK TO 0,8
	         user = new HumanPlayer(playerDeck, "PlayerDb You"); 
	         fileOutput.add("\n" + user.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	         
	         playerDeck = new ArrayList<>(deck.subList(8,16)); //16
	         AIPlayer bot1 = new AIPlayer(playerDeck, "AI PlayerDb 1");
	         fileOutput.add("\n" + bot1.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(16,24)); //24
	         AIPlayer bot2 = new AIPlayer(playerDeck, "AI PlayerDb 2");
	         fileOutput.add("\n" + bot2.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(24,32)); //32
	         AIPlayer bot3 = new AIPlayer(playerDeck, "AI PlayerDb 3");
	         fileOutput.add("\n" + bot3.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(32,40));
	         AIPlayer bot4 = new AIPlayer(playerDeck, "AI PlayerDb 4"); 
	         fileOutput.add("\n" + bot4.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	      
	         // 4. Start new game
	         playerList = new ArrayList<>(); 
	         playerList.add(user);
	         playerList.add(bot1); 
	         playerList.add(bot2); 
	         playerList.add(bot3); 
	         playerList.add(bot4); 
	         
	         Scanner scan = new Scanner(System.in); 
	         //String activePlayer = "";
	         
	         commonPile = new ArrayList<>(); 
	         
	         while(!userWantsToQuit) {
	         
	         //Start New Round
	           //Randomly selects first playerDb during first round. 
	            if(roundCount == 1) {
	               Collections.shuffle(playerList);
	               activePlayer = playerList.get(0).getName();
	            }
	        
	            //get all chosen cards from players and make an arraylist of cards
	            drawPile = new ArrayList<>(); 
     
	            for(int i = 0; i < playerList.size() ; i++ ) {
	               drawPile.add((playerList.get(i)).drawTopCard());
	            }
	               
	            fileOutput.add("\nCards in play this round:" + drawPile.toString()
	               + "\n--------------------");
	            if( user.numOfCards() != 0 ) {
	               System.out.println("You drew: " + user.drawTopCard());
	               System.out.println("There are '" + user.numOfCards() + " cards in your deck"); 
	            }
   
	            int userChoice = 0;
	            if(activePlayer.equalsIgnoreCase("PlayerDb You")){
	               System.out.print("It is your turn to select a category, " 
	                  + "the categories are: "
	                  + "\n\t1: " + (deck.get(0).getANames())[1]
	                  + "\n\t2: " + (deck.get(0).getANames())[2]
	                  + "\n\t3: " + (deck.get(0).getANames())[3]
	                  + "\n\t4: " + (deck.get(0).getANames())[4]
	                  + "\n\t5: " + (deck.get(0).getANames())[5]
	                  + "\nEnter the number for your attribute: ");
	              
	            		 userChoice = scan.nextInt();	            		 
	            	 
	                  //userChoice = scan.nextInt(); //add throw for Inputmismatch exception 
	                    
	            } else { //Method for bots to choose category
	               Random math = new Random();
	               userChoice = math.nextInt((5 - 1) + 1) + 1;
	            }         
	            int catChoice = 0;
	            
	            switch(userChoice) {
	               case 1 : catChoice = 1; 
	                  break; 
	               case 2 : catChoice = 2; 
	                  break; 
	               case 3 : catChoice = 3; 
	                  break; 
	               case 4 : catChoice = 4; 
	                  break; 
	               case 5 : catChoice = 5; 
	                  break;
	               default : 
	                  {
	                     fileOutput.add("No category chosen");
	                  }
	            }
	            
	            fileOutput.add("\nCatergory selected: " + (drawPile.get(0)).getAName(catChoice) 
	               + "\nCorresponding Values: ");
	               
	            for(int i = 0; i < playerList.size(); i++) {
	               fileOutput.add("\n" + (playerList.get(i)).getName() + ": " + drawPile.get(i).getStats(catChoice));
	            }
	            fileOutput.add("\n--------------------");
	            
	            //Compare all cards in chosen category 
	            //int currentWinner = 0;
	            boolean draw = false;
	            for(int i = 0; i < playerList.size()-1; i++) { 
	            
	               if(drawPile.get(currentWinner).getStats(catChoice) < drawPile.get(i+1).getStats(catChoice)) {
	                  currentWinner = i+1;
	                  draw = false; 
	               } else if (drawPile.get(currentWinner).getStats(catChoice) == drawPile.get(i+1).getStats(catChoice)) {
	                  draw = true; //drawn
	                  
	               }
	            }          
	            //return the winner --lose/draw/win
	            if(draw) {
	               commonPile.addAll(drawPile); 
	               fileOutput.add("\nCards added to Common Pile: " + commonPile.toString()  
	                  + "\n--------------------");
	               drawPile.clear(); 
	            }
	            
	            else {
	               activePlayer = playerList.get(currentWinner).getName(); 
	            
	               //winner gets all of common pile cards and then remove all from drawPile
	               (playerList.get(currentWinner)).addCards(drawPile);  
	               if(commonPile != null ) {
	                  fileOutput.add("\nCards removed from Common Pile: " + commonPile.toString()  
	                     + "\n--------------------");
	               }
	               commonPile.clear();         
	               drawPile.clear();               
	            }
	            
	            //remove cards at element 0 
	            // for(int i = 0; i < playerList.size(); i++) {
	               // playerList.get(i).removeCard(0);
	            // }
	            
	            if (user.numOfCards() != 0 ) {
	               user.removeCard(0);
	            }
	            if ( bot1.numOfCards() != 0 ) { bot1.removeCard(0); }
	            if ( bot2.numOfCards() != 0 ) { bot2.removeCard(0); }
	            if ( bot3.numOfCards() != 0 ) { bot3.removeCard(0); }
	            if ( bot4.numOfCards() != 0 ) { bot4.removeCard(0); }
	            
	            //print each deck 
	            for(int i = 0; i < playerList.size(); i++ ) {
	               fileOutput.add("\nAfter Round " + roundCount + "\n" 
	                  + (playerList.get(i)).getName() + "'s Deck:" + (playerList.get(i)).getDeck().toString() 
	                  + "\n--------------------\n");
	            }
	            String choice;	            
	            do {
	            	roundCount++;
	            	choice = scan.next();
	            	 
	            	 if(choice.equalsIgnoreCase("Y")) {
	                 	userWantsToQuit=true;
	                 	 //roundCount++; 
	                 }else {
	                 	continue;              	
	                 }	            	
	            }
	            while (choice.matches("\\d+"));
	                       
	            roundCount++; 	
	            	
	             //{
	               //userWantsToQuit=true; 
	               // use this when the user wants to exit the game
	            //}
	            //roundCount++;            
	            //remove players from game who no longer have cards
	            for(int i = 0; i < playerList.size(); i++) {
	               if((playerList.get(i)).numOfCards() == 0 ) {
	                  playerList.remove(i);
	                  i = 0;           
	               }
	            }     
	           //if only one playerDb remains, they are the winner
	            if(playerList.size() == 1) {
	               userWantsToQuit = true; 
	               fileOutput.add("\nThe winner is " + playerList.get(0).getName()); 
	            }            
	         }
	      
	         //print all of string array at once 
	         writer.println(fileOutput.toString().replace("[", "").replace("]", "").replace(",","")); 
	         writer.close();
	      }
	      String message = oWriter.writeValueAsString(playerList.get(0).getName());
		//return deckFile;
		//return numAIPlayers;
		//return message;
	}	   
	@GET
	@Path("/selectCategory")
	public int catChoice() throws IOException {
    boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
	   	
	   	// Loop until the user wants to exit the game
	      while (!userWantsToQuit) {
	         //variables
	         
	         ArrayList<Card> deck = new ArrayList<Card>(); 
	          
	         ArrayList<String> fileOutput = new ArrayList<>();
	         PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
	      
	         // 1. Read in file and load information for cards 
	         File file = new File("StarCitizenDeck.txt"); 
	         ImportDeckInformation fI = new ImportDeckInformation(file); 
	         fileOutput.add("NEW GAME \nContents of new deck:" + fI.getDeck().toString().replace("[", "").replace("]", "")
	            + "\n--------------------\n"); 
	         
	         // 2. Return a shuffled Deck 
	         deck = fI.getShuffledDeck();
	         fileOutput.add("\nShuffled Deck: " + deck.toString().replace("[", "").replace("]", "")
	            +  "\n--------------------\n"); 
	              
	         // 3. Create Players and divide deck between players
	         ArrayList<Card> playerDeck = new ArrayList<>(deck.subList(0,8));  ///TESTING CHANGE BACK TO 0,8
	         user = new HumanPlayer(playerDeck, "PlayerDb You"); 
	         fileOutput.add("\n" + user.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	         
	         playerDeck = new ArrayList<>(deck.subList(8,16)); //16
	         AIPlayer bot1 = new AIPlayer(playerDeck, "AI PlayerDb 1");
	         fileOutput.add("\n" + bot1.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(16,24)); //24
	         AIPlayer bot2 = new AIPlayer(playerDeck, "AI PlayerDb 2");
	         fileOutput.add("\n" + bot2.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(24,32)); //32
	         AIPlayer bot3 = new AIPlayer(playerDeck, "AI PlayerDb 3");
	         fileOutput.add("\n" + bot3.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(32,40));
	         AIPlayer bot4 = new AIPlayer(playerDeck, "AI PlayerDb 4"); 
	         fileOutput.add("\n" + bot4.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	      
	         // 4. Start new game
	         playerList = new ArrayList<>(); 
	         playerList.add(user);
	         playerList.add(bot1); 
	         playerList.add(bot2); 
	         playerList.add(bot3); 
	         playerList.add(bot4); 
	         
	         Scanner scan = new Scanner(System.in); 
	         //String activePlayer = "";
	         
	         commonPile = new ArrayList<>(); 
	         
	         while(!userWantsToQuit) {
	         
	         //Start New Round
	           //Randomly selects first playerDb during first round. 
	            if(roundCount == 1) {
	               Collections.shuffle(playerList);
	               activePlayer = playerList.get(0).getName();
	            }
	        
	            //get all chosen cards from players and make an arraylist of cards
	            drawPile = new ArrayList<>(); 
     
	            for(int i = 0; i < playerList.size() ; i++ ) {
	               drawPile.add((playerList.get(i)).drawTopCard());
	            }
	               
	            fileOutput.add("\nCards in play this round:" + drawPile.toString()
	               + "\n--------------------");
	            if( user.numOfCards() != 0 ) {
	               System.out.println("You drew: " + user.drawTopCard());
	               System.out.println("There are '" + user.numOfCards() + " cards in your deck"); 
	            }
   
	            int userChoice = 0;
	            if(activePlayer.equalsIgnoreCase("PlayerDb You")){
	               System.out.print("It is your turn to select a category, " 
	                  + "the categories are: "
	                  + "\n\t1: " + (deck.get(0).getANames())[1]
	                  + "\n\t2: " + (deck.get(0).getANames())[2]
	                  + "\n\t3: " + (deck.get(0).getANames())[3]
	                  + "\n\t4: " + (deck.get(0).getANames())[4]
	                  + "\n\t5: " + (deck.get(0).getANames())[5]
	                  + "\nEnter the number for your attribute: ");
	              
	            		 userChoice = scan.nextInt();	            		 
	            	 
	                  //userChoice = scan.nextInt(); //add throw for Inputmismatch exception 
	                    
	            } else { //Method for bots to choose category
	               Random math = new Random();
	               userChoice = math.nextInt((5 - 1) + 1) + 1;
	            }         
	            int catChoice = 0;
	            
	            switch(userChoice) {
	               case 1 : catChoice = 1; 
	                  break; 
	               case 2 : catChoice = 2; 
	                  break; 
	               case 3 : catChoice = 3; 
	                  break; 
	               case 4 : catChoice = 4; 
	                  break; 
	               case 5 : catChoice = 5; 
	                  break;
	               default : 
	                  {
	                     fileOutput.add("No category chosen");
	                  }
	            }
	            
	            fileOutput.add("\nCatergory selected: " + (drawPile.get(0)).getAName(catChoice) 
	               + "\nCorresponding Values: ");
	               
	            for(int i = 0; i < playerList.size(); i++) {
	               fileOutput.add("\n" + (playerList.get(i)).getName() + ": " + drawPile.get(i).getStats(catChoice));
	            }
	            fileOutput.add("\n--------------------");}
	      }return catChoice();
	}
    	
    @GET
    @Path("/activePlayer")
    public String activePlayer() {
	return activePlayer;
    }
    @GET
    @Path("/commonPile")
    public int commonPile() {
	return commonPile.size();
    }
    @GET
    @Path("/roundCount")
    public int roundCount() {
	return roundCount;
}
    
    @GET
    @Path("/startGame")  
    public String Game() throws IOException {
	String a = null;
	startGame();
	return a;
}
    
/*
 * Method to populate the saved statistics of the game
 * 
 * @return xAsJsonString - String representation of array containing pertinent information
 * game statistics
 * */
	
	@GET
	@Path("/statsTable")
	
	public String statsTable() throws IOException, SQLException, ClassNotFoundException {
		DbDriver db = new DbDriver(activePlayer, deckFile, txt);
		Connection x = db.getConnection();
		db.closeConnection();
		db = null;

		String xAsJsonString = oWriter.writeValueAsString(x);
		return xAsJsonString;
	}
    // save results to the database
	/**
	 * 
	 * @param results
	 * @return
	 * @throws SQLException
	 */
 
    public void GameResultRepository(DbDriver driver) {
		this.driver = driver;
	}
  
	public int getLargestNumberOfRounds() throws SQLException { 
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT max(numberOfRounds) FROM game_result").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}
	
	public int getNumberOfDraws() throws SQLException { 
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT count(*) FROM game_result WHERE winner IS NULL").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}
	
	public int getWinsByPlayerType(PlayerType type) throws SQLException {
		Connection con = driver.getConnection();
		try {
			
			PreparedStatement statement = con.prepareStatement("SELECT count(*) FROM game_result as G JOIN PLAYER AS P ON G.winner = P.id WHERE p.type = ?");
					 
			statement.setString(1, type.name());
			
			ResultSet result = statement.executeQuery(); 
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}
	
	public int totalGames() throws SQLException {
		Connection con = driver.getConnection();
		try {
			
			ResultSet result = con.prepareStatement("SELECT count(*) FROM game_result").executeQuery();
			
		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    }
		    
		    return result.getInt(1);
			
		} finally {
			con.close();
		}
	}
	
	/**
	 * 
	 * @param results
	 * @return
	 * @throws SQLException
	 * 
	 *                      Save method allows create an object (?) and save it to
	 *                      the data base.
	 */

	public int save(GameResultDb game) throws SQLException {
		validate(game);

		int id;
		Connection con = driver.getConnection();
		try {
			con.setAutoCommit(false);

			java.sql.PreparedStatement createGameStatement = con.prepareStatement(
					"INSERT INTO  game_result (winner,numberOfRounds) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			// Null means a draw
			if (game.winner != null) {
			    createGameStatement.setInt(1, game.winner.id);
			} else {
				createGameStatement.setNull(1, Types.INTEGER);
			}
			createGameStatement.setInt(2, game.numberOfRounds); 

			createGameStatement.executeUpdate();

			ResultSet result = createGameStatement.getGeneratedKeys();

		    if (!result.next()) {
		    	throw new IllegalStateException("Sql returned no rows");
		    } 
			id = result.getInt(1);
			
			for (ParticipantDb participant : game.participants) {

				java.sql.PreparedStatement createParticipantStatement = con.prepareStatement(
						"INSERT INTO  participation (roundsWon,playerId,gameId) VALUES (?, ?, ?)" );
				createParticipantStatement.setInt(1, participant.roundsWon); 
			    createParticipantStatement.setInt(2, participant.playerDb.id);  
				createParticipantStatement.setInt(3, id); 
				createParticipantStatement.executeUpdate();
			}
			
			con.commit();

			return id;
			
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			con.close();
		} 
 
	} 

	private void validate(GameResultDb results) {
		if (results.numberOfRounds < 1) {
			throw new IllegalArgumentException("Game must have at least one round");
		} 
		if (results.participants == null || results.participants.size() < 2) {
			throw new IllegalArgumentException("Game must have at least two players");
		}
	}
}

