//package commandline;
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
	 * @throws IOException 
	 */
   public static void main(String[] args) throws IOException {
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
         //ArrayList<String> users = new ArrayList<String>(); 
        
         
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
         HumanPlayer user = new HumanPlayer(playerDeck, "Player You"); 
         playerDeck = new ArrayList<>(deck.subList(8,16));
         AIPlayer bot1 = new AIPlayer(playerDeck, "AI Player 1");
         playerDeck = new ArrayList<>(deck.subList(17,24));
         AIPlayer bot2 = new AIPlayer(playerDeck, "AI Player 2");
         playerDeck = new ArrayList<>(deck.subList(25,32));
         AIPlayer bot3 = new AIPlayer(playerDeck, "AI Player 3");
         playerDeck = new ArrayList<>(deck.subList(33,40));
         AIPlayer bot4 = new AIPlayer(playerDeck, "AI Player 4"); 
      
         
         //System.out.print("Bot2's Deck \n" + bot2.printDeck()); 
         //System.out.println("Users's Deck \n" + user.printDeck()); 
         
         //System.out.println("Selected card: " + bot3.selectCard());
         
         // 4. Start new game
         ArrayList<Player> playerList = new ArrayList<>(); 
         playerList.add(user);
         playerList.add(bot1); 
         playerList.add(bot2); 
         playerList.add(bot3); 
         playerList.add(bot4); 
         
         //shuffle the array of players
         
         CreateNewGame newGame = new CreateNewGame(playerList); 
         
         
         int roundx=1;
         Scanner scan = new Scanner(System.in); 
         while(!userWantsToQuit) {
        	 //File stats
        	 PrintWriter writer = new PrintWriter(Integer.toString(roundx)+".txt", "UTF-8");
        	 
         //Start New Round
            System.out.println("\n\nRound " + roundCount);
            System.out.println("Round " + roundCount + ": Players have drawn their cards"); 
           Card ctemp=user.drawTopCard();
            System.out.println(ctemp);
            System.out.println("There are " + user.numOfCards() + " cards in your deck"); 
            
            //Stats to the text file
            writer.println("Round " + roundCount);
            writer.println("Round " + roundCount + ": Players have drawn their cards"); 
            writer.println("Player Top Card Drawn "+ctemp);
            writer.println("There are " + user.numOfCards() + " cards in players deck");
            
            //Select first player 
            Collections.shuffle(playerList);
            String activePlayer = playerList.get(0).getName();
            System.out.println("The first player is " + activePlayer);
            writer.println("The first player is " + activePlayer);
            
            int userChoice = 0;
            if(activePlayer.equalsIgnoreCase("Player You")){
               System.out.println("It is your turn to select a category, " 
                  + "the categories are: "
                  + "\n\t1: " + (deck.get(0).getANames())[1]
                  + "\n\t2: " + (deck.get(0).getANames())[2]
                  + "\n\t3: " + (deck.get(0).getANames())[3]
                  + "\n\t4: " + (deck.get(0).getANames())[4]
                  + "\n\t5: " + (deck.get(0).getANames())[5]
                  + "\nEnter the number of your attribute:");
               userChoice = scan.nextInt(); //add throw for Inputmismatch exception 
               
               writer.println("Player category, " 
                       + "the categories are: "
                       + "\n\t1: " + (deck.get(0).getANames())[1]
                       + "\n\t2: " + (deck.get(0).getANames())[2]
                       + "\n\t3: " + (deck.get(0).getANames())[3]
                       + "\n\t4: " + (deck.get(0).getANames())[4]
                       + "\n\t5: " + (deck.get(0).getANames())[5]
                       );
               
               
               writer.println("USER CHOICE: "+userChoice);
            } else { //Method for bots to choose category
            	writer.println("Bot turn: ");
               Random math = new Random();
               userChoice = math.nextInt((5 - 1) + 1) + 1;
               System.out.println(userChoice); 
               writer.println(userChoice);
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
            		   writer.println("No category chosen");
            		   System.out.println("No category chosen");  
            	   }
            	   
            }
               
            //get all chosen cards from players and make an arraylist of cards
            ArrayList<Card> commonPile = new ArrayList<>(); 
            Card uc=user.drawTopCard();
            Card b1c=bot1.drawTopCard();
            Card b2c=bot3.drawTopCard();
            Card b3c=bot3.drawTopCard();
            Card b4c=bot4.drawTopCard();
            commonPile.add(uc); //Users card
            commonPile.add(b1c); //ai 1
            commonPile.add(b2c); //ai 2
            commonPile.add(b3c); //ai 3
            commonPile.add(b4c); //ai 4
            //remove cards at element 0 
            user.removeCard(0);
            bot1.removeCard(0);  
            bot2.removeCard(0);
            bot3.removeCard(0);
            bot4.removeCard(0);
            
            
            //Compare all cards in chosen category 
            int currentWinner = 0;
            boolean draw = false;
            for(int i = 0; i < 4; i++) {
               System.out.println("current: " + commonPile.get(currentWinner).getStats(catChoice));
               System.out.println("challenger: " + commonPile.get(i+1).getStats(catChoice));
               
               writer.println("current: " + commonPile.get(currentWinner).getStats(catChoice));
               writer.println("challenger: " + commonPile.get(i+1).getStats(catChoice));
               
               
               
               if(commonPile.get(currentWinner).getStats(catChoice) < commonPile.get(i+1).getStats(catChoice)) {
                  currentWinner = i+1;
                  draw = false; 
               } else if (commonPile.get(currentWinner).getStats(catChoice) == commonPile.get(i+1).getStats(catChoice)) {
                  draw = true; //draw
               }
               System.out.println("Current winner: " + currentWinner + " " ); 
               writer.println("Current winner: " + currentWinner + " " ); 
            }
             
            //return the winner --lose/draw/win
            if(draw) {
               System.out.println("Round " + roundCount + ": " 
                  + "This round was a Draw"); 
               writer.println("Round " + roundCount + ": " 
                       + "This round was a Draw"); 
               }
            else {
               System.out.println("Round " + roundCount + ": " 
                  + "Player " + playerList.get(currentWinner).getName() 
                  + " won this round.");
               writer.println("Round " + roundCount + ": " 
                       + "Player " + playerList.get(currentWinner).getName() 
                       + " won this round.");
               //winner gets all of common pile cards and then remove all from commonPile
               (playerList.get(currentWinner)).addCards(commonPile);  
               commonPile.clear();
               //print winning card with selected category with an arrow
               System.out.println(playerList.get(currentWinner).drawTopCard());
               writer.println(playerList.get(currentWinner).drawTopCard());
            }
            
            writer.close();
            System.out.println("\nWould you like to quit? (Y/N)?"); 
            String choice = scan.next(); 
            if(choice.equalsIgnoreCase("Y")) {
               userWantsToQuit=true; 
               // use this when the user wants to exit the game
            }
            roundx++;
            roundCount++; 
         }
      }
   
   
   }

}