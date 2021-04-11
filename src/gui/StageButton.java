package gui;

import Coordinate.Coordinate;
import Map.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import logic.GameController;

public class StageButton extends Button {

	private Stage stage;
	private Coordinate coordinate;
	private boolean canGo;

	public StageButton(Stage stage, Coordinate coor) {

		this.stage = stage;
		this.coordinate = coor;
		this.canGo = false;

		this.setMaxSize(35, 35);
		this.setMinSize(35, 35);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setOnHover();
			}
		});
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if (coordinate.equals(GameController.getPlayerCoordinate()) && !GameController.getMoveToggle()) {
					setBackground();
				}
			}
		});
		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (coordinate.equals(GameController.getPlayerCoordinate()) && !GameController.getMoveToggle()) {
					GameController.setMoveToggle(!GameController.getMoveToggle());
					GameController.updateMapPanel();
				}else if (GameController.getMoveToggle() && canGo) {
					GameController.movePlayer(coordinate);
					GameController.setMoveToggle(false);
					GameController.updateMapPanel();
				}
			}
		});
	}

	public void setBackground() {
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setCanMoveBackground() {
		this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setOnHover() {
		if (coordinate.equals(GameController.getPlayerCoordinate()) || (GameController.getMoveToggle() && canGo)) {
			this.setCursor(javafx.scene.Cursor.HAND);
			if (!GameController.getMoveToggle()) {
				this.setBackground(
						new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Stage getStage() {
		return stage;
	}

	public void setCanGo(boolean bool) {
		canGo = bool;
	}

	public boolean canGo() {
		return canGo;
	}

}
