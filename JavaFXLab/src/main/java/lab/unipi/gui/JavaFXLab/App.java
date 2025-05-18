package lab.unipi.gui.JavaFXLab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    static Stage primaryStage;
    static Scene mainScene, bookScene, studentScene, loanScene, paymentScene;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();

        SceneCreator BookSceneCreator = new BookSceneCreator(650, 300);
        bookScene = BookSceneCreator.createScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();

        SceneCreator StudentSceneCreator = new StudentSceneCreator(650, 300);
        studentScene = StudentSceneCreator.createScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();

    	SceneCreator LoanSceneCreator = new LoanSceneCreator(650, 300);
    	loanScene = LoanSceneCreator.createScene();
    	primaryStage.setScene(mainScene);
    	primaryStage.setTitle("LibraryMainFX Window");
    	primaryStage.show();
    	
    	SceneCreator PaymentSceneCreator = new PaymentSceneCreator(650, 300);
    	paymentScene = PaymentSceneCreator.createScene();
    	primaryStage.setScene(mainScene);
    	primaryStage.setTitle("LibraryMainFX Window");
    	primaryStage.show();
    }
    	
    	
    public static void main(String[] args) {
        launch();
    }

}