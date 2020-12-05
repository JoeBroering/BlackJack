package csc439team7.blackjack;
import java.util.*;
import java.util.logging.Logger;

/**
 * The hand class is an ArrayList that is made up of cards. Has methods to add cards, return cards to the deck, find the size of the hand.
 * @version 1.1
 * @author Bradley Brown
 */
class hand {
    private static final Logger logger = Logger.getLogger(hand.class.getName());
    private ArrayList<card> hand = new ArrayList<>();

    /**
     * Default hand constructor.
     * @version 1.1
     * @author Bradley Brown
     */
    public hand(){ }

    /**
     * Adds a card to the hand
     * @version 1.1
     * @param card
     * @author Bradley Brown
     */
    public void addCard(card card){
        logger.entering(getClass().getName(), "addCard");
        hand.add(card);
        logger.info("Card added to hand");
        logger.exiting(getClass().getName(), "addCard");
    }

    /**
     * Returns cards to the deck, and removes the cards from the hand
     * @version 1.1
     * @author Bradley Brown
     */
    public ArrayList<card> getCards(){
        logger.entering(getClass().getName(), "getCards");
        ArrayList<card> cards = hand;
        for (int i = 0; i < hand.size(); i++) {
           hand.remove(i);
        }
        logger.info("cards removed from hand");
        logger.exiting(getClass().getName(), "getCards");
        return cards;
    }

    /**
     * method for printing out the cards in the hand without removal for printing for the user.
     * @version 1.1
     * @author joebr
     */
    public ArrayList<card> listCards() {
        logger.entering(getClass().getName(), "listCards");
        ArrayList<card> cards = hand;
        logger.info("cards available to print");
        logger.exiting(getClass().getName(), "listCards");
        return cards;
    }

    /**
     * Returns hand size.
     * @version 1.1
     * @author Bradley Brown
     */
    public int size(){
        logger.entering(getClass().getName(), "size");
        logger.info("size of hand obtained");
        logger.exiting(getClass().getName(), "size");
        return hand.size();
    }
}

