package gui;

import Coordinate.Coordinate;
import Map.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import logic.GameController;

public class MapPanel extends GridPane {

	private Map map;
	private ObservableList<StageButton> stageList = FXCollections.observableArrayList();

	public MapPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setAlignment(Pos.CENTER);

		map = GameController.getMap();

		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				if (map.getStage(i, j) != null) {
					Coordinate coor = new Coordinate(i, j);
					StageButton button = new StageButton(map.getStage(i, j), coor);
					this.add(button, j, i);
					stageList.add(button);
				}
			}
		}
		update();
	}

	public void update() {

		for (StageButton button : stageList) {
			if (button.getCoordinate().equals(GameController.getPlayerCoordinate())) {
				button.setText("PLAYER");
			}else {
				button.setText("");
			}
			if (GameController.getMoveToggle()) {
				int nowi = GameController.getPlayerCoordinate().getX();
				int nowj = GameController.getPlayerCoordinate().getY();
				int nexti = button.getCoordinate().getX();
				int nextj = button.getCoordinate().getY();
				if ((Math.abs(nowi - nexti) + Math.abs(nowj - nextj)) <= 1 || button.getStage().isClear()) {
					button.setCanGo(true);
					button.setCanMoveBackground();
				}
			} else {
				if(!button.getStage().isClear()) {
					button.setCanGo(false);
				}
				button.setBackground();
			}
		}

	}

}
