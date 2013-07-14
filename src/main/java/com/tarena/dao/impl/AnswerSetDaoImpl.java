package com.tarena.dao.impl;

import org.hibernate.Session;

import com.tarena.dao.IAnswerSetDao;
import com.tarena.po.AnswerSet;
import com.tarena.util.HibernateUtil;

public class AnswerSetDaoImpl implements IAnswerSetDao {

	@Override
	public int saveAnswerSet(AnswerSet answerSet) {
		int answerSetId=0;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			answerSetId=(Integer)session.save(answerSet);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession();
		}
		return answerSetId;
	}

}
