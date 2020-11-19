package com.cts.testAutomation.model;

import java.io.Serializable;

public class TestCaseRunResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private long sessionId;
	private String testCaseId;
	private String testCaseName;
	private String testCaseSessionKey;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTestCaseSessionKey() {
		return testCaseSessionKey;
	}
	public void setTestCaseSessionKey(String testCaseSessionKey) {
		this.testCaseSessionKey = testCaseSessionKey;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	
	
	

}
