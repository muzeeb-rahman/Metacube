package com.metacube.shoppingcart.controller;

import java.util.List;

import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.enums.status;

public class CartController {
	
	CartFacade cartFacade = new CartFacade();
	ProductController productController = new ProductController();
	
	/*
	 * getCartList method return the list of the products available in the list by calling the object of CartFacade class
	 * @param requires the user id to find the cart of the user
	 * @returns the list of the products in the cart of the user
	 */
	public List<Product> getCartList(int user_id)
	{
		return cartFacade.getCartList(user_id);
	}
	
	/*
	 * addProductToCart method add the product into the cart by calling the object of CartFacade class
	 *  @param requires the userID, productID , ProductQTY
	 *  @ returns true if product is added to cart
	 */
	public boolean addProductToCart(int userId, int productID, int productQTY) throws Exception
	{
		Product product=productController.getProductById(productID);
		if(product!=null)
		{
			//if product is available to add in cart
			if(cartFacade.addProductToCart(userId, product,productQTY)==status.SUCCESSFULL)
			{
				return true;
			}
			
			//if quantity is not available
			else if(cartFacade.addProductToCart(userId, product,productQTY)==status.NOTSUCCESSFULL)
			{
				throw new Exception("Quantity Not Available");
			}
		}
		throw new Exception("Product Doesn't exists");
			
	}
	
	/*
	 * deleteProductFromCart to delete product from the cart
	 * @param requires the userID, productID, ProductQTY
	 * @returns true if product is deleted from the cart
	 */
	public boolean deleteProductFromCart(int userID, int productID, int productQTY) throws Exception
	{
		Product product = productController.getProductById(productID);
		if(product!=null)
		{
			if(cartFacade.deleteProductFromCart(userID, product, productQTY) == status.SUCCESSFULL)
			{
				return true;
			}
			else 
			{
				throw new Exception("Quantity Not Available");
			}
		}
		throw new Exception("Product Doesn't Exist");
	}
	
	

}
