package gui;

import Skill.Effect;
import Skill.NormalSkill;
import UnitBase.AdvanceUnit;
import UnitBase.AllyUnit;
import UnitBase.BasicUnit;
import UnitBase.Unit;
import UnitBase.UnitStats;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class UnitButton extends VBox {

	private Unit unit;
	private Button button;
	private StackPane chooseIconPane;
	private Tooltip tooltip;

	public UnitButton(Unit u) {

		this.unit = u;

		button = new Button();
		button.setAlignment(Pos.BOTTOM_CENTER);
		button.setMinSize(150, 200);
		button.setMaxSize(150, 200);
		button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

		chooseIconPane = new StackPane();
		chooseIconPane.setAlignment(Pos.TOP_CENTER);
		chooseIconPane.setMaxSize(150, 50);
		chooseIconPane.setMinSize(150, 50);
		chooseIconPane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setAlignment(Pos.BOTTOM_CENTER);
		this.setSpacing(50);
		Image img;
		ImageView imgView;
		if (u == null) {
			img = new Image("grave.png");
			imgView = new ImageView(img);
			imgView.setFitHeight(150);
		} else {
			img = new Image(u.getUrl());
			imgView = new ImageView(img);
			if (u.getName().equals("Karna") || u.getName().equals("Leonidas")) {
				imgView.setFitHeight(280);
			} else if (u.getName().equals("Ereshkigal") || u.getName().equals("Wyvern")) {
				imgView.setFitHeight(300);
			} else if (u.getName().equals("Heracles")) {
				imgView.setFitHeight(260);
			} else {
				imgView.setFitHeight(220);
			}
		}
		imgView.setPreserveRatio(true);
		button.setGraphic(imgView);

		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setOnHoverBackground();
			}
		});
		button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setBackground();
			}
		});
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (unit != null && unit instanceof AllyUnit) {
					GameController.setSelectAllyUnit((AllyUnit) unit);
					GameController.updateAllyInfo();
					GameController.setChooseIcon();

				} else if (((unit instanceof BasicUnit) || (unit instanceof AdvanceUnit))
						&& !((UnitStats) unit).getIsDead()) {
					GameController.setSelectEnemyUnit(unit);
					GameController.updateEnemyInfoPanel();
					GameController.setChooseIcon();
				}
			}
		});
		setTooltip();

		this.getChildren().addAll(chooseIconPane, button);
	}

	public Unit getUnit() {
		return unit;
	}

	public void setBackground() {
		button.setCursor(javafx.scene.Cursor.DEFAULT);
		button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setOnHoverBackground() {
//		this.setBackground(new Background(
//				new BackgroundImage(new Image("Light.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//						BackgroundPosition.CENTER, new BackgroundSize(0, 100, false, true, false, true))));
		if (unit != null) {
			if (!((UnitStats) unit).getIsDead()) {
				button.setCursor(javafx.scene.Cursor.HAND);
//				button.setBackground(
//						new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		}
	}
	
	public void setChooseIcon() {
		Image imgIcon = new Image("choose.png");
		ImageView Icon = new ImageView(imgIcon);
		Icon.setFitHeight(50);
		Icon.setPreserveRatio(true);
		chooseIconPane.getChildren().add(Icon);
	}

	public void removeChooseIcon() {
		chooseIconPane.getChildren().clear();
	}

	public void setDeadImg() {
		setBackground();
		Image img = new Image("grave.png");
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(150);
		imgView.setPreserveRatio(true);
		button.setGraphic(imgView);
	}

	public void setTooltip() {
		if(unit == null) {
			return ;
		}
		tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		String txt = "Effect(s) : \n";
		UnitStats unit = (UnitStats) this.unit;
		for (Effect e : unit.getEffects()) {
			txt += e.toString() + "\n";
		}
		tooltip.setText(txt);
		if (GameController.getOnBattle()) {
			button.setOnMouseMoved((MouseEvent e) -> {
				tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
			});
			button.setOnMouseExited((MouseEvent e) -> {
				tooltip.hide();
			});
		}
	}
}
