package Application;

import java.util.ArrayList;
import java.util.Random;

import Skill.NormalSkill;
import Skill.Skill;
import Unit.*;
import javafx.application.Platform;
import logic.BattleController;
import logic.GameController;

public class Bot {

	private Unit[] units;

	public Bot(Unit[] units) {
		this.units = new Unit[3];
		for (int i = 0; i < 3; i++) {
			this.units[i] = units[i];
		}
	}

	public int getNumberOfUnit() {
		int num = 0;
		for (int i = 0; i < 3; i++) {
			if (!nullOrDead(i)) {
				num += 1;
			}
		}
		return num;
	}

	public Unit[] getUnits() {
		return this.units;
	}

	public void play(Unit[] targets) {
		// Random ran = new Random();
		BattleController.setEnemyTimeCount(0);
		for (int i = 0; i < 3; i++) {
			if (nullOrDead(i))
				continue;
			if (((UnitStats) units[i]).getIsStun()) {
				continue;
			}
			if (units[i] instanceof BasicUnit) {
				BasicUnitAction(targets, i);
			} else if (units[i] instanceof AdvanceUnit) {
				AdvanceUnitAction(targets, i);
			}
		}
		Thread thread = new Thread(() -> {
			GameController.getMainPanel().showText();
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					BattleController.enemyTurnEnd();
				}
			});
		});
		thread.start();
	}

	public void BasicUnitAction(Unit[] targets, int idx) {
		Random ran = new Random();
		int num = ran.nextInt(100);
		if (num < 90) {
			// Attack
			int targetIdx = ran.nextInt(3);
			while (true) {
				if (targets[targetIdx] == null) {
					targetIdx = ran.nextInt(3);
					continue;
				}
				if (!((UnitStats) targets[targetIdx]).getIsDead())
					break;
				targetIdx = ran.nextInt(3);
			}
			if (tauntCheck(targets) != -1)
				targetIdx = tauntCheck(targets);
			// sleep(1000);
			BattleController.attack(units[idx], targets[targetIdx]);
		} else {
			// Defense
			((UnitAction) units[idx]).defense();
		}
	}

	public void AdvanceUnitAction(Unit[] targets, int idx) {
		AdvanceUnit unit = (AdvanceUnit) units[idx];
		Random ran = new Random();
		int num = ran.nextInt(100);
		ArrayList<Integer> useableSkill = useableSkill(idx);
		int targetIdx = ran.nextInt(3);
		while (true) {
			if (targets[targetIdx] == null) {
				targetIdx = ran.nextInt(3);
				continue;
			}
			if (!((UnitStats) targets[targetIdx]).getIsDead())
				break;
			targetIdx = ran.nextInt(3);
		}
		if (tauntCheck(targets) != -1)
			targetIdx = tauntCheck(targets);
		if (unit.getUltiGauge() == unit.getMaxUltigauge()) {
			// useUlti
			useSkill(targets, unit, unit.getMaxSkill() - 1, targetIdx);
			unit.setUltiGauge(0);
			return;
		}
		if (num < 50) {
			// Attack
			BattleController.attack(units[idx], targets[targetIdx]);
		} else if (num < 60) {
			// Defense
			((UnitAction) units[idx]).defense();
		} else if (num >= 60 && useableSkill.size() > 0) {
			// Use Skill
			int rand = ran.nextInt(useableSkill.size());
			int skillIdx = useableSkill.get(rand);
			useSkill(targets, (AdvanceUnit) units[idx], skillIdx, targetIdx);
		} else {
			// sleep(1000);
			BattleController.attack(units[idx], targets[targetIdx]);
		}
	}

	public int tauntCheck(Unit[] targets) {
		int idx = -1;
		for (int i = 0; i < 3; i++) {
			if (targets[i] == null)
				continue;
			UnitStats target = (UnitStats) targets[i];
			if (target.getIsDead())
				continue;
			if (target.getIsTaunt()) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	public ArrayList<Integer> useableSkill(int idx) {
		ArrayList<Integer> skills = new ArrayList<Integer>();
		AdvanceUnit unit = (AdvanceUnit) units[idx];
		for (int i = 0; i < unit.getMaxSkill(); i++) {
			if ((unit.getSkills()[i] instanceof NormalSkill)
					&& ((NormalSkill) unit.getSkills()[i]).getCooldown() == 0) {
				skills.add(i);
			}
		}
		return skills;
	}

	public void useSkill(Unit[] targets, AdvanceUnit skillUser, int skillIdx, int targetIdx) {
		Skill skill = skillUser.getSkills()[skillIdx];
		if (skill.getToYourSelf()) {
			skill.use(skillUser, skillUser);
		} else {
			if (skill.getIsSingle()) {
				if (skill.getToAlly()) {
					skill.use(skillUser, units[targetIdx]);
				} else {
					skill.use(skillUser, targets[targetIdx]);
					if (((UnitStats) targets[targetIdx]).getCurrentHP() <= 0) {
						((UnitStats) targets[targetIdx]).setIsDead(true);
						BattleController.setPlayerUnitKilled(true);
					}
				}
			} else {
				if (skill.getToAlly()) {
					for (int i = 0; i < 3; i++) {
						if (nullOrDead(i))
							continue;
						skill.use(skillUser, units[i]);
					}
				} else {
					for (int i = 0; i < 3; i++) {
						if (targets[i] == null)
							continue;
						if (((UnitStats) targets[i]).getIsDead())
							continue;
						skill.use(skillUser, targets[i]);
						if (((UnitStats) targets[i]).getCurrentHP() <= 0) {
							((UnitStats) targets[i]).setIsDead(true);
							BattleController.setPlayerUnitKilled(true);
						}
					}
				}
			}
		}
		GameController.updateBattlePanel();
		GameController.updateAllyInfo();
		GameController.updateEnemyInfoPanel();
	}

	public boolean nullOrDead(int idx) {
		if (units[idx] == null)
			return true;
		if (((UnitStats) units[idx]).getIsDead())
			return true;
		return false;
	}

	public void sleep(int mi) {
		try {
			Thread.sleep(mi);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
