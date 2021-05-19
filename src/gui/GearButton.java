package gui;

import Item.Gear;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.GameController;

public class GearButton extends Button {

	private Gear gear;

	public GearButton() {

		this.setAlignment(Pos.CENTER);
		this.setMaxSize(75, 100);
		this.setMinSize(75, 100);
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (gear != null) {
					GameController.setSelectItem(gear);
					GameController.showItemInfo(true, gear, false, false, false);
				}
			}
		});
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
			Image img = new Image(gear.getUrl());
			ImageView view = new ImageView(img);
			view.setPreserveRatio(true);
			view.setFitWidth(60);
			this.setGraphic(view);
		}
	}

}
