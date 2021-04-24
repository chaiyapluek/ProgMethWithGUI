package UnitBase;

import Skill.*;

public class AllyUnit extends AdvanceUnit {

	private int level;
	final static int maxLevel = 5;
	private int[] statFactors;
	private int[] skillRequirement;
	private boolean canTakeAction = true;
	private int price = 10000;
	
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
	
	public String getShopInfo() {
		String info = "Name \t\t: " + this.getName() + "\n";
		info += "Price\t\t:" + this.getPrice()+"\n";
		info += "Class \t\t: " + this.get_Class() + "\n";
		info += "HP \t\t: " + this.getCurrentHP() + "/" + this.getMaxHP() + "\n";
		info += "Attack \t\t: " + this.getTotalAttack() + "\n";
		info += "Defense \t: " + this.getDefense() + "\n";
		info += "CritChance \t" + this.getCritChance() + "\n";
		info += "CritDamage \t" + this.getCritDamage() + "\n";
		info += "DodgeChance \t" + this.getDodgeChance() + "\n";
		info += "Ulti gauge \t: " + this.getUltiGauge() + "/" + this.getMaxUltigauge() + "\n";

		info += "Skill(s)\n";
		for (int i = 0; i < this.getMaxSkill(); i++) {
			if(getSkills()[i] instanceof NormalSkill) {
				info += "[" + (i+1) + "] " + getSkills()[i].getName() + "\tCooldown " + ((NormalSkill) getSkills()[i]).getCooldownTime() + " turn(s)";
				info += "\n" + ((NormalSkill) getSkills()[i]).getCooldown();
				info += "\n    " + getSkills()[i].getDescription() + "\n";
			}
			else {
				info += "[" + (i+1) + "] ";
				info += getSkills()[i].toString();
			}
		}
		return info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
