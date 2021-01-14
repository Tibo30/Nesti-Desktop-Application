package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Admin;
import entities.Supplier;
import tools.BCrypt;

public class QuerySupplier extends MyConnection {

	public QuerySupplier(String url, String login, String mdp, String bdd) {
		super(url, login, mdp, bdd);

	}

	public Supplier createSupplierInfo(String supplierName) throws Exception {
		openConnection();
		Supplier sup = null;
		ResultSet rs;
		try {
			String query = "SELECT supplier_name, supplier_adress, supplier_city, supplier_contact_number, supplier_contact_lastname, supplier_contact_firstname, supplier_state, supplier_creation_date, supplier_update_date FROM supplier WHERE (supplier_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, supplierName);
			rs = declaration.executeQuery();
			/* Récupération des données */
			if (rs.next()) {
				sup = new Supplier(rs.getString("supplier_name"), rs.getString("supplier_adress"),
						rs.getString("supplier_city"), rs.getString("supplier_contact_number"),
						rs.getString("supplier_contact_lastname"), rs.getString("supplier_contact_firstname"),
						rs.getString("supplier_state"), rs.getDate("supplier_creation_date"),
						rs.getDate("supplier_update_date"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return sup;
	}

	/**
	 * This method is used to create a new Supplier in the database, during the
	 * register process
	 * 
	 * @param supplier
	 * @return
	 * @throws Exception
	 */
	public boolean createPrepared(Supplier supplier) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `supplier`(supplier_name, supplier_adress, supplier_city, supplier_contact_number, supplier_contact_lastname, supplier_contact_firstname, supplier_state) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, supplier.getName());
			declaration.setString(2, supplier.getAdress());
			declaration.setString(3, supplier.getCity());
			declaration.setString(4, supplier.getContactNumber());
			declaration.setString(5, supplier.getContactLastname());
			declaration.setString(6, supplier.getContactFirstname());
			declaration.setString(7, supplier.getState());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}
	
	/**
	 * This method is used to update a value in the database
	 * @param valueChanged
	 * @param newValue
	 * @param email
	 * @return
	 * @throws Exception 
	 */
	public boolean updatePrepared(String valueChanged, String newValue, String name) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "";
			switch (valueChanged) {
			case "name":
				query = "UPDATE supplier SET name=? WHERE name=?";
				break;
			case "adress":
				query = "UPDATE supplier SET supplier_adress=? WHERE name=?";
				break;
			case "city":
				query = "UPDATE supplier SET supplier_city=? WHERE name=?";
				break;
			case "contactNumber":
				query = "UPDATE supplier SET supplier_contact_number=? WHERE name=?";
				break;
			case "contactLastname":
				query = "UPDATE supplier SET supplier_contact_lastname=? WHERE name=?";
				break;
			case "contactFirstname":
				query = "UPDATE supplier SET supplier_contact_firstname=? WHERE name=?";
				break;
			case "state":
				query = "UPDATE supplier SET supplier_state=? WHERE name=?";
				break;
			
			}
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, newValue);
			declaration.setString(2, name);
			
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

}
