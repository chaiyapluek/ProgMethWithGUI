package gui;

public class TextToShow {

	private double x;
	private double y;
	private int showTime;
	private int time;
	private int maxTime;

	private String text;
	private boolean isFinished = false;

	public TextToShow(double x, double y, int showTime, String text) {
		this.x = x;
		this.y = y;
		this.showTime = showTime;
		this.time = 0;
		this.maxTime = 1000;
		this.text = text;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTime() {
		return time;
	}

	public void addTime() {
		this.time += 10;
	}

	public double getX() {
		return x;
	}

	public int getShowTime() {
		return showTime;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public String getText() {
		return text;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

}
