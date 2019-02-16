package commandline;
import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {

    private String name;
    private ArrayList<Card> deck = new ArrayList<Card>;
    private AIPlayer aip;



    @BeforeEach
    void setUp() throws Exception {
        aip = new AIPlayer(this.deck, this.name);

    }

    @Test
    void getDeckTest() {
        assertEquals(deck, aip.getDeck(), "Should return same deck");
    }

    @Test
    void printDeckTest() {

    }

    @Test
    void setPlayerNumberTest() {
    }


    @Test
    void drawTopCardTest() {
        Card drawn = deck.get(0);
        assertEquals(drawn, aip.drawTopCard());

    }

    @Test
    void hasWon() {
    }

    @Test
    void getRoundsWon() {

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
    void getName() {

    }

    @Test
    void removeCard() {
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