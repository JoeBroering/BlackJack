package csc439team7.blackjack;
import java.util.logging.Logger;
import java.util.*;

/**
 * deck class which has a private arraylist for the cards in the deck, has methods for picking a card randomly, the size of the deck, and getting a card at index i
 * @author joebr
 */
class deck {
    private static final Logger logger = Logger.getLogger(deck.class.getName());
    private ArrayList<card> deck = new ArrayList<>();

    /**
     * constructor for a deck. runs through a nested for loop to create cards for all 4 suits, and the cards are added to the deck
     * @author joebr
     */
    public deck() {
        logger.entering(getClass().getName(), "deck");
        for (int j = 0; j < 4; j++) { //suit 0-3
            for (int k = 1; k < 14; k++) { //number
                card card = new card(j,k);
                deck.add(card);
            }
        }
        logger.info("deck constructed");
        logger.exiting(getClass().getName(), "deck");
    }

    /**
     * pick method that returns a random card from the deck. needs to be removed after being selected
     * @author joebr
     */
    public card pick() {
        logger.entering(getClass().getName(), "pick");
        if (deck.isEmpty()) {
            logger.info("Deck is empty");
            logger.exiting(getClass().getName(), "pick");
            throw new NoSuchElementException();
        } else
        {
           int random = (int)(Math.random()*deck.size());
           card picked = getCard(random);
           deck.remove(random);
           logger.info("Card has been removed from the deck");
           logger.exiting(getClass().getName(), "pick");
           return picked;
        }
    }

    /**
     * get method for the deck that returns the card at index i
     * @author joebr
     */
    public card getCard(int i) {
        logger.entering(getClass().getName(), "getCard");
        if( i < 0 || i > deck.size()-1) {
            logger.info("Illegal index to get card from deck");
            logger.exiting(getClass().getName(), "getCard");
            throw new IllegalArgumentException();
        }
        logger.info("Card obtained at index");
        logger.exiting(getClass().getName(), "getCard");
        return deck.get(i);
    }


    /**
     * returns the size of the deck by calling the deck's size method
     * @author joebr
     */
    public int size() {
        logger.entering(getClass().getName(), "size");
        logger.info("size of deck obtained");
        logger.exiting(getClass().getName(), "size");
        return deck.size();
    }



}
