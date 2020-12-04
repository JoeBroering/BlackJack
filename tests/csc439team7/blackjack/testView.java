package csc439team7.blackjack;

public class testView{
    public static void main(String[] args) {
        CLIView view = new CLIView();
        controller bjcontrol = new controller(view);
        bjcontrol.playBlackjack();
    }

}
