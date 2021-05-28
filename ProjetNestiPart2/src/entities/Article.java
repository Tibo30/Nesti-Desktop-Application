package entities;

import java.util.Date;

public class Article {
	int id;
	double quantity;
	int realQuant;
	String state;
	Date creationDate;
	Date updateDate;
	Packaging packaging;
	Product product;
	int idAdmin;

	/**
	 * 
	 * @param id
	 * @param quantity
	 * @param realQuant
	 * @param state
	 * @param creationDate
	 * @param updateDate
	 * @param packaging
	 * @param product
	 * @param idAdmin
	 */
	public Article(int id, double quantity, int realQuant, String state, Date creationDate, Date updateDate,
			Packaging packaging, Product product, int idAdmin) {

		this.id = id;
		this.quantity = quantity;
		this.realQuant = realQuant;
		this.state = state;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.product = product;
		this.packaging = packaging;
		this.idAdmin = idAdmin;
	}

	/**
	 * 
	 * @param quantity
	 * @param realQuant
	 * @param packaging
	 * @param product
	 */
	public Article(double quantity, int realQuant, Packaging packaging, Product product) {
		this.quantity = quantity;
		this.realQuant = realQuant;
		this.product = product;
		this.packaging = packaging;
	}

	/**
	 * 
	 */
	public Article() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the realQuant
	 */
	public int getRealQuant() {
		return realQuant;
	}

	/**
	 * @param realQuant the realQuant to set
	 */
	public void setRealQuant(int realQuant) {
		this.realQuant = realQuant;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the packaging
	 */
	public Packaging getPackaging() {
		return packaging;
	}

	/**
	 * @param packaging the packaging to set
	 */
	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}

	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	@Override
	public String toString() {
		return packaging.getName() + " de " + quantity + " " + product.getUnit().getName() + " de " + product.getName();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public double giveArticle(int id) {
		double article = this.quantity;
		return article;
	}

}
