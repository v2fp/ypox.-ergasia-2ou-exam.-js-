package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

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
import java.time.LocalDate;

public class LoanSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    // List of loans
    ArrayList<Loan> loanList;
    // List of students and books for selection
    ArrayList<Student> studentList;
    ArrayList<Book> bookList;

    // GUI components
    FlowPane buttonFlowPane;
    Button backBtn, newLoanBtn, returnLoanBtn, deleteLoanBtn;
    GridPane rootGridPane, inputFieldsPane;
    Label studentLbl, bookLbl, loanDateLbl, dueDateLbl, returnDateLbl, statusLbl, fineLbl;
    TextField studentField, bookField, loanDateField, dueDateField, returnDateField, statusField, fineField;
    TableView<Loan> loanTableView;

    // For selection/search
    Student selectedStudent;
    Book selectedBook;

    // Fine calculation policy
    FeePolicy feePolicy;

    public LoanSceneCreator(double width, double height) {
        super(width, height);
        this.loanList = new ArrayList<>();

        // Initialize GUI components
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();

        studentLbl = new Label("Student ID:");
        bookLbl = new Label("Book ISBN:");
        loanDateLbl = new Label("Loan Date (YYYY-MM-DD):");
        dueDateLbl = new Label("Due Date (YYYY-MM-DD):");
        returnDateLbl = new Label("Return Date (YYYY-MM-DD):");
        statusLbl = new Label("Status:");
        fineLbl = new Label("Fine (€):");

        studentField = new TextField();
        bookField = new TextField();
        loanDateField = new TextField();
        dueDateField = new TextField();
        returnDateField = new TextField();
        statusField = new TextField();
        fineField = new TextField();
        fineField.setEditable(false);

        backBtn = new Button("Back to Main");
        newLoanBtn = new Button("New Loan");
        returnLoanBtn = new Button("Return Book");
        deleteLoanBtn = new Button("Delete Loan");

        inputFieldsPane = new GridPane();
        loanTableView = new TableView<>();

        // Attach event handlers
        backBtn.setOnMouseClicked(this);
        newLoanBtn.setOnMouseClicked(this);
        returnLoanBtn.setOnMouseClicked(this);
        deleteLoanBtn.setOnMouseClicked(this);

        // Setup button pane
        buttonFlowPane.setHgap(5);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        buttonFlowPane.getChildren().add(backBtn);
        buttonFlowPane.getChildren().add(newLoanBtn);
        buttonFlowPane.getChildren().add(returnLoanBtn);
        buttonFlowPane.getChildren().add(deleteLoanBtn);

        // Setup input fields pane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(studentLbl, 0, 0);
        inputFieldsPane.add(studentField, 1, 0);
        inputFieldsPane.add(bookLbl, 0, 1);
        inputFieldsPane.add(bookField, 1, 1);
        inputFieldsPane.add(loanDateLbl, 0, 2);
        inputFieldsPane.add(loanDateField, 1, 2);
        inputFieldsPane.add(dueDateLbl, 0, 3);
        inputFieldsPane.add(dueDateField, 1, 3);
        inputFieldsPane.add(returnDateLbl, 0, 4);
        inputFieldsPane.add(returnDateField, 1, 4);
        inputFieldsPane.add(statusLbl, 0, 5);
        inputFieldsPane.add(statusField, 1, 5);
        inputFieldsPane.add(fineLbl, 0, 6);
        inputFieldsPane.add(fineField, 1, 6);

        // Setup root grid pane
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(loanTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 2);

        // Setup TableView for loans
        TableColumn<Loan, String> studentColumn = new TableColumn<>("Student");
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        loanTableView.getColumns().add(studentColumn);

        TableColumn<Loan, String> bookColumn = new TableColumn<>("Book");
        bookColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        loanTableView.getColumns().add(bookColumn);

        TableColumn<Loan, String> loanDateColumn = new TableColumn<>("Loan Date");
        loanDateColumn.setCellValueFactory(new PropertyValueFactory<>("loanDateString"));
        loanTableView.getColumns().add(loanDateColumn);

        TableColumn<Loan, String> dueDateColumn = new TableColumn<>("Due Date");
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
        loanTableView.getColumns().add(dueDateColumn);

        TableColumn<Loan, String> returnDateColumn = new TableColumn<>("Return Date");
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDateString"));
        loanTableView.getColumns().add(returnDateColumn);

        TableColumn<Loan, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        loanTableView.getColumns().add(statusColumn);

        TableColumn<Loan, String> fineColumn = new TableColumn<>("Fine");
        fineColumn.setCellValueFactory(new PropertyValueFactory<>("fineAmountString"));
        loanTableView.getColumns().add(fineColumn);

        // Optional: you can set column resize policy here
        loanTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("LibraryMainFX Window");
            App.primaryStage.setScene(App.mainScene);
        }
        else if (event.getSource() == newLoanBtn) {
            try {
                String studentId = studentField.getText();
                String bookIsbn = bookField.getText();
                Student student = findStudentById(studentId);
                Book book = findBookByIsbn(bookIsbn);

                if (student == null) {
                    AlertManager.specificAlert("Student not found.");
                    return;
                }
                if (book == null) {
                    AlertManager.specificAlert("Book not found.");
                    return;
                }
                if (!book.available)()) {
                    AlertManager.specificAlert("Book is not available for loan.");
                    return;
                }

                LocalDate loanDate = LocalDate.now();
                LocalDate dueDate = loanDate.plusDays(14);

                Loan loan = new Loan(student, book, loanDate, dueDate);
                loanList.add(loan);
                book.setAvailable(false);

                tableSync();
                clearTextFields();
                AlertManager.infoAlert("Loan added", "The loan has been added to the list.");
            } catch (Exception e) {
                AlertManager.specificAlert("Error creating loan: " + e.getMessage());
            }
        }
        else if (event.getSource() == returnLoanBtn) {
            try {
                String studentId = studentField.getText();
                String bookIsbn = bookField.getText();
                Loan loan = findActiveLoan(studentId, bookIsbn);

                if (loan == null) {
                    AlertManager.specificAlert("Active loan not found for this student and book.");
                    return;
                }
                if (loan.getReturnDate() != null) {
                    AlertManager.specificAlert("Book already returned.");
                    return;
                }

                LocalDate returnDate = LocalDate.now();
                loan.setReturnDate(returnDate);
                loan.getBook().setAvailable(true);

                if (returnDate.isAfter(loan.getDueDate())) {
                    loan.setStatus("Overdue");
                    int overdueDays = (int) java.time.temporal.ChronoUnit.DAYS.between(loan.getDueDate(), returnDate);
                    loan.setFine(new Fine(overdueDays, loan, feePolicy));
                } else {
                    loan.setStatus("Completed");
                    loan.setFine(null);
                }

                tableSync();
                clearTextFields();
                AlertManager.infoAlert("Book returned", "The book return has been recorded.");
            } catch (Exception e) {
                AlertManager.specificAlert("Error returning book: " + e.getMessage());
            }
        }
        else if (event.getSource() == deleteLoanBtn) {
            try {
                String studentId = studentField.getText();
                String bookIsbn = bookField.getText();
                Loan loan = findLoan(studentId, bookIsbn);

                if (loan == null) {
                    AlertManager.specificAlert("Loan not found for this student and book.");
                    return;
                }
                if (loan.getReturnDate() == null) {
                    loan.getBook().setAvailable(true);
                }
                loanList.remove(loan);

                tableSync();
                clearTextFields();
                AlertManager.infoAlert("Loan deleted", "The loan has been deleted.");
            } catch (Exception e) {
                AlertManager.specificAlert("Error deleting loan: " + e.getMessage());
            }
        }
    }

    // Helper methods for finding student, book, and loans
    private Student findStudentById(String studentId) {
        for (Student s : studentList) {
            if (s.getStudentNumber().equals(studentId)) return s;
        }
        return null;
    }

    private Book findBookByIsbn(String isbn) {
        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) return b;
        }
        return null;
    }

    private Loan findActiveLoan(String studentId, String bookIsbn) {
        for (Loan l : loanList) {
            if (l.getStudent().getStudentNumber().equals(studentId) && 
                l.getBook().getIsbn().equals(bookIsbn) &&
                l.getReturnDate() == null) {
                return l;
            }
        }
        return null;
    }

    private Loan findLoan(String studentId, String bookIsbn) {
        for (Loan l : loanList) {
            if (l.getStudent().getStudentNumber().equals(studentId) && 
                l.getBook().getIsbn().equals(bookIsbn)) {
                return l;
            }
        }
        return null;
    }

    public void tableSync() {
        List<Loan> items = loanTableView.getItems();
        items.clear();
        items.addAll(loanList);
    }

    public void clearTextFields() {
        studentField.setText("");
        bookField.setText("");
        loanDateField.setText("");
        dueDateField.setText("");
        returnDateField.setText("");
        statusField.setText("");
        fineField.setText("");
    }
}