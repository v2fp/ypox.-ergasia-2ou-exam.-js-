package lab.unipi.gui.JavaFXLab;

public class Student extends User {// υπολαση του user
    private String studentId;
    private String department;
    private int maxBooks;

    //Constructor
    public Student(int id, String firstName, String lastName, String phone, String email, String birthDate,
                   String studentId, String department, int maxBooks) {
        super(id, firstName, lastName, phone, email, birthDate);
        this.studentId = studentId;
        this.department = department;
        this.maxBooks = maxBooks;
    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public String getDepartment() {
        return department;
    }

    public int getMaxBooks() {
        return maxBooks;
    }

    //Setters
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Student ID: " + studentId + "\n" +
               "Department: " + department + "\n" +
               "Max Books: " + maxBooks;
    }
}
package lab.unipi.gui.JavaFXLab;

    public class Librarian extends User {
        private String workDepartment;
        private String educationLevel;

        //Constructor
        public Librarian(int id, String firstName, String lastName, String phone, String email, String birthDate,
                         String workDepartment, String educationLevel) {
            super(id, firstName, lastName, phone, email, birthDate);
            this.workDepartment = workDepartment;
            this.educationLevel = educationLevel;
        }

        //Getters
        public String getWorkDepartment() {
            return workDepartment;
        }

        public String getEducationLevel() {
            return educationLevel;
        }

        //Setters
        public void setWorkDepartment(String workDepartment) {
            this.workDepartment = workDepartment;
        }

        public void setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
        }

        //toString
        @Override
        public String toString() {
            return super.toString() + "\n" +
                   "Work Department: " + workDepartment + "\n" +
                   "Education Level: " + educationLevel;
        }
    }