package csc439team7.blackjack;

/**
 * controller class that controls the operation of the game and the logic with a play blackjack method that gives information to the view
 * @author joebr
 * @version 1.0
 */
public class controller {
    private CLIView view;
    private int chips;
    private int bet;
    private String response;

    /**
     * constructor for the controller which takes in a view object.
     * @author joebr
     * @version 1.0
     */
    public controller(CLIView view) {
    this.view = view;
    }


    /**
     * blackjack method that controls the logic of the game and sends stuff to the view so it can be seen by the player. Currently game starts, you get chips and choose to play or not (which will occur in a loop if we continue development for multiple hands)
     * @author joebr
     * @version 1.0
     */
    public void playBlackjack() {
        shoe myShoe = new shoe(5);
        chips = view.buyChips();
        try {
            response = view.start();
        } catch (Exception E) {
            System.exit(0);
        }

        bet = view.promptBet(chips);
        chips = chips - bet;

        card dealerCard1 = myShoe.pick();
        card dealerCard2 = myShoe.pick();
        hand dealerhand = new hand();
        dealerhand.addCard(dealerCard1);
        dealerhand.addCard(dealerCard2);

        hand playerhand = new hand();
        card playerCard1 = myShoe.pick();
        card playerCard2 = myShoe.pick();
        playerhand.addCard(playerCard1);
        playerhand.addCard(playerCard2);

        view.showCards(playerhand, dealerhand);

    }
}
