package SubSkill;

import SubSkillBase.Activatable;
import Unit.AdvanceUnit;
import Unit.Unit;

public class DecreaseUltiGauge extends SubSkill implements Activatable{

	private int decreaseAmount;

	public DecreaseUltiGauge(int decreaseAmount) {
		super("[ Gauge Down ]", 0);
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

	
}
