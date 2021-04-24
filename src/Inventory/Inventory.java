package Inventory;

import java.util.ArrayList;

import Item.Gear;
import Item.Item;
import Item.Potion;

public class Inventory {
	private int inventorySize;
	private int maxInventorySize;
	private ArrayList<Item> inventory;
	
	public Inventory(int maxInventorySize) {
		this.inventorySize = 0;
		this.maxInventorySize = maxInventorySize;
		this.inventory = new ArrayList<Item>();
	}
	
	public String toString() {
		String info = "Inventory: \n";
		for(Item item: inventory) {
			if(item instanceof Gear) {
				info += "- "+item.getName()+"\n";
			}
			if(item instanceof Potion){
				info += "- "+item.getName() +"\tx"+((Potion)item).getNumberOfPotion()+"\n";
			}
		}
		return info;
	}
	
	public void addToInventory(Item item) throws Exception {
		if(inventorySize < maxInventorySize) {
			inventory.add(item);
			inventorySize++;
		}
		else {
			throw new Exception();
		}
	}
	
	public void removeFromInventory(int index) throws Exception{
		if(index>=0&&index<maxInventorySize) {
			inventory.remove(index);
			inventorySize--;
		}
		else {
			throw new Exception();
		}
	}
	
	public boolean isPotionExist(Potion potion) {
		for(Item item:inventory) {
			if(potion.equals(item));
				return true;
		}
		return false;
	}
	
	public int getInventorySize() {
		return inventorySize;
	}

	public void setInventorySize(int inventorySize) {
		this.inventorySize = inventorySize;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public int getMaxInventorySize() {
		return maxInventorySize;
	}

	public void setMaxInventorySize(int maxInventorySize) {
		this.maxInventorySize = maxInventorySize;
	}
	
	
}
