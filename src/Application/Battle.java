package Application;

import java.util.ArrayList;
import java.util.Scanner;

import Map.Stage;
import Skill.Effect;
import Skill.NormalSkill;
import Skill.Skill;
import SubSkill.DOTDamage;
import SubSkill.Heal;
import SubSkill.IncreaseUltiGauge;
import UnitBase.AdvanceUnit;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class Battle {

	
	public static void StartBattle(Player player, Bot enemy) {
//		for (int wave = 0; wave < stage.getNumberOfWave(); wave++) {
//			Bot enemy = new Bot(stage.getUnitAtWave(wave));
//			while (true) {
//				if( isEnd(player.getUnits()) || isEnd(enemy.getUnits()) ) {
//					break;
//				}
//				PlayerTurn(player,enemy);
//				EnemyTurn(player,enemy);
//			}
//		}
		while (true) {
			if( isEnd(player.getUnits()) || isEnd(enemy.getUnits()) ) {
				break;
			}
			PlayerTurn(player,enemy);
			EnemyTurn(player,enemy);
		}
	}

	public static void PlayerTurn(Player player,Bot enemy) {
		decreaseSkillCooldown(player.getUnits());
		player.play(enemy.getUnits());
		decreaseEffectDuration(player.getUnits());
		checkEffect(player.getUnits());
		increseUltiGauge(player.getUnits());
	}
	
	public static void EnemyTurn(Player player,Bot enemy) {
		decreaseSkillCooldown(enemy.getUnits());
		enemy.play(player.getUnits());
		decreaseEffectDuration(enemy.getUnits());
		checkEffect(enemy.getUnits());
		increseUltiGauge(enemy.getUnits());
	}
	
	public static void increseUltiGauge(Unit[] units) {
		for (int i = 0; i < units.length; i++) {
			if (units[i] == null)
				continue;
			if (units[i] instanceof AdvanceUnit) {
				AdvanceUnit unit = (AdvanceUnit) units[i];
				if (unit.getIsDead())
					continue;
				unit.setUltiGauge(unit.getUltiGauge() + 1);
			}
		}
	}
	
	public static void checkEffect(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			for (Effect e : ((UnitStats) u).getEffects()) {
				if (e.getSubSkill() instanceof Heal && e.getDuration() != (e.getSubSkill()).getDuration()) {
					Heal skill = (Heal) e.getSubSkill();
					skill.heal(u);
					System.out.println(u.getName() + " " + (int) (1.0 * ((UnitStats)u).getMaxHP() * skill.getHealAmount() / 100) + " HP up");
				} else if (e.getSubSkill() instanceof DOTDamage && e.getDuration() != (e.getSubSkill()).getDuration()) {
					DOTDamage dot = (DOTDamage) e.getSubSkill();
					dot.damaged(u);
				} else if (e.getSubSkill() instanceof IncreaseUltiGauge && e.getDuration() != (e.getSubSkill()).getDuration()) {
					IncreaseUltiGauge skill = (IncreaseUltiGauge) e.getSubSkill();
					skill.increaseGauge(u);
					System.out.println(u.getName() + " gauge up by " + skill.getIncreaseAmount() );
				}
			}
		}
	}
	
	public static void decreaseEffectDuration(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			ArrayList<Effect> removed = new ArrayList<Effect>();
			for (Effect e : ((UnitStats) u).getEffects()) {
				e.setDuration(e.getDuration() - 1);
				if (e.getDuration() == 0) {
					removed.add(e);
				}
			}
			for (Effect e : removed) {
				((UnitStats) u).removeEffect(e);
			}
		}
	}
	
	public static void decreaseSkillCooldown(Unit[] units) {
		for (Unit u : units) {
			if (u == null)
				continue;
			if (u instanceof AdvanceUnit) {
				for (Skill s : ((AdvanceUnit) u).getSkills()) {
					if(s instanceof NormalSkill)
						((NormalSkill) s).setCooldown(((NormalSkill) s).getCooldown() - 1);
				}
			}
		}
	}
	
	public static boolean isEnd(Unit[] units) {
		int aliveUnit = 0;
		for (int i = 0; i < units.length; i++) {
			if (units[i] == null)
				continue;
			if (!((UnitStats) units[i]).getIsDead()) {
				aliveUnit += 1;
			}
		}
		return aliveUnit == 0;
	}

	public static void attack(Unit attack, Unit defense) {
		try {
			UnitStats attacker = (UnitStats) attack;
			UnitStats defender = (UnitStats) defense;
			attacker.attack(defender);
			if (defender.getCurrentHP() == 0) {
				defender.setIsDead(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + " can Dodged!!");
		}
	}
}
