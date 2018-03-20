package gameBoard;

import gameBoard.GameHandler;
import gameBoard.player.Player;
import gameState.State1;
import gameState.app;

public class Main {

    public static void main(String[] args) {

    	app.getInstance().setState(State1.getInstance());
        
    	while (true) {
        	app.getInstance().getCurrentState().handle();
        }
    }

}
