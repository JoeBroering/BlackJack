package csc439team7.blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * The CLIview implements the abstract methods in the view.
 * @version 1.0
 * @author joebr
 */
public class CLIView extends view{


    /**
     * the buyChips method requests user input for a number of chips to begin the game with
     * @author joebr, jcody
     * @version 1.5
     */
    @Override
    int buyChips() {
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
        return chips;
    }


    /**
     * start method checks to see if the user would like to play or quit the game. Assumes once they enter play they must play out the hand. has exception throw to controller if user enters exit
     *
     * @author joebr
     */
    String start(int chips) throws Exception {
        System.out.println("You have " + chips + " chips.");
        System.out.println("Would you like to play? (Play/Quit)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();

        while (true) {
            if (response.equals("Quit")) {
                throw new IllegalStateException();
            } else if (!response.equals("Play")) {
                System.out.println("Input not recognized");
                response = myObj.next();
            } else {
                break;
            }
        }
        return response;
    }

    /**
     * prompts bet from user, returns the value to the controller as an integer. needs handling on max/min bet value
     *
     * @author joebr
     */
    @Override
    int promptBet(int chips) {
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

        return bet;
    }

    /**
     * showCards prints out the card values to the user of their two cards and of the card the dealer shows.
     *
     * @author joebr
     */
    @Override
    void showCards(hand playerhand, hand dealerhand) {
        System.out.println("Your hand:");
        ArrayList<card> phand = playerhand.listCards();
        for (int i = 0; i < phand.size(); i++) {
            System.out.println(phand.get(i).getNumberName() + " of " + phand.get(i).getSuitName());
        }
        System.out.println("Dealer Hand:");
        ArrayList<card> dhand = dealerhand.listCards();
        System.out.println(dhand.get(0).getNumberName() + " of " + dhand.get(0).getSuitName());
    }

    /**
     * shows the dealer's hidden card once the player ends their turn
     * @author joebr
     */
    @Override
    void flipDealer(hand dealerhand) {
        ArrayList<card> dhand = dealerhand.listCards();
        System.out.println("Dealer Flips:");
        System.out.println(dhand.get(1).getNumberName() + " of " + dhand.get(1).getSuitName());
    }

    /**
     * method compares the two scores of the player and dealer if neither has busted to determine the winner. returns 0 if the player wins and 1 if the dealer wins
     * @author joebr
     */
    @Override
    int compare(int player, int dealer) {
        System.out.println("Your Score is " + player);
        System.out.println("Dealer Score is " + dealer);
        if(player > dealer) {
            System.out.println("Player Wins!");
            return 0;
        } else {
            System.out.println("Dealer Wins!");
            return 1;
        }
    }


    /**
     * method for player action. the player can currently hit or stand doubling needs to be added.\
     * @author joebr
     */
    String play() {
        System.out.println("What would you like to do? (Hit/Double/Stand)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();

        while (true) {
            if (response.equals("Hit")) {
                return response;
            } else if (response.equals("Stand")) {
                return response;
            } else {
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
        if(person == 0) {
            System.out.println("You busted!");
        } else System.out.println("Dealer busted!");

    }

    /**
     * printCard gets the card the dealer draws when their score is under 17, has a one second pause for added effect.
     * @author joebr
     */
    void printCard(card card) throws InterruptedException {
        System.out.println("Dealer Draws Another Card:");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Dealer drew " + card.getNumberName() + " of " + card.getSuitName());
    }


}
