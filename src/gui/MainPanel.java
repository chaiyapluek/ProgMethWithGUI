package gui;

import java.util.ArrayList;

import Application.Player;
import Unit.Unit;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameController;

public class MainPanel extends StackPane {

	private StackPane viewPanel;
	private AllyUnitsPanel allyUnitsPanel;
	private BattlePanel battlePanel;
	private ViewStagePane stagePane;
	private VBox panel;
	private Canvas canvas;

	private ArrayList<TextToShow> texts = new ArrayList<TextToShow>();

	public MainPanel(Player player) {
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		BackgroundImage sky = new BackgroundImage(new Image("BG_Main.jpg",1440,900,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(sky));
		panel = new VBox();
		panel.setPadding(new Insets(10));
		panel.setSpacing(10);
		panel.setAlignment(Pos.BOTTOM_CENTER);

		viewPanel = new StackPane();
		allyUnitsPanel = new AllyUnitsPanel(player);
		viewPanel.getChildren().add(allyUnitsPanel);

		ControlPanel controlPane = new ControlPanel(GameController.getSelectAllyUnit());
		GameController.setControlPanel(controlPane);

		canvas = new Canvas(1280, 720);
		canvas.setVisible(false);

		panel.getChildren().addAll(viewPanel, controlPane);
		panel.setPickOnBounds(false);
		this.getChildren().addAll(panel, canvas);
		panel.setViewOrder(9);
		// this.setPickOnBounds(false);
	}

	public void updateAllyPanel() {
		allyUnitsPanel.update();
	}

	public void updateBattlePanel() {
		battlePanel.update();
	}

	public void updateBattlePanelView() {
		battlePanel.updateView();
	}

	public void setChooseIcon() {
		if (GameController.getOnBattle()) {
			battlePanel.setChooseIcon();
		} else {
			allyUnitsPanel.setChooseIcon();
		}
	}

	public void setNewWave() {
		battlePanel.setNewWave();
	}

	public void viewStage() {
		stagePane = new ViewStagePane(GameController.getNowStage());
		viewPanel.getChildren().clear();
		viewPanel.getChildren().add(stagePane);
	}

	public void viewAllyPane() {
		viewPanel.getChildren().clear();
		viewPanel.getChildren().add(allyUnitsPanel);
	}

	public void viewBattlePanel() {
		viewPanel.getChildren().clear();
		battlePanel = new BattlePanel();
		viewPanel.getChildren().add(battlePanel);
	}

	public void textTransition(String text) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		TextAnimation.textTrasition(gc, text);
	}

	public void addTextToShow(String text, Unit target, int showTime) {
		UnitButton button = battlePanel.getUnitButton(target);
		Bounds localBounds = button.localToScene(button.getBoundsInLocal());
		double x = localBounds.getCenterX();
		double y = localBounds.getCenterY();
		TextToShow textToShow = new TextToShow(x, y, showTime, text);
		texts.add(textToShow);
	}

	public void showText() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		TextAnimation.textAtUnitButton(gc, texts);
		gc.getCanvas().setVisible(false);
	}

}
