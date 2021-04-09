package Skill;

import java.util.ArrayList;

import SubSkill.Damage;
import SubSkill.SubSkill;
import UnitBase.Unit;

public class UltimateSkill extends Skill {

	public UltimateSkill(String name, String description, ArrayList<SubSkill> subSkills, boolean toYourSelf,
			boolean isSingle, boolean toAlly) {
		super(name, description, subSkills, toYourSelf, isSingle, toAlly);

	}

	public UltimateSkill(Skill skill) {
		super(skill.getName(), skill.getDescription(), skill.getSubSkills(), skill.getToYourSelf(), skill.getIsSingle(),
				skill.getToAlly());
	}

	public void use(Unit user, Unit target) {
		for (SubSkill s : subSkills) {
			if (s instanceof Damage) {
				((Damage) s).damaged(user, target);
			} else {
				s.activate(target);
			}
		}
	}

	@Override
	public String toString() {
		String str = this.name + "\n";
		str += "    " + this.description;
		return str;
	}
}
