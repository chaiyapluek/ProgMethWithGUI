package SubSkill;

import Skill.Effect;
import SubSkillBase.Activatable;
import SubSkillBase.Deactivatable;
import Unit.Unit;
import Unit.UnitStats;

public class IncreaseDodgeChance extends BuffType implements Activatable, Deactivatable{

	public IncreaseDodgeChance(int duration,int increaseAmount) {
		super("[ Dodge chance up ]",duration,increaseAmount);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setDodgeChance(Target.getDodgeChance() + this.getIncreaseAmount());
		// add effect to target
		Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setDodgeChance(Target.getDodgeChance() - this.getIncreaseAmount());
	}
	
}
