package SubSkill;

import Skill.Effect;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class IncreaseDef extends BuffType{
	
	public IncreaseDef(int duration,int increaseAmount) {
		super("[ Def up ]",duration,increaseAmount);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setDefense(Target.getDefense()+this.getIncreaseAmount());
		//add effect to target
		Effect effect = new Effect(this.getDescription(),this.getDuration(),this);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setDefense(Target.getDefense()-this.getIncreaseAmount());
	}
	
}
