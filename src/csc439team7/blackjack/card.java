package csc439team7.blackjack;
import java.util.logging.Logger;

/**
     * Class used to create a card object
     * @author Jackson Cody, joebr, Bradley Brown
     * @version 1.2
     */
     class card {
        private static final Logger logger = Logger.getLogger(card.class.getName());
        private int number;
        private int suit;

        /**
         * constructor for card that takes in a suit and a number and checks for illegal arguments
         * @version 1.2
         * @param suit suit of the card
         * @param number number of the card
         * @author Jackson Cody, joebr
         */
        public card (int suit, int number){
            logger.entering(getClass().getName(), "card");
            if (number < 1 || number > 13) {
                logger.info("Card number is an illegal value");
                logger.exiting(getClass().getName(), "card");
                throw new IllegalArgumentException();
            }
            if (suit < 0 || suit > 3) {
                logger.info("Number representing the suite is out of the correct range");
                logger.exiting(getClass().getName(), "card");
                throw new IllegalArgumentException();
            }
            this.number=number;
            this.suit=suit;
            logger.info("Successful Card Creation");
            logger.exiting(getClass().getName(), "card");
        }

        /**
         * gets the Number of the card, stays at 11,12,13,14 for face cards. does not need to handle illegal arguments because other methods handle them before ever reaching this one.
         * @return number of the card object
         * @version 1.1
         * @author Jackson Cody
         */
        public int getNumber() {
            logger.entering(getClass().getName(), "getNumber");
            logger.info("card number is returned");
            logger.exiting(getClass().getName(), "getNumber");
            return number;
        }

        public int getValue() {
            logger.entering(getClass().getName(), "getValue");
            if (number <= 10 && number >= 2) {
                logger.info("Card value is between 2-10");
                logger.exiting(getClass().getName(), "getValue");
                return number;
            } else if (number == 1) {
                logger.info("Card value is assigned 11 for aces");
                logger.exiting(getClass().getName(), "getValue");
                return 11;
            } else {
                logger.info("Card value is assigned 10 for face cards");
                logger.exiting(getClass().getName(), "getValue");
                return 10;
            }
        }


        /**
         * returns the name of the card if it is a face card
         * @author joebr
         * @version 1.2
         */
        public String getNumberName(){
            logger.entering(getClass().getName(), "getNumberName");
            if (number < 1 || number > 13) {
                logger.info("Card number is an illegal value");
                logger.exiting(getClass().getName(), "getNumberName");
                throw new IllegalArgumentException();
            }

            if (number == 11){
                logger.info("11 is assigned the Jack card name");
                logger.exiting(getClass().getName(), "getNumberName");
                return "Jack";
            } else if (number == 12){
                logger.info("12 is assigned the Queen card name");
                logger.exiting(getClass().getName(), "getNumberName");
                return "Queen";
            } else if(number == 13){
                logger.info("13 is assigned the King card name");
                logger.exiting(getClass().getName(), "getNumberName");
                return "King";
            } else if(number == 1){
                logger.info("1 is assigned the Ace card name");
                logger.exiting(getClass().getName(), "getNumberName");
                return "Ace";
            } else {
                logger.info("The card number is returned");
                logger.exiting(getClass().getName(), "getNumberName");
                return Integer.toString(number);
            }
        }

        /**
         * gets the int value of the suit, 0 hearts 1 spades 2 clubs 3 diamonds. does not check for illegal arguments because other methods handle them before reaching this one.
         * @return suit of the card object
         * @version 1.1
         * @author joebr
         */
        public int getSuit() {
            logger.entering(getClass().getName(), "getSuit");
            logger.info("suit of card obtained");
            logger.exiting(getClass().getName(), "getSuit");
            return suit;
        }

        /**
         * returns the name of the suit of the card, and throws an illegal argument if the number isn't between 0 and 3 for a valid suit
         * @version 1.1
         * @author joebr
         */
        public String getSuitName(){
            logger.entering(getClass().getName(), "getSuitName");
            if(suit == 0) {
                logger.info("Card is a part of the Hearts suit");
                logger.exiting(getClass().getName(), "getSuitName");
                return "Hearts";
            } else if(suit == 1) {
                logger.info("Card is a part of the Spades suit");
                logger.exiting(getClass().getName(), "getSuitName");
                return "Spades";
            } else if(suit == 2) {
                logger.info("Card is a part of the Clubs suit");
                logger.exiting(getClass().getName(), "getSuitName");
                return "Clubs";
            } else if(suit == 3) {
                logger.info("Card is a part of the Diamonds suit");
                logger.exiting(getClass().getName(), "getSuitName");
                return "Diamonds";
            } else {
                logger.info("Illegal value for suit");
                logger.exiting(getClass().getName(), "getSuitName");
                throw new IllegalArgumentException();
            }
        }
    }



