package csc439team7.blackjack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class shoe {
    private int numDecks;
    private ArrayList<shoe> shoe = new java.util.ArrayList<>();


    public shoe(int numDecks)
    {
        this.numDecks = numDecks;
        for(int i = 0; i < numDecks; i++) {
            deck deck = new deck();
        }


    }

    public deck getDeck() {
    
    }

    public card pick()
    {
        if(shoe.isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = (int)(Math.random()*shoe.size());

    }


}
