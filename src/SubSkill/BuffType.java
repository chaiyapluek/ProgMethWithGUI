package SubSkill;

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
	
}
