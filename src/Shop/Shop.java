package Shop;

import java.util.Random;

import Item.Item;
import Item.Potion;
import List.AllyUnitList;
import List.GearList;
import UnitBase.AllyUnit;

public class Shop {
	
	private Item[] items;
	private AllyUnit[] allyUnits;
	private Random r = new Random();

	public Shop() {
		items = new Item[10];
		items[0] = new Potion("Small Potion", "Heal HP by 250.", 50, 250, 1);
		items[1] = new Potion("Medium Potion", "Heal HP by 1000.", 150, 1000, 1);
		items[2] = new Potion("Large Potion", "Heal HP by 2500.", 300, 2500, 1);
		items[3] = new Potion("Max Potion", "Heal HP by 10000.", 1000, 10000, 1);
		Item[] result = getRandomItem();
		for (int i = 4; i < 10; i++)
			items[i] = result[i];
		allyUnits = new AllyUnit[10];
		AllyUnit[] result2 = getAllyUnit();
		for (int i = 0; i < 10; i++)
			allyUnits[i] = result2[i];
	}

	private Item[] getRandomItem() {
		int[] mark = new int[35];
		Item[] result = new Item[35];
		for (int i = 4; i <= 9; i++) {
			int idx = getRandomNum(0, 32);
			while (mark[idx] == 1) {
				idx = getRandomNum(0, 32);
			}
			mark[idx] = 1;
			result[i] = GearList.getAllGear().get(idx);
		}
		return result;
	}

	private int getRandomNum(int l, int h) {
		int low = l;
		int high = h;
		int result = r.nextInt(high - low) + low;
		return result;
	}

	private AllyUnit[] getAllyUnit() {
		int[] mark = new int[30];
		AllyUnit[] result = new AllyUnit[30];
		for (int i = 0; i <= 9; i++) {
			int idx = getRandomNum(0, 19);
			while (mark[idx] == 1) {
				idx = getRandomNum(0, 19);
			}
			mark[idx] = 1;
			result[i] = AllyUnitList.getAllUnit().get(idx);
			// System.out.println(idx);
		}
		return result;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public AllyUnit[] getAllyUnits() {
		return allyUnits;
	}

	public void setAllyUnits(AllyUnit[] allyUnits) {
		this.allyUnits = allyUnits;
	}
}
