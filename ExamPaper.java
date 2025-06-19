package StudentManagementSystem;
public class ExamPaper {
    private String question;
    private String answer;

    public ExamPaper(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
