package commandline;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Card{
   private String[] aNames; 
   private String name;
   private String cat1;
   private String cat2;
   private String cat3;
   private String cat4;
   
 /** Constructor 
  * 
  */
   public Card(String name, String[] aNames, ArrayList<Integer> attributes){
      this.name=name;
      this.attributes=attributes;
      this.aNames = aNames; 
   }
   
   public void setAttributeNames(String[] aNames) {
      this.aNames = aNames; 
   }
   
   
   public void setCat1(String cat1) {
      this.cat1 = cat1;
   }

   public void setCat2(String cat2) {
      this.cat2 = cat2;
   }

   public void setCat3(String cat3) {
      this.cat3 = cat3;
   }

   public void setCat4(String cat4) {
      this.cat4 = cat4;
   }

   public void setCat5(String cat5) {
      this.cat5 = cat5;
   }

   private String cat5;
   private ArrayList<Integer> attributes;
   private String[] attributeNames;
   private ArrayList<Card> deck;
   private Random random;

   //getters and setters
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


   public ArrayList<Integer> getAttributes() {
      return attributes;
   }

   public void setAttributes(ArrayList<Integer> attributes) {
      this.attributes = attributes;
   }




   //method to set category names
   public void setCatNames(String[] names){
      setCat1(names[1]);
      setCat2(names[2]);
      setCat3(names[3]);
      setCat4(names[4]);
      setCat5(names[5]);
   }



   //draws a random card from the player's deck
   public Card drawCard(ArrayList<Card> deck){
      int index = random.nextInt(deck.size());
      Card drawn = deck.get(index);
      return drawn;
   }

   //can print out card's information including name and stats
   public String toString(){
      return "\nYou drew '" + this.name + ":"
         + "\n\t> " + aNames[1] + ": " + attributes.get(0) 
         + "\n\t> " + aNames[2] + ": " + attributes.get(1) 
         + "\n\t> " + aNames[3] + ": " + attributes.get(2) 
         + "\n\t> " + aNames[4] + ": " + attributes.get(3) 
         + "\n\t> " + aNames[5] + ": " + attributes.get(4);
   }

   //in the event of a draw, adds cards to the common pile
   public void addCommon(ArrayList<Card> CommonPile, Card c){
      CommonPile.add(c);
   }

   //takes cards from common pile, adds them to winner's pile
   public void clearCommon(ArrayList<Card> CommonPile, ArrayList<Card> WinnerPile){
      WinnerPile.addAll(CommonPile);
      CommonPile.clear();
   }




}
