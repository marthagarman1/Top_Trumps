package commandline;
import java.util.ArrayList;


public abstract class Player {
   ArrayList<Card> deck = new ArrayList<Card>();
   String name = "";
   int id;
   int roundsWon = 0;

   public Player(ArrayList<Card> deck, String name) {
      this.deck = deck; 
      this.name = name; 
   }
   
   public ArrayList<Card> getDeck() {
      return deck; 
   }
      
   public String printDeck() {
      String output = deck.toString(); 
      return output;
   }; 
   
   public void setPlayerNumber() {
      
   } 
   
   public int getNumberCards() {
      
      return 1; 
   }
   
   public Card drawTopCard() {
      Card drawn = deck.get(0); 
      return drawn; 
   }

   public void hasWon() {
      roundsWon++;
   }

   public int getRoundsWon() {
      return roundsWon;
   }

   public int numOfCards() {
      return deck.size(); 
   }
   
   public String getName() {
      return name; 
   }
   
   public void removeCard(int x) {
      deck.remove(x); 
   }
   
   public void addCards(ArrayList<Card> commonPile) {
      deck.addAll(commonPile);
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
}



