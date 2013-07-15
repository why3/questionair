package com.why3.dao.impl;

import java.util.List;

import zquirrel.util.datasource.CHibDao;
import zquirrel.util.datasource.HibDao;

import com.why3.dao.IQuestionSetDao;
import com.why3.entity.QuestionSet;

/**
 * The implementation of the QuestionSet Data Access Object.
 * 
 * @author yfwz100, Alvin.
 * 
 */
public class QuestionSetDaoImpl implements IQuestionSetDao {

	// the abstract dao.
	private HibDao<QuestionSet> dao = new CHibDao<QuestionSet>(QuestionSet.class);

	@Override
	public int saveQuestionSet(QuestionSet questionSet) {
		Integer qsid = (Integer) dao.save(questionSet);
		if (qsid != null) {
			return qsid;
		} else {
			return -1;
		}
	}

	@Override
	public QuestionSet findQuestionSet(int questionSetId) {
		return dao.find(questionSetId);
	}

	@Override
	public List<QuestionSet> listQuestionSets() {
		return dao.listAll();
	}

	@Override
	public int deleteQuestionSet(QuestionSet qs) {
		return dao.delete(qs);
	}

	@Override
	public int deleteQuestionSet(int qsid) {
		QuestionSet qs = new QuestionSet();
		qs.setQuestionSetId(qsid);
		return deleteQuestionSet(qs);
	}

	@Override
	public int updateQuestionSet(QuestionSet qs) {
		return dao.update(qs);
	}
}
