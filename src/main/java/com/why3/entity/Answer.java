package com.why3.entity;

import java.io.Serializable;

/**
 * Answer entity.
 * 
 * @author Alvin, yfwz100
 * 
 */
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	private AnswerSet answerSetId;
	private String questionId;
	private String answerId;
	private String label;

	public Answer() {
	}

	public AnswerSet getAnswerSetId() {
		return answerSetId;
	}

	public void setAnswerSetId(AnswerSet answerSetId) {
		this.answerSetId = answerSetId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
