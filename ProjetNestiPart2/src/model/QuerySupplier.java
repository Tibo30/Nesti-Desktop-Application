package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Supplier;

/**
 * Class for the supplier queries
 * @author Thibault
 *
 */
public class QuerySupplier extends MyConnection {
	
	
	/**
	 * Read all the supplier names
	 * @return ArrayList<Supplier>
	 * @throws Exception
	 */
	
	public ArrayList<Supplier> listAllSupplier() throws Exception {
		ArrayList<Supplier> listSupplier=new ArrayList<Supplier>();
		Supplier sup = null;
		try {
			
			String query = "CALL select_supplier;";
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
		return listSupplier;
	}

	/**
	 * This method is used to create a supplier from the database
	 * @param string supplierName
	 * @return Supplier
	 * @throws Exception
	 */
	public Supplier createSupplierInfo(String supplierName) throws Exception {
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
		return sup;
	}

	/**
	 * This method is used to create a new Supplier in the database, during the
	 * register process
	 * 
	 * @param Supplier supplier
	 * @return boolean
	 * @throws Exception
	 */
	public boolean createPrepared(Supplier supplier) throws Exception {
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
		return flag;
	}

	/**
	 * This method is used to update a value in the database
	 * 
	 * @param string valueChanged
	 * @param string newValue
	 * @param string name
	 * @return boolean
	 * @throws Exception
	 */
	public boolean updatePrepared(String valueChanged, String newValue, String name) throws Exception {
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
		return flag;
	}

}
