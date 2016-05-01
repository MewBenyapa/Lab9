
/**
 * 
 * @author lenovo
 * Set name and value of units.
 *
 */

public enum Area implements Unit {
	
	SQMETER("Sqmeter", 1.0),
	SQWA("Sqwa", 4.0),
	NGAN("Ngan", 0.0025),
	RAI("Rai", 0.000625),
	ACRE("Acre", 0.0002471),
	SQKILOMETER("Sqkilometer", 0.000001);
	
	/**
	 * Create attributes
	 */
	private final String name;
	private final double value;
	
	/**
	 * 
	 * @param name
	 * @param value
	 * 
	 */
	Area(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 
	 * @return value
	 * return value of unit
	 */
	public double getValue() { return value; }
	
	/**
	 * @return name of units
	 */
	public String toString() { return name; }
	
}
