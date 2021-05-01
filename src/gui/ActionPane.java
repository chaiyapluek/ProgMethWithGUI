package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.BattleController;
import logic.GameController;

public class ActionPane extends HBox {

	public ActionPane() {

		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setMinWidth(275);
		this.setMinHeight(75);

		ActionButton attack = new ActionButton("attack", null, false, 0);
		ActionButton defense = new ActionButton("defense", null, false, 0);
		ActionButton swap = new ActionButton("swap", null, false, 0);
		attack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (GameController.getOnBattle() && GameController.getSelectAllyUnit().canTakeAction()) {
					GameController.getSelectAllyUnit().setCanTakeAction(false);
					BattleController.increaseNumberOfTakenAction();
					BattleController.takeAction(attack);
				}
			}
		});
		defense.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (GameController.getOnBattle() && GameController.getSelectAllyUnit().canTakeAction()) {
					GameController.getSelectAllyUnit().setCanTakeAction(false);
					BattleController.increaseNumberOfTakenAction();
					BattleController.takeAction(defense);
				}
			}
		});
		swap.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (GameController.getOnBattle()) {
					if (GameController.getSelectAllyUnit().canTakeAction()) {
						GameController.setSwapPanel(true);
					}
				} else {
					GameController.setSwapPanel(true);
				}
			}
		});
		this.getChildren().addAll(attack, defense, swap);
	}

}
