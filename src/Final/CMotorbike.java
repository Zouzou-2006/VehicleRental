package Final;

/**
 * Motorbike class representing a motorbike for rental - extends CVehicle
 * @author NF
 * @since 12/08/2025
 * @version 1.0
 */
public class CMotorbike extends CVehicle {
	
	private String strBikeType;
	private int intEngineSize;
	
	/**
	 * Default constructor
	 */
	public CMotorbike() {
		super();
		this.strBikeType = "";
		this.intEngineSize = 0;
	}
	
	/**
	 * Parameterized constructor
	 * @param strVehicleType The type of vehicle
	 * @param dblPricePerDay The rental price per day
	 * @param intRentalDays The number of rental days
	 * @param strBikeType The motorbike type
	 * @param intEngineSize The engine size in CC
	 */
	public CMotorbike(String strVehicleType, double dblPricePerDay, int intRentalDays, String strBikeType, int intEngineSize) {
		super(strVehicleType, dblPricePerDay, intRentalDays);
		this.strBikeType = strBikeType;
		this.intEngineSize = intEngineSize;
	}
	
	/**
	 * Get the bike type
	 * @return The motorbike type
	 */
	public String getBikeType() {
		return strBikeType;
	}
	
	/**
	 * Set the bike type
	 * @param strBikeType The motorbike type
	 */
	public void setBikeType(String strBikeType) {
		this.strBikeType = strBikeType;
	}
	
	/**
	 * Get the engine size
	 * @return The engine size in CC
	 */
	public int getEngineSize() {
		return intEngineSize;
	}
	
	/**
	 * Set the engine size
	 * @param intEngineSize The engine size in CC
	 */
	public void setEngineSize(int intEngineSize) {
		this.intEngineSize = intEngineSize;
	}
	
	/**
	 * Get vehicle information - overrides parent method
	 * @return Information about the motorbike
	 */
	@Override
	public String getVehicleInfo() {
		return "Motorbike Type: " + strBikeType + " | This bike offers agile handling and quick acceleration | Engine Size: " + intEngineSize + " CC";
	}
}
