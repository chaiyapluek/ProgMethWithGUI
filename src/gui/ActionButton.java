package gui;

import Skill.NormalSkill;
import Skill.Skill;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class ActionButton extends Button {

	private String type;
	private Skill skill;
	private Tooltip tooltip;

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

		setBackground(isLock);

		this.setTooltip(isLock, level);

		this.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mouseEnter(isLock, skill);
			}

		});

		this.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mouseExit(isLock);
			}
		});
	}

	public void mouseEnter(boolean isLock, Skill s) {
		if (type.equals("swap")) {
			boolean check = true;
			if (GameController.getOnBattle() && !GameController.getSelectAllyUnit().canTakeAction()) {
				check = false;
			}
			if (check) {
				this.setCursor(Cursor.HAND);
				this.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));
			}
		} else {
			boolean check = true;
			if (type.equals("skill")) {
				if(isLock) {
					check = false;
				}
				if (s instanceof NormalSkill) {
					NormalSkill skill = (NormalSkill) s;
					if (skill.getCooldown() != 0) {
						check = false;
					}
				} else {
					if (GameController.getSelectAllyUnit().getUltiGauge() < GameController.getSelectAllyUnit()
							.getMaxUltigauge()) {
						check = false;
					}
				}
			}
			if (GameController.getOnBattle() && GameController.getSelectAllyUnit().canTakeAction() && check) {
				this.setCursor(Cursor.HAND);
				this.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
						BorderWidths.DEFAULT)));
			}
		}

	}

	public void mouseExit(boolean isLock) {
		tooltip.hide();
		this.setCursor(Cursor.DEFAULT);
		this.setBorder(new Border(
				new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setBackground(isLock);
	}

	private void setBackground(boolean isLock) {
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
			} else {
				if (skill instanceof NormalSkill) {
					NormalSkill s = (NormalSkill) skill;
					if (s.getCooldown() != 0) {
						StackPane p = new StackPane();
						Label label = new Label("" + s.getCooldown());
						label.setFont(Font.font("Berlin Sans FB", 48));
						label.setTextFill(Color.WHITE);
						Image img = new Image("black.jpg");
						ImageView imgView = new ImageView(img);
						imgView.setFitHeight(50);
						imgView.setFitWidth(50);
						imgView.setOpacity(0.8);
						p.getChildren().addAll(imgView, label);
						this.setGraphic(p);
					}
				}
			}
		}
	}

	public void setTooltip(boolean isLock, int level) {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		String txt = "";
		if (type.equals("attack")) {
			txt += "Normal attack\n" + "Deal damage to one enemy";
		} else if (type.equals("defense")) {
			txt += "Defense\n" + "Increases own defenses and dodge chance";
		} else if (type.equals("swap")) {
			txt += "Swap\n" + "Swap with unit in back row";
		} else {
			txt += skill.getName() + "\n" + skill.getDescription() + "\n";
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

	public Skill getSkill() {
		return skill;
	}

	public String getType() {
		return type;
	}

}
