package gameStage;

import UI.UIHandler;
import UI.UIHandlerStage3;

public class Stage1 implements IStage {
	private static Stage1 instance = null;
	
	public static Stage1 getInstance() {
		if (instance == null) {
			instance = new Stage1();
		};
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(Stage2.getInstance());
	}
}
