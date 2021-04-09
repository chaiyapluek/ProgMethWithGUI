package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainPanel extends VBox{
	
	public MainPanel() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		
		Label label = new Label("DIS SIS NEW SCENE");
		label.setFont(new Font(24));
		
		this.getChildren().add(label);
	}
	
}
