package online.dwResources;

import java.awt.Desktop;

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
import java.util.InputMismatchException;
import java.net.URI;

import java.util.Random;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import online.configuration.TopTrumpsJSONConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;



import commandline.AIPlayer;
import commandline.Card;
import commandline.HumanPlayer;
import commandline.ImportDeckInformation;
import commandline.Player;
import db.DbDriver;
import db.GameResultRepository;
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

	
	
	//TopTrumpsCLIApplication topTrumps;
	//ImportDeckInformation deck;
	//Boolean logsToFile = false;
	static DbDriver db;
	
	// eliminate not used variables

	String activePlayer = "";
	private int roundCount = 1;
    int numPlayers;
    String deckFile;
	
		
	/**
	 * Contructor method for the REST API. This is called first. It provides
	 * a TopTrumpsJSONConfiguration from which you can get the location of
	 * the deck file and the number of AI players.
	 * @param conf
	 */
	public TopTrumpsRESTAPI(TopTrumpsJSONConfiguration conf) throws Exception {
		
		  numPlayers = conf.getNumAIPlayers() + 1;
		  deckFile = conf.getDeckFile();
		
		 File file = new File("StarCitizenDeck.txt"); 
       
		
		  Desktop d = Desktop.getDesktop();
		  d.browse(new URI("http://localhost7777/toptrumps"));
        
         PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
      
         // 1. Read in file and load information for cards 
         
         ImportDeckInformation fI = new ImportDeckInformation(file); 
		
		// ----------------------------------------------------
		// Add relevant initalization here
		// ----------------------------------------------------
	}
				
	 @GET
	 @Path("/startGame")  
	 public String Game() throws Exception {
	     String a = null;
		startGame();
		return a;
	}
	public void startGame() throws Exception {
        boolean writeGameLogsToFile = false; // Should we write game logs to file?

        //if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile = true; // Command line selection

        // flag to check whether the user wants to quit the application
        boolean userWantsToQuit = false;

        /* Game Loop until the user wants to exit the game */
        while (!userWantsToQuit) {
            // Declare Variables used in Game Loop
            /** ArrayList of cards that will be dealt into player's hands. */
            ArrayList<Card> deck;
            /** Counts which round game is currently on. */
            int roundCount = 1;
            /** ArrayList that will be printed to log. */
            ArrayList<String> fileOutput = new ArrayList<>();
            /** Used to write fileOutput to toptrumps.log */
            PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
            /** Scanner for user Input in Game Loop. */
            Scanner scan = new Scanner(System.in);
            /** Keeps track of current player, after first round represents current Winner. */
            String activePlayer = "";
            /** Cards added to ArrayList after Draw. */
            ArrayList<Card> commonPile = new ArrayList<>();


            /** Start the Game */
            System.out.println("Game Start");
            // 1. Read in file and load information for cards
            File file = new File("StarCitizenDeck.txt");
            ImportDeckInformation fI = new ImportDeckInformation(file);
            fileOutput.add("NEW GAME \nContents of new deck:"
                    + fI.getDeck().toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");

            // 2. Return a shuffled Deck
            deck = fI.getShuffledDeck();
            fileOutput.add("\nShuffled Deck: "
                    + deck.toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");
           // 3. Create Players and divide deck between players
            ArrayList<Card> playerDeck = new ArrayList<>(deck.subList(0, 8));
            // TODO ask for name via input

            HumanPlayer user = new HumanPlayer(playerDeck, "Player You");
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
            ArrayList<Player> playerList = new ArrayList<>();
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
                //get all drawn cards from players and make an arraylist of cards
                ArrayList<Card> drawPile = new ArrayList<>();
                for (int i = 0; i < playerList.size(); i++) {
                    drawPile.add((playerList.get(i)).drawTopCard());
                }
                fileOutput.add("\nCards in play this round:" + drawPile.toString()
                        + "\n--------------------");
                if (user.numOfCards() != 0) {
                
                }
                /**User's selected category represeneted by int. */
                int userCatChoice = 0;
                //If the active player is Human, they can select a category.
                if (activePlayer.equalsIgnoreCase("Player You")) {
                   
                    try {
                        userCatChoice = scan.nextInt();
                    } catch (InputMismatchException e) {
                        
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
                    fileOutput.add("\n" + (playerList.get(i)).getName() + ": "
                            + drawPile.get(i).getStats(userCatChoice));
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
                    drawPile.clear();
                } else {
                   
                    activePlayer = playerList.get(currentWinner).getName();

                    //winner gets all of common pile cards and then remove all from drawPile
                    (playerList.get(currentWinner)).addCards(drawPile);
                    if (commonPile != null) {
                        fileOutput.add("\nCards removed from Common Pile: " + commonPile.toString()
                                + "\n--------------------");
                    }
                    commonPile.clear();
                    drawPile.clear();
                }

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
                        
                    }
                }

                //if only one player remains or there are cards in the commonPile, a winner is selected:
                if (playerList.size() == 1 && commonPile.size() >= 1) {
                    userWantsToQuit = true;
                    fileOutput.add("\nThe winner is " + playerList.get(0).getName());
                }

                if(!playerList.contains(user)) {System.out.println("You have lost");}
                // use this when the user wants to exit the game, only ask if losing or lost
                if(!activePlayer.equals(user) && user.numOfCards() <= 0) {
                    String choice = scan.next();
                    if (choice.equalsIgnoreCase("Y")) {
                        userWantsToQuit = true;
                    }
                }
            }
            if (writeGameLogsToFile) {
                //print all of string array at once
                writer.println(fileOutput.toString().replace("[", "")
                        .replace("]", "").replace(",", ""));
                writer.close();
            }
        }

    }	
    @GET
    @Path("/activePlayer")
    public String activePlayer() {
	return activePlayer();
    }
    @GET
    @Path("/roundCount")
    public int roundCount() {
    	int roundCount = 1;
		return roundCount;
    }
  
/*
 * The method up dates the database variables ready for retrieval
 * @throws Exception
 * */
		
public void getStats() throws Exception {
		
		DbDriver driver = null;
		GameResultRepository db = new GameResultRepository(driver);

		db.getLargestNumberOfRounds();
		db.getNumberOfDraws();
		db.getWinsByPlayerType(PlayerType.ai);
		db.getWinsByPlayerType(PlayerType.human);
		db.totalGames();
			
	}
	/* this method passes a database object containing all the statistics 
	 * data into a string and returns it
	 */
	@GET 
	@Path("/getStatistics")
	public String getStatistics() throws Exception {
		getStats();
		String dbString = oWriter.writeValueAsString(TopTrumpsRESTAPI.db);
	    return dbString;
	}
	}
