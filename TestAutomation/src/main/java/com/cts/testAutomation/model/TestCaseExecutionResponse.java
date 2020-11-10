package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestCaseExecutionResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String finalStatus;
	List<TestResultWithStatus> testResultWithStatusList;
	
	public String getFinalStatus() {
		return finalStatus;
	}
	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}
	public List<TestResultWithStatus> getTestResultWithStatusList() {
		return testResultWithStatusList;
	}
	public void setTestResultWithStatusList(List<TestResultWithStatus> testResultWithStatusList) {
		this.testResultWithStatusList = testResultWithStatusList;
	}
	
	
	

}
