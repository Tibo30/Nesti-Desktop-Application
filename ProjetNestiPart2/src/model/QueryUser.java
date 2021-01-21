//package model;
//import java.sql.Statement;
//
//import java.util.Arrays;
//
//
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import entities.Admin;
//
//
//public class QueryUser extends MyConnection{
//	
//	static boolean flag;
//
//	public QueryUser(String url, String login, String mdp, String bdd) {
//		super(url, login, mdp, bdd);
//		
//	}
//	
//	/**
//	 * Read user's attributes
//	 */
//	public static void readAll() {
//
//		try {
//
//			
//			Statement declaration = accessDataBase.createStatement();
//
//			
//			String query = "SELECT id, lastName FROM Admin;";
//		ResultSet resultat = declaration.executeQuery(query);
//
//			/** Récupération des données */
//
//			// 5. On récupère le résultat dans un objet de la classe Resultat
//
//
//			while (resultat.next()) {
//				Admin user = new Admin(0, query, query, query, query, query, query, flag, null, null);
//			
//				System.out.println(user.toString());
//			}
//		} catch (Exception e) {
//			System.err.println("Erreur d'affichage du user: " + e.getMessage());
//		}
//	}
//
//	
//	public boolean createUser(Admin user) {
//		try {
//			openConnection();
//
//			String query = "INSERT INTO `user`(id, lastName, firstName, userName, password, adress, state, creatDate, updateDate, isSuperAdmin) VALUES (?,?,?,?,?,?,?,?,?)";
//			
//		 		
//			PreparedStatement declaration = accessDataBase.prepareStatement(query);
//
//			declaration.setInt(1, user.getId());
//			declaration.setString(2, user.getLastName());
//			declaration.setString(3, user.getFirstName());
//			declaration.setString(4, user.getUserName());
//			declaration.setString(5, user.getPassword());
//			declaration.setString(6, user.getAdress());
//			declaration.setString(7, user.getState());
//			//declaration.setString(8, user.getCreateDate());
//			//declaration.setString(9, user.getUpdateDate());
//			declaration.setString(10, user.getLastName());
//			
//
//			int executeUpdate = declaration.executeUpdate();
//			
//		} catch (Exception e) {
//			System.err.println("Erreur dans la création du user: " + e.getMessage());
//		}
//		return flag;
//	
//	
//	
//	
//	
//}
//}
//	
//	
//	
//	
//	
//
