// StudentManager.java
// Manages student operations using an ArrayList

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Add a new student
    public void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = scanner.next();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter DOB (dd/MM/yyyy): ");
        String dobStr = scanner.next();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        try {
            students.add(new Student(prn, name, sdf.parse(dobStr), marks));
            System.out.println("Student added successfully!\n");
        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        }
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search student by PRN
    public void searchByPrn() {
        System.out.print("Enter PRN: ");
        String prn = scanner.next();
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Search student by Name
    public void searchByName() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Update Student Details
    public void updateStudent() {
        System.out.print("Enter PRN of student to update: ");
        String prn = scanner.next();
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                System.out.print("Enter new Name: ");
                student.setName(scanner.next());
                System.out.print("Enter new Marks: ");
                student.setMarks(scanner.nextDouble());
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Delete a student
    public void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        String prn = scanner.next();
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
