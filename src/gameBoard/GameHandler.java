package gameBoard;

import gameBoard.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

/// TODO: consider turning of singleton for this class, make every instance is created for each game

public class GameHandler {
	private ArrayList<Player> players;
	private Iterator<Player> iterator;

	public GameHandler(ArrayList<Player> players) {
		// TODO: GameHandler constructor
        this.players = players;
        iterator = players.iterator();
	}

	public void nextTurn() {
        if(!iterator.hasNext()) {
            iterator = players.iterator();
        }
        iterator.next().play();
    }

    /// receive input from inputHandler
    public void input(InputObject o){
        this.process(o);
    }

    private void process(InputObject o) {
        /// TODO: make sense of the input and updateCommandStage4 players accordingly

        /// TODO: check win

        ///if there is no winner yet
        this.nextTurn();
        /// if else
        /// app.win(winner) ????
    }
}
