package gui;

import Unit.AdvanceUnit;
import Unit.UnitStats;
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
import javafx.scene.text.Font;
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

	private Button back;

	public EnemyInfoPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.TOP_CENTER);
		
		HBox pane = new HBox();
		pane.setAlignment(Pos.CENTER);
		
		
		VBox info = new VBox();
		info.setSpacing(10);
		info.setAlignment(Pos.CENTER);
		VBox NameAndClass = new VBox();
		NameAndClass.setMinWidth(150);
		NameAndClass.setMaxWidth(150);
		NameAndClass.setAlignment(Pos.CENTER_LEFT);
		name = new Label();
		Class = new Label();
		NameAndClass.getChildren().addAll(name, Class);

		VBox Stats = new VBox();
		Stats.setSpacing(5);
		Stats.setAlignment(Pos.CENTER_LEFT);
		VBox HPandGauge = new VBox();
		VBox other = new VBox();
		HP = new Label();
		attack = new Label();
		def = new Label();
		crit = new Label();
		critdmg = new Label();
		dodge = new Label();
		gauge = new Label();
		HPandGauge.getChildren().addAll(HP,gauge);
		other.getChildren().addAll(attack,def,crit,critdmg,dodge);
		Stats.getChildren().addAll(HPandGauge,other);

		info.getChildren().addAll(NameAndClass, Stats);
		info.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		info.setAlignment(Pos.CENTER);
		info.setPadding(new Insets(10));
		pane.getChildren().add(info);

		HBox backPanel = new HBox();
		backPanel.setAlignment(Pos.CENTER_RIGHT);
		back = new Button();
		backPanel.getChildren().add(back);
		GameController.setBackButton(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
			}
		});
		setFont(16, name);
		setFont(14, Class);
		setFont(14,HP);
		setFont(14,gauge);
		setFont(12,attack);
		setFont(12,def);
		setFont(12,crit);
		setFont(12,critdmg);
		setFont(12,dodge);
		
		this.getChildren().addAll(backPanel, pane);
	}

	private void setFont(int size, Label label) {
		
		label.setFont(new Font("Arial Black",size));
	
	}

	public void update() {

		if (GameController.getOnBattle()) {
			back.setVisible(false);
		} else {
			back.setVisible(true);
		}

		if (GameController.getSelectEnemyUnit() != null) {

			UnitStats unit = (UnitStats) GameController.getSelectEnemyUnit();

			name.setText(unit.getName());
			Class.setText(unit.get_Class());

			HP.setText("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());

			def.setText("Defense : " + Math.max(0, Math.min(100, unit.getDefense())));
			attack.setText("Attack : " + unit.getTotalAttack());
			crit.setText("CritChance : " + Math.max(0, Math.min(100, unit.getCritChance())));
			critdmg.setText("CritDamage : " + Math.max(0, unit.getCritDamage()));
			dodge.setText("Dodge : " + Math.max(0, Math.min(100, unit.getDodgeChance())));
			gauge.setText("");

			if (unit instanceof AdvanceUnit) {
				AdvanceUnit u = (AdvanceUnit) unit;
				gauge.setText("Gauge : " + u.getUltiGauge() + "/" + u.getMaxUltigauge());
			}

		}
	}

}
