package lab.unipi.gui.JavaFXLab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	Stage primaryStage;
	Scene mainScene;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();
        
        SceneCreator BookSceneCreator = new BookSceneCreator(650, 300);
        BookScene = BookSceneCreator.createScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}