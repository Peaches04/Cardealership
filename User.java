public class User extends Person {
    private String email;

    public User(String name, int age, String email) {
        super(name, age);
        this.email = email;
    }

    @Override
    public void displayInfo() {
        System.out.println("User Name: " + name + ", Age: " + age + ", Email: " + email);
    }
}