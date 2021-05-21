package gui;

import UnitBase.AdvanceUnit;
import UnitBase.Unit;
import UnitBase.UnitStats;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class StatsPane extends VBox{

	private Label healthLabel;
	private Label attackLabel;
	private Label defenseLabel;
	private Label critLabel;
	private Label critDmgLabel;
	private Label dodgeLabel;
	private Label gaugeLabel;
	
	public StatsPane(Unit u) {
		
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(5));
		this.setSpacing(3);
		this.setMinWidth(150);
		UnitStats unit = (UnitStats) u;
		
		healthLabel = new Label();
		String HP = String.valueOf(unit.getCurrentHP());
		healthLabel.setText("Health : " + HP);
		
		attackLabel = new Label();
		String attack = String.valueOf( unit.getTotalAttack() );
		attackLabel.setText("Attack : " + attack);
		
		defenseLabel = new Label();
		String defense = String.valueOf( Math.max(0, unit.getDefense()) );
		defenseLabel.setText("Defense : " + defense);
		
		critLabel = new Label();
		String crit = String.valueOf( Math.max(0, unit.getCritChance()) );
		critLabel.setText("CritChance : " + crit);
		
		critDmgLabel = new Label();
		String critDmg = String.valueOf( Math.max(0, unit.getCritDamage()) );
		critDmgLabel.setText("CritDamage : " + critDmg);
		
		dodgeLabel = new Label();
		String dodge = String.valueOf( Math.max(0, unit.getDodgeChance()) );
		dodgeLabel.setText("DodgeChance : " + dodge);
	
		healthLabel.setFont(new Font("Arial",12));
		attackLabel.setFont(new Font("Arial",12));
		defenseLabel.setFont(new Font("Arial",12));
		critDmgLabel.setFont(new Font("Arial",12));
		critLabel.setFont(new Font("Arial",12));
		dodgeLabel.setFont(new Font("Arial",12));
		
		this.getChildren().add(healthLabel);
		this.getChildren().add(attackLabel);
		this.getChildren().add(defenseLabel);
		this.getChildren().add(critLabel);
		this.getChildren().add(critDmgLabel);
		this.getChildren().add(dodgeLabel);
		if(u.getClass() == AdvanceUnit.class) {
			
			gaugeLabel = new Label();
			gaugeLabel.setText("Gauge 0/" + ((AdvanceUnit)u).getMaxUltigauge() );
			gaugeLabel.setFont(new Font("Arial",16));
			
		}
	}

}
