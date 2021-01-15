
public class Admin {
private int id;
private String firstName;
private String lastName;
private String login;
private String password;
private String adress;
private String state;
private boolean isSuperAdmin;
//private date creatDate;
//private date updateDate;

public int getId() {
	return id;
}
public boolean isSuperAdmin() {
	return isSuperAdmin;
}
public void setSuperAdmin(boolean isSuperAdmin) {
	this.isSuperAdmin = isSuperAdmin;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login
			+ ", password=" + password + ", adress=" + adress + ", state=" + state + ", isSuperAdmin=" + isSuperAdmin
			+ "]";
}



	
	
}
