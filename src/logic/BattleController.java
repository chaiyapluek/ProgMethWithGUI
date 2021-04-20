package logic;

import Application.Bot;
import UnitBase.*;
import gui.ActionButton;

public class BattleController {

	private static Bot bot;
	private static int wave = 1;
	private static int turn = 1;
	private static int numberOfTakenAction = 0;

	public static void initializeBattle() {

		bot = new Bot(GameController.getNowStage().getUnitAtWave(0));
		GameController.setToEnemyInfoPanel();

	}

	public static void takeAction(ActionButton action) {

		String type = action.getType();

		if (type.equals("attack")) {
			attack(GameController.getSelectAllyUnit(), GameController.getSelectEnemyUnit());
		} else if (type.equals("defense")) {

		} else if (type.equals("swap")) {

		} else if (type.equals("skill")) {

		}

		UnitStats unit = (UnitStats) GameController.getSelectEnemyUnit();
		if (unit.getCurrentHP() <= 0) {
			unit.setIsDead(true);
			GameController.updateBattlePanel();
		}

		if (isWaveEnd()) {
			nextWave();
		} else if (!type.equals("skill")) {
			BattleController.checkPlayerTurnEnd();
			GameController.updateAllyInfo();
			GameController.setToEnemyInfoPanel();
		}
	}

	public static void checkPlayerTurnEnd() {
		if (numberOfTakenAction == 3) {
			// pass turn
			bot.play(GameController.getPlayer().getUnits());
			numberOfTakenAction = 0;
			nextTurn();
		}
	}

	private static boolean isWaveEnd() {
		return bot.getNumberOfUnit() == 0;
	}

	private static void nextTurn() {
		turn += 1;
		// replace death unit with back unit
		//
		// -----
		for (AllyUnit unit : GameController.getPlayer().getUnits()) {
			if (unit != null) {
				unit.setCanTakeAction(true);
			}
		}
		GameController.updateBattlePanel();
	}

	private static void nextWave() {
		if (wave == GameController.getNowStage().getNumberOfWave()) {
			System.out.println("VICTORY");
			GameController.getNowStage().setClear(true);
			for (AllyUnit unit : GameController.getPlayer().getUnits()) {
				if (unit != null) {
					unit.setCanTakeAction(true);
				}
			}
			GameController.updateAllyInfo();
			GameController.updateAllyView();
			GameController.updateMapPanel();
			GameController.setToButtonPanel();
			GameController.viewAllyUnit();
		} else {
			wave += 1;
			nextTurn();
			bot = new Bot(GameController.getNowStage().getUnitAtWave(wave - 1));
			GameController.setNewWave();
			GameController.updateAllyInfo();
			GameController.setToEnemyInfoPanel();
		}

	}

	public static void increaseNumberOfTakenAction() {
		numberOfTakenAction += 1;
	}

	public static void attack(Unit attack, Unit defense) {
		try {
			UnitStats attacker = (UnitStats) attack;
			UnitStats defender = (UnitStats) defense;
			attacker.attack(defender);
			if (defender.getCurrentHP() == 0) {
				defender.setIsDead(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " can Dodged!!");
		}
	}

	public static int getWave() {
		return wave;
	}

	public static int getTurn() {
		return turn;
	}
}
