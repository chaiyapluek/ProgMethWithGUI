package SubSkill;

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
	
	public String toString() {
		return this.description + "\t" + this.duration + " turn(s) left";
	}
}
