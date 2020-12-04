package csc439team7.blackjack;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * abstract view class that has methods to be implemented in the CLIview.
 * @author joebr
 */
abstract class view {

abstract int buyChips();
abstract String start(int chips) throws Exception;
abstract String play() throws Exception;
abstract int promptBet(int chips);
abstract void showCards(hand p, hand d);
abstract void flipDealer(hand d);
abstract int compare(int player, int dealer);
}

