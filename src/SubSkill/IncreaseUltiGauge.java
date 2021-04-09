package SubSkill;

import Skill.Effect;
import UnitBase.AdvanceUnit;
import UnitBase.Unit;

public class IncreaseUltiGauge extends SubSkill {

	private int increaseAmount;

	public IncreaseUltiGauge(int duration, int increaseAmount) {
		super("[ Gauge up ]", duration);
		this.increaseAmount = increaseAmount;
		// TODO Auto-generated constructor stub
	}

	public int getIncreaseAmount() {
		return increaseAmount;
	}
	
	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		if (target instanceof AdvanceUnit) {
			AdvanceUnit Target = (AdvanceUnit)target;
			Target.setUltiGauge(Target.getUltiGauge() + increaseAmount);
			if (this.getDuration() > 1) {
				Effect effect = new Effect(this.getDescription(), this.getDuration(), this);
				Target.getEffects().add(effect);
			}
		}
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub

	}

	public void increaseGauge(Unit target) {
		if (target instanceof AdvanceUnit) {
			AdvanceUnit Target = (AdvanceUnit)target;
			Target.setUltiGauge(Target.getUltiGauge() + increaseAmount);
		}
	}
	
}
