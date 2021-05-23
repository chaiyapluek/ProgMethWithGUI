package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
import Unit.AdvanceUnit;

public class AdvanceUnitList {

	public static AdvanceUnit MechaBore(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseUltiGauge(1, 1);
		s2 = new IncreaseCritChance(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("High Voltage", description, SubSkills, 2, true, false, false);

		s1 = new Damage(80, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "";
		Skill skill2 = new NormalSkill("High Voltage", description, SubSkills, 1, false, false, false);

		s1 = new Damage(400, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "";
		Skill ulti = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, skill2, ulti };
		AdvanceUnit unit = new AdvanceUnit("Mecha Boar", "Berserker", stats, skills);
		unit.setUrl("EnemyUnit/Mecha_Demon_Boar.png");

		return unit;
	}

	public static AdvanceUnit Krichat(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 10);
		s2 = new IncreaseDef(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Instinct", description, SubSkills, 2, true, false, false);

		s1 = new Damage(100, 1);
		s2 = new DOTDamage(10, 500);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill skill2 = new NormalSkill("Poison", description, SubSkills, 1, false, true, false);

		s1 = new Damage(300, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		Skill ulti = new UltimateSkill("Avalanche Headbutt", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, skill2, ulti };
		AdvanceUnit unit = new AdvanceUnit("Krichat", "Lancer", stats, skills);
		unit.setUrl("EnemyUnit/Frost_lizard.png");

		return unit;
	}

	public static AdvanceUnit Yaga_Saber(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "";
		Skill skill1 = new NormalSkill("Beast's Breath", description, SubSkills, 2, true, false, false);

		s1 = new Damage(300, 1);
		s2 = new DecreaseCritChance(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Finishing shot", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Yaga", "Saber", stats, skills);
		unit.setUrl("EnemyUnit/Yeger_Saber.png");

		return unit;
	}

	public static AdvanceUnit Yaga_Archer(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseCritChance(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "";
		Skill skill1 = new NormalSkill("Beast's Sense of Smell", description, SubSkills, 3, false, false, true);

		s1 = new Damage(300, 1);
		s2 = new DecreaseCritChance(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Finishing shot", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Yaga", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/Yeger_Archer.png");

		return unit;
	}

	public static AdvanceUnit Knight_Saber(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(2, 20);
		s2 = new IncreaseDef(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Oath of Destruction", description, SubSkills, 2, true, false, true);

		s1 = new Damage(500, 1);
		s2 = new DecreaseAttack(3, 25);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Judgement Sword", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Knight Enforcer", "Saber", stats, skills);
		unit.setUrl("EnemyUnit/Knight_Saber.png");

		return unit;
	}

	public static AdvanceUnit Knight_Lancer(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseCritChance(2, 20);
		s2 = new IncreaseCritDamage(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Oath of Extermination", description, SubSkills, 2, true, false, true);

		s1 = new Damage(500, 1);
		s2 = new DOTDamage(5, 750);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Punishment Spear", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Knight Enforcer", "Lancer", stats, skills);
		unit.setUrl("EnemyUnit/Knight_Lancer.png");

		return unit;
	}

	public static AdvanceUnit Knight_Archer(int[] stats) {
		SubSkill s1, s2;
		s1 = new SureHit(3);
		s2 = new IncreaseCritDamage(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Oath of Eradication", description, SubSkills, 3, true, false, true);

		s1 = new Damage(500, 1);
		s2 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Execution Arrow", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Knight Enforcer", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/Knight_Archer.png");

		return unit;
	}

	public static AdvanceUnit Sphinx(int[] stats) {
		SubSkill s1, s2;
		s1 = new Stun(1);
		s2 = new DecreaseCritDamage(3, 50);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Query", description, SubSkills, 2, false, true, false);

		s1 = new Damage(400, 1);
		s2 = new DecreaseAttack(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("X", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Sphinx", "Berserker", stats, skills);
		unit.setUrl("EnemyUnit/Sphinx.png");
		return unit;
	}

	public static AdvanceUnit SeaDemon(int[] stats) {
		SubSkill s1, s2, s3;
		s1 = new DecreaseUltiGauge(5);
		s2 = new DecreaseCritDamage(3, 20);
		s3 = new DecreaseCritChance(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		String description = "";
		Skill skill1 = new NormalSkill("Coil", description, SubSkills, 3, false, true, false);

		s1 = new Damage(400, 1);
		s2 = new Stun(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Paralytic", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Sea Demon", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/SeaDemonSprite.png");
		return unit;
	}

	public static AdvanceUnit Ghost(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseUltiGauge(1, 1);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "";
		Skill skill1 = new NormalSkill("Evil Spirit Possession", description, SubSkills, 1, true, false, false);

		s1 = new Damage(300, 1);
		s2 = new DecreaseUltiGauge(5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Hands of Impurity", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Abhor Soul", "Berserker", stats, skills);
		unit.setUrl("EnemyUnit/GhostSprite.png");
		return unit;
	}

	public static AdvanceUnit BlackSamurai(int[] stats) {
		SubSkill s1, s2;
		s1 = new SureHit(3);
		s2 = new IncreaseCritChance(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Kassatsu Jizai", description, SubSkills, 3, true, false, false);

		s1 = new Damage(400, 1);
		s2 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Bamboo Slash", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Black Samurai", "Saber", stats, skills);
		unit.setUrl("EnemyUnit/Black_samurai.png");
		return unit;
	}
	
	public static AdvanceUnit Gazer(int[] stats) {
		SubSkill s1, s2;
		s1 = new SureHit(3);
		s2 = new IncreaseAttack(3, 20);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Observe", description, SubSkills, 3, true, false, false);

		s1 = new Damage(200, 1);
		s2 = new DOTDamage(10,100);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Heat Vision", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Gazer", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/Gazer_Sprite.png");
		return unit;
	}
	
	public static AdvanceUnit Soulless(int[] stats) {
		SubSkill s1, s2;
		s1 = new Stun(1);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "";
		Skill skill1 = new NormalSkill("Stun", description, SubSkills, 3, false, true, false);

		s1 = new Damage(200, 1);
		s2 = new DOTDamage(10,100);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		Skill ulti = new UltimateSkill("Heat Vision", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, ulti };
		AdvanceUnit unit = new AdvanceUnit("Gazer", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/Soulless_Archer.png");
		return unit;
	}

}
