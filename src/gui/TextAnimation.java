package gui;

import java.util.ArrayList;

import Application.Main;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.BattleController;
import logic.GameController;

public class TextAnimation {

	private static int time;
	private static int num;
	private static int size;

	private static double func(double t, double width) {
		t /= 1000;
		return (-(t - 1) * (t - 1) * (t - 1)) * (width / 2 + 100) + width / 2 - 120;
	}

	public static void textTrasition(GraphicsContext gc, String text) {
		Font font = new Font("Berlin Sans FB", 100);
		gc.setFont(font);
		Thread thread = new Thread(() -> {
			gc.getCanvas().setVisible(true);
			time = 0;
			try {
				while (time <= 2100) {
					Thread.sleep(10);
					time += 10;
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
							gc.setGlobalAlpha(0.75);
							gc.setFill(Color.BLACK);
							gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
							gc.setGlobalAlpha(1);
							gc.setFont(font);
							gc.setFill(Color.RED);
							gc.fillText(text, func(time, gc.getCanvas().getWidth()), 400);
						}
					});
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if (text.equals("Victory")) {
							GameController.showReward(true);
						}else if(BattleController.getEnemyWin() || GameController.isWin()) {
							GameController.setIsWin(false);
							Main.setStartScene();
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gc.getCanvas().setVisible(false);
		});
		thread.start();
	}

	public static void textAtUnitButton(GraphicsContext gc, ArrayList<TextToShow> texts) {
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Font font = new Font("Berlin Sans FB", 30);
				gc.setFont(font);
				gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
				gc.getCanvas().setVisible(true);
			}
		});
		time = 0;
		size = texts.size();
		num = 0;
		try {
			while (num < size) {
				Thread.sleep(10);
				time += 10;
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
						for (TextToShow t : texts) {
							if (t.isFinished()) {
								continue;
							}
							if (t.getShowTime() <= time && t.getTime() < t.getMaxTime()) {
								gc.setGlobalAlpha(1 - 1.0 * t.getTime() / 1250);
								gc.fillText(t.getText(), t.getX(), t.getY() - 1.0 * t.getTime() / 25);
								t.addTime();
							}
							if (t.getTime() >= t.getMaxTime()) {
								t.setIsFinished(true);
								num += 1;
							}
						}
					}
				});
			}
			texts.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		gc.getCanvas().setVisible(false);
	}

}
