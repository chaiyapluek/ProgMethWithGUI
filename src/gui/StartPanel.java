package gui;

import Application.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class StartPanel extends StackPane {

	private ImageView gameNameText;
	private VBox howToPlay;
	private VBox buttonPanel;

	public StartPanel() {

		this.setAlignment(Pos.CENTER);
		BackgroundImage sky = new BackgroundImage(new Image("BG_Sky.jpg", 1280, 720, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		this.setBackground(new Background(sky));

		VBox startPane = new VBox();
		startPane.setAlignment(Pos.TOP_CENTER);
		startPane.setPadding(new Insets(20));
		startPane.setSpacing(10);

		gameNameText = new ImageView(new Image("DungeonAdventure.png", 1100, 250, false, true));
		gameNameText.setPreserveRatio(true);

		StackPane mid = new StackPane();
		mid.setAlignment(Pos.TOP_CENTER);
		mid.setMaxSize(450, 400);
		mid.setMinSize(450, 400);

		buttonPanel = new VBox();
		buttonPanel.setAlignment(Pos.CENTER);
		buttonPanel.setSpacing(15);
		Button startButton = new Button("START");
		Button howButton = new Button("HOW TO PLAY");
		Button exitButton = new Button("EXIT");
		setButton(startButton);
		setButton(howButton);
		setButton(exitButton);
		startButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Main.createInitialScene();
				GameController.changeToInitialScene();
			}
		});
		howButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				howToPlay.setVisible(true);
				buttonPanel.setVisible(false);
			}
		});
		exitButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				GameController.stopSound();
				Main.getStage().close();
			}
		});
		setHowToPlay();
		buttonPanel.getChildren().addAll(startButton, howButton, exitButton);
		mid.getChildren().addAll(howToPlay,buttonPanel);
		howToPlay.setVisible(false);
		startPane.getChildren().addAll(gameNameText, mid);
		this.getChildren().add(startPane);
	}

	private void setButton(Button button) {
		button.setFont(Font.font("Bauhaus 93", 50));
		button.setTextFill(Color.ANTIQUEWHITE);
		button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				button.setTextFill(Color.ALICEBLUE);
				button.setFont(Font.font("Bauhaus 93", 55));
				button.setCursor(Cursor.HAND);
			}
		});
		button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				button.setTextFill(Color.ANTIQUEWHITE);
				button.setFont(Font.font("Bauhaus 93", 50));
				button.setCursor(Cursor.DEFAULT);
			}
		});
	}

	private void setHowToPlay() {
		howToPlay = new VBox();
		howToPlay.setMaxSize(450, 400);
		howToPlay.setMinSize(450, 400);
		howToPlay.setAlignment(Pos.TOP_CENTER);
		howToPlay.setPadding(new Insets(15));
		howToPlay.setSpacing(10);
		howToPlay.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, new CornerRadii(20), Insets.EMPTY)));
		BorderPane top = new BorderPane();
		
		Button back = new Button();
		GameController.setBackButton(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				howToPlay.setVisible(false);
				buttonPanel.setVisible(true);
			}
		});
		top.setRight(back);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setMaxSize(410, 300);
		scrollPane.setMinSize(410, 300);
		ImageView view = new ImageView(new Image("HowToPlay.png"));
		view.setFitWidth(400);
		view.setPreserveRatio(true);
		scrollPane.setContent(view);
		howToPlay.getChildren().addAll(top, scrollPane);
	}
}
