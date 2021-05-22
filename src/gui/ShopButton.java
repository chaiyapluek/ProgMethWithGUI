package gui;

import Item.Gear;
import Item.Item;
import Item.Potion;
import List.AllyUnitList;
import Unit.AllyUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class ShopButton extends HBox {

	private boolean isBought = false;

	public ShopButton(Object o) {

		this.setAlignment(Pos.CENTER_LEFT);
		this.setSpacing(10);

		StackPane pic = new StackPane();
		pic.setAlignment(Pos.CENTER);
		pic.setMaxSize(47, 47);
		pic.setMinSize(47, 47);
		pic.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Button info = new Button("Info");
		info.setFont(new Font("Arial", 12));
		Button buy = new Button("Buy");
		buy.setFont(new Font("Arial", 12));

		info.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				info.setCursor(Cursor.HAND);
			}
		});
		info.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				info.setCursor(Cursor.DEFAULT);
			}
		});
		buy.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buy.setCursor(Cursor.HAND);
			}
		});
		buy.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				buy.setCursor(Cursor.DEFAULT);
			}
		});
		
		if (o instanceof Item) {
			Item item = (Item) o;
			Image img = new Image(item.getUrl());
			ImageView view = new ImageView(img);
			view.setFitHeight(45);
			view.setPreserveRatio(true);
			pic.getChildren().add(view);

			info.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					GameController.showItemInfo(true, item, true, true, false);
				}
			});

			buy.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (GameController.getPlayer().getMoney() < item.getPrice()) {
						GameController.showAleart(true, "Not enough money");
						return;
					}
					try {
						if (item instanceof Gear) {
							GameController.getPlayer().getInventory().addToInventory(item);
							GameController.getNowStage().getShop().updateMark(item);
							isBought = true;
						} else {
							if (GameController.getPlayer().getInventory().isPotionExist((Potion) item) == false) {
								GameController.getPlayer().getInventory().addToInventory(item);
							} else {
								for (int i = 0; i < GameController.getPlayer().getInventory().getInventorySize(); i++) {
									if (GameController.getPlayer().getInventory().getInventory()
											.get(i) instanceof Potion
											&& ((Potion) item).equals(
													GameController.getPlayer().getInventory().getInventory().get(i))) {
										((Potion) GameController.getPlayer().getInventory().getInventory().get(i))
												.setNumberOfPotion(((Potion) GameController.getPlayer().getInventory()
														.getInventory().get(i)).getNumberOfPotion() + 1);
									}
								}
								GameController.updateInventory();
							}
						}
						GameController.playSound(GameController.getBuySound());
						GameController.getPlayer().setMoney(GameController.getPlayer().getMoney() - item.getPrice());
						GameController.boughtItem();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						GameController.showAleart(true, "Inventory full");
					}
					GameController.updateInventory();
				}
			});
			this.getChildren().addAll(pic, info, buy);
		} else if (o instanceof AllyUnit) {

			AllyUnit allyUnit = (AllyUnit) o;
			Image img = new Image(allyUnit.getIconUrl());
			ImageView view = new ImageView(img);
			view.setFitHeight(45);
			view.setPreserveRatio(true);
			pic.getChildren().add(view);

			info.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					GameController.showMercenaryInfo(true, allyUnit);
				}
			});

			buy.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					if (GameController.getPlayer().getMoney() < 5000) {
						GameController.showAleart(true, "Not enough money");
						return;
					}
					// TODO Auto-generated method stub
					if (!GameController.isUnitExist(allyUnit)) {
						try {
							int idx = AllyUnitList.getAllUnit().indexOf(allyUnit);
							AllyUnit addedUnit = AllyUnitList.getAllUnit().get(idx);
							GameController.addUnits(addedUnit);
							GameController.setSelectAllyUnit(addedUnit);
							GameController.updateAllyInfo();
							GameController.setChooseIcon();
							GameController.getNowStage().getShop().updateMark(allyUnit);
							GameController.getPlayer().setMoney(GameController.getPlayer().getMoney() - 5000);
							isBought = true;
							GameController.boughtItem();
							GameController.playSound(GameController.getBuySound());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < GameController.getPlayer().getUnits().length; i++) {
							if (allyUnit.equals(GameController.getPlayer().getUnits()[i])
									&& GameController.getPlayer().getUnits()[i].getLevel() < 5) {
								GameController.getPlayer().getUnits()[i].levelup();
								GameController.setSelectAllyUnit(GameController.getPlayer().getUnits()[i]);
								GameController.updateAllyInfo();
								GameController.setChooseIcon();
								GameController.getNowStage().getShop().updateMark(allyUnit);
								GameController.getPlayer().setMoney(GameController.getPlayer().getMoney() - 5000);
								isBought = true;
								GameController.boughtItem();
								GameController.playSound(GameController.getBuySound());
							}
						}
						for (int i = 0; i < GameController.getPlayer().getBackUnits().length; i++) {
							if (allyUnit.equals(GameController.getPlayer().getBackUnits()[i])
									&& GameController.getPlayer().getBackUnits()[i].getLevel() < 5) {
								GameController.getPlayer().getBackUnits()[i].levelup();
								GameController.setSelectAllyUnit(GameController.getPlayer().getBackUnits()[i]);
								GameController.updateAllyInfo();
								GameController.setChooseIcon();
								GameController.getNowStage().getShop().updateMark(allyUnit);
								GameController.getPlayer().setMoney(GameController.getPlayer().getMoney() - 5000);
								isBought = true;
								GameController.boughtItem();
								GameController.playSound(GameController.getBuySound());
							}
						}
					}
					GameController.updateInventory();
				}
			});
			this.getChildren().addAll(pic, info, buy);
		}

	}

	public boolean getIsBought() {
		return isBought;
	}

}
