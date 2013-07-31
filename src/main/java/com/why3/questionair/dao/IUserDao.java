package com.why3.questionair.dao;

import java.util.List;

import com.why3.questionair.entity.User;

/**
 * The data access object interface for user.
 * 
 * @author plux
 * 
 */
public interface IUserDao {

	/**
	 * Find all users.
	 * 
	 * @param start
	 *            the start row of the list.
	 * @param maxResult
	 *            the max results to fetch.
	 * @return the list of users.
	 */
	List<User> findUsers(int start, int maxResult);

	/**
	 * The count of the users.
	 * 
	 * @return the count of all users.
	 */
	int count();

	/**
	 * Find all users with the same power bits.
	 * 
	 * @param bits
	 *            the power bits.
	 * @param start
	 *            the start row of the list.
	 * @param maxResult
	 *            the max results to fetch.
	 * @return the list of users.
	 */
	List<User> findUsersByPowerBits(long bits, int start, int maxResult);

	/**
	 * The count of the users.
	 * 
	 * @param powerBits
	 *            the power bits.
	 * @return the count of the users.
	 */
	int count(long powerBits);

	/**
	 * Find the users according to the example.
	 * 
	 * @param example
	 *            the example entity
	 * @return list of users.
	 */
	List<User> findUsers(User example, int start, int maxResults);

	/**
	 * The count of the users.
	 * 
	 * @param example
	 *            the example entity.
	 * @return the count of users.
	 */
	int count(User example);

	/**
	 * Find a specific user by username.
	 * 
	 * @param username
	 *            the username
	 * @return the user or null if not found.
	 */
	User findUser(String username);

	/**
	 * Find a specific user by ID.
	 * 
	 * @param id
	 *            the ID.
	 * @return the user or null if not found.
	 */
	User findUser(int id);

	/**
	 * Save the specific user to the database.
	 * 
	 * @param user
	 *            the user to save.
	 * @return the new ID.
	 */
	int saveUser(User user);

	/**
	 * Update the user with given properties. All the properties should be set
	 * even though you don't want to modify.
	 * 
	 * @param user
	 *            the user to update.
	 * @return the affected rows.
	 */
	int updateUser(User user);

	/**
	 * Delete the user with given user(mainly its ID property). You can also use
	 * the id parameter variant {@link #deleteUser(int)}.
	 * 
	 * @param user
	 *            the user to delete
	 * @return the affected rows.
	 */
	int deleteUser(User user);

	/**
	 * A handful method to delete a user by ID.
	 * 
	 * @param id
	 *            the ID of the user to delete.
	 * @return the affected rows.
	 */
	int deleteUser(int id);
}
