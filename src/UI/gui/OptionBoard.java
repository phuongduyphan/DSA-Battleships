package UI.gui;

import gameStage.Stage4;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class OptionBoard {
	private StackPane optionBoard;
	
	public OptionBoard() {
		optionBoard = new StackPane();
		optionBoard.setPrefHeight(920);
		optionBoard.setPrefWidth(540);
		optionBoard.setMinHeight(Region.USE_PREF_SIZE);
		optionBoard.setMinWidth(Region.USE_PREF_SIZE);
		optionBoard.setMaxHeight(Region.USE_PREF_SIZE);
		optionBoard.setMaxWidth(Region.USE_PREF_SIZE);
		optionBoard.setId("optionBoard");
		
		Button backToMenu = new Button();
		backToMenu.setPrefHeight(70);
		backToMenu.setPrefWidth(350);
		backToMenu.setTranslateY(-100);
		backToMenu.setId("optionButton");
		backToMenu.setText("Return to main menu");
		backToMenu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage4.getInstance().done();
			}
		});
		
		Button quitGame = new Button();
		quitGame.setPrefHeight(70);
		quitGame.setPrefWidth(350);
		quitGame.setTranslateY(0);
		quitGame.setId("optionButton");
		quitGame.setText("Quit game");
		quitGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage4.getInstance().exitGame();
			}
		});
		
		optionBoard.getChildren().addAll(backToMenu,quitGame);
	}

	public StackPane getOptionBoard() {
		return optionBoard;
	}
	
}
