package Skill;

import java.util.ArrayList;

import SubSkill.Damage;
import SubSkill.SubSkill;
import UnitBase.Unit;

public class NormalSkill extends Skill{
	
	private int cooldownTime;
	private int cooldown;
	
	public NormalSkill(String name, String description, ArrayList<SubSkill> subSkills, int cooldownTime, boolean toYourSelf,
			boolean isSingle, boolean toAlly) {
		super(name,description,subSkills,toYourSelf,isSingle,toAlly);
		
		this.cooldownTime = cooldownTime;
		this.cooldown = 0;
		
	}

	public NormalSkill(Skill skill) {
		// TODO Auto-generated constructor stub
		super(skill.getName(), skill.getDescription(), skill.getSubSkills(), skill.getToYourSelf(), skill.getIsSingle(),
				skill.getToAlly());
		
		this.cooldown = ((NormalSkill)skill).getCooldownTime();
		this.cooldown = 0;
	}

	public int getCooldownTime() {
		return this.cooldownTime;
	}
	
	public void setCooldown(int cooldown) {
		this.cooldown = Math.max(0, cooldown);
	}

	public int getCooldown() {
		return this.cooldown;
	}
	
	public void use(Unit user, Unit target) {
		for (SubSkill s : subSkills) {
			if (s instanceof Damage) {
				((Damage) s).damaged(user, target);
			} else {
				s.activate(target);
			}
		}
		this.cooldown = this.getCooldownTime();
	}
	
	public String toString() {
		String str = this.name + "\t";
		if (this.cooldown == 0)
			str += "[Available]\n";
		else
			str += "cooldown " + this.getCooldown() + " turn(s)\n";
		str += "    " + this.description;
		return str;
	}
	
}
