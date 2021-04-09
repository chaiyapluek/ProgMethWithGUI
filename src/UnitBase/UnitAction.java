package UnitBase;

import java.util.Random;

import SubSkill.*;

public abstract class UnitAction extends UnitStats {

	public UnitAction(String name, String _class, int[] stats) {
		super(name, _class, stats);
		// TODO Auto-generated constructor stub
	}

	public void attack(Unit target) throws Exception {
		UnitStats targetStat = (UnitStats) target;
		Random ran = new Random();
		int dodge = Math.min(100, targetStat.getDodgeChance());
		int defense = Math.min(100, targetStat.getDefense());
		if (defense < 0 || this.isIgnoreDef()) {
			defense = 0;
		}
		if ((!this.isSureHit()) && (isChance(dodge) || targetStat.getIsEvade())) {
			throw new Exception(target.getName());
		}
		double damageMultipler = getDamageMultiplier(targetStat);
		if (isChance(this.getCritChance())) {
			damageMultipler += 1.0 * this.getCritDamage() / 100;
		}

		double damageDealed = this.getTotalAttack() * damageMultipler;
		damageDealed = damageDealed * ((double) (95.0 + ran.nextInt(16)) / 100);
		double damageCut = Math.ceil((1.0 * defense / 100) * damageDealed);

		int totalDamage = (int) (damageDealed - damageCut);
		targetStat.setCurrentHP(targetStat.getCurrentHP() - totalDamage);

		System.out.println(this.getName() + " attacked " + target.getName() + " with damage " + totalDamage);
	}

	public double getDamageMultiplier(Unit target) {
		String thisClass = this.get_Class();
		String targetClass = target.get_Class();
		double damageMultiply = 1.0f;
		if (targetClass.equals("Berserker") || this.get_Class().equals("Berserker")) {
			return 1.5f;
		}
		if (thisClass.equals("Saber")) {
			if (targetClass.equals("Lancer")) {
				damageMultiply = 1.5f;
			} else if (targetClass.equals("Archer")) {
				damageMultiply = 0.5f;
			}
		} else if (thisClass.equals("Lancer")) {
			if (targetClass.equals("Archer")) {
				damageMultiply = 1.5f;
			} else if (targetClass.equals("Saber")) {
				damageMultiply = 0.5f;
			}
		} else if (thisClass.equals("Archer")) {
			if (targetClass.equals("Saber")) {
				damageMultiply = 1.5f;
			} else if (targetClass.equals("Lancer")) {
				damageMultiply = 0.5f;
			}
		}
		return damageMultiply;
	}

	public static boolean isChance(int chance) {
		Random ran = new Random();
		double number = ran.nextDouble() * 100;
		if (number <= chance)
			return true;
		return false;
	}

	public void defense() {
		SubSkill DefUp = new IncreaseDef(1, 20);
		SubSkill DodgeUp = new IncreaseDodgeChance(1, 10);
		DefUp.activate(this);
		DodgeUp.activate(this);
	}

}
