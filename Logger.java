import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE_PATH = "Log.txt";

    // Enhanced log method to support various actions
    public static void log(String username, String action) {
        try (FileWriter fw = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
            // Get the current date and time in the specified format
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss MM/dd/yy");
            String formattedDateTime = now.format(formatter);
            
            // Prepare the log message according to the provided format
            String logMessage = String.format("%s - %s %s", formattedDateTime, username, action);
            
            // Write the log message to file
            pw.println(logMessage);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the log file: " + e.getMessage());
        }
    }
}