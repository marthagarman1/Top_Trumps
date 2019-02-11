package commandline;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Card {
   private String[] aNames; 
   private String name;
   
 /** Constructor 
  * 
  */
   public Card(String name, String[] aNames, ArrayList<Integer> attributes){
      this.name=name;
      this.attributes=attributes;
      this.aNames = aNames; 
   }

   private ArrayList<Integer> attributes;
   private String[] attributeNames;
   private ArrayList<Card> deck;
   private Random random;

   //getters and setters
   public String getName() {
      return name;
   }



   public ArrayList<Integer> getAttributes() {
      return attributes;
   }


   //can print out card's information including name and stats
   public String toString(){
      String output = "\n'" + this.name + "':"
         + "\n\t> " + aNames[1] + ": " + attributes.get(0) 
         + "\n\t> " + aNames[2] + ": " + attributes.get(1) 
         + "\n\t> " + aNames[3] + ": " + attributes.get(2) 
         + "\n\t> " + aNames[4] + ": " + attributes.get(3) 
         + "\n\t> " + aNames[5] + ": " + attributes.get(4);
      return output;
   }
   
   
     public String winnderToString(int cat){
      String output = "\n'" + this.name + "':"
         + "\n\t> " + aNames[1] + ": " + attributes.get(0) 
         + (cat == 1 ? "<----" : "" )
         + "\n\t> " + aNames[2] + ": " + attributes.get(1) 
         + "\n\t> " + aNames[3] + ": " + attributes.get(2) 
         + "\n\t> " + aNames[4] + ": " + attributes.get(3) 
         + "\n\t> " + aNames[5] + ": " + attributes.get(4);
      return output;
   }
   

   //in the event of a draw, adds cards to the common pile
   public void addCommon(ArrayList<Card> CommonPile, Card c) {
      CommonPile.add(c);
   }

   //takes cards from common pile, adds them to winner's pile
   public void clearCommon(ArrayList<Card> CommonPile, ArrayList<Card> WinnerPile){
      WinnerPile.addAll(CommonPile);
      CommonPile.clear();
   }
   
   public String[] getANames() {
      return aNames; 
   }

   public String getAName(int c) {
      return aNames[c]; 
   }
   
   
   public int getStats(int i) {
      int stats =  attributes.get(i-1);
      return stats; 
   }


}
