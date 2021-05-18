package logic;

import Application.Main;
import Application.Player;
import Coordinate.Coordinate;
import Item.Item;
import List.AllyUnitList_Saber;
import Map.*;
import UnitBase.*;
import gui.ChooseMerPanel;
import gui.ControlPanel;
import gui.InfoItem;
import gui.InfoMercenary;
import gui.InventoryPanel;
import gui.MainPanel;
import gui.ReplacePanel;
import gui.SelectTargetSkillPanel;
import gui.SwapPanel;
import javafx.scene.canvas.Canvas;

public class GameController {

	private static Player player;
	private static AllyUnit[] units;

	private static Map gameMap;
	private static AllyUnit selectAllyUnit;
	private static AllyUnit deathUnit;
	private static Unit selectEnemyUnit;
	
	private static Item selectItem;

	private static ChooseMerPanel chooseMerPanel;
	private static ControlPanel controlPanel;
	private static MainPanel mainPanel;
	private static SelectTargetSkillPanel selectTargetPanel;
	private static SwapPanel swapPanel;
	private static ReplacePanel replacePanel;
	private static InfoItem infoItem;
	private static InfoMercenary infoMercenary;

	private static boolean moveToggle = false;
	private static boolean onBattle = false;

	public static void Intialize() {
		gameMap = new Map();
		units = new AllyUnit[6];
	}

	public static boolean isUnitExist(AllyUnit unit) {
		for (int i = 0; i < 3; i++) {
			if (unit.equals(player.getUnits()[i]))
				return true;
		}
		for (int i = 0; i < 3; i++) {
			if (unit.equals(player.getBackUnits()[i]))
				return true;
		}
		return false;
	}

	public static AllyUnit[] getUnits() {
		return units;
	}

	public static void addUnits(AllyUnit unit) throws Exception {
		if (player.getNumberOfUnit() < 6) {
			for (int i = 0; i < 3; i++) {
				if (player.getUnits()[i] == null) {
					player.getUnits()[i] = unit;
					updateAllyView();
					return;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (player.getBackUnits()[i] == null) {
					player.getBackUnits()[i] = unit;
					updateAllyView();
					return;
				}
			}
		} else {
			throw new Exception();
		}
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

	public static AllyUnit getDeathUnit() {
		return deathUnit;
	}

	public static void setDeathUnit(AllyUnit unit) {
		deathUnit = unit;
	}

	public static Unit getSelectEnemyUnit() {
		return selectEnemyUnit;
	}

	public static void setSelectEnemyUnit(Unit unit) {
		selectEnemyUnit = unit;
	}
	
	public static Item getSelecItem() {
		return selectItem;
	}
	
	public static void setSelectItem(Item item) {
		selectItem = item;
	}

	public static void setChooseMerPanel(ChooseMerPanel chooseMerPanel) {
		GameController.chooseMerPanel = chooseMerPanel;
	}

	public static void setControlPanel(ControlPanel panel) {
		GameController.controlPanel = panel;
	}

	public static MainPanel getMainPanel() {
		return mainPanel;
	}

	public static void startBattle() {
		GameController.mainPanel.viewBattlePanel();
		BattleController.initializeBattle();
	}

	public static void setMainPanel(MainPanel panel) {
		GameController.mainPanel = panel;
		setDeathUnit(null);

		selectTargetPanel = new SelectTargetSkillPanel();
		swapPanel = new SwapPanel();
		replacePanel = new ReplacePanel();
		infoItem = new InfoItem();
		infoMercenary = new InfoMercenary();

		selectTargetPanel.setVisible(false);
		swapPanel.setVisible(false);
		replacePanel.setVisible(false);
		infoItem.setVisible(false);
		infoMercenary.setVisible(false);

		mainPanel.getChildren().add(selectTargetPanel);
		mainPanel.getChildren().add(swapPanel);
		mainPanel.getChildren().add(replacePanel);
		mainPanel.getChildren().add(infoItem);
		mainPanel.getChildren().add(infoMercenary);
		setChooseIcon();
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

	public static void setChooseIcon() {
		mainPanel.setChooseIcon();
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
		if (bool) {
			selectTargetPanel.update();
		}
		selectTargetPanel.setVisible(bool);
	}

	public static void setSwapPanel(boolean bool) {
		if (bool) {
			swapPanel.update();
		}
		swapPanel.setVisible(bool);
	}

	public static void setReplacePanel(boolean bool) {
		if (bool) {
			replacePanel.update();
		}
		replacePanel.setVisible(bool);
	}

	public static void showItemInfo(boolean bool, Item item, boolean onShop, boolean isPotion) {
		if (bool) {
			infoItem.update(item, onShop, isPotion);
		}
		if (!onShop) {
			infoItem.showButtons(isPotion);
		} else {
			infoItem.removeButton();
		}
		infoItem.setVisible(bool);
	}

	public static void showMercenaryInfo(boolean bool, AllyUnit unit) {
		if (bool) {
			infoMercenary.update(unit);
		}
		infoMercenary.setVisible(bool);
	}
}
