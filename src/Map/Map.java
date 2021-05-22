package Map;

import java.util.ArrayList;
import java.util.Random;

import Coordinate.Coordinate;
import List.*;

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
		stages[height - 1][0] = StageList_Difficulty1.Stage1();
		stages[height - 1][0].setClear(true);
		stages[height - 1][0].setHasShop(true);
		stages[height - 1][0].createShop();
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
		int sti = height - 1;
		int stj = 0;
		int eni = 0;
		int enj = width - 1;
		Stage[][] stageDiff = new Stage[6][5];
		stageDiff[0] = StageList_Difficulty1.getStage_Difficulty1();
		stageDiff[1] = StageList_Difficulty2.getStage_Difficulty2();
		stageDiff[2] = StageList_Difficulty3.getStage_Difficulty3();
		stageDiff[3] = StageList_Difficulty4.getStage_Difficulty4();
		stageDiff[4] = StageList_Difficulty5.getStage_Difficulty5();
		stageDiff[5] = StageList_Boss.getMiniBossStage();
		boolean[][] mark2 = new boolean[6][10];
		Random r = new Random();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (mark[i][j] == 1) {
					if (i == eni && j == enj) {
						stages[i][j] = StageList_Boss.Boss();
						stages[i][j].setIsBoss(true);
					} else if ((i == eni + 1 && j == enj) || (i == eni && j == enj - 1)) {
						int idx = r.nextInt(4);
						while (mark2[5][idx]) {
							idx = r.nextInt(4);
						}
						stages[i][j] = stageDiff[5][idx];
						mark2[5][idx] = true;
					} else {
						int dis = Math.abs(sti - i) + Math.abs(stj - j);
						int diff = (dis - 1) / 2;
						if (dis == 0) {
							continue;
						}
						boolean check = true;
						for (int k = 0; k < 5; k++) {
							if (!mark2[diff][k]) {
								check = false;
								break;
							}
						}
						if (check) {
							for (int k = 0; k < 5; k++) {
								mark2[diff][k] = false;
							}
							if (diff == 0) {
								stageDiff[diff] = StageList_Difficulty1.getStage_Difficulty1();
							} else if (diff == 1) {
								stageDiff[diff] = StageList_Difficulty2.getStage_Difficulty2();
							} else if (diff == 2) {
								stageDiff[diff] = StageList_Difficulty3.getStage_Difficulty3();
							} else if (diff == 3) {
								stageDiff[diff] = StageList_Difficulty4.getStage_Difficulty4();
							} else if (diff == 4) {
								stageDiff[diff] = StageList_Difficulty5.getStage_Difficulty5();
							}
						}
						int idx = r.nextInt(5);
						while (mark2[diff][idx]) {
							idx = r.nextInt(5);
						}
						stages[i][j] = stageDiff[diff][idx];
						mark2[diff][idx] = true;
					}
				} else {
					stages[i][j] = null;
				}
			}
		}
		for (int k = 1; k <= 5; k++) {
			ArrayList<Stage> s = new ArrayList<Stage>();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (mark[i][j] != 1) {
						continue;
					}
					if ((i == sti && j == stj) || (i == eni && j == enj) || (i == eni + 1 && j == enj)
							|| (i == eni && j == enj - 1)) {
						continue;
					}
					int dis = Math.abs(sti - i) + Math.abs(stj - j);
					int diff = (dis - 1) / 2 + 1;
					if (diff == k) {
						s.add(stages[i][j]);
					}
				}

			}
			if (s.size() <= 0) {
				continue;
			}
			int idx = r.nextInt(s.size());
			s.get(idx).setHasShop(true);
			s.get(idx).createShop();
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

	public boolean isNearbyClear(Coordinate coor) {
		boolean isClear = false;
		int nowi = coor.getX();
		int nowj = coor.getY();
		int[] dir = { 1, -1, 0, 0 };
		int[] dic = { 0, 0, 1, -1 };
		for (int k = 0; k < 4; k++) {
			int nexti = nowi + dir[k];
			int nextj = nowj + dic[k];
			if (nexti < 0 || nextj < 0 || nexti >= height || nextj >= width) {
				continue;
			}
			if (stages[nexti][nextj] == null) {
				continue;
			}
			if (stages[nexti][nextj].isClear()) {
				isClear = true;
				break;
			}
		}
		return isClear;
	}
}
