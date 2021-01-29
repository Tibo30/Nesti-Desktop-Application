package entities;

public class UnitMeasure {
	
	String name;
	int id;
	
	public UnitMeasure(int id,String name) {
		this.name=name;
		this.id=id;
	}
	
	public UnitMeasure(String name) {
		this.name=name;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
        return  name ;
    }
}