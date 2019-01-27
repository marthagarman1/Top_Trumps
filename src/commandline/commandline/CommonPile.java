package commandline;
import java.util.ArrayList; 

public class CommonPile {
   ArrayList<Card> cards = new ArrayList<>(); 
   ArrayList<String> users = new ArrayList<>();
 
   public CommonPile(ArrayList<Card> cards, ArrayList<String> users) {
      this.cards = cards; 
      this.users = users; 
   }   
   
}