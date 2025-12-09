package Final;

/**
 * Parent class representing a generic vehicle for rental
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class CVehicle {
	
	// Attributes
	protected String strVehicleType;
	protected double dblPricePerDay;
	protected int intRentalDays;
	
	/**
	 * Default constructor
	 */
	public CVehicle() {
		this.strVehicleType = "";
		this.dblPricePerDay = 0.0;
		this.intRentalDays = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param strVehicleType The type of vehicle
	 * @param dblPricePerDay The rental price per day
	 * @param intRentalDays The number of rental days
	 */
	public CVehicle(String strVehicleType, double dblPricePerDay, int intRentalDays) {
		this.strVehicleType = strVehicleType;
		this.dblPricePerDay = dblPricePerDay;
		this.intRentalDays = intRentalDays;
	}
	
	/**
	 * Get the vehicle type
	 * @return The type of vehicle
	 */
	public String getVehicleType() {
		return strVehicleType;
	}
	
	/**
	 * Set the vehicle type
	 * @param strVehicleType The type of vehicle
	 */
	public void setVehicleType(String strVehicleType) {
		this.strVehicleType = strVehicleType;
	}
	
	/**
	 * Get the price per day
	 * @return The rental price per day
	 */
	public double getPricePerDay() {
		return dblPricePerDay;
	}
	
	/**
	 * Set the price per day
	 * @param dblPricePerDay The rental price per day
	 */
	public void setPricePerDay(double dblPricePerDay) {
		this.dblPricePerDay = dblPricePerDay;
	}
	
	/**
	 * Get the number of rental days
	 * @return The number of rental days
	 */
	public int getRentalDays() {
		return intRentalDays;
	}
	
	/**
	 * Set the number of rental days
	 * @param intRentalDays The number of rental days
	 */
	public void setRentalDays(int intRentalDays) {
		this.intRentalDays = intRentalDays;
	}
	
	/**
	 * Calculate the total rental cost
	 * @return The total rental cost (price per day * rental days)
	 */
	public double calculateRentalCost() {
		return dblPricePerDay * intRentalDays;
	}
	
	/**
	 * Get vehicle information - to be overridden by subclasses
	 * @return Information about the vehicle
	 */
	public String getVehicleInfo() {
		return "Generic Vehicle";
	}
	
	/**
	 * Display vehicle details
	 */
	public void displayVehicleDetails() {
		System.out.println("Vehicle Type: " + strVehicleType);
		System.out.println("Price Per Day: $" + String.format("%.2f", dblPricePerDay));
		System.out.println("Rental Days: " + intRentalDays);
		System.out.println("Total Cost: $" + String.format("%.2f", calculateRentalCost()));
	}

}
