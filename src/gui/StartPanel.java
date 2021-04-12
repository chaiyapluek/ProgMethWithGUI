package gui;

import java.io.File;

import Application.Main;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.GameController;

public class StartPanel extends VBox{
	private Text gameNameText;
	private Text space;
	private Text clickToContText;
	
	public StartPanel() {
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		BackgroundImage sky = new BackgroundImage(new Image("BG_Sky.jpg",1280,720,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(sky));
		
		setText();
		
		this.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				Main.createInitialScene();
				GameController.changeToInitialScene();
			}
		});
	}
	
	private void setText() {
		gameNameText = new Text();
		gameNameText.setText("[Game Name]");
		gameNameText.setFont(Font.font("Bauhaus 93",FontWeight.BOLD,140));
		gameNameText.setFill(Color.WHITE);
		
		space = new Text();
		space.setText("");
		space.setFont(Font.font("Bauhaus 93",FontWeight.BOLD,140));
		
		clickToContText = new Text();
		clickToContText.setText("- CLICK TO CONTINUE -");
		clickToContText.setFont(Font.font("Bauhaus 93",50));
		clickToContText.setFill(Color.WHITE);
		
		this.getChildren().addAll(gameNameText, space, clickToContText);
	}
}
