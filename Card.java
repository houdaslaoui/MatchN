import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cards in a players hand.
 */
public class Card {

    private final List<String> cards;

    /**
     * Constructor for Card class that stores the card values in a list
     *
     * @param cards list of cards
     */
    public Card(List<String> cards) {
        this.cards = new ArrayList<>(cards);
    }

    /**
     * Getter for list of cards.
     *
     * @return the list of cards
     */
    public List<String> getCards() {
        return cards;
    }

}
