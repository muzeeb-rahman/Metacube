package com.metacube.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.model.User;

public class UserDao {
	
	
	private List<User> userList = new ArrayList<User>();
	
	private static UserDao userDao_Object = null;
	
	//to make the class singleton
	private UserDao(){	}
	
	//returns the object of UserDao class
	public static UserDao getInstance()
	{
		if(userDao_Object == null)
		{
			userDao_Object = new UserDao();
		}
		return userDao_Object;
	}
	
	//returns the list of all available users
	public List<User> getAllUser()
	{
		return userList;
	}
	
	//add the user in the list of users
	public void add(User user) {
		userList.add(user);
	}



	
	
	

}
