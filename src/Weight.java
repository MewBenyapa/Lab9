
public enum Weight implements Unit {
	
	KILOGRAM("Kilogram", 1.0),
	GRAM("Gram", 1000.0),
	MILLIGRAM("Milligram", 1000000.0),
	POUND("Pound", 2.205),
	OUNCE("Ounce", 35.27),
	CHANGE("Chang", 0.82);
	
	private final String name;
	private final double value;
	
	Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public double getValue() { return value; }
	
	public String toString() { return name; }
	
	

}
