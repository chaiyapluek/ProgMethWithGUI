package gui;

import UnitBase.AdvanceUnit;
import UnitBase.UnitStats;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class EnemyInfoPanel extends VBox {

	private Label name;
	private Label Class;

	private Label HP;
	private Label def;
	private Label attack;
	private Label crit;
	private Label critdmg;
	private Label dodge;
	private Label gauge;

	public EnemyInfoPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setAlignment(Pos.TOP_CENTER);

		HBox pane = new HBox();
		pane.setSpacing(10);

		VBox info = new VBox();
		info.setSpacing(10);
		VBox NameAndClass = new VBox();
		NameAndClass.setMinWidth(150);
		NameAndClass.setMaxWidth(150);
		NameAndClass.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		NameAndClass.setAlignment(Pos.CENTER_LEFT);
		name = new Label();
		Class = new Label();
		NameAndClass.getChildren().addAll(name, Class);

		VBox Stats = new VBox();
		Stats.setAlignment(Pos.CENTER_LEFT);
		HP = new Label();
		attack = new Label();
		def = new Label();
		crit = new Label();
		critdmg = new Label();
		dodge = new Label();
		gauge = new Label();
		Stats.getChildren().addAll(HP, attack, def, crit, critdmg, dodge, gauge);

		info.getChildren().addAll(NameAndClass, Stats);
		
		pane.getChildren().add(info);
		
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
		
		this.getChildren().addAll(backPanel,pane);
	}

	public void update() {

		if (GameController.getSelectEnemyUnit() != null) {

			UnitStats unit = (UnitStats) GameController.getSelectEnemyUnit();

			name.setText(unit.getName());
			Class.setText(unit.get_Class());

			HP.setText("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());

			def.setText("Defense : " + Math.max(0, unit.getDefense()));
			attack.setText("Attack : " + unit.getTotalAttack());
			crit.setText("CritChance : " + Math.max(0, unit.getCritChance()));
			critdmg.setText("CritDamage : " + Math.max(0, unit.getCritDamage()));
			dodge.setText("Dodge : " + Math.max(0, unit.getDodgeChance()));

			if (unit instanceof AdvanceUnit) {
				AdvanceUnit u = (AdvanceUnit) unit;
				gauge.setText("Gauge : " + u.getUltiGauge() + "/" + u.getMaxUltigauge());
			}

		}
	}

}
