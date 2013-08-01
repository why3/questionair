package com.why3.questionair.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

import zquirrel.util.context.ContextRef;

import com.why3.questionair.dao.IAnswerDao;
import com.why3.questionair.dao.IAnswerSetDao;
import com.why3.questionair.entity.Answer;
import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;
import com.why3.questionair.service.IUserCharacterService;

public class UserCharacterServiceImpl implements IUserCharacterService {

	@ContextRef
	private IAnswerDao answerDao;
	@ContextRef
	private IAnswerSetDao answerSetDao;

	// the result map.
	private static Map<String, String> resultMap = new HashMap<String, String>();
	static {
		resultMap.put("s", "活泼型");
		resultMap.put("c", "力量型");
		resultMap.put("m", "完美型");
		resultMap.put("p", "和平型");
	}

	private class UserCharacterDataImpl implements UserCharacterData {

		private Map<String, List<String>> goodMap = new HashMap<String, List<String>>();
		private Map<String, List<String>> badMap = new HashMap<String, List<String>>();
		{
			goodMap.put("s", new ArrayList<String>());
			goodMap.put("c", new ArrayList<String>());
			goodMap.put("m", new ArrayList<String>());
			goodMap.put("p", new ArrayList<String>());

			badMap.put("s", new ArrayList<String>());
			badMap.put("c", new ArrayList<String>());
			badMap.put("m", new ArrayList<String>());
			badMap.put("p", new ArrayList<String>());
		}

		private Map<String, Integer> scoreMap = new HashMap<String, Integer>();

		private String result;

		/**
		 * Initialize the service from answer set.
		 * 
		 * @param as
		 *            the answer set.
		 */
		private final void init(AnswerSet as) {
			if (as == null)
				throw new RuntimeException("Empty answer set.");

			List<Answer> ansList = answerDao
					.listAnswers(as);

			scoreMap.put("s", 0);
			scoreMap.put("c", 0);
			scoreMap.put("m", 0);
			scoreMap.put("p", 0);

			for (Answer ans : ansList) {
				String qid = ans.getQuestionId();
				int n = Integer.parseInt(qid.substring(1));
				if (n <= 20)
					goodMap.get(ans.getAnswerId()).add(ans.getLabel());
				else
					badMap.get(ans.getAnswerId()).add(ans.getLabel());

				scoreMap.put(ans.getAnswerId(),
						1 + scoreMap.get(ans.getAnswerId()));
			}

			// sort the result.
			Map.Entry<String, Integer> mEntry = null;
			for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
				if (mEntry == null || entry.getValue() > mEntry.getValue()) {
					mEntry = entry;
				}
			}
			result = resultMap.get(mEntry.getKey());
		}

		public UserCharacterDataImpl(AnswerSet as) {
			init(as);
		}

		public UserCharacterDataImpl(User user) {
			LogFactory.getLog(UserCharacterData.class).error(user.getUserId());
			QuestionSet questionSet = new QuestionSet();
			questionSet.setQuestionSetId(1);
			AnswerSet answerSet = answerSetDao
					.findLatestAnswerSet(questionSet, user);
			init(answerSet);
		}

		@SuppressWarnings("unused")
		public UserCharacterDataImpl(int asid) {
			AnswerSet as = answerSetDao.findAnswerSet(
					asid);
			init(as);
		}

		public List<String> getGoodList(String type) {
			return goodMap.get(type);
		}

		public List<String> getBadList(String type) {
			return badMap.get(type);
		}

		public int getScore(String type) {
			return scoreMap.get(type);
		}

		public String getResult() {
			return result;
		}
	}

	@Override
	public UserCharacterData getCharacterData(User user) {
		return new UserCharacterDataImpl(user);
	}

	@Override
	public UserCharacterData getCharacterData(AnswerSet as) {
		return new UserCharacterDataImpl(as);
	}

	public IAnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	public IAnswerSetDao getAnswerSetDao() {
		return answerSetDao;
	}

	public void setAnswerSetDao(IAnswerSetDao answerSetDao) {
		this.answerSetDao = answerSetDao;
	}

	public static void setResultMap(Map<String, String> resultMap) {
		UserCharacterServiceImpl.resultMap = resultMap;
	}

}
