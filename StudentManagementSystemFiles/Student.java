package StudentManagementSystem;

import java.util.*;
public class Student extends User {
    private static int counter = 1000;
    private final String studentId;
    private int age;
    private String email;
    private String phone;
    private Branch branch;
    private List<Subject> selectedSubjects = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Student(String name, int age, String email, String phone) {
        super(name);
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.studentId = "STU" + (++counter);
    }

    public String getStudentId() {
        return studentId;
    }

    public void showProfile() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        if (branch != null) System.out.println("Branch: " + branch.getName());
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("\n--- Student Menu [" + studentId + "] ---");
            System.out.println("1. View Profile\n2. Select Branch\n3. Choose Subjects\n4. Give Exam\n5. View Results\n6. Logout");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> showProfile();
                case 2 -> selectBranch();
                case 3 -> chooseSubjects();
                case 4 -> giveExam();
                case 5 -> Result.view(name);
                case 6 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void selectBranch() {
        List<Branch> branches = Admin.getBranches();
        if (branches.isEmpty()) {
            System.out.println("No branches available.");
            return;
        }
        System.out.println("Available branches:");
        for (Branch b : branches) System.out.println("- " + b.getName());
        System.out.print("Enter branch: ");
        String name = sc.nextLine();
        Branch b = Admin.findBranch(name);
        if (b != null) {
            branch = b;
            System.out.println("Branch selected.");
        } else System.out.println("Branch not found.");
    }

    private void chooseSubjects() {
        if (branch == null) {
            System.out.println("Select branch first.");
            return;
        }
        System.out.println("Available subjects:");
        for (Subject s : branch.getSubjects()) System.out.println("- " + s.getName());
        System.out.print("Enter subject name to choose: ");
        String name = sc.nextLine();
        Subject s = branch.findSubject(name);
        if (s != null) {
            selectedSubjects.add(s);
            System.out.println("Subject added.");
        } else System.out.println("Subject not found.");
    }

    private void giveExam() {
        for (Subject s : selectedSubjects) {
            ExamPaper p = s.getExamPaper();
            if (p == null) {
                System.out.println("No exam paper for " + s.getName());
                continue;
            }
            System.out.println("Question: " + p.getQuestion());
            System.out.print("Answer: ");
            String ans = sc.nextLine();
            boolean correct = p.getAnswer().equalsIgnoreCase(ans);
            Result.saveResult(name, s.getName(), correct ? "Pass" : "Fail");
        }
    }
}
