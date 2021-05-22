package SubSkill;

import Skill.Effect;
import SubSkillBase.Activatable;
import Unit.Unit;
import Unit.UnitStats;

public class Heal extends SubSkill implements Activatable{

	private int healAmount;

	public Heal(int duration, int healAmount) {
		super("[ Heal ]", duration);
		this.healAmount = healAmount;
	}

	public int getHealAmount() {
		return this.healAmount;
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		// heal code
		// if duration>1 add to effect
		UnitStats Target = (UnitStats) target;
		int healAmount = (int) (1.0 * Target.getMaxHP() * this.healAmount / 100);
		Target.setCurrentHP(healAmount + Target.getCurrentHP());
		if (this.getDuration() > 1) {
			Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
			Target.getEffects().add(effect);
		}
	}

	public void heal(Unit target) {
		UnitStats Target = (UnitStats) target;
		int healAmount = (int) (1.0 * Target.getMaxHP() * this.healAmount / 100);
		Target.setCurrentHP(healAmount + Target.getCurrentHP());
	}
}
