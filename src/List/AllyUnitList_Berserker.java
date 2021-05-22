package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
import Unit.AllyUnit;

public class AllyUnitList_Berserker {

	public static ArrayList<AllyUnit> getAllUnits() {
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		units.add(Kiyohime());
		units.add(Heracles());
		units.add(Asteriod());
		units.add(Edmond());
		units.add(Mysterious());
		return units;
	}

	public static AllyUnit Kiyohime() {
		int[] stats = { 6911, 20, 1455, 10, 200, 10, 20 };
		int[] statsFactors = { 0, 25, 25, 25, 25 };
		int[] skillRequirement = { 1, 1, 1 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseDef(3, 24);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase own defense [3 turns]";
		Skill Kiyohime_FirstSkill = new NormalSkill("Shapeshift", description, SubSkills, 5, true, false, false);
		Kiyohime_FirstSkill.setUrl("Skill/Def.png");
		
		s1 = new DecreaseDef(3, 24);
		s2 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Decrease one enemy's defense and dodge chance [3 turns]";
		Skill Kiyohime_SecondSkill = new NormalSkill("Stalking", description, SubSkills, 5, false, true, false);
		Kiyohime_SecondSkill.setUrl("Skill/Defdown.png");
		
		s1 = new IncreaseUltiGauge(0, 10);
		s2 = new IncreaseAttack(3, 30);
		s3 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase gauge, attack and remove debuff to one ally";
		Skill Kiyohime_ThirdSkill = new NormalSkill("Flame-Coloured Kiss", description, SubSkills, 6, false, true,
				true);
		Kiyohime_ThirdSkill.setUrl("Skill/Attack.png");
		
		s1 = new Damage(160, 3);
		s2 = new DOTDamage(3, 500);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage and inflict DOT to all enemies";
		Skill Kiyohime_Ultimate = new UltimateSkill("Tenshin Kashou Zanmai", description, SubSkills, false, false,
				false);
		Kiyohime_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Kiyohime_FirstSkill, Kiyohime_SecondSkill, Kiyohime_ThirdSkill,
				Kiyohime_Ultimate };
		AllyUnit Kiyohime = new AllyUnit("Kiyohime", "Berserker", stats, skills, statsFactors, skillRequirement);
		Kiyohime.setUrl("AllyUnit/Kiyohime.png");
		Kiyohime.setIconUrl("AllyUnit/Icon/Kiyohime_Icon.png");
		return Kiyohime;
	}

	public static AllyUnit Heracles() {
		int[] stats = { 7086, 15, 1521, 10, 150, 10, 25 };
		int[] statsFactors = { 0, 10, 20, 30, 40 };
		int[] skillRequirement = { 1, 1, 2 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 31);
		s2 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own attack [3 turns] and remove debuff";
		Skill Harecles_FirstSkill = new NormalSkill("Bravery", description, SubSkills, 5, true, false, false);
		Harecles_FirstSkill.setUrl("Skill/Burst.png");
		
		s1 = new Evade(1);
		s2 = new IncreaseCritChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Grants self Evasion[1 turn] and increases  crit chance [3 turns]";
		Skill Harecles_SecondSkill = new NormalSkill("Eye of the Mind", description, SubSkills, 6, true, true, false);
		Harecles_SecondSkill.setUrl("Skill/Evade.png");
		
		s1 = new IncreaseDef(3, 18);
		s2 = new Heal(5, 5);
		s3 = new IncreaseUltiGauge(5, 4);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own defense[3 turns], increases HP and Gauge every turn [5 turns]";
		Skill Harecles_ThirdSkill = new NormalSkill("Indomitable", description, SubSkills, 8, true, false, false);
		Harecles_ThirdSkill.setUrl("Skill/Def.png");
		
		s1 = new Damage(60, 10);
		s2 = new DecreaseDef(3, 15);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage and decrease defense [3 turns] to one enemy";
		Skill Harecles_Ultimate = new UltimateSkill("Nine Lives", description, SubSkills, false, true, false);
		Harecles_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Harecles_FirstSkill, Harecles_SecondSkill, Harecles_ThirdSkill,
				Harecles_Ultimate };
		AllyUnit Heracles = new AllyUnit("Heracles", "Berserker", stats, skills, statsFactors, skillRequirement);
		Heracles.setUrl("AllyUnit/Heracles.png");
		Heracles.setIconUrl("AllyUnit/Icon/Heracles_Icon.png");
		return Heracles;
	}

	public static AllyUnit Asteriod() {
		int[] stats = { 6623, 15, 1397, 15, 150, 13, 18 };
		int[] statsFactors = { 0, 30, 15, 25, 30 };
		int[] skillRequirement = { 1, 1, 2 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own attack [3 turns]";
		Skill Asteriod_FirstSkill = new NormalSkill("Monstrous Strength", description, SubSkills, 5, true, false,
				false);
		Asteriod_FirstSkill.setUrl("Skill/Attack.png");
		
		s1 = new RemoveDebuff();
		s2 = new IncreaseDef(3, 40);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own defense [3 turns] and Removes debuff";
		Skill Asteriod_SecondSkill = new NormalSkill("Natural Demon", description, SubSkills, 5, true, true, false);
		Asteriod_SecondSkill.setUrl("Skill/Def.png");
		
		s1 = new Damage(80, 1);
		s2 = new DecreaseAttack(3, 10);
		s3 = new DecreaseCritChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damages to all enemies, decreases Attack and Crit chance [3 turns]";
		Skill Asteriod_ThirdSkill = new NormalSkill("Labrys of the Abyss", description, SubSkills, 5, false, false,
				false);
		Asteriod_ThirdSkill.setUrl("Skill/Damage.png");
		
		s1 = new DecreaseAttack(6, 20);
		s2 = new DecreaseDef(6, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Decreases Attack and Defense to all enemies [6 turns]";
		Skill Asteriod_Ultimate = new UltimateSkill("Chaos Labyrinthos", description, SubSkills, false, false, false);
		Asteriod_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Asteriod_FirstSkill, Asteriod_SecondSkill, Asteriod_ThirdSkill,
				Asteriod_Ultimate };
		AllyUnit Asteriod = new AllyUnit("Asterios", "Berserker", stats, skills, statsFactors, skillRequirement);
		Asteriod.setUrl("AllyUnit/Asterios.png");
		Asteriod.setIconUrl("AllyUnit/Icon/Asterios_Icon.png");
		return Asteriod;
	}

	public static AllyUnit Edmond() {
		int[] stats = { 5579, 30, 1953, 10, 200, 15, 25 };
		int[] statsFactors = { 0, 10, 25, 25, 40 };
		int[] skillRequirement = { 1, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IgnoreDef(3);
		s2 = new IncreaseAttack(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Ignores defense and Increases own attack [3 turns]";
		Skill Edmond_FirstSkill = new NormalSkill("Determination of Steel", description, SubSkills, 6, true, false,
				false);
		Edmond_FirstSkill.setUrl("Skill/Ignoredef.png");
		
		s1 = new RemoveDebuff();
		s2 = new IncreaseUltiGauge(3, 6);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own Gauge every turn [3 turns] and Removes debuff";
		Skill Edmond_SecondSkill = new NormalSkill("Golden Rule", description, SubSkills, 6, true, true, false);
		Edmond_SecondSkill.setUrl("Skill/RemoveDebuff.png");
		
		s1 = new Damage(120, 1);
		s2 = new DecreaseUltiGauge(1);
		s3 = new DecreaseCritChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damages and decreases Gauge to one enemy";
		Skill Edmond_ThirdSkill = new NormalSkill("Wisdom from Desperation", description, SubSkills, 4, false, true,
				false);
		Edmond_ThirdSkill.setUrl("Skill/Damage.png");
		
		s1 = new Damage(50, 8);
		s2 = new DecreaseDef(3, 30);
		s3 = new DOTDamage(5, 500);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage to all enemies, decrease defense [3 turns] and inflicts DOT [5 turns]";
		Skill Edmond_Ultimate = new UltimateSkill("Enfer Chateau", description, SubSkills, false, false, false);
		Edmond_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Edmond_FirstSkill, Edmond_SecondSkill, Edmond_ThirdSkill, Edmond_Ultimate };
		AllyUnit Edmond = new AllyUnit("Edmond Dantes", "Berserker", stats, skills, statsFactors, skillRequirement);
		Edmond.setUrl("AllyUnit/Edmon.png");
		Edmond.setIconUrl("AllyUnit/Icon/Edmond_Icon.png");
		return Edmond;
	}

	public static AllyUnit Mysterious() {
		int[] stats = { 6237, 25, 1717, 10, 170, 10, 20 };
		int[] statsFactors = { 0, 10, 25, 25, 40 };
		int[] skillRequirement = { 1, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Heal(1, 30);
		s2 = new Evade(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Recovers own HP and grants self Evasion [1 turn]";
		Skill Mysterious_FirstSkill = new NormalSkill("Black Bean Paste", description, SubSkills, 5, true, false,
				false);
		Mysterious_FirstSkill.setUrl("Skill/Evade.png");
		
		s1 = new IncreaseCritChance(3, 20);
		s2 = new IncreaseCritDamage(3, 60);
		s3 = new IncreaseAttack(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own Attack, Crit chance and Crit damage [3 turns]";
		Skill Mysterious_SecondSkill = new NormalSkill("Instantaneous Shadowless Blade", description, SubSkills, 6,
				true, false, false);
		Mysterious_SecondSkill.setUrl("Skill/Critdmg.png");
		
		s1 = new IncreaseAttack(3, 20);
		s2 = new IncreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases Attack and Dodge chance [3 turns] to all allies";
		Skill Mysterious_ThirdSkill = new NormalSkill("Sovereign's Invisible Hand", description, SubSkills, 5, false,
				false, true);
		Mysterious_ThirdSkill.setUrl("Skill/Attack.png");
		
		s1 = new Damage(80, 12);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deals damage to one enemies";
		Skill Mysterious_Ultimate = new UltimateSkill("Cross-Calibur", description, SubSkills, false, true, false);
		Mysterious_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Mysterious_FirstSkill, Mysterious_SecondSkill, Mysterious_ThirdSkill,
				Mysterious_Ultimate };
		AllyUnit Mysterious = new AllyUnit("Mysterious HX", "Berserker", stats, skills, statsFactors,
				skillRequirement);
		Mysterious.setUrl("AllyUnit/Mysterious.png");
		Mysterious.setIconUrl("AllyUnit/Icon/Mysterious_Icon.png");
		return Mysterious;
	}
}
