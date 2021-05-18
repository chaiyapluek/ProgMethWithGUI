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

public class StageList_Difficulty4 {
	public static Stage[] getStage_Difficulty4() {
		Stage[] stages = new Stage[] { Stage1(), Stage2(), Stage3(), Stage4(), Stage5() };
		return stages;
	}

	public static int getHP(int HP) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 1500;
	}

	public static int getAttack(int Attack) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 150;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		AdvanceUnit enemyUnit1 = AdvanceUnitList.Knight_Saber(stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		AdvanceUnit enemyUnit2 = AdvanceUnitList.Knight_Lancer(stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		AdvanceUnit enemyUnit3 = AdvanceUnitList.Knight_Archer(stats);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 } };

		Stage stage1 = new Stage(1, false, units);
		return stage1;

	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Ghost", "Lancer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Ghost", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Ghost", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Ghost", "Lancer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1;
		s1 = new DecreaseDef(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "Decreases defense single enemy for 3 turns.";
		Skill enemyUnit6Skill = new NormalSkill("Terror", description, SubSkills, 3, false, true, false);

		s1 = new DOTDamage(3, 100);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage over time to one enemy for 3 turns.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Bind", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Terror Ghost", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 20, 12 };
		s1 = new IncreaseCritChance(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases critical chance for 3 turns.";
		Skill enemyUnit9Skill = new NormalSkill("Avici", description, SubSkills, 3, true, false, false);

		s1 = new Evade(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Evade all allies for 1 turn.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Gojoku Akuse", description, SubSkills, false, false, true);

		skills = new Skill[] { enemyUnit9Skill, enemyUnit9UltiSkill };
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Massive Ghost", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ enemyUnit7, enemyUnit8, enemyUnit9 } };

		Stage stage2 = new Stage(3, false, units);
		return stage2;

	}

	public static Stage Stage3() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1;
		s1 = new DecreaseDodgeChance(3, 50);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "Decreases Dodge Chance for 3 turns.";
		Skill enemyUnit6Skill = new NormalSkill("Terror", description, SubSkills, 3, false, true, false);

		s1 = new Damage(200, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "200% damage to one enemy 2 times.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Bind", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Terror Ghost", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 20, 12 };
		s1 = new IncreaseUltiGauge(1, 5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases Ultimate Gauge by 5.";
		Skill enemyUnit9Skill = new NormalSkill("Avici", description, SubSkills, 3, true, false, false);

		s1 = new Damage(250, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "250% damage to all enemies 2 times.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Gojoku Akuse", description, SubSkills, false, false, false);

		skills = new Skill[] { enemyUnit9Skill, enemyUnit9UltiSkill };
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Massive Ghost", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ enemyUnit7, enemyUnit8, enemyUnit9 } };

		Stage stage3 = new Stage(3, false, units);
		return stage3;

	}

	public static Stage Stage4() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(2200), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Ghost", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Ghost", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1;
		s1 = new DecreaseCritDamage(3, 100);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "Decreases Critical damage for 3 turns.";
		Skill enemyUnit6Skill = new NormalSkill("Terror", description, SubSkills, 3, false, true, false);

		s1 = new DOTDamage(3, 100);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage over time to one enemy for 3 turns.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Bind", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Terror Ghost", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 20, 12 };
		s1 = new Heal(3, 200);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Heal for 3 turns.";
		Skill enemyUnit9Skill = new NormalSkill("Avici", description, SubSkills, 3, true, false, false);

		s1 = new DecreaseAttack(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Decrease attack all enemies for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Gojoku Akuse", description, SubSkills, false, false, false);

		skills = new Skill[] { enemyUnit9Skill, enemyUnit9UltiSkill };
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Massive Ghost", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ enemyUnit7, enemyUnit8, enemyUnit9 } };

		Stage stage4 = new Stage(3, false, units);
		return stage4;

	}

	public static Stage Stage5() {

		int[] stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit3 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Ghost", "Berserker", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 10, 10 };
		SubSkill s1;
		s1 = new Stun(2);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "Stun single enemy for 2 turns.";
		Skill enemyUnit6Skill = new NormalSkill("Terror", description, SubSkills, 4, false, true, false);

		s1 = new Damage(200, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "200% damage to all enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Bind", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { enemyUnit6Skill, enemyUnit6UltiSkill };
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Terror Ghost", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Ghost", "Saber", stats);

		stats = new int[] { getHP(3000), 20, getAttack(300), 10, 200, 20, 12 };
		s1 = new IgnoreDef(3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Ignore defense for 3 turns.";
		Skill enemyUnit9Skill = new NormalSkill("Avici", description, SubSkills, 3, true, false, false);

		s1 = new DOTDamage(3, 300);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage over time to all enemies for 3 turnsS.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Gojoku Akuse", description, SubSkills, false, false, false);

		skills = new Skill[] { enemyUnit9Skill, enemyUnit9UltiSkill };
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Massive Ghost", "Berserker", stats, skills);

		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 }, { enemyUnit4, enemyUnit5, enemyUnit6 },
				{ enemyUnit7, enemyUnit8, enemyUnit9 } };

		Stage stage5 = new Stage(3, false, units);
		return stage5;

	}
}
