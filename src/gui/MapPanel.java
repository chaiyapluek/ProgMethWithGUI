package gui;

import Coordinate.Coordinate;
import Map.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameController;

public class MapPanel extends VBox {

	private Map map;
	private ObservableList<StageButton> stageList = FXCollections.observableArrayList();

	public MapPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(10));
		this.setSpacing(15);
		this.setAlignment(Pos.TOP_CENTER);

		HBox pane = new HBox();
		pane.setAlignment(Pos.CENTER_RIGHT);
		Button back = new Button();
		GameController.setBackButton(back);
		pane.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
				GameController.setMoveToggle(false);
				update();
			}
		});

		GridPane mapPanel = new GridPane();
		mapPanel.setAlignment(Pos.CENTER);
		map = GameController.getMap();

		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				Coordinate coor = new Coordinate(i, j);
				if (map.getStage(coor) != null) {
					StageButton button = new StageButton(map.getStage(coor), coor);
					mapPanel.add(button, j, i);
					stageList.add(button);
				}
			}
		}
		update();
		this.getChildren().addAll(pane, mapPanel);
	}

	public void update() {
		for (StageButton button : stageList) {
			if (button.getCoordinate().equals(GameController.getPlayerCoordinate())) {
				button.setPlayerIcon();
			} else {
				button.setGraphic(null);
				if (button.getStage().isHasShop()) {
					button.setShopIcon();
				} else if (button.getStage().isBoss()) {
					button.setBossIcon();
				}
			}
			if (GameController.getMoveToggle()) {
				if (button.getStage().isClear()) {
					button.setCanGo(true);
					button.setCanMoveBackground(true);
				} else {
					if(GameController.getMap().isNearbyClear(button.getCoordinate())) {
						button.setCanGo(true);
						button.setCanMoveBackground(false);
					}
				}
			} else {
				if (!button.getStage().isClear()) {
					button.setCanGo(false);
				}
				button.setBackground();
			}
		}

	}

}
