package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ActionPane extends HBox {

	public ActionPane() {
		
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setMinWidth(275);
		this.setMinHeight(75);
		
		ActionButton attack = new ActionButton("attack",null);
		ActionButton defense = new ActionButton("defense",null);
		ActionButton swap = new ActionButton("swap",null);
		
		this.getChildren().addAll(attack,defense,swap);
	}

}
