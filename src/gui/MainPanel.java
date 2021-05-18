package gui;

import Application.Player;
import List.AllyUnitList_Saber;
import UnitBase.AllyUnit;
import UnitBase.Unit;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class MainPanel extends StackPane {

	private StackPane viewPanel;
	private AllyUnitsPanel allyUnitsPanel;
	private BattlePanel battlePanel;
	private ViewStagePane stagePane;
	private VBox panel;
	private Canvas canvas;

	private int time;

	public MainPanel(Player player) {
		this.setPadding(new Insets(10));
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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

	public void textAtUnitButton(String text, Unit target) {

		UnitButton button = battlePanel.getUnitButton(target);
		double x = button.getScene().getWindow().getX();
		double y = button.getScene().getWindow().getY();
		Bounds localBounds = button.localToScene(button.getBoundsInLocal());
		canvas.setVisible(true);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Font font = new Font("Berlin Sans FB", 100);
		gc.setFont(font);
		gc.setFill(Color.RED);
		gc.fillText(text, localBounds.getMinX(), localBounds.getMinY());
		gc.fillText(text, localBounds.getCenterX(), localBounds.getCenterY());
		gc.fillText(text, localBounds.getMaxX(), localBounds.getMaxY());
		System.out.println(x + localBounds.getMinX());
		System.out.println(y + localBounds.getMinY());
		System.out.println(localBounds);
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(2000);
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
						canvas.setVisible(false);
					}
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
	}

}
