package gui;

import Unit.AllyUnit;
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
import logic.BattleController;
import logic.GameController;

public class SelectTargetSkillPanel extends StackPane {

	private HBox buttons;
	
	public SelectTargetSkillPanel() {

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
		pane.setBackground(
				new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setSpacing(50);
		pane.setPadding(new Insets(15));
		pane.setMinSize(600, 300);
		pane.setMaxSize(600, 300);
		BorderPane top = new BorderPane();
		Label label = new Label("Select Target");
		label.setStyle("-fx-font-size: 24px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Button back = new Button();
		GameController.setBackButton(back);
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setSelectTarget(false);
			}
		});
		
		buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(25);
		update();

		pane.getChildren().addAll(top,buttons);
		this.getChildren().addAll(bg,pane);
		
	}

	public void update() {
		buttons.getChildren().clear();
		for (int i = 2; i >= 0; i--) {
			AllyUnit u = GameController.getPlayer().getUnits()[i];
			if(u == null || u.getIsDead()) {
				continue;
			}
			Button button = new Button();
			Image img = new Image(u.getIconUrl());
			ImageView imgView = new ImageView(img);
			imgView.setFitWidth(100);
			imgView.setPreserveRatio(true);
			button.setGraphic(imgView);
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					BattleController.useSkillTo(u);
					BattleController.afterTakeAction();
					GameController.updateBattlePanel();
					GameController.updateAllyInfo();
					GameController.setSelectTarget(false);
				}
			});
			buttons.getChildren().add(button);
		}
	}
	
}
