package UI.gui;

import java.io.IOException;
import java.util.ArrayList;

import UI.CommandStage3;
import UI.UI;
import gameBoard.Configurations;
import gameBoard.Coordinate;
import gameBoard.cell.Cell;
import gameBoard.cell.CellType;
import gameBoard.player.HumanPlayer;
import gameBoard.player.Player;
import gameStage.Stage3;
import gameStage.app;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class GUI implements UI {
	private VBox containerStage3;
	private OpponentBoard opponentBoardStage3;
	private WeaponPane weaponPaneStage3;
	private GameBoard gameBoardStage3;
	private Player player;

	public GUI(Player player) {
		// TODO Auto-generated constructor stub
		this.player = player;
	}

	public void createStage3() throws IOException {
		containerStage3 = new VBox();
		containerStage3.setPrefWidth(540);
		containerStage3.setPrefHeight(920);

		opponentBoardStage3 = new OpponentBoard();
		weaponPaneStage3 = new WeaponPane();
		gameBoardStage3 = new GameBoard();
		containerStage3.getChildren().addAll(opponentBoardStage3.getOpponentBoardPane(),
				gameBoardStage3.getGameBoardPane(), weaponPaneStage3.getWeaponPane());
	}

	public void enableInputStage3() {
		TranslateTransition translate = new TranslateTransition(Duration.millis(1000),
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
		System.out.println(cmd.getWeapon().getType());
		System.out.println(Configurations.mapWeaponImage.get(cmd.getWeapon().getType()));

		Image image = new Image(
				getClass().getResourceAsStream(Configurations.mapWeaponImage.get(cmd.getWeapon().getType())));
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
		translate.setToY(30+50 * cmd.getCell().getCoordinate().getRow() - 40);
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

	public void displayStage3(final CommandStage3 cmd,final ArrayList<Cell> listOfExplosion) {

		if ((Stage3.getInstance().getCurrentPlayer() instanceof HumanPlayer) == false) {
			Image weaponImage = new Image(
					getClass().getResourceAsStream(Configurations.mapWeaponImage.get(cmd.getWeapon().getType())));
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
			translate.setToY(30+50 * cmd.getCell().getCoordinate().getRow() - 20);
			translate.play();
			gameBoardStage3.getGameBoardPane().getChildren().add(weaponImageView);

			translate.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("yes");
					gameBoardStage3.getGameBoardPane().getChildren().remove(weaponImageView);
					final ArrayList<ImageView> listOfExplosionView = new ArrayList<>();

					for (int i = 0; i < listOfExplosion.size(); i++) {
						Image explosion = new Image(getClass().getResourceAsStream("explosion.gif"));
						ImageView explosionView = new ImageView(explosion);
						explosionView.setFitHeight(60);
						explosionView.setFitWidth(60);
						explosionView.setTranslateX(70 + listOfExplosion.get(i).getCoordinate().getCol() * 50);
						explosionView.setTranslateY(30+50 * listOfExplosion.get(i).getCoordinate().getRow() - 10);

						listOfExplosionView.add(explosionView);
						gameBoardStage3.getGameBoardPane().getChildren().add(explosionView);
					}

					PauseTransition pause = new PauseTransition(Duration.millis(700));
					pause.play();

					pause.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							for (int i = 0; i < listOfExplosionView.size(); i++) {
								gameBoardStage3.getGameBoardPane().getChildren().remove(listOfExplosionView.get(i));
							}

							for (int i = 0; i < listOfExplosion.size(); i++) {
								Image image = new Image(getClass().getResourceAsStream("flame.gif"));
								ImageView imageView = new ImageView(image);
								imageView.setFitHeight(50);
								imageView.setFitWidth(50);
								imageView.setTranslateX(70 + listOfExplosion.get(i).getCoordinate().getCol() * 50);
								imageView.setTranslateY(30+50 * listOfExplosion.get(i).getCoordinate().getRow() - 10);
								gameBoardStage3.getGameBoardPane().getChildren().add(imageView);
								Stage3.getInstance().displayFinish(cmd);
							}
						}
					});
				}
			});
		} else {
			for (int i = 0; i < listOfExplosion.size(); i++) {
				// System.out.println(listOfExplosion.get(i).getType());
				if (listOfExplosion.get(i).getType() == CellType.SHIP) {
					opponentBoardStage3.setButtonImage(listOfExplosion.get(i).getCoordinate().getRow(),
							listOfExplosion.get(i).getCoordinate().getCol(), true);
				} else {
					opponentBoardStage3.setButtonImage(listOfExplosion.get(i).getCoordinate().getRow(),
							listOfExplosion.get(i).getCoordinate().getCol(), false);
				}
			}
			Stage3.getInstance().displayFinish(cmd);
		}
	}

	public void switchPlayerStage3() {
		if (Stage3.getInstance().getCurrentPlayer() instanceof HumanPlayer) {
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
		}
		else {
			PauseTransition pause = new PauseTransition(Duration.millis(1000));
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

	public Player getPlayer() {
		return player;
	}

	public VBox getContainerStage3() {
		return containerStage3;
	}

}
