package entities;

import java.util.Date;

public class Admin {
	int id;
	String lastname;
	String firstname;
	String username;
	String password;
	String state;
	Date creationDate;
	Date updateDate;
	boolean superAdmin;

	
	
	public Admin(int id, String lastname, String firstname, String username, String password, String state, Date creationDate, Date updateDate, boolean superAdmin) {
		this.id=id;
		this.lastname=lastname;
		this.firstname=firstname;
		this.username=username;
		this.password=password;
		this.state=state;
		this.creationDate=creationDate;
		this.updateDate=updateDate;
		this.superAdmin=superAdmin;
	}
	
	public Admin(String lastname, String firstname, String username, String password, String state) {
		this.lastname=lastname;
		this.firstname=firstname;
		this.username=username;
		this.password=password;
		this.state=state;
	}
	
	
	public Admin(int id, String username, String lastname, String firstname, String state, java.sql.Date creationDate,
			java.sql.Date updateDate) {
		this.id = id;
		this.lastname=lastname;
		this.firstname=firstname;
		this.username=username;
		
		this.state=state;
		this.creationDate=creationDate;
		this.updateDate=updateDate;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}
	
}
