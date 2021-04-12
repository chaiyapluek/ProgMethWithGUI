package logic;

import java.util.ArrayList;
import java.util.Random;

import Application.Main;
import Application.Player;
import Coordinate.Coordinate;
import List.AllyUnitList;
import Map.*;
import UnitBase.*;
import gui.ChooseMerPanel;
import gui.ControlPanel;

public class GameController {

	private static Player player;
	private static AllyUnit[] units;
	private static Map gameMap;
	private static ChooseMerPanel chooseMerPanel;
	private static AllyUnit selectAllyUnit;
	private static ControlPanel controlPanel;
	
	private static boolean moveToggle = false;

	public static void Intialize() {
		gameMap = new Map();
		units = new AllyUnit[3];
	}
	
	public static void createPlayer() {
		Coordinate coordinate = new Coordinate(gameMap.getHeight() - 1, 0);
		player = new Player(units, coordinate);
		selectAllyUnit = player.getUnits()[0];
	}

	public static void addInitialUnit(AllyUnit unit) {
		units[ChooseMerPanel.count] = unit;
	}
	
	public static AllyUnit getSelectAllyUnit() {
		return selectAllyUnit;
	}
	
	public static void setSelectAllyUnit(AllyUnit unit) {
		selectAllyUnit = unit;
	}

	public static void setChooseMerPanel(ChooseMerPanel chooseMerPanel) {
		GameController.chooseMerPanel = chooseMerPanel;
	}

	public static void setControlPanel(ControlPanel panel) {
		GameController.controlPanel = panel;
	}
	
	public static void updateControlPanel() {
		GameController.controlPanel.update();
	}
	
	public static void updateMapPanel() {
		GameController.controlPanel.getMapPanel().update();
	}
	
	public static void chooseNext() {
		chooseMerPanel.setLabelText();
		chooseMerPanel.chooseNext();
	}
	
	public static void changeToInitialScene() {
		Main.getStage().setScene(Main.getInitialScene());
	}
	
	public static void changeToMainScene() {
		Main.getStage().setScene(Main.getMainScene());
	}

	public static boolean encouter(Coordinate coordinate) {
		int i = coordinate.getX();
		int j = coordinate.getY();
		return !gameMap.getStage(i, j).isClear();
	}

	public static Player getPlayer() {
		return player;
	}
	
	public static Coordinate getPlayerCoordinate() {
		return player.getCoordinate();
	}

	public static boolean canMove(Coordinate coordinate) {
		return !gameMap.isEmpty(coordinate);
	}

	public static void movePlayer(Coordinate coordinate) {
		player.Move(coordinate);
	}
	
	public static Map getMap() {
		return gameMap;
	}

	public static void setMoveToggle(boolean bool) {
		moveToggle = bool;
	}
	
	public static boolean getMoveToggle() {
		return moveToggle;
	}
}
