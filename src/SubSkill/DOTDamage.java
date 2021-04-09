package SubSkill;


import Skill.Effect;
import UnitBase.Unit;
import UnitBase.UnitStats;

public class DOTDamage extends SubSkill{

	private int damageAmount;
	
	public DOTDamage(int duration , int damageAmount) {
		super("[ DOT ]", duration);
		// TODO Auto-generated constructor stub
		this.damageAmount = damageAmount;
	}

	@Override
	public void activate(Unit target) {
		// TODO Auto-generated method stub
		UnitStats Target = (UnitStats)target;
		Target.setCurrentHP(Target.getCurrentHP() - damageAmount);
		if(this.getDuration()>1) {
			Effect effect = new Effect(this.getDescription(),this.getDuration(),this);
			Target.getEffects().add(effect);
		}
	}

	@Override
	public void deactivate(Unit target) {
		// TODO Auto-generated method stub
		
	}
	
	public void damaged(Unit target) {
		UnitStats Target = (UnitStats)target;
		Target.setCurrentHP(Target.getCurrentHP() - damageAmount);
	}
	
}
