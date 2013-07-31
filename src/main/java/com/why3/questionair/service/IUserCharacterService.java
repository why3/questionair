package com.why3.questionair.service;

import java.util.List;

import com.why3.questionair.entity.AnswerSet;
import com.why3.questionair.entity.User;

public interface IUserCharacterService {

	/**
	 * The data interface for user and character.
	 * 
	 * @author plux
	 */
	public interface UserCharacterData {
		/**
		 * Get the good list of the specific choice.
		 * 
		 * @param choice
		 *            the choice
		 * @return the list of good feature.
		 */
		List<String> getGoodList(String choice);

		/**
		 * Get the bad list of the specific choice.
		 * 
		 * @param choice
		 *            the choice
		 * @return the list of bad feature.
		 */
		List<String> getBadList(String choice);

		/**
		 * Get the sum of score of certain choice.
		 * 
		 * @param choice
		 *            the choice.
		 * @return the score.
		 */
		int getScore(String choice);

		/**
		 * Get the result of the test.
		 * 
		 * @return the result.
		 */
		String getResult();
	}

	/**
	 * Get the character data of a user.
	 * 
	 * @see com.why3.questionair.service.IUserService.UserCharacterData
	 * @param user
	 *            the user.
	 * @return
	 */
	UserCharacterData getCharacterData(User user);

	/**
	 * Get the character data of a user of a certain character test.
	 * 
	 * @see com.why3.questionair.service.IUserService.UserCharacterData
	 * @param as
	 *            the answer set.
	 * @return the data.
	 */
	UserCharacterData getCharacterData(AnswerSet as);

}
