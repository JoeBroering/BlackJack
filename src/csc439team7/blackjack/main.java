package csc439team7.blackjack;

/**
 * contains the main method that starts the game function
 * @author joebr
 */
public class main {

    /**
     * main method that creates a view, and then a controller that has a constructor using that view that then calls the playblackjack method
     */
    public static void main(String[] args) {
        //TestView view2 = new TestView();
        //controller bjcontroltest = new controller(view2);
        //bjcontroltest.blackJackTest();

        CLIView view = new CLIView();
        controller bjcontrol = new controller(view);
        bjcontrol.playBlackjack();
    }
}