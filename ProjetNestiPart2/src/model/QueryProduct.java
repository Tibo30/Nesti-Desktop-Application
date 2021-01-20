package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Product;
import entities.Supplier;

public class QueryProduct extends MyConnection {
	public static QueryProduct queryProd = new QueryProduct("127.0.0.1", "root", "", "java_nesti");

	public QueryProduct(String url, String login, String mdp, String bdd) {
		super(url, login, mdp, bdd);

	}

	/**
	 * Read all the supplier names
	 * 
	 * @throws Exception
	 */
	
	public ArrayList<Product> createProductInfo() throws Exception {
		openConnection();
		ArrayList<Product> sup = null;
		ResultSet rs;
		try {
			
			String query = "SELECT id_product, product_name, product_state, id_unit_measure FROM product WHERE (id_product=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {
				sup.add(resultat.getString("supplier_name"));
			
				Product toto = new Product(rs.getInt("id_product"),rs.getString("product_name"),rs.getString("product_type"), rs.getString("product_state"),
						rs.getString("id_unit_measure"));
			sup.add(toto);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return sup;
	}
	public boolean createPrepared(Product product) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `product`(product_name,product_type,product_state,id_unit_measure) VALUES (?,?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, product.getName());
			declaration.setString(2, product.getType());
			declaration.setString(3, product.getState());
			declaration.setString(4, product.getUnit());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

}
