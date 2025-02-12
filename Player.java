import java.util.ArrayList;
import java.util.List;

/**
 * The Player class represents a player in the game. It also includes the player's hand of cards.
 * It manages the distribution of cards to each player from the deck.
 */
public class Player {

    private final int numPlayers;
    private final List<Card> hands;
    private final Deck deck;

    /**
     * Constructor for Player class. It shuffles the cards (in normal mode only),
     * and calls method to distribute them to each player
     *
     * @param numPlayers the number of players in the game
     * @param deck       the Deck object representing the deck of cards
     */
    public Player(int numPlayers, final Deck deck) {

        this.numPlayers = numPlayers;
        this.deck = deck;
        this.hands = new ArrayList<>(numPlayers);
        deck.shuffle(deck.getDeckList());
        distributeCards();

    }

    /**
     * Getter for the list of hands for each player.
     *
     * @return a list of Card objects representing the players' hands
     */
    public List<Card> getHands() {
        return hands;
    }

    /**
     * Getter for the number of players.
     *
     * @return number of players
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * This method distributes cards from the deck to each player round-robin style,
     * giving each player the handSize number of cards.
     */
    public void distributeCards() {

        List<List<String>> playerCards = new ArrayList<>(numPlayers);

        for (int i = 0; i < numPlayers; i++) {
            playerCards.add(new ArrayList<>());
        }

        List<String> deckList = deck.getDeckList();

        for (int cardIndex = 0; cardIndex < Main.handSize; cardIndex++) {
            for (int playerIndex = 0; playerIndex < numPlayers; playerIndex++) {
                playerCards.get(playerIndex).add(deck.drawOneCard(deckList));
            }
        }

        for (int playerIndex = 0; playerIndex < numPlayers; playerIndex++) {
            hands.add(new Card(playerCards.get(playerIndex)));
        }
    }

}
