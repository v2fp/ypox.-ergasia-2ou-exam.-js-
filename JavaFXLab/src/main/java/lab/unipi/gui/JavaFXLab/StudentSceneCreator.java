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
    Label nameLbl, amLbl, emailLbl, classLbl, dobLbl;
    // TextFields
    TextField nameField, amField, emailField, classField, dobField;
    // TableView
    TableView<Student> studentTableView;
    
    public StudentSceneCreator(double width, double height) {
    	super(width, height);
		// initialize fields
		studentList = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();	
		nameLbl = new Label("Name: ");
		amLbl = new Label("AM:");
		emailLbl = new Label("Email: ");
		classLbl = new Label("Class: ");
		dobLbl = new Label("Date of Birth: "); 
		nameField = new TextField();
		amField = new TextField();
		emailField = new TextField();
		classField = new TextField();
		dobField = new TextField();
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
	    inputFieldsPane.add(nameLbl, 0,	0);
	    inputFieldsPane.add(nameField, 1, 0);
	    inputFieldsPane.add(amLbl, 0, 1);
	    inputFieldsPane.add(amField,1,1);
	    inputFieldsPane.add(emailLbl, 0, 2);
	    inputFieldsPane.add(emailField,1,2);
	    inputFieldsPane.add(classLbl, 0, 3);
	    inputFieldsPane.add(classField,1,3);
	    inputFieldsPane.add(dobLbl, 0, 4);
	    inputFieldsPane.add(dobField,1,4);
	    
	    //customize rootScene
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
	    rootGridPane.add(inputFieldsPane, 1, 0);
	    rootGridPane.add(studentTableView, 0,0);
	    rootGridPane.add(buttonFlowPane,0,2);
	    rootGridPane.add(backBtn, 1, 2);
	    
	    //Customize tableView
	    TableColumn<Book, String> nameColumn = new TableColumn<>("name");
	    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
	    studentTableView.getColumns().add(nameColumn);
	    
	    TableColumn<Book, String> authorColumn = new TableColumn<>("am");
	    authorColumn.setCellValueFactory(new PropertyValueFactory<>("am"));
	    studentTableView.getColumns().add(authorColumn);
	    
	    TableColumn<Book, String> isbnColumn = new TableColumn<>("email");
	    isbnColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
	    studentTableView.getColumns().add(isbnColumn);
	    
	    TableColumn<Book, String> publisherColumn = new TableColumn<>("class");
	    publisherColumn.setCellValueFactory(new PropertyValueFactory<>("class"));
	    studentTableView.getColumns().add(publisherColumn);
	    
	    TableColumn<Book, String> yearColumn = new TableColumn<>("YoB");
	    yearColumn.setCellValueFactory(new PropertyValueFactory<>("YoB"));
	    studentTableView.getColumns().add(yearColumn);
    
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
	
	}
}