package gui;

import Map.Stage;
import UnitBase.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class ViewStagePane extends HBox {

	public ViewStagePane(Stage stage) {

		this.setAlignment(Pos.CENTER_LEFT);
		this.setSpacing(30);

		Button backButton = new Button();
		ImageView view = new ImageView(new Image("arrow-left.png"));
		backButton
				.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		backButton.setMinSize(50, 100);
		backButton.setMaxSize(50, 100);
		view.setFitHeight(100);
		view.setFitWidth(50);
		backButton.setGraphic(view);
		backButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				backButton.setCursor(Cursor.HAND);
			}
		});
		backButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				backButton.setCursor(Cursor.DEFAULT);
			}
		});
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.viewAllyUnit();
			}
		});
		this.getChildren().add(backButton);

		for (int i = 0; i < stage.getNumberOfWave(); i++) {
			VBox pane = new VBox();
			pane.setMaxSize(350, 300);
			pane.setMinSize(350, 300);
			pane.setAlignment(Pos.BOTTOM_CENTER);
			pane.setSpacing(100);
			Label label = new Label("WAVE : " + (i + 1));
			label.setFont(new Font("Arial Black", 18));
			label.setTextFill(Color.ANTIQUEWHITE);
			Unit[] units = stage.getUnitAtWave(i);
			HBox unitsPane = new HBox();
			unitsPane.setSpacing(20);
			unitsPane.setAlignment(Pos.BOTTOM_CENTER);
			for (int j = 0; j < units.length; j++) {
				unitsPane.getChildren().add(getUnitButton(units[j]));
			}
			pane.getChildren().addAll(label, unitsPane);
			this.getChildren().add(pane);
		}

	}

	public Button getUnitButton(Unit unit) {
		Button unitButton = new Button();
		unitButton.setMaxSize(100, 150);
		unitButton.setMinSize(100, 150);
		unitButton.setAlignment(Pos.BOTTOM_CENTER);
		if (unit != null) {
			Image img = new Image(unit.getUrl());
			ImageView imgView = new ImageView(img);
			if (unit.getName().equals("Wyvern") || unit.getName().equals("Knight Enforcer")
					|| unit.getName().equals("Black Samurai") || unit.getName().equals("Demon King")) {
				imgView.setFitHeight(200);
				if (unit.getName().equals("Knight Enforcer") && unit.get_Class().equals("Lancer")) {
					imgView.setFitHeight(220);
				}
			} else if (unit.getName().equals("Sea Demon")) {
				imgView.setFitHeight(100);
			} else if (unit.getName().equals("Sphinx")) {
				imgView.setFitHeight(250);
			} else {
				imgView.setFitHeight(150);
			}
			imgView.setPreserveRatio(true);
			unitButton.setGraphic(imgView);
			unitButton.setBackground(
					new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		unitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				unitButton.setCursor(Cursor.HAND);
			}
		});
		unitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				unitButton.setCursor(Cursor.DEFAULT);
			}
		});
		unitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setSelectEnemyUnit(unit);
				GameController.updateEnemyInfoPanel();
			}
		});
		return unitButton;
	}

}
