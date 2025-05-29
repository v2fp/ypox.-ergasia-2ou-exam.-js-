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
@SuppressWarnings("unused")
public class PaymentSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	 // lists
	ArrayList<Fine> fineList; 
	ArrayList<Loan> loanList;
	ArrayList<Book> bookList;
	ArrayList<Student> studentList;
	FeePolicy feePolicy;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, pendingPaymentsBtn, entryBtn, paymentHistoryBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Labels
    Label isbnLbl, idLbl, fineLbl, amountLbl;
    // TextFields
    TextField isbnField,idField,fineField,amountField;
    // TableView
    TableView<Fine> paymentTableView;
    TableView<Student> studentTableView;
    
    public PaymentSceneCreator(double width, double height) {
    	super(width,height);
    	//initialize fields
    	
    	fineList = new ArrayList<>();
    	loanList = new ArrayList<>();
    	bookList = new ArrayList<>();
    	studentList = new ArrayList<>();
    	feePolicy = new FeePolicy(height, height);
    	initializeDummyData();
    	
	    amountLbl = new Label("Amount");
	    amountField = new TextField("");
	    isbnLbl = new Label("Book ISBN");
	    isbnField = new TextField("");
	    
	    rootGridPane = new GridPane();
	    buttonFlowPane = new FlowPane();	

	    backBtn = new Button("Επιστροφή στην αρχική");
	    pendingPaymentsBtn = new Button("Προβολή εκκρεμών προστίμων");
	    entryBtn = new Button("Καταχώρηση πληρωμής προστίμου");
	    paymentHistoryBtn = new Button("Προβολή ιστορικού πληρωμών");    
	    inputFieldsPane = new GridPane();
	    paymentTableView = new TableView<>();
	    studentTableView = new TableView<>();
            
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
	    studentTableView.setPrefWidth(600);
	    studentTableView.setPrefHeight(400);
	     
	   //input fields
		inputFieldsPane.add(amountLbl, 0, 0);
	    inputFieldsPane.add(amountField, 1, 0);
	    inputFieldsPane.add(isbnLbl, 0, 1);
	    inputFieldsPane.add(isbnField, 1, 1);
	
	            
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
    			showStudents();
    			tableSync();
    			ClearTextFields();
    	}
    											//αν πατηθεί το entry button τοτε ορίζεται ενα πρόστημο ως πληρωμένο
    	else if (event.getSource()== entryBtn) {
    		payLoan();
    	}
    	
    	else if (event.getSource() == paymentHistoryBtn) {
    		showPaymentHistory();
    		tableSync();
    		ClearTextFields();
    	}
    }
     public void showStudents() {
    	 try {

	    	 AlertManager.infoAlert("", "showing list of students with pending payments");
	 		
	 		//ανανεώνουμε τα TableView data
	 		studentTableView.getItems().clear();
	 		studentTableView.getItems().clear();
	 		rootGridPane.add(studentTableView, 0, 0);
	 		//φτιαχνουμε student oriented tableView για να εμφανισουμε τους φοιτητες
	 		TableColumn<Student, Number> idColumn = new TableColumn<>("Id");
		    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		    studentTableView.getColumns().add(idColumn);
		    
		    TableColumn<Student, String> nameColumn = new TableColumn<>("first name");
		    nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		    studentTableView.getColumns().add(nameColumn);
		    
		    TableColumn<Student, String> lastColumn = new TableColumn<>("last name");
		    lastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		    studentTableView.getColumns().add(lastColumn);
		    
		    TableColumn<Student, String> amColumn = new TableColumn<>("am");
		    amColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
		    studentTableView.getColumns().add(amColumn);
		    
		    TableColumn<Student, String> phoneColumn = new TableColumn<>("phone");
		    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		    studentTableView.getColumns().add(phoneColumn);
		    
		    TableColumn<Student, String> emailColumn = new TableColumn<>("email");
		    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		    studentTableView.getColumns().add(emailColumn);
		    
		    TableColumn<Student, String> classColumn = new TableColumn<>("class");
		    classColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
		    studentTableView.getColumns().add(classColumn);
		    
		    TableColumn<Student, String> yobColumn = new TableColumn<>("YoB");
		    yobColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		    studentTableView.getColumns().add(yobColumn);
		    
		    TableColumn<Student, Number> maxColumn = new TableColumn<>("Max");
		    maxColumn.setCellValueFactory(new PropertyValueFactory<>("maxBooks"));
		    studentTableView.getColumns().add(maxColumn);
	         
		    System.out.println("Total payments: " + fineList.size());
	
		    int count = 0;
	         for (Fine p : fineList) {  //ελεγχουμε και εμφανιζουμε ολους τους φοιτητες που χρωστούν προόστιμα
	 			if(p.getPaymentStatus().equals("Pending")) {
	 				count++;
	 				studentTableView.getItems().add(p.getLoan().getStudent());			
	 				if(count ==0) AlertManager.specificAlert("There are no pending payments at the moment.");
	 			}
 			}
         }catch (NumberFormatException e) {
 			AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
 		}catch (Exception e) {
 			AlertManager.unexpectedAlert();
 		}
     }
     
     public void payLoan(){
    	 try {    		     
	            int amount = Integer.parseInt(amountField.getText()); //αποθηκευομε σε temp τον κωδικο και το ποσό.
	            String isbn = isbnField.getText();	          
	    		LocalDate dueDate = LocalDate.now();
	
	    		Fine search = null;
	    		for (Fine f: fineList) { //ψάχνουμε την paymentList για το δάνειο 
	    			if (f.getLoan().getBook().getIsbn().equals(isbn) && f.getAmount()==amount) {
	    				search = f;
	    				break;
	    			}
	    		}
	    		if(search != null) { //ελεγχουμε αν υπήρξε επιτυχής αναζήτηση
	    			search.markAsPaid();
	    			AlertManager.infoAlert("success", "Fine was paid off");
	    		}
	    		else AlertManager.specificAlert("No loans that matched the entries were found");
	    		tableSync();
	    		ClearTextFields();
	    	}
	    catch (NumberFormatException e) {
			AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			AlertManager.unexpectedAlert();
		}
     }
     
     
     public void showPaymentHistory() {			//εμφανίζουμε όλα τα πληρωμένα fines //id fee policy amount loan payment status
    	 //φτιαχνουμε τα columns για την εμφανιση
    	 paymentTableView.getItems().clear();
    	 paymentTableView.getColumns().clear();
    	 
    	 try {

	    	 paymentTableView.getItems().clear();
	    	 boolean flag = false;
	    	 
	    	 TableColumn<Fine, String> fineIdColumn = new TableColumn<>("Student code");
	         fineIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	         paymentTableView.getColumns().add(fineIdColumn);         
	         
	         TableColumn<Fine, Number> amountColumn = new TableColumn<>("Fine amount");
	         amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
	         paymentTableView.getColumns().add(amountColumn);
	         
	         TableColumn<Fine, String> statusColumn = new TableColumn<>("Payment status");
	         statusColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
	         paymentTableView.getColumns().add(statusColumn);
	         
		 
	    	 for(Fine f: fineList) {		
					if("Paid".equals(f.getPaymentStatus())) {	//ψαχνουμε και εμφανίζουμε στο TableView ολα τα πληρωμένα fines
						flag = true;
						paymentTableView.getItems().add(f);
					}		
				}
	    	 if(!flag) {
	    		 AlertManager.specificAlert("No debts have been paid off yet");
	    	 }
    	 }catch (NumberFormatException e) {
 			AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
 		}catch (Exception e) {
 			e.printStackTrace();
 			AlertManager.unexpectedAlert();
 		}
     }
     public void initializeDummyData() {
    	 //αρχικοποιούμε ολες τις λίστες σε αυτή τη συνάρτηση
    	 studentList.add(new Student(1, "Joe", "Smith", "6912345678", "JoeSmith@gmail.com", "21-05-2003", "E24194", "Digital Systems", 5));
         studentList.add(new Student(2, "Jane", "Jacobs", "6978553556", "JaneJacbos@gmail.com", "31-12-1999", "E20110", "Economics", 5));
         studentList.add(new Student(3, "Julie", "Georgiou", "6942717220", "JulieGe@gmail.com", "15-12-2006", "E24167", "Digital Systems", 5));
         studentList.add(new Student(4, "Giannis", "Giannopoulos", "6981325430", "G.Giannopoulos@gmail.com", "04-07-2005", "E23010", "Digital Systems", 7));
         studentList.add(new Student(5, "Anne", "Doe", "6930219087", "AnneDoe@gmail.com", "10-04-2006", "E24189", "Economics", 5));
         
         bookList.add(new Book("978-960-453-709-4", "Fire Punch", "Tatsuki Fujimoto", "Shonen Jump", 2016, "Psychological", false));
         bookList.add(new Book("123-456-789-012-3", "No longer human", "Osamu Dazai", "Διόπτρα", 1984, "Biography", true));
         bookList.add(new Book("153-532-529-865-8", "Look Back", "Tatsuki Fujimoto", "VizMedia", 2021, "Drama", true));
         bookList.add(new Book("213-531-589-759-6", "Goodbye Eri", "Tatsuki Fujimoto", "VizMedia", 2022, "Drama", true));
         bookList.add(new Book("890-765-432-109-8", "The Stranger", "Albert Camus", "Gallimard", 1942, "Philosophical Fiction", false));
         bookList.add(new Book("533-585-123-399-7", "Blue Period", "Tsubasa Yamaguchi", "SeinenManga", 2017, "Drama", true));
         bookList.add(new Book("566-965-180-944-5", "Nineteen-Eightyfour", "George Orwell", "Secker Warburg", 1949, "Social Science Fiction", false));
         bookList.add(new Book("323-231-395-999-9", "Crime and Punishment", "Fyodor Dostoevsky", "Simon & Schuster", 1866, "Biography", true));
         bookList.add(new Book("944-234-555-111-5", "To Kill a Mockingbird", "Harper Lee", "Goodreads", 1960, "thriller", true));
         bookList.add(new Book("132-123-234-555-0", "20th Century Boys", "Naoki Urasawa", "VizMedia", 1969, "Mystery", false));
         
         loanList.add(new Loan("LN1001", studentList.get(0), bookList.get(0), LocalDate.now().minusDays(2), feePolicy)); 

         Loan loan2 = new Loan("LN1002", studentList.get(1), bookList.get(3), LocalDate.now().minusDays(20), feePolicy);
         loan2.returnBook(LocalDate.now().minusDays(5)); 
         loanList.add(loan2);
         fineList.add(loan2.getFine());

         loanList.add(new Loan("LN1003", studentList.get(2), bookList.get(5), LocalDate.now().minusDays(15), feePolicy)); 
         bookList.get(5).setAvailable(false);

         loanList.add(new Loan("LN1004", studentList.get(3), bookList.get(7), LocalDate.now().minusDays(1), feePolicy)); 
         bookList.get(7).setAvailable(false);
     }
	 public void tableSync() {
		List<Fine> items = paymentTableView.getItems();
		items.clear();
		items.addAll(fineList);

     } 
	public void ClearTextFields() { //κανουμε reset τα fields
    	isbnField.setText("");
    	amountField.setText("");
    	
    }
}