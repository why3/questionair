package com.why3.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;
import zquirrel.util.datasource.HibDao;

import com.why3.dao.IAnswerSetDao;
import com.why3.entity.AnswerSet;
import com.why3.entity.QuestionSet;
import com.why3.entity.User;

/**
 * Data Access Object of {@link AnswerSet}.
 * 
 * @author yfwz100
 * 
 */
public class AnswerSetDaoImpl implements IAnswerSetDao {

	// the abstract answer set.
	private HibDao<AnswerSet> dao = new CHibDao<AnswerSet>(AnswerSet.class);

	@Override
	public int saveAnswerSet(AnswerSet answerSet) {
		Integer answerSetId = (Integer) dao.save(answerSet);
		if (answerSetId != null) {
			return answerSetId;
		} else {
			return -1;
		}
	}
	
	@Override
	public List<AnswerSet> listAnswerSets() {
		return dao.listAll();
	}

	@Override
	public List<AnswerSet> listAnswerSets(QuestionSet qs, User user) {
		return dao.list(Restrictions.and(Restrictions.eq("questionSetId", qs),
				Restrictions.eq("userId", user)));
	}

	@Override
	public List<AnswerSet> listAnswerSets(User user) {
		return dao.list(Restrictions.eq("userId", user));
	}

	@Override
	public AnswerSet findAnswerSet(int asid) {
		return dao.find(asid);
	}

	@Override
	public int updateAnswerSet(AnswerSet as) {
		return dao.update(as);
	}

	@Override
	public int deleteAnswerSet(AnswerSet as) {
		return dao.delete(as);
	}

	@Override
	public int deleteAnswerSet(int asid) {
		AnswerSet as = new AnswerSet();
		as.setAnswerSetId(asid);
		return deleteAnswerSet(as);
	}

}
