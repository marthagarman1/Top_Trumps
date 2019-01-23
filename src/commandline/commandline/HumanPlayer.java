package commandline;
import java.util.ArrayList;

public class HumanPlayer extends Player {
   //class variables 
   ArrayList<Card> deck = new ArrayList<>();
   public HumanPlayer (ArrayList<Card> deck) {
      super(deck);
   }
   
   public Card selectCard(int x) {
      Card drawn = deck.get(x);
      return drawn; 
      
   }
}