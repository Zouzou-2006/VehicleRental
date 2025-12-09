package Final;
import java.io.*;
import java.util.regex.*;

/**
 * Utility class with input validation methods for the Vehicle Rental System
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class FinalProject {

	 // ------------------------------------------------------------
    // Read String (no validation)
    // ------------------------------------------------------------
	/**
	 * Read a string from user input
	 * @return The string entered by the user
	 */
    public static String ReadStringFromUser() {
        try {
            BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
            return burInput.readLine().trim();
        } catch (IOException e) {
            return "";
        }
    }

    // ------------------------------------------------------------
    // Read Integer With Validation
    // ------------------------------------------------------------
	/**
	 * Read an integer from user input with validation
	 * @return The integer entered by the user
	 */
    public static int ReadIntegerFromUser() {
        while (true) {
            try {
                BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
                String strBuffer = burInput.readLine().trim();
                return Integer.parseInt(strBuffer);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number:");
            }
        }
    }

    // ------------------------------------------------------------
    // Read Float With Validation
    // ------------------------------------------------------------
	/**
	 * Read a float from user input with validation
	 * @return The float entered by the user
	 */
    public static float ReadFloatFromUser() {
        while (true) {
            try {
                BufferedReader burInput = new BufferedReader(new InputStreamReader(System.in));
                String strBuffer = burInput.readLine().trim();
                return Float.parseFloat(strBuffer);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }
    
    // ------------------------------------------------------------
    // Validate Phone Number - accepts (xxx) xxx-xxxx or xxx-xxx-xxxx
    // ------------------------------------------------------------
	/**
	 * Validate phone number using regular expressions
	 * @param strPhoneNumber The phone number to validate
	 * @return true if valid, false otherwise
	 */
    public static boolean IsValidPhoneNumber(String strPhoneNumber) {
        // Accepts two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx
        String strPattern = "^(\\(\\d{3}\\)\\s?\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(strPhoneNumber);
        return matcher.matches();
    }
    
    // ------------------------------------------------------------
    // Validate Email Address
    // ------------------------------------------------------------
	/**
	 * Validate email address using regular expressions
	 * Must begin with a character, have @ sign, and extension of 2 to 6 characters
	 * @param strEmail The email address to validate
	 * @return true if valid, false otherwise
	 */
    public static boolean IsValidEmailAddress(String strEmail) {
        // Must begin with character, have @, and extension of 2-6 characters
        String strPattern = "^[a-zA-Z][a-zA-Z0-9._-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(strEmail);
        return matcher.matches();
    }
    
    // ------------------------------------------------------------
    // Validate Vehicle Number (1 to 3)
    // ------------------------------------------------------------
	/**
	 * Validate the number of vehicles to rent (must be between 1 and 3)
	 * @param intVehicleNumber The number of vehicles
	 * @return true if valid (1-3), false otherwise
	 */
    public static boolean IsValidVehicleNumber(int intVehicleNumber) {
        return (intVehicleNumber >= 1 && intVehicleNumber <= 3);
    }
    
    // ------------------------------------------------------------
    // MAIN PROGRAM - For testing only
    // ------------------------------------------------------------
	/**
	 * Main method for testing utility functions
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {

        System.out.println("Testing validation methods...");
        
        // Test phone validation
        System.out.println("\nPhone Number Tests:");
        System.out.println("(513) 123-4567: " + IsValidPhoneNumber("(513) 123-4567"));
        System.out.println("513-123-4567: " + IsValidPhoneNumber("513-123-4567"));
        System.out.println("invalid: " + IsValidPhoneNumber("invalid"));
        
        // Test email validation
        System.out.println("\nEmail Address Tests:");
        System.out.println("test@email.com: " + IsValidEmailAddress("test@email.com"));
        System.out.println("user123@domain.edu: " + IsValidEmailAddress("user123@domain.edu"));
        System.out.println("@invalid.com: " + IsValidEmailAddress("@invalid.com"));
        
        // Test vehicle number validation
        System.out.println("\nVehicle Number Tests:");
        System.out.println("1: " + IsValidVehicleNumber(1));
        System.out.println("3: " + IsValidVehicleNumber(3));
        System.out.println("4: " + IsValidVehicleNumber(4));
    }

}
