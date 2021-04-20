package gui;

import Skill.NormalSkill;
import Skill.Skill;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ActionButton extends Button {

	private String type;
	private Skill skill;

	public ActionButton(String type, Skill skill, boolean isLock, int level) {
		this.type = type;
		if (type.equals("skill")) {
			this.skill = skill;
		} else {
			this.skill = null;
		}

		this.setMinSize(50, 50);
		this.setMaxSize(50, 50);
		this.setAlignment(Pos.CENTER);
		if (type.equals("attack")) {
			this.setBackground(new Background(
					new BackgroundImage(new Image("attack.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
							BackgroundPosition.CENTER, new BackgroundSize(0, 100, false, true, true, false))));

		} else if (type.equals("defense")) {
			this.setBackground(new Background(new BackgroundImage(new Image("defense.png"), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 100, false, true, true, false))));
		} else if (type.equals("swap")) {
			this.setBackground(new Background(
					new BackgroundImage(new Image("swap.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
							BackgroundPosition.CENTER, new BackgroundSize(0, 100, false, true, true, false))));
		} else {
			this.setBackground(new Background(new BackgroundImage(new Image(skill.getUrl()), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(0, 100, false, true, true, false))));
			if (isLock) {
				Image img = new Image("Lock.png");
				ImageView imgView = new ImageView(img);
				imgView.setFitHeight(35);
				imgView.setPreserveRatio(true);
				this.setGraphic(imgView);
			}
		}
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("EXIT");
				setOnExit();
			}
		});
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("ENTER");
				setOnEnter(isLock);
			}
		});
		this.setTooltip(isLock, level);
	}

	public void setOnEnter(boolean isLock) {
		if (type.equals("skill") && !isLock) {
			this.setCursor(javafx.scene.Cursor.HAND);
			this.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		}
	}

	public void setOnExit() {
		System.out.println("HELLO");
		this.setCursor(javafx.scene.Cursor.DEFAULT);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
	}

	private void setTooltip(boolean isLock, int level) {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		String txt;
		if (type.equals("attack")) {
			txt = "Normal attack\n" + "Deal damage to one enemy";
		} else if (type.equals("defense")) {
			txt = "Defense\n" + "Increases own defenses and dodge chance";
		} else if (type.equals("swap")) {
			txt = "Swap\n" + "Swap with unit in back row";
		} else {
			txt = skill.getName() + "\n" + skill.getDescription() + "\n";
			if (skill instanceof NormalSkill) {
				txt += "Cooldown : " + ((NormalSkill) skill).getCooldownTime() + " turn(s)";
				if (isLock) {
					txt += "\nUnlock at level " + level;
				}
			}
		}
		tooltip.setText(txt);
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public String getType() {
		return type;
	}

}
