package gui;

import Application.Main;
import UnitBase.AdvanceUnit;
import UnitBase.AllyUnit;
import UnitBase.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class MercenaryCell extends VBox {

	private AllyUnit unit;
	
	public MercenaryCell(Unit u) {
		
		this.unit = (AllyUnit) u;
		
		this.setPadding(new Insets(20, 10, 20, 10));
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.TOP_CENTER);
		this.setSpacing(20);
		this.setMaxSize(400, 560);
		this.setMinSize(400, 560);
		this.setBackground(new Background(new BackgroundFill(Color.rgb(131, 242, 249), CornerRadii.EMPTY, Insets.EMPTY)));
		
		StatsPane statsPane = new StatsPane(u);
		Pane merImage = new Pane();
		merImage.setMaxSize(400, 250);
		merImage.setMinSize(400, 250);
		merImage.setPadding(new Insets(5));
		
		
		Label name = new Label(u.getName() + " [ " + u.get_Class() + " ]");
		name.setFont(new Font(24));
		
		merImage.setBackground(new Background(
				new BackgroundImage(new Image(u.getUrl()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.CENTER, new BackgroundSize(0, 100, false, true, true, false))));

		InitialSkillPanel skills = new InitialSkillPanel((AdvanceUnit) u);

		HBox info = new HBox();
		info.setAlignment(Pos.CENTER);
		info.setPadding(new Insets(10));
		info.setSpacing(20);
		info.getChildren().addAll(statsPane, skills);
		info.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
		
		Button choose = new Button("CHOOSE");
		choose.setFont(new Font("Arial Black",18));
		choose.setPrefWidth(150);
		choose.setBackground(new Background(new BackgroundFill(Color.rgb(255, 207, 72), CornerRadii.EMPTY, Insets.EMPTY)));
		choose.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		choose.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				choose.setCursor(Cursor.HAND);
			}
		});
		choose.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				choose.setCursor(Cursor.HAND);
			}
		});
		
		choose.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ChooseMerPanel.count <3) {
					GameController.addInitialUnit(unit);
					ChooseMerPanel.count += 1;
					GameController.chooseNext();
					if(ChooseMerPanel.count == 3) {
						GameController.createPlayer();
						Main.createMainScene();
						GameController.changeToMainScene();
					}
				}
			}
		});
		
		this.getChildren().add(name);
		this.getChildren().add(merImage);
		this.getChildren().add(info);
		this.getChildren().add(choose);
	}

}
