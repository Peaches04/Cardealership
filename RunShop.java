import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.Year;

/**
 * The {@code RunShop} class implements a simple console-based car shop application.
 * It allows users to log in, view available cars, filter cars by condition (new or used),
 * purchase cars, and view their issued tickets for purchases. Car and user data are managed
 * through CSV files.
 */
public class RunShop {
    
    private static List<String[]> users = CSVManager.readFromCSV("user_data.csv");
    private static List<Car> cars = loadAllCars.loadCarsFromCSV();
    private static String[] tempToken = null;
    
    private static List<IssueTicket> issuedTickets = new ArrayList<>();
    
    /**
     * The main method to run the car shop application. It handles user login and redirects
     * to the main menu upon successful authentication.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        int tries = 0;
        Scanner scanner = new Scanner(System.in);
        final int MAX_TRIES = 3;
        
        while(tries < MAX_TRIES) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            if (checkUserLogin(username, password, users)) {
                System.out.println("Welcome " + username);
                Log.log(username, "logged in");
                mainmenu(username);
                break;
            } else {
                System.out.println("User information not found in system.");
            }
            
            tries++;
            
            if(tries > 0)
                System.out.println("Login attempts left: " + (MAX_TRIES - tries));
            
            if(tries == MAX_TRIES)
                System.out.println("Maximum login attempts achieved. Please try again some other time.");
                Log.log(username, "attempted to log in for more than 3 times");
        }
        
        scanner.close();
    }
    
    /**
     * Checks if the provided username and password match a user in the system.
     * 
     * @param username The username of the user trying to log in.
     * @param password The password of the user trying to log in.
     * @param users A list of user data loaded from a CSV file.
     * @return true if the user is found and credentials match; false otherwise.
     */
    private static boolean checkUserLogin(String username, String password, List<String[]> users) {
        for (String[] user : users) {
            if (user[6].equals(username) && user[7].equals(password)) {
                tempToken = user;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Prints details of all cars available in the shop.
     */
    private static void printAllCars() {
        for (Car car : cars) {
            car.displayDetails();
            System.out.println(); 
        }
    }
    
    /**
     * Prints details of cars filtered by their condition (new or used).
     * 
     * @param usedornew The condition of the cars to display. Should be either "New" or "Used".
     */
    public static void printConditionCars(String usedornew) {
        for (Car car : cars) {
            if (usedornew.equals(car.getCondition())) {
                car.displayDetails();
                System.out.println(); // Adds an empty line between car details for readability
            }
        }
    }
    
    /**
     * Attempts to purchase a car with the given ID for the currently logged-in user. If the user has enough funds
     * and there is enough cars available, the car is purchased. Then it issues a ticket for the customer and saves it in the 
     * issue_tickets.csv file. 
     * 
     * @param username The username of the buyer.
     * @param ID The ID of the car to purchase.
     * @return true if the purchase is successful; false otherwise.
     */
    public static boolean purchaseCar(String username, String ID) {
        if (tempToken == null) {
            System.out.println("No user is currently logged in.");
            return false;
        }
        
        float userFunds = Float.parseFloat(tempToken[3]);
        
        for (Car car : cars) {
            if (Integer.parseInt(ID) == car.getId()) {
                if (userFunds >= car.getPrice()) {
                    if(car.getCarsAvailable() > 0) {
                        IssueTicket ticket = new IssueTicket(ID, username, car.getType(), car.getModel(), Year.now().getValue(), car.getColor());
                        issuedTickets.add(ticket);
                        ticket.getDetails();
                        
                        List<String[]> dataToWrite = new ArrayList<>();
                        dataToWrite.add(ticket.CSVparser());
                        car.setCarsAvailable(car.getCarsAvailable() - 1);
                        
                        CSVManager.writeToCSV("issued_tickets.csv", dataToWrite);
                        return true; 
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * Displays the main menu of the application and handles user navigation.
     * 
     * @param username The username of the currently logged-in user.
     */
    private static void mainmenu(String username) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Miner Cars main menu");
        System.out.println("Please input the corresponding number for the menu you wish to go to:");
        System.out.println("1. Display all cars.\n"
                + "2. Filter Cars (used / new)\n"
                + "    1) New\n"
                + "        (Print info)\n"
                + "    2) Used\n"
                + "        (Print info)\n"
                + "    3) Go back\n"
                + "3. Purchase a car\n"
                + "4. View Tickets\n"
                + "5. Sign out and Exit");

        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("Displaying all cars...");
                printAllCars();
                Log.log(username, "printed all cars");
                mainmenu(username);
                break;
                
            case "2":
                System.out.println("Filter options:");
                System.out.println("1) New\n2) Used\n3) Go back");
                String filterInput = scanner.nextLine();
                
                switch (filterInput) {
                    case "1":
                        System.out.println("New Cars:");
                        printConditionCars("New");
                        Log.log(username, "printed new cars");
                        mainmenu(username);
                        break;
                        
                    case "2":
                        System.out.println("Used Cars:");
                        printConditionCars("Used");
                        Log.log(username, "printed used cars");
                        mainmenu(username);
                        break;
                        
                    case "3":
                        System.out.println("Going back to the main menu...");
                        mainmenu(username); // Recursive call to show the menu again
                        break;
                        
                    default:
                        System.out.println("Invalid option");
                        mainmenu(username);
                        break;
                }
                break;
                
            case "3":
                System.out.println("Enter ID of car: ");
                String IDInput = scanner.nextLine();
                if(purchaseCar(username, IDInput)) {
                    System.out.println("Car Purchased. Thank you for your business!");
                    Log.log(username, "purchased a car");
                }
                else {
                    System.out.println("Unable to purchase the car");
                    Log.log(username,"failed to purchase a car");
                }
                mainmenu(username);
                break;
                
            case "4":
                System.out.println("Viewing tickets...");
                IssueTicket.viewTicketsForUser(username, "issued_tickets.csv");
                Log.log(username, "viewed tickets");
                mainmenu(username);
                break;
                
            case "5":
                System.out.println("Signed out");
                List<String[]> carDataToWrite = new ArrayList<>();
                for (Car car : cars) {
                    String[] carData = car.ArrayListToCSV();
                    carDataToWrite.add(carData);
                }
                CSVManager.updateCSV("car_data.csv", carDataToWrite);
                Log.log(username, "signed out");
                break;
                
            default:
                System.out.println("Invalid option. Please try again.");
                mainmenu(username);
                break;
        }

        scanner.close(); 
    }
}