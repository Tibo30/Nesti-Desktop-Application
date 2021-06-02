package entities;

import java.util.Date;

/**
 * Entity order
 * 
 * @author Thibault
 *
 */
public class Order {
	int id;
	String state;
	Date validationDate;
	Date deliveryDate;
	Supplier supplier;
	int idAdmin;

	/**
	 * Constructor
	 * 
	 * @param int      id
	 * @param Date     validationDate
	 * @param Date     deliveryDate
	 * @param string   state
	 * @param Supplier supplier
	 * @param int      idAdmin
	 */
	public Order(int id, Date validationDate, Date deliveryDate, String state, Supplier supplier, int idAdmin) {
		this.id = id;
		this.state = state;
		this.validationDate = validationDate;
		this.deliveryDate = deliveryDate;
		this.supplier = supplier;
		this.idAdmin = idAdmin;
	}

	/**
	 * Constructor
	 * 
	 * @param string   state
	 * @param Supplier supplier
	 * @param int      idAdmin
	 */
	public Order(String state, Supplier supplier, int idAdmin) {
		this.state = state;
		this.validationDate = validationDate;
		this.deliveryDate = deliveryDate;
		this.supplier = supplier;
		this.idAdmin = idAdmin;
	}
	
	/**
	 * Constructor
	 * @param int id
	 * @param Date deliveryDate
	 * @param Date validationDate
	 * @param String state
	 */
	public Order(int id, Date deliveryDate, Date validationDate,String state) {
		this.id=id;
		this.state=state;
		this.validationDate=validationDate;
		this.deliveryDate=deliveryDate;
		
	}

	/**
	 * ToString method for the order reference
	 */
	@Override
	public String toString() {
		int number;
		int idLength = String.valueOf(id).length();
		String orderNumber = "";
		number = 10 - idLength;
		for (int i = 0; i < number; i++) {
			orderNumber += 0;
		}
		orderNumber += String.valueOf(id);
		return "Order number : " + orderNumber;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the validationDate
	 */
	public Date getValidationDate() {
		return validationDate;
	}

	/**
	 * @param validationDate the validationDate to set
	 */
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	

}
