
public class UnitFactory {

	private static UnitFactory instance = null;
	private UnitType[] unitType;

	public UnitFactory() {}

	public static UnitFactory getInstance() { 
		if(instance == null) {
			instance = new UnitFactory();
		}
		return instance; 
	}
	
	public UnitType[] getUnitTypes() { return unitType; }
	
	public Unit[] getUnits(UnitType type) {
		if (type.equals(UnitType.LENGTH)) {
			return Length.values();
		} else if (type.equals(UnitType.AREA)) {
			return Area.values();
		} else if (type.equals(UnitType.WEIGHT)) {
			return Weight.values();
		} else {
			return Volume.values();
		}
	}

}
