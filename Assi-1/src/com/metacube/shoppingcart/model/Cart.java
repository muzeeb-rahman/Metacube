package com.metacube.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Product> cartItem;
	
	public Cart() 
	{
		cartItem = new ArrayList<Product>();
	}
	
	//returns the list of products available in cart
	public List<Product> getCartItem()
	{
		return cartItem;
	}
	
	/*
	 * getProductById finds the product of given id in the list of the cart
	 * @param requires the product id
	 * @returns the reference of the product of given product id
	 */
	public Product getProductById(int product_id)
	{
		for(Product pro : cartItem)
		{
			if(pro.getProduct_code()==product_id)
			{
				return pro;
			}
		}
		return null;
	}
	
	//adds the product in the list
	public void addProduct(Product product)
	{
		cartItem.add(product);
	}
	
	//removes the product from the list
	public void removeProduct(Product product)
	{
		cartItem.remove(product);
	}
}
