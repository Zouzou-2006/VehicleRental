package Final;

/**
 * Car class representing a car for rental - extends CVehicle
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class CCar extends CVehicle {
	
	private String strCarModel;
	private int intMPG;
	
	/**
	 * Default constructor
	 */
	public CCar() {
		super();
		this.strCarModel = "";
		this.intMPG = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param strVehicleType The type of vehicle
	 * @param dblPricePerDay The rental price per day
	 * @param intRentalDays The number of rental days
	 * @param strCarModel The car model
	 * @param intMPG The miles per gallon
	 */
	public CCar(String strVehicleType, double dblPricePerDay, int intRentalDays, String strCarModel, int intMPG) {
		super(strVehicleType, dblPricePerDay, intRentalDays);
		this.strCarModel = strCarModel;
		this.intMPG = intMPG;
	}
	
	/**
	 * Get the car model
	 * @return The car model
	 */
	public String getCarModel() {
		return strCarModel;
	}
	
	/**
	 * Set the car model
	 * @param strCarModel The car model
	 */
	public void setCarModel(String strCarModel) {
		this.strCarModel = strCarModel;
	}
	
	/**
	 * Get the MPG
	 * @return The miles per gallon
	 */
	public int getMPG() {
		return intMPG;
	}
	
	/**
	 * Set the MPG
	 * @param intMPG The miles per gallon
	 */
	public void setMPG(int intMPG) {
		this.intMPG = intMPG;
	}
	
	/**
	 * Get vehicle information - overrides parent method
	 * @return Information about the car
	 */
	@Override
	public String getVehicleInfo() {
		return "Car Model: " + strCarModel + " | This car drives smoothly on highways and city roads | MPG: " + intMPG + " miles per gallon";
	}
}
