package com.cts.testAutomation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class TestCase {
	
	@Id
	@GeneratedValue
	private int testCaseId;
	private String testCaseName;
	private int appId;
	private int pageId;

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="testcase_record_details",joinColumns = {@JoinColumn(name="testCaseId")},inverseJoinColumns = {@JoinColumn(name="testCaseXpathId")})
	private List<TestCaseXpath> testCaseXpathList;

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

	public List<TestCaseXpath> getTestCaseXpathList() {
		return testCaseXpathList;
	}

	public void setTestCaseXpathList(List<TestCaseXpath> testCaseXpathList) {
		this.testCaseXpathList = testCaseXpathList;
	}

	
	

}
