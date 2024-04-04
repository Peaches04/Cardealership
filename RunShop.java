import java.util.List;
import java.util.Scanner;


public class RunShop {
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
     
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        

        List<String[]> users = CSVManager.readFromCSV("user_data.csv");
        
        if (checkUserLogin(username, password, users)) {
            System.out.println("Welcome " + username);
            Logger.log(username, "logged in");
        } else {
            System.out.println("User information not found in system.");
        }
        
        scanner.close();
    }

    // Method to check user login
    private static boolean checkUserLogin(String username, String password, List<String[]> users) {
        for (String[] user : users) {
        	
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
}