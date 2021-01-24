package entities;

import java.util.Date;

public class Order {
	int id;
	String state;
	Date validationDate;
	Date deliveryDate;
	Supplier supplier;
	int idAdmin;
	
	public Order(int id, Date validationDate, Date deliveryDate, String state, Supplier supplier, int idAdmin) {
		this.id=id;
		this.state=state;
		this.validationDate=validationDate;
		this.deliveryDate=deliveryDate;
		this.supplier=supplier;
		this.idAdmin=idAdmin;
	}
	
	@Override
	public String toString() {
		int number;
		int idLength = String.valueOf(id).length();
		String orderNumber="";
		number = 10-idLength;
		for (int i=0; i<number;i++) {
			orderNumber+=0;
		}
		orderNumber+=String.valueOf(id);
		return  "Order number : " + orderNumber ;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public int getIdAdmin() {
		return idAdmin;
	}


	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	
	
	
	
	
}
