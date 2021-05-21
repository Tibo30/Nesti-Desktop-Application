package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Article;
import entities.Product;
import entities.Supplier;
import entities.UnitMeasure;

public class QueryProduct extends MyConnection {
//	public static QueryProduct queryProd = new QueryProduct("127.0.0.1", "root", "", "java_nesti");
//
//	public QueryProduct(String url, String login, String mdp, String bdd) {
//		super(url, login, mdp, bdd);
//
//	}

	/**
	 * Read all the supplier names
	 * 
	 * @throws Exception
	 */
	
	public ArrayList<Product> listAllProduct() throws Exception {
		openConnection();
		ArrayList<Product> prod = new ArrayList<Product>();
		
		try {
			
			String query = "SELECT p.id_product, p.product_name, p.product_type, p.product_state, u.unit_measure_name, a.article_quantity FROM product AS p INNER JOIN unit_measure AS u ON p.id_unit_measure = u.id_unit_measure LEFT JOIN article AS a ON p.id_product = a.id_product ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				Article quant = new Article(resultat.getInt("article_quantity"));
				UnitMeasure unit = new UnitMeasure(resultat.getString("unit_measure_name"));
				Product toto = new Product(resultat.getInt("id_product"),resultat.getString("product_name"),resultat.getString("product_type"), resultat.getString("product_state"), unit,quant);
			prod.add(toto);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return prod;
	}
	
	
	
	
	public  ArrayList<UnitMeasure> AllUnit() throws Exception {
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
		}
		 catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return Unit;
		}
	
	
	public   Object findUnit(String Prod ) throws Exception {
		String fofo="";
		ResultSet rs;
		openConnection();
		boolean flag = false;
		try {
			
			String query = "SELECT unit_measure.unit_measure_name FROM unit_measure INNER JOIN product ON product.id_unit_measure=unit_measure.id_unit_measure WHERE (product.product_name=?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();
			
			declaration.setString(0, (String) Prod);
			rs = declaration.executeQuery();
			 fofo = rs.getString("unit_measure.unit_measure_name");
		}
		 catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
	
		return fofo ;
		}
	
	public  ArrayList<String> AllType() throws Exception {
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
		}
		 catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		
		return type;
		
		}
	public Product createProductInfo(String productName) throws Exception {
        openConnection();
        Product prod = null;
        ResultSet rs;

        try {

            String query = "SELECT product.product_name,product.product_type, product.product_state, unit_measure.unit_measure_name  FROM product JOIN unit_measure ON product.id_unit_measure = unit_measure.id_unit_measure WHERE (product.product_name=?);";
            PreparedStatement declaration = accessDataBase.prepareStatement(query);
            declaration.setString(1, productName);
            rs = declaration.executeQuery();
            /* R�cup�ration des donn�es */
            if (rs.next()) {
                UnitMeasure unit = new UnitMeasure(rs.getString("unit_measure_name"));
                prod = new Product(rs.getString("product_name"),rs.getString("product_type"), rs.getString("product_state"), unit);
            }
        } catch (Exception e) {
            System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
        }
        closeConnection();
        return prod;
    }
	public boolean createPrepared(Product product,UnitMeasure unit) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `product`(product_name,product_type,product_state) VALUES (?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setString(1, product.getName());
			declaration.setString(2, product.getType());
			declaration.setString(3, product.getState());
			
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	} 
	
	
}
