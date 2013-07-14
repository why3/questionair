package com.tarena.po;

import java.io.Serializable;

public class Answer implements Serializable {

	public Answer() {
	}
	private AnswerSet answerSetId;
	private int questionId;
	private String answerId;
	private String label;
	
	public AnswerSet getAnswerSetId() {
		return answerSetId;
	}
	public void setAnswerSetId(AnswerSet answerSetId) {
		this.answerSetId = answerSetId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
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
