package SubSkill;

import UnitBase.Unit;

public abstract class SubSkill {

	private String description;
	private int duration;

	public SubSkill(String description, int duration) {
		this.description = description;
		this.duration = duration;
	}

	public String getDescription() {
		return this.description;
	}
	
	public int getDuration() {
		return this.duration;
	}

	public abstract void activate(Unit target);
	public abstract void deactivate(Unit target);
	
	public String toString() {
		return this.description + "\t" + this.duration + " turn(s) left";
	}
}
