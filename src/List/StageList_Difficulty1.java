package List;

import java.util.Random;

import Map.Stage;
import Unit.BasicUnit;
import Unit.Unit;

public class StageList_Difficulty1 {

	/*
	 * numberOfWave = 2 Money = ??? item drop ??? stats =
	 * {HP,DEF,ATT,CRIT,CRITDMG,DODGE,ULTI}
	 */

	private static Random r = new Random();
	
	public static Stage[] getStage_Difficulty1() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		return stages;
	}

	public static int getHP(int HP) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100);
	}

	public static int getAttack(int Attack) {
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100);
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Skeleton_Saber(stats);

		stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Skeleton_Saber(stats);

		stats = new int[] { getHP(2000), 10, getAttack(250), 5, 100, 0, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Skeleton_Saber(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Skeleton_Saber(stats);

		stats = new int[] { getHP(2500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.Golem(stats);

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage1 = new Stage(2, false, units);
		stage1.setMoneyDrop(500 + r.nextInt(100));
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Skeleton_Lancer(stats);

		stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Skeleton_Lancer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(250), 5, 100, 0, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Skeleton_Lancer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Skeleton_Lancer(stats);

		stats = new int[] { getHP(2500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.Golem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage2 = new Stage(2, false, units);
		stage2.setMoneyDrop(500 + r.nextInt(100));
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(250), 5, 100, 0, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.Golem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage3 = new Stage(2, false, units);
		stage3.setMoneyDrop(500 + r.nextInt(100));
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Skeleton_Saber(stats);

		stats = new int[] { getHP(1500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2200), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Skeleton_Lancer(stats);

		stats = new int[] { getHP(2000), 10, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Skeleton_Archer(stats);

		stats = new int[] { getHP(2500), 10, getAttack(350), 5, 100, 0, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.Golem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage4 = new Stage(2, false, units);
		stage4.setMoneyDrop(500 + r.nextInt(100));
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(2000), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2300), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2500), 10, getAttack(300), 5, 100, 0, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2500), 12, getAttack(325), 10, 100, 0, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(4000), 15, getAttack(400), 5, 100, 0, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.Golem(stats);

		stats = new int[] { getHP(2750), 13, getAttack(325), 5, 100, 0, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.Golem(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage5 = new Stage(2, false, units);
		stage5.setMoneyDrop(500 + r.nextInt(100));
		return stage5;

	}
}
