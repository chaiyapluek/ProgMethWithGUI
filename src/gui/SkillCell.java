package gui;

import Skill.NormalSkill;
import Skill.Skill;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SkillCell extends Button {

	private Skill skill;

	public SkillCell(Skill skill) {

		this.skill = skill;
		this.setPrefSize(35, 35);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Image image = new Image("Skill/skill1.png");
		BackgroundImage bimg = new BackgroundImage(image, null, null, BackgroundPosition.CENTER,
				new BackgroundSize(this.getWidth(), this.getHeight(), true, true, true, false));
		Background bg = new Background(bimg);
		this.setTooltip();
		this.setBackground(bg);
	}

	public Skill getSkill() {
		return skill;
	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		String txt = skill.getName() + "\n" + skill.getDescription() + "\n";
		if(skill instanceof NormalSkill) {
			tooltip.setText(txt + "Cooldown : " + ((NormalSkill)skill).getCooldownTime() + " turn(s)");
		}else {
			tooltip.setText(txt);
		}
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
}
