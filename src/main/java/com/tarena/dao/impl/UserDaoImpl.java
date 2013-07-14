package com.tarena.dao.impl;

import org.hibernate.Session;

import com.tarena.dao.IUserDao;
import com.tarena.po.User;
import com.tarena.util.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public int saveUser(User user) {
		int userId=0;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			userId=(Integer)session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession();
		}
		return userId;
	}

}
