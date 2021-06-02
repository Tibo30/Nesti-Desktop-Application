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
	int superAdmin;

	public Admin(int id, String lastname, String firstname, String username, String password, String state,
			Date creationDate, Date updateDate, int superAdmin) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.state = state;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.superAdmin = 0;
	}

	/**
	 * Constructors for the creation of a new Admin
	 * 
	 * @param lastname
	 * @param firstname
	 * @param username
	 * @param password
	 * @param state
	 */

	public Admin(String lastname, String firstname, String username, String password, String state) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.state = state;
	}

	public Admin(int id, String username, String lastname, String firstname, String state, java.sql.Date creationDate,
			java.sql.Date updateDate) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.username = username;

		this.state = state;
		this.creationDate = creationDate;
		this.updateDate = updateDate;

	}

	public Admin() {

	}

	@Override
	public String toString() {
		if (username == null) {
			return lastname;

		}
		return lastname + " " + firstname + "(" + username + ")";
	}

	public Admin(int id, String username) {
		this.id = id;
		this.username = username;
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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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


	/**
	 * @return the superAdmin
	 */
	public int getSuperAdmin() {
		return superAdmin;
	}

	/**
	 * @param superAdmin the superAdmin to set
	 */

	public int SuperAdmin() {
		return superAdmin;
	}


	public void setSuperAdmin(int superAdmin) {
		this.superAdmin = superAdmin;
	}

	/**
	 * Boolean method to check if lastname, firstname, username is equivalent to 
	 * @param adminProfil
	 * @return
	 */
	public boolean isSame(Admin adminProfil) {
		
		if (!this.lastname.equals(adminProfil.getLastname())) {
			return false;
		}
		if (!this.firstname.equals(adminProfil.getFirstname())) {
			return false;
		}

		if (!this.username.equals(adminProfil.getUsername())) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 * 	@return
	 */
	public boolean isBlocked() {
		
		return(this.state.equals("Blocked"));
	}

}
