package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Product;
import entities.UnitMeasure;

public class QueryProduct extends MyConnection {

	/**
	 * Read all the Product
	 * 
	 * @throws Exception
	 */

	public ArrayList<Product> listAllProduct() throws Exception {
		openConnection();
		ArrayList<Product> prod = new ArrayList<Product>();

		try {

			String query = "SELECT product.id_product, product.product_name, product.product_type, product.product_state, unit_measure.unit_measure_name FROM product JOIN unit_measure ON product.id_unit_measure=unit_measure.id_unit_measure";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();

			while (resultat.next()) {

				UnitMeasure unit = new UnitMeasure(resultat.getString("unit_measure_name"));
				Product toto = new Product(resultat.getInt("id_product"), resultat.getString("product_name"),
						resultat.getString("product_type"), resultat.getString("product_state"), unit);

				prod.add(toto);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();

		return prod;
	}

	

	/**
	 * Read all the unit measure
	 * 
	 * @return
	 * @throws Exception
	 */

	public ArrayList<UnitMeasure> AllUnit() throws Exception {
		ArrayList<UnitMeasure> Unit = new ArrayList<UnitMeasure>();
		openConnection();
		boolean flag = false;
		try {
			String query = "SELECT DISTINCT unit_measure_name FROM unit_measure";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();
			while (resultat.next()) {
				UnitMeasure unit = new UnitMeasure(resultat.getString("unit_measure_name"));
				Unit.add(unit);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return Unit;
	}

	/**
	 * Read type of product
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> AllType() throws Exception {
		ArrayList<String> type = new ArrayList<String>();
		openConnection();
		boolean flag = false;
		try {
			String query = "SELECT DISTINCT product_type FROM product";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();
			while (resultat.next()) {
				type.add(resultat.getString("product_type"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();

		return type;

	}

	/**
	 * Give product join unit measure with productName
	 * 
	 * @param productName
	 * @return
	 * @throws Exception
	 */
	public Product createProductInfo(String productName) throws Exception {
		openConnection();
		Product prod = null;
		ResultSet rs;

		try {

			String query = "SELECT product.product_name,product.product_type, product.product_state, unit_measure.unit_measure_name  FROM product JOIN unit_measure ON product.id_unit_measure = unit_measure.id_unit_measure WHERE (product.product_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, productName);
			rs = declaration.executeQuery();

			if (rs.next()) {
				UnitMeasure unit = new UnitMeasure(rs.getString("unit_measure_name"));
				prod = new Product(rs.getString("product_name"), rs.getString("product_state"),
						rs.getString("product_type"), unit);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur createProductInfo: " + e.getMessage());
		}
		closeConnection();
		return prod;
	}

	/**
	 * Give unit measure with unitName
	 * 
	 * @param unitName
	 * @return
	 * @throws Exception
	 */
	public UnitMeasure createUnitInfo(String unitName) throws Exception {
		openConnection();
		UnitMeasure unit = null;
		ResultSet rs;
		try {
			String query = "SELECT id_unit_measure, unit_measure_name  FROM unit_measure WHERE (unit_measure_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, unitName);
			rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			if (rs.next()) {
				unit = new UnitMeasure(rs.getInt("id_unit_measure"), rs.getString("unit_measure_name"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur createUnitInfo: " + e.getMessage());
		}
		closeConnection();
		return unit;
	}

	/**
	 * Insert Product with object product
	 * 
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public boolean createPrepared(Product product) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO product(product_name, product_type, product_state, id_unit_measure) VALUES (?,?,?,(SELECT id_unit_measure FROM unit_measure WHERE (unit_measure_name=?)))";

			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, product.getName());
			declaration.setString(2, product.getType());
			declaration.setString(3, product.getState());
			declaration.setString(4, product.getUnit().getName());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur createPrepared: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	/**
	 * Use a switch to change DBB Change Product type,name,state,unitmeasure with
	 * product name
	 * 
	 * @param valueChanged
	 * @param newValue
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public boolean UpdateProductPrepared(String valueChanged, String newValue, String name) throws Exception {
		System.out.println(valueChanged + "   " + newValue + "  " + name);
		openConnection();
		boolean flag = false;
		try {
			String query = "";
			switch (valueChanged) {
			case "name":
				query = "UPDATE product SET product_name=? WHERE product_name=?";
				break;
			case "type":
				query = "UPDATE product SET product_type=? WHERE product_name=?";
				break;
			case "state":
				query = "UPDATE product SET product_state=? WHERE product_name=?";
				break;
			case "unit":
				query = "UPDATE product JOIN unit_measure ON unit_measure.id_unit_measure = product.id_unit_measure SET product.id_unit_measure = ( SELECT id_unit_measure FROM unit_measure WHERE unit_measure_name = ? ) WHERE (product_name = ?) ";
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
