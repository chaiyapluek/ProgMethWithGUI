package List;

import java.util.Random;

import Map.Stage;
import Unit.BasicUnit;
import Unit.Unit;

public class StageList_Difficulty2 {

	private static Random r = new Random();
	
	public static Stage[] getStage_Difficulty2() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		for(Stage s : stages) {
			s.setMoneyDrop(1000 + r.nextInt(200));
		}
		return stages;
	}

	public static int getHP(int HP) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 500;
	}

	public static int getAttack(int Attack) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 50;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(2000), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Celtic_Saber(stats);

		stats = new int[] { getHP(2300), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Celtic_Saber(stats);

		stats = new int[] { getHP(3000), 10, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(2500), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(2700), 12, getAttack(325), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Celtic_Saber(stats);

		stats = new int[] { getHP(3000), 12, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.SteelGolem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage1 = new Stage(2, false, units);
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(2000), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Celtic_Lancer(stats);

		stats = new int[] { getHP(2300), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Celtic_Lancer(stats);

		stats = new int[] { getHP(3000), 10, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(2700), 12, getAttack(325), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Celtic_Lancer(stats);

		stats = new int[] { getHP(2500), 12, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(3500), 12, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.SteelGolem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage2 = new Stage(2, false, units);
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(2000), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Celtic_Archer(stats);

		stats = new int[] { getHP(2300), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Celtic_Archer(stats);

		stats = new int[] { getHP(3000), 10, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(2700), 12, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Celtic_Archer(stats);

		stats = new int[] { getHP(2500), 12, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(3500), 12, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.SteelGolem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage3 = new Stage(2, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(2500), 12, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Celtic_Saber(stats);

		stats = new int[] { getHP(2150), 12, getAttack(350), 10, 100, 10, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Celtic_Archer(stats);

		stats = new int[] { getHP(2300), 12, getAttack(200), 10, 100, 10, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Celtic_Archer(stats);

		stats = new int[] { getHP(2350), 15, getAttack(325), 5, 100, 8, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Celtic_Lancer(stats);

		stats = new int[] { getHP(2400), 15, getAttack(325), 5, 100, 8, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Celtic_Lancer(stats);

		stats = new int[] { getHP(3500), 10, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.SteelGolem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage4 = new Stage(2, false, units);
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(6500), 10, getAttack(450), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(7500), 10, getAttack(600), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.SteelGolem(stats);

		stats = new int[] { getHP(9000), 15, getAttack(750), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Wyvern(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null }, { null, enemyUnit2, null },
				{ null, enemyUnit3, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);

		Stage stage5 = new Stage(3, false, units);
		return stage5;

	}
}
