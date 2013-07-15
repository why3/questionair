package com.why3.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;
import zquirrel.util.datasource.HibDao;

import com.why3.dao.IUserDao;
import com.why3.entity.User;

/**
 * Data Access Object of {@link User}.
 * 
 * @author yfwz100
 * 
 */
public class UserDaoImpl implements IUserDao {

	// the abstract implementation.
	private HibDao<User> dao = new CHibDao<User>(User.class);

	@Override
	public List<User> findUsers() {
		return dao.listAll();
	}

	@Override
	public List<User> findUsersByPowerBits(long bits) {
		return dao.list(Restrictions.eq("powerBits", bits));
	}

	@Override
	public User findUser(String username) {
		return dao.find(Restrictions.eq("username", username));
	}

	@Override
	public User findUser(int id) {
		return dao.find(Restrictions.eq("id", id));
	}

	@Override
	public int saveUser(User user) {
		Integer integer = (Integer) dao.save(user);
		if (integer != null) {
			return integer;
		} else {
			return -1;
		}
	}

	@Override
	public int updateUser(User user) {
		return dao.update(user);
	}

	@Override
	public int deleteUser(User user) {
		return dao.delete(user);
	}

	@Override
	public int deleteUser(int id) {
		User user = new User();
		user.setUserId(id);
		return deleteUser(user);
	}

}
