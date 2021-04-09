package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
import UnitBase.AllyUnit;

public class AllyUnitList_Saber {

	/*
	 * Stats = {HP , Def , Att , CritChance , CritDmg , DodgeChance , ultiGauge}
	 * Skill -> (name,des,subskills,cooldownTime,toYourself,isSingle,toAlly)
	 */

	public static ArrayList<AllyUnit> getAllUnits() {
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		units.add(SiegFried());
		units.add(Lancelot());
		units.add(Artoria());
		return units;
	}

	public static AllyUnit SiegFried() {
		int[] stats = { 7230, 30, 950, 10, 170, 10, 20 };
		int[] statsFactors = { 0, 20, 30, 10, 40 };
		int[] skillRequirement = { 1, 1, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new DecreaseDef(1, 10);
		s2 = new Damage(70, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Decrease defense and deal damage to one enemy";
		Skill Seigfried_FirstSkill = new NormalSkill("Dragon Slayer", description, SubSkills, 3, false, true, false);

		s1 = new Heal(0, 10);
		s2 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Recovers own HP and removes own debuffs";
		Skill Seigfried_SecondSkill = new NormalSkill("Disengage", description, SubSkills, 4, true, false, false);

		s1 = new IncreaseUltiGauge(0, 10);
		s2 = new IncreaseDef(3, 30);
		s3 = new DecreaseAttack(2, 15);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase gauge, greatly increase defense and decrease attack[Demerit]";
		Skill Seigfried_ThirdSkill = new NormalSkill("Unbreakable Will", description, SubSkills, 6, true, false, false);

		s1 = new Damage(500, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deals damage to all enemies";
		Skill Seigfried_Ultimate = new UltimateSkill("Balmung", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { Seigfried_FirstSkill, Seigfried_SecondSkill, Seigfried_ThirdSkill,
				Seigfried_Ultimate };
		AllyUnit Seigfried = new AllyUnit("Siegfried", "Saber", stats, skills, statsFactors, skillRequirement);
		Seigfried.setUrl("AllyUnit/Siegfried.png");
		return Seigfried;
	}

	public static AllyUnit Lancelot() {
		int[] stats = { 5835, 33, 1280, 10, 200, 10, 18 };
		int[] statsFactors = { 0, 30, 25, 20, 25 };
		int[] skillRequirement = { 1, 2, 4 };
		SubSkill s1, s2;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseUltiGauge(0, 6);
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase Gauge, increase crit chance to yourself";
		Skill Lancelot_FirstSkill = new NormalSkill("Knight of the Lake", description, SubSkills, 5, true, false,
				false);

		s1 = new IncreaseAttack(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack to all ally";
		Skill Lancelot_SecondSkill = new NormalSkill("Charisma", description, SubSkills, 6, false, false, true);

		s1 = new IncreaseCritDamage(3, 50);
		s2 = new IncreaseCritChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase crit chance and crit damage[3 turns] to all ally";
		Skill Lancelot_ThirdSkill = new NormalSkill("Eternal Arms Mastery", description, SubSkills, 6, false, false,
				true);

		s1 = new Damage(1100, 1);
		s2 = new DecreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deal heavy damage to one enemy and decrease enemy's defense[3 turns]";
		Skill Lancelot_Ultimate = new UltimateSkill("Arondight Overload", description, SubSkills, false, true, false);
		Skill[] skills = new Skill[] { Lancelot_FirstSkill, Lancelot_SecondSkill, Lancelot_ThirdSkill,
				Lancelot_Ultimate };

		AllyUnit Lancelot = new AllyUnit("Lancelot", "Saber", stats, skills, statsFactors, skillRequirement);
		Lancelot.setUrl("AllyUnit/Lancelot.png");
		return Lancelot;
	}

	public static AllyUnit Artoria() {
		int[] stats = { 6590, 25, 1530, 20, 180, 15, 25 };
		int[] statsFactors = { 0, 20, 40, 30, 10 };
		int[] skillRequirement = { 1, 3, 5 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 18);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack to all ally";
		Skill Artoria_FirstSkill = new NormalSkill("Charisma", description, SubSkills, 6, false, false, true);

		s1 = new IncreaseCritChance(4, 15);
		s2 = new IncreaseCritDamage(4, 75);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own crit chance and crit damage[4 turns]";
		Skill Artoria_SecondSkill = new NormalSkill("Instinct", description, SubSkills, 5, true, false, false);

		s1 = new IncreaseAttack(3, 150);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "significantly increases own attack[3 turns]";
		Skill Artoria_ThirdSkill = new NormalSkill("Reactor Core", description, SubSkills, 6, true, false, false);

		s1 = new Damage(600, 1);
		s2 = new DecreaseAttack(3, 10);
		s3 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deal damage , decrease attack and dodge chance[3 turns] to all enemies";
		Skill Artoria_Ultimate = new UltimateSkill("Excalibur", description, SubSkills, false, false, false);
		Skill[] skills = new Skill[] { Artoria_FirstSkill, Artoria_SecondSkill, Artoria_ThirdSkill, Artoria_Ultimate };

		AllyUnit Artoria = new AllyUnit("Artoria", "Saber", stats, skills, statsFactors, skillRequirement);
		Artoria.setUrl("AllyUnit/Artoria.png");
		return Artoria;
	}

}
