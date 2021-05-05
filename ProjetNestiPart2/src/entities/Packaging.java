package entities;

public class Packaging {
	
	int packagingId;
	String name;
	
	public Packaging(String name) {
		this.name=name;
	}
	
	public Packaging(int packagingId, String name) {
		this.packagingId=packagingId;
		this.name=name;
	}
	
	public String toString() {
		return  name ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(int packagingId) {
		this.packagingId = packagingId;
	}
	public String toString() {
        return  name ;
    }
	

	
}
