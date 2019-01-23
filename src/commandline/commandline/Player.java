package commandline;
import java.util.ArrayList;


public abstract class Player {
   ArrayList<Card> deck = new ArrayList<Card>();
   public Player(ArrayList<Card> deck) {
      this.deck = deck; 
   }
   
   public abstract void selectCard();
   
   public String printDeck() {
      String output = deck.toString(); 
      return output;
   }; 
}
