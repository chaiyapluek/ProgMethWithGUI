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
		units.add(Sigurd());
		units.add(Lancelot());
		units.add(Artoria());
		units.add(Muramasa());
		units.add(Musashi());
		return units;
	}

	public static AllyUnit Sigurd() {
		int[] stats = { 6147, 30, 1126, 10, 180, 10, 20 };
		int[] statsFactors = { 0, 20, 30, 10, 40 };
		int[] skillRequirement = { 1, 1, 3 };
		SubSkill s1, s2;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new DecreaseDef(1, 10);
		s2 = new Damage(70, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Decrease defense and deal damage to one enemy";
		Skill Sigurd_FirstSkill = new NormalSkill("Dragon Slayer", description, SubSkills, 3, false, true, false);
		Sigurd_FirstSkill.setUrl("Skill/Damage.png");
		
		s1 = new Heal(0, 10);
		s2 = new RemoveDebuff();
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Recovers own HP and removes own debuffs";
		Skill Sigurd_SecondSkill = new NormalSkill("Disengage", description, SubSkills, 4, true, false, false);
		Sigurd_SecondSkill.setUrl("Skill/RemoveDebuff.png");
		
		s1 = new IncreaseUltiGauge(0, 10);
		s2 = new IncreaseDef(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own gauge and defense [3 turns]";
		Skill Sigurd_ThirdSkill = new NormalSkill("Unbreakable Will", description, SubSkills, 6, true, false, false);
		Sigurd_ThirdSkill.setUrl("Skill/Gauge.png");
		
		s1 = new Damage(100, 8);
		s2 = new DecreaseUltiGauge(1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deals damage and decrease 1 guage to one enemy";
		Skill Sigurd_Ultimate = new UltimateSkill("Bolverk Gram", description, SubSkills, false, true, false);
		Sigurd_Ultimate.setUrl("Skill/NP.png");

		Skill[] skills = new Skill[] { Sigurd_FirstSkill, Sigurd_SecondSkill, Sigurd_ThirdSkill, Sigurd_Ultimate };
		AllyUnit Sigurd = new AllyUnit("Sigurd", "Saber", stats, skills, statsFactors, skillRequirement);
		Sigurd.setUrl("AllyUnit/Sigurd.png");
		Sigurd.setIconUrl("AllyUnit/Icon/Sigurd_Icon.png");
		return Sigurd;
	}

	public static AllyUnit Lancelot() {
		int[] stats = { 5835, 33, 1281, 10, 200, 10, 18 };
		int[] statsFactors = { 0, 30, 25, 20, 25 };
		int[] skillRequirement = { 1, 2, 4 };
		SubSkill s1, s2;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseUltiGauge(0, 8);
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase Gauge, increase crit chance to yourself";
		Skill Lancelot_FirstSkill = new NormalSkill("Knight of the Lake", description, SubSkills, 5, true, false,
				false);
		Lancelot_FirstSkill.setUrl("Skill/Gauge.png");
		
		s1 = new IncreaseAttack(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack to all ally";
		Skill Lancelot_SecondSkill = new NormalSkill("Charisma", description, SubSkills, 6, false, false, true);
		Lancelot_SecondSkill.setUrl("Skill/Attack.png");
		
		s1 = new IncreaseCritDamage(3, 50);
		s2 = new IncreaseCritChance(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase crit chance and crit damage [3 turns] to all ally";
		Skill Lancelot_ThirdSkill = new NormalSkill("Eternal Arms Mastery", description, SubSkills, 6, false, false,
				true);
		Lancelot_ThirdSkill.setUrl("Skill/Critdmg.png");

		s1 = new Damage(1100, 1);
		s2 = new DecreaseDef(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Deal heavy damage to one enemy and decrease enemy's defense [3 turns]";
		Skill Lancelot_Ultimate = new UltimateSkill("Arondight Overload", description, SubSkills, false, true, false);
		Lancelot_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Lancelot_FirstSkill, Lancelot_SecondSkill, Lancelot_ThirdSkill,
				Lancelot_Ultimate };

		AllyUnit Lancelot = new AllyUnit("Lancelot", "Saber", stats, skills, statsFactors, skillRequirement);
		Lancelot.setUrl("AllyUnit/Lancelot.png");
		Lancelot.setIconUrl("AllyUnit/Icon/Lancelot_Icon.png");
		return Lancelot;
	}

	public static AllyUnit Artoria() {
		int[] stats = { 6796, 25, 1532, 20, 180, 15, 25 };
		int[] statsFactors = { 0, 20, 40, 30, 10 };
		int[] skillRequirement = { 1, 2, 4 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 18);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Increase attack to all ally";
		Skill Artoria_FirstSkill = new NormalSkill("Charisma", description, SubSkills, 6, false, false, true);
		Artoria_FirstSkill.setUrl("Skill/Attack.png");
		
		s1 = new IncreaseCritChance(4, 25);
		s2 = new IncreaseCritDamage(4, 75);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own crit chance and crit damage [4 turns]";
		Skill Artoria_SecondSkill = new NormalSkill("Instinct", description, SubSkills, 5, true, false, false);
		Artoria_SecondSkill.setUrl("Skill/Critchance.png");
		
		s1 = new IncreaseAttack(4, 150);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "significantly increases own attack [4 turns]";
		Skill Artoria_ThirdSkill = new NormalSkill("Reactor Core", description, SubSkills, 6, true, false, false);
		Artoria_ThirdSkill.setUrl("Skill/Burst.png");
		
		s1 = new Damage(100, 6);
		s2 = new DecreaseAttack(3, 10);
		s3 = new DecreaseDodgeChance(3, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Deal damage , decrease attack and dodge chance [3 turns] to all enemies";
		Skill Artoria_Ultimate = new UltimateSkill("Excalibur", description, SubSkills, false, false, false);
		Artoria_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Artoria_FirstSkill, Artoria_SecondSkill, Artoria_ThirdSkill, Artoria_Ultimate };

		AllyUnit Artoria = new AllyUnit("Artoria", "Saber", stats, skills, statsFactors, skillRequirement);
		Artoria.setUrl("AllyUnit/Artoria.png");
		Artoria.setIconUrl("AllyUnit/Icon/Artoria_Icon.png");
		return Artoria;
	}

	public static AllyUnit Muramasa() {
		int[] stats = { 6459, 20, 1757, 10, 150, 10, 25 };
		int[] statsFactors = { 0, 20, 40, 30, 10 };
		int[] skillRequirement = { 1, 2, 3 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new IncreaseAttack(3, 18);
		s2 = new IncreaseCritChance(3, 20);
		s3 = new IncreaseCritDamage(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increase own attack, crit chance and crit damage [3 turns]";
		Skill Muramasa_FirstSkill = new NormalSkill("Tame-shimono", description, SubSkills, 5, true, false, false);
		Muramasa_FirstSkill.setUrl("Skill/Attack.png");
		
		s1 = new IgnoreDef(3);
		s2 = new SureHit(3);
		s3 = new IncreaseUltiGauge(0, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "Increases own gauge and Applies Ignore defense and Sure hit to yourself [3 turns]";
		Skill Muramasa_SecondSkill = new NormalSkill("Karmic Vision", description, SubSkills, 6, true, false, false);
		Muramasa_SecondSkill.setUrl("Skill/Ignoredef.png");
		
		s1 = new IncreaseUltiGauge(0, 10);
		s2 = new IncreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increase gauge and crit chance to all allies [3 turns]";
		Skill Muramasa_ThirdSkill = new NormalSkill("Blaze", description, SubSkills, 6, false, false, true);
		Muramasa_ThirdSkill.setUrl("Skill/Gauge.png");
		
		s1 = new Damage(100, 6);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to all enemies";
		Skill Muramasa_Ultimate = new UltimateSkill("Tsumukari Muramasa", description, SubSkills, false, false, false);
		Muramasa_Ultimate.setUrl("Skill/NP.png");
		
		Skill[] skills = new Skill[] { Muramasa_FirstSkill, Muramasa_SecondSkill, Muramasa_ThirdSkill,
				Muramasa_Ultimate };

		AllyUnit Muramasa = new AllyUnit("Senji Muramasa", "Saber", stats, skills, statsFactors, skillRequirement);
		Muramasa.setUrl("AllyUnit/Muramasa.png");
		Muramasa.setIconUrl("AllyUnit/Icon/Muramasa_Icon.png");
		return Muramasa;
	}

	public static AllyUnit Musashi() {
		int[] stats = { 5997, 15, 1860, 15, 190, 15, 20 };
		int[] statsFactors = { 0, 25, 25, 25, 25 };
		int[] skillRequirement = { 1, 2, 2 };
		SubSkill s1, s2, s3;
		String description;
		ArrayList<SubSkill> SubSkills;

		s1 = new Damage(30, 3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to all enemies";
		Skill Musashi_FirstSkill = new NormalSkill("Fifth Form", description, SubSkills, 3, false, false, false);
		Musashi_FirstSkill.setUrl("Skill/Damage2.png");
		
		s1 = new IgnoreDef(3);
		s2 = new IncreaseAttack(3, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "Increases own attack and Applies Ignore defense [3 turns]";
		Skill Musashi_SecondSkill = new NormalSkill("Empyrean Eye", description, SubSkills, 5, true, false, false);
		Musashi_SecondSkill.setUrl("Skill/Ignoredef.png");
		
		s1 = new Evade(1);
		s2 = new RemoveDebuff();
		s3 = new Heal(0,18);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1,s2,s3));
		description = "Removes debuff and recovers own HP and applies Evade to yourself [1 turns]";
		Skill Musashi_ThirdSkill = new NormalSkill("Nothingness", description, SubSkills, 6, false, false, true);
		Musashi_ThirdSkill.setUrl("Skill/Evade.png");
		
		s1 = new Damage(100, 10);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deal damage to one enemy";
		Skill Musashi_Ultimate = new UltimateSkill("Rikudou Gorin - Kurikara Tenshou", description, SubSkills, false, true, false);
		Musashi_Ultimate.setUrl("Skill/NP.png");
		Skill[] skills = new Skill[] { Musashi_FirstSkill, Musashi_SecondSkill, Musashi_ThirdSkill,
				Musashi_Ultimate };

		AllyUnit Musashi = new AllyUnit("Musashi", "Saber", stats, skills, statsFactors, skillRequirement);
		Musashi.setUrl("AllyUnit/Musashi.png");
		Musashi.setIconUrl("AllyUnit/Icon/Musashi_Icon.png");
		return Musashi;
	}

}
