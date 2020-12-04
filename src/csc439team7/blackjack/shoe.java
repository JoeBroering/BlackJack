package csc439team7.blackjack;
import java.util.logging.Logger;
import java.util.*;


/**
 * shoe class which has a constructor which takes in the number of desired decks in the shoe. Has a getdeck method which returns the deck at index i in the shoe, numdecks which returns the size, and a pick method which also removes a deck from the shoe when it is emptied
 * @author joebr
 */
class shoe {
    private static final Logger logger = Logger.getLogger(shoe.class.getName());
    private int numDecks;
    private ArrayList<deck> shoe = new java.util.ArrayList<>();

    /**
     * constructor for shoe which takes in the number of decks in the shoe as an integer. checks to make sure at least 1 deck in the shoe, then creates the shoe using deck objects
     * @author joebr
     */
    public shoe(int numDecks) {
        logger.entering(getClass().getName(), "shoe");
        this.numDecks = numDecks;
        if(numDecks < 1) {
            logger.info("no decks in the shoe");
            logger.exiting(getClass().getName(), "shoe");
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < numDecks; i++) {
            deck deck = new deck();
            shoe.add(deck);
        }
        logger.info("Decks added to shoe");
        logger.exiting(getClass().getName(), "shoe");
    }

    /**
     * method to return the deck at a particular index in the shoe. checks to make sure its a valid position
     * @author joebr
     */
    public deck getDeck(int i) {
        logger.entering(getClass().getName(), "getDeck");
        if( i < 0 || i > shoe.size()-1) {
            logger.info("Invalid index in shoe");
            logger.exiting(getClass().getName(), "getDeck");
            throw new IllegalArgumentException();
        }
        logger.info("returns deck to shoe");
        return shoe.get(i);
    }

    /**
     * method to return the number of decks in the shoe
     * @author joebr
     */
    public int numDecks() { //number of decks
        return shoe.size();
    }

    /**
     * pick method for the shoe. calculates a random deck from the shoe to draw from, then selects a card randomly from that deck. if the deck is emptied after that selection, that deck is removed from the shoe.
     * @author joebr
     */
    public card pick() {
        logger.entering(getClass().getName(), "pick");
        if (shoe.size() == 0) {
            logger.info("no decks in shoe");
            logger.exiting(getClass().getName(), "pick");
            throw new NoSuchElementException();
        }

        int randomdeck = (int)(Math.random()*shoe.size()); //picks deck
        deck mydeck = getDeck(randomdeck);
        card pickedcard = mydeck.pick();
        if(mydeck.size() == 0) {
            shoe.remove(randomdeck); //removes the deck if it is empty
            logger.info("deck removed from shoe");
        }
        logger.info("card picked from deck");
        logger.exiting(getClass().getName(), "pick");
        return pickedcard;
    }




}
