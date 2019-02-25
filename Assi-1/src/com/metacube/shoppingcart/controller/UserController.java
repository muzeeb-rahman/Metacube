package com.metacube.shoppingcart.controller;


import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.User;
import com.metacube.shoppingcart.enums.status;

public class UserController {
	
	UserFacade userFacade = new UserFacade();	
	
	/*
	 * addUser method to add the user in the application
	 * @requires the object of user to add in the list
	 * @return true if user is added 
	 */
	public boolean addUser(User user) throws Exception
	{
		if(userFacade.addUser(user)==status.SUCCESSFULL)
		{
			return true;
		}
		throw new Exception("Duplicate User");
	}
	
	/*
	 * getUserByID method finds the user of given userID by calling UserFacade class
	 * @returns the user of given userID
	 */
	public User getUserByID(int userID)
	{
		return userFacade.getUserByID(userID);
	}

}
