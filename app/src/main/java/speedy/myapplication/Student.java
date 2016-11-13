package speedy.myapplication;

/**
 * Created by Hafta_Sonu on 12.11.2016.
 */

public class Student {

    String studentName;
    String studentDepartment;
    int studentNumber;


    public Student(String studentName, String studentDepartment, int studentNumber) {
        this.studentName = studentName;
        this.studentDepartment = studentDepartment;
        this.studentNumber = studentNumber;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
