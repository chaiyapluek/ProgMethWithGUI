package gui;

import java.util.Optional;

import Item.Gear;
import Item.Item;
import Item.Potion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	private Item item;
	private int i,j;
	private GridPane inventory;
	
	public InventoryPanel() {

		this.setMaxSize(400, 300);
		this.setMinSize(400, 300);
		this.setPadding(new Insets(20));
		this.setSpacing(30);
		this.setAlignment(Pos.TOP_CENTER);

		HBox backPanel = new HBox();
		backPanel.setAlignment(Pos.CENTER_RIGHT);
		Button back = new Button("X");
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
				new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Label money = new Label();
		money.setText("Money : XXX ");
		inventory = new GridPane();
		inventory.setAlignment(Pos.CENTER);
		inventory.setVgap(10);
		inventory.setHgap(10);
		Button itemButton[] = new Button[10];
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 5; j++) {
				if(i*5+j>=GameController.getPlayer().getInventory().getInventorySize()) {
					itemButton[i*5+j] = new Button();
					itemButton[i*5+j].setMaxSize(60, 60);
					itemButton[i*5+j].setMinSize(60, 60);
					inventory.add(itemButton[i*5+j], j, i);
					continue;
				}
				// item button (didn't create yet cus so lazy =.=)
				if(GameController.getPlayer().getInventory().getInventorySize()>i*5+j)
					item = GameController.getPlayer().getInventory().getInventory().get(i*5+j);
				itemButton[i*5+j] = new Button();
				Image img = new Image(item.getUrl());
			    ImageView view = new ImageView(img);
			    view.setFitHeight(45);
			    view.setPreserveRatio(true);
			    itemButton[i*5+j].setGraphic(view);
				itemButton[i*5+j].setMaxSize(60, 60);
				itemButton[i*5+j].setMinSize(60, 60);
				itemButton[i*5+j].setOnAction(new EventHandler<ActionEvent>() {
					int select = i*5+j;
					int ii=i,jj=j;
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Alert alert = new Alert(AlertType.INFORMATION);
						item = GameController.getPlayer().getInventory().getInventory().get(select);
						if(item instanceof Potion) {
							alert.setTitle("Potion");
							alert.setHeaderText(item.getName());
							alert.setContentText(item.toString());
							ButtonType use = new ButtonType("Use");
							ButtonType cancel = new ButtonType("Cancel");
							alert.getButtonTypes().clear();
							alert.getButtonTypes().addAll(use,cancel);
							Optional<ButtonType> option = alert.showAndWait();
							if (option.get() == use) {
								try {
									//System.out.println(i);
									((Potion)GameController.getPlayer().getInventory().getInventory().get(ii*5+jj)).healUnit(GameController.getSelectAllyUnit());
									if(((Potion)GameController.getPlayer().getInventory().getInventory().get(ii*5+jj)).getNumberOfPotion()>1) {
									}
									else {
										GameController.getPlayer().getInventory().removeFromInventory(ii*5+jj);
									}
									GameController.updateInventory();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
						}
						else if(item instanceof Gear) {
							alert.setTitle("Gear");
							alert.setHeaderText(item.getName());
							alert.setContentText(item.toString());

							alert.showAndWait();
						}
					}
				});
				inventory.add(itemButton[i*5+j], j, i);
			}
		}
		panel.getChildren().addAll(money, inventory);
		this.getChildren().addAll(backPanel, panel);
	}
	
	public void update() {
		Button itemButton[] = new Button[10];
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 5; j++) {
				//System.out.println(i);
				if(i*5+j>=GameController.getPlayer().getInventory().getInventorySize()) {
					itemButton[i*5+j] = new Button();
					itemButton[i*5+j].setMaxSize(60, 60);
					itemButton[i*5+j].setMinSize(60, 60);
					inventory.add(itemButton[i*5+j], j, i);
					continue;
				}
				// item button (didn't create yet cus so lazy =.=)
				//System.out.println(GameController.getPlayer().getInventory().getInventorySize()+" "+(i*5+j));
				if(GameController.getPlayer().getInventory().getInventorySize()>i*5+j)
					item = GameController.getPlayer().getInventory().getInventory().get(i*5+j);
				itemButton[i*5+j] = new Button();
				Image img = new Image(item.getUrl());
			    ImageView view = new ImageView(img);
			    view.setFitHeight(45);
			    view.setPreserveRatio(true);
			    itemButton[i*5+j].setGraphic(view);
				itemButton[i*5+j].setMaxSize(60, 60);
				itemButton[i*5+j].setMinSize(60, 60);
				itemButton[i*5+j].setOnAction(new EventHandler<ActionEvent>() {
					int select = i*5+j;
					int ii=i,jj=j;
					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Alert alert= new Alert(AlertType.INFORMATION);
						item = GameController.getPlayer().getInventory().getInventory().get(select);
						if(item instanceof Potion) {
							alert.setTitle("Potion");
							alert.setHeaderText(item.getName());
							alert.setContentText(item.toString());
							ButtonType use = new ButtonType("Use");
							ButtonType cancel = new ButtonType("Cancel");
							alert.getButtonTypes().clear();
							alert.getButtonTypes().addAll(use,cancel);
							Optional<ButtonType> option = alert.showAndWait();
							//System.out.println(i);
							if (option.get() == use) {
								try {
									//System.out.println(i);
									((Potion)GameController.getPlayer().getInventory().getInventory().get(ii*5+jj)).healUnit(GameController.getSelectAllyUnit());
									if(((Potion)GameController.getPlayer().getInventory().getInventory().get(ii*5+jj)).getNumberOfPotion()>1) {
									}
									else {
										GameController.getPlayer().getInventory().removeFromInventory(ii*5+jj);
									}
									GameController.updateInventory();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
						}
						else if(item instanceof Gear) {
							alert.setTitle("Gear");
							alert.setHeaderText(item.getName());
							alert.setContentText(item.toString());
							ButtonType equip = new ButtonType("Equip");
							ButtonType discard = new ButtonType("Discard");
							ButtonType cancel = new ButtonType("Cancel");
							alert.getButtonTypes().clear();
							alert.getButtonTypes().addAll(equip,discard,cancel);
							Optional<ButtonType> option = alert.showAndWait();
							if(option.get()==discard) {
								try {
									GameController.getPlayer().getInventory().removeFromInventory(ii*5+jj);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							GameController.updateInventory();
						}
					}
				});
				inventory.add(itemButton[i*5+j], j, i);
			}
		}
	}
}