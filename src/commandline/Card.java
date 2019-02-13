package commandline;

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
   
   
     public String winnerToString(int cat){
      ArrayList<String> outputList = new ArrayList<>();
        outputList.add("\n'" + this.name + "':"
         + "\n\t> " + aNames[1] + ": " + attributes.get(0));
        if(cat==1) {outputList.add(" <--");}
        outputList.add("\n\t> " + aNames[2] + ": " + attributes.get(1));
         if(cat==2) {outputList.add(" <--");}
        outputList.add("\n\t> " + aNames[3] + ": " + attributes.get(2));
         if(cat==3) {outputList.add(" <--");}
        outputList.add("\n\t> " + aNames[4] + ": " + attributes.get(3));
         if(cat==4) {outputList.add(" <--");}
        outputList.add("\n\t> " + aNames[5] + ": " + attributes.get(4));
         if(cat==5) {outputList.add(" <--");}
      String output = String.join("",outputList);
      return output;
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
