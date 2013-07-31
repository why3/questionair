package com.why3.questionair.dao.impl;

import java.util.List;

import zquirrel.util.datasource.CHibDao;

import com.why3.questionair.dao.IQuestionSetDao;
import com.why3.questionair.entity.QuestionSet;

/**
 * The implementation of the QuestionSet Data Access Object.
 * 
 * @author yfwz100, Alvin.
 * 
 */
public class QuestionSetDaoImpl extends CHibDao<QuestionSet> implements
		IQuestionSetDao {

	public QuestionSetDaoImpl() {
		super(QuestionSet.class);
	}

	@Override
	public int saveQuestionSet(QuestionSet questionSet) {
		Integer qsid = (Integer) this.save(questionSet);
		if (qsid != null) {
			return qsid;
		} else {
			return -1;
		}
	}

	@Override
	public QuestionSet findQuestionSet(int questionSetId) {
		return this.find(questionSetId);
	}

	@Override
	public List<QuestionSet> listQuestionSets() {
		return this.listAll();
	}

	@Override
	public int deleteQuestionSet(QuestionSet qs) {
		return this.delete(qs);
	}

	@Override
	public int deleteQuestionSet(int qsid) {
		QuestionSet qs = new QuestionSet();
		qs.setQuestionSetId(qsid);
		return deleteQuestionSet(qs);
	}

	@Override
	public int updateQuestionSet(QuestionSet qs) {
		return this.update(qs);
	}
}
