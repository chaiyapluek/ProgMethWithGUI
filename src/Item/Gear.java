package Item;

import UnitBase.Unit;
import UnitBase.UnitStats;

public class Gear extends Item{
	private int increaseMaxHP;
	private int increaseAttack;
	private int increaseDefense;
	private int increaseCritChance;
	private int increaseDodgeChance;
	private int increaseCritDamage;
	
	public Gear(String name, String description, int price,int[] increaseStats) {
		super(name, description, price);
		// TODO Auto-generated constructor stub
		for(int i=0;i<6;i++) {
			this.increaseMaxHP = increaseStats[0];
			this.increaseDefense = increaseStats[1];
			this.increaseAttack = increaseStats[2];
			this.increaseCritChance = increaseStats[3];
			this.increaseCritDamage = increaseStats[4];
			this.increaseDodgeChance = increaseStats[5];
		}
	}
	
	public void equip(Unit unit) {
		UnitStats unitStats = (UnitStats) unit;
		unitStats.setMaxHP(increaseMaxHP+unitStats.getMaxHP());
		unitStats.setDefense(increaseDefense+unitStats.getDefense());
		unitStats.setAttack(increaseAttack+unitStats.getAttack());
		unitStats.setCritChance(increaseCritChance+unitStats.getCritChance());
		unitStats.setCritDamage(increaseCritDamage+unitStats.getCritDamage());
		unitStats.setDodgeChance(increaseDodgeChance+unitStats.getDodgeChance());
	}
	
	public void unequip(Unit unit) {
		UnitStats unitStats = (UnitStats) unit;
		unitStats.setMaxHP(unitStats.getMaxHP()-increaseMaxHP);
		unitStats.setDefense(unitStats.getDefense()-increaseDefense);
		unitStats.setAttack(unitStats.getAttack()-increaseAttack);
		unitStats.setCritChance(unitStats.getCritChance()-increaseCritChance);
		unitStats.setCritDamage(unitStats.getCritDamage()-increaseCritDamage);
		unitStats.setDodgeChance(unitStats.getDodgeChance()-increaseDodgeChance);
	}
	
	public String toString() {
		String info = "Name \t\t\t\t\t: " + this.getName() + "\n";
		info += "Description \t\t\t\t: " + this.getDescription() + "\n";
		info += "Increase max HP \t\t\t: " + this.increaseMaxHP + "\n";
		info += "Increase defense \t\t\t: " + this.increaseDefense + "\n";
		info += "Increase attack \t\t\t: " + this.increaseAttack + "\n";
		info += "Increase critical chance \t\t: " + this.increaseCritChance + "\n";
		info += "Increase critical damage \t\t: " + this.increaseCritDamage + "\n";
		info += "Increase dodge chance \t\t\t: " + this.increaseDodgeChance + "\n";
		info += "Price \t\t\t\t\t: " + this.getPrice() + "\n";
		return info;
	}

	public int getIncreaseMaxHP() {
		return increaseMaxHP;
	}

	public void setIncreaseMaxHP(int increaseMaxHP) {
		this.increaseMaxHP = Math.max(0, increaseMaxHP);
	}

	public int getIncreaseAttack() {
		return increaseAttack;
	}

	public void setIncreaseAttack(int increaseAttack) {
		this.increaseAttack = Math.max(0, increaseAttack);
	}

	public int getIncreaseDefense() {
		return increaseDefense;
	}

	public void setIncreaseDefense(int increaseDefense) {
		this.increaseDefense = Math.max(0, increaseDefense);
	}

	public int getIncreaseCritChance() {
		return increaseCritChance;
	}

	public void setIncreaseCritChance(int increaseCritChance) {
		this.increaseCritChance = Math.max(0, increaseCritChance);
	}

	public int getIncreaseDodgeChance() {
		return increaseDodgeChance;
	}

	public void setIncreaseDodgeChance(int increaseDodgeChance) {
		this.increaseDodgeChance = Math.max(0, increaseDodgeChance);
	}

	public int getIncreaseCritDamage() {
		return increaseCritDamage;
	}

	public void setIncreaseCritDamage(int increaseCritDamage) {
		this.increaseCritDamage = Math.max(0, increaseCritDamage);
	}
	
	
}
