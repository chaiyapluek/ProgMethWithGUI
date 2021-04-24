package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameController;

public class ShopPanel extends VBox {

	public ShopPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		

		HBox backPanel = new HBox();
		backPanel.setAlignment(Pos.CENTER_RIGHT);
		Button back = new Button("X");
		backPanel.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
			}
		});
		this.getChildren().add(backPanel);
		
		ScrollPane shop = new ScrollPane();
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setSpacing(10);
		root.setMaxWidth(250);
		root.setMinWidth(250);
		root.setPadding(new Insets(10));
		
		Label itemLabel = new Label("Items");
		root.getChildren().add(itemLabel);
		for (int i = 0; i < 10; i++) {
			Button button = new Button();
			button.setMaxSize(45, 45);
			button.setMinSize(45, 45);
			root.getChildren().add(button);
		}
		Label unitLabel = new Label("Mercenaries");
		root.getChildren().add(unitLabel);
		for (int i = 0; i < 10; i++) {
			Button button = new Button();
			button.setMaxSize(45, 45);
			button.setMinSize(45, 45);
			root.getChildren().add(button);
		}

		shop.setContent(root);
		this.getChildren().add(shop);
	}

}
