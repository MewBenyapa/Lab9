
/**
 * Set name and value of units.
 */

public enum Length implements Unit {
	
	METER("Meter", 1.0),
	CENTIMETER("Centimeter", 0.01),
	KILOMETER("Kilometer", 1000.0),
	MILE("Mile" , 1609.344),
	FOOT("Foot", 0.30480),
	WA("Wa", 2.0);
	
	/**
	 * Create attributes 
	 */
	private final String name;
	private final double value;
	
	/**
	 * @param name and value
	 */
	Length(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return value
	 * return value of units
	 */
	public double getValue() { return value; }
	public String toString() { return name; }
	
}
