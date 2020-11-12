package csc439team7.blackjack;

public class main {

    public static void main(String[] args) {
        TestView view2 = new TestView();
        controller bjcontroltest = new controller(view2);
        bjcontroltest.blackJackTest();

        //CLIView view = new CLIView();
        //controller bjcontrol = new controller(view);
        //bjcontrol.playBlackjack();
    }
}