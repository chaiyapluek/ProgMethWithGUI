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
		this.setUrl("Item/potion-ball.png");
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + healPoint;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Potion other = (Potion) obj;
		if (healPoint != other.healPoint)
			return false;
		return true;
	}
	
}
