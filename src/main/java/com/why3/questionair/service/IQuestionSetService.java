package com.why3.questionair.service;

import java.util.List;

import com.why3.questionair.entity.Answer;
import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;

/**
 * The Service Interface for {@link QuestionSet} and related {@link AnswerSet}.
 * 
 * @author plux
 * 
 */
public interface IQuestionSetService {

	/**
	 * Get a question set by its unique ID. The ID is the identity in database.
	 * 
	 * @param id
	 *            the ID of question set.
	 * @return the question set.
	 */
	QuestionSet getQuestionSet(int id);

	/**
	 * Get the list of answer set of the user.
	 * 
	 * @param qs
	 *            the question set
	 * @param user
	 *            the user who did the test.
	 * @return the list of answer set.
	 */
	List<AnswerSet> getAnswerSets(QuestionSet qs, User user);

	/**
	 * Get all the answer sets the user holds.
	 * 
	 * @param user
	 *            the user to set.
	 * @return the list of answer sets.
	 */
	List<AnswerSet> getAnswerSets(User user);

	/**
	 * Get the latest answer set of the user.
	 * 
	 * @param qs
	 *            the question set.
	 * @param user
	 *            the user who did the test.
	 * @return the latest answer.
	 */
	AnswerSet getLatestAnswerSet(QuestionSet qs, User user);

	/**
	 * Get the specific answer set.
	 * 
	 * @param id
	 *            the ID of the answer set.
	 * @return the answer set.
	 */
	AnswerSet getAnswerSet(int id);

	/**
	 * Save the answer set of a question set. Note that the answers needn't have
	 * the ID of the answer set.
	 * 
	 * @param qs
	 *            the question set.
	 * @param user
	 *            the user who did the test.
	 * @param ans
	 *            the list of answers.
	 * @param result
	 *            the result of the answer set.
	 * @return
	 */
	AnswerSet saveAnswerSet(QuestionSet qs, User user, List<Answer> ans,
			String result);

	/**
	 * Get the answers of an answer set.
	 * 
	 * @param as
	 *            the answer set.
	 * @return the list of answers.
	 */
	List<Answer> getAnswers(AnswerSet as);
}
