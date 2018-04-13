package gameStage;

public class Stage2 implements IStage {
	private static Stage2 instance = null;

	public static Stage2 getInstance() {
		if (instance == null)
			return new Stage2();
		return instance;
	}
	
	public void handle() {
		//TODO implement each state handle
		
	}
	
	public void done() {
		app.getInstance().setStateAndStart(Stage3.getInstance());
	}
}
