package entities;


public class OrderLine {
	
	int quantity;
	Article article;
	
	public OrderLine(int quantity, Article article) {
		
		this.quantity=quantity;
		this.article=article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
	
}
