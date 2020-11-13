package com.cts.testAutomation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestCaseXpathDetails {
	
	@Id
	@GeneratedValue
	private int testCaseXpathId;
	private String testCaseXpath;
	private String operationName;
	private String inputData;

	@ManyToOne
	@JoinColumn(name = "testCaseId")
	private TestCases testCases;

	public int getTestCaseXpathId() {
		return testCaseXpathId;
	}

	public void setTestCaseXpathId(int testCaseXpathId) {
		this.testCaseXpathId = testCaseXpathId;
	}

	public String getTestCaseXpath() {
		return testCaseXpath;
	}

	public void setTestCaseXpath(String testCaseXpath) {
		this.testCaseXpath = testCaseXpath;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	public TestCases getTestCases() {
		return testCases;
	}

	public void setTestCases(TestCases testCases) {
		this.testCases = testCases;
	}
	
	
	
}
