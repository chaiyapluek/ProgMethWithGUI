package gui;

import Skill.Skill;
import UnitBase.AdvanceUnit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class skillPanel extends FlowPane {

	public skillPanel(AdvanceUnit unit) {
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setVgap(20);
		this.setHgap(20);
		this.setMaxSize(120, 120);
		this.setMinSize(120, 120);
		for (int i = 0; i < unit.getMaxSkill(); i++) {
			Skill skill = unit.getSkills()[i];
			SkillCell skillCell = new SkillCell(skill);
			this.getChildren().add(skillCell);
		}
	}

}
