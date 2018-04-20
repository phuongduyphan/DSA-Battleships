package UI;

import gameBoard.player.Strategy;

public class UIHandlerStage1 extends UIHandler {
	public void enableInput() {
		cmd = new CommandStage1();
	}
	
	public void updateCommand(IClickable i) {
		assert(cmd instanceof CommandStage1);
		CommandStage1 c = (CommandStage1) cmd;
		if (i instanceof Strategy) {
			c.setMode((Strategy) i);
		}
		
		if (c.isCompleted()) c.onFinished();
	}
}
