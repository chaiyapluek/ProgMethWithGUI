package gui;

import UnitBase.AllyUnit;
import UnitBase.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;

public class ControlPanel extends HBox {

	private Pane Icon;

	private Label name;
	private Label Class;

	private Label HP;
	private Label Gauge;

	private Label def;
	private Label attack;
	private Label crit;
	private Label critdmg;
	private Label dodge;
	private Label level;

	private ActionSkillPane skillPane;

	private StackPane rightPanel;
	private VBox buttonPane;
	private Button mapButton;
	private Button inventoryButton;
	private Button shopButton;
	private Button fightButton;

	private MapPanel mapPanel;
	private InventoryPanel inventoryPanel;
	private ShopPanel shopPanel;
	private EnemyInfoPanel enemyInfo;
	private ObservableList<GearButton> gearsButton = FXCollections.observableArrayList();

	public ControlPanel(Unit u) {

		this.setMaxSize(1000, 300);
		this.setMinSize(1000, 300);
		this.setAlignment(Pos.CENTER_LEFT);
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(135, 152, 153), CornerRadii.EMPTY, Insets.EMPTY)));
		
		GridPane left = new GridPane();
		left.setPadding(new Insets(20));
		left.setHgap(10);
		left.setVgap(10);
		left.setAlignment(Pos.CENTER_LEFT);
		left.setMinSize(600, 300);
		left.setMaxSize(600, 300);
		left.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Icon = new Pane();
		Icon.setBorder(new Border(
				new BorderStroke(Color.AQUAMARINE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		Icon.setMinSize(75, 75);
		Icon.setMaxSize(75, 75);
		setIcon();

		VBox NameAndClass = new VBox();
		NameAndClass.setMinWidth(150);
		NameAndClass.setMaxWidth(150);
		NameAndClass.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		NameAndClass.setAlignment(Pos.CENTER_RIGHT);
		NameAndClass.setPadding(new Insets(5));
		name = new Label(u.getName());
		Class = new Label(u.get_Class());
		name.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Class.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		NameAndClass.getChildren().addAll(name, Class);

		AllyUnit unit = (AllyUnit) u;
		VBox HPAndGauge = new VBox();
		HPAndGauge.setAlignment(Pos.CENTER_LEFT);
		HPAndGauge.setPadding(new Insets(5));
		HPAndGauge.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HP = new Label("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());
		Gauge = new Label("GAUGE : " + unit.getUltiGauge() + "/" + unit.getMaxUltigauge());
		HP.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		Gauge.setStyle("-fx-font-size: 14px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		HPAndGauge.getChildren().addAll(HP, Gauge);

		VBox Stats = new VBox();
		Stats.setPadding(new Insets(5));
		Stats.setAlignment(Pos.CENTER_LEFT);
		def = new Label("Defense : " + Math.max(0, unit.getDefense()));
		attack = new Label("Attack : " + unit.getTotalAttack());
		crit = new Label("CritChance : " + Math.max(0, unit.getCritChance()));
		critdmg = new Label("CritDamage : " + Math.max(0, unit.getCritDamage()));
		dodge = new Label("Dodge : " + Math.max(0, unit.getDodgeChance()));
		level = new Label("Level : " + unit.getLevel());
		def.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		attack.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		crit.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		critdmg.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		dodge.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		level.setStyle("-fx-font-size: 12px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");

		Stats.getChildren().addAll(attack, def, crit, critdmg, dodge, level);
		Stats.setBorder(new Border(
				new BorderStroke(Color.GOLD, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		Stats.setPadding(new Insets(5));
		ActionPane actionPane = new ActionPane();
		skillPane = new ActionSkillPane();

		left.add(Icon, 0, 0, 1, 1);
		left.add(NameAndClass, 1, 0, 2, 1);
		left.add(actionPane, 3, 0, 4, 1);
		left.add(HPAndGauge, 0, 1, 2, 1);
		left.add(skillPane, 3, 1, 4, 1);
		left.add(Stats, 0, 2, 2, 2);

		HBox gearsPane = new HBox();
		gearsPane.setSpacing(10);
		gearsPane.setAlignment(Pos.CENTER_LEFT);

		for (int i = 0; i < 5; i++) {
			GearButton button = new GearButton();
			gearsPane.getChildren().add(button);
			gearsButton.add(button);
		}
		left.add(gearsPane, 2, 2, 5, 2);

		this.rightPanel = rightPanel();

		mapButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rightPanel.getChildren().clear();
				rightPanel.getChildren().add(mapPanel);
			}
		});

		inventoryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				rightPanel.getChildren().clear();
				rightPanel.getChildren().add(inventoryPanel);
			}
		});

		shopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (GameController.getNowStage().isClear()) {
					rightPanel.getChildren().clear();
					rightPanel.getChildren().add(shopPanel);
					shopPanel.setMoneyText();
				}else {
					GameController.showAleart(true, "This stage is not clear yet.");
				}
			}
		});

		fightButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GameController.setOnBattle(true);
				GameController.startBattle();
			}

		});

		setButton(mapButton);
		setButton(inventoryButton);
		setButton(shopButton);
		setButton(fightButton);
		
		this.getChildren().add(left);
		this.getChildren().add(rightPanel);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		rightPanel.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	private void setButton(Button button) {
		button.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		button.setFont(new Font("Arial Black",15));
		button.setBackground(new Background(new BackgroundFill(Color.rgb(255, 207, 72), CornerRadii.EMPTY, Insets.EMPTY)));
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
				button.setCursor(Cursor.HAND);
			}
		});
	}

	private StackPane rightPanel() {
		StackPane pane = new StackPane();
		pane.setMaxSize(400, 300);
		pane.setMinSize(400, 300);
		pane.setAlignment(Pos.CENTER);

		buttonPane = new VBox();
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(10);

		mapButton = new Button("MAP");
		inventoryButton = new Button("INVENTORY");
		shopButton = new Button("SHOP");
		fightButton = new Button("FIGHT");

		setButtonProp(mapButton);
		setButtonProp(inventoryButton);
		setButtonProp(shopButton);
		setButtonProp(fightButton);

		updateButton();

		pane.getChildren().add(buttonPane);

		mapPanel = new MapPanel();
		inventoryPanel = new InventoryPanel();
		shopPanel = new ShopPanel();
		enemyInfo = new EnemyInfoPanel();

		return pane;
	}

	public void setToButtonPanel() {
		rightPanel.getChildren().clear();
		rightPanel.getChildren().add(buttonPane);
	}

	public void setToEnemyInfoPanel() {
		rightPanel.getChildren().clear();
		enemyInfo.update();
		rightPanel.getChildren().add(enemyInfo);
	}

	public void updateButton() {
		buttonPane.getChildren().clear();
		buttonPane.getChildren().addAll(mapButton, inventoryButton);
		if (GameController.getNowStage().isHasShop()) {
			buttonPane.getChildren().add(shopButton);
		} else {
			buttonPane.getChildren().remove(shopButton);
		}
		if (!GameController.getNowStage().isClear()) {
			buttonPane.getChildren().add(fightButton);
		} else {
			buttonPane.getChildren().remove(fightButton);
		}
	}

	public void setButtonProp(Button button) {
		button.setMaxSize(200, 40);
		button.setMinSize(200, 40);
	}

	public void updateInfo() {
		updateLabel();
		setIcon();
		skillPane.update();
		updateGear();
	}

	public void updateGear() {
		AllyUnit unit = GameController.getSelectAllyUnit();
		int cnt = 0;
		for (GearButton button : gearsButton) {
			button.setGear(unit.getGears()[cnt]);
			button.update();
			cnt++;
		}

	}

	public void setIcon() {
		Icon.setBackground(
				new Background(new BackgroundImage(new Image(GameController.getSelectAllyUnit().getIconUrl()),
						BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						new BackgroundSize(0, 100, false, true, false, true))));
	}

	private void updateLabel() {
		AllyUnit unit = GameController.getSelectAllyUnit();
		name.setText(unit.getName());
		Class.setText(unit.get_Class());

		HP.setText("HP : " + unit.getCurrentHP() + "/" + unit.getMaxHP());
		Gauge.setText("GAUGE : " + unit.getUltiGauge() + "/" + unit.getMaxUltigauge());

		def.setText("Defense : " + Math.max(0, unit.getDefense()));
		attack.setText("Attack : " + unit.getTotalAttack());
		crit.setText("CritChance : " + Math.max(0, unit.getCritChance()));
		critdmg.setText("CritDamage : " + Math.max(0, unit.getCritDamage()));
		dodge.setText("Dodge : " + Math.max(0, unit.getDodgeChance()));
		level.setText("Level : " + unit.getLevel());
	}

	public MapPanel getMapPanel() {
		return mapPanel;
	}

	public InventoryPanel getInventoryPanel() {
		return inventoryPanel;
	}
	
	public ShopPanel getShopPanel() {
		return shopPanel;
	}
}
