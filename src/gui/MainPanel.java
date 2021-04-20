package gui;

import Application.Player;
import List.AllyUnitList_Saber;
import UnitBase.AllyUnit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class MainPanel extends VBox {

	private StackPane viewPanel;
	private AllyUnitsPanel allyUnitsPanel;
	private BattlePanel battlePanel;
	private ViewStagePane stagePane;
	
	public MainPanel(Player player) {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.BOTTOM_CENTER);
		
		viewPanel = new StackPane();
		allyUnitsPanel = new AllyUnitsPanel(player);
		
		viewPanel.getChildren().add(allyUnitsPanel);
		ControlPanel controlPane = new ControlPanel(GameController.getSelectAllyUnit());
		GameController.setControlPanel(controlPane);

		this.getChildren().addAll(viewPanel, controlPane);
	}

	public void updateAllyPanel() {
		allyUnitsPanel.update();
	}
	
	public void updateBattlePanel() {
		battlePanel.update();
	}
	
	public void setNewWave() {
		battlePanel.setNewWave();
	}
	
	public void viewStage() {
		stagePane = new ViewStagePane(GameController.getNowStage());
		viewPanel.getChildren().clear();
		viewPanel.getChildren().add(stagePane);
	}
	
	public void viewAllyPane() {
		viewPanel.getChildren().clear();
		viewPanel.getChildren().add(allyUnitsPanel);
	}
	
	public void viewBattlePanel() {
		viewPanel.getChildren().clear();
		battlePanel = new BattlePanel();
		viewPanel.getChildren().add(battlePanel);
	}
}
