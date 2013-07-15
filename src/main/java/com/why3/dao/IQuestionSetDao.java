package com.why3.dao;

import java.util.List;

import com.why3.entity.QuestionSet;

/**
 * The data access object inferface for {@link QuestionSet}.
 * 
 * @author yfwz100, Huang Xufeng
 * 
 */
public interface IQuestionSetDao {

	/**
	 * Save question set to the database.
	 * 
	 * @param questionSet
	 *            the question set.
	 * @return the new ID.
	 */
	int saveQuestionSet(QuestionSet questionSet);

	/**
	 * Find the question set.
	 * 
	 * @param questionSetId
	 *            the question set ID.
	 * @return the question set.
	 */
	QuestionSet findQuestionSet(int questionSetId);

	/**
	 * List all question sets.
	 * 
	 * @return the list of question sets.
	 */
	List<QuestionSet> listQuestionSets();

	/**
	 * Delete the question set.
	 * 
	 * @param qs
	 *            the question set to delete.
	 * @return the affected rows.
	 */
	int deleteQuestionSet(QuestionSet qs);

	/**
	 * Delete the question set by ID. (A handful method equivalent to
	 * {@link #deleteQuestionSet(QuestionSet)}.
	 * 
	 * @param qsid
	 *            the ID of the question set to delete.
	 * @return the affected rows.
	 */
	int deleteQuestionSet(int qsid);

	/**
	 * Update the question set with given parameters.
	 * 
	 * @param qs
	 *            the question set to be updated
	 * @return the affected rows.
	 */
	int updateQuestionSet(QuestionSet qs);
}
