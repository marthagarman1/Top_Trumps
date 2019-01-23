import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Card{

    private String name;
    private String cat1;
    private String cat2;
    private String cat3;
    private String cat4;
    private ArrayList<Player> players; //arraylist of player objects represents game participants

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

    public Card(String name, ArrayList<Integer> attributes){
        this.name=name;
        this.attributes=attributes;
    }



    //reads input text file and creates deck (arraylist of card objects)
    public ArrayList<Card> makeDeck(File file)throws NumberFormatException, IOException {
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
                deck.add(new Card(name, attributes));


            }
            reader.close();
        return deck;

    }


    //method to set category names
    public void setCatNames(String[] names){
        setCat1(names[1]);
        setCat2(names[2]);
        setCat3(names[3]);
        setCat4(names[4]);
        setCat5(names[5]);
    }

    //method to turn a line of text into an array
    public String[] makeArray(String line){
        String[] result = line.split(" ");
        return result;
    }

    //draws a random card from the player's deck
    public Card drawCard(ArrayList<Card> deck){
        int index = random.nextInt(deck.size());
        Card drawn = deck.get(index);
        return drawn;
    }

    //can print out card's information including name and stats
    public String toString(){
        return "You drew '" + this.name +"'\n" + cat1 +": "+ attributes.get(0)+"\n"+
        cat2 +": "+ attributes.get(1) +"\n"+cat3 + ": " + attributes.get(2) + "\n" + cat4+
        ": "+ attributes.get(3)+"\n"+ cat5 + ": " + attributes.get(4)+"\n";
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

    //deals cards to players
    public void dealCards(){
        int numOfPlayers=5;
        for(int i=0;i<players.size();i++){
            players.get(i%numOfPlayers).addToDeck(deck.remove(0)); //methods to be written in player class
        }
    }

    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck){
        ArrayList<Card> shuffled = new ArrayList<>();
        while(deck.size()>0){
            int index = (int) Math.random()* deck.size();
            shuffled.add(deck.remove(index));
        }
        return shuffled;
    }


}
