package entities;

public class Product {
	String name;
	String type;
	String state;
	UnitMeasure unit;

	public Product(String name, String type, String state, UnitMeasure unit) {
		this.name = name;
		this.type = type;
		this.state = state;
		this.unit=unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public UnitMeasure getUnit() {
		return unit;
	}

	public void setUnit(UnitMeasure unit) {
		this.unit = unit;
	}
	
	
	
}
