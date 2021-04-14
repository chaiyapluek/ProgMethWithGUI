package gui;

import Skill.NormalSkill;
import Skill.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class ActionSkillPane extends HBox {

	private ObservableList<ActionButton> skillList = FXCollections.observableArrayList();

	public ActionSkillPane() {

		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setMinWidth(275);
		// this.setMinHeight(75);

		update();

	}

	public void update() {
		this.getChildren().clear();
		skillList.clear();

		for (int i = 0; i < GameController.getSelectAllyUnit().getMaxSkill(); i++) {
			boolean isLock = false;
			int level = 1;
			int requirement = 1;
			if (GameController.getSelectAllyUnit().getSkills()[i] instanceof NormalSkill) {
				level = GameController.getSelectAllyUnit().getLevel();
				requirement = GameController.getSelectAllyUnit().getSkillRequirement(i);
				isLock = (level < requirement);
			}
			ActionButton button = new ActionButton("skill", GameController.getSelectAllyUnit().getSkills()[i], isLock,
					requirement);
			skillList.add(button);
			this.getChildren().add(button);
		}

		for (ActionButton button : skillList) {
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("CLICKED!!");
					if (GameController.getSelectAllyUnit().getLevel() < 5) {
						GameController.getSelectAllyUnit().levelup();
						GameController.updateControlPanel();
					}
				}

			});
		}
	}

}
