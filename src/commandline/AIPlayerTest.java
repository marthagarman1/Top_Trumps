package commandline;
import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {

	private String name = "test";
	private ArrayList<Card> deck = new ArrayList<>();
	private AIPlayer aip;

    @BeforeEach
    void setUp() throws Exception {
    	aip = new AIPlayer(this.deck, this.name);

    }

    @Test
    void getDeckTest() {
    	assertEquals(deck, aip.getDeck(),"Should return same deck");

    }

    @Test
    void printDeck() {
    }

    @Test
    void setPlayerNumber() {
    }


    @Test
    void drawTopCard() {
    	String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        deck.add(e);
    	Card drawn = deck.get(0);
    	assertEquals(drawn, aip.drawTopCard(), "Should draw top card from deck");

    }

    @Test
    void roundsWonTest() {
    	aip.hasWon();
    	aip.hasWon();
    	assertEquals(2, aip.getRoundsWon(), "Should have added 2 rounds won to roundsWon counter");
    }



    @Test
    void numOfCards() {
        ArrayList<Card> botDeck = new ArrayList<>();
        String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        botDeck.add(e);
        AIPlayer bot_player = new AIPlayer(botDeck, "Bot Player");
        assertEquals(bot_player.numOfCards(), 1);
    }

    @Test
    void getNameTest() {
    	assertEquals("test", aip.getName(), "Should return name defined");
    }

    @Test
    void removeCard() {
    	String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        deck.add(e);
        
    }

    @Test
    void addCards() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void selectCard() {
    }
}