package Final;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Main program for Vehicle Rental System
 * Displays rental locations, collects customer information, and calculates rental costs
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class CVehicleFinal {

	private static Connection m_conAdministrator;

	/**
	 * Open database connection to SQL Server
	 * @return true if connection successful, false otherwise
	 */
	public static boolean OpenDatabaseConnectionSQLServer() {
		boolean blnResult = false;

		try {
			// Use connection string with explicit port (bypasses SQL Browser)
			// I used AI for the connection since I had issues with mainly with Windows Authentication
			String connectionUrl = "jdbc:sqlserver://127.0.0.1:59440;"
					+ "databaseName=dbVehicleRental;"
					+ "user=sa;"
					+ "password=Zou@zou2006!@;"
					+ "encrypt=false;"
					+ "trustServerCertificate=true;";
			
			m_conAdministrator = java.sql.DriverManager.getConnection(connectionUrl);
			blnResult = true;
		} catch (Exception excError) {
			System.out.println("Cannot connect - error: " + excError.getMessage());
		}

		return blnResult;
	}

	/**
	 * Close database connection
	 * @return true if closed successfully, false otherwise
	 */
	public static boolean CloseDatabaseConnection() {
		boolean blnResult = false;

		try {
			if (m_conAdministrator != null) {
				if (m_conAdministrator.isClosed() == false) {
					m_conAdministrator.close();
					m_conAdministrator = null;
				}
			}
			blnResult = true;
		} catch (Exception excError) {
			System.out.println(excError);
		}

		return blnResult;
	}

	/**
	 * Display pickup locations from database
	 * @return true if successful, false otherwise
	 */
	public static boolean DisplayPickupLocations() {
		boolean blnResult = false;

		try {
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstLocations = null;

			// Build SQL query
			strSelect = "SELECT intLocationID, strName, strAddress, strCity, strZip " +
					"FROM TLocations " +
					"ORDER BY intLocationID";

			// Execute query
			sqlCommand = m_conAdministrator.createStatement();
			rstLocations = sqlCommand.executeQuery(strSelect);

			// Display header
			System.out.println("\nHere are the pickup locations - we will call you with a location confirmation");

			// Loop through results
			while (rstLocations.next()) {
				int intID = rstLocations.getInt("intLocationID");
				String strName = rstLocations.getString("strName");
				String strAddress = rstLocations.getString("strAddress");
				String strCity = rstLocations.getString("strCity");
				String strZip = rstLocations.getString("strZip");

				// Display formatted output with proper alignment
				System.out.printf("ID: %-4d Name: %-14s Address: %-16s City: %-12s Zip: %-10s%n",
						intID, strName, strAddress, strCity, strZip);
			}

			// Clean up
			rstLocations.close();
			sqlCommand.close();
			blnResult = true;

		} catch (Exception e) {
			System.out.println("Error loading locations: " + e);
		}

		return blnResult;
	}

	/**
	 * Main program entry point
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {

		try {
			System.out.println("===============================================");
			System.out.println("   WELCOME TO VEHICLE RENTAL SYSTEM");
			System.out.println("===============================================");

			// Connect to database and display locations
			if (OpenDatabaseConnectionSQLServer()) {
				DisplayPickupLocations();
			} else {
				System.out.println("Error: Could not connect to database");
				return;
			}

			System.out.println("\n===============================================");
			System.out.println("   CUSTOMER INFORMATION");
			System.out.println("===============================================");

			// Get customer name
			System.out.print("\nEnter Customer Name: ");
			String strCustomerName = FinalProject.ReadStringFromUser();

			// Get and validate phone number
			String strPhoneNumber = "";
			boolean blnValidPhone = false;
			while (!blnValidPhone) {
				System.out.print("Enter Phone Number [(xxx) xxx-xxxx or xxx-xxx-xxxx]: ");
				strPhoneNumber = FinalProject.ReadStringFromUser();
				blnValidPhone = FinalProject.IsValidPhoneNumber(strPhoneNumber);
				if (!blnValidPhone) {
					System.out.println("Invalid phone number format. Please try again.");
				}
			}

			// Get and validate email address
			String strEmail = "";
			boolean blnValidEmail = false;
			while (!blnValidEmail) {
				System.out.print("Enter Email Address: ");
				strEmail = FinalProject.ReadStringFromUser();
				blnValidEmail = FinalProject.IsValidEmailAddress(strEmail);
				if (!blnValidEmail) {
					System.out.println("Invalid email format. Please try again.");
				}
			}

			// Get rental days
			System.out.print("Enter Number of Rental Days: ");
			int intRentalDays = FinalProject.ReadIntegerFromUser();
			while (intRentalDays <= 0) {
				System.out.println("Rental days must be positive. Please try again.");
				System.out.print("Enter Number of Rental Days: ");
				intRentalDays = FinalProject.ReadIntegerFromUser();
			}

			// Get and validate number of vehicles
			int intNumVehicles = 0;
			boolean blnValidVehicleCount = false;
			while (!blnValidVehicleCount) {
				System.out.print("Enter Number of Vehicles to Rent (1-3): ");
				intNumVehicles = FinalProject.ReadIntegerFromUser();
				blnValidVehicleCount = FinalProject.IsValidVehicleNumber(intNumVehicles);
				if (!blnValidVehicleCount) {
					System.out.println("You can only rent 1 to 3 vehicles. Please try again.");
				}
			}

			// Array to store selected vehicles
			CVehicle[] arrVehicles = new CVehicle[intNumVehicles];
			double dblTotalRental = 0.0;

			// Get vehicle selections
			System.out.println("\n===============================================");
			System.out.println("   VEHICLE SELECTION");
			System.out.println("===============================================");

			for (int i = 0; i < intNumVehicles; i++) {
				System.out.println("\n--- Vehicle " + (i + 1) + " ---");
				System.out.println("Select Vehicle Type:");
				System.out.println("1. Car ($50/day)");
				System.out.println("2. Motorbike ($35/day)");
				System.out.println("3. Trailer ($40/day)");
				System.out.print("Enter choice (1-3): ");
				int intChoice = FinalProject.ReadIntegerFromUser();

				while (intChoice < 1 || intChoice > 3) {
					System.out.println("Invalid choice. Please enter 1, 2, or 3.");
					System.out.print("Enter choice (1-3): ");
					intChoice = FinalProject.ReadIntegerFromUser();
				}

				// Create appropriate vehicle object based on choice
				switch (intChoice) {
				case 1:
					arrVehicles[i] = new CCar("Car", 50.0, intRentalDays, "Honda Accord", 32);
					break;
				case 2:
					arrVehicles[i] = new CMotorbike("Motorbike", 35.0, intRentalDays, "Sport Bike", 750);
					break;
				case 3:
					arrVehicles[i] = new CTrailer("Trailer", 40.0, intRentalDays, "6x12 feet", 3500);
					break;
				}
			}

			// Display rental summary
			System.out.println("\n\n===============================================");
			System.out.println("   RENTAL SUMMARY");
			System.out.println("===============================================");
			System.out.println("\nCustomer Name: " + strCustomerName);
			System.out.println("Phone Number: " + strPhoneNumber);
			System.out.println("Email Address: " + strEmail);
			System.out.println("Number of Rental Days: " + intRentalDays);
			System.out.println("\n-----------------------------------------------");
			System.out.println("   VEHICLE DETAILS");
			System.out.println("-----------------------------------------------");

			// Display each vehicle's details
			for (int i = 0; i < arrVehicles.length; i++) {
				System.out.println("\n** Vehicle " + (i + 1) + " **");
				System.out.println("Type: " + arrVehicles[i].getVehicleType());
				System.out.println(arrVehicles[i].getVehicleInfo());
				System.out.println("Price Per Day: $" + String.format("%.2f", arrVehicles[i].getPricePerDay()));
				System.out.println("Rental Days: " + arrVehicles[i].getRentalDays());
				double dblVehicleCost = arrVehicles[i].calculateRentalCost();
				System.out.println("Total for this vehicle: $" + String.format("%.2f", dblVehicleCost));
				dblTotalRental += dblVehicleCost;
			}

			// Display grand total
			System.out.println("\n===============================================");
			System.out.println("TOTAL RENTAL AMOUNT: $" + String.format("%.2f", dblTotalRental));
			System.out.println("===============================================");

			System.out.println("\nThank you for choosing our Vehicle Rental Service!");
			System.out.println("We will contact you shortly to confirm your pickup location.");

			// Close database connection
			CloseDatabaseConnection();

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
