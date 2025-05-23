package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaymentSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	 // lists
	ArrayList<Fine> paymentList; 
	ArrayList<Loan> loanList;
	ArrayList<Book> bookList;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, pendingPaymentsBtn, entryBtn, paymentHistoryBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Labels
    
    // TextFields
    
    // TableView
    TableView<Fine> paymentTableView;
    
    public PaymentSceneCreator(double width, double height) {
    	super(width,height);
    	
        	// initialize fields
    	
     rootGridPane = new GridPane();
     buttonFlowPane = new FlowPane();	

     backBtn = new Button("Επιστροφή στην αρχική");
     pendingPaymentsBtn = new Button("Προβολή εκκρεμών προστίμων");
     entryBtn = new Button("Καταχώρηση πληρωμής προστίμου");
     paymentHistoryBtn = new Button("Προβολή ιστορικού πληρωμών");    
     inputFieldsPane = new GridPane();
     paymentTableView = new TableView<>();
            
         // attach handle event
     backBtn.setOnMouseClicked(this);
     pendingPaymentsBtn.setOnMouseClicked(this);
     entryBtn.setOnMouseClicked(this);
     paymentHistoryBtn.setOnMouseClicked(this);

        //set up Flow pane
     buttonFlowPane.setHgap(10);
     buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        // add back, pending payments, entry and payment history buttons to rootFlowPane
     buttonFlowPane.getChildren().add(pendingPaymentsBtn);
     buttonFlowPane.getChildren().add(entryBtn);
     buttonFlowPane.getChildren().add(paymentHistoryBtn);
            
        //Customize Grid Pane
     inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
     inputFieldsPane.setVgap(10);
     inputFieldsPane.setHgap(10);
     
     paymentTableView.setPrefWidth(600);
     paymentTableView.setPrefHeight(400);

            
            //customize rootScene
     rootGridPane.setVgap(10);
     rootGridPane.setHgap(10);
     rootGridPane.add(inputFieldsPane, 1, 0);
     rootGridPane.add(paymentTableView, 0,0);
     rootGridPane.add(buttonFlowPane,0,2);
     rootGridPane.add(backBtn, 1, 2);
     }

        @Override
     Scene createScene() {
        	return new Scene (rootGridPane, width, height); }

     @Override
     public void handle(MouseEvent event) { //an patithei to back button o xrisths epistrefetai sto arxiko parathyro
    	if (event.getSource() == backBtn) {
    		App.primaryStage.setTitle("LibraryMainFX Window");
        	App.primaryStage.setScene(App.mainScene);
        }
    	else if (event.getSource() == pendingPaymentsBtn) {
    		AlertManager.infoAlert("", "showing list of pending payments");
    		
    		//ανανεώνουμε τα TableView data
    		paymentTableView.getItems().clear();
    		
    		TableColumn<Fine, String> studentIdColumn = new TableColumn<>("Student ID");
            studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            paymentTableView.getColumns().add(studentIdColumn);
            
            TableColumn<Fine, String> isbnColumn = new TableColumn<>("Book ISBN");
            isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
            paymentTableView.getColumns().add(isbnColumn);
            
            TableColumn<Fine, Double> amountColumn = new TableColumn<>("Loan Amount");
            amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
            paymentTableView.getColumns().add(amountColumn);
            
            TableColumn<Fine, String> dueDateColumn = new TableColumn<>("Due Date");
            dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
            paymentTableView.getColumns().add(dueDateColumn);
            
            paymentTableView.getColumns().add(studentIdColumn);
            paymentTableView.getColumns().add(isbnColumn);
            paymentTableView.getColumns().add(amountColumn);
            paymentTableView.getColumns().add(dueDateColumn);
            
            for (Loan loan : loanList) {
    			
    		}
    	}
    	else if (event.getSource()== entryBtn) {
    		
    	}
    	else if (event.getSource()==paymentHistoryBtn) {
    		
    	}
    }
}