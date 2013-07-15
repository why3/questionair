package com.why3.entity;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

public class QuestionSet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Log log = LogFactory.getLog(QuestionSet.class);

	private int questionSetId;
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
		log.debug(content);
		this.content = JSONObject.parseObject(content);
	}

	public JSONObject getJsonObject() {
		return this.content;
	}
}
