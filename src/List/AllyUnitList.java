package List;

import java.util.ArrayList;

import UnitBase.AllyUnit;

public class AllyUnitList {

	public static ArrayList<AllyUnit> getAllUnit() {
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		for (AllyUnit unit : AllyUnitList_Saber.getAllUnits())
			units.add(unit);
		for (AllyUnit unit : AllyUnitList_Lancer.getAllUnits())
			units.add(unit);
		for (AllyUnit unit : AllyUnitList_Archer.getAllUnits())
			units.add(unit);
		for (AllyUnit unit : AllyUnitList_Berserker.getAllUnits())
			units.add(unit);
		return units;
	}

}
