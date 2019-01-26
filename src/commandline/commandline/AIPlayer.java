package commandline;
import java.util.ArrayList;
import java.util.Random;

public class AIPlayer extends Player {
    
   //ArrayList<Card> deck = new ArrayList<>();
   public AIPlayer(ArrayList<Card> deck) {
      super(deck); 
   }
   
   
   //Make AI smarter by choosing largest card in category
   public String selectCard() {
      Random r = new Random(); 
      int index = r.nextInt(deck.size());
      String drawn = deck.get(index).toString(); 
      return drawn; 
   }
   

}



