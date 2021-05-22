package SubSkill;

public abstract class DebuffType extends SubSkill{

	private int decreaseAmount;
	
	public DebuffType(String description,int duration,int decreaseAmount) {
		super(description, duration);
		this.decreaseAmount = decreaseAmount;
	}

	public int getDecreaseAmount() {
		return this.decreaseAmount;
	}
	
}
