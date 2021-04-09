package SubSkill;

import Skill.Effect;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class IgnoreDef extends SubSkill{

	public IgnoreDef(int duration) {
		super("[ Ignore Def ]", duration);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Effect effect = new Effect(this.getDescription(),this.getDuration(),this);
		Target.setIgnoreDef(true);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setIgnoreDef(false);
	}
	
}
