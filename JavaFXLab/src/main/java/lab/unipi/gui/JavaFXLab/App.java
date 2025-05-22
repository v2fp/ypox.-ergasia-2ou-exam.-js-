package lab.unipi.gui.JavaFXLab;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
<<<<<<< HEAD

	Stage primaryStage;
	Scene mainScene;
    static Stage primaryStage;
    static Scene mainScene, bookScene, studentScene, loanScene, paymentScene;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
=======
	
    static Stage primaryStage;
    static Scene mainScene, bookScene, studentScene, loanScene, paymentScene;
    
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
>>>>>>> 84e52ed1d378c566c5078c01153cf5bd1832d62f
        App.primaryStage = primaryStage;
 
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();
<<<<<<< HEAD
        

        SceneCreator BookSceneCreator = new BookSceneCreator(650, 300);
        BookScene = BookSceneCreator.createScene();
        bookScene = BookSceneCreator.createScene();
=======

        SceneCreator BookSceneCreator = new BookSceneCreator(650, 300);
        bookScene = BookSceneCreator.createScene();

        SceneCreator StudentSceneCreator = new StudentSceneCreator(650, 300);
        studentScene = StudentSceneCreator.createScene();

    	SceneCreator LoanSceneCreator = new LoanSceneCreator(650, 300);
    	loanScene = LoanSceneCreator.createScene();
    	
    	SceneCreator PaymentSceneCreator = new PaymentSceneCreator(650, 300);
    	paymentScene = PaymentSceneCreator.createScene();
    	
>>>>>>> 84e52ed1d378c566c5078c01153cf5bd1832d62f
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();
    }
<<<<<<< HEAD

        SceneCreator StudentSceneCreator = new StudentSceneCreator(650, 300);
        studentScene = StudentSceneCreator.createScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("LibraryMainFX Window");
        primaryStage.show();

    	SceneCreator LoanSceneCreator = new LoanSceneCreator(650, 300);
    	loanScene = LoanSceneCreator.createScene();
    	primaryStage.setScene(mainScene);
    	primaryStage.setTitle("LibraryMainFX Window");
    	primaryStage.show();
    	
    	SceneCreator PaymentSceneCreator = new PaymentSceneCreator(650, 300);
    	paymentScene = PaymentSceneCreator.createScene();
    	primaryStage.setScene(mainScene);
    	primaryStage.setTitle("LibraryMainFX Window");
    	primaryStage.show();
    }
=======
>>>>>>> 84e52ed1d378c566c5078c01153cf5bd1832d62f
    	
    public static void main(String[] args) {
    	dummyObjects();
        launch();
    
    }
<<<<<<< HEAD
        //Dummy books (PREPEI NA TA VALOUME SE LISTA)
        Book book1 = new Book("978-960-453-709-4", "Fire Punch", "Tatsuki Fujimoto", "Shonen Jump", 2016, "Psychological", false);
    	Book book2 = new Book("123-456-789-012-3", "No longer human", "Osamu Dazai", "Διόπτρα", 1984, "Biography", true);
    	Book book3 = new Book("153-532-529-865-8", "Look Back", "Tatsuki Fujimoto", "VizMedia", 2021, "Drama", true);
    	Book book4 = new Book("213-531-589-759-6", "Goodbye Eri", "Tatsuki Fujimoto", "VizMedia", 2022, "Drama", true);
    	Book book5 = new Book("890-765-432-109-8", "The Stranger", "Albert Camus", "Gallimard", 1942, "Philosophical Fiction", false);
    	Book book6 = new Book("533-585-123-399-7", "Blue Period", "Tsubasa Yamaguchi", "SeinenManga", 2017, "Drama", true);
    	Book book7 = new Book("566-965-180-944-5", "Nineteen-Eightyfour", "George Orwell", "Secker Warburg", 1949,"Social Science Fiction", false);
    	Book book8 = new Book("323-231-395-999-9", "Crime and Punishment", "Fyodor Dostoevsky", "Simon & Schuster", 1866, "Biography", true);
    	Book book9 = new Book("944-234-555-111-5", "To Kill a Mockingbird", "Harper Lee", "Goodreads", 1960, "thriller", true);
    	Book book10= new Book("132-123-234-555-0", "20th Century Boys", "Naoki Urasawa", "VizMedia", 1969, "Mystery", false);
    	
    	//Dummy Students (PREPEI NA TA VALOUME SE LISTA)
    	Student student1 = new Student(01, "Joe", "Smith", "6912345678", "JoeSmith@gmail.com", "21-05-2003", "E24194", "Digital Systems", 5);
    	Student student2 = new Student(02, "Jane", "Jacobs","6978553556", "JaneJacbos@gmail.com", "31-12-1999","E20110", "Economics", 5);
    	Student student3 = new Student(03, "Julie", "Georgiou","6942717220", "JulieGe@gmail.com", "15-12-2006", "E24167", "Digital Systems", 5);
    	Student student4 = new Student(04, "Giannis", "Giannopoulos", "6981325430", "G.Giannopoulos@gmail.com", "04-07-2005", "E23010", "Digital Systems", 7);
    	Student student5 = new Student(05, "Anne", "Doe", "6930219087", "AnneDoe@gmail.com", "10-04-2006", "E24189", "Economics", 5);
    	}
    		
=======
    private static void dummyObjects() {
        // Dummy books
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
        // Dummy students
        studentList.add(new Student(1, "Joe", "Smith", "6912345678", "JoeSmith@gmail.com", "21-05-2003", "E24194", "Digital Systems", 5));
        studentList.add(new Student(2, "Jane", "Jacobs", "6978553556", "JaneJacbos@gmail.com", "31-12-1999", "E20110", "Economics", 5));
        studentList.add(new Student(3, "Julie", "Georgiou", "6942717220", "JulieGe@gmail.com", "15-12-2006", "E24167", "Digital Systems", 5));
        studentList.add(new Student(4, "Giannis", "Giannopoulos", "6981325430", "G.Giannopoulos@gmail.com", "04-07-2005", "E23010", "Digital Systems", 7));
        studentList.add(new Student(5, "Anne", "Doe", "6930219087", "AnneDoe@gmail.com", "10-04-2006", "E24189", "Economics", 5));
    }
}
>>>>>>> 84e52ed1d378c566c5078c01153cf5bd1832d62f

