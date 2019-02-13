package commandline;
import java.util.ArrayList;

public class HumanPlayer extends Player {
   //class variables 
   ArrayList<Card> deck = new ArrayList<>();
   String name = "";
   public HumanPlayer (ArrayList<Card> deck, String name) {
      super(deck, name);
      this.deck = deck; 
      this.name = name; 
   }
   

}



