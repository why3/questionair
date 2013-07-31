package com.why3.questionair.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import zquirrel.util.datasource.CHibDao;
import zquirrel.util.datasource.HibernateUtil;

import com.why3.questionair.dao.IAnswerSetDao;
import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;

/**
 * Data Access Object of {@link AnswerSet}.
 * 
 * @author yfwz100
 * 
 */
public class AnswerSetDaoImpl extends CHibDao<AnswerSet> implements
		IAnswerSetDao {

	public AnswerSetDaoImpl() {
		super(AnswerSet.class);
	}

	@Override
	public int saveAnswerSet(AnswerSet answerSet) {
		Integer answerSetId = (Integer) this.save(answerSet);
		if (answerSetId != null) {
			return answerSetId;
		} else {
			return -1;
		}
	}

	@Override
	public List<AnswerSet> listAnswerSets() {
		return this.listAll();
	}

	@Override
	public List<AnswerSet> listAnswerSets(QuestionSet qs, User user) {
		return this.list(Restrictions.and(Restrictions.eq("questionSetId", qs),
				Restrictions.eq("userId", user)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnswerSet> listAnswerSets(User user) {
		return HibernateUtil.getSession().createCriteria(AnswerSet.class)
				.add(Restrictions.eq("userId", user))
				.addOrder(Order.desc("time")).list();
	}

	@Override
	public AnswerSet findAnswerSet(int asid) {
		return this.find(asid);
	}

	@Override
	public int updateAnswerSet(AnswerSet as) {
		return this.update(as);
	}

	@Override
	public int deleteAnswerSet(AnswerSet as) {
		return this.delete(as);
	}

	@Override
	public int deleteAnswerSet(int asid) {
		AnswerSet as = new AnswerSet();
		as.setAnswerSetId(asid);
		return deleteAnswerSet(as);
	}

	@Override
	public AnswerSet findLatestAnswerSet(QuestionSet qSet, User user) {
		try {
			List<AnswerSet> asList = this.list(Restrictions.and(
					Restrictions.eq("questionSetId", qSet),
					Restrictions.eq("userId", user)), Order.desc("time"), 1, 1);
			if (asList.isEmpty()) {
				return null;
			} else {
				return asList.get(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
