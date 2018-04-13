package UI.gui;

import java.io.IOException;

import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.cell.CellFactory;
import gameStage.Stage3;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class OpponentBoard {
	private StackPane opponentBoardPane;
	private ToggleButton[][] buttonGrid;

	public OpponentBoard() throws IOException {
		FXMLLoader gameBoardLoader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
		opponentBoardPane = gameBoardLoader.load();
		opponentBoardPane.setId("opponentPane");

		GridPane gridPane = new GridPane();
		gridPane.setPrefHeight(400);
		gridPane.setPrefWidth(400);
		gridPane.setId("radarPane");
		gridPane.setTranslateX(70);
		gridPane.setTranslateY(30);

		int numberOfRows = Configurations.numberOfRows;
		int numberOfColumns = Configurations.numberOfColumns;
		ToggleGroup radarGroup = new ToggleGroup();
		buttonGrid = new ToggleButton[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			gridPane.getRowConstraints().add(new RowConstraints(50));
			for (int j = 0; j < numberOfColumns; j++) {
				gridPane.getColumnConstraints().add(new ColumnConstraints(50));
				ToggleButton button = new ToggleButton();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.setToggleGroup(radarGroup);
				button.setDisable(true);
				buttonGrid[i][j] = button;
				buttonGrid[i][j].setId("radarButton");
				final int row = i;
				final int col = j;
				
				button.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Stage3.getInstance().getUIHandler().updateCommand(
								Stage3.getInstance().getCurrentPlayer().getBoard().getCellAt(new Coordinate(row,col)));
					}
				});

				gridPane.add(buttonGrid[i][j], j, i);
			}
		}
		opponentBoardPane.setAlignment(Pos.TOP_LEFT);
		opponentBoardPane.getChildren().add(gridPane);
	}
	
	public void enable() {
		int numberOfRows = Configurations.numberOfRows;
		int numberOfColumns = Configurations.numberOfColumns;
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				buttonGrid[i][j].setDisable(false);
			}
		}
	}

	public StackPane getOpponentBoardPane() {
		return opponentBoardPane;
	}

	public void setButtonImage(int row,int col, boolean hit) {
		if (hit == true) {
			buttonGrid[row][col].setId("hitCoor");
		}
		else {
			buttonGrid[row][col].setId("missCoor");
		}	
	}
}
