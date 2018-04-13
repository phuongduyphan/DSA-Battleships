package gameStage;

public class Stage4 implements IStage{
	private static Stage4 instance = null;

	public static Stage4 getInstance() {
		if (instance == null)
			return new Stage4();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(Stage1.getInstance());
	}
}
