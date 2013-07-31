package com.why3.questionair.service.impl;

import java.util.List;

import zquirrel.util.PageBean;
import zquirrel.util.datasource.Transaction;

import com.why3.questionair.dao.IUserDao;
import com.why3.questionair.entity.User;
import com.why3.questionair.service.IUserService;

/**
 * The implementation of user service.
 * 
 * @author plux
 */
public class UserServiceImpl implements IUserService {

	@Override
	public User verify(String username, String password) {
		User u = DaoContext.get(IUserDao.class).findUser(username);
		if (u != null && password != null && password.equals(u.getPassword())) {
			return u;
		} else {
			return null;
		}
	}

	@Transaction
	@Override
	public User register(User user) {
		Integer id = DaoContext.get(IUserDao.class).saveUser(user);
		if (id > 0) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User findUser(int id) {
		return DaoContext.get(IUserDao.class).findUser(id);
	}

	@Override
	public List<User> findUsers(PageBean pageBean) {
		List<User> users = DaoContext.get(IUserDao.class).findUsers(
				pageBean.getStart(), pageBean.getPageSize());
		pageBean.setMaxRecords(DaoContext.get(IUserDao.class).count());
		return users;
	}

	@Override
	public List<User> findUsersFilterByPowerBit(long power, PageBean pageBean) {
		List<User> users = DaoContext.get(IUserDao.class).findUsersByPowerBits(
				power, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setMaxRecords(DaoContext.get(IUserDao.class).count(power));
		return users;
	}

	@Override
	public List<User> findUsers(User example, PageBean pageBean) {
		List<User> users = DaoContext.get(IUserDao.class).findUsers(example,
				pageBean.getStart(), pageBean.getPageSize());
		pageBean.setMaxRecords(DaoContext.get(IUserDao.class).count(example));
		return users;
	}

}
