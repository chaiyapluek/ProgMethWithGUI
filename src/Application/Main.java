package Application;

import gui.StartPanel;
import gui.ChooseMerPanel;
import gui.MainPanel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		primaryStage.setTitle("Test Project");
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		System.out.println(javafx.scene.text.Font.getFamilies());
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

}
