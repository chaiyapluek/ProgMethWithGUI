package Skill;

import SubSkill.SubSkill;

public class Effect {
	
	private String description;
	private int duration;
	private SubSkill appliedSubSkill;
	
	public Effect(String description,int duration,SubSkill appliedSkill) {
		this.description = appliedSkill.getDescription();
		this.duration = appliedSkill.getDuration();
		this.appliedSubSkill = appliedSkill;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int duration) {
		this.duration = Math.max(0, duration);
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public SubSkill getSubSkill() {
		return this.appliedSubSkill;
	}
	
	public String toString() {
		String str = this.description + " :    \t" + this.duration + " turn(s) left";
		return str;
	}
}
