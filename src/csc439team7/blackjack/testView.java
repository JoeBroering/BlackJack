package csc439team7.blackjack;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class testView extends view{
    private static final Logger logger = Logger.getLogger(hand.class.getName());

    /**
     * the buyChips method requests user input for a number of chips to begin the game with
     * @author joebr, jcody
     * @version 1.5
     */
    @Override
    int buyChips() {
        logger.entering(getClass().getName(), "buyChips");
        System.out.println("How many chips?");
        Scanner myObj = new Scanner(System.in);
        int chips = Integer.parseInt(myObj.nextLine());
        while (true) {
            if (chips > 5000) {
                System.out.println("Maximum buy is $5000");
                chips = Integer.parseInt(myObj.nextLine());
            } else if (chips < 0) {
                System.out.println("Invalid buy");
                chips = Integer.parseInt(myObj.nextLine());
            } else {
                break;
            }
        }
        logger.info("Valid number of chips were bought");
        logger.exiting(getClass().getName(), "buyChips");
        return chips;
    }


    /**
     * start method checks to see if the user would like to play or quit the game. Assumes once they enter play they must play out the hand. has exception throw to controller if user enters exit
     *
     * @author joebr
     */
    String start(int chips) throws Exception {
        logger.entering(getClass().getName(), "start");
        System.out.println("You have " + chips + " chips.");
        System.out.println("Would you like to play? (Play/Quit)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();

        while (true) {
            if (response.equals("Quit")) {
                logger.info("Player quits game");
                throw new IllegalStateException();
            } else if (!response.equals("Play")) {
                System.out.println("Input not recognized");
                response = myObj.next();
            } else {
                break;
            }
        }
        logger.info("New Game starts");
        logger.exiting(getClass().getName(), "start");
        return response;
    }

    /**
     * prompts bet from user, returns the value to the controller as an integer. needs handling on max/min bet value
     *
     * @author joebr
     */
    @Override
    int promptBet(int chips) {
        logger.entering(getClass().getName(), "promptBet");
        System.out.println("Enter your bet:");
        Scanner myObj = new Scanner(System.in);
        int bet = Integer.parseInt(myObj.nextLine());
        while (true) {
            if (bet < 10) {
                System.out.println("Minimum Bet is $10");
                bet = Integer.parseInt(myObj.next());
            } else if (bet > 500) {
                System.out.println("Maximum Bet is $500");
                bet = Integer.parseInt(myObj.next());
            } else if (bet > chips) {
                System.out.println("You only have " + chips + " to bet.");
                bet = Integer.parseInt(myObj.next());
            } else {
                break;
            }
        }
        logger.info("Valid Bet");
        logger.exiting(getClass().getName(), "promptBet");
        return bet;
    }

    /**
     * showCards prints out the card values to the user of their two cards and of the card the dealer shows.
     *
     * @author joebr
     */
    @Override
    void showCards(hand playerhand, hand dealerhand) {
        logger.entering(getClass().getName(), "showCards");
        System.out.println("Your hand:");
        ArrayList<card> phand = playerhand.listCards();
        for (int i = 0; i < phand.size(); i++) {
            System.out.println(phand.get(i).getNumberName() + " of " + phand.get(i).getSuitName());
        }
        System.out.println("Dealer Hand:");
        ArrayList<card> dhand = dealerhand.listCards();
        System.out.println(dhand.get(0).getNumberName() + " of " + dhand.get(0).getSuitName());
        logger.info("Both hands should be printed");
        logger.exiting(getClass().getName(), "showCards");
    }

    /**
     * shows the dealer's hidden card once the player ends their turn
     * @author joebr
     */
    @Override
    void flipDealer(hand dealerhand) {
        logger.entering(getClass().getName(), "flipDealer");
        ArrayList<card> dhand = dealerhand.listCards();
        System.out.println("Dealer Flips:");
        System.out.println(dhand.get(1).getNumberName() + " of " + dhand.get(1).getSuitName());
        logger.info("Dealer reveals hidden card");
        logger.exiting(getClass().getName(), "flipDealer");
    }

    /**
     * method compares the two scores of the player and dealer if neither has busted to determine the winner. returns 0 if the player wins and 1 if the dealer wins
     * @author joebr
     */
    @Override
    int compare(int player, int dealer) {
        logger.entering(getClass().getName(), "compare");
        System.out.println("Your Score is " + player);
        System.out.println("Dealer Score is " + dealer);
        if(player > dealer) {
            System.out.println("Player Wins!");
            logger.info("Player should win");
            logger.exiting(getClass().getName(), "compare");
            return 0;
        } else {
            System.out.println("Dealer Wins!");
            logger.info("Dealer Should win");
            logger.exiting(getClass().getName(), "compare");
            return 1;
        }
    }


    /**
     * method for player action. the player can currently hit or stand doubling needs to be added.\
     * @author joebr
     */
    String play() {
        logger.entering(getClass().getName(), "play");
        System.out.println("What would you like to do? (Hit/Double/Stand)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();

        while (true) {
            if (response.equals("Hit")) {
                logger.info("Player should receive another card next");
                logger.exiting(getClass().getName(), "play");
                return response;
            } else if (response.equals("Stand")) {
                logger.info("Player stands");
                logger.exiting(getClass().getName(), "play");
                return response;
            } else if (response.equals("Double")) {
                logger.info("player doubles");
                logger.exiting(getClass().getName(), "play");
                return response;
            } else{
                System.out.println("Input not Recognized");
                response = myObj.next();
            }
        }
    }

    /**
     * method for busting which takes in an integer to indicate which player busted.
     * @author joebr
     */
    void bust(int person) {
        logger.entering(getClass().getName(), "bust");
        if (person == 0) {
            System.out.println("You busted!");
            logger.info("player busted");
            logger.exiting(getClass().getName(), "bust");
        } else {
            System.out.println("Dealer busted!");
            logger.info("Dealer busted");
            logger.exiting(getClass().getName(), "bust");
        }
    }

    /**
     * printCard gets the card the dealer draws when their score is under 17, has a one second pause for added effect.
     * @author joebr
     */
    void printCard(card card) throws InterruptedException {
        logger.entering(getClass().getName(), "printCard");
        System.out.println("Dealer Draws Another Card:");
        logger.info("There should be a one second pause");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dealer drew " + card.getNumberName() + " of " + card.getSuitName());
        logger.info("newly drawn card should be printed");
        logger.exiting(getClass().getName(), "printCard");
    }

    /**
     * method used to prompt the user as to what happens when they try to double their bet
     * @param sitch determines if the player is able to double the bet or not to display the right prompt
     * @author jcody
     */
    void betDouble(int sitch){
        if (sitch == 1){
            System.out.println("You don't have 2 cards and cannot double your bet");
        }else if(sitch == 2){
            System.out.println("Your score is not between 9 and 11 so you cannot double your bet");
        }else{
            System.out.println("Your bet doubles and you take one hit then stand");
        }
    }

}
