package StudentManagementSystem;

public class Subject {
    private String name;
    private ExamPaper examPaper;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExamPaper(ExamPaper paper) {
        this.examPaper = paper;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }
}
