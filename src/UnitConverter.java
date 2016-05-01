
public class UnitConverter {
	
	private UnitFactory factory;
	
	public UnitConverter () {
		this.factory = UnitFactory.getInstance();
	}
	
	/**
	 * Converts unit.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		double x = amount * fromUnit.getValue();
			   x /= toUnit.getValue();
		return x;
	}
	
	/**
	 * @return return values of units.
	 */
	
	public UnitType[] getUnitTypes() { return factory.getUnitTypes(); }
	
	public Unit[] getUnits(UnitType type) { return factory.getUnits(type); } 
	
	public Unit[] getLength() { return Length.values(); }
	
	public Unit[] getWeight() { return Weight.values(); }
	
	public Unit[] getArea() { return Area.values(); }
	
	public Unit[] getVolume() { return Volume.values(); }
	
}
