import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Represents a ticket for a purchasing a car, encapsulates details ID, username,
 * car type, model, year, and color.
 */
public class IssueTicket {
    private String ID;
    private String username;
    private String carType;
    private String model;
    private int year;
    private String color;
    
    /**
     * Constructs an IssueTicket with the specified details.
     * 
     * @param ID The unique identifier for the ticket.
     * @param username The username of the user associated with the ticket.
     * @param carType The type of car associated with the ticket.
     * @param model The model of the car.
     * @param year The year of manufacture of the car.
     * @param color The color of the car.
     */
    public IssueTicket(String ID, String username, String carType, String model, int year, String color) {
        this.ID = ID;
        this.username = username;
        this.carType = carType;
        this.model = model;
        this.year = year;
        this.color = color;
    }
    
    /**
     * Displays tickets for a specified user from a CSV file.
     * 
     * @param username The username to filter tickets by.
     * @param filePath The path of the CSV file containing tickets data.
     */
    public static void viewTicketsForUser(String username, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] ticketData = line.split(",");
                if (ticketData.length > 1 && ticketData[1].trim().equalsIgnoreCase(username.trim())) {
                    System.out.println(" Car ID: " + ticketData[0] +
                        "\n Username: " + ticketData[1] +
                        "\n Car Type: " + ticketData[2] +
                        "\n Model: " + ticketData[3] +
                        "\n Year: " + ticketData[4] +
                        "\n Color: " + ticketData[5]);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the tickets: " + e.getMessage());
        }
    }
    
    // Getters
    
    /**
     * @return The ID of the ticket.
     */
    public String getID() {
        return ID;
    }

    /**
     * @return The username associated with the ticket.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The car type associated with the ticket.
     */
    public String getCarType() {
        return carType;
    }

    /**
     * @return The model of the car associated with the ticket.
     */
    public String getModel() {
        return model;
    }

    /**
     * @return The year of manufacture of the car associated with the ticket.
     */
    public int getYear() {
        return year;
    }

    /**
     * @return The color of the car associated with the ticket.
     */
    public String getColor() {
        return color;
    }

    // Setters
    
    /**
     * Sets the ID of the ticket.
     * @param ID The new ID.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Sets the username associated with the ticket.
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the car type for the ticket.
     * @param carType The new car type.
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * Sets the model of the car for the ticket.
     * @param model The new model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the year of manufacture of the car for the ticket.
     * @param year The new year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets the color of the car for the ticket.
     * @param color The new color.
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Prints the details of the ticket.
     */
    public void getDetails() {
        System.out.println(username + " car ticket: \n" + "Car Type: " + carType + "\nModel: " + model + "\nYear: " + year + "\nColor: " + color);
    }

    /**
     * Parses the ticket details into String[] type for CSV storage.
     * 
     * @return A String array representing the ticket details.
     */
    public String[] CSVparser() {
        return new String[]{ID, username, carType, model, String.valueOf(year), color};
    }
}