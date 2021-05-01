package gui;

import UnitBase.AllyUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class ReplacePanel extends StackPane {

	private HBox buttons;

	public ReplacePanel() {

		this.setMinSize(1280, 720);
		this.setMaxSize(1280, 720);
		this.setAlignment(Pos.CENTER);

		Image black = new Image("black.jpg");
		ImageView blackView = new ImageView(black);
		blackView.setOpacity(0.8);
		blackView.setFitWidth(1440);
		blackView.setPreserveRatio(true);
		Pane bg = new Pane();
		bg.getChildren().add(blackView);

		VBox pane = new VBox();
		pane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setSpacing(50);
		pane.setPadding(new Insets(15));
		pane.setMinSize(600, 300);
		pane.setMaxSize(600, 300);
		BorderPane top = new BorderPane();
		Label label = new Label("Select Unit to Replace");
		label.setFont(Font.font("Berlin Sans FB", 36));
		Button back = new Button("X");
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setReplacePanel(false);
			}
		});

		buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(25);
		update();

		pane.getChildren().addAll(top, buttons);
		this.getChildren().addAll(bg, pane);
	}

	public void update() {

		buttons.getChildren().clear();
		
		if (GameController.getDeathUnit() == null) {
			return;
		}

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		Button button = new Button();
		Image img = new Image(GameController.getDeathUnit().getIconUrl());
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(85);
		imgView.setPreserveRatio(true);
		button.setGraphic(imgView);
		Label label = new Label("<<");
		label.setFont(Font.font("Berlin Sans FB", 56));
		box.getChildren().addAll(button, label);

		buttons.getChildren().add(box);
		for (int i = 2; i >= 0; i--) {
			AllyUnit unit = GameController.getPlayer().getBackUnits()[i];
			if (unit == null) {
				continue;
			}
			button = new Button();
			img = new Image(unit.getIconUrl());
			imgView = new ImageView(img);
			imgView.setFitWidth(85);
			imgView.setPreserveRatio(true);
			button.setGraphic(imgView);
		
			buttons.getChildren().add(button);
		}

	}

}
