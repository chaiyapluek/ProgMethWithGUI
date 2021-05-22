package Map;

import Shop.Shop;
import Unit.*;

public class Stage {

	private int numberOfWave;
	private boolean isHasShop;
	private boolean isClear;
	private Unit[][] units;
	private int moneyDrop;
	private Shop shop;
	private boolean isBoss = false;

	public Stage(int numberOfWave, boolean isHasShop, Unit[][] units) {
		this.numberOfWave = numberOfWave;
		this.isHasShop = isHasShop;
		if (numberOfWave == 0) {
			isClear = true;
		} else {
			isClear = false;
		}
		this.units = new Unit[numberOfWave][3];
		for (int i = 0; i < units.length; i++) {
			for (int j = 0; j < units[i].length; j++) {
				this.units[i][j] = units[i][j];
			}
		}
	}

	public Unit[] getUnitAtWave(int idx) {
		Unit[] unitsAtWave = new Unit[units[idx].length];
		for (int i = 0; i < units[idx].length; i++)
			unitsAtWave[i] = units[idx][i];
		return unitsAtWave;
	}

	public int getNumberOfWave() {
		return numberOfWave;
	}

	public boolean isClear() {
		return isClear;
	}

	public void setClear(boolean isClear) {
		this.isClear = isClear;
	}

	public boolean isHasShop() {
		return isHasShop;
	}

	public void setHasShop(boolean isHasShop) {
		this.isHasShop = isHasShop;
	}

	public void setMoneyDrop(int money) {
		this.moneyDrop = money;
	}

	public int getMoneyDrop() {
		return moneyDrop;
	}

	public void createShop() {
		shop = new Shop();
	}

	public Shop getShop() {
		return shop;
	}

	public boolean isBoss() {
		return isBoss;
	}

	public void setIsBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}

}
