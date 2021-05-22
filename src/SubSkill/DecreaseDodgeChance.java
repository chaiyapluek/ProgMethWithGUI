package SubSkill;

import Skill.Effect;
import SubSkillBase.Activatable;
import SubSkillBase.Deactivatable;
import Unit.Unit;
import Unit.UnitStats;

public class DecreaseDodgeChance extends DebuffType implements Activatable, Deactivatable{

	public DecreaseDodgeChance(int duration,int increaseAmount) {
		super("[ Dodge chance down ]",duration,increaseAmount);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setDodgeChance(Target.getDodgeChance() - this.getDecreaseAmount());
		// add effect to target
		Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setDodgeChance(Target.getDodgeChance() + this.getDecreaseAmount());
	}
	
}
