package logic;

import java.util.ArrayList;

import Application.Bot;
import Map.Stage;
import Skill.Effect;
import Skill.NormalSkill;
import Skill.Skill;
import SubSkill.DOTDamage;
import SubSkill.Heal;
import SubSkill.IncreaseUltiGauge;
import Unit.*;
import gui.ActionButton;
import javafx.application.Platform;

public class BattleController {

	private static Bot bot;
	private static int wave;
	private static int turn;
	private static int numberOfTakenAction;
	private static int maxPlayerAction;
	private static Skill skill;

	private static boolean enemyTurn = false;
	private static boolean playerUnitKilled = false;
	private static boolean enemyWin = false;
	private static int enemyTimeCount = 0;

	public static void initializeBattle() {

		bot = new Bot(GameController.getNowStage().getUnitAtWave(0));
		wave = 1;
		turn = 1;
		numberOfTakenAction = 0;
		maxPlayerAction = GameController.getPlayer().getNumberOfFrontUnit();
		GameController.updateEnemyInfoPanel();
		setSelectAllyUnit();
		setSelectEnemyUnit();
		GameController.playBattleSound();
		GameController.getMainPanel().textTransition("Wave 1");
	}

	public static void takeAction(ActionButton action) {

		String type = action.getType();

		if (type.equals("attack")) {
			attack(GameController.getSelectAllyUnit(), GameController.getSelectEnemyUnit());
		} else if (type.equals("defense")) {
			defense();
		} else if (type.equals("swap")) {
			swap();
		} else if (type.equals("skill")) {
			skill = action.getSkill();
			if (skill.getToYourSelf()) {
				useSkillTo(GameController.getSelectAllyUnit());
				if (!enemyTurn) {
					afterTakeAction();
				}
				GameController.updateBattlePanel();
				GameController.updateAllyInfo();
			} else if (skill.getToAlly()) {
				if (skill.getIsSingle()) {
					GameController.setSelectTarget(true);
				} else {
					for (AllyUnit unit : GameController.getPlayer().getUnits()) {
						if (unit == null)
							continue;
						if (unit.getIsDead())
							continue;
						useSkillTo(unit);
					}
					if (!enemyTurn) {
						afterTakeAction();
					}
					GameController.updateBattlePanel();
					GameController.updateAllyInfo();
				}
			} else if (!skill.getToAlly()) {
				if (skill.getIsSingle()) {
					useSkillTo(GameController.getSelectEnemyUnit());
				} else {
					for (Unit unit : bot.getUnits()) {
						if (unit == null)
							continue;
						useSkillTo(unit);
					}
				}
				if (!enemyTurn) {
					afterTakeAction();
				}
				GameController.updateBattlePanel();
				GameController.updateAllyInfo();
			}
		}
	}

	public static void afterTakeAction() {
		GameController.updateBattlePanel();
		Thread thread = new Thread(() -> {
			GameController.getMainPanel().showText();
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					UnitStats unit = (UnitStats) GameController.getSelectEnemyUnit();
					if (unit.getCurrentHP() <= 0) {
						unit.setIsDead(true);
						GameController.updateBattlePanel();
						if (!isWaveEnd()) {
							setSelectEnemyUnit();
						}
					}
					if (isWaveEnd()) {
						decreaseSkillCooldown(GameController.getPlayer().getUnits());
						decreaseEffectDuration(GameController.getPlayer().getUnits());
						checkEffect(GameController.getPlayer().getUnits());
						increseUltiGauge(GameController.getPlayer().getUnits());
						GameController.updateAllyInfo();
						GameController.updateEnemyInfoPanel();
						GameController.updateBattlePanel();
						nextWave();
					} else {
						BattleController.checkPlayerTurnEnd();
						GameController.updateAllyInfo();
						GameController.updateEnemyInfoPanel();
					}
				}
			});
		});
		thread.start();
	}

	public static void checkPlayerTurnEnd() {
		if (numberOfTakenAction == maxPlayerAction) {
			decreaseSkillCooldown(GameController.getPlayer().getUnits());
			decreaseEffectDuration(GameController.getPlayer().getUnits());
			checkEffect(GameController.getPlayer().getUnits());
			increseUltiGauge(GameController.getPlayer().getUnits());
			GameController.updateAllyInfo();
			GameController.updateEnemyInfoPanel();
			GameController.updateBattlePanel();
			// pass turn
			enemyTurn = true;
			bot.play(GameController.getPlayer().getUnits());
			decreaseSkillCooldown(bot.getUnits());
			decreaseEffectDuration(bot.getUnits());
			checkEffect(bot.getUnits());
			increseUltiGauge(bot.getUnits());
		}
	}

	public static void enemyTurnEnd() {
		enemyTurn = false;
		if (playerUnitKilled) {
			playerUnitKilled();
		}
		playerUnitKilled = false;
		if (enemyWin) {
			GameController.setOnBattle(false);
			GameController.getMainPanel().textTransition("You lose");
			return;
		}
		nextTurn();
	}

	public static void setSelectEnemyUnit() {
		Stage stage = GameController.getNowStage();
		for (int i = 0; i < stage.getUnitAtWave(wave - 1).length; i++) {
			if (stage.getUnitAtWave(wave - 1)[i] == null)
				continue;
			UnitStats nextUnit = (UnitStats) stage.getUnitAtWave(wave - 1)[i];
			if (!nextUnit.getIsDead()) {
				GameController.setSelectEnemyUnit(stage.getUnitAtWave(wave - 1)[i]);
				break;
			}
		}
		GameController.setChooseIcon();
	}

	public static void setSelectAllyUnit() {
		for (int i = 0; i < 3; i++) {
			AllyUnit u = GameController.getPlayer().getUnits()[i];
			if (u == null || u.getIsDead()) {
				continue;
			}
			GameController.setSelectAllyUnit(u);
			GameController.updateAllyInfo();
			GameController.setChooseIcon();
			break;
		}
	}

	private static boolean isWaveEnd() {
		return bot.getNumberOfUnit() == 0;
	}

	private static void nextTurn() {
		turn += 1;
		numberOfTakenAction = 0;
		maxPlayerAction = 0;
		for (AllyUnit unit : GameController.getPlayer().getUnits()) {
			if (unit != null && !unit.getIsStun()) {
				unit.setCanTakeAction(true);
				maxPlayerAction += 1;
			}
		}
		if(maxPlayerAction == 0) {
			checkPlayerTurnEnd();
			return ;
		}
//		decreaseSkillCooldown(GameController.getPlayer().getUnits());
//		decreaseEffectDuration(GameController.getPlayer().getUnits());
//		checkEffect(GameController.getPlayer().getUnits());
//		increseUltiGauge(GameController.getPlayer().getUnits());
		GameController.updateAllyInfo();
		GameController.updateEnemyInfoPanel();
		GameController.updateBattlePanel();
	}

	private static void nextWave() {
		if (wave == GameController.getNowStage().getNumberOfWave()) {
			GameController.getPlayer()
					.setMoney(GameController.getPlayer().getMoney() + GameController.getNowStage().getMoneyDrop());
			if (GameController.getNowStage().isBoss()) {
				GameController.setIsWin(true);
				GameController.setOnBattle(false);
				GameController.getMainPanel().textTransition("You win");
				return ;
			} else {
				GameController.getMainPanel().textTransition("Victory");
			}
			GameController.playBGSound();
		} else {
			wave += 1;
			nextTurn();
			bot = new Bot(GameController.getNowStage().getUnitAtWave(wave - 1));
			setSelectEnemyUnit();
			GameController.setNewWave();
			GameController.setChooseIcon();
			GameController.updateAllyInfo();
			GameController.updateEnemyInfoPanel();
			GameController.getMainPanel().textTransition("Wave " + wave);
		}
	}

	public static void increaseNumberOfTakenAction() {
		numberOfTakenAction += 1;
	}

	public static void attack(Unit attack, Unit defense) {
		UnitStats attacker = (UnitStats) attack;
		UnitStats defender = (UnitStats) defense;
		attacker.attack(defender);
		if (defender.getCurrentHP() <= 0) {
			defender.setIsDead(true);
			GameController.updateBattlePanelView();
			if (defender instanceof AllyUnit) {
				if (defender.equals(GameController.getSelectAllyUnit())) {
					setSelectAllyUnit();
				}
				if (GameController.getPlayer().getNumberOfBackUnit() <= 0
						&& GameController.getPlayer().getNumberOfFrontUnit() == 0) {
					enemyWin = true;
				}
				playerUnitKilled = true;
			}
			GameController.setChooseIcon();
		}
		if (!enemyTurn) {
			GameController.playSound(GameController.getAttackSound());
			afterTakeAction();
		}
	}

	public static void defense() {
		GameController.getSelectAllyUnit().defense();
		if (!enemyTurn) {
			GameController.playSound(GameController.getBuffSound());
			afterTakeAction();
		}
	}

	public static void swap() {
		GameController.updateBattlePanelView();
		afterTakeAction();
	}

	public static void useSkillTo(Unit target) {
		skill.use(GameController.getSelectAllyUnit(), target);
		if (skill instanceof NormalSkill) {
			NormalSkill s = (NormalSkill) skill;
			s.setCooldown(s.getCooldownTime());
		}else {
			GameController.getSelectAllyUnit().setUltiGauge(0);
		}
	}

	public static void checkEffect(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			for (Effect e : ((UnitStats) u).getEffects()) {
				if (e.getSubSkill() instanceof Heal && e.getDuration() != (e.getSubSkill()).getDuration()) {
					Heal skill = (Heal) e.getSubSkill();
					skill.heal(u);
				} else if (e.getSubSkill() instanceof DOTDamage && e.getDuration() != (e.getSubSkill()).getDuration()) {
					DOTDamage dot = (DOTDamage) e.getSubSkill();
					dot.damaged(u);
				} else if (e.getSubSkill() instanceof IncreaseUltiGauge
						&& e.getDuration() != (e.getSubSkill()).getDuration()) {
					IncreaseUltiGauge skill = (IncreaseUltiGauge) e.getSubSkill();
					skill.increaseGauge(u);
				}
			}
		}
	}

	public static void decreaseEffectDuration(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			ArrayList<Effect> removed = new ArrayList<Effect>();
			for (Effect e : ((UnitStats) u).getEffects()) {
				e.setDuration(e.getDuration() - 1);
				if (e.getDuration() == 0) {
					removed.add(e);
				}
			}
			for (Effect e : removed) {
				((UnitStats) u).removeEffect(e);
			}
		}
	}

	public static void decreaseSkillCooldown(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			if (u instanceof AdvanceUnit) {
				for (Skill s : ((AdvanceUnit) u).getSkills()) {
					if (s instanceof NormalSkill)
						((NormalSkill) s).setCooldown(((NormalSkill) s).getCooldown() - 1);
				}
			}
		}
	}

	public static void playerUnitKilled() {
		setSelectAllyUnit();
		GameController.setChooseIcon();
		if (GameController.getPlayer().getNumberOfBackUnit() > 0) {
			// replace unit
			for (AllyUnit u : GameController.getPlayer().getUnits()) {
				if (u == null) {
					continue;
				}
				if (u.getIsDead()) {
					GameController.setDeathUnit(u);
					GameController.setReplacePanel(true);
					break;
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				if (GameController.getPlayer().getUnits()[i] != null
						&& GameController.getPlayer().getUnits()[i].getIsDead()) {
					GameController.getPlayer().getUnits()[i] = null;
				}
			}
			if (GameController.getPlayer().getNumberOfUnit() <= 0) {
				enemyWin = true;
			}
		}
	}

	public static void reset() {
		GameController.getNowStage().setClear(true);
		GameController.setOnBattle(false);
		for (int i = 0; i < 3; i++) {
			if (GameController.getPlayer().getUnits()[i] != null
					&& GameController.getPlayer().getUnits()[i].getIsDead()) {
				GameController.getPlayer().getUnits()[i] = null;
			}
			if (GameController.getPlayer().getBackUnits()[i] != null
					&& GameController.getPlayer().getBackUnits()[i].getIsDead()) {
				GameController.getPlayer().getUnits()[i] = null;
			}
		}
		for (AllyUnit unit : GameController.getPlayer().getUnits()) {
			if (unit != null) {
				unit.setCanTakeAction(true);
			}
		}
		for (AllyUnit u : GameController.getPlayer().getUnits()) {
			if (u == null) {
				continue;
			}
			for (Skill s : ((AdvanceUnit) u).getSkills()) {
				if (s instanceof NormalSkill)
					((NormalSkill) s).setCooldown(0);
			}
			ArrayList<Effect> removed = new ArrayList<Effect>();
			for (Effect e : ((UnitStats) u).getEffects()) {
				removed.add(e);
			}
			for (Effect e : removed) {
				((UnitStats) u).removeEffect(e);
			}
		}
		for (AllyUnit u : GameController.getPlayer().getBackUnits()) {
			if (u == null) {
				continue;
			}
			for (Skill s : ((AdvanceUnit) u).getSkills()) {
				if (s instanceof NormalSkill)
					((NormalSkill) s).setCooldown(0);
			}
			ArrayList<Effect> removed = new ArrayList<Effect>();
			for (Effect e : ((UnitStats) u).getEffects()) {
				removed.add(e);
			}
			for (Effect e : removed) {
				((UnitStats) u).removeEffect(e);
			}
		}
		GameController.updateAllyInfo();
		GameController.updateAllyView();
		GameController.updateMapPanel();
		GameController.setToButtonPanel();
		GameController.viewAllyUnit();
	}

	public static void increseUltiGauge(Unit[] units) {
		for (int i = 0; i < units.length; i++) {
			if (units[i] == null)
				continue;
			if (units[i] instanceof AdvanceUnit) {
				AdvanceUnit unit = (AdvanceUnit) units[i];
				if (unit.getIsDead())
					continue;
				unit.setUltiGauge(unit.getUltiGauge() + 1);
			}
		}
	}

	public static int getWave() {
		return wave;
	}

	public static int getTurn() {
		return turn;
	}

	public static void setPlayerUnitKilled(boolean bool) {
		playerUnitKilled = bool;
	}

	public static boolean getEnemyTurn() {
		return enemyTurn;
	}

	public static void setEnemyWin(boolean bool) {
		enemyWin = bool;
	}

	public static boolean getEnemyWin() {
		return enemyWin;
	}

	public static int getEnemyTimeCount() {
		return enemyTimeCount;
	}

	public static void setEnemyTimeCount(int time) {
		if (time < 0)
			time = 0;
		enemyTimeCount = time;
	}
}
