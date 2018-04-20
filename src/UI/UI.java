package UI;

import java.io.IOException;
import java.util.ArrayList;

import UI.gui.WeaponPane;
import gameBoard.cell.Cell;
import gameBoard.player.Player;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public interface UI {
	public void createStage1() throws IOException;
	
	public StackPane getContainerStage1();
	
	public void createStage2() throws IOException;
	
	public VBox getContainerStage2();
	
	public void disableShipStage2(CommandStage2 cmd);
	
	public void displayShipStage2(CommandStage2 cmd);
	
	public void createStage3() throws IOException;
	
	public void enableInputStage3();

	public void enableShootStage3();

	public Player getPlayer();
	
	public void shootStage3(CommandStage3 cmd);
	
	public void displayStage3(final CommandStage3 cmd, final ArrayList<Cell> listOfExplosion);
	
	public void switchPlayerStage3();
	
	public VBox getContainerStage3();
	
	public WeaponPane getWeaponPaneStage3();
}
