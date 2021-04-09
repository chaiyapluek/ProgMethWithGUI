package Map;

import UnitBase.*;

public class Stage {
	
	private int numberOfWave;
	private boolean isHasShop;
	private boolean isClear;
	private Unit[][] units;
	//money drop
	//item drop
	
	public Stage(int numberOfWave,boolean isHasShop,Unit[][] units) {
		this.numberOfWave = numberOfWave;
		this.isHasShop = isHasShop;
		if(numberOfWave == 0) {
			isClear = true;
		}else {
			isClear = false;
		}
		this.units = new Unit[numberOfWave][3];
		for(int i=0;i<units.length;i++) {
			for(int j=0;j<units[i].length;j++) {
				this.units[i][j] = units[i][j];
			}
		}
	}
	
	public Unit[] getUnitAtWave(int idx) {
		Unit[] unitsAtWave = new Unit[units[idx].length];
		for(int i=0;i<units[idx].length;i++)
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
	
	public String toString() {
		String str = "Enemy Unit(s)\n";
		for(int i=0;i<numberOfWave;i++) {
			str += "Wave : \n" + (i+1);
			for(int j=0;j<units.length;j++) {
				str += "["+(j+1)+"] ";
				if(units[i][j] == null) {
					str += "-\n";
				}else {
					UnitStats unit = (UnitStats)units[i][j];
					str += unit.getName() + "("+unit.get_Class()+")\n";
					str += "    " + unit.getTotalAttack() + "\n";
					str += "    " + unit.getMaxHP(); 
				}
			}
		}
		return str;
	}
}
