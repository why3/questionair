package com.why3.questionair.service.impl;

import com.why3.questionair.dao.IAnswerDao;
import com.why3.questionair.dao.IAnswerSetDao;
import com.why3.questionair.dao.IQuestionSetDao;
import com.why3.questionair.dao.IUserDao;
import com.why3.questionair.dao.impl.AnswerDaoImpl;
import com.why3.questionair.dao.impl.AnswerSetDaoImpl;
import com.why3.questionair.dao.impl.QuestionSetDaoImpl;
import com.why3.questionair.dao.impl.UserDaoImpl;

import zquirrel.util.context.ServiceContextSupport;

public class DaoContext extends ServiceContextSupport {

	// the singleton instance itself.
	private static final DaoContext CONTEXT = new DaoContext();

	{
		register(IUserDao.class, UserDaoImpl.class);
		register(IAnswerDao.class, AnswerDaoImpl.class);
		register(IAnswerSetDao.class, AnswerSetDaoImpl.class);
		register(IQuestionSetDao.class, QuestionSetDaoImpl.class);
	}

	public static <T> T get(Class<T> clazz) {
		return CONTEXT.getInstance(clazz);
	}
}
