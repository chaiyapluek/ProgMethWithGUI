package gui;

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

public class StatsPane extends VBox{

	public StatsPane(Unit u) {
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(5));
		this.setSpacing(3);
		this.setMinWidth(150);
		UnitStats unit = (UnitStats) u;
		
		Label healthLabel = new Label();
		String HP = String.valueOf(unit.getCurrentHP());
		healthLabel.setText("Health : " + HP);
		
		Label defenseLabel = new Label();
		String defense = String.valueOf( Math.max(0, unit.getDefense()) );
		defenseLabel.setText("Defense : " + defense);
		
		Label attackLabel = new Label();
		String attack = String.valueOf( unit.getTotalAttack() );
		attackLabel.setText("Attack : " + attack);
		
		Label critLabel = new Label();
		String crit = String.valueOf( Math.max(0, unit.getCritChance()) );
		critLabel.setText("CritChance : " + crit);
		
		Label critDmgLabel = new Label();
		String critDmg = String.valueOf( Math.max(0, unit.getCritDamage()) );
		critDmgLabel.setText("CritDamage : " + critDmg);
		
		Label dodgeLabel = new Label();
		String dodge = String.valueOf( Math.max(0, unit.getDodgeChance()) );
		dodgeLabel.setText("DodgeChance : " + dodge);
	
		this.getChildren().add(healthLabel);
		this.getChildren().add(attackLabel);
		this.getChildren().add(defenseLabel);
		this.getChildren().add(critLabel);
		this.getChildren().add(critDmgLabel);
		this.getChildren().add(dodgeLabel);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
}
