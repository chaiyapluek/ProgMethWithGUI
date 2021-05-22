package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
import Unit.AdvanceUnit;

public class BossList {

	public static AdvanceUnit Mordred(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 40);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		String description = "";
		Skill skill1 = new NormalSkill("Mana Burst", description, SubSkills, 3, true, false, false);

		s1 = new Damage(80, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "";
		Skill skill2 = new NormalSkill("Cigarette Lion", description, SubSkills, 1, false, false, false);

		s1 = new IncreaseDef(3, 30);
		s2 = new IncreaseUltiGauge(1, 3);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill3 = new NormalSkill("Secret of Pedigree", description, SubSkills, 4, true, false, false);

		s1 = new Damage(50, 5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "";
		Skill ulti = new UltimateSkill("Clarent Blood Arthur", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, skill2, skill3, ulti };
		AdvanceUnit unit = new AdvanceUnit("Mordred", "Saber", stats, skills);
		unit.setUrl("EnemyUnit/Modred.png");

		return unit;
	}

	public static AdvanceUnit Ozymandias(int[] stats) {
		SubSkill s1, s2, s3;
		s1 = new IncreaseAttack(3, 20);
		s2 = new IncreaseCritDamage(3, 30);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Pharaoh of the Hot Sands", description, SubSkills, 3, true, false, false);

		s1 = new IncreaseAttack(3, 20);
		s2 = new IncreaseDef(3, 20);
		s3 = new Heal(1, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "";
		Skill skill2 = new NormalSkill("Imperial Privilege", description, SubSkills, 5, true, false, false);

		s1 = new IncreaseUltiGauge(1, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "";
		Skill skill3 = new NormalSkill("Protection from Ra", description, SubSkills, 3, true, false, false);

		s1 = new Damage(70, 5);
		s2 = new DecreaseUltiGauge(5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill ulti = new UltimateSkill("Ramesseum Tentyris", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, skill2, skill3, ulti };
		AdvanceUnit unit = new AdvanceUnit("Ozymandias", "Berserker", stats, skills);
		unit.setUrl("EnemyUnit/Ozy_Sprite.png");

		return unit;
	}

	public static AdvanceUnit TomoeGozen(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 40);
		s2 = new IncreaseMaxHP(5, 5000);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Demonic Nature of Oni", description, SubSkills, 3, true, false, false);

		s1 = new IncreaseCritChance(3, 20);
		s2 = new IncreaseCritDamage(3, 70);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill2 = new NormalSkill("Knowledge of Chaotic Battle", description, SubSkills, 3, true, false, false);

		s1 = new Damage(120, 1);
		s2 = new DecreaseDef(2, 50);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill3 = new NormalSkill("Adrenaline Rush", description, SubSkills, 2, false, true, false);

		s1 = new Damage(70, 5);
		s2 = new DOTDamage(5, 2000);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill ulti = new UltimateSkill("On Arorikya Sowaka", description, SubSkills, false, true, false);

		Skill[] skills = new Skill[] { skill1, skill2, skill3, ulti };
		AdvanceUnit unit = new AdvanceUnit("Tomoe Gozen", "Lancer", stats, skills);
		unit.setUrl("EnemyUnit/TomoeGozenSprite.png");

		return unit;
	}

	public static AdvanceUnit Napoleon(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseAttack(3, 40);
		s2 = new IgnoreDef(3);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("Triumphant Charisma", description, SubSkills, 3, true, false, false);

		s1 = new Damage(70, 2);
		s2 = new DecreaseCritChance(3, 20);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill2 = new NormalSkill("Fire Support", description, SubSkills, 3, false, false, false);

		s1 = new IncreaseUltiGauge(3, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill3 = new NormalSkill("Light of Possibilities Rush", description, SubSkills, 4, true, true, false);

		s1 = new Damage(50, 5);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill ulti = new UltimateSkill("Arc de Triomphe de l'Etoile", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, skill2, skill3, ulti };
		AdvanceUnit unit = new AdvanceUnit("Napoleon", "Archer", stats, skills);
		unit.setUrl("EnemyUnit/NapoleonSprite.png");

		return unit;
	}

	public static AdvanceUnit Nobunaga(int[] stats) {
		SubSkill s1, s2, s3;
		s1 = new IncreaseAttack(3, 40);
		s2 = new SureHit(3);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "";
		Skill skill1 = new NormalSkill("It's Inevitable", description, SubSkills, 3, true, false, false);

		s1 = new Evade(1);
		s2 = new RemoveDebuff();
		s3 = new IncreaseDef(3, 30);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2, s3));
		description = "";
		Skill skill2 = new NormalSkill("As if it Was a Dream", description, SubSkills, 3, true, false, false);

		s1 = new IncreaseUltiGauge(1, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill skill3 = new NormalSkill("Demon King of the Sixth Heaven", description, SubSkills, 1, true, true, false);

		s1 = new Damage(50, 6);
		s2 = new DOTDamage(5, 1000);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		description = "";
		Skill ulti = new UltimateSkill("Hajunhenjou", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, skill2, skill3, ulti };
		AdvanceUnit unit = new AdvanceUnit("Demon King", "???", stats, skills);
		unit.setUrl("EnemyUnit/Avenger_Nobu.png");

		return unit;
	}

}
