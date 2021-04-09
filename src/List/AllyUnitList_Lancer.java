package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.*;
import SubSkill.*;
import UnitBase.AllyUnit;

public class AllyUnitList_Lancer {

	/*
	 * Stats = {HP , Def , Att , CritChance , CritDmg , DodgeChance , ultiGauge}
	 * Skill -> (name,des,subskills,cooldownTime,toYourself,isSingle,toAlly)
	 */
	public static ArrayList<AllyUnit> getAllUnits() {
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		units.add(Enkidu());
		units.add(Karna());
		units.add(Leonidas());
		return units;
	}

	public static AllyUnit Enkidu() {
		int[] stats = { 6750, 25, 1180, 15, 185, 15, 18 };
		int[] statsFactors = { 0, 20, 25, 10, 45 };
		int[] skillRequirement = { 1, 2, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(2, 15);
		s2 = new IncreaseCritChance(2, 15);
		s3 = new IncreaseCritDamage(2, 60);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase attack, crit chance and crit damage to yourself[2 turns]";
		Skill Enkidu_FirstSkill = new NormalSkill("Transfiguration", description, SubSkills, 5, true, false, false);

		s1 = new Evade(2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Grants self Evasion[2 turns]";
		Skill Enkidu_SecondSkill = new NormalSkill("Presence Detection", description, SubSkills, 6, true, false, false);

		s1 = new Heal(0, 60);
		s2 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Recovers own HP and Remove own debuff";
		Skill Enkidu_ThirdSkill = new NormalSkill("Consummated Shape", description, SubSkills, 8, true, false, false);

		s1 = new DecreaseDef(3, 15);
		s2 = new Stun(1);
		s3 = new Damage(1100, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage to one enemy and Stun enemy[1 turn] and reduce enemy defense[3 turns]";
		Skill Enkidu_Ultimate = new UltimateSkill("Enuma Elis", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { Enkidu_FirstSkill, Enkidu_SecondSkill, Enkidu_ThirdSkill, Enkidu_Ultimate };
		AllyUnit Enkidu = new AllyUnit("Enkidu", "Lancer", stats, skills, statsFactors, skillRequirement);
		Enkidu.setUrl("AllyUnit/Enkidu.png");
		return Enkidu;
	}

	public static AllyUnit Karna() {
		int[] stats = { 4950, 30, 2130, 10, 230, 20, 25 };
		int[] statsFactors = { 0, 25, 25, 25, 25 };
		int[] skillRequirement = { 1, 3, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Stun(1);
		s2 = new DecreaseDef(3, 10);
		s3 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Stun all enemies[1 turn] and reduces enemies's defense and dodge chance[3 turns]";
		Skill Karna_FirstSkill = new NormalSkill("Knowledge of the Deprived", description, SubSkills, 6, false, false,
				false);

		s1 = new IncreaseAttack(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own attack[3 turns]";
		Skill Karna_SecondSkill = new NormalSkill("Mana Burst", description, SubSkills, 5, true, false, false);

		s1 = new IncreaseUltiGauge(0, 15);
		s2 = new IncreaseCritChance(3, 10);
		s3 = new IncreaseCritDamage(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own Gauge and increases own crit chance and crit damage[3 turns]";
		Skill Karna_ThirdSkill = new NormalSkill("Uncrowned Arms Mastery", description, SubSkills, 6, true, false,
				false);

		s1 = new Damage(150, 4);
		s2 = new DecreaseAttack(3, 15);
		s3 = new DOTDamage(3, 700);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage to all enemies, inflicts DOT damage and decrease their attack[3 turns]";
		Skill Karna_Ultimate = new UltimateSkill("Vasavi Shakti", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { Karna_FirstSkill, Karna_SecondSkill, Karna_ThirdSkill, Karna_Ultimate };
		AllyUnit Karna = new AllyUnit("Karna", "Lancer", stats, skills, statsFactors, skillRequirement);
		Karna.setUrl("AllyUnit/Karna.png");
		return Karna;
	}

	public static AllyUnit Leonidas() {
		int[] stats = { 7540, 35, 680, 5, 250, 10, 20 };
		int[] statsFactors = { 0, 30, 20, 30, 20 };
		int[] skillRequirement = { 1, 3, 3 };
		SubSkill s1, s2;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Taunt(1);
		s2 = new IncreaseUltiGauge(3, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Applies Taunt[1 turn] and generate gauge[3 turns] to yourself";
		Skill Leonidas_FirstSkill = new NormalSkill("Pride of the Rearguard", description, SubSkills, 6, true, false,
				false);

		s1 = new Heal(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recovers HP every turn[3 turns]";
		Skill Leonidas_SecondSkill = new NormalSkill("Battle Continuation", description, SubSkills, 5, true, false,
				false);

		s1 = new IncreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases defense to all allies[3 turns]";
		Skill Leonidas_ThirdSkill = new NormalSkill("War cry", description, SubSkills, 7, false, false, true);

		s1 = new Taunt(3);
		s2 = new IncreaseDef(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own defense[3 turns] and applies Taunt to yourself[3 turns]";
		Skill Leonidas_Ultimate = new UltimateSkill("Thermopylae Enomotia", description, SubSkills, true, false, false);

		Skill[] skills = new Skill[] { Leonidas_FirstSkill, Leonidas_SecondSkill, Leonidas_ThirdSkill,
				Leonidas_Ultimate };
		AllyUnit Leonidas = new AllyUnit("Leonidas", "Lancer", stats, skills, statsFactors, skillRequirement);
		Leonidas.setUrl("AllyUnit/Leonidas.png");
		return Leonidas;
	}
}
