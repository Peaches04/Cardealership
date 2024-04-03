public class Admin extends Person {
    private String department;

    public Admin(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Name: " + name + ", Age: " + age + ", Department: " + department);
    }
}