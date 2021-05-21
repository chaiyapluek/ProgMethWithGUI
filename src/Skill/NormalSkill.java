package Skill;

import java.util.ArrayList;

import SubSkill.Damage;
import SubSkill.SubSkill;
import UnitBase.Unit;
import UnitBase.UnitStats;
import logic.BattleController;
import logic.GameController;

public class NormalSkill extends Skill {

	private int cooldownTime;
	private int cooldown;

	public NormalSkill(String name, String description, ArrayList<SubSkill> subSkills, int cooldownTime,
			boolean toYourSelf, boolean isSingle, boolean toAlly) {
		super(name, description, subSkills, toYourSelf, isSingle, toAlly);

		this.cooldownTime = cooldownTime;
		this.cooldown = 0;

	}

	public NormalSkill(Skill skill) {
		// TODO Auto-generated constructor stub
		super(skill.getName(), skill.getDescription(), skill.getSubSkills(), skill.getToYourSelf(), skill.getIsSingle(),
				skill.getToAlly());

		this.cooldown = ((NormalSkill) skill).getCooldownTime();
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
		int cnt = 0;
		this.cooldown = this.getCooldownTime();
		if (((UnitStats) target).getIsDead()) {
			return;
		}
		for (SubSkill s : subSkills) {
			if (s instanceof Damage) {
				((Damage) s).damaged(user, target, cnt);
				cnt += 1;
			} else {
				s.activate(target);
				if (BattleController.getEnemyTurn()) {
					int currentTime = BattleController.getEnemyTimeCount();
					GameController.getMainPanel().addTextToShow(s.getDescription(), target, currentTime);
					BattleController.setEnemyTimeCount(currentTime + 500);
				} else {
					GameController.getMainPanel().addTextToShow(s.getDescription(), target, 500 * (cnt++));
				}
			}
		}

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
