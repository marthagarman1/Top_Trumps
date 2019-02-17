package commandline;

import db.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Top Trumps command line application.
 *
 * @version 3/2/2019
 */
public class TopTrumpsCLIApplication {
    public static String url = "jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/";
    private static String user = "m_18_2094641c";
    private static String password = "2094641c";

    //public static String url = "jdbc:postgresql://manny.db.elephantsql.com:5432/onkrajux";
    //public static String user = "onkrajux";
    //public static String password = "toc8a9gWmmZO41dnETiNFS6Ju98QGKzq";

    private static PlayerRepository playerRepository;
    private static GameResultRepository gameRepository;
    private static DbDriver driver;

    static {
        try {
            driver = new DbDriver(user, password, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        playerRepository = new PlayerRepository(driver);
        gameRepository = new GameResultRepository(driver);
    }


    /**
     * This main method is called by TopTrumps.java when the user specifies that they want to run in
     * command line mode. The contents of args[0] is whether we should write game logs to a file.
     *
     * @param args used for user choices (writing logs)
     * @throws IOException in Database connection.
     */
    public static void main(String[] args) throws Exception {
        //Test Log is launched from here :
        boolean writeGameLogsToFile = true; // Should we write game logs to file?

        //if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile = true; // Command line selection

        // flag to check whether the user wants to quit the application
        boolean userWantsToQuit = false;


        /* Game Loop until the user wants to exit the game */
        while (!userWantsToQuit) {
            // Declare Variables used in Game Loop
            /* ArrayList of cards that will be dealt into player's hands. */
            ArrayList<Card> deck;
            /* Counts which round game is currently on. */
            int roundCount = 1;
            /* ArrayList that will be printed to log. */
            ArrayList<String> fileOutput = new ArrayList<>();
            /* Used to write fileOutput to toptrumps.log */
            PrintWriter writer = new PrintWriter("toptrumps.log", "UTF-8");
            /* Scanner for user Input in Game Loop. */
            Scanner scan = new Scanner(System.in);
            /* Keeps track of current player, after first round represents current Winner. */
            String activePlayer = "";
            int nextPlayer = 0;
            /* Cards added to ArrayList after Draw. */
            ArrayList<Card> commonPile = new ArrayList<>();
            /* Sets player name. */
            final String playerName = "You";

            /* Start the Game */
            System.out.println("Game Start");
            // 1. Read in file and load information for cards
            File file = new File("StarCitizenDeck.txt");
            ImportDeckInformation fi = new ImportDeckInformation(file);
            fileOutput.add("NEW GAME \nContents of new deck:"
                    + fi.getDeck().toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");

            // 2. Return a shuffled Deck
            deck = fi.getShuffledDeck();
            fileOutput.add("\nShuffled Deck: "
                    + deck.toString().replace("[", "")
                    .replace("]", "")
                    + "\n--------------------\n");


            // 3. Create Players and divide deck between players
            ArrayList<Card> playerDeck = new ArrayList<>(deck.subList(0, 8));
            // TODO ask for name via input

            HumanPlayer user = new HumanPlayer(playerDeck, playerName); // PLAYER YOU
            fileOutput.add("\n" + user.getName() + "r Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(8, 16)); //16
            AIPlayer bot1 = new AIPlayer(playerDeck, "AI Player 1");
            fileOutput.add("\n" + bot1.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(16, 24)); //24
            AIPlayer bot2 = new AIPlayer(playerDeck, "AI Player 2");
            fileOutput.add("\n" + bot2.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(24, 32)); //32
            AIPlayer bot3 = new AIPlayer(playerDeck, "AI Player 3");
            fileOutput.add("\n" + bot3.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            playerDeck = new ArrayList<>(deck.subList(32, 40));
            AIPlayer bot4 = new AIPlayer(playerDeck, "AI Player 4");
            fileOutput.add("\n" + bot4.getName() + "'s Deck:" + playerDeck.toString()
                    + "\n--------------------\n");

            // 4. Start new game by adding players and their decks to game.
            ArrayList<Player> playerList = new ArrayList<>();
            ArrayList<Player> losers = new ArrayList<>();
            playerList.add(user);
            playerList.add(bot1);
            playerList.add(bot2);
            playerList.add(bot3);
            playerList.add(bot4);


            //savePlayers(playerList);
            boolean newGame = false;
            while (!newGame) {
                //Start New Round
                //Randomly selects first player during first round.
                if (roundCount == 1) {
                    Collections.shuffle(playerList);
                    activePlayer = playerList.get(0).getName();

                }

                System.out.println("---------------- ROUND " + roundCount + " ----------------");
                //get all drawn cards from players and make an arraylist of cards
                ArrayList<Card> drawPile = new ArrayList<>();
                for (Player player1 : playerList) {
                    drawPile.add(player1.drawTopCard());
                }
                fileOutput.add("\nCards in play this round:" + drawPile.toString()
                        + "\n--------------------");

                System.out.println("Round " + roundCount
                        + ": Players have drawn their cards");
                if (user.numOfCards() != 0) {
                    System.out.println("You drew: " + user.drawTopCard());
                    System.out.println("There are '" + user.numOfCards()
                            + " cards in your deck");
                }
                /* User's selected category represented by int. */
                int userCatChoice = 0;
                boolean repeat = false;
                do {
                    //If the active player is Human, they can select a category.
                    if (activePlayer.equalsIgnoreCase(playerName)) {
                        System.out.print("\nIt is your turn to select a category, "
                                + "the categories are: "
                                + "\n\t1: " + (deck.get(0).getANames())[1]
                                + "\n\t2: " + (deck.get(0).getANames())[2]
                                + "\n\t3: " + (deck.get(0).getANames())[3]
                                + "\n\t4: " + (deck.get(0).getANames())[4]
                                + "\n\t5: " + (deck.get(0).getANames())[5]
                                + "\nEnter the number for your attribute: ");
                        try {
                            userCatChoice = scan.nextInt();
                            repeat = false;
                            if (userCatChoice < 1 || userCatChoice > 5) {
                                System.out.print("\nPlease enter a valid number between 1 - 5\n");
                                repeat = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("\nInvalid Input, please enter a valid number.\n");
                            repeat = true;
                        }
                        //If the active player is a bot, they will randomly select a category.
                    } else {
                        //Method for bots to choose category
                        //AIPlayer temp = bot1;
                        //userCatChoice = temp.pickCategory();
                        Random math = new Random();
                        userCatChoice = math.nextInt((5 - 1) + 1) + 1;
                    }
                } while (repeat);


                System.out.println("~ " + activePlayer + " " + "selected category "
                        + userCatChoice);
                fileOutput.add("\nCatergory selected: "
                        + (drawPile.get(0)).getAName(userCatChoice)
                        + "\nCorresponding Values: ");

                for (int i = 0; i < playerList.size(); i++) {
                    fileOutput.add("\n" + (playerList.get(i)).getName() + ": "
                            + drawPile.get(i).getStats(userCatChoice));
                }
                fileOutput.add("\n--------------------");

                //Compare all cards in chosen category
                int currentWinner = 0;

                boolean draw = false;
                for (int i = 0; i < playerList.size() - 1; i++) {

                    if (drawPile.get(currentWinner).getStats(userCatChoice)
                            < drawPile.get(i + 1).getStats(userCatChoice)) {
                        currentWinner = i + 1;

                        draw = false;
                    } else if (drawPile.get(currentWinner).getStats(userCatChoice)
                            == drawPile.get(i + 1).getStats(userCatChoice)) {
                        draw = true; //drawn

                    }
                }

                //return the winner --draw/win
                if (draw) {
                    commonPile.addAll(drawPile);
                    System.out.println("Round " + roundCount + ": "
                            + "This round was a Draw, common pile now has "
                            + commonPile.size() + " cards");
                    fileOutput.add("\nCards added to Common Pile: " + commonPile.toString()
                            + "\n--------------------");
                    drawPile.clear();
                } else {
                    System.out.println("~~~~ Round " + roundCount + ": "
                            + " Player " + playerList.get(currentWinner).getName()
                            + " won this round. ~~~~");


                    //if active player is the same as current winner, don't change the active player
                    if (!activePlayer.equalsIgnoreCase(playerList.get(currentWinner).getName())) {
                        //set next player, if at end of playerlist loop back
                        if (nextPlayer >= playerList.size() - 1) {
                            nextPlayer = 0;
                        } //otherwise move on to next player in list
                        else {
                            ++nextPlayer;
                        }
                        activePlayer = playerList.get(nextPlayer).getName();
                    }

                    //winner gets all of common pile cards and then remove all from drawPile
                    (playerList.get(currentWinner)).addCards(drawPile);
                    if (commonPile.size() > 0) {
                        (playerList.get(currentWinner)).addCards(commonPile);
                    }
                    //includes draws
                    (playerList.get(currentWinner)).hasWon();

                    if (commonPile.size() > 0 && !draw) {
                        fileOutput.add("\nCards removed from Common Pile: " + commonPile.toString()
                                + "\n--------------------");
                    }
                    commonPile.clear();

                    //print winning card with selected category with an arrow
                    System.out.print("\tThe winning card was ");
                    drawPile.clear();
                    //Prints with Arrow
                    System.out.println(playerList.get(currentWinner)
                            .drawTopCard().winnerToString(userCatChoice));

                }
                //Remove cards (simulate drawing cards)
                for (Player player : playerList) {
                    if (player.numOfCards() != 0) {
                        player.removeCard(0);
                    }
                }
                //Log each deck after Round
                for (Player player1 : playerList) {
                    fileOutput.add("\nAfter Round " + roundCount + "\n"
                            + player1.getName() + "'s Deck:"
                            + player1.getDeck().toString()
                            + "\n--------------------\n");
                }
                //End of round increase count
                roundCount++;

                //remove players from game who no longer have cards
                for (int i = 0; i < playerList.size(); i++) {
                    Player player = playerList.get(i);
                    if (player.numOfCards() == 0) {
                        playerList.remove(i);
                        losers.add(player);
                        i = 0;
                        markAsWinners(playerList);
                    }
                }

                System.out.println("There are " + playerList.size() + " players left and "
                        + user.numOfCards() + " cards in your hand.\n");

                //if only one player remains or there are
                // cards in the commonPile, a winner is selected:
                if (playerList.size() == 1) {

                    //saveGameResults(roundCount, playerList.get(0), losers);

                    //TODO save game result and participants in the database here (Using GameResultRepository)
                    System.out.println("\n~~~~Game End~~~~\n");
                    System.out.println("The overall winner is " + playerList.get(0).getName());
                    fileOutput.add("\nThe overall winner is " + playerList.get(0).getName());
                    PlayerRoundComparator pC = new PlayerRoundComparator();
                    Collections.sort(losers, pC);
                    System.out.println("Scores:\n"
                            + playerList.get(0).toString() //prints winner
                            + losers.get(0).toString() //prints last place...
                            + losers.get(1).toString()
                            + losers.get(2).toString()
                            + losers.get(3).toString());
                    boolean endLoop = false;
                    while (!endLoop) {
                        System.out.println("Do you want to see past results or play a game?"
                                + "\n\t1: Print Game Statistics"
                                + "\n\t2: Play New Game "
                                + "\n\t3: Quit Game "
                                + "\nEnter the number for your selection: ");
                        int choice = scan.nextInt();

                        if (choice == 2) //User wants to play new game
                        {
                            endLoop = true;
                            newGame = true;
                        } else if (choice == 1) //User wants to print Game Stats
                        {
                            System.out.println("Largest number of rounds: " + gameRepository.getLargestNumberOfRounds());
                            System.out.println("Number of draws: " + gameRepository.getNumberOfDraws());
                            System.out.println("AI wins: " + gameRepository.getWinsByPlayerType(PlayerType.ai));
                            System.out.println("Human wins: " + gameRepository.getWinsByPlayerType(PlayerType.human));
                            System.out.println("Total games: " + gameRepository.totalGames());

                        } else if (choice == 3) {
                            System.out.println("Thanks for Playing!");
                            endLoop = true;
                            newGame = true;
                            userWantsToQuit = true;
                        }
                    }
                }

            }

            if (writeGameLogsToFile) {
                //print all of string array at once
                writer.println(fileOutput.toString().replace("[", "")
                        .replace("]", "").replace(",", ""));
                writer.close();
            }
        }
    }

    static void saveGameResults(int roundCount, Player winner, Collection<Player> losers) throws Exception {
        Collection<ParticipantDb> participants = new ArrayList<>();
        // add winner
        PlayerDb winnerDb = new PlayerDb(winner.getId(), winner.getName(), getType(winner));
        participants.add(new ParticipantDb(winnerDb, winner.getRoundsWon()));

        for (Player loser : losers) {
            PlayerDb player = new PlayerDb(loser.getId(), loser.getName(), getType(loser));
            participants.add(new ParticipantDb(player, loser.getRoundsWon()));
        }
        GameResultDb result = new GameResultDb(winnerDb, roundCount, participants);
        gameRepository.save(result);
    }

    private static PlayerType getType(Player player) {

        if (player instanceof HumanPlayer) {
            return PlayerType.human;
        } else {
            return PlayerType.ai;
        }
    }

    public static void markAsWinners(Collection<Player> players) {
        for (Player player : players) {
            player.hasWon();
        }
    }

    static void savePlayers(Collection<Player> players) throws Exception {
        for (Player player : players) {
            PlayerType type = getType(player);
            PlayerDb db = new PlayerDb(player.name, type);
            PlayerDb saved = playerRepository.save(db);
            player.setId(saved.id);
        }
    }

    
}
