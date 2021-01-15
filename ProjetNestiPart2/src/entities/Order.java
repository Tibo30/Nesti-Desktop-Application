package entities;

import java.util.Date;

public class Order {
	String state;
	Date validationDate;
	Date deliveryDate;
	Article article;

	public Order(String state, Date validationDate, Date deliveryDate, Article article) {
		this.state=state;
		this.validationDate=validationDate;
		this.deliveryDate=deliveryDate;
		this.article= article;

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
}
