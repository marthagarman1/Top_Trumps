package commandline;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AIPlayerTest {

	private String name = "test";
	private ArrayList<Card> deck = new ArrayList<>();
	private ArrayList<Card> common = new ArrayList<>();
	private AIPlayer aip;

    @BeforeEach
    void setUp() throws Exception {
    	File file = new File("StarCitizenDeck.txt");
    	ImportDeckInformation deckinfo = new ImportDeckInformation(file);
    	deck = deckinfo.getDeck();
    	common.addAll(deck.subList(0, 20));
    	aip = new AIPlayer(this.deck, this.name);

    }

    @Test
    void getDeckTest() {
    	assertEquals(deck, aip.getDeck(),"Should return same deck");

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
        assertEquals(40, aip.numOfCards(), "Should return the num of cards in deck which is 40");
    }

    @Test
    void getNameTest() {
    	assertEquals("test", aip.getName(), "Should return name defined");
    	assertEquals("test", aip.getName(), "Should return name previously defined");
    }

    @Test
    void removeCardTest() {
        aip.removeCard(0); 
        assertEquals(39, aip.numOfCards(), "Should return one less card (40-1=39)");
    }

    @Test
    void addCardsTest() {
        aip.addCards(common);
        assertEquals(60, aip.numOfCards(), "Should add decks from common pile to player's deck (40+20=60)");
    }

    @Test
    void getSetIdTest() {
    	aip.setId(5);
    	assertEquals(5, aip.getId(), "Should set player ID to 5 and return it as such");
    }


    @Test
    void selectCardTest() {
        assertTrue(aip.selectCard().contains("Firepower"), "If card is correctly selected and returning toString should contain attribute Firepower");
        
    }
    
    @Test
    void pickCategoryTest() {
    	assertTrue(aip.pickCategory()<=5 && aip.pickCategory()>=0, "Should return int between 0 and 5");
    }
    
}
