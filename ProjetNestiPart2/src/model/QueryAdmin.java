package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Admin;
import tools.BCrypt;

public class QueryAdmin extends MyConnection {

	public QueryAdmin(String url, String login, String mdp, String bdd) {
		super(url, login, mdp, bdd);

	}

	public Admin createAdminInfo(String adminUsername) throws Exception {
		openConnection();
		Admin adm = null;
		ResultSet rs;
		try {
			String query = "SELECT id_admin, admin_lastname, admin_firstname, admin_login, admin_password, admin_state, admin_creation_date, admin_update_date, is_super_admin FROM admin WHERE (admin_login=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, adminUsername);
			rs = declaration.executeQuery();
			/* Récupération des données */
			if (rs.next()) {
				adm = new Admin(rs.getInt("id_admin"),rs.getString("admin_lastname"), rs.getString("admin_firstname"),
						rs.getString("admin_login"), rs.getString("admin_password"), rs.getString("admin_state"),
						rs.getDate("admin_creation_date"), rs.getDate("admin_update_date"),
						rs.getBoolean("is_super_admin"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return adm;
	}

	/**
	 * This method is used to create a new Admin in the database, during the register
	 * process
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
			String pw_hash = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()); // this is used to encrypt the
																					// password
			declaration.setString(1, admin.getLastname());
			declaration.setString(2, admin.getFirstname());
			declaration.setString(3, admin.getUsername());
			declaration.setString(4, pw_hash);
			declaration.setString(5, admin.getState());
			declaration.setBoolean(6, admin.isSuperAdmin());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

}
