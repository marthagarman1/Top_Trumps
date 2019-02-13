package commandline;
import java.util.ArrayList;


public abstract class Player {
   ArrayList<Card> deck;
   String name;


   public Player(ArrayList<Card> deck, String name) {
      this.deck = deck;
      this.name = name;
   }

   public ArrayList<Card> getDeck() {
      return deck;
   }


   public Card drawTopCard() {
      Card drawn = deck.get(0);
      return drawn;
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
}







