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
        assertEquals(playerType.ai, TopTrumpsCLIApplication.)
    }

    @Test
    void markAsWinners() {
    }

    @Test
    void savePlayers() {
    }
}