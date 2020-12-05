package csc439team7.blackjack;
import java.util.logging.Logger;

/**
 * contains the main method that starts the game function
 * @author joebr
 */
public class main {
    private static final Logger logger = Logger.getLogger(main.class.getName());
    /**
     * main method that creates a view, and then a controller that has a constructor using that view that then calls the playblackjack method
     */
    public static void main(String[] args) {
        logger.entering(main.class.getName(), "main");

        CLIView view = new CLIView();
        controller bjcontrol = new controller(view);
        bjcontrol.playBlackjack();
        logger.exiting(main.class.getName(), "main");
    }
}