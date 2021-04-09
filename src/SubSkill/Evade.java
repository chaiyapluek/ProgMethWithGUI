package SubSkill;

import Skill.Effect;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class Evade extends SubSkill{
	
	public Evade(int duration) {
		super("[ Evade ]", duration);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Effect effect = new Effect(this.getDescription(),this.getDuration(),this);
		Target.setIsEvade(true);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setIsEvade(false);
	}
	
}
