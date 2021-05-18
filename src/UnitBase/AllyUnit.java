package UnitBase;

import Skill.*;

public class AllyUnit extends AdvanceUnit {

	private int level;
	final static int maxLevel = 5;
	private int[] statFactors;
	private int[] skillRequirement;
	private boolean canTakeAction = true;
	
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

	public int getSkillRequirement(int i) {
		return skillRequirement[i];
	}
	
	public boolean canTakeAction() {
		return canTakeAction;
	}
	
	public void setCanTakeAction(boolean bool) {
		canTakeAction = bool;
	}
	
	public void levelup() {
		double factor = statFactors[getLevel()] + 100;
		this.setMaxHP((int) (0.01 * factor * this.getMaxHP()));
		this.setAttack((int) (0.01 * factor * this.getAttack()));
		setLevel(getLevel() + 1);
	}
		
}
