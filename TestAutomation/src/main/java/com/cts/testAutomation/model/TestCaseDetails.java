package com.cts.testAutomation.model;

import java.io.Serializable;

public class TestCaseDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int testCaseId;
	private String testCaseName;
	public int getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(int testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	
	

}
