package csc439team7.blackjack;

public class controller {
    private CLIView view;
    private int chips;
    private int bet;
    private String response;

    public controller(CLIView view) {
    this.view = view;
    }

    public void playBlackjack() {
        shoe myShoe = new shoe(5);
        chips = view.buyChips();
        try {
            response = view.start();
        } catch (Exception E) {
            System.exit(0);
        }

        bet = view.promptBet();
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
