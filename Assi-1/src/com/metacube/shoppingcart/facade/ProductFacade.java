package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.ProductDao;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.enums.status;

public class ProductFacade 
{
	
	ProductDao productDao = ProductDao.getInstance();
	
	//returns the list of product available in the store by calling ProductDao object
	public List<Product> getStoreProduct()
	{
		return productDao.getAllproducts();
	}
	
	
	/*
	 * getProductById method finds the product of given productID
	 * @param rquires the productID
	 * @returns the reference of object of type product
	 */
	public Product getProductById(int productID)
	{
		List<Product> storeProducts = productDao.getAllproducts();
		
		for(Product p : storeProducts)
		{
			if(p.getProduct_code() == productID)
			{
				return p;
			}
		}
		return null;	
	}
	
	/*
	 * updateProduct updates the product quantity 
	 * @param requires product id and the quantity to be updated
	 * @returns the enum successful if product quantity is updated
	 */
	public status updateProduct(int pro_id, int pro_qty)
	{	
		//finds the product of given product id
		Product p = getProductById(pro_id);
		if(p!=null)
		{
			//checks the quantity of the product 
			if(p.getProduct_qty() >= pro_qty)
			{
				//updating the product quantity
				p.setProduct_qty(p.getProduct_qty()-pro_qty);
				return status.SUCCESSFULL;
			}
			else
			{
				return status.NOTSUCCESSFULL;
			}
		}
		return null;
	}
	
	/*
	 * isAvailQuantity checks whether given quantity is available for the product id given in parameter
	 * @param requires the productID and Product quantity
	 * @returns true if quantity is available and false if not available
	 */
	public boolean isAvailQuantity(int productID, int productQuantity)
	{
		Product p = getProductById(productID);
		if(p!=null)
		{
			if(p.getProduct_qty() >= productQuantity)
			{
				return true;
			}
		}
		return false;
	}
	
	/*
	 * addProduct method add the product quantity in the store for the given product id
	 * @param requires the product id and the quantity to be added
	 * @returns the enum successful if quantity id updated in the store
	 */
	public status addProduct(int pro_id,int pro_qty)
	{
		Product p = getProductById(pro_id);
		if(p!=null) 
		{
			//updates the quantity
			p.setProduct_qty(p.getProduct_qty()+pro_qty);
			return status.SUCCESSFULL;
		}
		return status.NOTSUCCESSFULL;
	}
	
	
	
	
}
