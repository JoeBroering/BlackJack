package csc439team7.blackjack;

public class main {

    public static void main(String[] args) {
    CLIView view = new CLIView();
    controller bjcontrol = new controller(view);
    bjcontrol.playBlackjack();
    }
}