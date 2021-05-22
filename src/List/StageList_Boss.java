package List;

import java.util.Random;

import Map.Stage;
import Unit.AdvanceUnit;
import Unit.Unit;

public class StageList_Boss {

	private static Random r = new Random();

	public static Stage[] getMiniBossStage() {
		Stage[] stages = new Stage[] { MiniBoss1(), MiniBoss2(), MiniBoss3(), MiniBoss4() };
		for (Stage s : stages) {
			s.setMoneyDrop(3000 + r.nextInt(1000));
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

	public static Stage MiniBoss1() {

		int[] stats = new int[] { getHP(25000), 15, getAttack(850), 5, 65, 5, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(23000), 15, getAttack(950), 5, 75, 7, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Knight_Lancer(stats);

		stats = new int[] { getHP(19000), 15, getAttack(1200), 10, 100, 10, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Knight_Archer(stats);

		stats = new int[] { getHP(100000), 20, getAttack(2000), 10, 100, 0, 10 };
		AdvanceUnit enemyUnit4 = BossList.Mordred(stats);

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { null, enemyUnit4, null } };

		Stage stage = new Stage(2, false, units);
		return stage;

	}

	public static Stage MiniBoss2() {
		int[] stats = new int[] { getHP(70000), 10, getAttack(1520), 10, 70, 10, 5 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Sphinx(stats);

		stats = new int[] { getHP(120000), 10, getAttack(2250), 10, 100, 15, 10 };
		AdvanceUnit enemyUnit2 = BossList.Ozymandias(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null }, { null, enemyUnit2, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);

		Stage stage = new Stage(2, false, units);
		return stage;

	}

	public static Stage MiniBoss3() {
		int[] stats = new int[] { getHP(25000), 20, getAttack(1150), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.BlackSamurai(stats);

		stats = new int[] { getHP(25000), 20, getAttack(1150), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.BlackSamurai(stats);

		stats = new int[] { getHP(25000), 20, getAttack(1150), 10, 85, 10, 5 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.BlackSamurai(stats);

		stats = new int[] { getHP(100000), 15, getAttack(2000), 5, 120, 15, 10 };
		AdvanceUnit enemyUnit4 = BossList.TomoeGozen(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { null, enemyUnit4, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);

		Stage stage = new Stage(2, false, units);
		return stage;

	}

	public static Stage MiniBoss4() {
		int[] stats = new int[] { getHP(25000), 8, getAttack(1550), 15, 100, 12, 5 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Gazer(stats);

		stats = new int[] { getHP(25000), 8, getAttack(1550), 15, 100, 12, 5 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Gazer(stats);

		stats = new int[] { getHP(100000), 15, getAttack(2000), 15, 100, 5, 10 };
		AdvanceUnit enemyUnit3 = BossList.Napoleon(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null }, { null, enemyUnit2, null },
				{ null, enemyUnit3, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);

		Stage stage = new Stage(3, false, units);
		return stage;
	}

	public static Stage Boss() {
		int[] stats = new int[] { getHP(150000), 20, getAttack(2550), 10, 100, 10, 10 };
		AdvanceUnit enemyUnit1 = BossList.Nobunaga(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null } };

		Stage stage = new Stage(1, false, units);
		return stage;
	}

}
