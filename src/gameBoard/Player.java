package gameBoard;

public abstract class Player {
	
	public void play() {
		// play...
		notifyAllViews();
	}
	
	public boolean checkWin();
	public void notifyAllViews();
}
