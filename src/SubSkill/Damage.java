package SubSkill;

import java.util.Random;

import UnitBase.Unit;
import UnitBase.UnitAction;

public class Damage extends SubSkill {

	private int percentDamage;
	private int hitAmount;

	public Damage(int percentDamage, int hitAmount) {
		super("[]", 0);
		// TODO Auto-generated constructor stub
		this.percentDamage = percentDamage;
		this.hitAmount = hitAmount;
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub

	}

	public void damaged(Unit u, Unit t) {
		Random ran = new Random();
		UnitAction User = (UnitAction) u;
		UnitAction Target = (UnitAction) t;
		int dodge = Math.min(100, Target.getDodgeChance());
		int defense = Math.min(100, Target.getDefense());
		int userCritChance = Math.min(100, User.getCritChance());
		double damageMul = User.getDamageMultiplier(Target);
		for (int i = 0; i < hitAmount; i++) {
			double damageDealed = (int) ((double) (1.0 * percentDamage / 100 * User.getTotalAttack()) * damageMul);
			if (defense < 0 || User.isIgnoreDef()) {
				defense = 0;
			}
			if ((!User.isSureHit()) && (UnitAction.isChance(dodge) || Target.getIsEvade())) {
				continue;
			}
			if (UnitAction.isChance(userCritChance)) {
				damageDealed *= (double) (1 + (double) User.getCritDamage() / 100);
			}
			damageDealed = damageDealed * ((double) (95.0 + ran.nextInt(16)) / 100);
			double damageCut = Math.ceil(defense * damageDealed / 100.0);
			int totalDamage = (int) (damageDealed - damageCut);
			Target.setCurrentHP(Target.getCurrentHP() - totalDamage);
			System.out.println(totalDamage);
		}
		if (Target.getCurrentHP() <= 0) {
			Target.setIsDead(true);
		}
	}

}
