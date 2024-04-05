import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.Year;


public class RunShop {
	
    private static List<String[]> users = CSVManager.readFromCSV("user_data.csv");
    private static List<Car> cars = loadAllCars.loadCarsFromCSV();
    private static String[] tempToken = null;
    
    private static List<IssueTicket> issuedTickets = new ArrayList<>();
    
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
	            
	        } else { System.out.println("User information not found in system.");}
	        
	        tries++;
	        
	        if(tries > 0)
	        	System.out.println("Login attempts left: " + (MAX_TRIES - tries));
	        
	        if(tries == MAX_TRIES)
	        	System.out.println("Maximum login attempts achieved. Please try again some other time.");
	        	Log.log(username, "attempted to log in for more than 3 times");
	    
    	}
        
        scanner.close();
        
    }
    

    // Method to check user login
    private static boolean checkUserLogin(String username, String password, List<String[]> users) {
    	
        for (String[] user : users) {
            if (user[6].equals(username) && user[7].equals(password)) {tempToken = user; return true;}
            
            
        }
        return false;
    }
    
    
    private static void printAllCars() {
    	for (Car car : cars) { car.displayDetails(); System.out.println();}
    }
    
    
    public static void printConditionCars(String usedornew) {
        for (Car car : cars) {
            if (usedornew.equals(car.getCondition())) {
                car.displayDetails();
                System.out.println(); // Adds an empty line between car details for readability
            }
        }
    }
    
    
    public static boolean canPurchaseCar(String username, String ID) {
    	
        if (tempToken == null) {
            System.out.println("No user is currently logged in.");
            return false;
        }
        

        float userFunds = Float.parseFloat(tempToken[3]);
        
       

        for (Car car : cars) {
        	System.out.println(car.getId());
            if (Integer.parseInt(ID) == car.getId()) {
            
            	
          
                if (userFunds >= car.getPrice()) {
                	
                	if(car.getCarsAvailable() > 0) {
                		
                		
                		
                		IssueTicket ticket = new IssueTicket(ID, username, car.getType(), car.getModel(), Year.now().getValue(),  car.getColor());
                		issuedTickets.add(ticket);
                		ticket.getDetails();
                		
                        List<String[]> dataToWrite = new ArrayList<>();
                        dataToWrite.add(ticket.CSVparser());
                        
                       
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
                + "3. Buy\n"
                + "4. View Tickets\n"
                + "5. Sign out");

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
                System.out.println("Buy");
                
                System.out.println("Enter ID of car: ");
                String IDInput = scanner.nextLine();
                if(canPurchaseCar(username, IDInput)) {
                	
                	System.out.println("Car Purchased. Thank you for your business!");
                	
                }
                else { System.out.println("Unable to purchase the car");}
                mainmenu(username);
                
                break;
                
            case "4":
                System.out.println("Viewing tickets...");
                
                //WRONG fix
                for (IssueTicket ticket : issuedTickets) {
                    
                    if (ticket.getUsername().equals(username)) {
                    
                        ticket.getDetails();
                        System.out.println();
                    }
                }
                mainmenu(username);
                break;
            case "5":
                System.out.println("Signing out...");
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