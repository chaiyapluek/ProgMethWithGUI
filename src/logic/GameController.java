package logic;

import Application.Main;
import Application.Player;
import Coordinate.Coordinate;
import Map.*;
import UnitBase.*;
import gui.ChooseMerPanel;
import gui.ControlPanel;
import gui.MainPanel;
import gui.SelectTargetSkillPanel;
import gui.SwapPanel;

public class GameController {

	private static Player player;
	private static AllyUnit[] units;
	private static int unitsNumber;
	
	private static Map gameMap;
	private static AllyUnit selectAllyUnit;
	private static Unit selectEnemyUnit;
	
	private static ChooseMerPanel chooseMerPanel;
	private static ControlPanel controlPanel;
	private static MainPanel mainPanel;
	private static SelectTargetSkillPanel selectTargetPanel;
	private static SwapPanel swapPanel;
	
	private static boolean moveToggle = false;
	private static boolean onBattle = false;

	public static void Intialize() {
		gameMap = new Map();
		units = new AllyUnit[6];
		unitsNumber = 3;
	}
	
	public static boolean isUnitExist(AllyUnit unit) {
		for(int i=0;i<3;i++) {
			if(unit.equals(player.getUnits()[i]))
				return true;
		}
		for(int i=0;i<3;i++) {
			if(unit.equals(player.getBackUnits()[i]))
				return true;
		}
		return false;
	}
	
	public static AllyUnit[] getUnits() {
		return units;
	}

	public static void addUnits(AllyUnit unit) throws Exception {
		if(unitsNumber<6) {
			for(int i=0;i<3;i++) {
				if(player.getUnits()[i] == null) {
					player.getUnits()[i] = unit;
					updateAllyView();
					return;
				}
			}
			for(int i=0;i<3;i++) {
				if(player.getBackUnits()[i] == null) {
					player.getBackUnits()[i] = unit;
					updateAllyView();
					return;
				}
			}
		}
		else {
			throw new Exception();
		}
	}

	public static int getUnitsNumber() {
		return unitsNumber;
	}

	public static void setUnitsNumber(int unitsNumber) {
		GameController.unitsNumber = unitsNumber;
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
	
	public static Unit getSelectEnemyUnit() {
		return selectEnemyUnit;
	}
	
	public static void setSelectEnemyUnit(Unit unit) {
		selectEnemyUnit = unit;
	}

	public static void setChooseMerPanel(ChooseMerPanel chooseMerPanel) {
		GameController.chooseMerPanel = chooseMerPanel;
	}

	public static void setControlPanel(ControlPanel panel) {
		GameController.controlPanel = panel;
	}
	
	public static void startBattle() {
		GameController.mainPanel.viewBattlePanel();
		BattleController.initializeBattle();
	}
	
	public static void setMainPanel(MainPanel panel) {
		GameController.mainPanel = panel;
		selectTargetPanel = new SelectTargetSkillPanel();
		swapPanel = new SwapPanel();
		selectTargetPanel.setVisible(false);
		swapPanel.setVisible(false);
		mainPanel.getChildren().add(selectTargetPanel);
		mainPanel.getChildren().add(swapPanel);
	}
	
	public static void updateAllyInfo() {
		GameController.controlPanel.updateInfo();
	}
	
	public static void updateMapPanel() {
		GameController.controlPanel.getMapPanel().update();
		GameController.controlPanel.updateButton();
	}
	
	public static void updateBattlePanel() {
		GameController.mainPanel.updateBattlePanel();
	}
	
	public static void updateBattlePanelView() {
		GameController.mainPanel.updateBattlePanelView();
	}
	
	public static void updateAllyView() {
		GameController.mainPanel.updateAllyPanel();
	}
	
	public static void setToButtonPanel() {
		GameController.controlPanel.setToButtonPanel();
	}
	
	public static void updateEnemyInfoPanel() {
		GameController.controlPanel.setToEnemyInfoPanel();
	}
	
	public static void setNewWave() {
		GameController.mainPanel.setNewWave();
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

	public static void viewStage() {
		mainPanel.viewStage();
	}
	
	public static void viewAllyUnit() {
		mainPanel.viewAllyPane();
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static Coordinate getPlayerCoordinate() {
		return player.getCoordinate();
	}

	public static void movePlayer(Coordinate coordinate) {
		player.Move(coordinate);
	}
	
	public static Map getMap() {
		return gameMap;
	}

	public static Stage getNowStage() {
		return gameMap.getStage(GameController.getPlayerCoordinate());
	}
	
	public static void setMoveToggle(boolean bool) {
		moveToggle = bool;
	}
	
	public static boolean getMoveToggle() {
		return moveToggle;
	}
	
	public static void setOnBattle(boolean bool) {
		onBattle = bool;
	}
	
	public static boolean getOnBattle() {
		return onBattle;
	}
	
	public static void updateInventory() {
		controlPanel.updateInventoryPanel();
	}
	
	public static void setSelectTarget(boolean bool) {
		if(bool) {
			selectTargetPanel.update();
		}
		selectTargetPanel.setVisible(bool);
	}
	
	public static void setSwapPanel(boolean bool) {
		if(bool) {
			swapPanel.update();
		}
		swapPanel.setVisible(bool);
	}

}
