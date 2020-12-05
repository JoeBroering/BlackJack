package csc439team7.blackjack;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * controller class that controls the operation of the game and the logic with a play blackjack method that gives information to the view
 * @author joebr, Bradley Brown
 * @version 1.1
 */
public class controller {
    private static final Logger logger = Logger.getLogger(controller.class.getName());
    private CLIView view;
    private int chips;
    private int bet;
    private String response;

    /**
     * constructor for the controller which takes in a view object.
     * @author joebr
     * @version 1.1
     */
    public controller(view view) {
        logger.entering(getClass().getName(), "controller");
        logger.exiting(getClass().getName(), "controller");
    }


    /**
     * blackjack method that controls the logic of the game and sends stuff to the view so it can be seen by the player. Currently game starts, you get chips and choose to play or not (which will occur in a loop if we continue development for multiple hands)
     * @author joebr, jcody, Bradley Brown
     * @version 1.7
     */
    public void playBlackjack() {
        logger.entering(getClass().getName(), "playBlackjack");
        shoe myShoe = new shoe(5);
        int size = myShoe.numDecks();
        int minimum = size/5;
        chips = view.buyChips();

        while(true) {

            try {
                response = view.start(chips);
            } catch (Exception E) {
                logger.info("User specifies to exit game");
                logger.exiting(getClass().getName(), "playBlackjack");
                System.exit(0);
            }

            bet = view.promptBet(chips);
            chips = chips - bet;

            int playerTotal = 0;
            int dealerTotal = 0;
            int winner = -1;
            if(size == minimum){
                shoe refill = new shoe(5);
                myShoe = refill;
                logger.info("shoe is refilled");
            }

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
            int numPlayerCards = 2; //to check for doubling

            view.showCards(playerhand, dealerhand);

            while (true) {
                response = view.play();
                if (response.equals("Hit")) {
                    logger.info("player hits");
                    card hitCard = myShoe.pick();
                    playerhand.addCard(hitCard);
                    numPlayerCards += 1;
                    view.showCards(playerhand, dealerhand);
                    ArrayList<card> phand = playerhand.listCards();
                    for (int i = 0; i < phand.size(); i++) {
                        playerTotal += phand.get(i).getValue();
                    }
                    if (playerTotal > 21) {
                        logger.info("playerTotal is above 21 and Player loses");
                        view.bust(0);
                        winner = 1;
                        break;
                    }
                } else if (response.equals("Stand")) {
                    logger.info("player stands");
                    playerTotal = 0;
                    ArrayList<card> phand = playerhand.listCards();
                    for (int i = 0; i < phand.size(); i++) {
                        playerTotal += phand.get(i).getValue();
                    }
                    break;
                } else if (response.equals("Double")){
                    logger.info("player doubles");
                    int sitch;
                    if(numPlayerCards != 2){
                        sitch = 1;
                        view.betDouble(sitch);
                    }else if(playerTotal < 9 || playerTotal > 11){
                        sitch = 2;
                        view.betDouble(sitch);
                    }else{
                        sitch = 3;
                        bet = bet * 2;
                        card hitCard = myShoe.pick();
                        playerhand.addCard(hitCard);
                        numPlayerCards += 1;
                        view.betDouble(sitch);
                        view.showCards(playerhand, dealerhand);
                        ArrayList<card> phand = playerhand.listCards();
                        for (int i = 0; i < phand.size(); i++) {
                            playerTotal += phand.get(i).getValue();
                        }
                        if (playerTotal > 21) {
                            logger.info("playerTotal is above 21 and Player loses");
                            view.bust(0);
                            winner = 1;
                            break;
                        }
                        break;
                    }
                }
            }
           if(winner == -1) {
               view.flipDealer(dealerhand);

               ArrayList<card> dhand = dealerhand.listCards();
               for (int i = 0; i < dhand.size(); i++) {
                   dealerTotal += dhand.get(i).getValue();
               }

               while (dealerTotal < 17 && dealerTotal < playerTotal) {
                   card dealerCard = myShoe.pick();
                   dealerhand.addCard(dealerCard);
                   try {
                       view.printCard(dealerCard);
                   } catch (InterruptedException e) {
                       logger.info("Error with viewing a card after being added to the dealer's hand.");
                       e.printStackTrace();
                   }
                   dealerTotal += dealerCard.getValue();
               }

               if (dealerTotal > 21) {
                   logger.info("dealerTotal is above 21 and Dealer loses");
                   view.bust(1);
                   winner = 0;
               }

               //if here both have valid scores time to compare
               if (winner == -1) {
                   logger.info("Both scores are below 21 and need to be compared");
                   winner = view.compare(playerTotal, dealerTotal);
               }

               if (winner == 0) {
                   chips += (2 * bet);
                   logger.info("player receives chips equal to double their bet");
               }
           }
            logger.exiting(getClass().getName(), "playBlackjack");
        } //closes loop

    }
}
