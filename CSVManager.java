import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {


    public static void writeToCSV(String filePath, List<String[]> data) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            for (String[] rowData : data) {
                writer.println(String.join(",", rowData));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }

    public static List<String[]> readFromCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return data;
    }
}