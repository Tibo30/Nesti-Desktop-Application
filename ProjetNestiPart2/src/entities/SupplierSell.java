package entities;

import java.util.ArrayList;
import java.util.Date;

public class SupplierSell {
	
	Supplier supplier;
	ArrayList<Product> products; // list of object product
	ArrayList<Double> buyingPrices;
	
	public SupplierSell(Supplier supplier,ArrayList<Product> products,ArrayList<Double> buyingPrices) {
		this.supplier=supplier;
		this.products=products;
		this.buyingPrices=buyingPrices;
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


	
	

}
