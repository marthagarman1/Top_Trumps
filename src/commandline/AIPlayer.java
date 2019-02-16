package commandline;
import java.util.ArrayList;
import java.util.Random;


public class AIPlayer extends Player {
    

   public AIPlayer(ArrayList<Card> deck, String name) {
      super(deck, name); 
   }
   
   
   //Make AI smarter by choosing largest card in category
   public String selectCard() {
      Random r = new Random(); 
      int index = r.nextInt(deck.size());
      String drawn = deck.get(index).toString(); 
      return drawn; 
   }
   
   public int pickCategory() {
	   Random math = new Random();
       int choice = math.nextInt((5 - 1) + 1) + 1;
	   return choice; 
   }
   

}



