package com.why3.questionair.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;

import com.why3.questionair.dao.IUserDao;
import com.why3.questionair.entity.User;

/**
 * Data Access Object of {@link User}.
 * 
 * @author yfwz100
 * 
 */
public class UserDaoImpl extends CHibDao<User> implements IUserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public List<User> findUsers(int start, int maxResult) {
		return this.list(start, maxResult);
	}

	@Override
	public List<User> findUsersByPowerBits(long bits, int start, int maxResult) {
		return this.list(Restrictions.eq("power", bits), start, maxResult);
	}

	@Override
	public User findUser(String username) {
		return this.find(Restrictions.eq("username", username));
	}

	@Override
	public User findUser(int id) {
		return this.find(Restrictions.eq("id", id));
	}

	@Override
	public int saveUser(User user) {
		Integer integer = (Integer) this.save(user);
		if (integer != null) {
			return integer;
		} else {
			return -1;
		}
	}

	@Override
	public int updateUser(User user) {
		return this.update(user);
	}

	@Override
	public int deleteUser(User user) {
		return this.delete(user);
	}

	@Override
	public int deleteUser(int id) {
		User user = new User();
		user.setUserId(id);
		return deleteUser(user);
	}

	@Override
	public int count(long powerBits) {
		return this.count(Restrictions.eq("power", powerBits));
	}

	@Override
	public List<User> findUsers(User example, int start, int maxResults) {
		Criterion criterion = Example.create(example).enableLike(
				MatchMode.ANYWHERE);
		return this.list(criterion, start, maxResults);
	}

	@Override
	public int count(User example) {
		Criterion criterion = Example.create(example).enableLike(
				MatchMode.ANYWHERE);
		return this.count(criterion);
	}

}
