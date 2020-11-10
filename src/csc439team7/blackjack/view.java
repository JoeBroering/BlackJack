package csc439team7.blackjack;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * abstract view class that has methods to be implemented in the CLIview.
 * @author joebr
 */
abstract class view {

abstract int buyChips();
abstract String start() throws Exception;
abstract int promptBet();
abstract void showCards(hand p, hand d);
}

/**
 * The CLIview implements the abstract methods in the view.
 * @version 1.0
 * @author joebr
 */
class CLIView extends view {


    /**
     * the buyChips method requests user input for a number of chips to begin the game with
     * @author joebr
     */
    @Override
    int buyChips() {
        System.out.println("How many chips?");
        Scanner myObj = new Scanner(System.in);
        int chips = Integer.parseInt(myObj.nextLine());
        System.out.println("You have " + chips + " chips");
        return chips;
    }


    /**
     * start method checks to see if the user would like to play or quit the game. Assumes once they enter play they must play out the hand. has exception throw to controller if user enters exit
     * @author joebr
     */
    String start() throws Exception {
        System.out.println("Would you like to play? (Play/Quit)");
        Scanner myObj = new Scanner(System.in);
        String response = myObj.nextLine();

        while(true) {
            if(response.equals("Quit")) {
                throw new IllegalStateException();
            } else if(!response.equals("Play")) {
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
     * @author joebr
     */
    @Override
    int promptBet() {
        System.out.println("Enter your bet:");
        Scanner myObj = new Scanner(System.in);
        int bet = Integer.parseInt(myObj.nextLine());
        return bet;
    }

    /**
     * showCards prints out the card values to the user of their two cards and of the card the dealer shows.
     * @author joebr
     */
    @Override
    void showCards(hand playerhand, hand dealerhand) {
    System.out.println("Your hand:");
        ArrayList<card> phand = playerhand.getCards();
        for (int i = 0; i < phand.size(); i++) {
            System.out.println(phand.get(i).getNumberName() + " of " + phand.get(i).getSuitName());
        }
    System.out.println("Dealer Hand:");
        ArrayList<card> dhand = dealerhand.getCards();
        System.out.println(dhand.get(0).getNumberName() + " of " + dhand.get(0).getSuitName());
    }

}
