package gameStage;

import UI.UIHandler;

public interface IStage {
	public UIHandler getUIHandler();
	public void handle();
	public void done();
}
