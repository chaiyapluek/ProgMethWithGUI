package gui;


import Item.Gear;
import Item.Item;
import Item.Potion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;

public class InventoryPanel extends VBox {

	private GridPane inventory;

	public InventoryPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(10));
		this.setSpacing(15);
		this.setAlignment(Pos.TOP_CENTER);

		HBox backPanel = new HBox();
		backPanel.setAlignment(Pos.CENTER_RIGHT);
		Button back = new Button();
		GameController.setBackButton(back);
		backPanel.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
			}
		});

		VBox panel = new VBox();
		panel.setAlignment(Pos.CENTER_LEFT);
		panel.setSpacing(10);
		panel.setPadding(new Insets(10));
		panel.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		inventory = new GridPane();
		inventory.setAlignment(Pos.CENTER);
		inventory.setVgap(10);
		inventory.setHgap(10);
		update();

		panel.getChildren().addAll(inventory);
		this.getChildren().addAll(backPanel, panel);
	}

	public void update() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				int idx = 5 * i + j;
				Button button = new Button();
				button.setMaxSize(60, 60);
				button.setMinSize(60, 60);
				button.setBorder(new Border(
						new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
				button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				inventory.add(button, j, i);
				if (idx >= GameController.getPlayer().getInventory().getInventorySize()) {
					continue;
				}
				Item item = GameController.getPlayer().getInventory().getInventory().get(idx);
				Image img = new Image(item.getUrl());
				ImageView view = new ImageView(img);
				view.setFitHeight(45);
				button.setGraphic(view);
				view.setPreserveRatio(true);
				button.setOnMouseEntered(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						button.setCursor(Cursor.HAND);
					}
				});
				button.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						button.setCursor(Cursor.DEFAULT);
					}
				});
				button.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						GameController.setSelectItem(item);
						if (item instanceof Potion) {
							GameController.showItemInfo(true, item, false, true, true);
						} else {
							GameController.showItemInfo(true, item, false, false, true);
						}
					}
				});
			}
		}
	}

	public void useItem() {
		try {
			Potion potion = (Potion) GameController.getSelecItem();
			potion.healUnit(GameController.getSelectAllyUnit());
			if (potion.getNumberOfPotion() == 0) {
				int idx = GameController.getPlayer().getInventory().getInventory()
						.indexOf(GameController.getSelecItem());
				GameController.getPlayer().getInventory().removeFromInventory(idx);
			}
			GameController.updateInventory();
			GameController.updateAllyInfo();
			GameController.showItemInfo(false, null, false, false, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void discardItem() {
		try {
			int idx = GameController.getPlayer().getInventory().getInventory().indexOf(GameController.getSelecItem());
			GameController.getPlayer().getInventory().removeFromInventory(idx);
			GameController.updateInventory();
			GameController.showItemInfo(false, null, false, false, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void equipItem() {
		Gear gear = (Gear) GameController.getSelecItem();
		int idx = gear.getType();
		if (GameController.getSelectAllyUnit().getGears()[idx] == null) {
			gear.equip(GameController.getSelectAllyUnit());
			GameController.getSelectAllyUnit().getGears()[gear.getType()] = gear;
			discardItem();
		} else {
			Gear old = GameController.getSelectAllyUnit().getGears()[idx];
			old.unequip(GameController.getSelectAllyUnit());
			gear.equip(GameController.getSelectAllyUnit());
			GameController.getSelectAllyUnit().getGears()[idx] = gear;
			discardItem();
			try {
				GameController.getPlayer().getInventory().addToInventory(old);
			} catch (Exception e) {

			}
			GameController.updateInventory();
		}
		GameController.updateAllyInfo();
	}

	public void unequipItem() {
		try {
			Gear gear = (Gear) GameController.getSelecItem();
			GameController.getPlayer().getInventory().addToInventory(gear);
			gear.unequip(GameController.getSelectAllyUnit());
			GameController.getSelectAllyUnit().getGears()[gear.getType()] = null;
			GameController.updateAllyInfo();
			GameController.updateInventory();
			GameController.showItemInfo(false, null, false, false, false);
		}catch(Exception e) {
			GameController.showAleart(true, "Inventory full");
		}
	}
	
	public void discardEquippedItem() {
		Gear gear = (Gear) GameController.getSelecItem();
		gear.unequip(GameController.getSelectAllyUnit());
		GameController.getSelectAllyUnit().getGears()[gear.getType()] = null;
		GameController.updateAllyInfo();
		GameController.updateInventory();
		GameController.showItemInfo(false, null, false, false, false);
	}
}