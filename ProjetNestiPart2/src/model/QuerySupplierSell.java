package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import entities.Admin;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import entities.UnitMeasure;

public class QuerySupplierSell extends MyConnection {

	//public static QuerySupplierSell querySell = new QuerySupplierSell("127.0.0.1", "root", "", "java_nesti");

	public static void main(String[] args) throws Exception {

		//QuerySupplier querySupp = new QuerySupplier("127.0.0.1", "root", "", "java_nesti");
		//QueryAdmin queryAdm = new QueryAdmin("127.0.0.1", "root", "", "java_nesti");
		//Admin adm = new Admin("Jol", "Tibo", "TiboJol123456", "TiboJol987654#", "Unblocked");

		// test de la fonction createPrepared de l'admin
		// queryAdm.createPrepared(adm);

		// test de la fonction createObjectAdmin
		// Admin adm2=queryAdm.createAdminInfo(adm.getUsername());

		// test de la fonction createPrepared Suppl
		// Supplier supp=new Supplier("Supplier3","12 avenue du
		// givre","Montpellier","0908070605","Late","Jeremi","Unblocked",adm2.getId());
		// querySupp.createPrepared(supp);

		// Test de la fonction update Suppl
		// querySupp.updatePrepared("adress", "13 chemin des lilas", "Supplier2");

		// test de la fonction createObject suppl
		// Supplier supp=querySupp.createSupplierInfo("Supplier3");
		// System.out.println(supp.getName()+ " et "+supp.getAdress());

		// test fonction createPrepare de Sell
//		UnitMeasure unit=new UnitMeasure("kg");
//		Product prod=new Product("banane","ingredient","unblocked",unit);
//		ArrayList<Product> products = new ArrayList<Product>();
//		products.add(prod);
//		ArrayList<Double> buyingPrices = new ArrayList<Double>();
//		buyingPrices.add(3.2);
//		SupplierSell supplier = new SupplierSell(supp,products,buyingPrices);
//		querySell.createPrepared(supplier);

		// test de la fonction createObject supplierSell
		// SupplierSell suppSell= querySell.createSupplierSellInfo(supp);
		// System.out.println(suppSell.getProducts().size());

	}

	public SupplierSell createSupplierSellInfo(Supplier supplier) throws Exception {
		openConnection();
		SupplierSell supSell = null;
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Double> buyingPrices = new ArrayList<Double>();
		ResultSet rs;
		try {
			String query = "SELECT product.product_name,product.product_type,product.product_state,unit_measure.unit_measure_name,sell.buying_price "
					+ "FROM unit_measure JOIN product ON unit_measure.id_unit_measure=product.id_unit_measure JOIN sell ON sell.id_product=product.id_product "
					+ "JOIN supplier ON supplier.id_supplier=sell.id_supplier WHERE (supplier.supplier_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, supplier.getName());
			rs = declaration.executeQuery();
			while (rs.next()) {
				UnitMeasure unit = new UnitMeasure(rs.getString("unit_measure_name"));
				Product product = new Product(rs.getString("product_name"), rs.getString("product_type"),
						rs.getString("product_state"), unit);
				products.add(product);
				buyingPrices.add(rs.getDouble("buying_price"));

			}
			supSell = new SupplierSell(supplier, products, buyingPrices);

		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return supSell;
	}

	/**
	 * This method is used to create a new Supplier in the database, during the
	 * register process
	 * 
	 * @param supplier
	 * @return
	 * @throws Exception
	 */
	public boolean createPrepared(SupplierSell supplier) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `sell`(id_supplier, id_product, buying_price) "
					+ "VALUES ((SELECT id_supplier FROM supplier WHERE supplier_name=?),(SELECT id_product FROM product WHERE product_name=?),?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, supplier.getSupplier().getName());
			declaration.setString(2, supplier.getProduct().getName());
			declaration.setDouble(3, supplier.getBuyingPrice());
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
	public boolean updatePrice(String newValue, String productName, String supplierName) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "UPDATE sell JOIN product ON sell.id_product=product.id_product JOIN supplier ON supplier.id_supplier=sell.id_supplier SET sell.buying_price=? WHERE (product.product_name = ?) AND (supplier.supplier_name=?);";
				
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setDouble(1, Double.parseDouble(newValue));
			declaration.setString(2, productName);
			declaration.setString(3, supplierName);

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}
	
	public double getPrice(String productName, String supplierName) throws Exception {
		openConnection();
		double price = 0;
		ResultSet rs;
		try {
			String query = "SELECT sell.buying_price FROM sell JOIN product ON sell.id_product=product.id_product JOIN supplier ON supplier.id_supplier=sell.id_supplier WHERE (product.product_name=?) AND (supplier.supplier_name=?);";
				
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, productName);
			declaration.setString(2, supplierName);

			rs = declaration.executeQuery();
			if (rs.next()) {
			price = rs.getDouble("buying_price");
			}
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return price;
	}

	public boolean deletePrepared(String productName) throws Exception {
		boolean success = false;
		openConnection();
		try {
			String query = "DELETE sell FROM sell JOIN product ON sell.id_product=product.id_product WHERE product.product_name = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, productName);
			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Erreur suppression ingredient: " + e.getMessage());
		}
		closeConnection();
		return success;
	}

}
