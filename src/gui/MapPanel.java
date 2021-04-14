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
		this.setPadding(new Insets(20));
		this.setSpacing(30);
		this.setAlignment(Pos.TOP_CENTER);

		HBox pane = new HBox();
		pane.setAlignment(Pos.CENTER_RIGHT);
		Button back = new Button("X");
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
		this.getChildren().addAll(pane,mapPanel);
	}

	public void update() {

		for (StageButton button : stageList) {
			if (button.getCoordinate().equals(GameController.getPlayerCoordinate())) {
				button.setText("PLAYER");
			} else {
				button.setText("");
			}
			if (GameController.getMoveToggle()) {
				int nowi = GameController.getPlayerCoordinate().getX();
				int nowj = GameController.getPlayerCoordinate().getY();
				int nexti = button.getCoordinate().getX();
				int nextj = button.getCoordinate().getY();
				if(GameController.getNowStage().isClear()) {
					if ((Math.abs(nowi - nexti) + Math.abs(nowj - nextj)) <= 1) {
						button.setCanGo(true);
						button.setCanMoveBackground();
					}
				}else {
					if(nowi==nexti && nowj==nextj) {
						button.setCanGo(true);
						button.setCanMoveBackground();
					}else if ((Math.abs(nowi - nexti) + Math.abs(nowj - nextj)) <= 1 && button.getStage().isClear()) {
						button.setCanGo(true);
						button.setCanMoveBackground();
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
