package csc439team7;

/**
 * Class used to create a card object
 * @author Jackson Cody
 * @version 1.0
 */
public class card {

    /**
     * Number and suit variables for a card
     */
    private int number;
    private int suit;

    /**
     * @param suit suit of the card
     * @param numb number of the card
     */
    public card (int suit, int numb){
        this.number=numb;
        this.suit=suit;
    }

    /**
     * @return number of the card object
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets the number of the card
     * @param number number of the card
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * returns the name of the card if it is a face card
     * @param numb number of the card object
     */
    public void getCardName(int numb){

    }

    /**
     * @return suit of the card object
     */
    public int getSuit() {
        return suit;
    }

    /**
     * @param suit suit of the card
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    /**
     * returns the name of the suit of the card
     * @param suit suit of the card
     */
    public void getSuitName(int suit){

    }


}
