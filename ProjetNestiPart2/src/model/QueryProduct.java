package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	public ArrayList<String> listTypeOfProduct() throws Exception {
		ArrayList<String> listTypeOfProduct = new ArrayList<String>();
		try {
			openConnection();
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT DISTINCT product_type FROM product;";
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {
				listTypeOfProduct.add(resultat.getString("product_type"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listTypeOfProduct;
	}


}
