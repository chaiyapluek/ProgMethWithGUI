package gui;

import Item.Gear;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class GearButton extends Button {

	private Gear gear;
	private int type;

	public GearButton(int type) {
		this.type = type;
		this.setAlignment(Pos.CENTER);
		this.setMaxSize(75, 100);
		this.setMinSize(75, 100);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		this.setFont(new Font("Arial", 12));
		this.setTextFill(Color.BLACK);
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setOnEnter();
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setOnExit();
			}
		});
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (gear != null && !GameController.getOnBattle()) {
					GameController.setSelectItem(gear);
					GameController.showItemInfo(true, gear, false, false, false);
				}
			}
		});
		update();
	}

	private void setOnEnter() {
		if (!GameController.getOnBattle() && gear != null) {
			this.setCursor(Cursor.HAND);
		}
	}

	private void setOnExit() {
		this.setCursor(Cursor.DEFAULT);
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}

	public Gear getGear() {
		return gear;
	}

	public void update() {
		this.setGraphic(null);
		if (gear != null) {
			this.setText("");
			Image img = new Image(gear.getUrl());
			ImageView view = new ImageView(img);
			view.setPreserveRatio(true);
			view.setFitWidth(60);
			this.setGraphic(view);
		} else {
			if (type == 0) {
				this.setText("Weapon");
			} else if (type == 1) {
				this.setText("Helmet");
			} else if (type == 2) {
				this.setText("Armor");
			} else if (type == 3) {
				this.setText("Leggings");
			} else if (type == 4) {
				this.setText("Boots");
			}
		}
	}

}
