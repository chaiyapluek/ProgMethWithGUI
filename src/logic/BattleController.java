package logic;

import Application.Bot;
import Map.Stage;
import UnitBase.*;
import gui.ActionButton;

public class BattleController {

	private static Bot bot;
	private static int wave;
	private static int turn;
	private static int numberOfTakenAction;

	public static void initializeBattle() {

		bot = new Bot(GameController.getNowStage().getUnitAtWave(0));
		wave = 1;
		turn = 1;
		numberOfTakenAction = 0;
		GameController.updateEnemyInfoPanel();

	}

	public static void takeAction(ActionButton action) {

		String type = action.getType();

		if (type.equals("attack")) {
			attack(GameController.getSelectAllyUnit(), GameController.getSelectEnemyUnit());
		} else if (type.equals("defense")) {
			GameController.getSelectAllyUnit().defense();
		} else if (type.equals("swap")) {

		} else if (type.equals("skill")) {

		}

		UnitStats unit = (UnitStats) GameController.getSelectEnemyUnit();
		if (unit.getCurrentHP() <= 0) {
			unit.setIsDead(true);
			GameController.updateBattlePanel();
			if (!isWaveEnd()) {
				setSelectEnemyUnit();
			}
		}

		if (isWaveEnd()) {
			nextWave();
		} else {
			System.out.println("ACTION");
			System.out.println("-->" + numberOfTakenAction);
			BattleController.checkPlayerTurnEnd();
			GameController.updateAllyInfo();
			GameController.updateEnemyInfoPanel();
		}
	}

	public static void checkPlayerTurnEnd() {
		if (numberOfTakenAction == 3) {
			// pass turn
			System.out.println("TEST!!");
			bot.play(GameController.getPlayer().getUnits());
			nextTurn();
		}
	}

	private static void setSelectEnemyUnit() {
		Stage stage = GameController.getNowStage();
		for (int i = 0; i < stage.getUnitAtWave(wave - 1).length; i++) {
			if(stage.getUnitAtWave(wave-1)[i] == null)	continue;
			UnitStats nextUnit = (UnitStats)stage.getUnitAtWave(wave-1)[i];
			if (!nextUnit.getIsDead()) {
				GameController.setSelectEnemyUnit(stage.getUnitAtWave(wave-1)[i]);
				break;
			}
		}
	}
	
	private static boolean isWaveEnd() {
		return bot.getNumberOfUnit() == 0;
	}
	
	private static void nextTurn() {
		turn += 1;
		numberOfTakenAction = 0;
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
			setSelectEnemyUnit();
			GameController.setNewWave();
			GameController.updateAllyInfo();
			GameController.updateEnemyInfoPanel();
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
