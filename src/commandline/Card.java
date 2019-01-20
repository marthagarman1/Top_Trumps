import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Card{

    private String name, cat1, cat2, cat3, cat4, cat5;
    private int[] attributes;
    private ArrayList<Card> deck;
    private Random random;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }

    public Card(String name, int[] attributes){
        this.name=name;
        this.attributes=attributes;
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
        String name="";
        String line;
        int[] attributes = new int[5];

        while((line = reader.readLine()) != null){
            Card card  = new Card(name, attributes);
            Scanner scanner = new Scanner(line);
            //scanner.useDelimiter(",");
            while(scanner.hasNextInt()) {
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = Integer.parseInt(scanner.next());
                }
            }


            for(int i =0; i<attributes.length; i++){
                System.out.println(attributes[i]);
            }
        }

    }

    //draws a random card from the player's deck
    public Card drawCard(ArrayList<Card> deck){
        int index = random.nextInt(deck.size());
        Card drawn = deck.get(index);
        return drawn;
    }

    //can print out card's information including name and stats
    public String toString(){
        return "You drew '" + this.name +"'\n" + cat1 +": "+ attributes[0]+"\n"+
        cat2 +": "+ attributes[1] +"\n"+cat3 + ": " + attributes[2] + "\n" + cat4+
        ": "+ attributes[3]+"\n"+ cat5 + ": " + attributes[4];
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

    public ArrayList<Card> divideCards(ArrayList<Card> MainDeck){
        int numCards = MainDeck.size();
        int cardsEach = numCards/5;
        int forCommon = numCards%5;
        ArrayList<Card> playerDeck=new ArrayList<Card>();
        

        return playerDeck;
    }


}
