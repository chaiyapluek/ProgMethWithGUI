package List;

import java.util.Random;

import Map.Stage;
import UnitBase.BasicUnit;
import UnitBase.Unit;

public class StageList_Difficulty2 {
	
	public static Stage[] getStage_Difficulty2() {
		Stage[] stages = new Stage[] {Stage1(),Stage2(),Stage3(),Stage4(),Stage5()};
		return stages;
	}
	
	public static int getHP(int HP) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 500;
	}

	public static int getAttack(int Attack) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 50;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Soldier", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Soldier", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Soldier", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Soldier", "Saber", stats);

		stats = new int[] { getHP(2500), 15, getAttack(250), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = new BasicUnit("Spartan Soldier", "Berserker", stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage1 = new Stage(2,false,units);	
		return stage1;
		
	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Soldier", "Lancer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Soldier", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Soldier", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Soldier", "Lancer", stats);

		stats = new int[] { getHP(2500), 15, getAttack(250), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = new BasicUnit("Spartan Soldier", "Berserker", stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage2 = new Stage(2,false,units);	
		return stage2;
		
	}
	
	public static Stage Stage3() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2500), 15, getAttack(250), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = new BasicUnit("Spartan Soldier", "Berserker", stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage3 = new Stage(2,false,units);	
		return stage3;
		
	}
	
	public static Stage Stage4() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Soldier", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2200), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Soldier", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Soldier", "Archer", stats);

		stats = new int[] { getHP(2500), 15, getAttack(250), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = new BasicUnit("Spartan Soldier", "Berserker", stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage4 = new Stage(2,false,units);	
		return stage4;
		
	}
	
	public static Stage Stage5() {

		int[] stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Soldier", "Berserker", stats);

		stats = new int[] { getHP(2500), 15, getAttack(250), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = new BasicUnit("Spartan Soldier", "Berserker", stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage5 = new Stage(2,false,units);	
		return stage5;
		
	}
}
