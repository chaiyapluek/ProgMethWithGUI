package Map;

import java.util.Random;

import Coordinate.Coordinate;
import List.StageList_Difficulty1;

public class Map {

	private int height;
	private int width;
	private Stage[][] stages;

	public Map() {

		int[][] mark;
		mark = GenerateMap();
		stages = new Stage[mark.length][mark[0].length];
		this.height = mark.length;
		this.width = mark[0].length;
		assignStage(mark);
		stages[height-1][0].setClear(true);
		stages[height-1][0].setHasShop(true);
	}

	public boolean isEmpty(Coordinate coordinate) {
		int i = coordinate.getX();
		int j = coordinate.getY();
		if (i < 0 || j < 0 || i >= height || j >= width)
			return true;
		if (stages[i][j] == null)
			return true;
		return false;
	}

	public Stage getStage(Coordinate coordinate) {
		return stages[coordinate.getX()][coordinate.getY()];
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void assignStage(int[][] mark) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (mark[i][j] == 1) {
					stages[i][j] = StageList_Difficulty1.Stage1();
				} else {
					stages[i][j] = null;
				}
			}
		}
	}

	public int[][] GenerateMap() {
		Random ran = new Random();
		int n = 1;
		int m = 1;
		while ((n * m < 36) || (n * m > 48)) {
			n = 4 + ran.nextInt(3);
			m = 6 + ran.nextInt(4);
		}
		int[][] mark = new int[n][m];
		while (true) {
			mark = new int[n][m];
			boolean Re = false;
			while (!QA(mark, n, m)) {
				if (zeroPercent(mark, n, m) < 25) {
					Re = true;
					break;
				}
				int nowi = n - 1;
				int nowj = 0;
				int upAmount = n - 1;
				int rightAmount = m - 1;
				mark[nowi][nowj] = 1;
				for (int j = 0; j < (n + m - 2); j++) {
					boolean up = ran.nextBoolean();
					if (up && upAmount > 0) {
						upAmount -= 1;
						nowi -= 1;
					} else if (!up && rightAmount > 0) {
						rightAmount -= 1;
						nowj += 1;
					} else if (upAmount == 0) {
						rightAmount -= 1;
						nowj += 1;
					} else {
						upAmount -= 1;
						nowi -= 1;
					}
					mark[nowi][nowj] = 1;
				}
			}
			if (!Re)
				break;
		}
		return mark;
	}

	public static boolean QA(int[][] mark, int n, int m) {
		if (mark[0][m - 2] == 0 || mark[1][m - 1] == 0)
			return false;
		return (zeroPercent(mark, n, m) >= 25) && (zeroPercent(mark, n, m) <= 30);
	}

	public static double zeroPercent(int[][] mark, int n, int m) {
		int num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mark[i][j] == 0)
					num++;
			}
		}
		return (1.0 * num) / (n * m) * 100.0;
	}
}
