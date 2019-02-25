package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.CartDao;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.enums.status;

public class CartFacade {
	
	
	CartDao cartDao = new CartDao();
	ProductFacade productFacade = new ProductFacade();
	
	/*
	 * addProductToCart method add the given quantity of the product to the cart
	 * @param requires the userID, object of product, and productQty to update the data
	 * @return the enum Successful is product is updated
	 */
	
	
	public status addProductToCart(int userId, Product product, int productQTY)
	{
		Cart cart = cartDao.getCart(userId);
		if(cart!=null)
		{
			//checks the product quantity is available in the store
			if(productFacade.isAvailQuantity(product.getProduct_code(), productQTY))
			{
				//checks if product is already available in the cart
				Product pro = cart.getProductById(product.getProduct_code());
				if(pro!=null)
				{
					pro.setProduct_qty(pro.getProduct_qty()+productQTY);
				}
				else
				{
					Product newProduct = new Product(product.getProduct_code(), product.getProduct_type(), product.getProduct_name(), product.getProduct_price(), productQTY);
					cart.addProduct(newProduct);
				}
				
				//updates the quantity in the store
				productFacade.updateProduct(product.getProduct_code(), productQTY);
				return status.SUCCESSFULL;
			}
			return status.NOTSUCCESSFULL;
		}
		else 
		{
			return status.NOTEXISTS;
		}
		
	}
	
	/*
	 * deleteProductFromCart delete the given quantity of the product from the cart
	 * @param requires the userID, object of product, and productQty to update the data
	 * @return the enum Successful is product is updated
	 */
	
	public status deleteProductFromCart(int userId, Product product, int productQTY)
	{
		Cart cart = cartDao.getCart(userId);
		Product pro = cart.getProductById(product.getProduct_code());
		if(pro!=null)
		{
			//checks if quantity is same, if same then remove the product form cart
			if(pro.getProduct_qty() == productQTY)
			{
				 cart.removeProduct(pro);
				 productFacade.addProduct(product.getProduct_code(), productQTY);
				 return status.SUCCESSFULL;
			}
			//checks if quantity if greater than input, if greater then updates the quantity in the cart 
			else if(pro.getProduct_qty() > productQTY)
			{
				pro.setProduct_qty(pro.getProduct_qty() - productQTY);
				productFacade.addProduct(product.getProduct_code(), productQTY);
				return status.SUCCESSFULL;
			}
			else
			{
				return status.NOTSUCCESSFULL;
			}	
		}
		return status.NOTEXISTS;
	}
	
	/*
	 * getCartList method returns the list of the products available in the cart
	 * @param requires the userID
	 * @returns the list of the products available in the cart 
	 */
	public List<Product> getCartList(int user_id)
	{
		Cart cart = cartDao.getCart(user_id);
		if(cart!=null)
		{
			return cart.getCartItem();
		}
		return null;
	}
	
	
	

}
