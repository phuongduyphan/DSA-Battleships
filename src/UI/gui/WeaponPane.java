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
import gameStage.app;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class WeaponPane {
	private BorderPane weaponPane;
	private ToggleButton shootButton;
	private ToggleButton bullet;
	private ToggleButton rocket;
	private ToggleButton verticalBomb;
	private ToggleButton horizontalBomb;
	
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
		
		bullet = new ToggleButton();
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
				app.getInstance().getCurrentState().getUIHandler().updateCommand(new BulletWeapon(WeaponType.BULLET_SHOT));
			}
		});
		
		rocket = new ToggleButton();
		rocket.setPrefHeight(80);
		rocket.setPrefWidth(110);
		image = new Image("file:///../resources/rocket-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(60);
		imageView.setFitWidth(60);
		rocket.setGraphic(imageView);
		rocket.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				app.getInstance().getCurrentState().getUIHandler().updateCommand(new RocketWeapon(WeaponType.ROCKET));
			}
		});
		
		verticalBomb = new ToggleButton();
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
				app.getInstance().getCurrentState().getUIHandler().updateCommand(new VerticalBombWeapon(WeaponType.VERTICAL_BOMBING));
			}
		});
		
		horizontalBomb = new ToggleButton();
		horizontalBomb.setPrefHeight(80);
		horizontalBomb.setPrefWidth(110);
		image = new Image("file:///../resources/hori-bomb-icon.png");
		imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(90);
		horizontalBomb.setGraphic(imageView);
		horizontalBomb.setDisable(true);
		horizontalBomb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				app.getInstance().getCurrentState().getUIHandler().updateCommand(new HorizontalBombWeapon(WeaponType.HORIZONTAL_BOMBING));
			}
		});
		
		ToggleGroup weaponGroup = new ToggleGroup();
		bullet.setToggleGroup(weaponGroup);
		rocket.setToggleGroup(weaponGroup);
		verticalBomb.setToggleGroup(weaponGroup);
		horizontalBomb.setToggleGroup(weaponGroup);
		
		selectWeaponPane.setPadding(new Insets(15,30,15,30));
		selectWeaponPane.setVgap(70);
		selectWeaponPane.setHgap(70);
		selectWeaponPane.getChildren().addAll(bullet,rocket,verticalBomb,horizontalBomb);
		
		disable();
	}
	
	public void disable() {
		shootButton.setDisable(true);
		bullet.setDisable(true);
		rocket.setDisable(true);
		verticalBomb.setDisable(true);
		horizontalBomb.setDisable(true);
	}
	
	public void enableWeapon(Player player) {
		for (int i=0; i < player.getListOfWeapon().size(); i++) {
			if (player.getListOfWeapon().get(i) instanceof BulletWeapon) bullet.setDisable(false);
			if (player.getListOfWeapon().get(i) instanceof RocketWeapon) rocket.setDisable(false);
			if (player.getListOfWeapon().get(i) instanceof VerticalBombWeapon) verticalBomb.setDisable(false);
			if (player.getListOfWeapon().get(i) instanceof HorizontalBombWeapon) horizontalBomb.setDisable(false);
		}
	}
	
	public void enableShootButton() {
		shootButton.setDisable(false);
	}

	public BorderPane getWeaponPane() {
		return weaponPane;
	}
}	
