
import java.util.Scanner;


/**
 * The {@code RunShop} class implements a simple console-based car shop application.
 * It allows users to log in, view available cars, filter cars by condition (new or used),
 * purchase cars, and view their issued tickets for purchases. Car and user data are managed
 * through CSV files.
 */
public class RunShop {
    
	
	/**
	 * Manages all car-related operations including loading cars, processing car purchases, and managing inventory.
	 * This instance of {@link CarManager} is used throughout the application to interface with car data.
	 */
    private static CarManager carManager = new CarManager();
    
    /**
     * Manages user-related operations, user authentication and user data management.
     * This instance of {@link UserManager} is initialized with a reference to {@code carManager} to allow
     * user operations that may affect car data, such as car purchases.
     */
    private static UserManager userManager = new UserManager(carManager);
    
    /**
     * Represents an administrator who can perform administrative actions such as adding or removing cars or users.
     * This instance of {@link Admin} may be initialized as needed to perform administrative tasks within the application.
     */
    private static Admin admin;

 

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
    
            if (userManager.authenticateUser(username, password)) {
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
     * Retrieves boolean input from the user in response to a specific prompt. This method ensures that
     * the input is correctly parsed to a boolean by accepting only 'yes' or 'no' answers.
     *
     * @param scanner The scanner object to read the user's input.
     * @param prompt The prompt to display to the user, asking for a 'yes' or 'no' response.
     * @return The boolean value corresponding to the user's input ('yes' returns true, 'no' returns false).
     */
    private static boolean getBooleanInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
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
                + "5. Sign out and Exit\n"
                + "6. Return Car\n"
                + "7. Admin Panel");

        String input = scanner.nextLine();

        try {
        switch (input) {
        
        
        
            case "1":
                System.out.println("Displaying all cars...");
                carManager.printAllCars();
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
                        carManager.printConditionCars("New");
                        Log.log(username, "printed new cars");
                        mainmenu(username);
                        break;
                        
                    case "2":
                        System.out.println("Used Cars:");
                        carManager.printConditionCars("Used");
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
                if(carManager.purchaseCar(username, IDInput, userManager)) {
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

            	
                carManager.saveCarsToCSV();
                
                
                
                userManager.saveUsersToCSV();  
                
                
                userManager.logout();
                
                Log.log(username, "signed out");
                
                userManager.clearTempToken();
                
                break;
            case "6":
            	
            	System.out.println("Enter Car ID to return: ");
            	int carID = scanner.nextInt();
            	
            	userManager.returnCar(username, carID);
            	mainmenu(username);
            	break;
            	
            case "7":
            	AdminPanel(username);
                
            default:
                System.out.println("Invalid option. Please try again.");
                mainmenu(username);
                
                break;
        }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
            mainmenu(username);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            mainmenu(username);
        }
        

        scanner.close(); 
    }
    
    
    /**
     * Displays and manages the Admin Panel, allowing admin-level operations such as adding or removing cars,
     * adding users, and getting revenue. 
     * 
     * @param username The username of the administrator.
     */
    private static void AdminPanel(String username) {
    	
    	admin = new Admin("admin", "admin", carManager, userManager);

        System.out.println("Accessing Admin Panel...");
        System.out.println("Select admin option: \n"
        		+ "1. Add Car\n"
        		+ "2. Get Revenue by Id and by Car Type \n"
        		+ "3. Remove Car\n"
        		+ "4. Add User\n"
        		+ "Main Menu");
        
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        try {
        switch (input) {
        case "1":
            System.out.println("Enter Car Type:");
            String type = scanner.nextLine();
            System.out.println("Enter Model:");
            String model = scanner.nextLine();
            System.out.println("Enter Condition (new/used):");
            String condition = scanner.nextLine();
            System.out.println("Enter Color:");
            String color = scanner.nextLine();
            System.out.println("Enter Capacity:");
            int capacity = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Year:");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Fuel Type:");
            String fuelType = scanner.nextLine();
            System.out.println("Enter Transmission:");
            String transmission = scanner.nextLine();
            System.out.println("Enter VIN:");
            String vin = scanner.nextLine();
            System.out.println("Enter Price:");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter Cars Available:");
            int carsAvailable = Integer.parseInt(scanner.nextLine());
            boolean hasTurbo = getBooleanInput(scanner, "Has Turbo (yes/no):");
            admin.addCar(type, model, condition, color, capacity, year, fuelType, transmission, vin, price, carsAvailable, hasTurbo);
            AdminPanel(username);
            break;

        case "2":
            System.out.println("Enter Car Type or ID:");
            String identifier = scanner.nextLine();
            admin.getRevenueByIDOrType(identifier);
            AdminPanel(username);
            break;

        case "3":
            System.out.println("Enter the VIN of the car you wish to remove:");
            String removeVin = scanner.nextLine();
            admin.removeCar(removeVin);
            AdminPanel(username);
            break;

        case "4":
            System.out.println("Enter User ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter First Name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter Last Name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter Money Available:");
            float moneyAvailable = Float.parseFloat(scanner.nextLine());
            System.out.println("Enter Cars Purchased:");
            int carsPurchased = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter MinerCars Membership (true/false):");
            System.out.println("Note: any input other than true will be false");
            boolean minerCarsMembership = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Enter Username:");
            String username_two = scanner.nextLine();
            System.out.println("Enter Password:");
            String password = scanner.nextLine();
            admin.addUser(id, firstName, lastName, moneyAvailable, carsPurchased, minerCarsMembership, username_two, password);
            System.out.println("User added successfully.");
            AdminPanel(username);
            break;
        case "5":
        	
        	mainmenu(username);
        	break;

        default:
            System.out.println("Invalid option. Please try again.");
            AdminPanel(username);
            break;
        }       
        }catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
            AdminPanel(username);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            AdminPanel(username);
        }
   
    }
}