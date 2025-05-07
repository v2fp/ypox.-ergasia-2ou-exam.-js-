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
		super(width, height);
		rootFlowPane = new FlowPane();
		bookBtn = new Button("Book");
		studentBtn = new Button("Student");
		loanBtn = new Button("Loan");
		paymentBtn = new Button("Payment");
		
		// attach handle event to bookBtn;
		bookBtn.setOnMouseClicked(this);
		
		//set up Flow pane
		rootFlowPane.setHgap(10);
		rootFlowPane.setAlignment(Pos.CENTER);
		// add book, student, loan and payment buttons to rootFlowPane
		rootFlowPane.getChildren().add(bookBtn);
		rootFlowPane.getChildren().add(studentBtn);
		rootFlowPane.getChildren().add(loanBtn);
		rootFlowPane.getChildren().add(paymentBtn);
	}
	@Override
	Scene createScene() { return new Scene (rootFlowPane, width, height); }
	
	@Override
	public void handle(lab.unipi.gui.JavaFXLab.MouseEvent event) {
		if(event.getSource()== bookBtn) {
			App.primaryStage.setScene(App.bookScene);
			App.primaryStage.setScene("Book window");
		}
		
	}
	@Override
	public void handle(lab.unipi.gui.JavaFXLab.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

}
