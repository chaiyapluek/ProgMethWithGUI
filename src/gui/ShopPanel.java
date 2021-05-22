package gui;

import Item.Item;
import Shop.Shop;
import Unit.AllyUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class ShopPanel extends VBox {

	private Label money;
	private ObservableList<ShopButton> shopButtons = FXCollections.observableArrayList();
	private VBox root;

	private ScrollPane shopPane;
	private Shop shop;

	public ShopPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);

		BorderPane backPanel = new BorderPane();
		backPanel.setMaxSize(400, 60);
		backPanel.setMinSize(400, 60);
		backPanel.setPadding(new Insets(25));
		money = new Label();
		money.setFont(new Font("Arial Black", 16));
		setMoneyText();
		Button back = new Button();
		GameController.setBackButton(back);
		backPanel.setAlignment(money, Pos.CENTER);
		backPanel.setAlignment(back, Pos.CENTER);
		backPanel.setLeft(money);
		backPanel.setRight(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setToButtonPanel();
			}
		});
		this.getChildren().add(backPanel);

		shopPane = new ScrollPane();

		root = new VBox();
		root.setAlignment(Pos.CENTER_LEFT);
		root.setSpacing(10);
		root.setMaxWidth(250);
		root.setMinWidth(250);
		root.setPadding(new Insets(20));

		shop = new Shop();
		Label itemLabel = new Label("Items");
		itemLabel.setFont(new Font("Arial Black", 16));
		root.getChildren().add(itemLabel);
		for (int i = 0; i < 10; i++) {
			Item item = shop.getItems()[i];
			ShopButton button = new ShopButton(item);
			root.getChildren().add(button);
			shopButtons.add(button);
		}
		Label unitLabel = new Label("Mercenaries");
		unitLabel.setFont(new Font("Arial Black", 16));
		root.getChildren().add(unitLabel);
		for (int i = 0; i < 10; i++) {
			AllyUnit allyUnit = shop.getAllyUnits()[i];
			ShopButton button = new ShopButton(allyUnit);
			root.getChildren().add(button);
			shopButtons.add(button);
		}

		shopPane.setContent(root);
		this.getChildren().add(shopPane);
	}

	public void setMoneyText() {
		money.setText("Money : " + GameController.getPlayer().getMoney());
	}

	public void removeItem() {
		for (ShopButton button : shopButtons) {
			if (button.getIsBought()) {
				root.getChildren().remove(button);
			}
		}
	}

	public void update() {

		if (GameController.getNowStage().isHasShop()) {
			Shop shop = GameController.getNowStage().getShop();
			root.getChildren().clear();
			shopButtons.clear();
			Label itemLabel = new Label("Items");
			itemLabel.setFont(new Font("Arial Black", 16));
			root.getChildren().add(itemLabel);
			for (int i = 0; i < 10; i++) {
				if (shop.getMarkItem(i)) {
					continue;
				}
				Item item = shop.getItems()[i];
				ShopButton button = new ShopButton(item);
				root.getChildren().add(button);
				shopButtons.add(button);
			}
			Label unitLabel = new Label("Mercenaries");
			unitLabel.setFont(new Font("Arial Black", 16));
			root.getChildren().add(unitLabel);
			for (int i = 0; i < 10; i++) {
				AllyUnit allyUnit = shop.getAllyUnits()[i];
				if (shop.getMarkUnit(i)) {
					continue;
				}
				ShopButton button = new ShopButton(allyUnit);
				root.getChildren().add(button);
				shopButtons.add(button);
			}
		}

	}

}
