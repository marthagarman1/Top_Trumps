package commandline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
   private commandline.Card c;
   private String name;
   private String[] aNames = new String[] {"a1", "a2", "a3", "a4","a5","a6"};
   private ArrayList<Integer> attributes = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
   private ArrayList<commandline.Card> deck = new ArrayList<>();
   ArrayList< commandline.Card > winnerPile = new ArrayList<>();

   @BeforeEach
   public void setup(){
      c = new commandline.Card(this.name, this.aNames, this.attributes);
   }


   @Test
   public void testToString() {
      String expected = "\nYou drew '" + this.name + "':"
             + "\n\t> " + aNames[1] + ": " + attributes.get(0)
             + "\n\t> " + aNames[2] + ": " + attributes.get(1)
             + "\n\t> " + aNames[3] + ": " + attributes.get(2)
             + "\n\t> " + aNames[4] + ": " + attributes.get(3)
             + "\n\t> " + aNames[5] + ": " + attributes.get(4);
      assertEquals(expected, c.toString(),"Check Card toString");
   }


   @Test
   public void testGetANames() {
      c.getANames();
      for(int i=0; i<aNames.length; i++){
         assertEquals(aNames[i], c.getANames()[i], "Check correct attribute names are fetched");
      }
   }

   @Test
   public void testGetStats() {
      int i = 5;
      assertEquals(5, c.getStats(i));
   }
}