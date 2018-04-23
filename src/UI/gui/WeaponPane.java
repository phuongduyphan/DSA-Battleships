package UI.gui;

import java.io.IOException;

import UI.UIHandlerStage3;
import gameBoard.player.Player;
import gameBoard.weapon.BulletWeapon;
import gameBoard.weapon.HorizontalBombWeapon;
import gameBoard.weapon.RocketWeapon;
import gameBoard.weapon.VerticalBombWeapon;
import gameBoard.weapon.WeaponType;
import gameStage.Stage3;
import gameStage.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class WeaponPane {
	private BorderPane weaponPane;
	private ToggleButton shootButton;
	private VBox bulletPane;
	private VBox rocketPane;
	private VBox verticalBombPane;
	private VBox horizontalBombPane;
	
	public WeaponPane() throws IOException {
		FXMLLoader weaponLoader = new FXMLLoader(getClass().getResource("WeaponPane.fxml"));
		weaponPane = weaponLoader.load();
		
		StackPane shootPane = new StackPane();
		shootPane.setPrefHeight(160);
		shootPane.setPrefWidth(540);
		shootPane.setId("shootPane");
		
		FlowPane selectWeaponPane = new FlowPane();
		selectWeaponPane.setPrefHeight(300);
		selectWeaponPane.setPrefWidth(540);
		selectWeaponPane.setId("selectWeaponPane");
		
		weaponPane.setTop(shootPane);
		weaponPane.setBottom(selectWeaponPane);
		
		shootButton = new ToggleButton();
		shootButton.setId("shootButton");
		shootButton.setShape(new Circle(130));
		shootButton.setMinSize(130, 130);
		shootButton.setMaxSize(130, 130);
		shootButton.setStyle("-fx-base:red");
		shootButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				UIHandlerStage3 uiHandler = (UIHandlerStage3) Stage3.getInstance().getUIHandler();
				uiHandler.shoot();
			}
		});

		Image image = new Image("file:///../resources/shoot-icon.png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(100);
		imageView.setFitWidth(100);
		shootButton.setGraphic(imageView);
		shootPane.setAlignment(Pos.CENTER);
		shootPane.getChildren().add(shootButton);
		
		bulletPane = new VBox();
		bulletPane.setPrefHeight(100);
		bulletPane.setPrefWidth(110);
		bulletPane.setMinHeight(Region.USE_PREF_SIZE);
		bulletPane.setMinWidth(Region.USE_PREF_SIZE);
		bulletPane.setMaxHeight(Region.USE_PREF_SIZE);
		bulletPane.setMaxWidth(Region.USE_PREF_SIZE);
		
		ToggleButton bullet = new ToggleButton();
		bullet.setPrefHeight(80);
		bullet.setPrefWidth(110);
		image = new Image("file:///../resources/bullet-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		bullet.setGraphic(imageView);
		bullet.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				App.getInstance().getCurrentState().getUIHandler()
				.updateCommand(Stage3.getInstance().getCurrentPlayer().findWeapon(WeaponType.BULLET_SHOT));
			}
		});
		Label bulletLabel = new Label();
		bulletLabel.setAlignment(Pos.CENTER);
		bulletLabel.setId("weaponRemainLabel");
		bulletLabel.setPrefWidth(110);
		bulletPane.getChildren().addAll(bullet,bulletLabel);
		
		rocketPane = new VBox();
		rocketPane.setPrefHeight(100);
		rocketPane.setPrefWidth(110);
		rocketPane.setMinHeight(Region.USE_PREF_SIZE);
		rocketPane.setMinWidth(Region.USE_PREF_SIZE);
		rocketPane.setMaxHeight(Region.USE_PREF_SIZE);
		rocketPane.setMaxWidth(Region.USE_PREF_SIZE);
		
		ToggleButton rocket = new ToggleButton();
		rocket.setPrefHeight(80);
		rocket.setPrefWidth(110);
		image = new Image("file:///../resources/rocket-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		rocket.setGraphic(imageView);
		rocket.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				App.getInstance().getCurrentState().getUIHandler()
				.updateCommand(Stage3.getInstance().getCurrentPlayer().findWeapon(WeaponType.ROCKET));
			}
		});
		Label rocketLabel = new Label();
		rocketLabel.setAlignment(Pos.CENTER);
		rocketLabel.setId("weaponRemainLabel");
		rocketLabel.setPrefWidth(110);
		rocketPane.getChildren().addAll(rocket,rocketLabel);
		
		verticalBombPane = new VBox();
		verticalBombPane.setPrefHeight(100);
		verticalBombPane.setPrefWidth(110);
		verticalBombPane.setMinHeight(Region.USE_PREF_SIZE);
		verticalBombPane.setMinWidth(Region.USE_PREF_SIZE);
		verticalBombPane.setMaxHeight(Region.USE_PREF_SIZE);
		verticalBombPane.setMaxWidth(Region.USE_PREF_SIZE);
		
		ToggleButton verticalBomb = new ToggleButton();
		verticalBomb.setPrefHeight(80);
		verticalBomb.setPrefWidth(110);
		image = new Image("file:///../resources/verti-bomb-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(70);
		imageView.setFitWidth(23);
		verticalBomb.setGraphic(imageView);
		verticalBomb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				App.getInstance().getCurrentState().getUIHandler()
				.updateCommand(Stage3.getInstance().getCurrentPlayer().findWeapon(WeaponType.VERTICAL_BOMBING));
			}
		});
		Label verticalBombLabel = new Label();
		verticalBombLabel.setAlignment(Pos.CENTER);
		verticalBombLabel.setId("weaponRemainLabel");
		verticalBombLabel.setPrefWidth(110);
		verticalBombPane.getChildren().addAll(verticalBomb,verticalBombLabel);
		
		horizontalBombPane = new VBox();
		horizontalBombPane.setPrefHeight(100);
		horizontalBombPane.setPrefWidth(110);
		horizontalBombPane.setMinHeight(Region.USE_PREF_SIZE);
		horizontalBombPane.setMinWidth(Region.USE_PREF_SIZE);
		horizontalBombPane.setMaxHeight(Region.USE_PREF_SIZE);
		horizontalBombPane.setMaxWidth(Region.USE_PREF_SIZE);
		
		ToggleButton horizontalBomb = new ToggleButton();
		horizontalBomb.setPrefHeight(80);
		horizontalBomb.setPrefWidth(110);
		image = new Image("file:///../resources/hori-bomb-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(90);
		horizontalBomb.setGraphic(imageView);
		horizontalBomb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				App.getInstance().getCurrentState().getUIHandler()
				.updateCommand(Stage3.getInstance().getCurrentPlayer().findWeapon(WeaponType.HORIZONTAL_BOMBING));
			}
		});
		Label horizontalBombLabel = new Label();
		horizontalBombLabel.setAlignment(Pos.CENTER);
		horizontalBombLabel.setId("weaponRemainLabel");
		horizontalBombLabel.setPrefWidth(110);
		horizontalBombPane.getChildren().addAll(horizontalBomb,horizontalBombLabel);
		
		ToggleGroup weaponGroup = new ToggleGroup();
		bullet.setToggleGroup(weaponGroup);
		rocket.setToggleGroup(weaponGroup);
		verticalBomb.setToggleGroup(weaponGroup);
		horizontalBomb.setToggleGroup(weaponGroup);
		
		selectWeaponPane.setPadding(new Insets(15,30,15,30));
		selectWeaponPane.setVgap(60);
		selectWeaponPane.setHgap(70);
		selectWeaponPane.getChildren().addAll(bulletPane,rocketPane,verticalBombPane,horizontalBombPane);
	}
	
	public void unselected() {
		shootButton.setSelected(false);
		shootButton.setDisable(true);
		((ToggleButton) bulletPane.getChildren().get(0)).setSelected(false);
		((ToggleButton) rocketPane.getChildren().get(0)).setSelected(false);
		((ToggleButton) verticalBombPane.getChildren().get(0)).setSelected(false);
		((ToggleButton) horizontalBombPane.getChildren().get(0)).setSelected(false);
	}
	
	public void enableWeapon(Player player) {
		bulletPane.getChildren().get(0).setDisable(true);
		rocketPane.getChildren().get(0).setDisable(true);
		verticalBombPane.getChildren().get(0).setDisable(true);
		horizontalBombPane.getChildren().get(0).setDisable(true);
		
		updateWeaponLabel(rocketPane,0);
		updateWeaponLabel(verticalBombPane,0);
		updateWeaponLabel(horizontalBombPane,0);
		
		System.out.println(player);
		System.out.println(player.getListOfWeapon().size());
		for (int i=0; i < player.getListOfWeapon().size(); i++) {
			System.out.println(player.getListOfWeapon().get(i));
		}
		for (int i=0; i < player.getListOfWeapon().size(); i++) {
			if (player.getListOfWeapon().get(i) instanceof BulletWeapon) {
				bulletPane.getChildren().get(0).setDisable(false);
			}
			if (player.getListOfWeapon().get(i) instanceof RocketWeapon) {
				rocketPane.getChildren().get(0).setDisable(false);
				updateWeaponLabel(rocketPane,player.getListOfWeapon().get(i).getNumberOfWeapon());
			}
			if (player.getListOfWeapon().get(i) instanceof VerticalBombWeapon) {
				verticalBombPane.getChildren().get(0).setDisable(false);
				updateWeaponLabel(verticalBombPane,player.getListOfWeapon().get(i).getNumberOfWeapon());
			}
			if (player.getListOfWeapon().get(i) instanceof HorizontalBombWeapon) {
				horizontalBombPane.getChildren().get(0).setDisable(false);
				updateWeaponLabel(horizontalBombPane,player.getListOfWeapon().get(i).getNumberOfWeapon());
			}
		}
	}
	
	public void updateWeaponLabel(VBox Pane, Integer number) {
		((Labeled) Pane.getChildren().get(1)).setText(number.toString());
	}
	
	public void enableShootButton() {
		shootButton.setDisable(false);
	}

	public BorderPane getWeaponPane() {
		return weaponPane;
	}
}	
