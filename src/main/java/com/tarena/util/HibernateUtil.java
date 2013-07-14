package com.tarena.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static ThreadLocal<Session> threadLocal =new ThreadLocal<Session>();
	private static SessionFactory sessionFactory ;
	static {
		try {
			sessionFactory =new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession(){
		Session session=null;
		session=threadLocal.get();
		if(session==null){
			session =sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	public static void closeSession(){
		Session session=null;
		session =threadLocal.get();
		if(session!=null&&session.isOpen()){
			session.close();
			threadLocal.set(null);
		}
	}
}
