package com.why3.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;
import zquirrel.util.datasource.HibDao;

import com.why3.dao.IAnswerDao;
import com.why3.entity.Answer;
import com.why3.entity.AnswerSet;

/**
 * Data Access Object of {@link Answer}.
 * 
 * @author yfwz100
 * 
 */
public class AnswerDaoImpl implements IAnswerDao {

	// the abstract data access object.
	private HibDao<Answer> dao = new CHibDao<Answer>(Answer.class);

	@Override
	public List<Answer> listAnswers(AnswerSet as) {
		return dao.list(Restrictions.eq("answerSetId", as));
	}

	@Override
	public Answer findAnswer(AnswerSet as, int qid, int aid) {
		return dao.find(Restrictions.and(Restrictions.and(
				Restrictions.eq("answerSetId", as),
				Restrictions.eq("questionId", qid)), Restrictions.eq(
				"answerId", aid)));
	}

	@Override
	public Object saveAnswer(Answer answer) {
		return dao.save(answer);
	}

	@Override
	public int deleteAnswer(Answer answer) {
		return dao.delete(answer);
	}

	@Override
	public int deleteAnswer(AnswerSet as, String qid, String aid) {
		Answer answer = new Answer();
		answer.setAnswerSetId(as);
		answer.setQuestionId(qid);
		answer.setAnswerId(aid);
		return deleteAnswer(answer);
	}

}
