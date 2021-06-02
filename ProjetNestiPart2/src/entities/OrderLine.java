package entities;

/**
 * Class Entity OrderLine
 * @author Thibault
 *
 */
public class OrderLine {
	
	int idArticle;
	int idOrder;
	int quantity;
	Article article;
	
	/**
	 * Constructor
	 * @param int idArticle
	 * @param int idOrder
	 * @param int quantity
	 */
	public OrderLine(int idArticle, int idOrder, int quantity) {
		this.idArticle=idArticle;
		this.idOrder=idOrder;
		this.quantity=quantity;
	}

	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the idOrder
	 */
	public int getIdOrder() {
		return idOrder;
	}

	/**
	 * @param idOrder the idOrder to set
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
		
	
}
