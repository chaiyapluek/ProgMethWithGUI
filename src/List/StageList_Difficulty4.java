package List;

import java.util.Random;

import Map.Stage;
import Unit.AdvanceUnit;
import Unit.Unit;

public class StageList_Difficulty4 {
	
	private static Random r = new Random();
	
	public static Stage[] getStage_Difficulty4() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		for(Stage s : stages) {
			s.setMoneyDrop(2000 + r.nextInt(500));
		}
		return stages;
	}

	public static int getHP(int HP) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 1500;
	}

	public static int getAttack(int Attack) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 150;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(25000), 15, getAttack(850), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(23000), 15, getAttack(950), 5, 75, 7, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Knight_Lancer(stats);

		stats = new int[] { getHP(19000), 15, getAttack(1200), 10, 100, 10, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Knight_Archer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);

		Stage stage1 = new Stage(1, false, units);
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(15000), 15, getAttack(850), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(15000), 15, getAttack(850), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(16000), 15, getAttack(950), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(15000), 15, getAttack(1200), 10, 100, 10, 3 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Knight_Archer(stats);

		stats = new int[] { getHP(15000), 15, getAttack(1250), 10, 100, 10, 3 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Knight_Archer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, null, enemyUnit2 }, { enemyUnit3, enemyUnit4, enemyUnit5 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);

		Stage stage2 = new Stage(2, false, units);
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(17000), 15, getAttack(950), 5, 75, 7, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Knight_Lancer(stats);

		stats = new int[] { getHP(18000), 15, getAttack(1000), 5, 75, 7, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Knight_Lancer(stats);

		stats = new int[] { getHP(18000), 15, getAttack(1000), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(20000), 15, getAttack(1200), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Knight_Saber(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, null, enemyUnit2 }, { enemyUnit3, null, enemyUnit4 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);

		Stage stage3 = new Stage(2, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(6000), 5, getAttack(550), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(6500), 5, getAttack(611), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(6800), 6, getAttack(620), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(6000), 5, getAttack(550), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(6500), 5, getAttack(611), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(6800), 6, getAttack(620), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(56800), 10, getAttack(1520), 10, 70, 10, 5 };
		AdvanceUnit enemyUnit7 = AdvanceUnitList.Sphinx(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ null, enemyUnit7, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);
		enemyUnit7.setID(7);

		Stage stage4 = new Stage(3, false, units);
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(9000), 5, getAttack(550), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(9500), 5, getAttack(611), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(10000), 6, getAttack(620), 5, 75, 15, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.SeaDemon(stats);

		stats = new int[] { getHP(20000), 20, getAttack(1200), 20, 70, 15, 3 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Krichat(stats);

		stats = new int[] { getHP(25000), 25, getAttack(1250), 25, 70, 15, 3 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Krichat(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { null, enemyUnit4, null },
				{ null, enemyUnit5, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);

		Stage stage5 = new Stage(3, false, units);
		return stage5;

	}
}
