package UnitBase;

import Skill.*;

public class AllyUnit extends AdvanceUnit {

	private int level;
	final static int maxLevel = 5;
	private int[] statFactors;
	private int[] skillRequirement;

	public AllyUnit(String name, String _class, int[] stats, Skill[] skills, int[] statFactors,
			int[] skillRequirement) {
		super(name, _class, stats, skills);
		this.level = 1;

		this.statFactors = new int[statFactors.length];
		for (int i = 0; i < statFactors.length; i++)
			this.statFactors[i] = statFactors[i];
		this.skillRequirement = new int[skillRequirement.length];
		for (int i = 0; i < skillRequirement.length; i++)
			this.skillRequirement[i] = skillRequirement[i];
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = Math.min(level, maxLevel);
	}

	public void levelup() {
		double factor = statFactors[getLevel()] + 100;
		this.setMaxHP((int) (0.01 * factor * this.getMaxHP()));
		this.setAttack((int) (0.01 * factor * this.getAttack()));
		setLevel(getLevel() + 1);
	}

	public String toString() {
		String str;
		str = this.getName() + "\n";
		str += "HP : " + this.getMaxHP() + "\n";
		str += "Attack : " + this.getTotalAttack() + "\n";
		str += "Defense : " + this.getDefense() + "\n";
		str += "CritChance : " + this.getCritChance() + "\n";
		str += "CritDamage : " + this.getCritDamage() + "\n";
		str += "DodgeChance : " + this.getDodgeChance() + "\n";
		str += "Gauge : 0/" + this.getMaxUltigauge() + "\n";
		str += "Level : " + this.level + "/5\n";
		str += "Skills\n";
		for (int i = 0; i < this.getMaxSkill(); i++) {
			Skill skill = this.getSkills()[i];
			str += "[" + (i + 1) + "] " + skill.getName();
			if (skill instanceof NormalSkill) {
				if (level >= skillRequirement[i])
					str += "\t\t Cooldown " + ((NormalSkill) skill).getCooldownTime() + " turn(s)\n";
				else
					str += "\t\t [ Unlock at level : " + skillRequirement[i] + " ]\n";
			} else {
				str += "\n";
			}
			str += "    " + skill.getDescription() + "\n\n";
		}
		return str;
	}

}
