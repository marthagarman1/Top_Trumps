package commandline;
//import commandline.ReadInFile;
import java.io.*;
import java.util.ArrayList; 
import java.util.Random; 
import java.util.Collections;

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
         //variables
         System.out.println("Lets start the Game:"); 
         ArrayList<Card> deck = new ArrayList<Card>(); 
         int roundCount = 1; 
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
         
         // 4. Start new game
         ArrayList<Player> playerList = new ArrayList<>(); 
         playerList.add(user);
         playerList.add(bot1); 
         playerList.add(bot2); 
         playerList.add(bot3); 
         playerList.add(bot4); 
         
         //shuffle the array of players
         Collections.shuffle(playerList);
         CreateNewGame newGame = new CreateNewGame(playerList); 
         
         
         System.out.println("\n\nRound " + roundCount); 
         bot4.selectCard();
         user.selectCard(1); 
         System.out.println("Round " + roundCount + ": Players have drawn their cards"); 
         System.out.println("There are " + "x" + " cards in your deck"); 
         
                        
         userWantsToQuit=true; // use this when the user wants to exit the game
      	
      }
   
   
   }

}

