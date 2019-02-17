package commandline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TopTrumpsCLIApplicationTest {

    AIPlayer aip;
    String name = "test";
    private ArrayList<Card> deck = new ArrayList<>();


    @BeforeEach
    void setUp() throws Exception {
        TopTrumpsCLIApplication game = new TopTrumpsCLIApplication();
       aip = new AIPlayer(deck, name);
    }

    @Test
    void saveGameResults() {
    }

//    @Test
//    void getTypeTest() {
//        assertEquals(PlayerType.ai, TopTrumpsCLIApplication.getType(aip), "Should be equal, returning type AI")
//    }

    @Test
    void markAsWinnersTest() {
        HumanPlayer hp = new HumanPlayer(deck, name);
        Collection<Player> players = Arrays.asList(hp, aip);
        TopTrumpsCLIApplication.markAsWinners(players);
        assertTrue(hp.roundsWon == 1 && aip.roundsWon == 1, "Both players should now have one round won");

    }

//    @Test
//    void savePlayers() {
//    }
}