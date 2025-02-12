import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a deck of cards used in the game.
 */
public class Deck {
    private final List<String> cards = List.of("!", "@", "#", "$", "%", "^", "&", "*");
    private final List<String> deckList;

    /**
     * Constructor for Deck class.
     * If in grader mode, the deck size is determined by user input.
     * Otherwise, the deck is created with three copies of each character provided.
     *
     * @param input user input
     */
    public Deck(final InputScanner input) {

        final List<String> deck = new LinkedList<>();


            for (String card : cards) {
                for (int i = 0; i < Main.matchSize; i++) {
                    deck.add(card);
                }
            }

        this.deckList = deck;
    }

    /**
     * Getter for the list representing the deck of cards.
     *
     * @return a list of strings representing the cards in the deck
     */
    public List<String> getDeckList() {
        return deckList;
    }

    /**
     * This method shuffles the given list of cards.
     *
     * @param cards the list of cards to shuffle
     */
    public void shuffle(List<String> cards) {
        Collections.shuffle(cards);
    }

    /**
     * This method draws and removes the first card from the deck.
     * @param cards the list of cards to draw from
     * @return the drawn card
     */
    public String drawOneCard(List<String> cards) {
        return cards.removeFirst();
    }




}
