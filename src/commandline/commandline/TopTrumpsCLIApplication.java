package commandline;
//import commandline.ReadInFile;
import java.io.*;
import java.util.ArrayList; 
import java.util.Random; 

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
   public static void main(String[] args) throws IOException{
      //Test Log is launched from here :
      boolean writeGameLogsToFile = false; // Should we write game logs to file?
      
      //if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
      //{
         //enter logic to run test log class 
      //}
   	
      boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
   	
   	// Loop until the user wants to exit the game
      while (!userWantsToQuit) {
      
         System.out.println("Lets start the Game:"); 
         ArrayList<Card> deck = new ArrayList<Card>(); 
         
      	// ----------------------------------------------------
      	// Add your game logic here based on the requirements
      	// ----------------------------------------------------
      
         
         // 1. Read in file and load information for cards 
         File file = new File("StarCitizenDeck.txt"); 
         ImportDeckInformation fI = new ImportDeckInformation(file); 
         
         // 2. Return a shuffled Deck 
         deck = fI.getDeck();
         
         // 3. Create Players and divide deck between players
         ArrayList<Card> playerDeck = new ArrayList<>(deck.subList(0,7));
         HumanPlayer user = new HumanPlayer(playerDeck); 
         playerDeck = new ArrayList<>(deck.subList(8,16));
         AIPlayer bot1 = new AIPlayer(playerDeck);
         playerDeck = new ArrayList<>(deck.subList(17,24));
         AIPlayer bot2 = new AIPlayer(playerDeck);
         playerDeck = new ArrayList<>(deck.subList(25,32));
         AIPlayer bot3 = new AIPlayer(playerDeck);
         playerDeck = new ArrayList<>(deck.subList(33,40));
         AIPlayer bot4 = new AIPlayer(playerDeck); 
         System.out.print("Bot2's Deck \n" + bot2.printDeck()); 
         System.out.println("Users's Deck \n" + user.printDeck()); 
         
         // 4. Create new instance of game
         ArrayList<Player> newGame = new ArrayList<>(); 
         newGame.add(user);
         newGame.add(bot1); 
         newGame.add(bot2); 
         newGame.add(bot3); 
         newGame.add(bot4); 
         
         // 4. Split shuffled deck between players
         
            // 5. 
            
            // 6.
            //    
            //
            //
            // 2. Shuffle card deck
            //    Select First User
            // 3. Show top card in user deck 
            // 4. If user is AI select a catergory to play
            // 5. 
            //
            //
            
         userWantsToQuit=true; // use this when the user wants to exit the game
      	
      }
   
   
   }

}

