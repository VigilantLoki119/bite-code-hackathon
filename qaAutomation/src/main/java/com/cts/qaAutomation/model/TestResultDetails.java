package com.cts.qaAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestResultDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	
	
	
	

}
