package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Map.Stage;
import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
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

		int[] stats = new int[] { getHP(3000), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(3000), 10, getAttack(300), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(3000), 10, getAttack(320), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(3500), 15, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(3500), 15, getAttack(350), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(3500), 15, getAttack(380), 5, 100, 5, 0 };
		BasicUnit enemyUnit6 = BasicUnitList.DemonBoar(stats);

		stats = new int[] { getHP(20000), 30, getAttack(600), 8, 100, 13, 3 };
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

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Demon Boar", "Lancer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Demon Boar", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Demon Boar", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Demon Boar", "Lancer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1, s2;
		s1 = new IncreaseCritDamage(3, 100);
		s2 = new IncreaseCritChance(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "Increases own critical damage by 100% for 3 turns and Increases own critical attack chance by 10% for 3 turns";
		Skill enemyUnit6Skill = new NormalSkill("High Voltage", description, SubSkills, 3, true, false, false);

		s1 = new Stun(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Stun all enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Mecha Demon Boar", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage2 = new Stage(2, false, units);
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 100);
		s2 = new IncreaseDef(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "Increases own Attack and Defense for 3 turns";
		Skill enemyUnit6Skill = new NormalSkill("High Voltage", description, SubSkills, 3, true, false, false);

		s1 = new DOTDamage(5, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "50 damage to all enemies for 5 turns.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Mecha Demon Boar", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage3 = new Stage(2, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Demon Boar", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(2200), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Demon Boar", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Demon Boar", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1;
		s1 = new IncreaseUltiGauge(3, 1);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "Increases own Ulti gauge by 1 for 3 turns";
		Skill enemyUnit6Skill = new NormalSkill("High Voltage", description, SubSkills, 3, true, false, false);

		s1 = new Damage(300, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "300% damage to all enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Mecha Demon Boar", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage4 = new Stage(2, false, units);
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Demon Boar", "Berserker", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1, s2;
		s1 = new IncreaseUltiGauge(1, 1);
		s2 = new IncreaseCritChance(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "Increases own Ulti gauge by 1 and Increases own critical attack chance by 10% for 3 turns";
		Skill enemyUnit6Skill = new NormalSkill("High Voltage", description, SubSkills, 3, true, false, false);

		s1 = new Damage(400, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "400% damage to all enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Mecha Demon Boar", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 } };

		Stage stage5 = new Stage(2, false, units);
		return stage5;

	}

	public static Stage testStage() {

		int[] stats = new int[] { getHP(1), 0, getAttack(999999), 0, 0, 0, 0 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.MechaBore(stats);

		enemyUnit1.setID(1);

		Unit[][] units = new Unit[][] { { enemyUnit1} };

		Stage stage5 = new Stage(1, false, units);
		return stage5;
	}
}
