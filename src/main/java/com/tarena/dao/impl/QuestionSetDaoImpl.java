package com.tarena.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tarena.dao.IQuestionSetDao;
import com.tarena.po.QuestionSet;
import com.tarena.util.HibernateUtil;

public class QuestionSetDaoImpl implements IQuestionSetDao {

	@Override
	public int saveQuestionSet(QuestionSet questionSet) {
		int questionSetId=0;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
			questionSetId=(Integer)session.save(questionSet);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.closeSession();
		}
		return questionSetId;
	}

	@Override
	public QuestionSet getQuestionSet(int questionSetId) {
		QuestionSet questionSet=null;
		Session session=null;
		try {
			session =HibernateUtil.getSession();
			String hql = "from QuestionSet where questionSetId =:questionSetId";
			Query query =session.createQuery(hql);
			query.setParameter("questionSetId", questionSetId);
			questionSet =(QuestionSet) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return questionSet;
	}
}
