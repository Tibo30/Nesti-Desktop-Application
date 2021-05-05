package entities;

import java.util.ArrayList;

public class SupplierSell {
	
	Supplier supplier;
	ArrayList<Product> products; // list of object product
	ArrayList<Double> buyingPrices;
	Product product;
	double buyingPrice;
	
	public SupplierSell(Supplier supplier,ArrayList<Product> products,ArrayList<Double> buyingPrices) {
		this.supplier=supplier;
		this.products=products;
		this.buyingPrices=buyingPrices;
	}
	
	public SupplierSell(Supplier supplier,Product product, double buyingPrice) {
		this.supplier=supplier;
		this.product=product;
		this.buyingPrice=buyingPrice;
	}


	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<Double> getBuyingPrices() {
		return buyingPrices;
	}

	public void setBuyingPrices(ArrayList<Double> buyingPrices) {
		this.buyingPrices = buyingPrices;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}


	
	

}
