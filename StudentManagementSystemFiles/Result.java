package StudentManagementSystem;
import java.util.*;

public class Result {
    private static List<String> records = new ArrayList<>();

    public static void saveResult(String student, String subject, String status) {
        records.add("Student: " + student + ", Subject: " + subject + ", Result: " + status);
    }

    public static void view(String student) {
        System.out.println("--- Results for " + student + " ---");
        for (String r : records) {
            if (r.contains(student)) System.out.println(r);
        }
    }

    public static void viewAll() {
        System.out.println("--- All Results ---");
        for (String r : records) System.out.println(r);
    }
}
