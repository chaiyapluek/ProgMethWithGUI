package List;

import UnitBase.BasicUnit;

public class BasicUnitList {

	public static BasicUnit Skeleton_Saber(int[] stats) {
		BasicUnit unit = new BasicUnit("Skeleton", "Saber", stats);
		unit.setUrl("EnemyUnit/Skeleton_Saber.png");
		return unit;
	}
	
	public static BasicUnit Skeleton_Lancer(int[] stats) {
		BasicUnit unit = new BasicUnit("Skeleton", "Lancer", stats);
		unit.setUrl("EnemyUnit/Skeleton_Lancer.png");
		return unit;
	}
	
	public static BasicUnit Skeleton_Archer(int[] stats) {
		BasicUnit unit = new BasicUnit("Skeleton", "Archer", stats);
		unit.setUrl("EnemyUnit/Skeleton_Archer.png");
		return unit;
	}
	
	public static BasicUnit Golem(int[] stats) {
		BasicUnit unit = new BasicUnit("Golem", "Berserker", stats);
		unit.setUrl("EnemyUnit/Golem.png");
		return unit;
	}
	
}
