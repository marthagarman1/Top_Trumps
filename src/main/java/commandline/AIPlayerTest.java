package commandline;
import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {

    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void getDeck() {

    }

    @Test
    void printDeck() {
    }

    @Test
    void setPlayerNumber() {
    }

    @Test
    void getNumberCards() throws Exception {
        ArrayList<Card> botDeck = new ArrayList<>();
        String[] aNames = new String[]{"speed"};
        ArrayList<Integer> attribures = new ArrayList<>();
        attribures.add(3);
        Card e = new Card("Test", aNames, attribures);
        botDeck.add(e);
        AIPlayer bot_player = new AIPlayer(botDeck, "Bot Player");
        assertEquals(bot_player.getNumberCards(), 1);
    }

    @Test
    void drawTopCard() {

    }

    @Test
    void hasWon() {
    }

    @Test
    void getRoundsWon() {
    }

    @Test
    void numOfCards() {
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