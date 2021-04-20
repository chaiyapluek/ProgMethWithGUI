package Application;

import Coordinate.Coordinate;
import Skill.*;
import UnitBase.*;

public class Player {

	private AllyUnit[] units;
	private AllyUnit[] backUnits;
	private int numberOfUnits;
	private Coordinate coordinate;

	public Player(AllyUnit[] units,Coordinate coordinate) {
		this.units = new AllyUnit[3];
		this.backUnits = new AllyUnit[3];
		this.numberOfUnits = 0;
		for (int i = 0; i < 3; i++) {
			this.backUnits[i] = null;
			if (units[i] == null) {
				this.units[i] = null;
			} else {
				this.units[i] = units[i];
				this.numberOfUnits += 1;
			}
		}
		this.coordinate = new Coordinate(coordinate);
	}

	public void Move(Coordinate coordinate) {
		this.coordinate.setX(coordinate.getX());
		this.coordinate.setY(coordinate.getY());
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public int getNumberOfUnit() {
		int numberOfUnit = 0;
		for (int i = 0; i < 3; i++) {
			if (units[i] == null)
				continue;
			if (units[i].getIsDead() || units[i].getIsStun())
				continue;
			numberOfUnit += 1;
		}
		this.setNumberOfUnit(numberOfUnit);
		return this.numberOfUnits;
	}
	
	public void setNumberOfUnit(int num) {
		this.numberOfUnits = Math.max(0, num);
	}

	public AllyUnit[] getUnits() {
		return this.units;
	}
	
	public AllyUnit[] getBackUnits() {
		return this.backUnits;
	}

	public void play(Unit[] targets) {
		boolean[] mark = new boolean[] { false, false, false };
		for (int i = 0; i < this.getNumberOfUnit(); i++) {
			while (true) {
				int idx = getUnitIdx(mark);
				boolean finished = false;
				while (true) {
					System.out.println("Choose unit's action");
					System.out.println("[1] Attack");
					System.out.println("[2] Defense");
					System.out.println("[3] Use skill");
					// System.out.println("[4] Swap unit");
					System.out.println("[0] Go back");
					int opr = 0;
					if (opr < 0 || opr > 3) {
						System.out.println("Out of an option");
						continue;
					}
					if (opr == 1) {
						finished = attack(targets, mark, idx);
						break;
					} else if (opr == 2) {
						finished = defense(mark, idx);
						System.out.println(units[idx].getName() + "'s defense has increased");
						break;
					} else if (opr == 3) {
						finished = useSkill(targets, mark, idx);
						break;
					} else {
						break;
					}
				}
				if (!finished)
					continue;
				else
					break;
			}
			if(Battle.isEnd(targets))
				break;
		}
	}

	public int getUnitIdx(boolean[] mark) {
		int idx;
		while (true) {
			System.out.println("Choose your unit to take action");
			idx = 0;
			System.out.println("IDX:"  + idx);
			if (idx < 1 || idx > 3) {
				System.out.println("Out of an option");
				continue;
			}
			if (units[idx - 1] == null) {
				System.out.println("There is no unit " + idx);
				continue;
			}
			if (mark[idx - 1]) {
				System.out.println("This unit already took an action");
				continue;
			}
			if (units[idx - 1].getIsDead()) {
				System.out.println("This unit is already dead");
				continue;
			}
			if(units[idx-1].getIsStun()) {
				System.out.println("This unit cannot operate");
				continue;
			}
			break;
		}
		return idx - 1;
	}

	public boolean attack(Unit[] targets, boolean[] mark, int idx) {
		boolean finished = false;
		while (true) {
			System.out.println("Select enemy to attack ([0] to go back)");
			int targetIdx = 0;
			if (targetIdx == 0)
				break;
			if (targetIdx < 1 || targetIdx > 3) {
				System.out.println("There is no target " + targetIdx);
				continue;
			}
			if (targets[targetIdx - 1] == null) {
				System.out.println("There is no target " + targetIdx);
				continue;
			}
			if (((UnitStats) targets[targetIdx - 1]).getIsDead()) {
				System.out.println("This unit is already dead");
				continue;
			}
			Battle.attack(units[idx], targets[targetIdx - 1]);
			finished = true;
			mark[idx] = true;
			break;
		}
		return finished;
	}

	public boolean defense(boolean[] mark, int idx) {
		units[idx].defense();
		mark[idx] = true;
		return true;
	}

	public int getUnitIdxForSkill(Unit[] target, int type) {
		int idx;
		while (true) {
			if (type == 0) {
				System.out.println("Select one Ally ([0] to go back)");
			} else {
				System.out.println("Select one Enemy ([0] to go back)");
			}
			idx = 0;
			if (idx < 0 || idx > 3) {
				System.out.println("Out of an option");
				continue;
			}
			if (idx == 0)
				break;
			if (target[idx - 1] == null) {
				System.out.println("There is no unit " + idx);
				continue;
			} else if (((UnitStats) target[idx - 1]).getIsDead()) {
				System.out.println("This unit is already dead");
				continue;
			}
			break;
		}
		return idx;
	}

	public boolean useSkill(Unit[] target, boolean[] mark, int idx) {
		boolean finished = false;
		System.out.println(units[idx].getName() + "'s skill(s)");
		for (int i = 0; i < units[idx].getSkills().length; i++) {
			System.out.println("[" + (i + 1) + "] " + units[idx].getSkills()[i]);
		}
		while (true) {
			System.out.println("Select skill to use([0] to go back)");
			int skillIdx = 0;
			if (skillIdx == 0)
				break;
			skillIdx -= 1;
			Skill skill = units[idx].getSkills()[skillIdx];
			if((skill instanceof UltimateSkill) && units[idx].getUltiGauge()<units[idx].getMaxUltigauge()) {
				System.out.println("Gauge isn't full yet");
				continue;
			}
			if ((skill instanceof NormalSkill) && ((NormalSkill) skill).getCooldown() != 0) {
				System.out.println("This skill is on cooldown");
				continue;
			}
			if(skill.getToYourSelf()) {
				System.out.println(units[idx].getName() + " used skill to his self");
				skill.use(units[idx],units[idx]);
				finished = true;
				mark[idx] = true;
				break;
			}
			if (skill.getIsSingle()) {
				if (skill.getToAlly()) {
					int targetIdx = getUnitIdxForSkill(units, 0);
					if (targetIdx == 0)
						continue;
					System.out.println(units[idx].getName() + " used skill to " + units[targetIdx - 1].getName());
					skill.use(units[idx],units[targetIdx - 1]);
					finished = true;
					mark[idx] = true;
					break;
				} else {
					int targetIdx = getUnitIdxForSkill(target, 1);
					if (targetIdx == 0)
						continue;
					System.out.println(units[idx].getName() + " used skill to " + target[targetIdx - 1].getName());
					skill.use(units[idx],target[targetIdx - 1]);
					finished = true;
					mark[idx] = true;
					break;
				}
			} else {
				if (skill.getToAlly()) {
					for (int i = 0; i < 3; i++) {
						if (units[i] == null)
							continue;
						skill.use(units[idx],units[i]);
					}
					System.out.println(units[idx].getName() + " used skill to all Ally");
				} else {
					for (int i = 0; i < 3; i++) {
						if (target[i] == null)
							continue;
						skill.use(units[idx],target[i]);
					}
					System.out.println(units[idx].getName() + " used skill to all Enemies");
				}
				mark[idx] = true;
				finished = true;
				break;
			}
		}
		return finished;
	}
}
