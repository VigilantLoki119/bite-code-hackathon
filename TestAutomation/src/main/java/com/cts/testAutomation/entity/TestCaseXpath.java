package com.cts.testAutomation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TestCaseXpath {
	
	@Id
	@GeneratedValue
	private int testCaseXpathId;
	private String testCaseXpathStr;
	private String operationName;
	private String inputData;
	private String siteName;
	private String testStepName;
	private int envId;

	@ManyToOne
	@JoinColumn(name = "testCaseId")
	private TestCase testCase;

	public int getTestCaseXpathId() {
		return testCaseXpathId;
	}

	public void setTestCaseXpathId(int testCaseXpathId) {
		this.testCaseXpathId = testCaseXpathId;
	}

	public String getTestCaseXpathStr() {
		return testCaseXpathStr;
	}

	public void setTestCaseXpathStr(String testCaseXpathStr) {
		this.testCaseXpathStr = testCaseXpathStr;
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

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getTestStepName() {
		return testStepName;
	}

	public void setTestStepName(String testStepName) {
		this.testStepName = testStepName;
	}

	public int getEnvId() {
		return envId;
	}

	public void setEnvId(int envId) {
		this.envId = envId;
	}

	public TestCase getTestCase() {
		return testCase;
	}

	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}

	
	
	
	
}
