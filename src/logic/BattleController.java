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
import UnitBase.*;
import gui.ActionButton;

public class BattleController {

	private static Bot bot;
	private static int wave;
	private static int turn;
	private static int numberOfTakenAction;
	private static Skill skill;

	private static boolean enemyTurn = false;

	public static void initializeBattle() {

		bot = new Bot(GameController.getNowStage().getUnitAtWave(0));
		wave = 1;
		turn = 1;
		numberOfTakenAction = 0;
		GameController.updateEnemyInfoPanel();
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
			System.out.println(skill.getName());
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
			
			System.out.println("ENEMYTURN");
			enemyTurn = true;
			decreaseSkillCooldown(bot.getUnits());
			decreaseEffectDuration(bot.getUnits());
			checkEffect(bot.getUnits());
			bot.play(GameController.getPlayer().getUnits());
			enemyTurn = false;
			increseUltiGauge(bot.getUnits());
			nextTurn();
		}
	}

	private static void setSelectEnemyUnit() {
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
		decreaseSkillCooldown(GameController.getPlayer().getUnits());
		decreaseEffectDuration(GameController.getPlayer().getUnits());
		checkEffect(GameController.getPlayer().getUnits());
		increseUltiGauge(GameController.getPlayer().getUnits());
		GameController.updateAllyInfo();
		GameController.updateEnemyInfoPanel();
		GameController.updateBattlePanel();
	}

	private static void nextWave() {
		if (wave == GameController.getNowStage().getNumberOfWave()) {
			System.out.println("VICTORY");
			GameController.getNowStage().setClear(true);
			GameController.setOnBattle(false);
			for (AllyUnit unit : GameController.getPlayer().getUnits()) {
				if (unit != null) {
					unit.setCanTakeAction(true);
				}
			}
			reset();
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
			GameController.setChooseIcon();
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
		if (!enemyTurn) {
			afterTakeAction();
		}
	}

	public static void defense() {
		GameController.getSelectAllyUnit().defense();
		if (!enemyTurn) {
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
					System.out.println(u.getName() + " " + (int) (1.0 * ((UnitStats)u).getMaxHP() * skill.getHealAmount() / 100) + " HP up");
				} else if (e.getSubSkill() instanceof DOTDamage && e.getDuration() != (e.getSubSkill()).getDuration()) {
					DOTDamage dot = (DOTDamage) e.getSubSkill();
					dot.damaged(u);
				} else if (e.getSubSkill() instanceof IncreaseUltiGauge && e.getDuration() != (e.getSubSkill()).getDuration()) {
					IncreaseUltiGauge skill = (IncreaseUltiGauge) e.getSubSkill();
					skill.increaseGauge(u);
					System.out.println(u.getName() + " gauge up by " + skill.getIncreaseAmount() );
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
					if(s instanceof NormalSkill)
						((NormalSkill) s).setCooldown(((NormalSkill) s).getCooldown() - 1);
				}
			}
		}
	}
	
	public static void reset() {
		for(AllyUnit u : GameController.getPlayer().getUnits()) {
			if(u == null) {
				continue;
			}
			for (Skill s : ((AdvanceUnit) u).getSkills()) {
				if(s instanceof NormalSkill)
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
		for(AllyUnit u : GameController.getPlayer().getBackUnits()) {
			if(u == null) {
				continue;
			}
			for (Skill s : ((AdvanceUnit) u).getSkills()) {
				if(s instanceof NormalSkill)
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
}
