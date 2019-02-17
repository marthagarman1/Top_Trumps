package online.dwResources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import commandline.*;
import online.configuration.TopTrumpsJSONConfiguration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.*;

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
	private String activePlayer = "";
	private HumanPlayer user;
	private int currentWinner;
	private ArrayList<Player> playerList;
	private String txt;
	private ArrayList<Card> commonPile;
	private ArrayList<Card> drawPile;
	private int roundCount = 1;
	private ArrayList<Card> playerDeck;
	private ArrayList<Card> deck;
	private int selectcat;
	
	
	
	
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) throws IOException, URISyntaxException {
		numAIPlayers = conf.getNumAIPlayers() + 1;
		deckFile = conf.getDeckFile();
		Desktop d = Desktop.getDesktop();
		d.browse(new URI("http://localhost:7777/toptrumps"));
		
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}
	
	//public static void main(String[] args) {
	//	startGame();
	//}
	@GET
	@Path("/startGame")
	public String startGame() throws IOException {
		String message = null;
		Scanner scan = null;
		try {
			
			File file = new File("StarCitizenDeck.txt");
			
			scan = new Scanner(file).useDelimiter("/");
			
			txt = scan.next();
			
			for (int i = 0; i < txt.length();i++) {
				
			message = oWriter.writeValueAsString(txt);
			
			}
			
			
		}catch (FileNotFoundException ex) {
	    	
	        System.out.println("Cannot read file.");
		}
		scan.close();
		
	return message;
		
	}
	@GET
	@Path("/tableStats")
	public String ss() throws JsonProcessingException {
		
		int win = playerList.get(0).getRoundsWon();
		int rc = roundCount;
		int cp = commonPile.size();
		
		List<Integer> listOfWords = new ArrayList<Integer>();
		listOfWords.add(win);
		//listOfWords.add(rc);
		listOfWords.add(rc);
		listOfWords.add(cp);
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
		
		
	 
	}
	@GET
	@Path("/activePlayer")
	public String activePLA() throws JsonProcessingException {
		
		//String message = oWriter.writeValueAsString(activePlayer);
		
		return activePlayer;
	}
	@GET
	@Path("/commonPile")
	public int commPile() {
		return commonPile.size();
	}
	@GET
	@Path("/roundCount")
	public int roundCo() {
		return roundCount;
	}
	@GET
	@Path("/selectCategory")
	public String[] selectCatey() {
		
		String[] deck = this.deck.get(0).getANames();
		return deck;
	}
	@GET
	@Path("/winnerOfTheGame")
	public String winofgame() {
		return playerList.get(0).getName();
	}
	@GET
	@Path("/selectCate")
	public int selectCate(@QueryParam("SelectedCat") int selectedCat) {
		//selectedCat = getselectedcategory();
		selectcat = selectedCat;
		//selectcat = cards.get(0).getAttri();
		System.out.println(selectcat);
		//System.out.println(selectedCat);
		return selectedCat;
		
	}
	
	
	@GET
	@Path("/startGamee")
	public String startIT(@QueryParam("SelectedCat") int selectedCat) throws IOException {
		String a = null;
		//this.selectcat = selectcat;
		//startGame1();
		game2();
		System.out.println("Test it it it it " + selectcat);
		return a;
		
	}
	//@Consumes(MediaType.APPLICATION_JSON)
	public void startGame1() throws IOException {
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
	   	
	   	// Loop until the user wants to exit the game
	      while (!userWantsToQuit) {
	         //variables
	         System.out.println("Game Start"); 
	         deck = new ArrayList<Card>();
	          
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
	         playerDeck = new ArrayList<>(deck.subList(0,8));  ///TESTING CHANGE BACK TO 0,8
	         user = new HumanPlayer(playerDeck, "Player You");
	         fileOutput.add("\n" + user.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	         
	         playerDeck = new ArrayList<>(deck.subList(8,16)); //16
	         AIPlayer bot1 = new AIPlayer(playerDeck, "AI Player 1");
	         fileOutput.add("\n" + bot1.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(16,24)); //24
	         AIPlayer bot2 = new AIPlayer(playerDeck, "AI Player 2");
	         fileOutput.add("\n" + bot2.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(24,32)); //32
	         AIPlayer bot3 = new AIPlayer(playerDeck, "AI Player 3");
	         fileOutput.add("\n" + bot3.getName() + "'s Deck:" + playerDeck.toString() 
	            + "\n--------------------\n");
	            
	         playerDeck = new ArrayList<>(deck.subList(32,40));
	         AIPlayer bot4 = new AIPlayer(playerDeck, "AI Player 4");
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
	           //Randomly selects first player during first round. 
	            if(roundCount == 1) {
	               Collections.shuffle(playerList);
	               activePlayer = playerList.get(0).getName();
	            }
	         
	            System.out.println("Round " + roundCount);
	            //get all chosen cards from players and make an arraylist of cards
	            drawPile = new ArrayList<>(); 
	          
	            
	            for(int i = 0; i < playerList.size() ; i++ ) {
	               drawPile.add((playerList.get(i)).drawTopCard());
	            }
	               
	            fileOutput.add("\nCards in play this round:" + drawPile.toString()
	               + "\n--------------------"); 
	            
	            System.out.println("Round " + roundCount + ": Players have drawn their cards");
	            if( user.numOfCards() != 0 ) {
	               System.out.println("You drew: " + user.drawTopCard());
	               System.out.println("There are '" + user.numOfCards() + " cards in your deck"); 
	            }
	          
	            int userChoice = 0;
	           if(activePlayer.equalsIgnoreCase("Player You")){
	               System.out.print("It is your turn to select a category, " 
	                  + "the categories are: "
	                  + "\n\t1: " + (deck.get(0).getANames())[1]
	                  + "\n\t2: " + (deck.get(0).getANames())[2]
	                  + "\n\t3: " + (deck.get(0).getANames())[3]
	                  + "\n\t4: " + (deck.get(0).getANames())[4]
	                  + "\n\t5: " + (deck.get(0).getANames())[5]
	                  + "\nEnter the number for your attribute: ");
	               //TopTrumpsRESTAPI catsel = new TopTrumpsRESTAPI(null);
	            		 System.out.println("Enter Number 1 or 5");
	            		 //userChoice = scan.nextInt();
	            		 //userChoice = getselectedcategory();
	            		 
	            	 
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
	                     System.out.println("No category chosen");  
	                  }
	            }
	            
	            fileOutput.add("\nCatergory selected: " + (drawPile.get(0)).getAName(catChoice) 
	               + "\nCorresponding Values: ");
	               
	            for(int i = 0; i < playerList.size(); i++) {
	              // fileOutput.add("\n" + (playerList.get(i)).getName() + ": " + drawPile.get(i).getStats(catChoice));
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
	               System.out.println("Round " + roundCount + ": " 
	                  + "This round was a Draw"); 
	               commonPile.addAll(drawPile); 
	               fileOutput.add("\nCards added to Common Pile: " + commonPile.toString()  
	                  + "\n--------------------");
	               drawPile.clear(); 
	            }
	            
	            else {
	               System.out.println("Round " + roundCount + ": " 
	                  + "Player " + playerList.get(currentWinner).getName() 
	                  + " won this round.");
	               activePlayer = playerList.get(currentWinner).getName(); 
	            
	               //winner gets all of common pile cards and then remove all from drawPile
	               (playerList.get(currentWinner)).addCards(drawPile);  
	               if(commonPile != null ) {
	                  fileOutput.add("\nCards removed from Common Pile: " + commonPile.toString()  
	                     + "\n--------------------");
	               }
	               commonPile.clear();
	               
	                  
	               //print winning card with selected category with an arrow
	               System.out.print("The winning card was "); 
	               drawPile.clear();
	               System.out.println(playerList.get(currentWinner).drawTopCard());
	               
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
	            
	            
	         
	            System.out.println("\nWould you like to quit? (Y/N)?"); 
	            String choice;
	            
	            /*do {
	            	System.out.println("Enter Y or N");
	            	//roundCount++;
	            	choice = scan.next();
	            	 
	            	 if(choice.equalsIgnoreCase("Y")) {
	                 	userWantsToQuit=true;
	                 	 //roundCount++; 
	                 }else {
	                 	continue;
	                 	
	                 }
	            	 
	            	
	            }
	            while (choice.matches("\\d+"));
	            	**/
	            
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
	         
	           //if only one player remains, they are the winner
	            if(playerList.size() == 1) {
	               System.out.println("The winner is " + playerList.get(0).getName()); 
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
	
	public void game2() throws IOException {
		
		//Test Log is launched from here :
        boolean writeGameLogsToFile = false; // Should we write game logs to file?

        //if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile = true; // Command line selection

        // flag to check whether the user wants to quit the application
        boolean userWantsToQuit = false;

        /* Game Loop until the user wants to exit the game */
        while (!userWantsToQuit) {
            // Declare Variables used in Game Loop
            /** ArrayList of cards that will be dealt into player's hands. */
            
            /** Counts which round game is currently on. */
            roundCount = 1;
            /** ArrayList that will be printed to log. */
            ArrayList<String> fileOutput = new ArrayList<>();
            /** Used to write fileOutput to toptrumps.log */
            //PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
            /** Scanner for user Input in Game Loop. */
            Scanner scan = new Scanner(System.in);
            /** Keeps track of current player, after first round represents current Winner. */
            //String activePlayer = "";
            /** Cards added to ArrayList after Draw. */
            commonPile = new ArrayList<>();


            /** Start the Game */
            System.out.println("Game Start");
            // 1. Read in file and load information for cards
            File file = new File("StarCitizenDeck.txt");
            ImportDeckInformation fI = new ImportDeckInformation(file);
            fileOutput.add("NEW GAME \nContents of new deck:"
              //      + fI.getDeck().toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");

            // 2. Return a shuffled Deck
            deck = fI.getShuffledDeck();
            fileOutput.add("\nShuffled Deck: "
                    + deck.toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");


            // 3. Create Players and divide deck between players
            playerDeck = new ArrayList<>(deck.subList(0, 8));
            // TODO ask for name via input

            user = new HumanPlayer(playerDeck, "Player You");
            fileOutput.add("\n" + user.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(8, 16)); //16
            AIPlayer bot1 = new AIPlayer(playerDeck, "AI Player 1");
            fileOutput.add("\n" + bot1.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(16, 24)); //24
            AIPlayer bot2 = new AIPlayer(playerDeck, "AI Player 2");
            fileOutput.add("\n" + bot2.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(24, 32)); //32
            AIPlayer bot3 = new AIPlayer(playerDeck, "AI Player 3");
            fileOutput.add("\n" + bot3.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(32, 40));
            AIPlayer bot4 = new AIPlayer(playerDeck, "AI Player 4");
            fileOutput.add("\n" + bot4.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            // 4. Start new game by adding players and their decks to game.
            playerList = new ArrayList<>();
            ArrayList<Player> losers = new ArrayList();
            playerList.add(user);
            playerList.add(bot1);
            playerList.add(bot2);
            playerList.add(bot3);
            playerList.add(bot4);

            //savePlayers(playerList);

            while (!userWantsToQuit) {
                //Start New Round
                //Randomly selects first player during first round.
                if (roundCount == 1) {
                    Collections.shuffle(playerList);
                    activePlayer = playerList.get(0).getName();
                }

                System.out.println("Round " + roundCount);
                //get all drawn cards from players and make an arraylist of cards
                ArrayList<Card> drawPile = new ArrayList<>();
                for (int i = 0; i < playerList.size(); i++) {
                    drawPile.add((playerList.get(i)).drawTopCard());
                }
                fileOutput.add("\nCards in play this round:" + drawPile.toString()
                        + "\n--------------------");

                System.out.println("Round " + roundCount
                        + ": Players have drawn their cards");
                if (user.numOfCards() != 0) {
                    System.out.println("You drew: " + user.drawTopCard());
                    System.out.println("There are '" + user.numOfCards()
                            + " cards in your deck");
                }
                /**User's selected category represeneted by int. */
                int userCatChoice = 0;
                //int userCatChoice = cards.get(0).getAttri();
                //If the active player is Human, they can select a category.
                if (activePlayer.equalsIgnoreCase("Player You")) {
                    System.out.print("It is your turn to select a category, "
                            + "the categories are: "
                            + "\n\t1: " + (deck.get(0).getANames())[1]
                            + "\n\t2: " + (deck.get(0).getANames())[2]
                            + "\n\t3: " + (deck.get(0).getANames())[3]
                            + "\n\t4: " + (deck.get(0).getANames())[4]
                            + "\n\t5: " + (deck.get(0).getANames())[5]
                            + "\nEnter the number for your attribute: ");
                   try {
                        userCatChoice = scan.nextInt();
                        
                        //userCatChoice = getselectedcategory();
                        
                        System.out.println("test this one ---" + userCatChoice);
                  } catch (InputMismatchException e) {
                        System.out.print("\nPlease enter number 1 - 5");
                   }
                //If the active player is a bot, they will randomly select a category.
                } else {
                    //Method for bots to choose category
                    Random math = new Random();
                    userCatChoice = math.nextInt((5 - 1) + 1) + 1;
                }


                fileOutput.add("\nCatergory selected: "
                        + (drawPile.get(0)).getAName(userCatChoice)
                        + "\nCorresponding Values: ");

                for (int i = 0; i < playerList.size(); i++) {
                   // fileOutput.add("\n" + (playerList.get(i)).getName() + ": "
                     //       + drawPile.get(i).getStats(userCatChoice));
                }
                fileOutput.add("\n--------------------");

                //Compare all cards in chosen category
                int currentWinner = 0;
                boolean draw = false;
                for (int i = 0; i < playerList.size() - 1; i++) {

                    if (drawPile.get(currentWinner).getStats(userCatChoice)
                            < drawPile.get(i + 1).getStats(userCatChoice)) {
                        currentWinner = i + 1;
                        draw = false;
                    } else if (drawPile.get(currentWinner).getStats(userCatChoice)
                            == drawPile.get(i + 1).getStats(userCatChoice)) {
                        draw = true; //drawn

                    }
                }

                //return the winner --lose/draw/win
                if (draw) {
                    commonPile.addAll(drawPile);
                    System.out.println("Round " + roundCount + ": "
                            + "This round was a Draw, common pile now has "
                            +  commonPile.size() + " cards");
                    fileOutput.add("\nCards added to Common Pile: " + commonPile.toString()
                            + "\n--------------------");
                    drawPile.clear();
                } else {
                    System.out.println("Round " + roundCount + ": "
                            + "Player " + playerList.get(currentWinner).getName()
                            + " won this round.");
                    activePlayer = playerList.get(currentWinner).getName();

                    //winner gets all of common pile cards and then remove all from drawPile
                    (playerList.get(currentWinner)).addCards(drawPile);
                    if (commonPile != null) {
                        fileOutput.add("\nCards removed from Common Pile: " + commonPile.toString()
                                + "\n--------------------");
                    }
                    commonPile.clear();







                    //print winning card with selected category with an arrow
                    System.out.print("The winning card was ");
                    drawPile.clear();
                    //arrow
                    System.out.println(playerList.get(currentWinner)
                            .drawTopCard().winnerToString(userCatChoice));

                }
                System.out.println("test this one ---" + userCatChoice);
                System.out.println("test this one ---" + userCatChoice);
                System.out.println("test this one ---" + userCatChoice);

                for (Player player : playerList) {
                    if (player.numOfCards() != 0) {
                        player.removeCard(0);
                    }
                }

                //Log each deck after Round
                for (int i = 0; i < playerList.size(); i++) {
                    fileOutput.add("\nAfter Round " + roundCount + "\n"
                            + (playerList.get(i)).getName() + "'s Deck:"
                            + (playerList.get(i)).getDeck().toString()
                            + "\n--------------------\n");
                }


                //End of round increase count
                roundCount++;

                //remove players from game who no longer have cards
                for (int i = 0; i < playerList.size(); i++) {
                    Player player = playerList.get(i);
                    if (player.numOfCards() == 0) {
                        playerList.remove(i);
                        losers.add(player);
                        i = 0;
                       // markAsWinners(playerList);
                    }
                }

                System.out.println("There are " + playerList.size() + " players left.");

                //if only one player remains or there are cards in the commonPile, a winner is selected:
                if (playerList.size() == 1 || commonPile.size() == -1) {

                    //saveGameResults(roundCount, playerList.get(0), losers);
                    //TODO save game result and participants in the database here (Using GameResultRepository)

                    System.out.println("The winner is " + playerList.get(0).getName());
                    userWantsToQuit = true;
                    fileOutput.add("\nThe winner is " + playerList.get(0).getName());
                }


                if(!playerList.contains(user)) {System.out.println("You have lost");}
                // use this when the user wants to exit the game, only ask if losing or lost
               //if(!activePlayer.equals(user) && user.numOfCards() <= 0) {
                    //System.out.println("\nWould you like to quit? (Y/N)?");
                    //String choice = scan.next();
                    //if (choice.equalsIgnoreCase("Y")) {
                      //  userWantsToQuit = true;
                   //}
                    //continue;
                //}
               

            }

            if (writeGameLogsToFile) {
                //print all of string array at once
                //writer.println(fileOutput.toString().replace("[", "")
                  //      .replace("]", "").replace(",", ""));
                //writer.close();
            }
        }

    }

		
		
	
	
	
		   
	public int getselectedcategory() {
		return selectcat;
	}
	
	
	
	
	// ----------------------------------------------------
	// Add relevant API methods here
	// ----------------------------------------------------
	
	@GET
	@Path("/helloJSONList")
	/**
	 * Here is an example of a simple REST get request that returns a String.
	 * We also illustrate here how we can convert Java objects to JSON strings.
	 * @return - List of words as JSON
	 * @throws IOException
	 */
	public String helloJSONList() throws IOException {
		
		List<String> listOfWords = new ArrayList<String>();
		listOfWords.add("Hello");
		listOfWords.add("World!");
		
		// We can turn arbatory Java objects directly into JSON strings using
		// Jackson seralization, assuming that the Java objects are not too complex.
		String listAsJSONString = oWriter.writeValueAsString(listOfWords);
		
		return listAsJSONString;
	}
	
	@GET
	@Path("/helloWord")
	/**
	 * Here is an example of how to read parameters provided in an HTML Get request.
	 * @param Word - A word
	 * @return - A String
	 * @throws IOException
	 */
	public String helloWord(@QueryParam("Word") String Word) throws IOException {
		return "Hello "+Word;
	}
	
}
