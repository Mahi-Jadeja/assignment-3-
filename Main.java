
// Main class containing menu-driven program

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.displayStudents(); break;
                case 3: manager.searchByPrn(); break;
                case 4: manager.searchByName(); break;
                case 5: manager.updateStudent(); break;
                case 6: manager.deleteStudent(); break;
                case 7: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
