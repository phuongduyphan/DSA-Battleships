package UI;

import java.util.ArrayList;

import gameBoard.cell.Cell;
import gameBoard.player.Player;
import javafx.scene.layout.VBox;

public interface UI {
	public void enableInputStage3();

	public void enableShootStage3();

	public Player getPlayer();
	
	public void shootStage3(CommandStage3 cmd);
	
	public void displayStage3(final CommandStage3 cmd, final ArrayList<Cell> listOfExplosion);
	
	public void switchPlayerStage3();
	
	public VBox getContainerStage3();
}
