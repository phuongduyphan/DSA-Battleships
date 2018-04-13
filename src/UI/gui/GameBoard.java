package UI.gui;

import java.io.IOException;

import gameBoard.Configurations;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class GameBoard {
	private StackPane gameBoardPane;
	private Button[][] buttonGrid;
	
	public GameBoard() throws IOException {
		FXMLLoader gameBoardLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
		gameBoardPane = gameBoardLoader.load();
		gameBoardPane.setId("seaPane");
		
		GridPane gridPane = new GridPane();
		gridPane.setTranslateX(70);
		gridPane.setTranslateY(30);
		gridPane.setPrefHeight(400);
		gridPane.setPrefWidth(400);
		
		int numberOfRows = Configurations.numberOfRows;
		int numberOfColumns = Configurations.numberOfColumns;
		buttonGrid = new Button[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			gridPane.getRowConstraints().add(new RowConstraints(50));
			for (int j = 0; j < numberOfColumns; j++) {
				gridPane.getColumnConstraints().add(new ColumnConstraints(50));
				
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.setId("seaButton");
				
				gridPane.add(button, j, i);
				buttonGrid[i][j] = button;
			}
		}
		gameBoardPane.setAlignment(Pos.TOP_LEFT);
		gameBoardPane.getChildren().add(gridPane);
		
	}

	public StackPane getGameBoardPane() {
		return gameBoardPane;
	}
	
}
