package UnitBase;

import java.util.ArrayList;
import Skill.Effect;

public abstract class UnitStats extends Unit {

	private int maxHP;
	private int defense;
	private int attack;

	private int currentHP;

	private int critChance;
	private int critDamage;
	private int dodgeChance;

	private int increaseAttackAmount;

	private boolean isEvade;
	private boolean isTaunt;
	private boolean isStun;
	private boolean isDead;
	private boolean sureHit;
	private boolean ignoreDef;
	private ArrayList<Effect> effects;

	public UnitStats(String name, String _class, int[] stats) {
		super(name, _class);
		this.currentHP = stats[0];
		this.maxHP = stats[0];
		this.defense = stats[1];
		this.attack = stats[2];

		this.critChance = stats[3];
		this.critDamage = stats[4];
		this.dodgeChance = stats[5];
		this.increaseAttackAmount = 0;
		this.isStun = false;
		this.isDead = false;
		this.isTaunt = false;
		this.isEvade = false;
		this.sureHit = false;
		this.ignoreDef = false;

		effects = new ArrayList<Effect>();
	}

	public abstract void attack(Unit target) throws Exception;

	public abstract void defense();

	public int getMaxHP() {
		return this.maxHP;
	}

	public void setMaxHP(int maxHP) {
		double percentHP = (1.0 * this.getCurrentHP() * 100) / this.getMaxHP();
		this.maxHP = maxHP;
		this.setCurrentHP((int) (1.0 * maxHP * percentHP / 100));
	}

	public int getCurrentHP() {
		return this.currentHP;
	}

	public void setCurrentHP(int currentHp) {
		if (currentHp < 0) {
			currentHp = 0;
		}
		this.currentHP = Math.min(currentHp, this.maxHP);
	}

	public int getDefense() {
		return this.defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getIncreaseAttackAmount() {
		return increaseAttackAmount;
	}

	public void setIncreaseAttackAmount(int increaseAttackAmount) {
		this.increaseAttackAmount = increaseAttackAmount;
	}

	public int getTotalAttack() {
		return this.getAttack() + ((this.getIncreaseAttackAmount() * this.getAttack()) / 100);
	}

	public int getCritChance() {
		return this.critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}

	public int getCritDamage() {
		return critDamage;
	}

	public void setCritDamage(int critDamage) {
		this.critDamage = critDamage;
	}

	public int getDodgeChance() {
		return this.dodgeChance;
	}

	public void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}

	public boolean getIsStun() {
		return this.isStun;
	}

	public void setIsStun(boolean isStun) {
		this.isStun = isStun;
	}

	public boolean getIsTaunt() {
		return isTaunt;
	}

	public void setIsTaunt(boolean isTaunt) {
		this.isTaunt = isTaunt;
	}

	public boolean getIsEvade() {
		return isEvade;
	}

	public void setIsEvade(boolean isEvade) {
		this.isEvade = isEvade;
	}

	public boolean isSureHit() {
		return sureHit;
	}

	public void setSureHit(boolean sureHit) {
		this.sureHit = sureHit;
	}

	public boolean isIgnoreDef() {
		return ignoreDef;
	}

	public void setIgnoreDef(boolean ignoreDef) {
		this.ignoreDef = ignoreDef;
	}

	public ArrayList<Effect> getEffects() {
		return this.effects;
	}

	public void removeEffect(Effect e) {
		e.getSubSkill().deactivate(this);
		this.effects.remove(e);
	}

}
