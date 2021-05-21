package gui;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.BattleController;
import logic.GameController;

public class RewardPane extends StackPane {

	private Label text;

	public RewardPane() {

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
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setSpacing(10);
		pane.setPadding(new Insets(10));
		pane.setMinSize(600, 150);
		pane.setMaxSize(600, 150);
		BorderPane top = new BorderPane();
		Label label = new Label("Reward");
		label.setStyle("-fx-font-size: 24px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Button back = new Button();
		GameController.setBackButton(back);
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				BattleController.reset();
				GameController.showReward(false);
			}
		});

		text = new Label();
		text.setFont(new Font("Berlin Sans FB", 24));
		pane.getChildren().addAll(top, text);
		this.getChildren().addAll(bg, pane);
	}

	public void setText() {
		int money = GameController.getPlayer().getMoney();
		int drop = GameController.getNowStage().getMoneyDrop();
		text.setText("Money : " + (money) + " (+" + drop + ")");
	}
}
