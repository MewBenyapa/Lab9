
public enum UnitType {
	
	LENGTH("Length"),
	AREA("Area"),
	WEIGHT("Weight"),
	VOLUME("Volume");
	
	private String name;
	
	private UnitType(String name) {
		this.name = name;
	}
	
	public String toString () { return name; }

}
