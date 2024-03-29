package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import logic.BattleController;
import logic.GameController;

public class ActionPane extends HBox {

	private ActionButton attack;
	private ActionButton defense;
	private ActionButton swap;

	public ActionPane() {

		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setMinWidth(275);
		this.setMinHeight(75);

		attack = new ActionButton("attack", null, false, 0);
		defense = new ActionButton("defense", null, false, 0);
		swap = new ActionButton("swap", null, false, 0);
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
