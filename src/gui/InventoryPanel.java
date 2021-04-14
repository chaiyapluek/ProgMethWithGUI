package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class InventoryPanel extends VBox {

	public InventoryPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(20));
		this.setSpacing(30);
		this.setAlignment(Pos.TOP_CENTER);

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

		VBox panel = new VBox();
		panel.setAlignment(Pos.CENTER_LEFT);
		panel.setSpacing(10);
		panel.setPadding(new Insets(10));
		panel.setBorder(new Border(
				new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Label money = new Label();
		money.setText("Money : XXX ");
		GridPane inventory = new GridPane();
		inventory.setAlignment(Pos.CENTER);
		inventory.setVgap(10);
		inventory.setHgap(10);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				// item button (didn't create yet cus so lazy =.=)
				Button itemButton = new Button();
				itemButton.setMaxSize(60, 60);
				itemButton.setMinSize(60, 60);
				inventory.add(itemButton, j, i);
			}
		}
		panel.getChildren().addAll(money, inventory);
		this.getChildren().addAll(backPanel, panel);
	}

}
