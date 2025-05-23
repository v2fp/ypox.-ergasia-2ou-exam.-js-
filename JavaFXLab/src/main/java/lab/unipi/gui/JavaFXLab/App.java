package lab.unipi.gui.JavaFXLab;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    static Stage primaryStage;
    static Scene mainScene, bookScene, studentScene, loanScene, paymentScene;

    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        App.primaryStage = primaryStage;
 
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();

        SceneCreator BookSceneCreator = new BookSceneCreator(800, 450);
        bookScene = BookSceneCreator.createScene();

        SceneCreator StudentSceneCreator = new StudentSceneCreator(800, 450);
        studentScene = StudentSceneCreator.createScene();

        SceneCreator LoanSceneCreator = new LoanSceneCreator(800, 450);
        loanScene = LoanSceneCreator.createScene();

        SceneCreator PaymentSceneCreator = new PaymentSceneCreator(800, 450);
        paymentScene = PaymentSceneCreator.createScene();

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}