package csc439team7.blackjack;

import java.util.*;

public class shoe {
    private int numDecks;
    private ArrayList<deck> shoe = new java.util.ArrayList<>();


    public shoe(int numDecks)
    {
        this.numDecks = numDecks;
        if(numDecks < 1) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numDecks; i++) {
            deck deck = new deck();
            shoe.add(deck);
        }
    }

    /**
     * method to return the deck at a particular index in the shoe. checks to make sure its a valid position
     * @author joebr
     */
    public deck getDeck(int i) {
        if( i < 0 || i > shoe.size()-1) {
            throw new IllegalArgumentException();
        }
        return shoe.get(i);
    }

    /**
     * method to return the number of decks in the shoe
     * @author joebr
     */
    public int numDecks() { //number of decks
        return numDecks;
    }

    public card pick()
    {

        int randomdeck = (int)(Math.random()*shoe.size()); //picks deck
        deck mydeck = getDeck(randomdeck);
        card pickedcard = mydeck.pick();
        if(mydeck.size() == 0) {
            shoe.remove(randomdeck); //removes the deck if it is empty
        }

        return pickedcard;
    }




}
