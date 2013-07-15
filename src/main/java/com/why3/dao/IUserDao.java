package com.why3.dao;

import java.util.List;

import com.why3.entity.User;


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
	 * @return the list of users.
	 */
	List<User> findUsers();

	/**
	 * Find all users with the same power bits.
	 * 
	 * @param bits
	 *            the power bits.
	 * @return the list of users.
	 */
	List<User> findUsersByPowerBits(long bits);

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
