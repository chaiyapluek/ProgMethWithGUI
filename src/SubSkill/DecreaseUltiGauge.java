package SubSkill;

import UnitBase.AdvanceUnit;
import UnitBase.Unit;

public class DecreaseUltiGauge extends SubSkill {

	private int decreaseAmount;

	public DecreaseUltiGauge(int decreaseAmount) {
		super("[ Gauge up ]", 0);
		this.decreaseAmount = decreaseAmount;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		if (target instanceof AdvanceUnit) {
			AdvanceUnit Target = (AdvanceUnit)target;
			Target.setUltiGauge(Target.getUltiGauge() - decreaseAmount);
		}
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub

	}
	
}
