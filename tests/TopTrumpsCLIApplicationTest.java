package commandline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopTrumpsCLIApplicationTest {

    AIPlayer aip;
    String name = "test";
    private ArrayList<Card> deck = new ArrayList<>();


    @BeforeEach
    void setUp() throws Exception {
        TopTrumpsCLIApplication game = new TopTrumpsCLIApplication();
       aip = new Player(name, deck);
    }

    @Test
    void saveGameResults() {
    }

    @Test
    void getTypeTest() {
        assertEquals(playerType.ai, TopTrumpsCLIApplication.getType(aip), "Should be equal, returning type AI")
    }

    @Test
    void markAsWinnersTest() {
        HumanPlayer hp = new HumanPlayer(name, deck);
        Collection<Player> players = Arrays.asList(hp, aip);
        TopTrumpsCLIApplication.markAsWinners(players);
        assertTrue(hp.roundsWon == 1 && aip.roundsWon == 1, "Both players should now have one round won")

    }

    @Test
    void savePlayers() {
    }
}