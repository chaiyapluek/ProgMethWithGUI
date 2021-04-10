package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.*;
import SubSkill.*;
import UnitBase.AllyUnit;

public class AllyUnitList_Archer {

	public static ArrayList<AllyUnit> getAllUnits() {
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		units.add(David());
		units.add(Arjuna());
		units.add(Billy());
		return units;
	}
	
	public static AllyUnit David() {
		int[] stats = { 6370, 20, 1210, 15, 180, 20, 20 };
		int[] statsFactors = { 0, 25, 10, 25, 40 };
		int[] skillRequirement = { 1, 2, 2 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseDef(1, 50);
		s2 = new Heal(1, 15);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase defense[1 turn] and recovers own HP";
		Skill David_FirstSkill = new NormalSkill("Divine Protection of God", description, SubSkills, 5, true, false,
				false);

		s1 = new Evade(1);
		s2 = new Heal(1, 10);
		s3 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Applies Evade, Recovers HP and Remove debuff to all allies";
		Skill David_SecondSkill = new NormalSkill("Harp of Healing", description, SubSkills, 6, false, false, true);

		s1 = new IncreaseAttack(3, 18);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack[3 turns] to all allies";
		Skill David_ThirdSkill = new NormalSkill("Charisma", description, SubSkills, 5, false, false, true);

		s1 = new DecreaseDodgeChance(1,50);
		s2 = new Damage(1100, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Decrease Dodge chance and Deal damage to one enemy";
		Skill David_Ultimate = new UltimateSkill("Hamesh Avanim", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { David_FirstSkill, David_SecondSkill, David_ThirdSkill, David_Ultimate };
		AllyUnit David = new AllyUnit("David", "Archer", stats, skills, statsFactors, skillRequirement);
		David.setUrl("AllyUnit/David.png");
		David.setIconUrl("AllyUnit/Icon/David_Icon.png");
		return David;
	}

	public static AllyUnit Arjuna() {
		int[] stats = { 5020, 30, 2045, 10, 225, 20, 25 };
		int[] statsFactors = { 0, 25, 25, 25, 25 };
		int[] skillRequirement = { 1, 3, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new RemoveDebuff();
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Removes own debuff and increase crit chance[3 turns]";
		Skill Arjuna_FirstSkill = new NormalSkill("Clairvoyance", description, SubSkills, 5, true, false, false);

		s1 = new IncreaseUltiGauge(0, 5);
		s2 = new IncreaseUltiGauge(5, 3);
		s3 = new Heal(5, 6);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase Gauge, Generates Gauge[5 turns] and Recovers HP every turn[5 turns]";
		Skill Arjuna_SecondSkill = new NormalSkill("Hero of the Endowed", description, SubSkills, 8, true, false, false);

		s1 = new Damage(50,3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to all enemies";
		Skill Arjuna_ThirdSkill = new NormalSkill("Divinity", description, SubSkills, 5, false, false, false);

		s1 = new Damage(100, 6);
		s2 = new DecreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage to all enemies and decrease their defense[3 turns]";
		Skill Arjuna_Ultimate = new UltimateSkill("Pashupata", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { Arjuna_FirstSkill, Arjuna_SecondSkill, Arjuna_ThirdSkill, Arjuna_Ultimate };
		AllyUnit Arjuna = new AllyUnit("Arjuna", "Archer", stats, skills, statsFactors, skillRequirement);
		Arjuna.setUrl("AllyUnit/Arjuna.png");
		Arjuna.setIconUrl("AllyUnit/Icon/Arjuna_Icon.png");
		return Arjuna;
	}

	public static AllyUnit Billy() {
		int[] stats = { 5870, 20, 1365, 15, 150, 20, 20 };
		int[] statsFactors = { 0, 10, 20, 30, 40 };
		int[] skillRequirement = { 1, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new RemoveDebuff();
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Removes own debuff and increase crit chance[3 turns]";
		Skill Billy_FirstSkill = new NormalSkill("Clairvoyance", description, SubSkills, 5, true, false, false);

		s1 = new Damage(25, 6);
		s2 = new Stun(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deal damage and Inflicts Stun to one enemy[1 turn]";
		Skill Billy_SecondSkill = new NormalSkill("Quick Draw", description, SubSkills, 3, false, true, false);

		s1 = new Evade(1);
		s2 = new IncreaseCritDamage(3,80);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2));
		description = "Applies Evade to yourself[1 turn] and increase crit damage[3 turns]";
		Skill Billy_ThirdSkill = new NormalSkill("Eye of the Mind", description, SubSkills, 6, true, false, false);

		s1 = new Damage(1500, 1);
		s2 = new DecreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage and decrease crit chance[3 turns] to one enemy";
		Skill Billy_Ultimate = new UltimateSkill("Pashupata", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { Billy_FirstSkill, Billy_SecondSkill, Billy_ThirdSkill, Billy_Ultimate };
		AllyUnit Billy = new AllyUnit("Billy The Kid",  "Archer", stats, skills, statsFactors, skillRequirement);
		Billy.setUrl("AllyUnit/Billy.png");
		Billy.setIconUrl("AllyUnit/Icon/Billy_Icon.png");
		return Billy;
	}
}
