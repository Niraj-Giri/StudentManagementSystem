package StudentManagementSystem;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Admin admin = new Admin("admin", "1234");
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Admin Login\n2. Student Login\n3. Register Student\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> admin.login();
                case 2 -> studentLogin();
                case 3 -> registerStudent();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void studentLogin() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                s.menu();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void registerStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        Student s = new Student(name, age, email, phone);
        students.add(s);
        System.out.println("Student registered successfully.");
        System.out.println("Your Student ID is: " + s.getStudentId());
    }
}
