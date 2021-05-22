package gui;

import java.util.ArrayList;

import Unit.AllyUnit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class MercenaryPanel extends HBox{
	
	public MercenaryPanel(ArrayList<AllyUnit> units) {
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
		
		for(AllyUnit u : units) {
			MercenaryCell cell = new MercenaryCell(u);
			this.getChildren().add(cell);
		}
	}
	
}
