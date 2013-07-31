package com.why3.questionair.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * Question Set Entity.
 * 
 * @author plux
 * 
 */
public class QuestionSet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The question ID.
	 */
	private int questionSetId;

	/**
	 * The title of the question set.
	 */
	private String title;

	/**
	 * The JSON content of the question set.
	 */
	private JSONObject content;

	public QuestionSet() {
	}

	public int getQuestionSetId() {
		return questionSetId;
	}

	public void setQuestionSetId(int questionSetId) {
		this.questionSetId = questionSetId;
	}

	public String getContent() {
		return content.toJSONString();
	}

	public void setContent(String content) {
		this.content = JSONObject.parseObject(content);
	}

	public JSONObject getJsonObject() {
		return this.content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
