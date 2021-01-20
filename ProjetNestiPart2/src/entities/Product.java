package entities;

public class Product {
	int id;
	String name;
	String type;
	String state;
	UnitMeasure unit;
	Article quantity;

	public Product(int id, String name, String type, String state, UnitMeasure unit, Article quantity) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.type = type;
		this.unit = unit;

	}

	public Product(String name, String state, String type, UnitMeasure unit, Article quantity) {

		this.name = name;
		this.state = state;
		this.type = type;
		this.unit = unit;
		this.quantity = quantity;
	}
	public Product(String name, String state, String type, UnitMeasure unit) {

		this.name = name;
		this.state = state;
		this.type = type;
		this.unit = unit;
		
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

	/**
	 * @return the quantity
	 */
	public Article getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Article quantity) {
		this.quantity = quantity;
	}

}
