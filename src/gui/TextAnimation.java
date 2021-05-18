package gui;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.BattleController;

public class TextAnimation {

	private static int time;

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
							BattleController.reset();
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
	
	public void textAtUnitButton() {
		
	}

}
