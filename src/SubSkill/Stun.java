package SubSkill;

import Skill.Effect;
import SubSkillBase.Activatable;
import SubSkillBase.Deactivatable;
import Unit.Unit;
import Unit.UnitStats;

public class Stun extends SubSkill implements Activatable, Deactivatable{

	public Stun(int duration) {
		super("[ stun ]", duration);
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Effect effect = new Effect(this.getDescription(),this.getDuration(),this);
		Target.setIsStun(true);
		Target.getEffects().add(effect);
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setIsStun(false);
	}

}
