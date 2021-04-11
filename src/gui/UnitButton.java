package gui;

import java.awt.Cursor;

import UnitBase.AllyUnit;
import UnitBase.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.GameController;

public class UnitButton extends Button {

	private Unit unit;

	public UnitButton(Unit u) {

		this.unit = u;

		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setMinSize(150, 250);
		this.setMaxSize(150, 250);
		this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		Image img = new Image(u.getUrl());
		ImageView imgView = new ImageView(img);
		if (u.getName().equals("Karna") || u.getName().equals("Leonidas")) {
			imgView.setFitHeight(280);
		} else if (u.getName().equals("Ereshkigal")) {
			imgView.setFitHeight(300);
		} else if (u.getName().equals("Heracles")) {
			imgView.setFitHeight(260);
		} else {
			imgView.setFitHeight(220);
		}
		imgView.setPreserveRatio(true);
		this.setGraphic(imgView);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setOnHoverBackground();
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setBackground();
			}
		});
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (unit instanceof AllyUnit) {
					GameController.setSelectAllyUnit((AllyUnit) unit);
					GameController.updateControlPanel();
				}
			}
		});
	}

	public void setBackground() {
		this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setOnHoverBackground() {
//		this.setBackground(new Background(
//				new BackgroundImage(new Image("Light.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//						BackgroundPosition.CENTER, new BackgroundSize(0, 100, false, true, false, true))));
		this.setCursor(javafx.scene.Cursor.HAND);
		this.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
