package com.tarena.dao;

import com.tarena.po.QuestionSet;

public interface IQuestionSetDao {
	int saveQuestionSet(QuestionSet questionSet);
	QuestionSet getQuestionSet(int questionSetId);
}
