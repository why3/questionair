package com.why3.questionair.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;

import com.why3.questionair.dao.IAnswerDao;
import com.why3.questionair.entity.Answer;
import com.why3.questionair.entity.AnswerSet;

/**
 * Data Access Object of {@link Answer}.
 * 
 * @author yfwz100
 * 
 */
public class AnswerDaoImpl extends CHibDao<Answer> implements IAnswerDao {

	public AnswerDaoImpl() {
		super(Answer.class);
	}

	@Override
	public List<Answer> listAnswers(AnswerSet as) {
		return this.list(Restrictions.eq("answerSetId", as));
	}

	@Override
	public Answer findAnswer(AnswerSet as, int qid, int aid) {
		return this.find(Restrictions.and(Restrictions.and(
				Restrictions.eq("answerSetId", as),
				Restrictions.eq("questionId", qid)), Restrictions.eq(
				"answerId", aid)));
	}

	@Override
	public Object saveAnswer(Answer answer) {
		return this.save(answer);
	}

	@Override
	public int deleteAnswer(Answer answer) {
		return this.delete(answer);
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
