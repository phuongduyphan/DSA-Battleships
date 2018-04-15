package UI.gui;

import java.io.IOException;

import gameBoard.Board;
import gameBoard.Configurations;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipOrientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class GameBoard {
	private StackPane gameBoardPane;
	private Button[][] buttonGrid;
	private Board board;
	
	public GameBoard(Board board) throws IOException {
		this.board = board;
		
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
		
		displayShip();
	}

	public StackPane getGameBoardPane() {
		return gameBoardPane;
	}
	
	private void displayShip() {
		for (int i=0 ; i < board.getListOfShips().size(); i++) {
			Ship ship = board.getListOfShips().get(i);
			
			String imageName = "file:///../resources/" + Configurations.mapShipImage.get(ship.getType());
			if (ship.getOrientation() == ShipOrientation.HORIZONTAL) imageName += "_HORI.png";
			else imageName += "_VERTI.png";
			
			Image shipImage = new Image(imageName);
			ImageView shipImageView = new ImageView(shipImage);
			shipImageView.setTranslateX(70+ship.getStartCoordinate().getCol() * 50);
			shipImageView.setTranslateY(30+ship.getStartCoordinate().getRow() * 50);
			gameBoardPane.getChildren().add(shipImageView);
		}
	}
	
}
