package Skill;

import java.util.ArrayList;

import SubSkill.SubSkill;
import UnitBase.Unit;

public abstract class Skill {

	protected String name;
	protected String description;
	private String url;
	protected ArrayList<SubSkill> subSkills;

	private boolean toYourSelf;
	private boolean isSingle;
	private boolean toAlly;

	public Skill(String name, String description, ArrayList<SubSkill> subSkills, boolean toYourSelf, boolean isSingle,
			boolean toAlly) {
		this.name = name;
		this.description = description;
		this.subSkills = new ArrayList<SubSkill>();
		for (SubSkill s : subSkills)
			this.subSkills.add(s);
		this.toYourSelf = toYourSelf;
		this.isSingle = isSingle;
		this.toAlly = toAlly;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<SubSkill> getSubSkills() {
		return this.subSkills;
	}

	public boolean getToAlly() {
		return this.toAlly;
	}

	public boolean getIsSingle() {
		return this.isSingle;
	}

	public boolean getToYourSelf() {
		return this.toYourSelf;
	}

	public abstract void use(Unit user,Unit target);
	public abstract String toString();
	
}
