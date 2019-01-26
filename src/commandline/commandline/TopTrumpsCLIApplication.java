package commandline;
//import commandline.ReadInFile;
import java.io.*;
import java.util.ArrayList; 
import java.util.Random; 
import java.util.Collections;
import java.util.Scanner; 
//import java.util.


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
         System.out.println("Game Start"); 
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
         
         
         //System.out.print("Bot2's Deck \n" + bot2.printDeck()); 
         //System.out.println("Users's Deck \n" + user.printDeck()); 
         
         System.out.println("Selected card: " + bot3.selectCard());
         
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
         
         
      
         Scanner scan = new Scanner(System.in); 
         while(!userWantsToQuit) {
         //Start New Round
            System.out.println("\n\nRound " + roundCount); 
            bot4.selectCard();
         //user.selectCard(1); 
            System.out.println("Round " + roundCount + ": Players have drawn their cards"); 
            System.out.println(user.drawTopCard());
            System.out.println("There are " + user.numOfCards() + " cards in your deck"); 
            System.out.println("It is your turn to select a category, " 
               + "the categories are: "
               + "\n\t1: " + (deck.get(0).getANames())[1]
               + "\n\t2: " + (deck.get(0).getANames())[2]
               + "\n\t3: " + (deck.get(0).getANames())[3]
               + "\n\t4: " + (deck.get(0).getANames())[4]
               + "\n\t5: " + (deck.get(0).getANames())[5]
               + "Enter the number of your attribute:");
            int userChoice = scan.nextInt(); //add throw exception 
            
            int catChoice = 0;
            switch(userChoice) {
               case 1 : catChoice = 1; 
               case 2 : catChoice = 2; 
               case 3 : catChoice = 3; 
               case 4 : catChoice = 4; 
               case 5 : catChoice = 5; 
               default : System.out.println("No category chosen");  
            }
               
            //get all cards from players and make an arraylist 
            ArrayList<Card> playDeck = new ArrayList<>(); 
            playDeck.add(user.drawTopCard());
            playDeck.add(bot1.drawTopCard());
            playDeck.add(bot2.drawTopCard());
            playDeck.add(bot3.drawTopCard());
            playDeck.add(bot4.drawTopCard());
         
            //Compare all cards in elemnet 0 
            
            //remove cards at element 0 
            //return the winner --lose/draw/win
            System.out.print("Round " + roundCount + ": " ); 
            //print winning card with selected category with an arrow
            
            
            
            System.out.println("Would you like to quit? (Y/N)?"); 
            String choice = scan.next(); 
            if(choice.equalsIgnoreCase("Y")) {
               userWantsToQuit=true; 
               // use this when the user wants to exit the game
            }
            roundCount++; 
         }
      }
   
   
   }

}

