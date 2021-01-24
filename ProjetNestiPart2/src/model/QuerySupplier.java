package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Supplier;

public class QuerySupplier extends MyConnection {
	
//public static QuerySupplier querySuppl=new QuerySupplier("127.0.0.1", "root", "", "java_nesti");

	
	/**
	 * Read all the supplier names
	 * @throws Exception 
	 */
	public ArrayList<Supplier> listAllSupplier() throws Exception {
		ArrayList<Supplier> listSupplier=new ArrayList<Supplier>();
		Supplier sup = null;
		try {
			openConnection();
			
			String query = "SELECT id_supplier, supplier_name, supplier_adress, supplier_city, supplier_contact_number, supplier_contact_lastname, "
					+ "supplier_contact_firstname, supplier_state,supplier_creation_date,supplier_update_date, id_admin FROM supplier;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* Récupération des données */
			while (rs.next()) {
				sup = new Supplier(rs.getInt("id_supplier"),rs.getString("supplier_name"), rs.getString("supplier_adress"),
						rs.getString("supplier_city"), rs.getString("supplier_contact_number"),
						rs.getString("supplier_contact_lastname"), rs.getString("supplier_contact_firstname"),
						rs.getString("supplier_state"),rs.getDate("supplier_creation_date"), rs.getDate("supplier_update_date"), rs.getInt("id_admin"));
				listSupplier.add(sup);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listSupplier;
	}

	public Supplier createSupplierInfo(String supplierName) throws Exception {
		openConnection();
		Supplier sup = null;
		ResultSet rs;
		try {
			String query = "SELECT id_supplier, supplier_name, supplier_adress, supplier_city, supplier_contact_number, supplier_contact_lastname, "
					+ "supplier_contact_firstname, supplier_state,supplier_creation_date,supplier_update_date, id_admin FROM supplier WHERE (supplier_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, supplierName);
			rs = declaration.executeQuery();
			/* Récupération des données */
			if (rs.next()) {
				sup = new Supplier(rs.getInt("id_supplier"),rs.getString("supplier_name"), rs.getString("supplier_adress"),
						rs.getString("supplier_city"), rs.getString("supplier_contact_number"),
						rs.getString("supplier_contact_lastname"), rs.getString("supplier_contact_firstname"),
						rs.getString("supplier_state"),rs.getDate("supplier_creation_date"), rs.getDate("supplier_update_date"), rs.getInt("id_admin"));
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
			String query = "INSERT INTO `supplier`(supplier_name, supplier_adress, supplier_city, supplier_contact_number, supplier_contact_lastname, "
					+ "supplier_contact_firstname, supplier_state, id_admin) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, supplier.getName());
			declaration.setString(2, supplier.getAdress());
			declaration.setString(3, supplier.getCity());
			declaration.setString(4, supplier.getContactNumber());
			declaration.setString(5, supplier.getContactLastname());
			declaration.setString(6, supplier.getContactFirstname());
			declaration.setString(7, supplier.getState());
			declaration.setInt(8, supplier.getIdAdmin());
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
	 * 
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
				query = "UPDATE supplier SET supplier_name=? WHERE supplier_name=?";
				break;
			case "adress":
				query = "UPDATE supplier SET supplier_adress=? WHERE supplier_name=?";
				break;
			case "city":
				query = "UPDATE supplier SET supplier_city=? WHERE supplier_name=?";
				break;
			case "contactNumber":
				query = "UPDATE supplier SET supplier_contact_number=? WHERE supplier_name=?";
				break;
			case "contactLastname":
				query = "UPDATE supplier SET supplier_contact_lastname=? WHERE supplier_name=?";
				break;
			case "contactFirstname":
				query = "UPDATE supplier SET supplier_contact_firstname=? WHERE supplier_name=?";
				break;
			case "state":
				query = "UPDATE supplier SET supplier_state=? WHERE supplier_name=?";
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
