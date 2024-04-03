public class Log {
    private String message;

    public Log(String message) {
        this.message = message;
    }

    public void displayLog() {
        System.out.println("Log: " + message);
    }
}