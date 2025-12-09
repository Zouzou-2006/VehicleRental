package Final;

/**
 * Trailer class representing a trailer for rental - extends CVehicle
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class CTrailer extends CVehicle {
	
	private String strTrailerSize;
	private int intMaxLoadWeight;
	
	/**
	 * Default constructor
	 */
	public CTrailer() {
		super();
		this.strTrailerSize = "";
		this.intMaxLoadWeight = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param strVehicleType The type of vehicle
	 * @param dblPricePerDay The rental price per day
	 * @param intRentalDays The number of rental days
	 * @param strTrailerSize The trailer size
	 * @param intMaxLoadWeight The maximum load weight in lbs
	 */
	public CTrailer(String strVehicleType, double dblPricePerDay, int intRentalDays, String strTrailerSize, int intMaxLoadWeight) {
		super(strVehicleType, dblPricePerDay, intRentalDays);
		this.strTrailerSize = strTrailerSize;
		this.intMaxLoadWeight = intMaxLoadWeight;
	}
	
	/**
	 * Get the trailer size
	 * @return The trailer size
	 */
	public String getTrailerSize() {
		return strTrailerSize;
	}
	
	/**
	 * Set the trailer size
	 * @param strTrailerSize The trailer size
	 */
	public void setTrailerSize(String strTrailerSize) {
		this.strTrailerSize = strTrailerSize;
	}
	
	/**
	 * Get the maximum load weight
	 * @return The maximum load weight in lbs
	 */
	public int getMaxLoadWeight() {
		return intMaxLoadWeight;
	}
	
	/**
	 * Set the maximum load weight
	 * @param intMaxLoadWeight The maximum load weight in lbs
	 */
	public void setMaxLoadWeight(int intMaxLoadWeight) {
		this.intMaxLoadWeight = intMaxLoadWeight;
	}
	
	/**
	 * Get vehicle information - overrides parent method
	 * @return Information about the trailer
	 */
	@Override
	public String getVehicleInfo() {
		return "Trailer Size: " + strTrailerSize + " | Ideal for hauling large items and equipment | Max Load: " + intMaxLoadWeight + " lbs";
	}
}
