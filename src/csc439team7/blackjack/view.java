package csc439team7.blackjack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * abstract view class that has methods to be implemented in the CLIview. buyChips prompts the user for the amount of chips to enter the game with.
 * start prompts the user for whether or not they would like to play the hand
 * play prompts the user for the action they will take during the hand
 * promptbet asks the user for the value of their bet.
 * showCards shows the cards that the player has and the cards the dealer has.
 * flipDealer shows the hidden card of the dealer after the player finishes their turn.
 * compare compares the players score to the dealer's score
 * @author joebr
 */
abstract class view {

    /**
     * Abstract buyChips method to be defined in CLIview
     * @return the user's response to the prompt
     * @author joebr
     */
abstract int buyChips();

    /**
     * abstract start method to be defined in CLIview
     * @param chips The amount of chips the player has
     * @return the amount of chips the user buys
     * @throws Exception An exception made if the player doesn't wish to play
     * @author joebr
     */
abstract String start(int chips) throws Exception;

    /**
     * abstract play method to be defined in CLIView
     * @return if the player hits or stands
     * @throws Exception an exception if the player makes an invalid input
     * @author joebr
     */
abstract String play() throws Exception;
    /**
     * abstract promptBet method to be defined in CLIView
     * @return how many chips the user bets
     * @author joebr
     */
abstract int promptBet(int chips);
    /**
     * abstract showCards method to be defined in CLIView
     * @author joebr
     */
abstract void showCards(hand p, hand d);
    /**
     * abstract flipDealer method to be defined in CLIView
     * @author joebr
     */
abstract void flipDealer(hand d);
    /**
     * abstract compare method to be defined in CLIView
     * @return if the player or dealer wins the game
     * @author joebr
     */
abstract int compare(int player, int dealer);
}
