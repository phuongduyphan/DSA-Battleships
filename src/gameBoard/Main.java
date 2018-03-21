package gameBoard;
import gameState.State1;
import gameState.app;

public class Main {

    public static void main(String[] args) {

    	app.getInstance().setStateAndStart(State1.getInstance());
    }

}
