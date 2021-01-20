package entities;

public class Product {
	int id;
	String name;
	String type;
	String state;
	String unit;
	

	public Product(int id,String name, String type, String state, String unit) {
		this.id= id;
		this.name = name;
		this.state = state;
		this.type = type;
		this.unit=unit;
	}
	public Product(String name,  String state, String unit,String type) {
		
		this.name = name;
		this.state = state;
		this.type = type;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
}
