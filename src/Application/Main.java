package Application;

import java.util.Scanner;

import Coordinate.Coordinate;
import List.AllyUnitList_Archer;
import List.AllyUnitList_Lancer;
import List.AllyUnitList_Saber;
import gui.MercenaryPanel;
import gui.ChooseMerPanel;
import gui.MainPanel;
import gui.MercenaryCell;
import gui.StatsPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameController;

public class Main extends Application{

	static Scanner s = new Scanner(System.in);
	private static Stage stage;
	
	private static Scene initialScene;
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
		GameController.Intialize();
		createInitialScene();
		
		primaryStage.setScene(initialScene);
		primaryStage.setTitle("Test Project");
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}
	
	public void createInitialScene() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		ChooseMerPanel p = new ChooseMerPanel();
		root.getChildren().add(p);
		GameController.setChooseMerPanel(p);
		
		initialScene = new Scene(root,1280,720);
	}
	
	public static void createMainScene() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		MainPanel p = new MainPanel(GameController.getPlayer());
		root.getChildren().add(p);
		
		mainScene = new Scene(root,1280,720);
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void movePlayer() {
		while (true) {
			System.out.println(GameController.getPlayerCoordinate());
			System.out.println("Select direction to move");
			System.out.println("[1] Up");
			System.out.println("[2] Down");
			System.out.println("[3] Left");
			System.out.println("[4] Right");
			System.out.println("[0] Back");
			int opr = getOneInt();
			if (opr < 0 || opr > 4) {
				System.out.println("Invalid Input");
				continue;
			}
			Coordinate now = GameController.getPlayerCoordinate();
			Coordinate next = new Coordinate(0, 0);
			if (opr == 0) {
				break;
			}
			switch (opr) {
			case 1:
				next = new Coordinate(now.getX() - 1, now.getY());
				break;
			case 2:
				next = new Coordinate(now.getX() + 1, now.getY());
				break;
			case 3:
				next = new Coordinate(now.getX(), now.getY() - 1);
				break;
			case 4:
				next = new Coordinate(now.getX(), now.getY() + 1);
				break;
			}
			if (!GameController.canMove(next)) {
				System.out.println("Can't move to that direction");
				continue;
			} else {
				GameController.movePlayer(next);
				System.out.println("Moved to " + next);
				break;
			}
		}
	}

	public static int getOneInt() {
		int opr = 0;
		while (true) {
			try {
				if (s.hasNextInt()) {
					opr = s.nextInt();
					s.nextLine();
				}
				// String in = sc.nextLine();
				// opr = Integer.parseInt(in);
				System.out.println("OUT!");
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Invalid Input");
				e.printStackTrace();
			}
		}

		return opr;
	}
}
