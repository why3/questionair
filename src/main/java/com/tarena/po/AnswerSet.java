package com.tarena.po;

import java.io.Serializable;
import java.util.Date;

public class AnswerSet implements Serializable {

	public AnswerSet() {
	}
	private int answerSetId;
	private QuestionSet questionSetId;
	private User userId;
	private Date time;
	private String result;
	public int getAnswerSetId() {
		return answerSetId;
	}
	public void setAnswerSetId(int answerSetId) {
		this.answerSetId = answerSetId;
	}
	public QuestionSet getQuestionSetId() {
		return questionSetId;
	}
	public void setQuestionSetId(QuestionSet questionSetId) {
		this.questionSetId = questionSetId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
