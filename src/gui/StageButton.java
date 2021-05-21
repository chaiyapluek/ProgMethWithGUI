package gui;

import Coordinate.Coordinate;
import Map.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import logic.GameController;

public class StageButton extends Button {

	private Stage stage;
	private Coordinate coordinate;
	private boolean canGo;
	private final ImageView playerIcon = new ImageView(new Image("player-icon.png"));
	private final ImageView shopIcon = new ImageView(new Image("shop-icon.png"));
	private final ImageView bossIcon = new ImageView(new Image("boss-icon.png"));

	public StageButton(Stage stage, Coordinate coor) {

		this.stage = stage;
		this.coordinate = coor;
		this.canGo = false;
		this.setAlignment(Pos.CENTER);

		playerIcon.setFitWidth(30);
		playerIcon.setPreserveRatio(true);
		shopIcon.setFitWidth(30);
		shopIcon.setPreserveRatio(true);
		bossIcon.setFitWidth(30);
		bossIcon.setPreserveRatio(true);

		if (stage != null && stage.isHasShop()) {
			this.setGraphic(shopIcon);
		}

		this.setMaxSize(35, 35);
		this.setMinSize(35, 35);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

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
				if (coordinate.equals(GameController.getPlayerCoordinate()) && !GameController.getMoveToggle()) {
					GameController.setMoveToggle(!GameController.getMoveToggle());
					GameController.updateMapPanel();
				} else if (GameController.getMoveToggle() && canGo) {
					GameController.movePlayer(coordinate);
					if (stage.isHasShop()) {
						GameController.updateShop();
					}
					GameController.setMoveToggle(false);
					GameController.updateMapPanel();
					GameController.updateAllyView();
					GameController.viewAllyUnit();
					checkIsClear();
				}
			}
		});
	}

	public void setBackground() {
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setCanMoveBackground(boolean isClear) {
		if (isClear) {
			this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		}else {
			this.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		}
	}

	public void setOnEnter() {
		if (GameController.getMoveToggle()) {
			if (canGo) {
				this.setCursor(javafx.scene.Cursor.HAND);
			}
		} else {
			if (coordinate.equals(GameController.getPlayerCoordinate())) {
				this.setCursor(javafx.scene.Cursor.HAND);
				this.setBackground(
						new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}

	public void setOnExit() {
		if (GameController.getMoveToggle()) {
			this.setCursor(javafx.scene.Cursor.DEFAULT);
		} else {
			if (coordinate.equals(GameController.getPlayerCoordinate())) {
				setBackground();
			}
		}
	}

	public void checkIsClear() {
		if (this.stage.isClear()) {
			GameController.setSelectEnemyUnit(null);
		} else {
			for (int i = 0; i < stage.getUnitAtWave(0).length; i++) {
				if (stage.getUnitAtWave(0)[i] != null) {
					GameController.setSelectEnemyUnit(stage.getUnitAtWave(0)[i]);
					break;
				}
			}
		}
	}

	public void setPlayerIcon() {
		this.setGraphic(playerIcon);
	}

	public void setShopIcon() {
		this.setGraphic(shopIcon);
	}

	public void setBossIcon() {
		this.setGraphic(bossIcon);
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
