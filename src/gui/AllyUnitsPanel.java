package gui;

import Application.Player;
import UnitBase.AllyUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import logic.GameController;

public class AllyUnitsPanel extends HBox{

	private StackPane viewStagePane;
	private ObservableList<UnitButton> allyUnits = FXCollections.observableArrayList();
	private HBox frontUnit;
	private HBox backUnit;
	
	public AllyUnitsPanel(Player player) {

		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(80);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setMinHeight(300);
		frontUnit = new HBox();
		frontUnit.setAlignment(Pos.BOTTOM_CENTER);
		frontUnit.setSpacing(35);
		for (int i = 2; i >= 0; i--) {
			UnitButton button = new UnitButton(player.getUnits()[i]);
			frontUnit.getChildren().add(button);
			allyUnits.add(button);
		}
		backUnit = new HBox();
		backUnit.setAlignment(Pos.BOTTOM_CENTER);
		backUnit.setSpacing(35);
		for (int i = 2; i >= 0; i--) {
			UnitButton button = new UnitButton(player.getBackUnits()[i]);
			backUnit.getChildren().add(button);
			allyUnits.add(button);
		}
		viewStagePane = new StackPane();
		viewStagePane.setMaxWidth(50);
		viewStagePane.setMinWidth(50);
		viewStagePane.setAlignment(Pos.CENTER);
		viewStagePane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.getChildren().addAll(backUnit,frontUnit,viewStagePane);
		setChooseIcon();
	}
	
	public void update() {
		allyUnits.clear();
		frontUnit.getChildren().clear();
		for (int i = 2; i >= 0; i--) {
			UnitButton button = new UnitButton(GameController.getPlayer().getUnits()[i]);
			frontUnit.getChildren().add(button);
			allyUnits.add(button);
		}
		backUnit.getChildren().clear();
		for (int i = 2; i >= 0; i--) {
			UnitButton button = new UnitButton(GameController.getPlayer().getBackUnits()[i]);
			backUnit.getChildren().add(button);
			allyUnits.add(button);
		}
		if(!GameController.getNowStage().isClear()) {
			Button viewStageButton = new Button(">>");
			viewStageButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					GameController.viewStage();
				}
			});
			viewStagePane.getChildren().add(viewStageButton);
		}else {
			viewStagePane.getChildren().clear();
		}
		setChooseIcon();
	}
	
	public void resetChoose() {
		for(UnitButton button : allyUnits) {
			button.removeChooseIcon();
		}
	}
	
	public void setChooseIcon() {
		for(UnitButton button : allyUnits) {
			button.removeChooseIcon();
		}
		for(UnitButton button : allyUnits) {
			if(GameController.getSelectAllyUnit().equals(button.getUnit())) {
				button.setChooseIcon();
				break;
			}
		}
	}
}
