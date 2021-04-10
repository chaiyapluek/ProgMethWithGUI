package gui;

import Application.Player;
import List.AllyUnitList_Saber;
import UnitBase.AllyUnit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class MainPanel extends VBox{
	
	public MainPanel(Player player) {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.TOP_CENTER);
		
		Label label = new Label("DIS SIS NEW SCENE");
		label.setFont(new Font(24));
		
		HBox unitView = new HBox();
		unitView.setAlignment(Pos.BOTTOM_CENTER);
		unitView.setSpacing(70);
		for(AllyUnit u : player.getUnits()) {
			UnitButton button = new UnitButton(u);
			unitView.getChildren().add(button);
		}
		
		ControlPanel controlPane = new ControlPanel(GameController.getSelectAllyUnit());
		GameController.setControlPanel(controlPane);
		
		this.getChildren().addAll(label,unitView,controlPane);
	}
	
}
