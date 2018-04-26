package UI.gui;

import java.io.IOException;

import UI.CommandStage2;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.ship.Ship;
import gameBoard.ship.ShipFactory;
import gameBoard.ship.ShipOrientation;
import gameBoard.ship.ShipType;
import gameStage.Stage2;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ShipBoard {
	private int numberOfColumns;
	private int numberOfRows;
	public VBox shipBoard;
	private Button[][] buttonGrid;
	private StackPane shipBoardPane;
	private ToggleButton aircraftButton;
	private ToggleButton destroyerButton;
	private ToggleButton battleshipButton;
	private ToggleButton submarineButton;
	private ToggleButton patrolBoatButton;
	
	public ShipBoard() throws IOException {
		numberOfColumns = 8;
		numberOfRows = 8;

		FXMLLoader shipBoardLoader = new FXMLLoader(getClass().getResource("ShipBoard.fxml"));
		shipBoard = shipBoardLoader.load();
		
		Pane shipBoardHeader = new Pane();
		shipBoardHeader.setPrefHeight(150);
		shipBoardHeader.setPrefWidth(540);
		shipBoardHeader.setId("shipBoardHeader");
		
		shipBoardPane = new StackPane();
		shipBoardPane.setId("shipBoardPane");
		shipBoardPane.setPrefHeight(770);
		shipBoardPane.setPrefWidth(540);
		shipBoardPane.setMinHeight(Region.USE_PREF_SIZE);
		shipBoardPane.setMinWidth(Region.USE_PREF_SIZE);
		shipBoardPane.setMaxHeight(Region.USE_PREF_SIZE);
		shipBoardPane.setMaxWidth(Region.USE_PREF_SIZE);
		shipBoardPane.setAlignment(Pos.TOP_LEFT);
		
		Image aircraftImage = new Image("file:///../resources/AIRCRAFT_CARRIER_verti.png");
		ImageView aircraftImageView = new ImageView(aircraftImage);
		aircraftImageView.setFitHeight(210);
		aircraftImageView.setFitWidth(40);
		aircraftButton = new ToggleButton();
		aircraftButton.setPrefHeight(220);
		aircraftButton.setPrefWidth(60);
		aircraftButton.setTranslateX(35);
		aircraftButton.setTranslateY(30);
		aircraftButton.setGraphic(aircraftImageView);
		aircraftButton.setId("shipBoardButton");
		
		aircraftButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage2.getInstance().getUIHandler().updateCommand(ShipType.AIRCRAFT_CARRIER);
			}
		});
		
		Image destroyerImage = new Image("file:///../resources/DESTROYER_verti.png");
		ImageView destroyerImageView = new ImageView(destroyerImage);
		destroyerImageView.setFitHeight(170);
		destroyerImageView.setFitWidth(40);
		destroyerButton = new ToggleButton();
		destroyerButton.setPrefHeight(220);
		destroyerButton.setPrefWidth(60);
		destroyerButton.setTranslateX(135);
		destroyerButton.setTranslateY(30);
		destroyerButton.setGraphic(destroyerImageView);
		destroyerButton.setId("shipBoardButton");
		
		destroyerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage2.getInstance().getUIHandler().updateCommand(ShipType.DESTROYER);
			}
		});

		Image battleshipImage = new Image("file:///../resources/battleship_verti.png");
		ImageView battleshipImageView = new ImageView(battleshipImage);
		battleshipImageView.setFitHeight(150);
		battleshipImageView.setFitWidth(50);
		battleshipButton = new ToggleButton();
		battleshipButton.setPrefHeight(220);
		battleshipButton.setPrefWidth(60);
		battleshipButton.setTranslateX(235);
		battleshipButton.setTranslateY(30);
		battleshipButton.setGraphic(battleshipImageView);
		battleshipButton.setId("shipBoardButton");
		
		battleshipButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage2.getInstance().getUIHandler().updateCommand(ShipType.BATTLESHIP);
			}
		});
		
		Image submarineImage = new Image("file:///../resources/submarine_verti.png");
		ImageView submarineImageView = new ImageView(submarineImage);
		submarineImageView.setFitHeight(140);
		submarineImageView.setFitWidth(30);
		submarineButton = new ToggleButton();
		submarineButton.setPrefHeight(220);
		submarineButton.setPrefWidth(60);
		submarineButton.setTranslateX(335);
		submarineButton.setTranslateY(30);
		submarineButton.setGraphic(submarineImageView);
		submarineButton.setId("shipBoardButton");
		
		submarineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage2.getInstance().getUIHandler().updateCommand(ShipType.SUBMARINE);
			}
		});
		
		Image patrolBoatImage = new Image("file:///../resources/patrol_boat_verti.png");
		ImageView patrolBoatImageView = new ImageView(patrolBoatImage);
		patrolBoatImageView.setFitHeight(100);
		patrolBoatImageView.setFitWidth(50);
		patrolBoatButton = new ToggleButton();
		patrolBoatButton.setPrefHeight(220);
		patrolBoatButton.setPrefWidth(60);
		patrolBoatButton.setTranslateX(435);
		patrolBoatButton.setTranslateY(30);
		patrolBoatButton.setGraphic(patrolBoatImageView);
		patrolBoatButton.setId("shipBoardButton");
		
		patrolBoatButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Stage2.getInstance().getUIHandler().updateCommand(ShipType.PATROL_BOAT);
			}
		});
		
		ToggleGroup shipGroup = new ToggleGroup();
		aircraftButton.setToggleGroup(shipGroup);
		destroyerButton.setToggleGroup(shipGroup);
		battleshipButton.setToggleGroup(shipGroup);
		submarineButton.setToggleGroup(shipGroup);
		patrolBoatButton.setToggleGroup(shipGroup);
		
		shipBoardPane.getChildren().addAll(aircraftButton,destroyerButton,battleshipButton,submarineButton,patrolBoatButton);
		
		Image reverseImage = new Image("file:///../resources/reverse_icon.png");
		ImageView reverseImageView = new ImageView(reverseImage);
		reverseImageView.setFitHeight(30);
		reverseImageView.setFitWidth(30);
		Button reverseButton = new Button();
		reverseButton.setId("reverseButton");
		reverseButton.setPrefHeight(40);
		reverseButton.setPrefWidth(130);
		reverseButton.setTranslateX(200);
		reverseButton.setTranslateY(280);
		reverseButton.setText("Horizontal");
		reverseButton.setTextAlignment(TextAlignment.RIGHT);
		reverseButton.setAlignment(Pos.BASELINE_LEFT);
		reverseButton.setId("shipBoardButton");
		reverseButton.setGraphic(reverseImageView);
		
		reverseButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String str = reverseButton.getText();
				if (str.equals("Horizontal")) {
					reverseButton.setText("Vertical");
				}
				else {
					reverseButton.setText("Horizontal");
				}
			}
		});
		
		
		shipBoardPane.getChildren().add(reverseButton);
		
		GridPane gridPane = new GridPane();
		gridPane.setTranslateX(70);
		gridPane.setTranslateY(345);
		gridPane.setPrefHeight(400);
		gridPane.setPrefWidth(400);
		
		buttonGrid = new Button[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			gridPane.getRowConstraints().add(new RowConstraints(50));
			for (int j = 0; j < numberOfColumns; j++) {
				gridPane.getColumnConstraints().add(new ColumnConstraints(50));
				
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.setId("seaButton");
				buttonGrid[i][j] = button;

				final int row = i;
				final int column = j;
				
				button.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
						String str = reverseButton.getText();
						ShipOrientation orientation;
						orientation = getOrientation(str);
						
						CommandStage2 cmd = (CommandStage2) Stage2.getInstance().getUIHandler().getCmd(); 
						if (cmd.getShipType() != null) {
							String id;
							Ship ship = ShipFactory.getInstance().create(new Coordinate(row, column), orientation,cmd.getShipType());
							if (Configurations.listOfPlayer.get(0).getBoard().canPlaceShip(new Coordinate(row, column)
									, orientation,ship)) {
								id = "seaButton";
								Stage2.getInstance().getUIHandler().updateCommand(Configurations.listOfPlayer.get(0)
										.getBoard().getCellAt(new Coordinate(row, column)));
								if (str == "Horizontal") {
									Stage2.getInstance().getUIHandler().updateCommand(ShipOrientation.HORIZONTAL);
								}
								else {
									Stage2.getInstance().getUIHandler().updateCommand(ShipOrientation.VERTICAL);
								}
							}
							else id = "shipBoardButton_INVALID";
							
							if (orientation == ShipOrientation.HORIZONTAL) {
								int columnBoundary = Math.min(column+ship.getLength(), numberOfColumns);
								for (int i=column; i < columnBoundary ; i++) {
									buttonGrid[row][i].setId(id);
								}
							}
							else {
								int rowBoundary = Math.min(row + ship.getLength(), numberOfRows);
								for (int i = row; i < rowBoundary; i++) {
									buttonGrid[i][column].setId(id);
								}
							}
						}
					}
				});
				
				button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						// TODO Auto-generated method stub
						String str = reverseButton.getText();
						ShipOrientation orientation;
						if (str.equals("Horizontal")) {
							orientation = ShipOrientation.HORIZONTAL;
						}
						else {
							orientation = ShipOrientation.VERTICAL;
						}
						
						CommandStage2 cmd = (CommandStage2) Stage2.getInstance().getUIHandler().getCmd(); 
						if (cmd.getShipType() != null) {
							String id;
							Ship ship = ShipFactory.getInstance().create(new Coordinate(row, column), orientation,cmd.getShipType());
							if (Configurations.listOfPlayer.get(0).getBoard().canPlaceShip(new Coordinate(row, column)
									, orientation,ship)) {
								id = "shipBoardButton_ENTERED";
							}
							else id = "shipBoardButton_INVALID";
							
							if (orientation == ShipOrientation.HORIZONTAL) {
								for (int i=column; i < Math.min(column+ship.getLength(), numberOfColumns); i++) {
									buttonGrid[row][i].setId(id);
								}
							}
							else {
								for (int i = row; i < Math.min(row + ship.getLength(), numberOfRows); i++) {
									buttonGrid[i][column].setId(id);
								}
							}
						}
					}
				});
				
				button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						// TODO Auto-generated method stub
						String str = reverseButton.getText();
						ShipOrientation orientation;
						orientation = getOrientation(str);
						
						CommandStage2 cmd = (CommandStage2) Stage2.getInstance().getUIHandler().getCmd(); 
						if (cmd.getShipType() != null) {
							Ship ship = ShipFactory.getInstance().create(new Coordinate(row, column), orientation,cmd.getShipType());
							
							if (orientation == ShipOrientation.HORIZONTAL) {
								for (int i=column; i < Math.min(column+ship.getLength(), numberOfColumns); i++) {
									buttonGrid[row][i].setId("seaButton");
								}
							}
							else {
								for (int i = row; i < Math.min(row + ship.getLength(), numberOfRows); i++) {
									buttonGrid[i][column].setId("seaButton");
								}
							}
						}
					}
				});
				
				gridPane.add(button, j, i);
			}
		}
		shipBoardPane.getChildren().add(gridPane);
		shipBoard.getChildren().addAll(shipBoardHeader,shipBoardPane);
	}
	
	private ShipOrientation getOrientation(String str) {
		ShipOrientation orientation;
		if (str.equals("Horizontal")) {
			orientation = ShipOrientation.HORIZONTAL;
		}
		else {
			orientation = ShipOrientation.VERTICAL;
		}
		return orientation;
	}

	public VBox getShipBoard() {
		return shipBoard;
	}
	
	public void displayShip(Coordinate coor, ShipOrientation orientation, ShipType shipType) {
		String filepath;
		filepath = "file:///../resources/" + Configurations.mapShipImage.get(shipType);
		if (orientation == ShipOrientation.HORIZONTAL) {
			filepath += "_hori.png";
		}
		else filepath += "_verti.png";
		
		System.out.println(filepath);
		System.out.println(70+coor.getCol()*50);
		System.out.println(345+coor.getRow()*50);
		Image image = new Image(filepath);
		ImageView imageView = new ImageView(image);
		imageView.setTranslateX(70+coor.getCol()*50);
		imageView.setTranslateY(345+coor.getRow()*50);
	
		shipBoardPane.getChildren().add(imageView);
	}
	
	
	public void disableShip(ShipType shipType) {
		if (shipType == ShipType.AIRCRAFT_CARRIER) aircraftButton.setDisable(true);
		if (shipType == ShipType.BATTLESHIP) battleshipButton.setDisable(true);
		if (shipType == ShipType.DESTROYER) destroyerButton.setDisable(true);
		if (shipType == ShipType.SUBMARINE) submarineButton.setDisable(true);
		if (shipType == ShipType.PATROL_BOAT) patrolBoatButton.setDisable(true);
	}
}
