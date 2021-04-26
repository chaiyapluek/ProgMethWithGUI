package gui;

import UnitBase.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import logic.BattleController;
import logic.GameController;

public class BattlePanel extends VBox {

	private Label wave;
	private Label turn;

	private HBox enemyPane;

	private ObservableList<UnitButton> allyUnits = FXCollections.observableArrayList();
	private ObservableList<UnitButton> enemyUnits = FXCollections.observableArrayList();

	public BattlePanel() {

		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10));
		this.setSpacing(25);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		VBox labelPane = new VBox();
		labelPane.setAlignment(Pos.CENTER);
		wave = new Label("WAVE : 1");
		turn = new Label("TURN : 1");
		labelPane.getChildren().addAll(wave, turn);

		HBox unitPane = new HBox();
		unitPane.setAlignment(Pos.BOTTOM_CENTER);
		unitPane.setSpacing(100);

		HBox allyPane = new HBox();
		allyPane.setSpacing(35);
		allyPane.setAlignment(Pos.BOTTOM_CENTER);
		for (Unit unit : GameController.getPlayer().getUnits()) {
			UnitButton button = new UnitButton(unit);
			allyPane.getChildren().add(button);
			allyUnits.add(button);
		}
		enemyPane = new HBox();
		enemyPane.setSpacing(35);
		enemyPane.setAlignment(Pos.BOTTOM_CENTER);
		for (Unit unit : GameController.getNowStage().getUnitAtWave(0)) {
			UnitButton button = new UnitButton(unit);
			enemyPane.getChildren().add(button);
			enemyUnits.add(button);
		}
		unitPane.getChildren().addAll(allyPane, enemyPane);

		this.getChildren().addAll(labelPane, unitPane);
	}

	public void update() {
		setLabel();
		setDeadImg();
		for(UnitButton button : allyUnits) {
			button.removeChooseIcon();
		}
	}

	private void setDeadImg() {
		for (UnitButton button : allyUnits) {
			if(button.getUnit() == null) {
				continue;
			}
			if (((UnitStats) button.getUnit()).getIsDead()) {
				button.setDeadImg();
			}
		}
		for (UnitButton button : enemyUnits) {
			if(button.getUnit() == null) {
				continue;
			}
			if (((UnitStats) button.getUnit()).getIsDead()) {
				button.setDeadImg();
			}
		}
	}

	public void setNewWave() {
		enemyUnits.clear();
		enemyPane.getChildren().clear();
		for (Unit unit : GameController.getNowStage().getUnitAtWave(BattleController.getWave() - 1)) {
			UnitButton button = new UnitButton(unit);
			enemyPane.getChildren().add(button);
			enemyUnits.add(button);
		}
	}

	private void setLabel() {
		wave.setText("WAVE : " + BattleController.getWave());
		turn.setText("TURN : " + BattleController.getTurn());
	}

}
