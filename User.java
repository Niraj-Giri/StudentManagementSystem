package StudentManagementSystem;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void menu();

    public String getName() {
        return name;
    }
}
