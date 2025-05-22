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

public class BookSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	// List of books
	ArrayList<Book> bookList;
	// Flow Pane 
    FlowPane buttonFlowPane;
    // buttons
    Button backBtn, newbookBtn, editbookBtn, deletebookBtn;
	// Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Labels
    Label titleLbl, authorLbl, isbnLbl, publisherLbl, yearLbl, categoryLbl, availabilityLbl;
    // TextFields
    TextField titleField, authorField, publisherField, yearField, categoryField, availabilityField, isbnField;
    // TableView
    TableView<Book> bookTableView;
    
    
    
    public BookSceneCreator(double width, double height) {
    	super(width, height);
    	
    	// initialize fields
    	bookList = new ArrayList<>();
    	rootGridPane = new GridPane();
    	buttonFlowPane = new FlowPane();	
    	titleLbl = new Label("Title: ");
    	authorLbl = new Label("Author:");
    	isbnLbl = new Label("ISBN: ");
    	publisherLbl = new Label("Publisher: ");
    	yearLbl = new Label("Year of Publishment: "); 
    	categoryLbl = new Label("Category: ");
    	availabilityLbl = new Label("Availability: ");
    	titleField = new TextField();
    	authorField = new TextField();
    	isbnField = new TextField();
    	publisherField = new TextField();
    	yearField = new TextField();
    	categoryField = new TextField();
    	availabilityField = new TextField();
    	backBtn = new Button("Επιστροφή στην αρχική");
        newbookBtn = new Button("Καταχώρηση νέου βιβλίου");
        editbookBtn = new Button("Επεξεργασία Στοιχείων Βιβλίου");
        deletebookBtn = new Button("Αφαίρεση Βιβλίου");    
        inputFieldsPane = new GridPane();
        bookTableView = new TableView<>();
        
     // attach handle event
        backBtn.setOnMouseClicked(this);
        newbookBtn.setOnMouseClicked(this);
        editbookBtn.setOnMouseClicked(this);
        deletebookBtn.setOnMouseClicked(this);

        //set up Flow pane
        buttonFlowPane.setHgap(5);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        // add book, student, loan and payment buttons to rootFlowPane
        buttonFlowPane.getChildren().add(backBtn);
        buttonFlowPane.getChildren().add(newbookBtn);
        buttonFlowPane.getChildren().add(editbookBtn);
        buttonFlowPane.getChildren().add(deletebookBtn);
        
        //Customize Grid Pane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(titleLbl, 0, 1);
        inputFieldsPane.add(titleField,1,1);
        inputFieldsPane.add(authorLbl, 0, 2);
        inputFieldsPane.add(authorField,1,2);
        inputFieldsPane.add(isbnLbl, 0, 0);
        inputFieldsPane.add(isbnField,1,0);
        inputFieldsPane.add(publisherLbl, 0, 3);
        inputFieldsPane.add(publisherField,1,3);
        inputFieldsPane.add(yearLbl, 0, 4);
        inputFieldsPane.add(yearField,1,4);
        inputFieldsPane.add(categoryLbl, 0, 5);
        inputFieldsPane.add(categoryField,1,5);
        inputFieldsPane.add(availabilityLbl, 0, 6);
        inputFieldsPane.add(availabilityField,1,6);
        
        //customize rootScene
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(bookTableView, 0,0);
        rootGridPane.add(buttonFlowPane,0,2);
        rootGridPane.add(backBtn, 1, 2);
        
        //Customize tableView
        TableColumn<Book, String> isbnColumn = new TableColumn<>("isbn");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        bookTableView.getColumns().add(isbnColumn);
        
        TableColumn<Book, String> nameColumn = new TableColumn<>("title");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookTableView.getColumns().add(nameColumn);
        
        TableColumn<Book, String> authorColumn = new TableColumn<>("author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookTableView.getColumns().add(authorColumn);
        
        TableColumn<Book, String> publisherColumn = new TableColumn<>("publisher");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        bookTableView.getColumns().add(publisherColumn);
        
        TableColumn<Book, Number> yearColumn = new TableColumn<>("year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        bookTableView.getColumns().add(yearColumn);
        
        TableColumn<Book, String> categoryColumn = new TableColumn<>("category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        bookTableView.getColumns().add(categoryColumn);
        
        TableColumn<Book, String> availabilityColumn = new TableColumn<>("Availability");
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available")); 
        bookTableView.getColumns().add(availabilityColumn);
        
        
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
    	else if(event.getSource() == newbookBtn) {
    		try {
	    		String title = titleField.getText();
	    		String author = authorField.getText();
	    		String isbn = isbnField.getText();
	    		String publisher = publisherField.getText();
	    		String category = categoryField.getText();
	    	    int year = Integer.parseInt(yearField.getText());
	    	    Boolean availability = Boolean.parseBoolean(availabilityField.getText().trim());
  
	    		createBook(title,author,isbn,publisher,year,category,availability);
	    		tableSync();
	    		clearTextFields();
	    		Alert alertType = new Alert(Alert.AlertType.INFORMATION);
				alertType.setTitle("Book added");
				alertType.setContentText("The book was added to the list.");
    	    }catch (NumberFormatException e) {
				Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("Invalid input type. \n Exception message: "+ e.getMessage());
				alertType.show();
    	    } catch (Exception e) {
    	    	Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Error");
				alertType.setContentText("An unexpected Error occured");
				alertType.show();
    	    }	
    	}
    	
    	else if(event.getSource() == editbookBtn) {
    		try {
	    		String title = titleField.getText();
	    		String author = authorField.getText();
	    		String isbn = isbnField.getText();
	    		String publisher = publisherField.getText();
	    		String category = categoryField.getText();
	    	    int year = Integer.parseInt(yearField.getText());
	    	    Boolean availability = Boolean.parseBoolean(availabilityField.getText());
  
	    		editBook(title,author,isbn,publisher,year,category,availability);
	    		tableSync();
	    		clearTextFields();
	    		Alert alertType = new Alert(Alert.AlertType.INFORMATION);
				alertType.setTitle("Book edited");
				alertType.setContentText("The book's information was adjusted");
    	    }catch (NumberFormatException e) {
				Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("Invalid input type. \n Exception message: "+ e.getMessage());
				alertType.show();
    	    } catch (Exception e) {
    	    	Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Error");
				alertType.setContentText("An unexpected Error occured");
				alertType.show();
    	    }
    	}
    	else if(event.getSource() == deletebookBtn) {
    		deleteBook(titleField.getText());
    		
    		tableSync();
    		clearTextFields();
    	
    	}
    	
    }
    public void createBook (String title, String author, String isbn, String publisher, int year, String category, Boolean availability) {
    	Book b = new Book(title,author,isbn,publisher,year,category,availability);
		bookList.add(b);
	}
    public void editBook(String title, String author, String isbn, String publisher, int year, String category, Boolean availability) {
    	for(Book b: bookList) {
    		if ((b.getTitle()).equals(title)) {
    			b.setAuthor(author);
    			b.setIsbn(isbn);
    			b.setPublisher(publisher);
    			b.setYear(year);
    			b.setCategory(category);
    			b.setAvailable(availability);
    		}
    	}
    }
    public void deleteBook(String title) {
    	for(int i = 0; i < bookList.size(); i++) {
    		if (bookList.get(i).getTitle().equals(title)) {
    			bookList.remove(i);
    		}
    	}
    }
    
    
    public void tableSync() {
    	List<Book> items = bookTableView.getItems();
    	items.clear();
    	for (Book b : bookList) {
    		if (b instanceof Book) {
    			items.add((Book) b);
    		}
    	}
    }
    public void clearTextFields() {
    	titleField.setText("");
    	authorField.setText("");
    	isbnField.setText("");
    	publisherField.setText("");
    	yearField.setText("");
    	categoryField.setText("");
    	availabilityField.setText("");
    	
    }    
}
