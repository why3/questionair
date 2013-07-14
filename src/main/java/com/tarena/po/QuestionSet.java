package com.tarena.po;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class QuestionSet implements Serializable {

	public QuestionSet() {
	}
	private int questionSetId;
	private JSONObject content;
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
		this.content =JSONObject.parseObject(content);
	}
	public JSONObject getJsonObject(){
		return this.content;
	}
}
