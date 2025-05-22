package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

	// List of books
	ArrayList<Student> studentList;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, newstudentBtn, updatestudentBtn, historyBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Labels
    Label idLbl, nameLbl, lastLbl, amLbl, emailLbl, classLbl, phoneLbl, dobLbl, maxLbl;
    // TextFields
    TextField idField, nameField, lastField, amField, emailField, classField, phoneField, dobField, maxField;
    // TableView
    TableView<Student> studentTableView;
    
    public StudentSceneCreator(double width, double height) {
    	super(width, height);
		// initialize fields
		studentList = new ArrayList<>();
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
	    inputFieldsPane = new GridPane();
	    studentTableView = new TableView<>();
	    
	 // attach handle event
	    backBtn.setOnMouseClicked(this);
	    newstudentBtn.setOnMouseClicked(this);
	    updatestudentBtn.setOnMouseClicked(this);
	    historyBtn.setOnMouseClicked(this);
	
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
    
    }

	@Override
	Scene createScene() {
		return new Scene (rootGridPane, width, height); }
	
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			App.primaryStage.setTitle("LibraryMainFX Window");
			App.primaryStage.setScene(App.mainScene);

		}
		else if(event.getSource() == newstudentBtn) {
			try {
				int id = Integer.parseInt(idField.getText());
	    		String name = nameField.getText();
	    		String last = lastField.getText();
	    		String am = amField.getText();
	    		String email = emailField.getText();
	    		String Class = classField.getText();
	    		String phone = phoneField.getText();
	    		String dob = dobField.getText();
	    		int max =Integer.parseInt(maxField.getText());
    		
	    		createstudent(id,name,last,am,email,Class,phone,dob,max);
	    		tableSync();
	    		ClearTextFields();
	    		
	    		Alert alertType = new Alert(Alert.AlertType.INFORMATION);
				alertType.setTitle("student added");
				alertType.setContentText("The student was added to the list.");
			}catch (NumberFormatException e) {
				Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("Invalid input type. \n Exception message: "+ e.getMessage());
    	    } catch (Exception e) {
    	    	Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Error");
				alertType.setContentText("An unexpected Error occured");
				alertType.show();
    	    }	
    	}
    		
    	else if(event.getSource() == updatestudentBtn) {
    		try {
	    		int id = Integer.parseInt(idField.getText());
	    		String name = nameField.getText();
	    		String last = lastField.getText();
	    		String am = amField.getText();
	    		String email = emailField.getText();
	    		String Class = classField.getText();
	    		String phone = phoneField.getText();
	    		String dob = dobField.getText();
	    		int max = Integer.parseInt(maxField.getText());
	    		
	    		updatestudent(id, name,last,am,email,Class,phone,dob,max);
	    		
	    		tableSync();
	    		ClearTextFields();
	    		Alert alertType = new Alert(Alert.AlertType.INFORMATION);
				alertType.setTitle("student added");
				alertType.setContentText("The student was added to the list.");
			}catch (NumberFormatException e) {
				Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("Invalid input type. \n Exception message: "+ e.getMessage());
		    } catch (Exception e) {
		    	Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Error");
				alertType.setContentText("An unexpected Error occured");
				alertType.show();	
		    }
    	}
    	else if(event.getSource() == historyBtn) {
    		int id = Integer.parseInt(idField.getText());
    		String name = nameField.getText();
    		String last = lastField.getText();
    		String am = amField.getText();
    		String email = emailField.getText();
    		String Class = classField.getText();
    		String phone = phoneField.getText();
    		String dob = dobField.getText();
    		int max = Integer.parseInt(maxField.getText());
	    	viewhistory(id,name,last,am,email,Class,phone,dob,max);
    				
   		}
   	}
	public void createstudent(int id, String name, String last, String am, String email, String Class, String phone, String dob, int maxBooks) {
		Student s = new Student( id, name, last, am, email, Class, phone, dob, maxBooks); //allagh
		studentList.add(s);
	}
	
	public void updatestudent(int id,String name, String last, String am, String email, String Class, String phone, String dob, int max){
		for(Student s: studentList) {
    		if ((s.getId()) == id) {
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
	public void viewhistory(int id,String name, String last, String am, String email, String Class, String phone, String dob, int max) {
		for (Student s: studentList) {
			if ((s.getId()) == id) {
			// το id κάνει match με φοιτητή, επομένως εμφανίζει το ιστορικό στο grid pane
			}
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
    	idField.setText("");
    	nameField.setText("");
    	lastField.setText("");
    	amField.setText("");
    	maxField.setText("");
    	dobField.setText("");
    	emailField.setText("");
    	classField.setText("");
    	phoneField.setText("");
    	dobField.setText("");    	
    }
}