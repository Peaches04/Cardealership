import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality to load user information from a CSV file and
 * create User objects.
 */
public class loadAllUsers {
	
    /**
     * Static variable to hold the header from the user CSV file. This header is used
     * to used when updating the CSV file to append. 
     */
	public static String[] header;

    /**
     * Reads user data from a CSV file and initializes a list of User objects
     * based on the data.
     * <p>
     * The first row of the CSV is expected to be a header row and is skipped.
     * Each row after the header is used to instantiate a User object with the values
     * from the row.
     *
     * @return A list of User objects initialized with the data read from the CSV.
     */
    public static List<User> loadUsersFromCSV() {
        boolean isFirstRow = true;
        List<String[]> userData = CSVManager.readFromCSV("user_data.csv");
        List<User> users = new ArrayList<>();

        for (String[] userInfo : userData) {
            if (isFirstRow) {
                isFirstRow = false; // Skip the header row
                header = userInfo;
                continue;
            }
            try {
                int ID = Integer.parseInt(userInfo[0]);
                String firstName = userInfo[1];
                String lastName = userInfo[2];
                float moneyAvailable = Float.parseFloat(userInfo[3]);
                int carsPurchased = Integer.parseInt(userInfo[4]);
                boolean minerCarsMembership = Boolean.parseBoolean(userInfo[5]);
                String username = userInfo[6];
                String password = userInfo[7];

                User user = new User(ID, firstName, lastName, moneyAvailable, carsPurchased, minerCarsMembership, username, password);
                users.add(user);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing user data: " + e.getMessage());
            }
        }

        return users;
    }
}