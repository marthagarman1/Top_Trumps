package commandline;
import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {

	private String name = "test";
	private ArrayList<Card> deck = new ArrayList<>();
<<<<<<< HEAD
=======
	private ArrayList<Card> common = new ArrayList<>();
>>>>>>> branch 'master' of https://github.com/marthagarman1/sdjflwakejrwoeiunweorn
	private AIPlayer aip;

    @BeforeEach
    void setUp() throws Exception {
<<<<<<< HEAD
=======
    	File file = new File("StarCitizenDeck.txt");
    	ImportDeckInformation deckinfo = new ImportDeckInformation(file);
    	deck = deckinfo.getDeck();
    	common.addAll(deck.subList(0, 20));
>>>>>>> branch 'master' of https://github.com/marthagarman1/sdjflwakejrwoeiunweorn
    	aip = new AIPlayer(this.deck, this.name);

    }

    @Test
    void getDeckTest() {
    	assertEquals(deck, aip.getDeck(),"Should return same deck");

    }

    
    @Test
    void drawTopCard() {
<<<<<<< HEAD
    	String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        deck.add(e);
=======
>>>>>>> branch 'master' of https://github.com/marthagarman1/sdjflwakejrwoeiunweorn
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
<<<<<<< HEAD
    	assertEquals("test", aip.getName(), "Should return name defined");
=======
    	assertEquals("test", aip.getName(), "Should return name previously defined");
>>>>>>> branch 'master' of https://github.com/marthagarman1/sdjflwakejrwoeiunweorn
    }

    @Test
<<<<<<< HEAD
    void removeCard() {
    	String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        deck.add(e);
=======
    void removeCardTest() {
        aip.removeCard(0); 
        assertEquals(39, aip.numOfCards(), "Should return one less card (40-1=39)");
>>>>>>> branch 'master' of https://github.com/marthagarman1/sdjflwakejrwoeiunweorn
        
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
    
}
