
public enum Volume implements Unit {
	
	LITER("Liter", 1.0),
	CUBICMETER("Cubic meter", 0.001),
	MILLILITER("Milliliter", 1000.0),
	DECILITER("Deciliter", 10.0),
	GALLON("Gallon", 0.2642),
	KWIAN("Kwian", 0.0005);
	
	private final String name;
	private final double value;
	
	Volume(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public double getValue() { return value; }
	public String toString() { return name; }

}
