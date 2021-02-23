package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Article;
import entities.Order;
import entities.OrderLine;
import entities.Packaging;
import entities.Product;
import entities.Supplier;

public class QueryOrder extends MyConnection {

	private QuerySupplier querySupplier = new QuerySupplier();
	private QueryArticle queryArticle = new QueryArticle();

	public ArrayList<Order> listAllOrder() throws Exception {
		ArrayList<Order> listOrder = new ArrayList<Order>();
		Order ord = null;
		try {
			openConnection();

			String query = "SELECT request_order.id_order,request_order.order_validation_date,request_order.order_delivery_date,request_order.order_state,request_order.id_admin, supplier.supplier_name FROM request_order JOIN supplier ON request_order.id_supplier=supplier.id_supplier;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (rs.next()) {
				Supplier supplier = querySupplier.createSupplierInfo(rs.getString("supplier_name"));
				ord = new Order(rs.getInt("id_order"), rs.getTimestamp("order_validation_date"),
						rs.getTimestamp("order_delivery_date"), rs.getString("order_state"), supplier,
						rs.getInt("id_admin"));
				listOrder.add(ord);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listOrder;
	}

	public ArrayList<OrderLine> listAllOrderLine(int idOrder) throws Exception {
		ArrayList<OrderLine> listOrderLine = new ArrayList<OrderLine>();
		OrderLine ordLine = null;
		try {
			openConnection();

			String query = "SELECT * FROM request_order_line JOIN request_order ON request_order_line.id_order=request_order.id_order JOIN article ON request_order_line.id_article=article.id_article WHERE (request_order_line.id_order = ?);";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, idOrder);
			ResultSet rs = declaration.executeQuery();
			/* R�cup�ration des donn�es */
			while (rs.next()) {
				ordLine = new OrderLine(rs.getInt("id_article"), rs.getInt("id_order"),
						rs.getInt("request_order_line_quantity"));
				listOrderLine.add(ordLine);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listOrderLine;
	}

	public int createPreparedOrderId(Order order) throws Exception {
		openConnection();
		int last_inserted_id=0;
		try {
			String query="";
			if (order.getState().equals("Accepted")) {
				query = "INSERT INTO `request_order`(order_validation_date, order_state,id_supplier,id_admin) VALUES (CURRENT_TIMESTAMP,?,?,?)";
			} else if (order.getState().equals("Received")) {
				query = "INSERT INTO `request_order`(order_validation_date, order_delivery_date, order_state,id_supplier,id_admin) VALUES (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,?,?,?)";
			} else {
				query = "INSERT INTO `request_order`(order_state,id_supplier,id_admin) VALUES (?,?,?)";
			}
			
			PreparedStatement declaration = accessDataBase.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			declaration.setString(1, order.getState());
			declaration.setInt(2, order.getSupplier().getId());
			declaration.setInt(3, order.getIdAdmin());
			
			int executeUpdate = declaration.executeUpdate();
			ResultSet rs= declaration.getGeneratedKeys();
			
			if(rs.next())
			{
			last_inserted_id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return last_inserted_id;
	}

	public boolean createPreparedOrderLine(OrderLine orderline) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "INSERT INTO `request_order_line`(id_article,id_order,request_order_line_quantity) VALUES (?,?,?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);

			declaration.setInt(1, orderline.getIdArticle());
			declaration.setInt(2, orderline.getIdOrder());
			declaration.setInt(3, orderline.getQuantity());
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur d'insertion utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	public boolean updatePreparedOrder(String valueChanged, String newValue, int iD) throws Exception {
		openConnection();
		boolean flag = false;
		try {
			String query = "";
			switch (valueChanged) {
			case "state":
				query = "UPDATE request_order SET order_state=? WHERE id_order=?";
				break;
			case "validation":
				query = "UPDATE request_order SET order_validation_date=CURRENT_TIMESTAMP WHERE id_order=?";
				break;
			case "delivery":
				query = "UPDATE request_order SET order_delivery_date=CURRENT_TIMESTAMP WHERE id_order=?";
				break;
			case "blocked":
				query ="UPDATE request_order SET order_delivery_date=NULL, order_validation_date=NULL WHERE id_order=?";
				break;
			}
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			if (valueChanged.equals("state")) {
				declaration.setString(1, newValue);
				declaration.setInt(2, iD);
			} else {
				declaration.setInt(1, iD);
			}
			

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}

	public boolean updatePreparedQuantityOrderLine(int quantity, int iDOrder, int iDArticle) throws Exception {
		openConnection();
		boolean flag = false;
		try {

			String query = "UPDATE request_order_line SET request_order_line_quantity=? WHERE id_order=? AND id_article=?";

			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, quantity);
			declaration.setInt(2, iDOrder);
			declaration.setInt(3, iDArticle);

			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
		} catch (Exception e) {
			System.err.println("Erreur de modification utilisateur: " + e.getMessage());
		}
		closeConnection();
		return flag;
	}
	
	public boolean deletePreparedOrderLine(int iDOrder, int iDArticle) throws Exception {
		boolean success = false;
		openConnection();
		try {
			String query = "DELETE request_order_line FROM request_order_line WHERE (id_article = ?) AND (id_order = ?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, iDArticle);
			declaration.setInt(2, iDOrder);
			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Erreur suppression ingredient: " + e.getMessage());
		}
		closeConnection();
		return success;
	}

}