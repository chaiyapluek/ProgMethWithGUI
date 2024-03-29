package SubSkill;

import java.util.ArrayList;

import Skill.Effect;
import SubSkillBase.Activatable;
import Unit.Unit;
import Unit.UnitStats;

public class RemoveDebuff extends SubSkill implements Activatable{

	public RemoveDebuff() {
		super("[Remove Debuff]", 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		ArrayList<Effect> removed = new ArrayList<Effect>();
		for(Effect e : Target.getEffects()) {
			if ((e.getSubSkill() instanceof DebuffType) || (e.getSubSkill() instanceof Stun)) {
				removed.add(e);
			}
		}
		for (Effect e : removed) {
			Target.removeEffect(e);
		}
	}

}
