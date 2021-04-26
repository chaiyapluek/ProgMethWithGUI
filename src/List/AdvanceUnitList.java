package List;

import java.util.ArrayList;
import java.util.Arrays;

import Skill.NormalSkill;
import Skill.Skill;
import Skill.UltimateSkill;
import SubSkill.*;
import UnitBase.AdvanceUnit;

public class AdvanceUnitList {

	public static AdvanceUnit MechaBore(int[] stats) {
		SubSkill s1, s2;
		s1 = new IncreaseUltiGauge(1, 1);
		s2 = new IncreaseCritChance(3, 10);
		ArrayList<SubSkill> SubSkills;
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1, s2));
		String description = "Increases own Gauge by 1 and Increases own critical attack chance [3 turns]";
		Skill skill1 = new NormalSkill("High Voltage", description, SubSkills, 2, true, false, false);

		s1 = new Damage(80, 2);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deals damage to all enemies";
		Skill skill2 = new NormalSkill("High Voltage", description, SubSkills, 1, false, false, false);

		s1 = new Damage(400, 1);
		SubSkills = new ArrayList<SubSkill>(Arrays.asList(s1));
		description = "Deals damage to all enemies.";
		Skill ulti = new UltimateSkill("High Voltage", description, SubSkills, false, false, false);

		Skill[] skills = new Skill[] { skill1, skill2, ulti };
		AdvanceUnit unit = new AdvanceUnit("Mecha Demon Boar", "Berserker", stats, skills);
		unit.setUrl("EnemyUnit/Mecha_Demon_Boar.png");

		return unit;
	}

}
