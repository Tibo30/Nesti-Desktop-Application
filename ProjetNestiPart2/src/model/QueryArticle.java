package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Article;
import entities.Packaging;
import entities.Product;
import entities.Supplier;

public class QueryArticle extends MyConnection {
	private QueryProduct queryProduct = new QueryProduct();

	public ArrayList<Article> listAllArticle() throws Exception {
		ArrayList<Article> listArticle = new ArrayList<Article>();
		Article art = null;
		try {
			openConnection();

			String query = "SELECT article.id_article, article.article_quantity, article.article_quantity_real_stock, article.article_state, article.article_creation_date, article.article_update_date, "
					+ "packaging.packaging_name,product.product_name,article.id_admin FROM article JOIN packaging ON article.id_packaging=packaging.id_packaging JOIN product ON product.id_product=article.id_product;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* Récupération des données */
			while (rs.next()) {
				Packaging packaging = new Packaging(rs.getString("packaging_name"));
				Product product = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("id_article"), rs.getDouble("article_quantity"),
						rs.getInt("article_quantity_real_stock"), rs.getString("article_state"),
						rs.getDate("article_creation_date"), rs.getDate("article_update_date"), packaging,product,
						rs.getInt("id_admin"));
				listArticle.add(art);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listArticle;
	}
	
	public Article createArticleInfo(int idArticle) throws Exception {
		openConnection();
		Article art = null;
		ResultSet rs;
		try {
			String query = "SELECT * FROM article JOIN product ON article.id_product = product.id_product JOIN packaging ON article.id_packaging = packaging.id_packaging WHERE (id_article=?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, idArticle);
			rs = declaration.executeQuery();
			/* Récupération des données */
			if (rs.next()) {
				Packaging packaging = new Packaging(rs.getString("packaging_name"));
				Product prod = queryProduct.createProductInfo(rs.getString("product_name"));
				art = new Article(rs.getInt("article.id_article"),rs.getDouble("article_quantity"), rs.getInt("article_quantity_real_stock"),
						rs.getString("article_state"),rs.getDate("article_creation_date"), rs.getDate("article_update_date"), packaging,prod,rs.getInt("id_admin"));
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'utilisateur: " + e.getMessage());
		}
		closeConnection();
		return art;
	}

}