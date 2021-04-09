package SubSkill;

import Skill.Effect;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class DecreaseAttack extends DebuffType{

	public DecreaseAttack(int duration,int increaseAmount) {
		super("[ Attack down ]",duration,increaseAmount);
	}
	
	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setIncreaseAttackAmount(Target.getIncreaseAttackAmount() - this.getDecreaseAmount());
		// add effect to target
		Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setIncreaseAttackAmount(Target.getIncreaseAttackAmount() + this.getDecreaseAmount());
	}
	
}
