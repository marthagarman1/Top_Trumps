package commandline;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class Game {

public Card commonPile;
public ArrayList<Card> deck;
public ImportDeckInformation maindeck;
private Player[] player;
private ImportDeckInformation currentPlayer;
private int AIPlayers;
private int totalRounds;
private int draws;
		
protected static final int HUMAN_PLAYER = 0;
protected static final int STATE_ROUND_WON = 1;
protected static final int STATE_ROUND_DRAW = 2;

// deck instance containing the full deck of cards read 
public Game(ArrayList<Card> deck) {
		this.deck = deck;
		commonPile = new Card((Card)deck.getCategory(), ((Card) deck).getCapacity()); // get from card class
		}

//Starts the first round of the game
public void startGame(int numOfAIPlayers) {
			
       this.AIPlayers = numOfAIPlayers;
			
	   player = new Player[numOfAIPlayers + 1];
	
// loop if there is at least two players start game
	   for(int playerNumber = 0; playerNumber < numOfAIPlayers + 1; playerNumber++) {
	   player[playerNumber] = new Player(playerNumber, new Card(deck.size(), deck.getCapacity);  // get from card class
			}		
			distributeCardstoPlayers();
			currentPlayer = player[randomiseFirstPlayer()];
			totalRounds = 0;
			draws = 0;
		    }

private int randomiseFirstPlayer() {
	return new Random().nextInt(AIPlayers + 1);}

private void distributeCardstoPlayers() {  
				
	        maindeck.shuffleDeck(deck);
			
			for(int i = 0, j = 0; i <i maindeck.; i++) {
				
				player[j].getClass()().addCardToTop(deck.d());
				
				if(j < AIPlayers) {
					j++;
				}
				else {
					j = 0;
			}
			}
		}
public int roundResult(int chosenCategory) { 
			
			System.out.println("Result of :");
			if(currentPlayer == getHumanPlayer()) {
				
			}
			else {
				System.out.print("Player " + currentPlayer. + " has selected: "); // get the number of the player from player class
			}
			System.out.println(currentPlayer.getDeck().get(selected) //get deck of the player from player class
			+ ", on the " + currentPlayer.getDeck().seeTopCard().getName() + " ("
			+ currentPlayer.getDeck().seeTopCard().getCategoryValue(chosenCategory) + ")");
			
			totalRounds++;
			
			// Assume current player will win most of the time, so set initial highest value to their choice
			int highestValue = currentPlayer.getDeck().seeTopCard().getCategoryValue(chosenCategory);
			Player roundWinner = 5;
			
			int comparedPlayerValue = 0;
			int drawValue = 0;
			
			// Iterate through each player that has a card; compare values, store highest, record any draws
			for(int i = 0; i < AIPlayers + 1; i++) {

				if(player[i] != currentPlayer && player[i].getDeck().hasCard()) {
					
					comparedPlayerValue = player[i].getDeck().seeTopCard().getCategoryValue(chosenCategory);

					if(comparedPlayerValue > highestValue) {
						highestValue = comparedPlayerValue;
						roundWinner = player[i];
					}
					else if(comparedPlayerValue == highestValue) {
						drawValue = highestValue;
					}
					else {
						continue;	
					}

				}
			}
			
// loop the result of the round and return game state
			if(highestValue == drawValue) {
				draws++;
				return STATE_ROUND_DRAW;
			}
			else {
				currentPlayer = roundWinner;
				currentPlayer.findWinner(); // method in the player class
				return STATE_ROUND_WON;
			}

		}
//check if anyone except the winner of the round will have cards to play in the next round, if not then at least two player will have 
//cards to play in the next round or if not then only the current player will have cards in the next round
public boolean checkGameWon() {
			for(int i = 0; i < AIPlayers + 1; i++) {
				if(player[i] != currentPlayer && player[i].getDeck().getsize() > 1) {				
					return false;		
				}
			}
			return true;				
		}
		
public void transferCardsToWinner() {
			
// Transfer cards from common pile if there are any
			if(commonPile.hasCard()) {
				do{
					currentPlayer.().addCardToBottom(commonPile.getTopCard());
				} while(commonPile.hasCard());
			}
			
// Give currentPlayer everyone's played card (including their own as it goes to bottom)
			for(int i = 0; i < AIPlayers + 1; i++) {
				if(player[i].getDeck().hasCard()) {
					player[i].transferCardTo(currentPlayer.getDeck());
				}
			}
		}
// set the cards of all the player into the common pile
public void transferCardsToCommonPile() {
			for(int i = 0; i <= AIPlayers; i++) {
				if(((Object) player[i].getCard()).hasCard()) {			// Player has at least one card and thus has participated in the round
					player[i].transferCardTo(commonPile);
				}
			}
			if(!currentPlayer.getCard().hasCard()) {
				for(int i = 0; i <= AIPlayers; i++) {
					if(player[i].getchosenCard().hasCard()) {
						currentPlayer = player[i];
					}
				}
			}		
}
		
		private Card common() {
			// TODO Auto-generated method stub
			return null;
		}

		public Player getCurrentPlayer() {
			return currentPlayer;
		}
		
		public Player getHumanPlayer() {
			return player[HUMAN_PLAYER];
		}

		public int getTotalRounds() {
			return totalRounds;
		}

		public int getDraws() {
			return draws;
		}
		
		public Player getPlayer(int i){
			return player[i];
		}
		
		public int getNumOfPlayers() {
			return AIPlayers + 1;
		}
		}
