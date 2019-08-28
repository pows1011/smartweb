package webshop.dao;

import java.util.ArrayList;

import webshop.dto.Product;

public class ProductRepository {
	
	private ArrayList<Product> listOfProducts=new ArrayList<Product>();
	private static ProductRepository instance=new ProductRepository();
	
	
	public ProductRepository() {
		Product phone=new Product("p1234", "iPhone", 800000);
		phone.setDescription("4.7-inch, 1334X750 Renina HD display, 8-megapixel iSight Camera");
		phone.setCategory("smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		phone.setFilename("p1234.png");
		
		Product notebook=new Product("P12345", "LG PC 그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LED display, 5rd Generation Intel Core processors");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refurbished");
		notebook.setFilename("p1235.png");
		
		Product tablet=new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("212.8*125.6*6mm, Super AMOLED display, OctaCore processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCategory("Old");
		tablet.setFilename("p1236.png");
		
		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
		
	}
	
	public ArrayList<Product> getAllProducts(){
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById=null;
		
		for(int i=0; i<listOfProducts.size(); i++) {
			Product product=listOfProducts.get(i);
			if(product !=null && product.getProductId()!=null&&product.getProductId().equals(productId)) {
				productById=product;
				break;
			}
		}
		return productById;
	}
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
}
