package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.model.Product;

public class ProductDao {
	
	
	List<Product> productList = new ArrayList<Product>();
	
	//to make the class singleton
	private ProductDao() {
		
		//predefined products which used as a store products
		productList.add(new Product(1, "furniture", "chair", 100, 5));
		productList.add(new Product(2, "furniture", "table", 150, 6));
		productList.add(new Product(3, "clothes", "shirt", 50, 3));
		productList.add(new Product(4, "stationary", "pen", 10, 2));
		productList.add(new Product(5, "stationary", "note-book", 20, 7));
	}
	
	private static ProductDao productDao_Object = null;
	
	//returns the object of the ProductDao class
	public static ProductDao getInstance()
	{
		if(productDao_Object == null)
		{
			productDao_Object = new ProductDao();
		}
		return productDao_Object;
	}
	
	//returns the list of all available products
	public List<Product> getAllproducts()
	{
		return productList;
	}

}
