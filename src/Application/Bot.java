package Application;

import java.util.ArrayList;
import java.util.Random;

import Skill.NormalSkill;
import Skill.Skill;
import SubSkill.*;
import UnitBase.AdvanceUnit;
import logic.BattleController;
import logic.GameController;
import UnitBase.*;

public class Bot {

	public Unit[] units;

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
		System.out.println("------Enemy turn------");
		for (int i = 0; i < 3; i++) {
			if(BattleController.getEnemyWin()) {
				System.out.println("You lose, FOOL!!");
				break;
			}
			System.out.println(i);
			if (nullOrDead(i))
				continue;
			if (((UnitStats) units[i]).getIsStun())
				continue;
			// sleep(1000);
			System.out.println(this.units[i].getName() + " turn");
			// sleep(1000);
			if (units[i] instanceof BasicUnit) {
				BasicUnitAction(targets, i);
			} else if (this.units[i] instanceof AdvanceUnit) {
				AdvanceUnitAction(targets, i);
			}
		}
		System.out.println("----------------------");
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
			System.out.println(units[idx].getName() + " attacked " + targets[targetIdx].getName());
			// sleep(1000);
			BattleController.attack(units[idx], targets[targetIdx]);
		} else {
			// Defense
			System.out.println(this.units[idx].getName() + " defense up");
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
			return;
		}
		if (num < 50) {
			// Attack
			
			System.out.println(units[idx].getName() + " attacked " + targets[targetIdx].getName());
			BattleController.attack(units[idx], targets[targetIdx]);
		} else if (num < 60) {
			// Defense
			System.out.println(this.units[idx].getName() + " defense up");
			((UnitAction) units[idx]).defense();
		} else if (num >= 60 && useableSkill.size() > 0) {
			// Use Skill
			int rand = ran.nextInt(useableSkill.size());
			int skillIdx = useableSkill.get(rand);
			useSkill(targets, (AdvanceUnit) units[idx], skillIdx, targetIdx);
		} else {
			System.out.println(units[idx].getName() + " attacked " + targets[targetIdx].getName());
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
					System.out.println(skillUser.getName() + " used skill to " + units[targetIdx].getName());
					skill.use(skillUser, units[targetIdx]);
				} else {
					System.out.println(skillUser.getName() + " used skill to " + targets[targetIdx].getName());
					skill.use(skillUser, targets[targetIdx]);
					if(((UnitStats)targets[targetIdx]).getCurrentHP()<=0) {
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
					System.out.println(skillUser.getName() + " used skill to all of their units");
				} else {
					for (int i = 0; i < 3; i++) {
						if (targets[i] == null)
							continue;
						if (((UnitStats) targets[i]).getIsDead())
							continue;
						skill.use(skillUser, targets[i]);
						if(((UnitStats)targets[i]).getCurrentHP()<=0) {
							((UnitStats) targets[i]).setIsDead(true);
							BattleController.setPlayerUnitKilled(true);
						}
					}
					System.out.println(skillUser.getName() + " used skill to all of your units");
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

	public boolean shouldHeal(int idx) {
		int num = 0;
		for (int i = 0; i < 3; i++) {
			if (units[i] == null)
				continue;
			UnitStats unit = (UnitStats) units[i];
			if ((int) (unit.getCurrentHP() * 100 / unit.getMaxHP()) < 60) {
				if (units[i] instanceof BasicUnit)
					num += 1;
				else
					num += 2;
			}
		}
		return num >= 2;
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
