package entities;

public class Product {
	int id;
	String name;
	String type;
	String state;
	UnitMeasure unit;
	
	public Product(int id, String name, String type, String state, UnitMeasure unit) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.unit = unit;
		this.state = state;
	}

	public Product(String name, String state, String type, UnitMeasure unit) {

		this.name = name;
		this.state = state;
		this.type = type;
		this.unit = unit;
		
	}
	
	@Override
	public String toString() {
		return  name ;
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

	public  void setState(String state) {
		this.state = state;
	}

	public UnitMeasure getUnit() {
		return unit;
	}

	public void setUnit(UnitMeasure unit) {
		this.unit = unit;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	
	
	public Object[] toRowProduct() {
		Object[] prod = {this.name,this.state,this.type,this.unit.getName()};
		return prod;
	}
	public Object[] giveProduct(String name) {
		
		Object[] prod = {this.name,this.state,this.type,this.unit.getName()};
		return prod;
	}
	
}
