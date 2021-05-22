package Unit;

public class BasicUnit extends UnitAction {

	public BasicUnit(String name, String _class, int[] stats) {
		super(name, _class, stats);
	}

	public BasicUnit(BasicUnit unit) {
		super(unit.getName(), unit.get_Class(), unit.getStats());
	}

	public int[] getStats() {
		int[] stats = new int[7];
		stats[0] = this.getMaxHP();
		stats[1] = this.getDefense();
		stats[2] = this.getAttack();
		stats[3] = this.getCritChance();
		stats[4] = this.getCritDamage();
		stats[5] = this.getDodgeChance();
		stats[6] = 0;
		return stats;
	}

	public String getInfo() {
		String str = "[ " + this.getName() + " : " + this.get_Class() + " ] --> ";
		str += "HP : " + this.getCurrentHP() + "/" + this.getMaxHP();
		return str;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String info = "Name \t\t: " + this.getName() + "\n";
		info += "Class \t\t: " + this.get_Class() + "\n";
		info += "HP \t\t: " + this.getCurrentHP() + "/" + this.getMaxHP() + "\n";
		info += "Attack \t\t: " + this.getAttack() + "\n";
		info += "Defense \t: " + this.getDefense() + "\n";
		info += "Ulti gauge \t: 0/0" + "\n";
		return info;
	}
}
