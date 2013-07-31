package com.why3.questionair.dao;

import java.util.List;

import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.QuestionSet;
import com.why3.questionair.entity.User;

/**
 * The data access object inferface for {@link AnswerSet}.
 * 
 * @author Alvin, yfwz100
 * 
 */
public interface IAnswerSetDao {

	/**
	 * Save the answer set.
	 * 
	 * @param answerSet
	 *            the answer set to save.
	 * @return the new ID.
	 */
	int saveAnswerSet(AnswerSet answerSet);

	/**
	 * List the answer sets by user.
	 * 
	 * @param user
	 *            the user to be updated.
	 * @return the list of answer sets.
	 */
	List<AnswerSet> listAnswerSets(QuestionSet qs, User user);

	/**
	 * List the answer sets.
	 * 
	 * @param user
	 *            the user the answer set belongs to.
	 * @return the list of answer sets that the user owns.
	 */
	List<AnswerSet> listAnswerSets(User user);

	/**
	 * List all the answer sets.
	 * 
	 * @return the list of answer sets.
	 */
	List<AnswerSet> listAnswerSets();

	/**
	 * Find the answer set by ID.
	 * 
	 * @param asid
	 *            the ID of the answer set.
	 * @return the AnswerSet object.
	 */
	AnswerSet findAnswerSet(int asid);

	/**
	 * Get the latest answer set of the user and given question set.
	 * 
	 * @param qSet
	 *            the corresponding question set.
	 * @param user
	 *            the user.
	 * @return the answer set if found, otherwise null will be returned.
	 */
	AnswerSet findLatestAnswerSet(QuestionSet qSet, User user);

	/**
	 * Update answer set.
	 * 
	 * @param as
	 *            the answer set to be updated.
	 * @return the affected rows.
	 */
	int updateAnswerSet(AnswerSet as);

	/**
	 * Delete the given answer set.
	 * 
	 * @param as
	 *            the answer set to delete.
	 * @return the affected rows.
	 */
	int deleteAnswerSet(AnswerSet as);

	/**
	 * Delete the answer set by its ID. (A handful method equivalent to
	 * {@link #deleteAnswerSet(AnswerSet)}.
	 * 
	 * @param asid
	 *            the ID of answer set to delete.
	 * @return the affected rows.
	 */
	int deleteAnswerSet(int asid);

}
