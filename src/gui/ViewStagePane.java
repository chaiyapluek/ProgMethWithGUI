package gui;

import Map.Stage;
import UnitBase.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class ViewStagePane extends HBox {

	public ViewStagePane(Stage stage) {

		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(10));
		this.setSpacing(30);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		Button backButton = new Button("<<");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.viewAllyUnit();
			}
		});
		this.getChildren().add(backButton);

		for (int i = 0; i < stage.getNumberOfWave(); i++) {
			VBox pane = new VBox();
			pane.setMaxSize(375, 300);
			pane.setMinSize(375, 300);
			pane.setAlignment(Pos.BOTTOM_CENTER);
			pane.setSpacing(10);
			Label label = new Label("WAVE : " + (i + 1));
			Unit[] units = stage.getUnitAtWave(i);
			HBox unitsPane = new HBox();
			unitsPane.setSpacing(20);
			unitsPane.setAlignment(Pos.BOTTOM_CENTER);
			for (int j = 0; j < units.length; j++) {
				unitsPane.getChildren().add(getUnitButton(units[j]));
			}
			pane.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			pane.getChildren().addAll(label, unitsPane);
			this.getChildren().add(pane);
		}

	}

	public Button getUnitButton(Unit unit) {
		Button unitButton = new Button();
		unitButton.setMaxSize(100, 150);
		unitButton.setMinSize(100, 150);
		unitButton.setAlignment(Pos.BOTTOM_CENTER);
		if (unit != null) {
			Image img = new Image(unit.getUrl());
			ImageView imgView = new ImageView(img);
			imgView.setFitHeight(150);
			imgView.setPreserveRatio(true);
			unitButton.setGraphic(imgView);
		}
		return unitButton;
	}

}
