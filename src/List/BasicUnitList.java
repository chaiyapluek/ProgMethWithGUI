package List;

import Unit.BasicUnit;

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
	
	public static BasicUnit Celtic_Saber(int[] stats) {
		BasicUnit unit = new BasicUnit("Celtic Soilder", "Saber", stats);
		unit.setUrl("EnemyUnit/Celtic_Saber.png");
		return unit;
	}
	
	public static BasicUnit Celtic_Lancer(int[] stats) {
		BasicUnit unit = new BasicUnit("Celtic Soilder", "Lancer", stats);
		unit.setUrl("EnemyUnit/Celtic_Lancer.png");
		return unit;
	}
	
	public static BasicUnit Celtic_Archer(int[] stats) {
		BasicUnit unit = new BasicUnit("Celtic Soilder", "Archer", stats);
		unit.setUrl("EnemyUnit/Celtic_Archer.png");
		return unit;
	}
	
	public static BasicUnit Golem(int[] stats) {
		BasicUnit unit = new BasicUnit("Golem", "Berserker", stats);
		unit.setUrl("EnemyUnit/Golem.png");
		return unit;
	}
	
	public static BasicUnit SteelGolem(int[] stats) {
		BasicUnit unit = new BasicUnit("SteelGolem", "Berserker", stats);
		unit.setUrl("EnemyUnit/Steel_Golem.png");
		return unit;
	}
	
	public static BasicUnit Wyvern(int[] stats) {
		BasicUnit unit = new BasicUnit("Wyvern", "Berserker", stats);
		unit.setUrl("EnemyUnit/Wyvern.png");
		return unit;
	}
	
	public static BasicUnit DemonBoar(int[] stats) {
		BasicUnit unit = new BasicUnit("Demon boar", "Berserker", stats);
		unit.setUrl("EnemyUnit/Demon_Boar.png");
		return unit;
	}
	
}
