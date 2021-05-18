package gui;

import Item.Item;
import Item.Potion;
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
import javafx.scene.text.Font;
import logic.GameController;

public class InfoItem extends StackPane {

	private HBox info;
	private VBox text;
	private Label name;
	private Label des;
	private Label potionAmount;
	private StackPane pic;
	private VBox pane;

	private HBox potionButtons;
	private HBox gearButtons;

	public InfoItem() {
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

		pane = new VBox();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setSpacing(20);
		pane.setPadding(new Insets(15));
		pane.setMinSize(600, 320);
		pane.setMaxSize(600, 320);
		BorderPane top = new BorderPane();
		Label label = new Label("Item Information");
		label.setStyle("-fx-font-size: 24px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Button back = new Button("X");
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.showItemInfo(false, null, true, true);
			}
		});

		info = new HBox();
		info.setAlignment(Pos.CENTER_LEFT);
		info.setSpacing(25);
		info.setPadding(new Insets(15));
		info.setMinSize(500, 150);
		info.setMaxSize(500, 150);
		info.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		VBox text = new VBox();
		text.setSpacing(15);
		name = new Label();
		des = new Label();
		potionAmount = new Label();
		name.setFont(new Font("Berlin Sans FB", 20));
		des.setFont(new Font("Berlin Sans FB", 14));
		potionAmount.setFont(new Font("Berlin Sans FB", 14));
		text.getChildren().addAll(name, des, potionAmount);
		potionAmount.setVisible(false);

		pic = new StackPane();
		pic.setMinSize(100, 100);
		pic.setMaxSize(100, 100);
		info.getChildren().addAll(pic, text);

		pane.getChildren().addAll(top, info);

		potionButtons = new HBox();
		potionButtons.setSpacing(10);
		potionButtons.setAlignment(Pos.CENTER);
		Button use = new Button("USE");
		Button cancel = new Button("CANCEL");
		setUpButton(use);
		setUpButton(cancel);
		potionButtons.getChildren().addAll(use, cancel);

		gearButtons = new HBox();
		gearButtons.setSpacing(10);
		gearButtons.setAlignment(Pos.CENTER);
		Button equip = new Button("EQUIP");
		Button discard = new Button("DISCARD");
		Button cancel2 = new Button("CANCEL");
		setUpButton(equip);
		setUpButton(discard);
		setUpButton(cancel2);
		gearButtons.getChildren().addAll(equip, discard, cancel2);
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.showItemInfo(false, null, true, true);
			}
		
		});
		cancel2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.showItemInfo(false, null, true, true);
			}
		
		});
		use.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		
		});
		discard.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		
		});

		this.getChildren().addAll(bg, pane);
	}

	public void setUpButton(Button button) {
		button.setMinSize(150, 34);
		button.setMaxSize(150, 34);
		button.setFont(new Font("Berlin Sans FB", 20));
	}

	public void showButtons(boolean isPotion) {
		if (isPotion) {
			pane.getChildren().add(potionButtons);
		} else {
			pane.getChildren().add(gearButtons);
		}
	}

	public void removeButton() {
		pane.getChildren().remove(potionButtons);
		pane.getChildren().remove(gearButtons);
	}

	public void update(Item item, boolean onShop, boolean isPotion) {

		Image img = new Image(item.getUrl());
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(100);
		imgView.setPreserveRatio(true);
		pic.getChildren().clear();
		pic.getChildren().add(imgView);
		name.setText(item.getName());
		des.setText(item.getDescription());
		if(!onShop && isPotion) {
			potionAmount.setVisible(true);
			potionAmount.setText("Amount : " + ((Potion)item).getNumberOfPotion());
		}else {
			potionAmount.setVisible(false);
		}

	}

}
