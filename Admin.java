package StudentManagementSystem;

import java.util.*;

public class Admin extends User {
    private String password;
    private static List<Branch> branches = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Admin(String name, String password) {
        super(name);
        this.password = password;
    }

    public void login() {
        System.out.print("Enter password: ");
        String input = sc.nextLine();
        if (input.equals(password)) menu();
        else System.out.println("Wrong password.");
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Branch\n2. Add Subject\n3. Add Exam Paper\n4. View Student Results\n5. Logout");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addBranch();
                case 2 -> addSubject();
                case 3 -> addExamPaper();
                case 4 -> Result.viewAll();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addBranch() {
        System.out.print("Enter branch name: ");
        String name = sc.nextLine();
        branches.add(new Branch(name));
        System.out.println("Branch added.");
    }

    private void addSubject() {
        System.out.print("Enter branch name: ");
        String branchName = sc.nextLine();
        Branch b = findBranch(branchName);
        if (b != null) {
            System.out.print("Enter subject name: ");
            String sub = sc.nextLine();
            b.addSubject(new Subject(sub));
            System.out.println("Subject added.");
        } else System.out.println("Branch not found.");
    }

    private void addExamPaper() {
        System.out.print("Enter branch: ");
        String branchName = sc.nextLine();
        Branch b = findBranch(branchName);
        if (b == null) {
            System.out.println("Branch not found.");
            return;
        }
        System.out.print("Enter subject: ");
        String subjectName = sc.nextLine();
        Subject sub = b.findSubject(subjectName);
        if (sub != null) {
            System.out.print("Enter question: ");
            String question = sc.nextLine();
            System.out.print("Enter correct answer: ");
            String ans = sc.nextLine();
            sub.setExamPaper(new ExamPaper(question, ans));
            System.out.println("Exam paper added.");
        } else System.out.println("Subject not found.");
    }

    public static Branch findBranch(String name) {
        for (Branch b : branches) {
            if (b.getName().equalsIgnoreCase(name)) return b;
        }
        return null;
    }

    public static List<Branch> getBranches() {
        return branches;
    }
}
