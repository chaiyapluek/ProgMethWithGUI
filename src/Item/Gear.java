package Item;

import Unit.Unit;
import Unit.UnitStats;

public class Gear extends Item {
	
	private int increaseMaxHP;
	private int increaseAttack;
	private int increaseDefense;
	private int increaseCritChance;
	private int increaseDodgeChance;
	private int increaseCritDamage;
	private int type;
//	0->weapon
//	1->helmet
//	2->armour
//	3->leggings
//	4->boots
	
	public Gear(String name, String description, int price, int[] increaseStats) {
		super(name, description, price);
		// TODO Auto-generated constructor stub
		this.increaseMaxHP = increaseStats[0];
		this.increaseDefense = increaseStats[1];
		this.increaseAttack = increaseStats[2];
		this.increaseCritChance = increaseStats[3];
		this.increaseCritDamage = increaseStats[4];
		this.increaseDodgeChance = increaseStats[5];
	}

	public void equip(Unit unit) {
		UnitStats unitStats = (UnitStats) unit;
		unitStats.setMaxHP(increaseMaxHP + unitStats.getMaxHP());
		unitStats.setDefense(increaseDefense + unitStats.getDefense());
		unitStats.setAttack(increaseAttack + unitStats.getAttack());
		unitStats.setCritChance(increaseCritChance + unitStats.getCritChance());
		unitStats.setCritDamage(increaseCritDamage + unitStats.getCritDamage());
		unitStats.setDodgeChance(increaseDodgeChance + unitStats.getDodgeChance());
	}

	public void unequip(Unit unit) {
		UnitStats unitStats = (UnitStats) unit;
		unitStats.setMaxHP(unitStats.getMaxHP() - increaseMaxHP);
		unitStats.setDefense(unitStats.getDefense() - increaseDefense);
		unitStats.setAttack(unitStats.getAttack() - increaseAttack);
		unitStats.setCritChance(unitStats.getCritChance() - increaseCritChance);
		unitStats.setCritDamage(unitStats.getCritDamage() - increaseCritDamage);
		unitStats.setDodgeChance(unitStats.getDodgeChance() - increaseDodgeChance);
	}

	public int getIncreaseMaxHP() {
		return increaseMaxHP;
	}

	public int getIncreaseAttack() {
		return increaseAttack;
	}

	public int getIncreaseDefense() {
		return increaseDefense;
	}

	public int getIncreaseCritChance() {
		return increaseCritChance;
	}
	public int getIncreaseDodgeChance() {
		return increaseDodgeChance;
	}

	public int getIncreaseCritDamage() {
		return increaseCritDamage;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
