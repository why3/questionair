package com.why3.dao;

import java.util.List;

import com.why3.entity.Answer;
import com.why3.entity.AnswerSet;

/**
 * The data access object interface of {@link Answer}.
 * 
 * @author plux
 * 
 */
public interface IAnswerDao {

	/**
	 * List the answers.
	 * 
	 * @param as
	 *            the answer set.
	 * @return the answer set.
	 */
	List<Answer> listAnswers(AnswerSet as);

	/**
	 * Find the specific answer.
	 * 
	 * @param id
	 *            the answer ID.
	 * @return
	 */
	Answer findAnswer(AnswerSet as, int qid, int aid);

	/**
	 * Save the answer.
	 * 
	 * @param answer
	 * @return
	 */
	Object saveAnswer(Answer answer);

	/**
	 * Delete the answer.
	 * 
	 * @param answer
	 * @return
	 */
	int deleteAnswer(Answer answer);

	/**
	 * Delete the answer.
	 * 
	 * @param as
	 *            the answer set.
	 * @param qid
	 *            the question ID.
	 * @param aid
	 *            the answer ID.
	 * @return the qid.
	 */
	int deleteAnswer(AnswerSet as, String qid, String aid);

}
