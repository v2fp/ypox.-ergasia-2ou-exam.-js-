package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LoanSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    ArrayList<Student> studentList;
    ArrayList<Book> bookList;
    ArrayList<Loan> loanList;
    FeePolicy feePolicy;

    TableView<Loan> loanTableView;
    Button newLoanBtn, returnLoanBtn, backBtn;
    Button filterActiveBtn, filterOverdueBtn, filterCompletedBtn;
    VBox rootVBox;
    HBox filterButtonsBox;
    HBox actionButtonsBox;
    VBox centralBox;

    public LoanSceneCreator(int width, int height) {
        super(width, height);

        this.studentList = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.loanList = new ArrayList<>();
        this.feePolicy = new FeePolicy(height, height);
        
        
        // Αρχικοποιήσεις Βιβλίων, Φοιτητών και Δανεισμών
	    studentList.add(new Student(1, "Joe", "Smith", "6912345678", "JoeSmith@gmail.com", "21-05-2003", "E24194", "Digital Systems", 5));
        studentList.add(new Student(2, "Jane", "Jacobs", "6978553556", "JaneJacbos@gmail.com", "31-12-1999", "E20110", "Economics", 5));
        studentList.add(new Student(3, "Julie", "Georgiou", "6942717220", "JulieGe@gmail.com", "15-12-2006", "E24167", "Digital Systems", 5));
        studentList.add(new Student(4, "Giannis", "Giannopoulos", "6981325430", "G.Giannopoulos@gmail.com", "04-07-2005", "E23010", "Digital Systems", 7));
        studentList.add(new Student(5, "Anne", "Doe", "6930219087", "AnneDoe@gmail.com", "10-04-2006", "E24189", "Economics", 5));
        
        bookList.add(new Book("978-960-453-709-4", "Fire Punch", "Tatsuki Fujimoto", "Shonen Jump", 2016, "Psychological", true));
        bookList.add(new Book("123-456-789-012-3", "No longer human", "Osamu Dazai", "Διόπτρα", 1984, "Biography", true));
        bookList.add(new Book("153-532-529-865-8", "Look Back", "Tatsuki Fujimoto", "VizMedia", 2021, "Drama", true));
        bookList.add(new Book("213-531-589-759-6", "Goodbye Eri", "Tatsuki Fujimoto", "VizMedia", 2022, "Drama", true));
        bookList.add(new Book("890-765-432-109-8", "The Stranger", "Albert Camus", "Gallimard", 1942, "Philosophical Fiction", true));
        bookList.add(new Book("533-585-123-399-7", "Blue Period", "Tsubasa Yamaguchi", "SeinenManga", 2017, "Drama", true));
        bookList.add(new Book("566-965-180-944-5", "Nineteen-Eightyfour", "George Orwell", "Secker Warburg", 1949, "Social Science Fiction", true));
        bookList.add(new Book("323-231-395-999-9", "Crime and Punishment", "Fyodor Dostoevsky", "Simon & Schuster", 1866, "Biography", true));
        bookList.add(new Book("944-234-555-111-5", "To Kill a Mockingbird", "Harper Lee", "Goodreads", 1960, "thriller", true));
        bookList.add(new Book("132-123-234-555-0", "20th Century Boys", "Naoki Urasawa", "VizMedia", 1969, "Mystery", true));
        
        loanList.add(new Loan("LN1001", studentList.get(0), bookList.get(0), LocalDate.now().minusDays(2), feePolicy)); 
        Loan loan2 = new Loan("LN1002", studentList.get(1), bookList.get(3), LocalDate.now().minusDays(20), feePolicy);
        loan2.returnBook(LocalDate.now().minusDays(5)); 
        loanList.add(loan2);
        loanList.add(new Loan("LN1003", studentList.get(2), bookList.get(5), LocalDate.now().minusDays(15), feePolicy)); 
        bookList.get(5).setAvailable(false);
        loanList.add(new Loan("LN1004", studentList.get(3), bookList.get(7), LocalDate.now().minusDays(1), feePolicy)); 
        bookList.get(7).setAvailable(false);
        
        // --- Κουμπιά φίλτρων στο κέντρο ---
        filterActiveBtn = new Button("Ενεργοί");
        filterOverdueBtn = new Button("Καθυστερημένοι");
        filterCompletedBtn = new Button("Ολοκληρωμένοι");
        filterActiveBtn.setOnMouseClicked(this);
        filterOverdueBtn.setOnMouseClicked(this);
        filterCompletedBtn.setOnMouseClicked(this);

        filterButtonsBox = new HBox(20, filterActiveBtn, filterOverdueBtn, filterCompletedBtn);
        filterButtonsBox.setAlignment(Pos.CENTER);

        // --- Πίνακας δανεισμών ---
        loanTableView = new TableView<>();
        TableColumn<Loan, String> stuCol = new TableColumn<>("Student");
        stuCol.setCellValueFactory(new PropertyValueFactory<>("studentDisplayName"));
        TableColumn<Loan, String> bkCol = new TableColumn<>("Book");
        bkCol.setCellValueFactory(new PropertyValueFactory<>("bookDisplayTitle"));
        TableColumn<Loan, String> ldateCol = new TableColumn<>("Loan Date");
        ldateCol.setCellValueFactory(new PropertyValueFactory<>("loanDateString"));
        TableColumn<Loan, String> ddateCol = new TableColumn<>("Due Date");
        ddateCol.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
        TableColumn<Loan, String> rdateCol = new TableColumn<>("Return Date");
        rdateCol.setCellValueFactory(new PropertyValueFactory<>("returnDateString"));
        TableColumn<Loan, String> stCol = new TableColumn<>("Status");
        stCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        TableColumn<Loan, String> fineCol = new TableColumn<>("Fine (€)");
        fineCol.setCellValueFactory(new PropertyValueFactory<>("fineAmountString"));
        loanTableView.getColumns().addAll(stuCol, bkCol, ldateCol, ddateCol, rdateCol, stCol, fineCol);
        loanTableView.setPrefHeight(180);

        centralBox = new VBox(20, filterButtonsBox, loanTableView);
        centralBox.setAlignment(Pos.CENTER);

        // --- Κουμπιά ενεργειών στο κάτω μέρος ---
        newLoanBtn = new Button("Νέος Δανεισμός");
        returnLoanBtn = new Button("Επιστροφή Βιβλίου");
        backBtn = new Button("Επιστροφή στην Αρχική");
        newLoanBtn.setOnMouseClicked(this);
        returnLoanBtn.setOnMouseClicked(this);
        backBtn.setOnMouseClicked(this);

        actionButtonsBox = new HBox(20, newLoanBtn, returnLoanBtn, backBtn);
        actionButtonsBox.setAlignment(Pos.CENTER);

        rootVBox = new VBox(30, centralBox, actionButtonsBox);
        rootVBox.setAlignment(Pos.CENTER);
        rootVBox.setPrefWidth(width);
        rootVBox.setPrefHeight(height);
        rootVBox.setStyle("-fx-padding: 30;");

        tableSync();
    }

    @Override
    Scene createScene() {
        return new Scene(rootVBox, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        Object src = event.getSource();
        if (src == backBtn) {
            App.primaryStage.setTitle("LibraryMainFX Window");
            App.primaryStage.setScene(App.mainScene);
        } else if (src == newLoanBtn) {
            showNewLoanDialog();
        } else if (src == returnLoanBtn) {
            Loan selectedLoan = loanTableView.getSelectionModel().getSelectedItem();
            if (selectedLoan == null) {
                AlertManager.specificAlert("Παρακαλώ επιλέξτε κάποιον δανεισμό για επιστροφή.");
                return;
            }
            if (selectedLoan.getReturnDate() != null) {
                AlertManager.specificAlert("Το βιβλίο έχει ήδη επιστραφεί.");
                return;
            }
            LocalDate returnDate = LocalDate.now();
            selectedLoan.returnBook(returnDate);

            tableSync();
            AlertManager.infoAlert("Επιστροφή βιβλίου", "Η επιστροφή καταγράφηκε επιτυχώς.");
        } else if (src == filterActiveBtn) {
            loanTableView.getItems().setAll(
                loanList.stream()
                        .filter(l -> l.getReturnDate() == null && l.getStatus().equals("Active"))
                        .collect(Collectors.toList())
            );
        } else if (src == filterOverdueBtn) {
            loanTableView.getItems().setAll(
                loanList.stream()
                        .filter(l -> "Overdue".equals(l.getStatus()))
                        .collect(Collectors.toList())
            );
        } else if (src == filterCompletedBtn) {
            loanTableView.getItems().setAll(
                loanList.stream()
                        .filter(l -> "Completed".equals(l.getStatus()))
                        .collect(Collectors.toList())
            );
        }
    }

    private void showNewLoanDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Νέος Δανεισμός");

        Label studentLbl = new Label("ID Φοιτητή:");
        TextField studentField = new TextField();
        Label bookLbl = new Label("ISBN Βιβλίου:");
        TextField bookField = new TextField();

        Button confirmBtn = new Button("Επιβεβαίωση");
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        confirmBtn.setOnAction(e -> {
            String studentInput = studentField.getText().trim();
            String bookInput = bookField.getText().trim();

            Student student = null;
            for (Student s : studentList) {
                if (s.getStudentId().equals(studentInput)) {
                    student = s;
                    break;
                }
            }

            Book book = null;
            for (Book b : bookList) {
                if (b.getIsbn().equals(bookInput) && b.getAvailable()) {
                    book = b;
                    break;
                }
            }

            if (student == null) {
                errorLabel.setText("Δεν βρέθηκε φοιτητής με αυτό το ID.");
                return;
            }
            if (book == null) {
                errorLabel.setText("Δεν βρέθηκε διαθέσιμο βιβλίο με αυτό το ISBN.");
                return;
            }

            LocalDate loanDate = LocalDate.now();
            String id = "LN" + System.currentTimeMillis();
            Loan loan = new Loan(id, student, book, loanDate, feePolicy);
            loanList.add(loan);
            book.setAvailable(false);
            tableSync();
            dialog.close();
            AlertManager.infoAlert("Δημιουργία δανεισμού", "Ο δανεισμός προστέθηκε επιτυχώς.");
        });

        VBox vbox = new VBox(18, studentLbl, studentField, bookLbl, bookField, confirmBtn, errorLabel);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 22;");

        dialog.setScene(new Scene(vbox, 420, 300));
        dialog.initOwner(App.primaryStage);
        dialog.showAndWait();
    }

    private void tableSync() {
        loanTableView.getItems().setAll(loanList);
    }
}