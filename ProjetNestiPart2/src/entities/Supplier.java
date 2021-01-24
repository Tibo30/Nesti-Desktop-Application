package entities;

import java.util.ArrayList;
import java.util.Date;

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
	
	@Override
	public String toString() {
		return  name ;
	}
	
	// creating supplier from the app
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactFirstname() {
		return contactFirstname;
	}

	public void setContactFirstname(String contactFirstname) {
		this.contactFirstname = contactFirstname;
	}

	public String getContactLastname() {
		return contactLastname;
	}

	public void setContactLastname(String contactLastname) {
		this.contactLastname = contactLastname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
