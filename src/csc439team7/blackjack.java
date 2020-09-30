package csc439team7;

/**
 * testing 5:53
 * @version 1.0
 * @author joebr
 */

public class blackjack {

    /**
     * Class used to create a card object
     * @author Jackson Cody
     * @version 1.0
     */
    class card {

        /**
         * Number and suit variables for a card
         */
        private int number;
        private int suit;
        private String numberName;

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
        public String getCardName(int numb){
            return " ";
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
        public String getSuitName(int suit){
            return " ";
        }


    }
}
