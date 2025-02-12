import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The Play class represents the main game logic for handling player actions,
 * card drawing, discarding, and determining the winner.
 */
public class Play {
    private final Player players;
    private final Deck deck;

    /**
     * Constructor for Play class with the given players and deck.
     *
     * @param players the Player object representing the players in the game
     * @param deck    the Deck object representing the deck of cards
     */
    public Play(Player players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    /**
     * This method starts the game and handles the game loop where players draw,
     * discard, and check for a winner. Additionally, it checks if the deck is empty,
     * and if so, shuffles the discarded cards from the last player and makes it the
     * new deck.
     *
     * @param input user input
     */
    public void start(final InputScanner input) {

        int numPlayers = players.getNumPlayers();
        boolean keepGoing = true;
        List<String> discardedDeck = new LinkedList<>();
        List<String> cards = deck.getDeckList();
        List<String> previousDiscards = new ArrayList<>();

        while (keepGoing) {
            for (int i = 0; i < numPlayers; i++) {

                Card hand = players.getHands().get(i);
                List<String> handList = new ArrayList<>(hand.getCards());

                if (i == 0) {
                    for (int draw = 0; draw < Main.numDrawn; draw++) {
                        if (cards.isEmpty()) {
                            System.out.println("Out of cards, resetting with discard pile");
                            deck.shuffle(discardedDeck);

                            Collections.reverse(discardedDeck);
                            cards = new LinkedList<>(discardedDeck);
                            discardedDeck.clear();
                        }
                        handList.add(deck.drawOneCard(cards));
                    }
                } else {
                    handList.addAll(previousDiscards);
                }

                previousDiscards.clear();

                for (int d = 0; d < Main.numDrawn; d++) {
                    System.out.println("Player " + i + ":\n" + displayHand(handList));
                    String indexString = "";
                    for (int a = 0; a < handList.size(); a++) {
                        indexString += a + " ";
                    }
                    System.out.println(indexString + "\nSelect index of card " + (d + 1) + " to discard:");

                    int discardIndex = -1;
                    boolean validIndex = false;
                    while (!validIndex) {
                        discardIndex = input.nextIntLine();
                        if (discardIndex >= 0 && discardIndex < handList.size()) {
                            validIndex = true;
                        } else {
                            System.out.println(discardIndex + " is out of range, please try again.");
                        }
                    }

                    previousDiscards.add(handList.remove(discardIndex));

                    if (cards.isEmpty()) {
                        deck.shuffle(discardedDeck);
                        cards = new LinkedList<>(discardedDeck);
                        discardedDeck.clear();
                    }
                }

                players.getHands().set(i, new Card(new ArrayList<>(handList)));

                if (isWinning(handList, Main.matchSize)) {
                    System.out.println("Congratulations player " + i + ", you won the game!");
                    keepGoing = false;
                    break;
                }
            }
            discardedDeck.addAll(previousDiscards);
        }
    }

    private String displayHand(List<String> handList) {
        String returnStr = "";
        for (String card : handList) {
            returnStr += card + " ";
        }
        return returnStr;
    }

    private boolean isWinning(List<String> hand, int matchSize) {

        int size = hand.size();

        for (int i = 0; i < size; i++) {
            int count = 1;
            for (int j = i + 1; j < size; j++) {
                if (hand.get(i).equals(hand.get(j))) {
                    count++;
                }
            }
            if (count >= matchSize) {
                return true;
            }
        }
        return false;
    }


}
