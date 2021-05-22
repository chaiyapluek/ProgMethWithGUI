package List;


import java.util.Random;

import Map.Stage;
import Unit.AdvanceUnit;
import Unit.Unit;

public class StageList_Difficulty5 {

	private static Random r = new Random();

	public static Stage[] getStage_Difficulty5() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		for(Stage s : stages) {
			s.setMoneyDrop(2500 + r.nextInt(700));
		}
		return stages;
	}

	public static int getHP(int HP) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 2000;
	}

	public static int getAttack(int Attack) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 200;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(15000), 0, getAttack(1050), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(16000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(18000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(17500), 0, getAttack(1250), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(19000), 0, getAttack(1350), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(35000), 20, getAttack(1550), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.BlackSamurai(stats);

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Unit[][] units = new Unit[][] { { enemyUnit1, null, enemyUnit2 }, { enemyUnit3, enemyUnit4, enemyUnit5 },
				{ null, enemyUnit6, null } };

		Stage stage1 = new Stage(3, false, units);
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(15000), 0, getAttack(1050), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(16000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(18000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(17500), 0, getAttack(1250), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(19000), 0, getAttack(1350), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(35000), 20, getAttack(1550), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.BlackSamurai(stats);

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

		int[] stats = new int[] { getHP(15000), 0, getAttack(1050), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(16000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(18000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(17500), 0, getAttack(1250), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(19000), 0, getAttack(1350), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(21000), 0, getAttack(1550), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(21000), 0, getAttack(1550), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit7 = AdvanceUnitList.Ghost(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, null, enemyUnit2 }, { enemyUnit3, null, enemyUnit4 },
				{ enemyUnit5, enemyUnit6, enemyUnit7 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);
		enemyUnit7.setID(7);

		Stage stage3 = new Stage(3, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(15000), 0, getAttack(1050), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(16000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(18000), 0, getAttack(1150), 20, 90, 20, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Ghost(stats);

		stats = new int[] { getHP(25000), 25, getAttack(1250), 25, 70, 15, 3 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Krichat(stats);

		stats = new int[] { getHP(25000), 8, getAttack(1550), 15, 100, 12, 5 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Gazer(stats);

		stats = new int[] { getHP(25000), 9, getAttack(1550), 15, 100, 10, 5 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.Gazer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { null, enemyUnit4, null },
				{ enemyUnit5, null, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage4 = new Stage(3, false, units);
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(55000), 20, getAttack(1550), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.BlackSamurai(stats);

		stats = new int[] { getHP(55000), 25, getAttack(1250), 25, 70, 15, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Krichat(stats);

		stats = new int[] { getHP(45000), 9, getAttack(1800), 15, 100, 10, 5 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Gazer(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null }, { null, enemyUnit2, null },
				{ null, enemyUnit3, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);

		Stage stage5 = new Stage(3, false, units);
		return stage5;

	}
}
