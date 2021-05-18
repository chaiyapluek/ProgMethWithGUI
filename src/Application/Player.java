package Application;

import Coordinate.Coordinate;
import Inventory.Inventory;
import Skill.*;
import UnitBase.*;

public class Player {

	private AllyUnit[] units;
	private AllyUnit[] backUnits;
	private Coordinate coordinate;
	private Inventory inventory;
	private int money;

	public Player(AllyUnit[] units,Coordinate coordinate) {
		money = 10000;
		this.units = new AllyUnit[3];
		this.backUnits = new AllyUnit[3];
		this.inventory = new Inventory(10);
		for (int i = 0; i < 3; i++) {
			this.backUnits[i] = null;
			if (units[i] == null) {
				this.units[i] = null;
			} else {
				this.units[i] = units[i];
			}
		}
		this.coordinate = new Coordinate(coordinate);
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void Move(Coordinate coordinate) {
		this.coordinate.setX(coordinate.getX());
		this.coordinate.setY(coordinate.getY());
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public int getNumberOfFrontUnit() {
		int numberOfFrontUnit = 0;
		for (int i = 0; i < 3; i++) {
			if (units[i] == null)
				continue;
			if (units[i].getIsDead())
				continue;
			numberOfFrontUnit += 1;
		}
		return numberOfFrontUnit;
	}
	
	public int getNumberOfBackUnit() {
		int numberOfBackUnit = 0;
		for (int i = 0; i < 3; i++) {
			if (backUnits[i] == null)
				continue;
			if (backUnits[i].getIsDead())
				continue;
			numberOfBackUnit += 1;
		}
		return numberOfBackUnit;
	}
	
	public int getNumberOfUnit() {
		return getNumberOfBackUnit()+getNumberOfFrontUnit();
	}

	public AllyUnit[] getUnits() {
		return this.units;
	}
	
	public AllyUnit[] getBackUnits() {
		return this.backUnits;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

}
