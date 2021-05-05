package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Order;
import entities.OrderLine;
import entities.Supplier;

public class QueryOrder extends MyConnection{
	
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
				ord = new Order(rs.getInt("id_order"), rs.getDate("order_validation_date"),
						rs.getDate("order_delivery_date"), rs.getString("order_state"), supplier,rs.getInt("id_admin"));
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
				ordLine = new OrderLine(rs.getInt("id_article"),rs.getInt("id_order"),rs.getInt("request_order_line_quantity"));
				listOrderLine.add(ordLine);
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
		closeConnection();
		return listOrderLine;
	}
	
	

}