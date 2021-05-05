package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Article;
import entities.Packaging;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import entities.UnitMeasure;

public class QueryArticle extends MyConnection {
	private QueryProduct queryProduct = new QueryProduct();
	private QuerySupplier querySupplier = new QuerySupplier();

	/**
	 * List all articles from the database
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Article> listAllArticle() throws Exception {
		ArrayList<Article> listArticle = new ArrayList<Article>();
		Article art = null;
		try {
			openConnection();

			String query = "SELECT article.id_article, article.article_quantity, article.article_quantity_real_stock, article.article_state, article.article_creation_date, article.article_update_date, "
					+ "packaging.packaging_name,product.product_name,article.id_admin FROM article JOIN packaging ON article.id_packaging=packaging.id_packaging JOIN product ON product.id_product=article.id_product;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (rs.next()) {
				Packaging packaging = new Packaging(rs.getString("packaging_name"));
				Product product = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("id_article"), rs.getDouble("article_quantity"),
						rs.getInt("article_quantity_real_stock"), rs.getString("article_state"),
						rs.getDate("article_creation_date"), rs.getDate("article_update_date"), packaging, product,
						rs.getInt("id_admin"));
				listArticle.add(art);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listArticle;
	}

	/**
	 * List all articles from the database for a given supplier
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Article> listAllArticle(Supplier supplier) throws Exception {
		ArrayList<Article> listArticle = new ArrayList<Article>();
		Article art = null;
		try {
			openConnection();

			String query = "SELECT article.id_article, article.article_quantity, article.article_quantity_real_stock, article.article_state, article.article_creation_date, article.article_update_date, "
					+ "packaging.packaging_name,product.product_name,article.id_admin FROM article JOIN packaging ON article.id_packaging=packaging.id_packaging JOIN product ON product.id_product=article.id_product "
					+ "JOIN sell ON sell.id_product = product.id_product JOIN supplier on supplier.id_supplier = sell.id_supplier WHERE (supplier.supplier_name=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, supplier.getName());
			ResultSet rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (rs.next()) {
				Packaging packaging = new Packaging(rs.getString("packaging_name"));
				Product product = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("id_article"), rs.getDouble("article_quantity"),
						rs.getInt("article_quantity_real_stock"), rs.getString("article_state"),
						rs.getDate("article_creation_date"), rs.getDate("article_update_date"), packaging, product,
						rs.getInt("id_admin"));
				listArticle.add(art);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listArticle;
	}

	/**
	 * Create object Article with datas from the database
	 * 
	 * @param idArticle
	 * @return
	 * @throws Exception
	 */
	public Article createArticleInfo(int idArticle) throws Exception {
		openConnection();
		Article art = null;
		ResultSet rs;
		try {
			String query = "SELECT * FROM article JOIN product ON article.id_product = product.id_product JOIN packaging ON article.id_packaging = packaging.id_packaging WHERE (id_article=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, idArticle);
			rs = declaration.executeQuery();
			
			if (rs.next()) {
				Packaging packaging = new Packaging(rs.getString("packaging_name"));
				Product prod = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("article.id_article"), rs.getDouble("article_quantity"),
						rs.getInt("article_quantity_real_stock"), rs.getString("article_state"),
						rs.getDate("article_creation_date"), rs.getDate("article_update_date"), packaging, prod,
						rs.getInt("id_admin"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return art;
	}
	public ArrayList<SupplierSell> giveTableInfo(int idArticle) throws Exception {
		openConnection();
	ArrayList<SupplierSell> supSell = new ArrayList<SupplierSell>() ;
		ResultSet rs;
		String query = "SELECT supplier.supplier_name, sell.buying_price, product.product_name FROM sell JOIN supplier ON supplier.id_supplier = sell.id_supplier JOIN product ON product.id_product = sell.id_product JOIN article ON article.id_product = product.id_product WHERE article.id_article = ? ";
		PreparedStatement declaration = accessDataBase.prepareStatement(query);
		declaration.setInt(1, idArticle);
		rs = declaration.executeQuery();
		while (rs.next()) {
			Supplier sup = querySupplier.createSupplierInfo(rs.getString("supplier_name"));
			Product prod = queryProduct.createProductInfo(rs.getString("product_name"));
			SupplierSell  oneSupSell = new SupplierSell(sup,prod, rs.getDouble("buying_price"));	
			 supSell.add(oneSupSell);
		}
		closeConnection();
		return supSell;
		}
	
	public ArrayList<UnitMeasure> listUnit() throws Exception {
		openConnection();
		ArrayList<UnitMeasure> unit = new ArrayList<UnitMeasure>();
		
		try {
			
			String query = "SELECT unit_measure_name FROM unit_measure  ";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (resultat.next()) {
				
				UnitMeasure unit1 = new UnitMeasure(resultat.getString("unit_measure_name"));
				
				unit.add(unit1);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		
		return unit;
	}
	
	

	public boolean createPrepared(Article article) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `article`(article_quantity,id_packaging,id_admin,id_product) "
					+ "VALUES (?,(SELECT id_packaging FROM packaging WHERE packaging_name=?),?,(SELECT id_product FROM product WHERE product_name=?))";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setDouble(1, article.getQuantity());
			declaration.setString(2, article.getPackaging().getName());
			declaration.setInt(3, article.getIdAdmin());
			declaration.setString(4, article.getProduct().getName());

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	public int createPreparedID(Article article) throws Exception {
		openConnection();
		int last_inserted_id = 0;
		try {
			String query = "INSERT INTO `article`(article_quantity,id_packaging,id_admin,id_product) "
					+ "VALUES (?,(SELECT id_packaging FROM packaging WHERE packaging_name=?),?,(SELECT id_product FROM product WHERE product_name=?))";
			PreparedStatement declaration = accessDataBase.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			declaration.setDouble(1, article.getQuantity());
			declaration.setString(2, article.getPackaging().getName());
			declaration.setInt(3, article.getIdAdmin());
			declaration.setString(4, article.getProduct().getName());

			int executeUpdate = declaration.executeUpdate();
			ResultSet rs = declaration.getGeneratedKeys();
			if (rs.next()) {
				last_inserted_id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return last_inserted_id;
	}

	public Article checkArticle(String product, String packaging, double quantity) throws Exception {
		openConnection();
		Article art = null;
		ResultSet rs;
		try {
			String query = "SELECT * FROM article JOIN product ON article.id_product = product.id_product JOIN packaging ON article.id_packaging = packaging.id_packaging WHERE (product.product_name=?) AND (packaging.packaging_name=?) AND (article.article_quantity=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, product);
			declaration.setString(2, packaging);
			declaration.setDouble(3, quantity);
			rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			if (rs.next()) {
				Packaging pack = new Packaging(rs.getString("packaging_name"));
				Product prod = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("article.id_article"), rs.getDouble("article_quantity"),
						rs.getInt("article_quantity_real_stock"), rs.getString("article_state"),
						rs.getDate("article_creation_date"), rs.getDate("article_update_date"), pack, prod,
						rs.getInt("id_admin"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return art;
	}

	public boolean updatePrepared(String valueChanged, String newValue, int iD) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "";
			switch (valueChanged) {
			case "quantityStock":
				query = "UPDATE article SET article_quantity_real_stock=? WHERE id_article=?";
				break;
			}

			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, newValue);
			declaration.setInt(2, iD);

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

}