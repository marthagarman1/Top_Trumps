package commandline;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class ImportDeckInformation{

   private ArrayList<Integer> attributes;
   private String[] attributeNames;
   private ArrayList<Card> deck;
  
  /** 
   * Constructor 
   * 
   */ 
   public ImportDeckInformation(File file) throws IOException{
      makeDeck(file); 
   }
   
  //reads input text file and creates deck (arraylist of card objects)
   public void makeDeck(File file)throws NumberFormatException, IOException {
      BufferedReader reader=null;
      try {
         reader = new BufferedReader(new FileReader(
                file));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      this.attributeNames= new String[5];
      attributeNames = makeArray(reader.readLine());
      
      String line;
      deck=new ArrayList<>();
      while((line = reader.readLine()) != null){
         String[] lineArray = makeArray(line);
         String name=lineArray[0];
         attributes=new ArrayList<Integer>();
      
         for (int i = 1; i <lineArray.length; i++) {
            attributes.add(Integer.parseInt(lineArray[i]));
         }
         deck.add(new Card(name, attributeNames, attributes));
      }
      reader.close();
      
      
   }
   
   //method to return the ArrayList<Card> 
   public ArrayList<Card> getDeck() {
      Collections.shuffle(this.deck);
      return deck; 
   }
   
   //method to shuffle deck ---REMOVE LATER IF NOT CALLED
   public ArrayList<Card> shuffleDeck(ArrayList<Card> deck) {
      Collections.shuffle(deck);
      return deck; 
   }
   
   //method to turn a line of text into an array
   public String[] makeArray(String line){
      String[] result = line.split(" ");
      return result;
   } 
   
     //  //Divides arraylist of cards  
   // public ArrayList<Card> divideCards(ArrayList<Card> MainDeck){
      // int numCards = MainDeck.size();
      // int cardsEach = numCards/5;
      // int forCommon = numCards%5;
      // ArrayList<Card> playerDeck=new ArrayList<Card>();
      // for(int i = 0; i < numCards; i++) {
      //    
      // }
      // return playerDeck;
   // }
}

