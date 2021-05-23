package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.*;
import SubSkill.*;
import Unit.AllyUnit;

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
		units.add(Ereshkigal());
		units.add(Jaguar());
		return units;
	}

	public static AllyUnit Enkidu() {
		int[] stats = { 6754, 25, 1582, 15, 185, 15, 18 };
		int[] statsFactors = { 0, 20, 25, 10, 45 };
		int[] skillRequirement = { 1, 2, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(2, 15);
		s2 = new IncreaseCritChance(2, 15);
		s3 = new IncreaseCritDamage(2, 60);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase attack, crit chance and crit damage to yourself [2 turns]";
		Skill Enkidu_FirstSkill = new NormalSkill("Transfiguration", description, SubSkills, 5, true, false, false);
		Enkidu_FirstSkill.setUrl("Skill/Attack.png");
		
		s1 = new Evade(3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Grants self Evasion[2 turns]";
		Skill Enkidu_SecondSkill = new NormalSkill("Presence Detection", description, SubSkills, 6, true, false, false);
		Enkidu_SecondSkill.setUrl("Skill/Evade.png");
		
		s1 = new Heal(0, 60);
		s2 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Recovers own HP and Remove own debuff";
		Skill Enkidu_ThirdSkill = new NormalSkill("Consummated Shape", description, SubSkills, 8, true, false, false);
		Enkidu_ThirdSkill.setUrl("Skill/Heal.png");
		
		s1 = new DecreaseDef(3, 15);
		s2 = new Stun(1);
		s3 = new Damage(200, 5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage to one enemy and Stun enemy [1 turn] and reduce enemy defense [3 turns]";
		Skill Enkidu_Ultimate = new UltimateSkill("Enuma Elis", description, SubSkills, false, true, false);
		Enkidu_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Enkidu_FirstSkill, Enkidu_SecondSkill, Enkidu_ThirdSkill, Enkidu_Ultimate };
		AllyUnit Enkidu = new AllyUnit("Enkidu", "Lancer", stats, skills, statsFactors, skillRequirement);
		Enkidu.setUrl("AllyUnit/Enkidu.png");
		Enkidu.setIconUrl("AllyUnit/Icon/Enkidu_Icon.png");
		return Enkidu;
	}

	public static AllyUnit Karna() {
		int[] stats = { 4952, 30, 2139, 10, 230, 20, 25 };
		int[] statsFactors = { 0, 25, 25, 25, 25 };
		int[] skillRequirement = { 1, 3, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Stun(1);
		s2 = new DecreaseDef(3, 10);
		s3 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Stun all enemies [1 turn] and reduces enemies's defense and dodge chance [3 turns]";
		Skill Karna_FirstSkill = new NormalSkill("Knowledge of the Deprived", description, SubSkills, 6, false, false,
				false);
		Karna_FirstSkill.setUrl("Skill/Stun.png");
		
		s1 = new IncreaseAttack(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases own attack[3 turns]";
		Skill Karna_SecondSkill = new NormalSkill("Mana Burst", description, SubSkills, 5, true, false, false);
		Karna_SecondSkill.setUrl("Skill/Burst.png");
		
		s1 = new IncreaseUltiGauge(0, 15);
		s2 = new IncreaseCritChance(3, 10);
		s3 = new IncreaseCritDamage(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own Gauge and increases own crit chance and crit damage [3 turns]";
		Skill Karna_ThirdSkill = new NormalSkill("Uncrowned Arms Mastery", description, SubSkills, 6, true, false,
				false);
		Karna_ThirdSkill.setUrl("Skill/Gauge.png");
		
		s1 = new Damage(150, 4);
		s2 = new DecreaseAttack(3, 15);
		s3 = new DOTDamage(3, 700);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage to all enemies, inflicts DOT damage and decrease their attack [3 turns]";
		Skill Karna_Ultimate = new UltimateSkill("Vasavi Shakti", description, SubSkills, false, false, false);
		Karna_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Karna_FirstSkill, Karna_SecondSkill, Karna_ThirdSkill, Karna_Ultimate };
		AllyUnit Karna = new AllyUnit("Karna", "Lancer", stats, skills, statsFactors, skillRequirement);
		Karna.setUrl("AllyUnit/Karna.png");
		Karna.setIconUrl("AllyUnit/Icon/Karna_Icon.png");
		return Karna;
	}

	public static AllyUnit Leonidas() {
		int[] stats = { 7546, 35, 942, 5, 250, 10, 18 };
		int[] statsFactors = { 0, 30, 20, 30, 20 };
		int[] skillRequirement = { 1, 3, 3 };
		SubSkill s1, s2;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Taunt(2);
		s2 = new IncreaseUltiGauge(3, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Applies Taunt [1 turn] and generate Gauge [3 turns] to yourself";
		Skill Leonidas_FirstSkill = new NormalSkill("Pride of the Rearguard", description, SubSkills, 6, true, false,
				false);
		Leonidas_FirstSkill.setUrl("Skill/Taunt.png");
		
		s1 = new Heal(3, 15);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Recovers HP every turn [3 turns]";
		Skill Leonidas_SecondSkill = new NormalSkill("Battle Continuation", description, SubSkills, 5, true, false,
				false);
		Leonidas_SecondSkill.setUrl("Skill/Heal.png");
		
		s1 = new IncreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increases defense to all allies [3 turns]";
		Skill Leonidas_ThirdSkill = new NormalSkill("War cry", description, SubSkills, 7, false, false, true);
		Leonidas_ThirdSkill.setUrl("Skill/Def.png");
		
		s1 = new Taunt(4);
		s2 = new IncreaseDef(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own defense [3 turns] and applies Taunt to yourself [3 turns]";
		Skill Leonidas_Ultimate = new UltimateSkill("Thermopylae Enomotia", description, SubSkills, true, false, false);
		Leonidas_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Leonidas_FirstSkill, Leonidas_SecondSkill, Leonidas_ThirdSkill,
				Leonidas_Ultimate };
		AllyUnit Leonidas = new AllyUnit("Leonidas", "Lancer", stats, skills, statsFactors, skillRequirement);
		Leonidas.setUrl("AllyUnit/Leonidas.png");
		Leonidas.setIconUrl("AllyUnit/Icon/Leonidas_Icon.png");
		return Leonidas;
	}

	public static AllyUnit Ereshkigal() {
		int[] stats = { 7068, 25, 1598, 5, 250, 10, 25 };
		int[] statsFactors = { 0, 30, 20, 20, 30 };
		int[] skillRequirement = { 2, 3, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseDodgeChance(3, 30);
		s2 = new RemoveDebuff();
		s3 = new IncreaseDef(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own dodge chance and defense [3 turns] and removes debuff";
		Skill Ereshkigal_FirstSkill = new NormalSkill("The Secret Great Crown", description, SubSkills, 6, true, false,
				false);
		Ereshkigal_FirstSkill.setUrl("Skill/RemoveDebuff.png");
		
		s1 = new IncreaseAttack(3, 50);
		s2 = new IncreaseUltiGauge(0, 12);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own attack [3 turns] and increases Gauge";
		Skill Ereshkigal_SecondSkill = new NormalSkill("Mana Burst (Cage)", description, SubSkills, 6, true, false,
				false);
		Ereshkigal_SecondSkill.setUrl("Skill/Burst.png");
		
		s1 = new IncreaseDef(3, 20);
		s2 = new IncreaseUltiGauge(3, 4);
		s3 = new IncreaseMaxHP(3, 3000);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases defense and max HP to all allies [3 turns] and increases Gauge every turns [3 turns]";
		Skill Ereshkigal_ThirdSkill = new NormalSkill("Blessing of Kur", description, SubSkills, 7, false, false, true);
		Ereshkigal_ThirdSkill.setUrl("Skill/Blessing.png");
		
		s1 = new Damage(100, 4);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to all enemies";
		Skill Ereshkigal_Ultimate = new UltimateSkill("Kur Ki Gal Irkalla", description, SubSkills, false, false,
				false);
		Ereshkigal_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Ereshkigal_FirstSkill, Ereshkigal_SecondSkill, Ereshkigal_ThirdSkill,
				Ereshkigal_Ultimate };
		AllyUnit Ereshkigal = new AllyUnit("Ereshkigal", "Lancer", stats, skills, statsFactors,
				skillRequirement);
		Ereshkigal.setUrl("AllyUnit/Ereshkigal.png");
		Ereshkigal.setIconUrl("AllyUnit/Icon/Ereshkigal_Icon.png");
		return Ereshkigal;
	}
	
	public static AllyUnit Jaguar() {
		int[] stats = { 6904, 15, 1304, 10, 195, 20, 20 };
		int[] statsFactors = { 0, 20, 25, 20, 35 };
		int[] skillRequirement = { 1, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Damage(150,1);
		s2 = new DecreaseCritChance(2,20);
		s3 = new DecreaseCritDamage(2,80);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage to one enemy, decreases crit chance and crit damage [2 turns]";
		Skill Jaguar_FirstSkill = new NormalSkill("Jaguar Punch", description, SubSkills, 3, false, true, false);
		Jaguar_FirstSkill.setUrl("Skill/Damage.png");
		
		s1 = new Damage(150,1);
		s2 = new DecreaseDef(2,20);
		s3 = new DecreaseAttack(2,20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2,s3));
		description = "Deals damage to one enemy, decreases attack and defense [2 turns]";
		Skill Jaguar_SecondSkill = new NormalSkill("Jaguar Kick", description, SubSkills, 3, false, true, false);
		Jaguar_SecondSkill.setUrl("Skill/Damage.png");
		
		s1 = new Taunt(2);
		s2 = new Heal(3,10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Applies taunt to your self [1 turn] and recovers HP every turn [3 turns]";
		Skill Jaguar_ThirdSkill = new NormalSkill("Jaguar Provoke", description, SubSkills, 6, true, false, false);
		Jaguar_ThirdSkill.setUrl("Skill/Taunt.png");
		
		s1 = new Stun(1);
		s2 = new Damage(400, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage to one enemy and Stun enemy[1 turn]";
		Skill Jaguar_Ultimate = new UltimateSkill("Great Death Claw", description, SubSkills, false, true, false);
		Jaguar_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Jaguar_FirstSkill, Jaguar_SecondSkill, Jaguar_ThirdSkill, Jaguar_Ultimate };
		AllyUnit Jaguar = new AllyUnit("Jaguar Man", "Lancer", stats, skills, statsFactors, skillRequirement);
		Jaguar.setUrl("AllyUnit/Jaguar.png");
		Jaguar.setIconUrl("AllyUnit/Icon/Jaguar_Icon.png");
		return Jaguar;
	}
}
