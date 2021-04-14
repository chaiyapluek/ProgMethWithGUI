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
	private ViewStagePane stagePane;
	
	public MainPanel(Player player) {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.BOTTOM_CENTER);

		Label label = new Label("DIS SIS NEW SCENE");
		label.setFont(new Font(24));
		
		viewPanel = new StackPane();
		allyUnitsPanel = new AllyUnitsPanel(player);
		
		viewPanel.getChildren().add(allyUnitsPanel);
		ControlPanel controlPane = new ControlPanel(GameController.getSelectAllyUnit());
		GameController.setControlPanel(controlPane);

		this.getChildren().addAll(label, viewPanel, controlPane);
	}

	public void updateAllyPanel() {
		allyUnitsPanel.update();
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
}
