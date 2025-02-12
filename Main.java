import java.util.Scanner;

/**
 * This is the main class that initializes the MATCH N game and input system.
 * Each round consists of the first player drawing a card from the deck, choosing
 * which card or cards they want to pass to the next player. The next player then
 * makes the same decision and so on until the last player. The last player then
 * discards (into a discard pile). This process is repeated until someone gets N
 * matches in their hand. If the deck is exhausted before this happens then the
 * discard pile is shuffled and becomes the deck.
 */
public class Main {

    /**
     * Number of players
     */
    public static int numPlayers;

    /**
     * Number of cards that make a match
     */
    public static int matchSize;

    /**
     * Number of cards in a hand
     */
    public static int handSize;

    /**
     * Number of cards drawn each round
     */
    public static int numDrawn;

    /**
     * String representation of whether grader mode is on or off
     */
//    public static String graderMode;


    /**
     * The main method that calls all other classes. It reads the number of players
     * and the cards. It then starts the game.
     *
     * @param args
     */
    public static void main(String[] args) {

        final InputScanner input = new InputScanner(new Scanner(System.in));

        do {
            System.out.println("Enter the number of players ([2..]): ");
            numPlayers = input.nextIntLine();
        } while (numPlayers < 2);

        do {
            System.out.println("Enter the match size ([2..]): ");
            matchSize = input.nextIntLine();
        } while (matchSize < 2);

        do {
            System.out.println("Enter the hand size ([match size..]): ");
            handSize = input.nextIntLine();
        } while (handSize < matchSize);

        do {
            System.out.println("Enter the number of cards to be drawn ([1..]): ");
            numDrawn = input.nextIntLine();
        } while (numDrawn < 1);


        Deck deck = new Deck(input);

        Player player = new Player(numPlayers, deck);
        Play play = new Play(player, deck);

        System.out.println("Welcome to MATCH N!");

        play.start(input);

    }

}