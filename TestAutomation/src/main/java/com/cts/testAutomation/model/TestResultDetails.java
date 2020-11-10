package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestResultDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String siteName;
	private String testCaseSessionKey;
	private String testCaseName;
	private List<TestItem> testResults;
	private String executionStatus;
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public List<TestItem> getTestResults() {
		return testResults;
	}
	public void setTestResults(List<TestItem> testResults) {
		this.testResults = testResults;
	}
	public String getExecutionStatus() {
		return executionStatus;
	}
	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getTestCaseSessionKey() {
		return testCaseSessionKey;
	}
	public void setTestCaseSessionKey(String testCaseSessionKey) {
		this.testCaseSessionKey = testCaseSessionKey;
	}

	
	
	
	

}
