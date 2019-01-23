package commandline;
import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {
    
   //ArrayList<Card> deck = new ArrayList<>();
   public AIPlayer(ArrayList<Card> deck) {
      super(deck); 
   }
   
   public Card selectCard() {
      Random r = new Random(); 
      int index = r.nextInt(deck.size());
      Card drawn = deck.get(index);
      return drawn; 
   }
   

}

}

