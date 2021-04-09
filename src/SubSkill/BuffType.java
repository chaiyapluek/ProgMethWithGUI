package SubSkill;

import UnitBase.Unit;

public abstract class BuffType extends SubSkill{

	private int increaseAmount;
	
	public BuffType(String description,int duration,int increaseAmount) {
		super(description, duration);
		this.increaseAmount = increaseAmount;
	}

	public int getIncreaseAmount() {
		return this.increaseAmount;
	}
	
	public void setIncreaseAmount(int increaseAmount) {
		this.increaseAmount = increaseAmount;
	}
	
	public abstract void activate(Unit target) ;
	public abstract void deactivate(Unit target);
	
	
}
