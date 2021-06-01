package entities;

import java.util.ArrayList;

/**
 * Class Entity SupplierSell
 * @author Thibault
 *
 */
public class SupplierSell {
	
	Supplier supplier;
	ArrayList<Product> products; // list of object product
	ArrayList<Double> buyingPrices;
	Product product;
	double buyingPrice;
	
	/**
	 * Constructor
	 * @param Supplier supplier
	 * @param ArrayList<Product> products
	 * @param ArrayList<Double> buyingPrices
	 */
	public SupplierSell(Supplier supplier,ArrayList<Product> products,ArrayList<Double> buyingPrices) {
		this.supplier=supplier;
		this.products=products;
		this.buyingPrices=buyingPrices;
	}
	
	/**
	 * Constructor
	 * @param Supplier supplier
	 * @param Product product
	 * @param double buyingPrice
	 */
	public SupplierSell(Supplier supplier,Product product, double buyingPrice) {
		this.supplier=supplier;
		this.product=product;
		this.buyingPrice=buyingPrice;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * @return the buyingPrices
	 */
	public ArrayList<Double> getBuyingPrices() {
		return buyingPrices;
	}

	/**
	 * @param buyingPrices the buyingPrices to set
	 */
	public void setBuyingPrices(ArrayList<Double> buyingPrices) {
		this.buyingPrices = buyingPrices;
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
	 * @return the buyingPrice
	 */
	public double getBuyingPrice() {
		return buyingPrice;
	}

	/**
	 * @param buyingPrice the buyingPrice to set
	 */
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}





	
	

}
