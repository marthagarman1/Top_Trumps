

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.PrintWriter;
import java.io.FileNotFoundException;





public class GameTestLog {

	private PrintWriter printToLog;
	private ArrayList<Card> deckOfCar;
	private ArrayList<Card> deck;
	private String addRemoveCommunal;
	private String currentCommunal;
	private Date dateAndTime;
	private String winnerOfGame;
	private String categorySelected;

	public GameTestLog() {

		try {
			printToLog = new PrintWriter("toptrumps.log");
		} catch (FileNotFoundException e) {
			System.out.println("Log Test file connot be created");
		}
	}

	// The contents of the complete deck once it has been read in and constructed
	public void deckList(Card deckCat) {
		printToLog.write("The Deck Catergoies and Attributes: \n"
				+ "		   |	|	|	|	|	|	|	\n"
				+ "		   V	V	V	V	V	V	V	\n");
		deckOfCar = deckCat.getAttributes();

		for (int i = 0; i < deckOfCar.size(); i++) {
			String card = deckOfCar.get(i).toString();
			printToLog.write(card + "\r\n");
		}
	}

	// The contents of the complete deck after it has been shuffled
	public void completedShuffle(Card deckCat) {
		printToLog.write("Cards has been shuffeld.\r\n");
		deckList(deckCat);
	}

	// The contents of the user’s deck and the computer’s deck(s) once they have been allocated.
	public void playersList(ArrayList<Player> players) {

		for (int i = 0; i < players.size(); i++) {

			String name = players.get(i).getName();
			printToLog.write("Player's deck: " + name + "\r\n");
			deck = players.get(i).playerDeck.getDeck();

			if (deck.size() == 0) {
				printToLog.write(name + " has lost!");
			}

			for (int j = 0; j < deck.size(); j++) {
				String playerCat = deck.get(j).toString();
				printToLog.write(playerCat + "\r\n");
			}
		}
	}

	// The contents of the communal pile when cards are added or removed from it.
	public void communalPile(ArrayList<Card> winPile) {

		printToLog.write("Communal Pile contains: \n"
				+ "		   |	|	|	|	|	|	\n"
				+ "		   V	V	V	V	V	V	\n");

		for (int i = 0; i < winPile.size(); i++) {
			addRemoveCommunal = winPile.get(i).toString();
			printToLog.write(addRemoveCommunal + "\n");
		}
	}

	// The contents of the current cards in play (the cards from the top of the user’s deck and the computer’s deck(s))
	public void currentCards(ArrayList<Card> topCards) {

		printToLog.write("Current Cards in Game: \n"
				+ "		   |	|	|	|	|	\n"
				+ "		   V	V	V	V	V	\n");

		for (int i = 0; i < topCards.size(); i++) {

			currentCommunal = topCards.get(i).toString();
			printToLog.write(currentCommunal + "\r\n");

		}
	}

	// The category selected and corresponding values when a user or computer selects a category
	public void updatesCat(String category, ArrayList<Player> players) {
		categorySelected = category;
		printToLog.write("The selected category is: " + category + "\n");

		for (int i = 0; i < players.size(); i++) {

			String playerName = players.get(i).getName();
			int value = players.get(i).playerCard.getSelectedValue();
			printToLog.write(playerName + "'s " + categorySelected + " and his cards are " + value + "\n");
		}
	}

	// The contents of each deck after a round
	public void updateRound(ArrayList<Player> players) {
		printToLog.write("Updated Round: \n "
				+ "		   |	|	|	 \n"
				+ "		   V	V	V	\n");
		playersList(players);
	}
	// The winner of the game
	public void winofGameAndDate(Player gameWin) {

		dateAndTime = Calendar.getInstance().getTime();
		winnerOfGame = gameWin.getName();
		printToLog.write("The winner is " + winnerOfGame + ".\r\n" + dateAndTime);
	}
	// Close the Print Writer object after a game is over
	public void close() {
		printToLog.close();
	}
}
