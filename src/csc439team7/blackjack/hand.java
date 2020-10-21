package csc439team7.blackjack;
import java.util.*;

/**
 * The hand class is an ArrayList that is made up of cards. Has methods to add cards, return cards to the deck, find the size of the hand.
 * @version 1.0
 * @author Bradley Brown
 */
class hand {
    private ArrayList<card> hand = new ArrayList<>();

    /**
     * Default hand constructor.
     * @version 1.0
     * @author Bradley Brown
     */
    public hand(){ }

    /**
     * Adds a card to the hand
     * @version 1.0
     * @param card
     * @author Bradley Brown
     */
    public void addCard(card card){
        hand.add(card);
    }

    /**
     * Returns cards to the deck, and removes the cards from the hand
     * @version 1.0
     * @author Bradley Brown
     */
    public ArrayList<card> getCards(){
        ArrayList<card> cards = hand;
        for (int i = 0; i < hand.size(); i++) {
            hand.remove(i);
        }
        return cards;
    }

    /**
     * Returns hand size.
     * @version 1.0
     * @author Bradley Brown
     */
    public int size(){
        return hand.size();
    }
}

