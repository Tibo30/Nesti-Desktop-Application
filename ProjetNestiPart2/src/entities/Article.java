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

	

	public Article(int id, double quantity, int realQuant, String state,Date creationDate,Date updateDate,Packaging packaging, Product product, int idAdmin) {
		
		this.id = id;
		this.quantity = quantity;
		this.realQuant = realQuant;
		this.state = state;
		this.creationDate=creationDate;
		this.updateDate=updateDate;
		this.product = product;
		this.packaging = packaging;
		this.idAdmin = idAdmin;
	}
	
	public Article(double quantity, int realQuant,Packaging packaging, Product product) {
		this.quantity = quantity;
		this.realQuant = realQuant;
		this.product = product;
		this.packaging = packaging;
	}
	
	@Override
	public String toString() {
		return  packaging.getName() + " de " + quantity + " " + product.getUnit().getName() + " de " + product.getName() ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getRealQuant() {
		return realQuant;
	}

	public void setRealQuant(int realQuant) {
		this.realQuant = realQuant;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	
}
