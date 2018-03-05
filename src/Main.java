
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameHandler handler = GameHandler.getInstance();
		
		while (!handler.getCurrentTurn().getPlayer().checkWin()) {
			Player currentPlayer = handler.getCurrentTurn().getPlayer();
			currentPlayer.play();
			handler.getCurrentTurn().setNextTurnInGameHanler();
		}
	}

}
