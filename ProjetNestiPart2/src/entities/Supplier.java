package entities;

import java.util.Date;

/**
 * Class Entity Supplier
 * @author Thibault
 *
 */
public class Supplier {

	int id;
	int idAdmin;
	String name;
	String adress;
	String city;
	String contactNumber;
	String contactFirstname;
	String contactLastname;
	String state;
	Date creationDate;
	Date updateDate;

	/**
	 * Constructor
	 * @param int id
	 * @param string name
	 * @param string address
	 * @param string city
	 * @param string contactNumber
	 * @param string contactLastname
	 * @param string contactFirstname
	 * @param string state
	 * @param Date creationDate
	 * @param Date updateDate
	 * @param int idAdmin
	 */
	public Supplier(int id, String name, String adress, String city, String contactNumber, String contactLastname,
			String contactFirstname, String state,Date creationDate,Date updateDate,int idAdmin) {
		this.id=id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.contactNumber = contactNumber;
		this.contactFirstname = contactFirstname;
		this.contactLastname = contactLastname;
		this.state=state;
		this.creationDate=creationDate;
		this.updateDate=updateDate;
		this.idAdmin=idAdmin;

	}
	
	/**
	 * Tostring() method
	 */
	@Override
	public String toString() {
		return  name ;
	}
	
	/**
	 * Constructor
	 * @param string name
	 * @param string adress
	 * @param string city
	 * @param string contactNumber
	 * @param string contactLastname
	 * @param string contactFirstname
	 * @param string state
	 * @param int idAdmin
	 */
	public Supplier(String name, String adress, String city, String contactNumber, String contactLastname,
			String contactFirstname, String state,int idAdmin) {
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.contactNumber = contactNumber;
		this.contactFirstname = contactFirstname;
		this.contactLastname = contactLastname;
		this.state=state;
		this.idAdmin=idAdmin;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the contactFirstname
	 */
	public String getContactFirstname() {
		return contactFirstname;
	}

	/**
	 * @param contactFirstname the contactFirstname to set
	 */
	public void setContactFirstname(String contactFirstname) {
		this.contactFirstname = contactFirstname;
	}

	/**
	 * @return the contactLastname
	 */
	public String getContactLastname() {
		return contactLastname;
	}

	/**
	 * @param contactLastname the contactLastname to set
	 */
	public void setContactLastname(String contactLastname) {
		this.contactLastname = contactLastname;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
