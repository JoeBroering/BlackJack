package csc439team7.blackjack;

/**
     * Class used to create a card object
     * @author Jackson Cody, joebr
     * @version 1.1
     */
     class card {

        private int number;
        private int suit;

        /**
         * constructor for card that takes in a suit and a number and checks for illegal arguments
         * @version 1.1
         * @param suit suit of the card
         * @param number number of the card
         */
        public card (int suit, int number){
            if (number < 1 || number > 13) {
                throw new IllegalArgumentException();
            }
            if (suit < 0 || suit > 3) {
                throw new IllegalArgumentException();
            }
            this.number=number;
            this.suit=suit;
        }

        /**
         * gets the Number of the card, stays at 11,12,13,14 for face cards. does not need to handle illegal arguments because other methods handle them before ever reaching this one.
         * @return number of the card object
         * @version 1.0
         * @author Jackson Cody
         */
        public int getNumber() {
            return number;
        }

        public int getValue() {
            if (number <= 10 && number >= 2) {
                return number;
            } else if (number == 1) {
                return 11;
            } else return 10;
        }


        /**
         * returns the name of the card if it is a face card
         * @author joebr
         * @version 1.1
         */
        public String getNumberName(){
            if (number < 1 || number > 13) {
                throw new IllegalArgumentException();
            }

            if (number == 11){
                return "Jack";
            } else if (number == 12){
                return "Queen";
            } else if(number == 13){
                return "King";
            } else if(number == 1){
                return "Ace";
            } else {
                return Integer.toString(number);
            }
        }

        /**
         * gets the int value of the suit, 0 hearts 1 spades 2 clubs 3 diamonds. does not check for illegal arguments because other methods handle them before reaching this one.
         * @return suit of the card object
         * @version 1.0
         */
        public int getSuit() {
            return suit;
        }

        /**
         * returns the name of the suit of the card, and throws an illegal argument if the number isn't between 0 and 3 for a valid suit
         * @author joebr
         */
        public String getSuitName(){
            if(suit == 0) {
                return "Hearts";
            } else if(suit == 1) {
                return "Spades";
            } else if(suit == 2) {
                return "Clubs";
                } else if(suit == 3) {
                return "Diamonds";
            } else {
                throw new IllegalArgumentException();
            }
        }
    }



