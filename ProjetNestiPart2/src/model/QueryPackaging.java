package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Packaging;
import entities.UnitMeasure;

public class QueryPackaging extends MyConnection{

	public ArrayList<Packaging> listAllPackaging() throws Exception {
		ArrayList<Packaging> listPackaging = new ArrayList<Packaging>();
		Packaging pack = null;
		try {

			String query = "SELECT id_packaging, packaging_name FROM packaging;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* Récupération des données */
			while (rs.next()) {
				pack = new Packaging(rs.getInt("id_packaging"),rs.getString("packaging_name"));
				listPackaging.add(pack);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		return listPackaging;
	}
	public Packaging createPackInfo(String unitName) throws Exception {
        Packaging unit = null;
        ResultSet rs;

        try {

            String query = "SELECT id_packaging  FROM packaging WHERE (packaging_name=?);";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, unitName);
            rs = declaration.executeQuery();
            /* Rï¿½cupï¿½ration des donnï¿½es */
            if (rs.next()) {
               unit = new Packaging(rs.getInt("id_packaging"));
            }
        } catch (Exception e) {
            System.err.println("Erreur d'affichage d'utilisateur createUnitInfo: " + e.getMessage());
        }
        return unit;
    }
	
}
