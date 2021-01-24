package entities;


public class OrderLine {
	
	int idArticle;
	int idOrder;
	int quantity;
	Article article;
	
	public OrderLine(int idArticle, int idOrder, int quantity) {
		this.idArticle=idArticle;
		this.idOrder=idOrder;
		this.quantity=quantity;
	}
	
	

	public int getIdArticle() {
		return idArticle;
	}



	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}



	public int getIdOrder() {
		return idOrder;
	}



	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
