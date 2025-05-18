package lab.unipi.gui.JavaFXLab;

import java.util.concurrent.Flow;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    // Flow Pane (root mode
    FlowPane rootFlowPane;
    // Main scene buttons
    Button bookBtn, studentBtn, loanBtn, paymentBtn;
    public MainSceneCreator(double width, double height) {
        super(width, height);
        rootFlowPane = new FlowPane();
        bookBtn = new Button("Διαχείριση Βιβλίων");
        studentBtn = new Button("Διαχειριση φοιτητων");
        loanBtn = new Button("Διαχείριση Δανεισμών");
        paymentBtn = new Button("Διαχείριση Πληρομών");

        // attach handle event to bookBtn;
        bookBtn.setOnMouseClicked(this);
        studentBtn.setOnMouseClicked(this);
        loanBtn.setOnMouseClicked(this);
        paymentBtn.setOnMouseClicked(this);

        //set up Flow pane
        rootFlowPane.setHgap(50);
        rootFlowPane.setAlignment(Pos.CENTER);
        // add book, student, loan and payment buttons to rootFlowPane
        rootFlowPane.getChildren().add(bookBtn);
        rootFlowPane.getChildren().add(studentBtn);
        rootFlowPane.getChildren().add(loanBtn);
        rootFlowPane.getChildren().add(paymentBtn);
    }
    @Override
    Scene createScene() {
    return new Scene (rootFlowPane, width, height); }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource() == bookBtn) {
            App.primaryStage.setScene(App.bookScene);
            App.primaryStage.setTitle("Book window"); 
        }
        else if(event.getSource() == studentBtn) {
        	App.primaryStage.setScene(App.studentScene);
            App.primaryStage.setTitle("Student window"); 
        }
        else if(event.getSource() == loanBtn) {
            App.primaryStage.setScene(App.loanScene);
            App.primaryStage.setTitle("Loan window"); 
        }
        else if(event.getSource() == paymentBtn) {
            App.primaryStage.setScene(App.paymentScene);
            App.primaryStage.setTitle("Payment window"); 
        } 
    }
}

