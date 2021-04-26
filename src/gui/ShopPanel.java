package gui;

import Item.Gear;
import Item.Item;
import Item.Potion;
import Shop.Shop;
import UnitBase.AllyUnit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.GameController;

public class ShopPanel extends VBox {

	public ShopPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		

		HBox backPanel = new HBox();
		backPanel.setAlignment(Pos.CENTER_RIGHT);
		Label money = new Label();
		money.setText("Money : XXX");
		money.setPadding(new Insets(0,250,0,0));
		Button back = new Button("X");
		backPanel.getChildren().add(money);
		backPanel.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
			}
		});
		this.getChildren().add(backPanel);
		
		ScrollPane shopPane = new ScrollPane();
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setSpacing(10);
		root.setMaxWidth(250);
		root.setMinWidth(250);
		root.setPadding(new Insets(10));
		
		Shop shop = new Shop();
		Label itemLabel = new Label("Items");
		root.getChildren().add(itemLabel);
		for (int i = 0; i < 10; i++) {
			Item item = shop.getItems()[i];
			HBox hbox = new HBox();
			Button button = new Button();
			button.setMaxSize(45, 45);
			button.setMinSize(45, 45);
			//System.out.println(item.getUrl());
			Image img = new Image(item.getUrl());
		    ImageView view = new ImageView(img);
		    view.setFitHeight(45);
		    view.setPreserveRatio(true);
		    button.setGraphic(view);
			Button info = new Button("Info");
			info.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Item Information");
					alert.setHeaderText(item.getName());
					alert.setContentText(item.toString());

					alert.showAndWait();
				}
			});
			Button buy = new Button("Buy");
			buy.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						if(item instanceof Gear) {
							GameController.getPlayer().getInventory().addToInventory(item);
						}
						else {
							if(GameController.getPlayer().getInventory().isPotionExist((Potion) item)==false) {
								GameController.getPlayer().getInventory().addToInventory(item);
							}
							else {
								for(int i=0;i<GameController.getPlayer().getInventory().getInventorySize();i++) {
									if(GameController.getPlayer().getInventory().getInventory().get(i) instanceof Potion && ((Potion)item).equals(GameController.getPlayer().getInventory().getInventory().get(i))) {
										((Potion)GameController.getPlayer().getInventory().getInventory().get(i)).setNumberOfPotion(((Potion)GameController.getPlayer().getInventory().getInventory().get(i)).getNumberOfPotion()+1);
									}
								}
								GameController.updateInventory();
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					GameController.updateInventory();
				}
			});
			hbox.getChildren().add(button);
			hbox.getChildren().add(info);
			hbox.getChildren().add(buy);
			hbox.setAlignment(Pos.CENTER_LEFT);
			hbox.setSpacing(10);
			root.getChildren().add(hbox);
		}
		Label unitLabel = new Label("Mercenaries");
		root.getChildren().add(unitLabel);
		for (int i = 0; i < 10; i++) {
			AllyUnit allyUnit = shop.getAllyUnits()[i];
			HBox hbox = new HBox();
			Button button = new Button();
			button.setMaxSize(45, 45);
			button.setMinSize(45, 45);
			Image img = new Image(allyUnit.getIconUrl());
		    ImageView view = new ImageView(img);
		    view.setFitHeight(45);
		    view.setPreserveRatio(true);
		    button.setGraphic(view);
			Button info = new Button("Info");
			info.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Unit Information");
					alert.setHeaderText(allyUnit.getName());
					alert.setContentText(allyUnit.getShopInfo());

					alert.showAndWait();
				}
			});
			Button buy = new Button("Buy");
			buy.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					
					// TODO Auto-generated method stub
					if(!GameController.isUnitExist(allyUnit)) {
						try {
							GameController.addUnits(allyUnit);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						for(int i=0;i<GameController.getUnitsNumber();i++) {
							if(allyUnit.equals(GameController.getUnits()[i])) {
								GameController.getUnits()[i].levelup();
							}
						}
					}
					GameController.updateInventory();
				}
			});
			hbox.getChildren().add(button);
			hbox.getChildren().add(info);
			hbox.getChildren().add(buy);
			hbox.setAlignment(Pos.CENTER_LEFT);
			hbox.setSpacing(10);
			root.getChildren().add(hbox);
		}

		shopPane.setContent(root);
		this.getChildren().add(shopPane);
	}
	
}
