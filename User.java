/**
 * Represents a user in the car shop application.
 */
public class User {
    // User attributes
    private int ID;
    private String firstName;
    private String lastName;
    private float moneyAvailable;
    private int carsPurchased;
    private boolean minerCarsMembership;
    private String username;
    private String password;

    /**
     * Constructs a new User with the specified details.
     *
     * @param ID The unique identifier for the user.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param moneyAvailable The amount of money available to the user for purchases.
     * @param carsPurchased The number of cars the user has purchased.
     * @param minerCarsMembership Indicates whether the user has a MinerCars membership.
     * @param username The user's login username.
     * @param password The user's login password.
     */
    public User(int ID, String firstName, String lastName, float moneyAvailable, int carsPurchased, boolean minerCarsMembership, String username, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyAvailable = moneyAvailable;
        this.carsPurchased = carsPurchased;
        this.minerCarsMembership = minerCarsMembership;
        this.username = username;
        this.password = password;
    }

    /**
     * Converts user information into a format suitable for CSV storage.
     *
     * @return A String array representing the user's information.
     */
    public String[] ArrayListToCSV() {
        return new String[]{
            String.valueOf(ID),
            firstName,
            lastName,
            String.format("%.2f", moneyAvailable),
            String.valueOf(carsPurchased),
            String.valueOf(minerCarsMembership),
            username,
            password
        };
    }

    /**
     * Displays detailed information about the user.
     */
    public void displayInfo() {
        System.out.println("User ID: " + ID + ", First Name: " + firstName + ", Last Name: " + lastName + ", Money Available: " + moneyAvailable + ", Cars Purchased: " + carsPurchased + ", MinerCars Membership: " + (minerCarsMembership ? "Yes" : "No") + ", Username: " + username);
    }

    // Getters
    
    /**
     * Returns the user's ID.
     *
     * @return The user's ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Returns the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the amount of money available to the user.
     *
     * @return The user's money available.
     */
    public float getMoneyAvailable() {
        return moneyAvailable;
    }

    /**
     * Returns the number of cars purchased by the user.
     *
     * @return The number of cars purchased.
     */
    public int getCarsPurchased() {
        return carsPurchased;
    }

    /**
     * Checks if the user has a MinerCars membership.
     *
     * @return True if the user has a membership, false otherwise.
     */
    public boolean isMinerCarsMembership() {
        return minerCarsMembership;
    }

    /**
     * Returns the user's username.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    // Setters
    
    /**
     * Sets the ID of the user.
     *
     * @param ID The new ID for the user.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName The new first name for the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName The new last name for the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the amount of money available to the user.
     *
     * @param moneyAvailable The new amount of money available.
     */
    public void setMoneyAvailable(float moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    /**
     * Sets the number of cars purchased by the user.
     *
     * @param carsPurchased The new number of cars purchased.
     */
    public void setCarsPurchased(int carsPurchased) {
        this.carsPurchased = carsPurchased;
    }

    /**
     * Sets the MinerCars membership status of the user.
     *
     * @param minerCarsMembership The new MinerCars membership status.
     */
    public void setMinerCarsMembership(boolean minerCarsMembership) {
        this.minerCarsMembership = minerCarsMembership;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The new password for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}