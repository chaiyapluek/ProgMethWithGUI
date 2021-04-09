package Item;

import UnitBase.Unit;
import UnitBase.UnitStats;

public class Potion extends Item{
	private int healPoint;
	private int numberOfPotion;

	public Potion(String name, String description, int price, int healPoint,int numberOfPotion) {
		super(name, description, price);
		// TODO Auto-generated constructor stub
		this.healPoint = healPoint;
		this.numberOfPotion = numberOfPotion;
	}
	 
	public void healUnit(Unit unit) throws Exception {
		if(numberOfPotion>0) {
			UnitStats unitStats = (UnitStats) unit;
			unitStats.setCurrentHP(unitStats.getCurrentHP()+healPoint);
			numberOfPotion--;
		}
		else {
			throw new Exception();
		}
	}
	
	public int getHealPoint() {
		return healPoint;
	}

	public void setHealPoint(int healPoint) {
		this.healPoint = Math.max(0, healPoint);
	}

	public int getNumberOfPotion() {
		return numberOfPotion;
	}

	public void setNumberOfPotion(int numberOfPotion) {
		this.numberOfPotion = numberOfPotion;
	}

	public String toString() {
		String info = "Name \t\t\t: " + this.getName() + "\n";
		info += "Description \t\t: " + this.getDescription() + "\n";
		info += "Heal Amount \t\t: " + this.healPoint + "\n";
		info += "Price \t\t\t: " + this.getPrice() + "\n";
		info += "Number of Potion \t: " + this.numberOfPotion + "\n";
		return info;
	}
}
