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
		units.add(Elmelloid());
		units.add(Gilgamesh());
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
		description = "Increase defense [1 turn] and recovers own HP";
		Skill David_FirstSkill = new NormalSkill("Divine Protection of God", description, SubSkills, 5, true, false,
				false);
		David_FirstSkill.setUrl("Skill/Def.png");

		s1 = new Evade(1);
		s2 = new Heal(1, 10);
		s3 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Applies Evade, Recovers HP and Remove debuff to all allies";
		Skill David_SecondSkill = new NormalSkill("Harp of Healing", description, SubSkills, 6, false, false, true);
		David_SecondSkill.setUrl("Skill/Evade.png");

		s1 = new IncreaseAttack(3, 18);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack [3 turns] to all allies";
		Skill David_ThirdSkill = new NormalSkill("Charisma", description, SubSkills, 5, false, false, true);
		David_ThirdSkill.setUrl("Skill/Attack.png");

		s1 = new DecreaseDodgeChance(1, 50);
		s2 = new Damage(1100, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Decrease Dodge chance and Deal damage to one enemy";
		Skill David_Ultimate = new UltimateSkill("Hamesh Avanim", description, SubSkills, false, true, false);
		David_Ultimate.setUrl("Skill/NP.png");

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
		description = "Removes own debuff and increase crit chance [3 turns]";
		Skill Arjuna_FirstSkill = new NormalSkill("Clairvoyance", description, SubSkills, 5, true, false, false);
		Arjuna_FirstSkill.setUrl("Skill/Critchance.png");

		s1 = new IncreaseUltiGauge(0, 5);
		s2 = new IncreaseUltiGauge(5, 3);
		s3 = new Heal(5, 6);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase Gauge, Generates Gauge [5 turns] and Recovers HP every turn [5 turns]";
		Skill Arjuna_SecondSkill = new NormalSkill("Hero of the Endowed", description, SubSkills, 8, true, false,
				false);
		Arjuna_SecondSkill.setUrl("Skill/Gauge.png");

		s1 = new Damage(50, 3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to all enemies";
		Skill Arjuna_ThirdSkill = new NormalSkill("Divinity", description, SubSkills, 5, false, false, false);
		Arjuna_ThirdSkill.setUrl("Skill/Damage.png");

		s1 = new Damage(100, 6);
		s2 = new DecreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage to all enemies and decrease their defense [3 turns]";
		Skill Arjuna_Ultimate = new UltimateSkill("Pashupata", description, SubSkills, false, false, false);
		Arjuna_Ultimate.setUrl("Skill/NP.png");

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

		s1 = new IncreaseCritDamage(3, 50);
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases crit chance and crit damage [3 turns]";
		Skill Billy_FirstSkill = new NormalSkill("Marksmanship", description, SubSkills, 5, true, false, false);
		Billy_FirstSkill.setUrl("Skill/Critdmg.png");
		
		s1 = new Damage(25, 6);
		s2 = new Stun(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deal damage and Inflicts Stun to one enemy [1 turn]";
		Skill Billy_SecondSkill = new NormalSkill("Quick Draw", description, SubSkills, 3, false, true, false);
		Billy_SecondSkill.setUrl("Skill/Damage.png");
		
		s1 = new Evade(1);
		s2 = new IncreaseCritDamage(3, 80);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Applies Evade to yourself[1 turn] and increase crit damage [3 turns]";
		Skill Billy_ThirdSkill = new NormalSkill("Eye of the Mind", description, SubSkills, 6, true, false, false);
		Billy_ThirdSkill.setUrl("Skill/Evade.png");
		
		s1 = new DecreaseDodgeChance(1, 100);
		s2 = new Damage(1500, 1);
		s3 = new DecreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deals damage and decrease crit chance [3 turns] to one enemy";
		Skill Billy_Ultimate = new UltimateSkill("Pashupata", description, SubSkills, false, true, false);
		Billy_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Billy_FirstSkill, Billy_SecondSkill, Billy_ThirdSkill, Billy_Ultimate };
		AllyUnit Billy = new AllyUnit("Billy The Kid", "Archer", stats, skills, statsFactors, skillRequirement);
		Billy.setUrl("AllyUnit/Billy.png");
		Billy.setIconUrl("AllyUnit/Icon/Billy_Icon.png");
		return Billy;
	}

	public static AllyUnit Elmelloid() {
		int[] stats = { 6273, 20, 1037, 5, 200, 15, 20 };
		int[] statsFactors = { 0, 40, 25, 25, 10 };
		int[] skillRequirement = { 2, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseCritChance(3, 20);
		s2 = new IncreaseUltiGauge(0, 15);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase one ally Gauge and crit chance [3 turns]";
		Skill Elmelloid_FirstSkill = new NormalSkill("Discerning Eye", description, SubSkills, 5, false, true, true);
		Elmelloid_FirstSkill.setUrl("Skill/Critchance.png");
		
		s1 = new IncreaseDef(3, 30);
		s2 = new IncreaseUltiGauge(0, 8);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases defense [3 turns] and increases Gauge to all allies";
		Skill Elmelloid_SecondSkill = new NormalSkill("Advice of the Strategist", description, SubSkills, 6, false,
				false, true);
		Elmelloid_SecondSkill.setUrl("Skill/Def.png");
		
		s1 = new IncreaseAttack(3, 30);
		s2 = new IncreaseUltiGauge(0, 8);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases attack [3 turns] and increases Gauge to all allies";
		Skill Elmelloid_ThirdSkill = new NormalSkill("Command of the Strategist", description, SubSkills, 6, false,
				false, true);
		Elmelloid_ThirdSkill.setUrl("Skill/Attack.png");

		s1 = new DecreaseUltiGauge(1);
		s2 = new Stun(1);
		s3 = new DecreaseDef(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Decrease enemy's Gauge, stun [1 turn] and Decrease all enemies's defense [3 turns]";
		Skill Elmelloid_Ultimate = new UltimateSkill("Unreturning Formation", description, SubSkills, false, false,
				false);
		Elmelloid_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Elmelloid_FirstSkill, Elmelloid_SecondSkill, Elmelloid_ThirdSkill,
				Elmelloid_Ultimate };
		AllyUnit Elmelloid = new AllyUnit("Lord El-Melloi II", "Archer", stats, skills, statsFactors, skillRequirement);
		Elmelloid.setUrl("AllyUnit/ElMelloi.png");
		Elmelloid.setIconUrl("AllyUnit/Icon/ElMelloi_Icon.png");
		return Elmelloid;
	}

	public static AllyUnit Gilgamesh() {
		int[] stats = { 5760, 20, 1897, 10, 200, 10, 25 };
		int[] statsFactors = { 0, 40, 25, 25, 10 };
		int[] skillRequirement = { 2, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 21);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack [3 turns] to all allies";
		Skill Gilgamesh_FirstSkill = new NormalSkill("Charisma", description, SubSkills, 5, false, false, true);
		Gilgamesh_FirstSkill.setUrl("Skill/Attack.png");
		
		s1 = new IncreaseUltiGauge(3, 5);
		s2 = new Heal(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases Gauge and recovers HP every turn [3 turns]";
		Skill Gilgamesh_SecondSkill = new NormalSkill("Golden Rule", description, SubSkills, 5, true, false, false);
		Gilgamesh_SecondSkill.setUrl("Skill/Gauge.png");
		
		s1 = new IncreaseAttack(3, 30);
		s2 = new IncreaseUltiGauge(0, 10);
		s3 = new IncreaseDodgeChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own attack and dodge chance [3 turns] and Increases Gauge";
		Skill Gilgamesh_ThirdSkill = new NormalSkill("Treasury of Babylon", description, SubSkills, 6, true, false,
				false);
		Gilgamesh_ThirdSkill.setUrl("Skill/Burst.png");
		
		s1 = new DecreaseDodgeChance(1, 100);
		s2 = new Damage(600, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage to all enemies";
		Skill Gilgamesh_Ultimate = new UltimateSkill("Enuma Elis", description, SubSkills, false, false, false);
		Gilgamesh_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Gilgamesh_FirstSkill, Gilgamesh_SecondSkill, Gilgamesh_ThirdSkill,
				Gilgamesh_Ultimate };
		AllyUnit Gilgamesh = new AllyUnit("Gilgamesh", "Archer", stats, skills, statsFactors, skillRequirement);
		Gilgamesh.setUrl("AllyUnit/Gilgamesh.png");
		Gilgamesh.setIconUrl("AllyUnit/Icon/Gilgamesh_Icon.png");
		return Gilgamesh;
	}
}
