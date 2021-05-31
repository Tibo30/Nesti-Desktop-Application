package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Date;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Admin;
import entities.Supplier;
import tools.BCrypt;
import view.LoginFrame;
import view.ManagePanel;

public class QueryAdmin extends MyConnection {
	
	public String error="";
	

//	public static QueryAdmin queryAdm = new QueryAdmin("127.0.0.1", "root", "", "java_nesti");
//
//	public QueryAdmin() {
//		super(url, login, mdp, bdd);
//
//	}

	/**
	 * Read all the Admin's names
	 * 
	 * @throws Exception
	 */

	public ArrayList<Admin> listAllAdmin() throws Exception {

		ArrayList<Admin> listAdmin = new ArrayList<Admin>();
		Admin adm = null;

		try {

			openConnection();

			String query = "SELECT id_admin, admin_lastname, admin_firstname, admin_password, admin_login, "
					+ "admin_state,admin_creation_date,admin_update_date, is_super_admin FROM admin;";

			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();

			/* R�cup�ration des donn�es */

			while (rs.next()) {
				adm = new Admin(rs.getInt("id_admin"), rs.getString("admin_login"), rs.getString("admin_lastname"),
						rs.getString("admin_firstname"), rs.getString("admin_state"), rs.getDate("admin_creation_date"),
						rs.getDate("admin_update_date"));
				listAdmin.add(adm);
			}

		} catch (Exception e) {
			System.err.println("Error in display Admin's informations: " + e.getMessage());
		}

		return listAdmin;
	}

	/**
	 * This method is used to select all admin's information from admin_login
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public Admin selectAdminInfo(String login) throws Exception {
		openConnection();
		Admin adm = null;
		ResultSet rs;
		try {
			String query = "SELECT id_admin, admin_lastname, admin_firstname, admin_login, admin_password, admin_state, admin_creation_date, admin_update_date, is_super_admin FROM admin WHERE admin_login=? ;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, login);
			rs = declaration.executeQuery();

			/* R�cup�ration des donn�es */
			if (rs.next()) {
				adm = new Admin(rs.getInt("id_admin"), rs.getString("admin_lastname"), rs.getString("admin_firstname"),
						rs.getString("admin_login"), rs.getString("admin_password"), rs.getString("admin_state"),
						rs.getDate("admin_creation_date"), rs.getDate("admin_update_date"),
						rs.getBoolean("is_super_admin"));
			}
		} catch (Exception e) {
			System.err.println("Error in Admin creation: " + e.getMessage());
		}
		closeConnection();
		return adm;
	}

	public Admin selectAdminInfoById(int id) throws Exception {
		openConnection();
		Admin adm = null;
		ResultSet rs;
		try {
			String query = "SELECT id_admin, admin_lastname, admin_firstname, admin_login, admin_password, admin_state, admin_creation_date, admin_update_date, is_super_admin FROM admin WHERE id_admin=? ;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, id);
			rs = declaration.executeQuery();

			/* R�cup�ration des donn�es */
			if (rs.next()) {
				adm = new Admin(rs.getInt("id_admin"), rs.getString("admin_lastname"), rs.getString("admin_firstname"),
						rs.getString("admin_login"), rs.getString("admin_password"), rs.getString("admin_state"),
						rs.getDate("admin_creation_date"), rs.getDate("admin_update_date"),
						rs.getBoolean("is_super_admin"));
			}
		} catch (Exception e) {
			System.err.println("Error in Admin creation: " + e.getMessage());
		}
		closeConnection();
		return adm;
	}
	
		
	/**
	 * This method is used to create a new Admin in the database, during the
	 * register process
	 * 
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public boolean createPrepared(Admin admin) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `admin`(`admin_lastname`,`admin_firstname`,`admin_login`,`admin_password`,`admin_state`,`is_super_admin`) VALUES (?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			
			// this is used to encrypt the password
			String pw_hash = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(12)); 
																				 
			declaration.setString(1, admin.getLastname());
			declaration.setString(2, admin.getFirstname());
			declaration.setString(3, admin.getUsername());
			declaration.setString(4, pw_hash);
			declaration.setString(5, admin.getState());
			declaration.setBoolean(6, admin.isSuperAdmin());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Error in Admin creation: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	/**
	 * This method is used to update Admin's values in the database
	 * 
	 * @param valueChanged
	 * @param newValue
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public boolean updatePrepared(Admin admin) throws Exception {
		openConnection();
		boolean flag = false;
		System.out.println(admin.getId()+ admin.getFirstname()+ admin.getUsername()+ admin.getLastname()+ admin.getState());
		try {
			String query = "UPDATE admin SET admin_lastname=?, admin_firstname=?, admin_state=?, admin_login=? WHERE id_admin=?";
	
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, admin.getLastname());
			declaration.setString(2, admin.getFirstname());
			declaration.setString(3, admin.getState());
			declaration.setString(4, admin.getUsername());
			declaration.setInt(5, admin.getId());

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			error=e.getMessage();
			e.printStackTrace();
		}
		closeConnection();
		return flag;
	}

	/**
	 * This method is used to check Admin's username and password
	 * 
	 * 
	 * @param login * @param password
	 * @return
	 * @throws Exception
	 */

	public boolean checkPassword(String username, String password) throws Exception {
		openConnection();

		PreparedStatement declaration;
		ResultSet rs;

		boolean checkPassword = false;

		String query = "SELECT `admin_password`, `id_admin` FROM `admin` WHERE `admin_login` =? AND admin_state='Unblocked';";

		try {
			declaration = accessDataBase.prepareStatement(query);
			
			declaration.setString(1, username);

			rs = declaration.executeQuery();

			if (rs.next()) {
				
				if (BCrypt.checkpw(password, rs.getString("admin_password"))) {
					checkPassword = true;
					
				LoginFrame.id= rs.getInt("id_admin"); // stocker l'id de l'admin dans login frame  

				}
			}

		} catch (SQLException ex) {
			Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	return checkPassword;

	}

	/**
	 * This method check if the username is already taken
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean checkUsername(String username) throws Exception {
		openConnection();
		PreparedStatement declaration;
		ResultSet rs;
		boolean checkUser = false;
		String query = "SELECT * FROM admin WHERE admin_login =?";

		try {
			declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, username);

			rs = declaration.executeQuery();

			if (rs.next()) {
				checkUser = true;
			}
		} catch (SQLException ex) {
			Logger.getLogger(ManagePanel.class.getName()).log(Level.SEVERE, null, ex);
		}
		closeConnection();
		return checkUser;
	}

	public boolean updatePasswordPrepared(char[] psw, int idAdminSelected) {
		openConnection();
		boolean flag = false;
		try {
			String query = "UPDATE admin SET admin_password=? WHERE id_admin=?"; 
			String pw_hash = BCrypt.hashpw(String.valueOf(psw), BCrypt.gensalt(12)); 

			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, pw_hash);
			declaration.setInt(2, idAdminSelected);

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Error in password modification: " + e.getMessage());
		}
		
		closeConnection();
		return flag;
		
	}
	
	
	public boolean updateState(int id, String state) throws Exception {
		openConnection();
		boolean flag = false;

		try {
			String query = "UPDATE admin SET admin_state=? WHERE id_admin=?";
	
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, state);
			declaration.setInt(2, id);

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			error=e.getMessage();
			e.printStackTrace();
		}
		closeConnection();
		return flag;
	}
	
	

}