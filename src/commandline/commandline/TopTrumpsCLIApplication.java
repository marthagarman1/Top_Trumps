package commandline;
//import commandline.ReadInFile;
import java.io.*;
import java.util.ArrayList; 

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
      if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
      {
         //enter logic to run test log class 
      }
   	
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
         deck = fI.getDeck();
         
         // Select number of players (create AI n-1)
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

