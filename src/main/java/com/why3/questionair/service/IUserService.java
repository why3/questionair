package com.why3.questionair.service;

import java.util.List;

import zquirrel.util.PageBean;

import com.why3.questionair.entity.User;

public interface IUserService {

	/**
	 * Check if the user is valid.
	 * 
	 * @param user
	 *            the user to check.
	 * @return the user or null if user is not valid.
	 */
	User verify(String username, String password);

	/**
	 * Register the user to the database.
	 * 
	 * @param user
	 *            the user to register.
	 * @return the persistent user.
	 */
	User register(User user);

	/**
	 * Find the specific user.
	 * 
	 * @param id
	 *            the ID of the user.
	 * @return the user.
	 */
	User findUser(int id);

	/**
	 * Find the users according to the given example.
	 * 
	 * @param example
	 *            the example.
	 * @param pageBean
	 *            the pagination bean.
	 * @return
	 */
	List<User> findUsers(User example, PageBean pageBean);

	/**
	 * Find users by power bit.
	 */
	List<User> findUsersFilterByPowerBit(long power, PageBean pageBean);

	/**
	 * Get all the users.
	 * 
	 * @param pageBean
	 *            the pagination bean.
	 * @return the list of users.
	 */
	List<User> findUsers(PageBean pageBean);
}
