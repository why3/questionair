package com.why3.questionair.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import zquirrel.util.context.ContextRef;
import zquirrel.util.datasource.HibernateUtil;
import zquirrel.util.datasource.Transaction;

import com.why3.questionair.dao.IAnswerDao;
import com.why3.questionair.dao.IAnswerSetDao;
import com.why3.questionair.dao.IQuestionSetDao;
import com.why3.questionair.entity.Answer;
import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;
import com.why3.questionair.service.IQuestionSetService;

public class QuestionSetServiceImpl implements IQuestionSetService {
	
	@ContextRef	private IQuestionSetDao questionSetDao;
	@ContextRef private IAnswerSetDao answerSetDao;
	@ContextRef private IAnswerDao answerDao;

	@Override
	public QuestionSet getQuestionSet(int id) {
		return questionSetDao.findQuestionSet(id);
	}

	@Transaction
	@Override
	public AnswerSet saveAnswerSet(QuestionSet qs, User user, List<Answer> ans,
			String result) {
		AnswerSet as = new AnswerSet();
		as.setQuestionSetId(qs);
		as.setTime(new Date());
		as.setUserId(user);

		Integer asId = (Integer) answerSetDao 
				.saveAnswerSet(as);
		if (asId == null)
			throw new HibernateException("Cannot save AnswerSet.");

		for (Answer answer : ans) {
			answer.setAnswerSetId(as);
			answerDao.saveAnswer(answer);
		}

		// save the result to the database.
		as.setResult(result);

		return as;
	}

	@Override
	public List<AnswerSet> getAnswerSets(QuestionSet qs, User user) {
		return answerSetDao.listAnswerSets(qs, user);
	}

	@Override
	public AnswerSet getLatestAnswerSet(QuestionSet qs, User user) {
		return answerSetDao
				.findLatestAnswerSet(qs, user);
	}

	@Override
	public AnswerSet getAnswerSet(int id) {
		return answerSetDao.findAnswerSet(id);
	}

	@Override
	public List<Answer> getAnswers(AnswerSet as) {
		return answerDao.listAnswers(as);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnswerSet> getAnswerSets(User user) {
		List<AnswerSet> asList = HibernateUtil.getSession()
				.createCriteria(AnswerSet.class)
				.add(Restrictions.eq("userId", user))
				.addOrder(Order.desc("time")).list();
		return asList;
	}

	public IQuestionSetDao getQuestionSetDao() {
		return questionSetDao;
	}

	public void setQuestionSetDao(IQuestionSetDao questionSetDao) {
		this.questionSetDao = questionSetDao;
	}

	public IAnswerSetDao getAnswerSetDao() {
		return answerSetDao;
	}

	public void setAnswerSetDao(IAnswerSetDao answerSetDao) {
		this.answerSetDao = answerSetDao;
	}

	public IAnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}

}
