package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Article;
import entities.Packaging;
import entities.Product;

public class QueryPackaging extends MyConnection{

	public ArrayList<Packaging> listAllPackaging() throws Exception {
		ArrayList<Packaging> listPackaging = new ArrayList<Packaging>();
		Packaging pack = null;
		try {
			openConnection();

			String query = "SELECT id_packaging, packaging_name FROM packaging;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* Récupération des données */
			while (rs.next()) {
				pack = new Packaging(rs.getString("packaging_name"));
				listPackaging.add(pack);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listPackaging;
	}
	
}
