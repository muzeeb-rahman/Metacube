package com.metacube.shoppingcart.model;

public class Product{
	
	int product_code;
	String product_type;
	String product_name;
	double product_price;
	int product_qty;
	
	//parameterized constructor to initialize the required parameter
	public Product(int product_code, String product_type, String product_name, double product_price,int product_qty){
		this.product_name = product_name;
		this.product_code = product_code;
		this.product_price = product_price;
		this.product_type = product_type;
		this.product_qty = product_qty;
	}

	//returns the product code or id
	public int getProduct_code() {
		return this.product_code;
	}

	//returns the product type
	public String getProduct_type() {
		return this.product_type;
	}

	//returns the product name
	public String getProduct_name() {
		return this.product_name;
	}

	//returns the product price
	public double getProduct_price() {
		return this.product_price;
	}
	
	//returns the product quantity
	public int getProduct_qty()
	{
		return this.product_qty;
	}
	
	//sets the product quantity
	public void setProduct_qty(int qty)
	{
		this.product_qty = qty;
	}
	
	
}
