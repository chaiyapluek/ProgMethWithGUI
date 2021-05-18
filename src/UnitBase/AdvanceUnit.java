package UnitBase;

import Skill.*;

public class AdvanceUnit extends UnitAction {

	private int ultiGauge;
	private int maxUltigauge;
	private int maxSkill;
	private Skill[] skills;

	public AdvanceUnit(String name, String _class, int[] stats, Skill[] skills) {
		super(name, _class, stats);
		this.ultiGauge = 0;
		this.maxUltigauge = stats[6];
		this.maxSkill = skills.length;
		this.skills = new Skill[this.maxSkill];
		for (int i = 0; i < this.maxSkill; i++) {
			this.skills[i] = skills[i];
		}
	}

	public AdvanceUnit(AdvanceUnit unit) {
		super(unit.getName(), unit.get_Class(), unit.getStats());
		this.ultiGauge = 0;
		this.maxUltigauge = unit.getStats()[6];
		this.maxSkill = unit.getMaxSkill();
		this.skills = new Skill[maxSkill];
		for (int i = 0; i < maxSkill; i++) {
			if (unit.getSkills()[i] instanceof NormalSkill)
				this.skills[i] = new NormalSkill(unit.getSkills()[i]);
			else
				this.skills[i] = new UltimateSkill(unit.getSkills()[i]);
		}
	}

	public int getUltiGauge() {
		return ultiGauge;
	}

	public void setUltiGauge(int ultiGauge) {
		if (ultiGauge < 0)
			ultiGauge = 0;
		this.ultiGauge = Math.min(ultiGauge, this.maxUltigauge);
	}

	public int getMaxUltigauge() {
		return maxUltigauge;
	}

	public void setMaxUltigauge(int maxUltigauge) {
		this.maxUltigauge = maxUltigauge;
	}

	public int getMaxSkill() {
		return this.maxSkill;
	}

	public Skill[] getSkills() {
		return this.skills;
	}

	public int[] getStats() {
		int[] stats = new int[7];
		stats[0] = this.getMaxHP();
		stats[1] = this.getDefense();
		stats[2] = this.getAttack();
		stats[3] = this.getCritChance();
		stats[4] = this.getCritDamage();
		stats[5] = this.getDodgeChance();
		stats[6] = this.getMaxUltigauge();
		return stats;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "Name \t\t: " + this.getName() + "\n";
		info += "Class \t\t: " + this.get_Class() + "\n";
		info += "HP \t\t: " + this.getCurrentHP() + "/" + this.getMaxHP() + "\n";
		info += "Attack \t\t: " + this.getTotalAttack() + "\n";
		info += "Defense \t: " + this.getDefense() + "\n";
		info += "CritChance \t" + this.getCritChance() + "\n";
		info += "CritDamage \t" + this.getCritDamage() + "\n";
		info += "DodgeChance \t" + this.getDodgeChance() + "\n";
		info += "Ulti gauge \t: " + this.getUltiGauge() + "/" + this.getMaxUltigauge() + "\n";

		info += "Skill(s)\n";
		for (int i = 0; i < this.maxSkill; i++) {
			info += "[" + (i + 1) + "] " + skills[i].getName() + "\tCooldown "
					+ ((NormalSkill) skills[i]).getCooldownTime() + " turn(s)";
			info += "\n" + ((NormalSkill) skills[i]).getCooldown();
			info += "\n    " + skills[i].getDescription() + "\n";
		}
		return info;
	}

}
