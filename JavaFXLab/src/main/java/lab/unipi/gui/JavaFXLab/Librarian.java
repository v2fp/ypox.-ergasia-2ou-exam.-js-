package lab.unipi.gui.JavaFXLab;

    public class Librarian extends User {//υποκλαση του user
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