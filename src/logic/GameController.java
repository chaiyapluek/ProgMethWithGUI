package logic;

import Application.Main;
import Application.Player;
import Coordinate.Coordinate;
import Item.Item;
import Map.*;
import Unit.*;
import gui.AleartPanel;
import gui.ChooseMerPanel;
import gui.ControlPanel;
import gui.InfoItem;
import gui.InfoMercenary;
import gui.MainPanel;
import gui.ReplacePanel;
import gui.RewardPane;
import gui.SelectTargetSkillPanel;
import gui.SwapPanel;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

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
	private static AleartPanel aleartPanel;
	private static RewardPane rewardPane;
	
	private static AudioClip BGSound;
	private static AudioClip BattleSound;
	private static AudioClip buySound;
	private static AudioClip attackSound;
	private static AudioClip buffSound;

	private static boolean moveToggle = false;
	private static boolean onBattle = false;
	private static boolean isWin = false;

	public static void Intialize() {
		
		units = new AllyUnit[6];
		BGSound = new AudioClip(ClassLoader.getSystemResource("BG-sound.mp3").toString());
		BattleSound = new AudioClip(ClassLoader.getSystemResource("Battle-sound.mp3").toString());
		buySound = new AudioClip(ClassLoader.getSystemResource("buy-sound.mp3").toString());
		attackSound = new AudioClip(ClassLoader.getSystemResource("attack-sound.mp3").toString());
		buffSound = new AudioClip(ClassLoader.getSystemResource("buff-sound.mp3").toString());
		
		playBGSound();
		
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
		gameMap = new Map();
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
		aleartPanel = new AleartPanel();
		rewardPane = new RewardPane();

		selectTargetPanel.setVisible(false);
		swapPanel.setVisible(false);
		replacePanel.setVisible(false);
		infoItem.setVisible(false);
		infoMercenary.setVisible(false);
		aleartPanel.setVisible(false);
		rewardPane.setVisible(false);

		mainPanel.getChildren().add(selectTargetPanel);
		mainPanel.getChildren().add(swapPanel);
		mainPanel.getChildren().add(replacePanel);
		mainPanel.getChildren().add(infoItem);
		mainPanel.getChildren().add(infoMercenary);
		mainPanel.getChildren().add(aleartPanel);
		mainPanel.getChildren().add(rewardPane);
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
	
	public static boolean isWin() {
		return isWin;
	}
	
	public static void setIsWin(boolean bool) {
		isWin = bool;
	}

	public static void updateInventory() {
		controlPanel.getInventoryPanel().update();
	}

	public static void discardItemInInventory() {
		controlPanel.getInventoryPanel().discardItem();
	}
	
	public static void discardEquippedGear() {
		controlPanel.getInventoryPanel().discardEquippedItem();
	}

	public static void useItem() {
		controlPanel.getInventoryPanel().useItem();
	}

	public static void equipItem() {
		controlPanel.getInventoryPanel().equipItem();
	}
	
	public static void unequipItem() {
		controlPanel.getInventoryPanel().unequipItem();
	}
	
	public static void updateShop() {
		controlPanel.getShopPanel().update();
	}
	
	public static void boughtItem() {
		controlPanel.getShopPanel().setMoneyText();
		controlPanel.getShopPanel().removeItem();
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

	public static void showItemInfo(boolean bool, Item item, boolean onShop, boolean isPotion, boolean onInventory) {
		if (bool) {
			infoItem.update(item, onShop, isPotion);
			if (!onShop) {
				infoItem.showButtons(isPotion, onInventory);
			} else {
				infoItem.removeButton();
			}
		}
		infoItem.setVisible(bool);
	}

	public static void showMercenaryInfo(boolean bool, AllyUnit unit) {
		if (bool) {
			infoMercenary.update(unit);
		}
		infoMercenary.setVisible(bool);
	}

	public static void showAleart(boolean bool, String text) {
		if (bool) {
			aleartPanel.setText(text);
		}
		aleartPanel.setVisible(bool);
	}
	
	public static void showReward(boolean bool) {
		if(bool) {
			rewardPane.setText();
		}
		rewardPane.setVisible(bool);
	}
	
	public static void setBackButton(Button button) {
		ImageView backView = new ImageView(new Image("cross-icon.png"));
		backView.setFitWidth(35);
		backView.setPreserveRatio(true);
		button.setGraphic(backView);
		button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		button.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				button.setCursor(javafx.scene.Cursor.HAND);
			}
		});
		button.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				button.setCursor(javafx.scene.Cursor.DEFAULT);
			}
		});
	}
	
	public static void playBGSound() {
		BattleSound.stop();
		BGSound.setCycleCount(AudioClip.INDEFINITE);
		BGSound.play();
	}
	
	public static void playBattleSound() {
		BGSound.stop();
		BattleSound.setCycleCount(AudioClip.INDEFINITE);
		BattleSound.play();
	}
	
	public static void playSound(AudioClip sound) {
		sound.play();
	}
	
	public static AudioClip getAttackSound() {
		return attackSound;
	}
	
	public static AudioClip getBuffSound() {
		return buffSound;
	}
	
	public static AudioClip getBuySound() {
		return buySound;
	}
}
