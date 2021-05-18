package List;

import java.util.Random;

import Map.Stage;
import UnitBase.AdvanceUnit;
import UnitBase.BasicUnit;
import UnitBase.Unit;

public class StageList_Difficulty3 {
	public static Stage[] getStage_Difficulty2() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		return stages;
	}

	public static int getHP(int HP) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 1000;
	}

	public static int getAttack(int Attack) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 100;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(5100), 10, getAttack(310), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(5200), 10, getAttack(330), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(5500), 10, getAttack(340), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(5500), 15, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(5700), 15, getAttack(355), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(6500), 15, getAttack(380), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(20000), 30, getAttack(600), 8, 150, 13, 3 };
		AdvanceUnit enemyUnit7 = AdvanceUnitList.MechaBore(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ null, enemyUnit7, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);
		enemyUnit7.setID(7);

		Stage stage1 = new Stage(3, false, units);
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(3500), 15, getAttack(350), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3200), 15, getAttack(350), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3700), 15, getAttack(370), 20, 65, 10, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4200), 15, getAttack(370), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4000), 15, getAttack(370), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3500), 12, getAttack(390), 25, 80, 15, 4 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.Yaga_Archer(stats);

		stats = new int[] { getHP(4500), 12, getAttack(410), 25, 80, 15, 4 };
		AdvanceUnit enemyUnit7 = AdvanceUnitList.Yaga_Archer(stats);

		stats = new int[] { getHP(5000), 13, getAttack(420), 25, 85, 15, 4 };
		AdvanceUnit enemyUnit8 = AdvanceUnitList.Yaga_Archer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ null, enemyUnit7, enemyUnit8 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);
		enemyUnit7.setID(7);
		enemyUnit8.setID(8);

		Stage stage2 = new Stage(3, false, units);
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(12000), 20, getAttack(650), 15, 65, 10, 3 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Krichat(stats);

		stats = new int[] { getHP(13000), 22, getAttack(750), 18, 70, 12, 3 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Krichat(stats);

		stats = new int[] { getHP(15000), 25, getAttack(850), 25, 70, 15, 3 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Krichat(stats);

		Unit[][] units = new Unit[][] { { null, enemyUnit1, null }, { null, enemyUnit2, null },
				{ null, enemyUnit3, null } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);

		Stage stage3 = new Stage(3, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(3500), 15, getAttack(365), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3700), 15, getAttack(375), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3500), 15, getAttack(370), 20, 65, 10, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4200), 15, getAttack(390), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3900), 15, getAttack(390), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(3600), 12, getAttack(450), 25, 80, 15, 4 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.Yaga_Archer(stats);

		stats = new int[] { getHP(19500), 25, getAttack(850), 25, 70, 15, 3 };
		AdvanceUnit enemyUnit7 = AdvanceUnitList.Krichat(stats);

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

		int[] stats = new int[] { getHP(4500), 15, getAttack(370), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4200), 15, getAttack(375), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4700), 15, getAttack(390), 20, 65, 10, 4 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4200), 15, getAttack(400), 20, 60, 10, 4 };
		AdvanceUnit enemyUnit4 = AdvanceUnitList.Yaga_Saber(stats);

		stats = new int[] { getHP(4200), 12, getAttack(450), 25, 80, 15, 4 };
		AdvanceUnit enemyUnit5 = AdvanceUnitList.Yaga_Archer(stats);

		stats = new int[] { getHP(5500), 12, getAttack(475), 25, 80, 15, 4 };
		AdvanceUnit enemyUnit6 = AdvanceUnitList.Yaga_Archer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		enemyUnit1.setID(1);
		enemyUnit2.setID(2);
		enemyUnit3.setID(3);
		enemyUnit4.setID(4);
		enemyUnit5.setID(5);
		enemyUnit6.setID(6);

		Stage stage5 = new Stage(2, false, units);
		return stage5;

	}

	public static Stage testStage() {

		int[] stats = new int[] { getHP(1), 0, getAttack(999999), 0, 0, 0, 0 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.MechaBore(stats);

		enemyUnit1.setID(1);

		Unit[][] units = new Unit[][] { { enemyUnit1 } };

		Stage stage5 = new Stage(1, false, units);
		return stage5;
	}
}
