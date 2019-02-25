package com.metacube.shoppingcart.model;

public class User {
	
	int user_id;
	String user_name;
	Cart cart;
	
	//parameterized constructor to initialize the required parameter 
	public User(int user_id, String user_name){
		this.user_id = user_id;
		this.user_name = user_name;
		cart = new Cart();
	}

	//returns the user id
	public int getUser_id() {
		return user_id;
	}

	//returns the user name
	public String getUser_name() {
		return user_name;
	}
	
	//returns the cart of the user
	public Cart getCart()
	{
		return cart;
	}

}
