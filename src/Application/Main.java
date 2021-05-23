package Application;

import gui.StartPanel;
import gui.ChooseMerPanel;
import gui.MainPanel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.GameController;

public class Main extends Application{

	private static Stage stage;
	
	private static Scene startScene;
	private static Scene initialScene;
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
		GameController.Intialize();
		createStartScene();
		
		primaryStage.setScene(startScene);
		primaryStage.setTitle("Dungeon Adventure");
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}
	
	public void createStartScene() {
		//VBox root = new VBox();
		//root.setAlignment(Pos.CENTER);
		
		StartPanel p = new StartPanel();
		//root.getChildren().add(p);
		
		startScene = new Scene(p,1280,720);
	}
	
	public static void createInitialScene() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		
		ChooseMerPanel p = new ChooseMerPanel();
		root.getChildren().add(p);
		GameController.setChooseMerPanel(p);
		
		initialScene = new Scene(root,1280,720);
	}
	
	public static void createMainScene() {
		VBox root = new VBox();
		root.setAlignment(Pos.BOTTOM_CENTER);
		
		MainPanel p = new MainPanel(GameController.getPlayer());
		root.getChildren().add(p);
		GameController.setMainPanel(p);
		
		mainScene = new Scene(root,1280,720);
	}
	
	public static Scene getInitialScene() {
		return initialScene;
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void setStartScene() {
		stage.setScene(startScene);
	}

}
