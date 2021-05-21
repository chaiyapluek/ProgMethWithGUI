package Skill;

import java.util.ArrayList;

import SubSkill.Damage;
import SubSkill.SubSkill;
import UnitBase.Unit;
import UnitBase.UnitStats;
import logic.BattleController;
import logic.GameController;

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
		int cnt = 0;
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

	@Override
	public String toString() {
		String str = this.name + "\n";
		str += "    " + this.description;
		return str;
	}
}
