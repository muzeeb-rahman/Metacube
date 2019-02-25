package com.metacube.shoppingcart.facade;

import java.util.List;

import com.metacube.shoppingcart.dao.UserDao;
import com.metacube.shoppingcart.model.User;
import com.metacube.shoppingcart.enums.status;

public class UserFacade {
	
	UserDao userDao = UserDao.getInstance();
	
	/*
	 * addUser method to add the new user 
	 * @param requires the object user to add in the list
	 * @returns enums successful if user is added in list or duplicate if if user of same id already exists
	 */
	public status addUser(User user)
	{
		User u = getUserByID(user.getUser_id());
		//user doesn't exist in list
		if(u==null)
		{
			userDao.add(user);
			return status.SUCCESSFULL;
		}
		
		//user of same id exist in the list
		return status.DUPLICATE;
		
	}
	
	/*
	 * getUserByID method returns the reference of the user of given user id
	 * @param requires the user id
	 * @returns the reference of the user of given user id
	 */
	public User getUserByID(int id)
	{
		List<User> existingUser = userDao.getAllUser();
		for(User u : existingUser)
		{
			if(u.getUser_id() == id)
			{
				return u;
			}
		}
		return null;
	}
	

}
