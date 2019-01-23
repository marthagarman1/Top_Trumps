

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class GameTestLog {

	
	private PrintWriter printToLog;

	
	public GameTestLog() {

		try {
			printToLog = new PrintWriter("TestOfGame.log");
		} catch (FileNotFoundException e) {
			System.out.println("Log Test file connot be created");
		}
	}
	
		//Print names and the cards of players that they currently have in.
		public void playersList(ArrayList<Player> players) {

			// print players' name
			for (int i = 0; i < players.size(); i++) {

				String name = players.get(i).getName();
				printToLog.write("Player's deck: " + name + "\r\n");
				ArrayList<Card> deck = players.get(i).playerDeck.getDeck();

				// if the player has 0 cards, prints 
				if (deck.size() == 0) {
					printToLog.write(name + " has lost!");
				}

				// Loops through a player's deck of cards and prints each out to the log file
				for (int j = 0; j < deck.size(); j++) {

					String playerCat = deck.get(j).toString();
					printToLog.write(playerCat + "\r\n");
				}
			}
		}
	
	// list complete deck
	public void deckList(Card deckCat) {

		printToLog.write("The Deck Catergoies and Attributes: \n"
				+ "		   |	|	|	|	|	|	|	\n"
				+ "		   V	V	V	V	V	V	V	\n");
		ArrayList<Card> deckOfCards = deckCat.getAttributes();

		for (int i = 0; i < deckOfCards.size(); i++) {
			String card = deckOfCards.get(i).toString();
			printToLog.write(card + "\r\n");
		}
	}
	
	// print after shuffling is completed
	public void completedShuffle(Card deckCat) {
		printToLog.write("Cards has been shuffeld.\r\n");
		deckList(deckCat);
	}
	// updates a winner for entire game
		public void winnerofGameAndDate(Player gameWin) {

			Date dateAndTime = Calendar.getInstance().getTime();
			
			String winnerOfGame = gameWin.getName();
			printToLog.write("The winner is " + winnerOfGame + ".\r\n" + dateAndTime);
		}

}