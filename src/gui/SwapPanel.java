package gui;

import Unit.AllyUnit;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.BattleController;
import logic.GameController;

public class SwapPanel extends StackPane {

	private HBox buttons;
	private boolean isFront;

	public SwapPanel() {

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
		Label label = new Label("Select Target to Swap");
		label.setStyle("-fx-font-size: 24px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Button back = new Button();
		GameController.setBackButton(back);
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setSwapPanel(false);
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
		isFront = false;
		for (AllyUnit u : GameController.getPlayer().getUnits()) {
			if (u == null || u.getIsDead()) {
				continue;
			}
			if (GameController.getSelectAllyUnit().equals(u)) {
				isFront = true;
				break;
			}
		}
		for (int j = 2; j >= 0; j--) {
			AllyUnit u;
			if (isFront) {
				u = GameController.getPlayer().getBackUnits()[j];
			} else {
				u = GameController.getPlayer().getUnits()[j];
			}
			if (u == null || u.getIsDead()) {
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
					int sourceIdx = 0;
					int targetIdx = 0;
					for (int i = 0; i < 3; i++) {
						if (isFront) {
							if (GameController.getSelectAllyUnit().equals(GameController.getPlayer().getUnits()[i])) {
								sourceIdx = i;
							}
							if (u.equals(GameController.getPlayer().getBackUnits()[i])) {
								targetIdx = i;
							}
						} else {
							if (GameController.getSelectAllyUnit()
									.equals(GameController.getPlayer().getBackUnits()[i])) {
								sourceIdx = i;
							}
							if (u.equals(GameController.getPlayer().getUnits()[i])) {
								targetIdx = i;
							}
						}
					}
					if (isFront) {
						AllyUnit temp = GameController.getPlayer().getUnits()[sourceIdx];
						GameController.getPlayer().getUnits()[sourceIdx] = GameController.getPlayer()
								.getBackUnits()[targetIdx];
						GameController.getPlayer().getBackUnits()[targetIdx] = temp;
						GameController.setSelectAllyUnit(GameController.getPlayer().getUnits()[sourceIdx]);
					} else {
						AllyUnit temp = GameController.getPlayer().getBackUnits()[sourceIdx];
						GameController.getPlayer().getBackUnits()[sourceIdx] = GameController.getPlayer()
								.getUnits()[targetIdx];
						GameController.getPlayer().getUnits()[targetIdx] = temp;
						GameController.setSelectAllyUnit(GameController.getPlayer().getBackUnits()[sourceIdx]);
					}
					if (GameController.getOnBattle()) {
						BattleController.increaseNumberOfTakenAction();
						GameController.getSelectAllyUnit().setCanTakeAction(false);
						BattleController.swap();
					} else {
						GameController.updateAllyView();
					}
					GameController.setSwapPanel(false);
					GameController.updateAllyInfo();
					GameController.setChooseIcon();
				}
			});
			buttons.getChildren().add(button);
		}
	}

}
