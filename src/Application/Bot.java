package Application;

import java.util.ArrayList;
import java.util.Random;

import Skill.NormalSkill;
import Skill.Skill;
import SubSkill.*;
import UnitBase.AdvanceUnit;
import UnitBase.*;

public class Bot {

	public Unit[] units;
	private int numberOfUnit = 0;

	public Bot(Unit[] units) {
		this.units = new Unit[3];
		for (int i = 0; i < 3; i++) {
			if (units[i] == null) {
				this.units[i] = null;
			} else {
				if (units[i] instanceof BasicUnit) {
					this.units[i] = new BasicUnit((BasicUnit) (units[i]));
					this.numberOfUnit += 1;
				} else if (units[i] instanceof AdvanceUnit) {
					this.units[i] = new AdvanceUnit((AdvanceUnit) (units[i]));
					this.numberOfUnit += 1;
				}
			}
		}
	}

	public int getNumberOfUnit() {
		return this.numberOfUnit;
	}

	public Unit[] getUnits() {
		return this.units;
	}

	public void play(Unit[] targets) {
		// Random ran = new Random();
		System.out.println("------Enemy turn------");
		for (int i = 0; i < 3; i++) {
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
			if (Battle.isEnd(targets))
				break;
		}
		System.out.println("----------------------");
	}

	public void BasicUnitAction(Unit[] targets, int idx) {
		Random ran = new Random();
		int num = ran.nextInt(100);
		if (num < 70) {
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
			Battle.attack(units[idx], targets[targetIdx]);
		} else {
			// Defense
			System.out.println(this.units[idx].getName() + " defense up");
			((UnitAction) units[idx]).defense();
		}
	}

	public void AdvanceUnitAction(Unit[] targets, int idx) {
		AdvanceUnit unit = (AdvanceUnit) units[idx];
		if (unit.getUltiGauge() == unit.getMaxUltigauge()) {
			// useUlti
		}
		if (shouldHeal(idx)) {
			for (int i = 0; i < unit.getMaxSkill(); i++) {
				for (SubSkill s : unit.getSkills()[i].getSubSkills()) {
					if (unit.getSkills()[i] instanceof NormalSkill) {
						if ((s instanceof Heal) && (((NormalSkill) unit.getSkills()[i]).getCooldown() == 0)) {
							heal(unit, i);
							return;
						}
					}
				}
			}
		}
		Random ran = new Random();
		int num = ran.nextInt(100);
		ArrayList<Integer> useableSkill = useableSkill(idx);
		System.out.println(units[idx].getName());
		System.out.println(useableSkill.size());
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
		if (num < 50) {
			// Attack
			if (tauntCheck(targets) != -1)
				targetIdx = tauntCheck(targets);
			System.out.println(units[idx].getName() + " attacked " + targets[targetIdx].getName());
			// sleep(1000);
			Battle.attack(units[idx], targets[targetIdx]);
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
			Battle.attack(units[idx], targets[targetIdx]);
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
			if ((unit.getSkills()[i] instanceof NormalSkill) && ((NormalSkill) unit.getSkills()[i]).getCooldown() == 0) {
				skills.add(i);
			}
		}
		return skills;
	}

	public void heal(AdvanceUnit skillUser, int skillIdx) {
		if (skillUser.getSkills()[skillIdx].getIsSingle()) {
			int max = 0;
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				if (nullOrDead(i))
					continue;
				int num = 0;
				UnitStats unit = (UnitStats) units[i];
				if ((int) (unit.getCurrentHP() * 100 / unit.getMaxHP()) < 60) {
					num += 1;
					if (unit instanceof AdvanceUnit)
						num += 1;
					if ((int) (unit.getCurrentHP() * 100 / unit.getMaxHP()) < 30)
						num += 2;
				}
				if (num > max) {
					max = num;
					idx = i;
				}
			}
			skillUser.getSkills()[skillIdx].use(skillUser, units[idx]);
		} else {
			for (int i = 0; i < 3; i++) {
				if (nullOrDead(i))
					continue;
				skillUser.getSkills()[skillIdx].use(skillUser, units[i]);
			}
		}
	}

	public void useSkill(Unit[] targets, AdvanceUnit skillUser, int skillIdx, int targetIdx) {
		Skill skill = skillUser.getSkills()[skillIdx];
		if (skill.getIsSingle()) {
			if (skill.getToAlly()) {
				System.out.println(skillUser.getName() + " used skill to " + units[targetIdx].getName());
				skill.use(skillUser, units[targetIdx]);
			} else {
				System.out.println(skillUser.getName() + " used skill to " + targets[targetIdx].getName());
				skill.use(skillUser, targets[targetIdx]);
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
				}
				System.out.println(skillUser.getName() + " used skill to all of your units");
			}
		}
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
