package csc439team7.blackjack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * abstract view class that has methods to be implemented in the CLIview.
 * @version 1.1
 * @author joebr
 */
abstract class view {
    /**
     * abstract buy chips method to be defined in CLIView
     * @version 1.1
     * @author joebr
     */
abstract int buyChips();
    /**
     * abstract start method to be defined in CLIview.
     * @version 1.1
     * @author joebr
     */
abstract String start(int chips) throws Exception;
    /**
     * abstract play method to be defined in CLIview.
     * @version 1.1
     * @author joebr
     */
abstract String play() throws Exception;
    /**
     * abstract promptbet method to be defined in the CLIview.
     * @version 1.1
     * @author joebr
     */
abstract int promptBet(int chips);
    /**
     * abstract showcards method to be defined in the CLIview.
     * @version 1.1
     * @author joebr
     */
abstract void showCards(hand p, hand d);
    /**
     * abstract flipDealer method to be defined in the CLIview.
     * @version 1.1
     * @author joebr
     */
abstract void flipDealer(hand d);
    /**
     * abstract compare method to be defined in the CLIview.
     * @version 1.1
     * @author joebr
     */
abstract int compare(int player, int dealer);
}
