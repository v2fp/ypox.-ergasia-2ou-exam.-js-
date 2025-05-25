package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
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

public class StudentSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

	// Lists
	ArrayList<Student> studentList;
	ArrayList<Loan> loanList;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, newstudentBtn, updatestudentBtn, historyBtn, revertBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane, hGridPane;
    // Labels
    Label idLbl, nameLbl, lastLbl, amLbl, emailLbl, classLbl, phoneLbl, dobLbl, maxLbl;
    // TextFields
    TextField idField, nameField, lastField, amField, emailField, classField, phoneField, dobField, maxField;
    // TableView
    TableView<Student> studentTableView;
    TableView<Loan> loanTableView;
    
    public StudentSceneCreator(double width, double height) {
    	super(width, height);
		// initialize fields
		studentList = new ArrayList<>();
		hGridPane = new GridPane();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		idLbl = new Label("id: ");
		nameLbl = new Label("First name: ");
		lastLbl = new Label("Last name: ");
		amLbl = new Label("AM: ");
		emailLbl = new Label("Email: ");
		classLbl = new Label("Class: ");
		phoneLbl = new Label("Phone: ");
		dobLbl = new Label("Date of Birth: ");
		maxLbl = new Label("Max books to be borrowed");
		idField = new TextField();
		nameField = new TextField();
		lastField = new TextField();
		amField = new TextField();
		emailField = new TextField();
		classField = new TextField();
		phoneField = new TextField();
		dobField = new TextField();
		maxField = new TextField();
		backBtn = new Button("Επιστροφή στην αρχική");
	    newstudentBtn = new Button("Εγγραφή νέου φοιτητή");
	    updatestudentBtn = new Button("Επεξεργασία Στοιχείων Φοιτητή");
	    historyBtn = new Button("Προβολή Ιστορικού Δανεισμών");    
	    revertBtn = new Button("Πίσω");
	    inputFieldsPane = new GridPane();
	    studentTableView = new TableView<>();
	    
	 // attach handle event
	    backBtn.setOnMouseClicked(this);
	    newstudentBtn.setOnMouseClicked(this);
	    updatestudentBtn.setOnMouseClicked(this);
	    historyBtn.setOnMouseClicked(this);
	    revertBtn.setOnMouseClicked(this);
	
	    //set up Flow pane
	    buttonFlowPane.setHgap(5);
	    buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
	    // add book, student, loan and payment buttons to rootFlowPane
	    buttonFlowPane.getChildren().add(backBtn);
	    buttonFlowPane.getChildren().add(newstudentBtn);
	    buttonFlowPane.getChildren().add(updatestudentBtn);
	    buttonFlowPane.getChildren().add(historyBtn);
	    
	    //Customize Grid Pane
	    inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
	    inputFieldsPane.setVgap(10);
	    inputFieldsPane.setHgap(10);
	    inputFieldsPane.add(idLbl, 0, 0);
	    inputFieldsPane.add(idField, 1, 0);
	    inputFieldsPane.add(nameLbl, 0,	1);
	    inputFieldsPane.add(nameField, 1, 1);
	    inputFieldsPane.add(lastLbl, 0, 2);
	    inputFieldsPane.add(lastField,1,2);
	    inputFieldsPane.add(amLbl, 0, 3);
	    inputFieldsPane.add(amField, 1,3);
	    inputFieldsPane.add(phoneLbl, 0, 4);
	    inputFieldsPane.add(phoneField, 1, 4);
	    inputFieldsPane.add(emailLbl, 0, 5);
	    inputFieldsPane.add(emailField,1,5);
	    inputFieldsPane.add(classLbl, 0, 6);
	    inputFieldsPane.add(classField,1,6);
	    inputFieldsPane.add(dobLbl, 0, 7);
	    inputFieldsPane.add(dobField,1,7);
	    inputFieldsPane.add(maxLbl, 0, 8);
	    inputFieldsPane.add(maxField,1,8);
	    	    
	    
	    //customize rootScene
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(studentTableView, 0,0);
	    rootGridPane.add(buttonFlowPane,0,2);
	    rootGridPane.add(backBtn, 1, 2);
	    
	    //Customize tableView
	    TableColumn<Student, String> idColumn = new TableColumn<>("Id");
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
	    
	    
	    //αρχικοποιούμε μερικούς φοιτητές
	    studentList.add(new Student(1, "Joe", "Smith", "6912345678", "JoeSmith@gmail.com", "21-05-2003", "E24194", "Digital Systems", 5));
        studentList.add(new Student(2, "Jane", "Jacobs", "6978553556", "JaneJacbos@gmail.com", "31-12-1999", "E20110", "Economics", 5));
        studentList.add(new Student(3, "Julie", "Georgiou", "6942717220", "JulieGe@gmail.com", "15-12-2006", "E24167", "Digital Systems", 5));
        studentList.add(new Student(4, "Giannis", "Giannopoulos", "6981325430", "G.Giannopoulos@gmail.com", "04-07-2005", "E23010", "Digital Systems", 7));
        studentList.add(new Student(5, "Anne", "Doe", "6930219087", "AnneDoe@gmail.com", "10-04-2006", "E24189", "Economics", 5));
        tableSync();
    }

	@Override
	Scene createScene() {
		return new Scene (rootGridPane, width, height); }
	
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) { //επιστροφη στην αρχική 
			App.primaryStage.setTitle("LibraryMainFX Window");
			App.primaryStage.setScene(App.mainScene);

		}
		else if(event.getSource() == newstudentBtn) {
			try {
				
			
			int id = Integer.parseInt(idField.getText());	//παίρνουμε τις τιμές μεσα απο τα text fields και τα αποθηκεύομε σε temps
    		String name = nameField.getText();
    		String last = lastField.getText();
    		String am = amField.getText();
    		String email = emailField.getText();
    		String Class = classField.getText();
    		String phone = phoneField.getText();
    		String dob = dobField.getText();
    		int max =Integer.parseInt(maxField.getText());
    		if(CheckValidity.checkPhone(phone)==true) {			//Εχουμε 2 ελεγχους εγκαιρώτητας για τον αριθμο τηλεφώνου και το email, αν ειναι εγκυρα τοτε καλουμε τις μεθόδους, αλλιώς εμφανίζονται ανάλογα μηνύματα
    			if(CheckValidity.emailValidity(email)==true) {
		    		createstudent(id,name,last,am,email,Class,phone,dob,max);
		    		tableSync();
		    		ClearTextFields();
    			}else {AlertManager.specificAlert("Invalid email format, please try again");
    			emailField.setText("");}
    		}else {AlertManager.specificAlert("invalid phone number, please try again");
    			phoneField.setText("");}
    		AlertManager.infoAlert("Student added", "The student has been added to the  list.");
			}catch (NumberFormatException e) {
				AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
			}catch (Exception e) {
				AlertManager.unexpectedAlert();
				}
	    	}
	
    	else if(event.getSource() == updatestudentBtn) {
    		try {
    			
    		int id = Integer.parseInt(idField.getText()); //ίδια λειτουργία με την newstudent σε ήδη υπάρχων φοιτητές
    		String name = nameField.getText();
    		String last = lastField.getText();
    		String am = amField.getText();
    		String email = emailField.getText();
    		String Class = classField.getText();
    		String phone = phoneField.getText();
    		String dob = dobField.getText();
    		int max = Integer.parseInt(maxField.getText());
    		if(CheckValidity.checkPhone(phone)==true) {	
    			if(CheckValidity.emailValidity(email)==true) {
		    		updatestudent(id, name,last,am,email,Class,phone,dob,max);
		    		tableSync();
		    		ClearTextFields();
    			}else {AlertManager.specificAlert("Invalid email format, please try again");
    			emailField.setText("");}
    		}else {AlertManager.specificAlert("invalid phone number, please try again");
    		phoneField.setText("");}
    		AlertManager.infoAlert("Student info updated", "The information of this student was updated");
	    	}catch (NumberFormatException e) {
				AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
			}catch (Exception e) {
				AlertManager.unexpectedAlert();
			}
	   	}
	
    	else if(event.getSource() == historyBtn) {
    		try {
	    		int id = Integer.parseInt(idField.getText()); //αποθηκεύουμε μονο την id διοτι αυτη χρειαζόμαστε για τον ελεγχο
		    	viewhistory(id);
    		}catch (NumberFormatException e) {
    			AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
    		}catch (Exception e) {
    			AlertManager.specificAlert("Unexpected error" + e.toString());
    		}
   		}
   	}
	public void createstudent(int id, String name, String last, String am, String email, String Class, String phone, String dob, int maxBooks) {
		Student s = new Student( id, name, last, am, email, Class, phone, dob, maxBooks); 
		studentList.add(s); //προσθέτουμε με τα fields καινούργιο student στην λιστα
	}
	
	public void updatestudent(int id,String name, String last, String am, String email, String Class, String phone, String dob, int max){
		for(Student s: studentList) {
    		if ((s.getId()) == id) { //αντικαθιστούμε ήδη υπάρχων fields
    			s.setId(id);
    			s.setFirstName(name);
    			s.setLastName(last);
    			s.setStudentId(am);
    			s.setEmail(email);
    			s.setDepartment(Class);
    			s.setPhone(phone);
    			s.setBirthDate(dob);
    			s.setMaxBooks(max);
    		}
    	}
	}
	public void viewhistory(int id) {
		try {
			hGridPane.getChildren().clear();		//φτιάχνουμε grid για τα loans
			studentTableView.getColumns().clear();
			studentTableView.getItems().clear();
			hGridPane.add(revertBtn,0,1);
			revertBtn.setAlignment(Pos.BOTTOM_RIGHT);
			
			if (loanTableView == null) {
			loanTableView = new TableView<>();
			}
			
			int flag = 0;
			for (Student s: studentList) {			
				if ((s.getId()) == id) {
					flag = 1;
					// το id κάνει match με φοιτητή, επομένως εμφανίζει το ιστορικό στο Table View
					rootGridPane.add(hGridPane, 0,1);
					hGridPane.add(loanTableView, 0, 0,5,1);
					
					AlertManager.infoAlert("Student History", "Showing loan history for " + s.getFirstName() + " " +s.getLastName());		
					
					TableColumn<Loan, String> titleColumn = new TableColumn<>("Title");
			        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));			         
			        loanTableView.getColumns().add(titleColumn);
			        
			        TableColumn<Loan, LocalDate> getDateColumn = new TableColumn<>("Date of loan");
			        getDateColumn.setCellValueFactory(new PropertyValueFactory<>("loanDate"));			         
			        loanTableView.getColumns().add(getDateColumn);
			        
			        TableColumn<Loan, LocalDate> dueColumn = new TableColumn<>("Due Date");
			        dueColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));			         
			        loanTableView.getColumns().add(dueColumn);
			        
			        TableColumn<Loan, LocalDate> returnColumn = new TableColumn<>("Return Date");
			        returnColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));			         
			        loanTableView.getColumns().add(returnColumn);
			        
			        TableColumn<Loan, String> statusColumn = new TableColumn<>("Status");
			        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));			         
			        loanTableView.getColumns().add(statusColumn);
			        
			        for(Loan l : loanList) { //ελέγχουμε ποια loan ανοίκουν στον φοιτητή και τα εμφανίζουμε 
			        	if(l.getStudent().getId()==id) {
			        		loanTableView.getItems().add(l);
			        	}
			        }
			        
			      
			        break;
				}
			}
			
			if(flag == 0) {
				AlertManager.specificAlert("Student" + id + "not found");
			}

		}catch (NumberFormatException e) {
			AlertManager.specificAlert("Invalid input type. \n Exception message: "+ e.getMessage());
		}catch (Exception e) {
			AlertManager.specificAlert("Unexpected error" + e.toString());
		}
		
	}

	
    public void tableSync() {
    	List<Student> items = studentTableView.getItems();
    	items.clear();
    	for (Student s : studentList) {
    		if (s instanceof Student) {
    			items.add((Student) s);
    		}
    	}
    }
    public void ClearTextFields() {
    	nameField.setText("");
    	amField.setText("");
    	emailField.setText("");
    	classField.setText("");
    	phoneField.setText("");
    	dobField.setText("");    	
    }
}