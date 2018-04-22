package UI.gui;

import java.io.IOException;

import gameBoard.player.EasyMode;
import gameBoard.player.NormalMode;
import gameStage.Stage1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MenuBoard {
	private StackPane menuBoard;
	
	public MenuBoard() throws IOException {
		FXMLLoader menuBoardLoader = new FXMLLoader(getClass().getResource("MenuBoard.fxml"));
		menuBoard = menuBoardLoader.load();
		menuBoard.setAlignment(Pos.CENTER);
		menuBoard.setId("menuBoard");
		
		Button easyModeButton = new Button();
		easyModeButton.setPrefHeight(66);
		easyModeButton.setPrefWidth(300);
		easyModeButton.setTranslateY(100);
		easyModeButton.setId("cover-button");
		easyModeButton.setText("Easy Mode");
		easyModeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage1.getInstance().getUIHandler().updateCommand(new EasyMode());
			}
		});
		
		
		Button normalModeButton = new Button();
		normalModeButton.setPrefHeight(66);
		normalModeButton.setPrefWidth(300);
		normalModeButton.setTranslateY(200);
		normalModeButton.setId("cover-button");
		normalModeButton.setText("Normal Mode");
		normalModeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage1.getInstance().getUIHandler().updateCommand(new NormalMode());
			}
		});
		
		
		menuBoard.getChildren().addAll(easyModeButton,normalModeButton);
	}

	public StackPane getMenuBoard() {
		return menuBoard;
	}
}
