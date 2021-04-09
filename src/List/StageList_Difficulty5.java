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

public class StageList_Difficulty5 {
	public static Stage[] getStage_Difficulty5() {
		Stage[] stages = new Stage[] {Stage1(),Stage2(),Stage3(),Stage4(),Stage5()};
		return stages;
	}
	
	public static int getHP(int HP) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * HP * num / 100) + 2000;
	}

	public static int getAttack(int Attack) {
		Random r = new Random();
		int num = r.nextInt(16) + 95;
		return (int) (1.0 * Attack * num / 100) + 200;
	}

	public static Stage Stage1() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(3000), 20, getAttack(100), 5, 100, 5, 0 };
		SubSkill s1,s2;
		s1 = new DecreaseDef(3,20);
		s2 = new Heal(1,40);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		String description = "Decreases own defense for 3 turns and Recover HP by 2000";
		Skill enemyUnit3Skill = new NormalSkill("Terror", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(400,1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "400% damage to one enemies.";
		Skill enemyUnit3UltiSkill = new UltimateSkill("Rock Peel", description ,SubSkills, false, true, false);
		
		Skill[] skills = new Skill[] {enemyUnit3Skill,enemyUnit3UltiSkill};
		AdvanceUnit enemyUnit3 = new AdvanceUnit("Stone Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(4000), 25, getAttack(200), 10, 200, 5, 10 };
		
		s1 = new IncreaseDef(1,50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own defence by 50% for 1 turn.";
		Skill enemyUnit6Skill = new NormalSkill("Ultra-Hardening", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(500,1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "500% damage to one enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Ground Mimic", description ,SubSkills, false, true, false);
		
		skills = new Skill[] {enemyUnit6Skill,enemyUnit6UltiSkill};
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Iron Golem", "Berserker", stats, skills);
		
		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Golem", "Saber", stats);
		
		stats = new int[] { getHP(5000), 25, getAttack(200), 10, 200, 0, 12 };
		s1 = new Heal(5,14);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recover 1000 HP at the end of each turn for 5 turns";
		Skill enemyUnit9Skill = new NormalSkill("Light Emission", description ,SubSkills, 7, true, false, false);
		
		s1 = new Heal(5,14);
		s2 = new IncreaseDef(3,50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Recover 1000 HP at the end of each turn for 5 turns and Grants self Defense Up for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Shining, Surging Seas", description ,SubSkills, true, false, false);
		
		skills = new Skill[] {enemyUnit9Skill,enemyUnit9UltiSkill};
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Crystal Golem", "Berserker", stats, skills);
		
		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 }, {enemyUnit7,enemyUnit8,enemyUnit9} };

		Stage stage1 = new Stage(3,false,units);	
		return stage1;
		
	}

	public static Stage Stage2() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Golem", "Lancer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Golem", "Lancer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(100), 5, 100, 5, 0 };
		SubSkill s1,s2;
		s1 = new DecreaseAttack(3,100);
		s2 = new Heal(1,40);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		String description = "Decreases own attack for 3 turns and Recover HP by 2000";
		Skill enemyUnit3Skill = new NormalSkill("Terror", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(200,1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "200% damage to all enemies.";
		Skill enemyUnit3UltiSkill = new UltimateSkill("Rock Peel", description ,SubSkills, false, false, false);
		
		Skill[] skills = new Skill[] {enemyUnit3Skill,enemyUnit3UltiSkill};
		AdvanceUnit enemyUnit3 = new AdvanceUnit("Stone Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Golem", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Golem", "Lancer", stats);

		stats = new int[] { getHP(4000), 25, getAttack(200), 10, 200, 5, 10 };
		
		s1 = new IncreaseDef(2,25);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own defence by 25% for 2 turn.";
		Skill enemyUnit6Skill = new NormalSkill("Ultra-Hardening", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(250,1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "250% damage to all enemies.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Ground Mimic", description ,SubSkills, false, false, false);
		
		skills = new Skill[] {enemyUnit6Skill,enemyUnit6UltiSkill};
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Iron Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Golem", "Saber", stats);
		
		stats = new int[] { getHP(5000), 25, getAttack(200), 10, 200, 0, 12 };
		s1 = new IncreaseMaxHP(5,14);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase Max HP for 5 turns";
		Skill enemyUnit9Skill = new NormalSkill("Light Emission", description ,SubSkills, 7, true, false, false);
		
		s1 = new IncreaseMaxHP(5,14);
		s2 = new IncreaseDef(3,50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Increase Max HP for 5 turns and Grants self Defense Up for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Shining, Surging Seas", description ,SubSkills, true, false, false);
		
		skills = new Skill[] {enemyUnit9Skill,enemyUnit9UltiSkill};
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Crystal Golem", "Berserker", stats, skills);
		
		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 }, {enemyUnit7,enemyUnit8,enemyUnit9} };

		Stage stage2 = new Stage(3,false,units);	
		return stage2;
		
	}
	
	public static Stage Stage3() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(100), 5, 100, 5, 0 };
		SubSkill s1,s2;
		s1 = new DecreaseDef(3,20);
		s2 = new IncreaseMaxHP(3,2000);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		String description = "Decreases own defense and Increase Max HP by 2000 for 3 turns.";
		Skill enemyUnit3Skill = new NormalSkill("Terror", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(200,2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "200% damage to one enemy 2 times.";
		Skill enemyUnit3UltiSkill = new UltimateSkill("Rock Peel", description ,SubSkills, false, true, false);
		
		Skill[] skills = new Skill[] {enemyUnit3Skill,enemyUnit3UltiSkill};
		AdvanceUnit enemyUnit3 = new AdvanceUnit("Stone Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(4000), 25, getAttack(200), 10, 200, 5, 10 };
		
		s1 = new IncreaseDef(3,17);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own defence by 17% for 3 turn.";
		Skill enemyUnit6Skill = new NormalSkill("Ultra-Hardening", description ,SubSkills, 3, true, false, false);
		
		s1 = new DOTDamage(5,100);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage over time to one enemy.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Ground Mimic", description ,SubSkills, false, true, false);
		
		skills = new Skill[] {enemyUnit6Skill,enemyUnit6UltiSkill};
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Iron Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Golem", "Saber", stats);
		
		stats = new int[] { getHP(5000), 25, getAttack(200), 10, 200, 0, 12 };
		s1 = new Heal(10,7);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recover 500 HP at the end of each turn for 10 turns";
		Skill enemyUnit9Skill = new NormalSkill("Light Emission", description ,SubSkills, 7, true, false, false);
		
		s1 = new Heal(10,7);
		s2 = new IncreaseDef(3,50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Recover 500 HP at the end of each turn for 10 turns and Grants self Defense Up for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Shining, Surging Seas", description ,SubSkills, true, false, false);
		
		skills = new Skill[] {enemyUnit9Skill,enemyUnit9UltiSkill};
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Crystal Golem", "Berserker", stats, skills);
		
		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 }, {enemyUnit7,enemyUnit8,enemyUnit9} };

		Stage stage3 = new Stage(3,false,units);	
		return stage3;
		
	}
	
	public static Stage Stage4() {

		int[] stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(1500), 15, getAttack(150), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(3000), 20, getAttack(100), 5, 100, 5, 0 };
		SubSkill s1,s2;
		s1 = new DecreaseDef(3,20);
		s2 = new Evade(1);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		String description = "Decreases own defense for 3 turns and Evade 1 turn";
		Skill enemyUnit3Skill = new NormalSkill("Terror", description ,SubSkills, 3, true, false, false);
		
		s1 = new Damage(100,2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "100% damage to all enemies 2 times.";
		Skill enemyUnit3UltiSkill = new UltimateSkill("Rock Peel", description ,SubSkills, false, false, false);
		
		Skill[] skills = new Skill[] {enemyUnit3Skill,enemyUnit3UltiSkill};
		AdvanceUnit enemyUnit3 = new AdvanceUnit("Stone Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Golem", "Lancer", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Golem", "Archer", stats);

		stats = new int[] { getHP(4000), 25, getAttack(200), 10, 200, 5, 10 };
		
		s1 = new IncreaseDef(1,25);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases ally defence by 25% for 1 turn.";
		Skill enemyUnit6Skill = new NormalSkill("Ultra-Hardening", description ,SubSkills, 3, false, false, true);
		
		s1 = new Stun(2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Stun all enemies 2 turns.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Ground Mimic", description ,SubSkills, false, false, false);
		
		skills = new Skill[] {enemyUnit6Skill,enemyUnit6UltiSkill};
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Iron Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Golem", "Saber", stats);
		
		stats = new int[] { getHP(5000), 25, getAttack(200), 10, 200, 0, 12 };
		s1 = new Heal(3,10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recover HP to all allies at the end of each turn for 3 turns";
		Skill enemyUnit9Skill = new NormalSkill("Light Emission", description ,SubSkills, 7, false, false, true);
		
		s1 = new Heal(3,10);
		s2 = new IncreaseDef(3,50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Recover HP to all allies at the end of each turn for 3 turns and Grants self Defense Up for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Shining, Surging Seas", description ,SubSkills, true, false, false);
		
		skills = new Skill[] {enemyUnit9Skill,enemyUnit9UltiSkill};
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Crystal Golem", "Berserker", stats, skills);
		
		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 }, {enemyUnit7,enemyUnit8,enemyUnit9} };

		Stage stage4 = new Stage(3,false,units);	
		return stage4;
		
	}
	
	public static Stage Stage5() {

		int[] stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit1 = new BasicUnit("Golem", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit2 = new BasicUnit("Golem", "Berserker", stats);

		stats = new int[] { getHP(3000), 20, getAttack(100), 5, 100, 5, 0 };
		SubSkill s1,s2;
		s1 = new Stun(3);
		s2 = new Heal(1,40);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		String description = "Stun itself for 3 turns and Recover HP by 2000";
		Skill enemyUnit3Skill = new NormalSkill("Terror", description ,SubSkills, 3, true, false, false);
		
		s1 = new Stun(3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Stun one enemy for 3 turns.";
		Skill enemyUnit3UltiSkill = new UltimateSkill("Rock Peel", description ,SubSkills, false, true, false);
		
		Skill[] skills = new Skill[] {enemyUnit3Skill,enemyUnit3UltiSkill};
		AdvanceUnit enemyUnit3 = new AdvanceUnit("Stone Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit4 = new BasicUnit("Golem", "Berserker", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit5 = new BasicUnit("Golem", "Berserker", stats);

		stats = new int[] { getHP(4000), 25, getAttack(200), 10, 200, 5, 10 };
		
		s1 = new IncreaseDef(1,25);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases allies defence by 25% for 1 turn.";
		Skill enemyUnit6Skill = new NormalSkill("Ultra-Hardening", description ,SubSkills, 3, false, false, true);
		
		s1 = new Stun(2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Stun all enemies 2 turns.";
		Skill enemyUnit6UltiSkill = new UltimateSkill("Ground Mimic", description ,SubSkills, false, false, false);
		
		skills = new Skill[] {enemyUnit6Skill,enemyUnit6UltiSkill};
		AdvanceUnit enemyUnit6 = new AdvanceUnit("Iron Golem", "Berserker", stats, skills);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit7 = new BasicUnit("Golem", "Saber", stats);

		stats = new int[] { getHP(2000), 15, getAttack(200), 5, 100, 5, 0 };
		BasicUnit enemyUnit8 = new BasicUnit("Golem", "Saber", stats);
		
		stats = new int[] { getHP(5000), 25, getAttack(200), 10, 200, 0, 12 };
		s1 = new Heal(5,5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recover all allies HP at the end of each turn for 5 turns";
		Skill enemyUnit9Skill = new NormalSkill("Light Emission", description ,SubSkills, 7, false, false, true);
		
		s1 = new Heal(5,7);
		s2 = new IncreaseDef(3,20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Recover all allies HP at the end of each turn for 5 turns and Grants self Defense Up for 3 turns.";
		Skill enemyUnit9UltiSkill = new UltimateSkill("Shining, Surging Seas", description ,SubSkills, false, false, true);
		
		skills = new Skill[] {enemyUnit9Skill,enemyUnit9UltiSkill};
		AdvanceUnit enemyUnit9 = new AdvanceUnit("Crystal Golem", "Berserker", stats, skills);
		
		Unit[][] units = new Unit[][] { { enemyUnit1, enemyUnit2, enemyUnit3 },
				{ enemyUnit4, enemyUnit5, enemyUnit6 }, {enemyUnit7,enemyUnit8,enemyUnit9} };

		Stage stage5 = new Stage(3,false,units);	
		return stage5;
		
	}
}
