package lab.unipi.gui.JavaFXLab;

import lab.unipi.gui.JavaFXLab.Loan;
import lab.unipi.gui.JavaFXLab.LoanSceneCreator;
import lab.unipi.gui.JavaFXLab.FeePolicy;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
	ArrayList<Student>studentList;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, pendingPaymentsBtn, entryBtn, paymentHistoryBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Labels
    Label isbnLbl, idLbl, fineLbl;
    // TextFields
    TextField isbnField,idField,fineField;
    // TableView
    TableView<Fine> paymentTableView;
    
    public PaymentSceneCreator(double width, double height) {
    	super(width,height);
    	
        	// initialize fields
     paymentList = new ArrayList<>();
     isbnLbl = new Label("ISBN");
     idLbl = new Label("Student ID");
     fineLbl = new Label("Fine Amount");
     isbnField = new TextField("");
     idField = new TextField("");
     fineField = new TextField("");
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
     public void handle(MouseEvent event) { 
    	if (event.getSource() == backBtn) { //an patithei to back button o xrisths epistrefetai sto arxiko parathyro
    		App.primaryStage.setTitle("LibraryMainFX Window");
        	App.primaryStage.setScene(App.mainScene);
        }
    	else if (event.getSource() == pendingPaymentsBtn) { //αν πατηθεί το pending payments button εμφανίζονται όλοι οι φοιτητές με pending πληρωμές
    		if(paymentList.size() > 0) {
    			showStudents();
    			tableSync();
    			
	    	} else AlertManager.specificAlert("There are no pending payments at the moment.");
    	}
    											//αν πατηθεί το entry button τοτε ορίζεται ενα πρόστημο ως πληρωμένο
    	else if (event.getSource()== entryBtn) {
    		AlertManager.infoAlert("Payment entry", "Please enter the Loaned book's ISBN,the student's id, as well as the fine amount");
    		//προσθετουμε fields για να συμπληρωθούν τα στοιχεία 
    		inputFieldsPane.add(isbnLbl, 0, 0);
            inputFieldsPane.add(isbnField, 1, 0);
            inputFieldsPane.add(idLbl, 0, 1);
            inputFieldsPane.add(idField, 1, 1);
            inputFieldsPane.add(fineLbl, 0, 2);
            inputFieldsPane.add(fineField, 1, 2);
            
            String isbn = isbnField.getText();
            String id = idField.getText();
            int fine = Integer.parseInt(fineField.getText());
    		LocalDate dueDate = LocalDate.now();

    		Loan search = null;
    		for (Loan l: loanList) {
    			if ((l.getId()).equals(id) && l.getBook().getIsbn().equals(isbn)) {
    				search = l;
    				break;
    			}
    		}
    		if(search != null) {
    			search.returnBook(search.getReturnDate());
    			AlertManager.infoAlert("success", "Book was returned successfully");
    		}
    		else AlertManager.specificAlert("No loans that matched the entries were found");
    		tableSync();
    		ClearTextFields();
    	}
    	
    	else if (event.getSource() == paymentHistoryBtn) {
    		int flag = 1;
    		for(Loan l: loanList) {
    			if ((l.getStatus().equals("Completed"))) {  // public Loan(String id, Student student, Book book, LocalDate loanDate, FeePolicy feePolicy) {
    				showPaymentHistory(l);//    public Fine(int overdueDays, Loan loan, FeePolicy feePolicy) {
   				
    			}
    		}
    	}    	
    	
    }
     public void showStudents() {
    	 AlertManager.infoAlert("", "showing list of students with pending payments");
 		
 		//ανανεώνουμε τα TableView data
 		paymentTableView.getItems().clear();
 		
 		TableColumn<Fine, String> idColumn = new TableColumn<>("Id");
	    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	    paymentTableView.getColumns().add(idColumn);
	    
	    TableColumn<Fine, String> nameColumn = new TableColumn<>("first name");
	    nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    paymentTableView.getColumns().add(nameColumn);
	    
	    TableColumn<Fine, String> lastColumn = new TableColumn<>("last name");
	    lastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	    paymentTableView.getColumns().add(lastColumn);
	    
	    TableColumn<Fine, String> amColumn = new TableColumn<>("am");
	    amColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
	    paymentTableView.getColumns().add(amColumn);
	    
	    TableColumn<Fine, String> phoneColumn = new TableColumn<>("phone");
	    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
	    paymentTableView.getColumns().add(phoneColumn);
	    
	    TableColumn<Fine, String> emailColumn = new TableColumn<>("email");
	    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
	    paymentTableView.getColumns().add(emailColumn);
	    
	    TableColumn<Fine, String> classColumn = new TableColumn<>("class");
	    classColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
	    paymentTableView.getColumns().add(classColumn);
	    
	    TableColumn<Fine, String> yobColumn = new TableColumn<>("YoB");
	    yobColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
	    paymentTableView.getColumns().add(yobColumn);
	    
	    TableColumn<Fine, Number> maxColumn = new TableColumn<>("Max");
	    maxColumn.setCellValueFactory(new PropertyValueFactory<>("maxBooks"));
	    paymentTableView.getColumns().add(maxColumn);
         
         for (Fine p : paymentList) { 
 			if(p.getPaymentStatus().equals("pending")) {
 				paymentTableView.getItems().add(p);
 			}
         }
     }
     public void showPaymentHistory(Loan l) {			//student id, isbn, book title, loanDate, overdueDays
    	 //φτιαχνουμε τα columns για την εμφανιση
    	 paymentTableView.getItems().clear();
    	 
    	 TableColumn<Fine, String> studentIdColumn = new TableColumn<>("Student ID");
         studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
         paymentTableView.getColumns().add(studentIdColumn);
         
         TableColumn<Fine, String> isbnColumn = new TableColumn<>("Book ISBN");
         isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
         paymentTableView.getColumns().add(isbnColumn);
         
         TableColumn<Fine, String> titleColumn = new TableColumn<>("Book Title");
         titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
         paymentTableView.getColumns().add(titleColumn);
         
         TableColumn<Fine, Double> amountColumn = new TableColumn<>("Loan Amount");
         amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
         paymentTableView.getColumns().add(amountColumn);
         
         TableColumn<Fine, String> dueDateColumn = new TableColumn<>("Due Date");
         dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
         paymentTableView.getColumns().add(dueDateColumn);
         
         TableColumn<Fine, Number> overdueDaysColumn = new TableColumn<>("Overdue Days");
         overdueDaysColumn.setCellValueFactory(new PropertyValueFactory<>("overdueDays"));
         paymentTableView.getColumns().add(overdueDaysColumn);
	 
    	 for(Fine f: paymentList) {
				if(f.getLoan().equals(l)) {
					paymentTableView.getItems().add(f);
				}
			}
     }
	public void tableSync() {
		List<Fine> items = paymentTableView.getItems();
		items.clear();
		items.addAll(paymentList);

     } 
	public void ClearTextFields() { //κανουμε reset τα fields
    	idField.setText("");
    	fineField.setText("");
    	isbnField.setText("");
    	
    }
}