package StudentManagementSystem;
import java.util.*;

public class Branch {
    private String name;
    private List<Subject> subjects = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public void addSubject(Subject sub) {
        subjects.add(sub);
    }

    public Subject findSubject(String name) {
        for (Subject s : subjects) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
