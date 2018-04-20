package UI;

import gameBoard.player.Strategy;
import gameStage.Stage1;

public class CommandStage1 extends Command {
	private Strategy mode;

	@Override
	public boolean isCompleted() {
		return mode != null ? true : false;
	}

	@Override
	public void onFinished() {
		// TODO Auto-generated method stub
		Stage1.getInstance().createGame(this);

	}

	public Strategy getMode() {
		return mode;
	}

	public void setMode(Strategy mode) {
		this.mode = mode;
	}
}
