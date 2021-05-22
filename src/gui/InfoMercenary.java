package gui;

import List.AllyUnitList_Saber;
import Unit.AllyUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class InfoMercenary extends StackPane {

	private MercenaryCell info;
	private VBox pane;

	public InfoMercenary() {
		this.setMinSize(1280, 720);
		this.setMaxSize(1280, 720);
		this.setAlignment(Pos.CENTER);

		Image black = new Image("black.jpg");
		ImageView blackView = new ImageView(black);
		blackView.setOpacity(0.8);
		blackView.setFitWidth(1440);
		blackView.setPreserveRatio(true);
		Pane bg = new Pane();
		bg.getChildren().add(blackView);

		pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		pane.setSpacing(30);
		pane.setPadding(new Insets(15));
		pane.setMinSize(500, 650);
		pane.setMaxSize(500, 650);
		BorderPane top = new BorderPane();
		Label label = new Label("Mercenary Information");
		label.setStyle("-fx-font-size: 24px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Button back = new Button();
		GameController.setBackButton(back);
		top.setRight(back);
		top.setCenter(label);

		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.showMercenaryInfo(false, null);
			}
		});

		info = new MercenaryCell(AllyUnitList_Saber.Artoria());
		info.getChildren().remove(info.getChildren().size() - 1);

		pane.getChildren().addAll(top, info);
		this.getChildren().addAll(bg, pane);
	}

	public void update(AllyUnit unit) {

		info = new MercenaryCell(unit);
		info.getChildren().remove(info.getChildren().size() - 1);
		info.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

		pane.getChildren().remove(pane.getChildren().size() - 1);
		pane.getChildren().add(info);

	}

}
