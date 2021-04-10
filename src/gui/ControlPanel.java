package gui;

import UnitBase.AllyUnit;
import UnitBase.Unit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class ControlPanel extends HBox {

	private Pane Icon;
	
	private Label name;
	private Label Class;
	
	private Label HP;
	private Label Gauge;
	
	private Label def;
	private Label attack;
	private Label crit;
	private Label critdmg;
	private Label dodge;
	private Label level;

	public ControlPanel(Unit u) {

		this.setMaxSize(1000, 300);
		this.setMinSize(1000, 300);
		this.setAlignment(Pos.CENTER_LEFT);
		
		GridPane left = new GridPane();
		left.setPadding(new Insets(20));
		left.setHgap(10);
		left.setVgap(10);
		left.setAlignment(Pos.CENTER_LEFT);
		left.setMinSize(600, 300);
		left.setMaxSize(600, 300);
		left.setBorder(new Border(
				new BorderStroke(Color.CHOCOLATE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Icon = new Pane();
		Icon.setBorder(new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		Icon.setMinSize(75, 75);
		Icon.setMaxSize(75, 75);
		setIcon();

		VBox NameAndClass = new VBox();
		NameAndClass.setMinWidth(125);
		NameAndClass.setMaxWidth(125);
		NameAndClass.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		NameAndClass.setAlignment(Pos.CENTER_RIGHT);
		name = new Label(u.getName());
		Class = new Label(u.get_Class());
		name.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Class.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		NameAndClass.getChildren().addAll(name, Class);

		AllyUnit unit = (AllyUnit) u;
		VBox HPAndGauge = new VBox();
		HPAndGauge.setAlignment(Pos.CENTER_LEFT);
		HPAndGauge.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HP = new Label("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());
		Gauge = new Label("GAUGE : " + unit.getUltiGauge() + "/" + unit.getMaxUltigauge());
		HP.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Gauge.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		HPAndGauge.getChildren().addAll(HP, Gauge);

		VBox Stats = new VBox();
		Stats.setPadding(new Insets(5));
		Stats.setAlignment(Pos.CENTER_LEFT);
		def = new Label("Defense : " + Math.max(0, unit.getDefense()));
		attack = new Label("Attack : " + unit.getTotalAttack());
		crit = new Label("CritChance : " + Math.max(0, unit.getCritChance()));
		critdmg = new Label("CritDamage : " + Math.max(0, unit.getCritDamage()));
		dodge = new Label("Dodge : " + Math.max(0, unit.getDodgeChance()));
		level = new Label("Level : " + unit.getLevel());
		def.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		attack.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		crit.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		critdmg.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		dodge.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		level.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");

		Stats.getChildren().addAll(def, attack, crit, critdmg, dodge, level);
		Stats.setBorder(new Border(
				new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


		ActionPane actionPane = new ActionPane();
		
		left.add(Icon, 0, 0, 2, 1);
		left.add(NameAndClass, 2, 0, 1, 1);
		left.add(HPAndGauge, 0, 1, 3, 1);
		left.add(Stats, 0, 2, 2, 2);
		left.add(actionPane, 3, 0);

		this.getChildren().add(left);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	public void setIcon() {
		Icon.setBackground(new Background(new BackgroundImage(new Image(GameController.getSelectAllyUnit().getIconUrl()),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(0, 100, false, true, false, true))));
	}

	public void update() {
		updateLabel();
		setIcon();
	}
	
	private void updateLabel() {
		AllyUnit unit = GameController.getSelectAllyUnit();
		name.setText(unit.getName());
		Class.setText(unit.get_Class());
		
		HP.setText("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());
		Gauge.setText("GAUGE : " + unit.getUltiGauge() + "/" + unit.getMaxUltigauge());
		
		def.setText("Defense : " + Math.max(0, unit.getDefense()));
		attack.setText("Attack : " + unit.getTotalAttack());
		crit.setText("CritChance : " + Math.max(0, unit.getCritChance()));
		critdmg.setText("CritDamage : " + Math.max(0, unit.getCritDamage()));
		dodge.setText("Dodge : " + Math.max(0, unit.getDodgeChance()));
		level.setText("Level : " + unit.getLevel());
	}
}
