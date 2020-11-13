package com.cts.testAutomation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TestCases {
	
	@Id
	@GeneratedValue
	private int testCaseId;
	private String testCaseName;
	private int appId;
	private int pageId;
	
	@OneToMany
	@JoinColumn(name = "testCaseXpathId")
	private List<TestCaseXpathDetails> xpathDetails;

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

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public List<TestCaseXpathDetails> getXpathDetails() {
		return xpathDetails;
	}

	public void setXpathDetails(List<TestCaseXpathDetails> xpathDetails) {
		this.xpathDetails = xpathDetails;
	}
	
	

}
