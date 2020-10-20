package csc439team7.blackjack;

import java.util.*;

/**
 * deck class which has a private arraylist for the cards in the deck
 * @author joebr
 */
class deck {
    private ArrayList<card> deck = new ArrayList<>();

    public deck() {

        for (int j = 0; j < 4; j++) { //suit 0-3
            for (int k = 1; k < 14; k++) { //number
                card card = new card(j,k);
                deck.add(card);
            }
        }
    }

    /**
     * pick method that returns a random card from the deck. needs to be removed after being selected
     * @author joebr
     */
    public card pick() {
        if (deck.isEmpty()) {
            throw new NoSuchElementException();
        } else
        {
           int random = (int)(Math.random()*deck.size());
           card picked = getCard(random);
           deck.remove(random);
           return picked;
        }
    }

    /**
     * get method for the deck that returns the card at index i
     * @author joebr
     */
    public card getCard(int i) {
        if( i < 0 || i > deck.size()-1) {
            throw new IllegalArgumentException();
        }
        return deck.get(i);
    }


    /**
     * returns the size of the deck by calling the deck's size method
     * @author joebr
     */
    public int size() {
        return deck.size();
    }



}
