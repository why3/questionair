package com.why3.questionair.web.action;

import static zquirrel.util.VarUtil.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.why3.questionair.entity.Answer;
import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;
import com.why3.questionair.service.IQuestionSetService;
import com.why3.questionair.web.ServiceContext;

/**
 * The abstract action to do a QuestionSet. Intended to use with struts 2.
 * 
 * @author plux
 * 
 */
public abstract class QuestionSetAction {

	/**
	 * The ID of the question set.
	 */
	private int id;

	private Map<String, Object> session, request;
	private Map<String, String[]> param;

	protected final static String QUESTION_SET_SESSIONKEY = "questionSet";

	/**
	 * Submit the question.
	 * 
	 * @return question set.
	 */
	public final String submit() {
		// the question set.
		QuestionSet qs = (QuestionSet) session.get(QUESTION_SET_SESSIONKEY);
		if (qs == null) {
			return "illegal-access";
		}

		User user = (User) session.get("user");
		if (user == null) {
			return "illegal-access";
		}

		// the JSON for question set.
		JSONObject object = qs.getJsonObject();

		// the answer of the question set.
		List<Answer> answers = new ArrayList<Answer>();

		// the questions.
		for (int i = 1; i <= 40; i++) {
			String qid = "q" + i;
			String aid = param.get(qid)[0];
			String label = object.getJSONObject(qid).getString(aid);
			if (isEmpty(label)) {
				return "dashboard";
			}

			Answer answer = new Answer();
			answer.setAnswerId(aid);
			answer.setLabel(label);
			answer.setQuestionId(qid);

			answers.add(answer);
		}

		AnswerSet as = ServiceContext.get(IQuestionSetService.class)
				.saveAnswerSet(qs, user, answers,
						doQuestionSet(qs, user, answers));

		if (as == null) {
			return "error";
		}

		// Delete the session.
		session.remove(QUESTION_SET_SESSIONKEY);

		return "success";
	}

	/**
	 * Do the question set result.
	 * 
	 * @param qs
	 *            the question
	 * @param user
	 *            the user
	 * @param answers
	 *            the list of answers.
	 * @return the result.
	 */
	protected abstract String doQuestionSet(QuestionSet qs, User user,
			List<Answer> answers);

	public final String execute() {
		QuestionSet qs = ServiceContext.get(IQuestionSetService.class)
				.getQuestionSet(id);
		
		if (qs == null) {
			return "illegal-access";
		}
		session.put(QUESTION_SET_SESSIONKEY, qs);
		request.put("questionSetJson", qs.getJsonObject());
		return "input";
	}

	/**
	 * Get the ID of the question set.
	 * 
	 * @return the ID of the question set.
	 */
	protected int getId() {
		return id;
	}

	/**
	 * Set the ID of question set.
	 * 
	 * @param testId
	 *            the testId to set
	 */
	protected void setId(int testId) {
		this.id = testId;
	}

	/**
	 * Inject the session object.
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * Inject the request object.
	 */
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	/**
	 * Inject the parameters.
	 */
	public void setParameters(Map<String, String[]> parameters) {
		this.param = parameters;
	}

	/**
	 * Get the map of parameters.
	 * 
	 * @return the map of parameters.
	 */
	public Map<String, String[]> getParameters() {
		return param;
	}

	/**
	 * Get the map of session.
	 * 
	 * @return the session map.
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * Get the map of request attributes.
	 * 
	 * @return the map of request attributes.
	 */
	public Map<String, Object> getRequest() {
		return request;
	}

}
