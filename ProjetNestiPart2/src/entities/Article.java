package entities;

public class Article {
	int id;
	int quantity;
	int realQuant;
	String state;
	Admin admin;
	Product product;
	Packaging packaging;
	/**
	 * @param quantity
	 */
	public Article(int quantity) {
		
		this.quantity = quantity;
		
	}
	
	/**
	 * @param id
	 * @param quantity
	 * @param realQuant
	 * @param state
	 * @param admin
	 * @param product
	 * @param packaging
	 */
	public Article(int id, int quantity, int realQuant, String state, Admin admin, Product product,
			Packaging packaging) {
		
		this.id = id;
		this.quantity = quantity;
		this.realQuant = realQuant;
		this.state = state;
		this.admin = admin;
		this.product = product;
		this.packaging = packaging;
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
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	
}
