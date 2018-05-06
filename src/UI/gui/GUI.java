package UI.gui;

import java.io.IOException;
import java.util.ArrayList;

import UI.CommandStage2;
import UI.CommandStage3;
import UI.UI;
import gameBoard.Configurations;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameBoard.ship.Ship;
import gameStage.Stage3;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class GUI implements UI {
	private StackPane containerStage1;
	private VBox containerStage2;
	private ShipBoard shipBoardStage2;
	private StackPane containerStage3;
	private OpponentBoard opponentBoardStage3;
	private WeaponPane weaponPaneStage3;
	private GameBoard gameBoardStage3;
	private StackPane containerStage4;
	private Player player;

	public GUI(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
	}
	
	public void createStage1() throws IOException {
		MenuBoard menuBoard = new MenuBoard();
		containerStage1 = menuBoard.getMenuBoard();
	}
	
	public void createStage2() throws IOException {
		containerStage2 = new VBox();
		containerStage2.setPrefWidth(540);
		containerStage2.setPrefHeight(920);
		
		shipBoardStage2 = new ShipBoard();
		containerStage2.getChildren().add(shipBoardStage2.getShipBoard());
	}
	
	public void disableShipStage2(CommandStage2 cmd) {
		shipBoardStage2.disableShip(cmd.getShipType());
	}
	
	public void displayShipStage2(CommandStage2 cmd) {
		shipBoardStage2.displayShip(cmd.getCell().getCoordinate(),cmd.getOrientation(),cmd.getShipType());
	}

	public void createStage3() throws IOException {
		containerStage3 = new StackPane();
		containerStage3.setPrefWidth(540);
		containerStage3.setPrefHeight(920);
		containerStage3.setMinHeight(Region.USE_PREF_SIZE);
		containerStage3.setMinWidth(Region.USE_PREF_SIZE);
		containerStage3.setMaxHeight(Region.USE_PREF_SIZE);
		containerStage3.setMaxWidth(Region.USE_PREF_SIZE);
		
		VBox containerTemp = new VBox();
		containerTemp.setPrefHeight(920);
		containerTemp.setPrefWidth(540);	
		containerTemp.setMinHeight(Region.USE_PREF_SIZE);
		containerTemp.setMinWidth(Region.USE_PREF_SIZE);
		containerTemp.setMaxHeight(Region.USE_PREF_SIZE);
		containerTemp.setMaxWidth(Region.USE_PREF_SIZE);

		opponentBoardStage3 = new OpponentBoard();
		weaponPaneStage3 = new WeaponPane();
		gameBoardStage3 = new GameBoard(player.getBoard());
		containerTemp.getChildren().addAll(opponentBoardStage3.getOpponentBoardPane(),
				gameBoardStage3.getGameBoardPane(), weaponPaneStage3.getWeaponPane());
		containerStage3.getChildren().add(containerTemp);
	}

	public void enableInputStage3() {
		TranslateTransition translate = new TranslateTransition(Duration.millis(700),
				weaponPaneStage3.getWeaponPane());
		translate.setByY(1);
		translate.setFromY(0);
		translate.setToY(-460);
		translate.play();

		opponentBoardStage3.enable();
		weaponPaneStage3.enableWeapon(player);
	}

	public void enableShootStage3() {
		weaponPaneStage3.enableShootButton();
	}

	public void shootStage3(final CommandStage3 cmd) {
		Image image = new Image("file:///../resources/" + Configurations.mapWeaponImage.get(cmd.getWeapon().getType()));
		final ImageView imageView = new ImageView(image);
		imageView.setFitHeight(50);
		imageView.setFitWidth(50);
		imageView.setTranslateX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		imageView.setTranslateY(-50);

		TranslateTransition translate = new TranslateTransition(Duration.millis(400), imageView);
		translate.setByY(1);
		translate.setFromX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		translate.setFromY(-50);
		translate.setToX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		translate.setToY(30 + 50 * cmd.getCell().getCoordinate().getRow() - 40);
		translate.play();
		opponentBoardStage3.getOpponentBoardPane().getChildren().add(imageView);

		translate.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				opponentBoardStage3.getOpponentBoardPane().getChildren().remove(imageView);
				CommandStage3 cmdTemp = cmd;
				Stage3.getInstance().processInput(cmdTemp);
			}
		});
	}

	public void displayStage3(final CommandStage3 cmd, final ArrayList<Cell> listOfTargetableCells,ArrayList<Ship> listOfDestroyedShips) {

		if (!(Stage3.getInstance().getCurrentPlayer() instanceof HumanPlayer)) {
			setEffectShootingPlayer(cmd, listOfTargetableCells);
		} else {
			setEffectShootingOpponent(cmd, listOfTargetableCells, listOfDestroyedShips);
		}
	}

	private void setEffectShootingOpponent(final CommandStage3 cmd, final ArrayList<Cell> listOfTargetableCells,
			ArrayList<Ship> listOfDestroyedShips) {
		for (int i = 0; i < listOfTargetableCells.size(); i++) {
			if (listOfTargetableCells.get(i).getType() == CellType.SHIP) {
				opponentBoardStage3.setButtonImage(listOfTargetableCells.get(i).getCoordinate().getRow(),
						listOfTargetableCells.get(i).getCoordinate().getCol(), true);
			} else {
				opponentBoardStage3.setButtonImage(listOfTargetableCells.get(i).getCoordinate().getRow(),
						listOfTargetableCells.get(i).getCoordinate().getCol(), false);
			}
		}
		for (int i = 0; i < listOfDestroyedShips.size(); i++) {
			opponentBoardStage3.setDestroyedShips(listOfDestroyedShips.get(i));
		}
		Stage3.getInstance().displayFinish(cmd);
	}

	private void setEffectShootingPlayer(final CommandStage3 cmd, final ArrayList<Cell> listOfTargetableCells) {
		Image weaponImage = new Image(
				"file:///../resources/" + Configurations.mapWeaponImage.get(cmd.getWeapon().getType()));
		final ImageView weaponImageView = new ImageView(weaponImage);
		weaponImageView.setFitHeight(50);
		weaponImageView.setFitWidth(50);
		weaponImageView.setTranslateX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		weaponImageView.setTranslateY(-460 - 50);

		TranslateTransition translate = new TranslateTransition(Duration.millis(1000), weaponImageView);
		translate.setByY(1);
		translate.setFromX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		translate.setFromY(-460 - 50);
		translate.setToX(70 + cmd.getCell().getCoordinate().getCol() * 50);
		translate.setToY(30 + 50 * cmd.getCell().getCoordinate().getRow() - 20);
		translate.play();
		gameBoardStage3.getGameBoardPane().getChildren().add(weaponImageView);

		translate.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				gameBoardStage3.getGameBoardPane().getChildren().remove(weaponImageView);
				final ArrayList<ImageView> listOfExplosionView = new ArrayList<>();

				for (int i = 0; i < listOfTargetableCells.size(); i++) {
					Image explosion = new Image("file:///../resources/explosion.gif");
					ImageView explosionView = new ImageView(explosion);
					explosionView.setFitHeight(60);
					explosionView.setFitWidth(60);
					explosionView.setTranslateX(70 + listOfTargetableCells.get(i).getCoordinate().getCol() * 50);
					explosionView.setTranslateY(30 + 50 * listOfTargetableCells.get(i).getCoordinate().getRow() - 10);

					listOfExplosionView.add(explosionView);
					gameBoardStage3.getGameBoardPane().getChildren().add(explosionView);
				}

				setPauseTransitionBeforeExplosion(cmd, listOfTargetableCells, listOfExplosionView);
			}
		});
	}
	
	private void setPauseTransitionBeforeExplosion(final CommandStage3 cmd,
			final ArrayList<Cell> listOfTargetableCells, final ArrayList<ImageView> listOfExplosionView) {
		PauseTransition pause = new PauseTransition(Duration.millis(500));
		pause.play();

		pause.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for (int i = 0; i < listOfExplosionView.size(); i++) {
					gameBoardStage3.getGameBoardPane().getChildren().remove(listOfExplosionView.get(i));
				}

				for (int i = 0; i < listOfTargetableCells.size(); i++) {
					Image image;
					ImageView imageView;
					if (listOfTargetableCells.get(i).getType() == CellType.SHIP) {
						image = new Image("file:///../resources/flame.gif");
						imageView = new ImageView(image);
						imageView.setTranslateX(70 + listOfTargetableCells.get(i).getCoordinate().getCol() * 50);
						imageView.setTranslateY(30 + 50 * listOfTargetableCells.get(i).getCoordinate().getRow() - 10);
						imageView.setFitHeight(50);
						imageView.setFitWidth(50);
						gameBoardStage3.getGameBoardPane().getChildren().add(imageView);
					}
					else {
						gameBoardStage3.getButtonGrid()
						[listOfTargetableCells.get(i).getCoordinate().getRow()][listOfTargetableCells.get(i).getCoordinate().getCol()].setId("missCoorGameBoard");
					}
				}
				Stage3.getInstance().displayFinish(cmd);
			}
		});
	}

	public void switchPlayerStage3() {
		if (Stage3.getInstance().getCurrentPlayer() instanceof HumanPlayer) {
			opponentBoardStage3.disable();
			TranslateTransition translate = new TranslateTransition(Duration.millis(1000),
					weaponPaneStage3.getWeaponPane());
			translate.setByY(1);
			translate.setFromY(-460);
			translate.setToY(0);
			translate.play();
			translate.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Stage3.getInstance().switchPlayerFinish();

				}
			});
		} else {
			PauseTransition pause = new PauseTransition(Duration.millis(800));
			pause.play();

			pause.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					Stage3.getInstance().switchPlayerFinish();
				}
			});
		}
	}
	
	public void displayStatusStage3(boolean status) {
		Pane layer = new Pane();
		layer.setPrefHeight(920);
		layer.setPrefWidth(540);	
		layer.setMinHeight(Region.USE_PREF_SIZE);
		layer.setMinWidth(Region.USE_PREF_SIZE);
		layer.setMaxHeight(Region.USE_PREF_SIZE);
		layer.setMaxWidth(Region.USE_PREF_SIZE);
		layer.setId("statusLayer");
		
		Label label = new Label();
		label.setPrefHeight(100);
		label.setPrefWidth(350);
		label.setTranslateX(45);
		if (status) {
			label.setText("YOU WIN !!!");
			label.setId("winLabel");
		}
		else {
			label.setText("YOU LOSE !!!");
			label.setId("loseLabel");
			opponentBoardStage3.displayRemainingShips(Configurations.listOfPlayer.get(1));
		}
		
		TranslateTransition translate = new TranslateTransition(Duration.millis(500),label);
		translate.setFromY(460);
		translate.setToY(-200);
		translate.setByY(1);
		translate.play();
		containerStage3.getChildren().addAll(layer,label);
		
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				PauseTransition pause = new PauseTransition(Duration.millis(3000));
				pause.play();
				pause.setOnFinished(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						Stage3.getInstance().done();
					}
				});
			}
		});
	}
	
	public void createStage4() {
		containerStage4 = new StackPane();
		OptionBoard optionBoard = new OptionBoard();
		containerStage4 = optionBoard.getOptionBoard();
	}

	public Player getPlayer() {
		return player;
	}

	public StackPane getContainerStage1() {
		return containerStage1;
	}
	
	public VBox getContainerStage2() {
		return containerStage2;
	}

	public StackPane getContainerStage3() {
		return containerStage3;
	}

	public WeaponPane getWeaponPaneStage3() {
		return weaponPaneStage3;
	}

	public StackPane getContainerStage4() {
		return containerStage4;
	}
	
}
