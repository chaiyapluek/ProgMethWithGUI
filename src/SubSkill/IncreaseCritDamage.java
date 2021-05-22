package SubSkill;

import Skill.Effect;
import SubSkillBase.Activatable;
import SubSkillBase.Deactivatable;
import Unit.Unit;
import Unit.UnitStats;

public class IncreaseCritDamage extends BuffType implements Activatable, Deactivatable{

	public IncreaseCritDamage(int duration,int increaseAmount) {
		super("[ Crit dmg up ]",duration,increaseAmount);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setCritDamage(Target.getCritDamage() + this.getIncreaseAmount());
		// add effect to target
		Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats) target;
		Target.setCritDamage(Target.getCritDamage() - this.getIncreaseAmount());
	}
	
}
