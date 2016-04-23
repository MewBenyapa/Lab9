
public class UnitConverter {
	/*
	 * Converts unit.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		double x = amount * fromUnit.getValue();
			   x /= toUnit.getValue();
		return x;
	}
	
	/*
	 * @return return Length.values.
	 */
	public Unit[] getUnits() { return Length.values(); }
	
}
