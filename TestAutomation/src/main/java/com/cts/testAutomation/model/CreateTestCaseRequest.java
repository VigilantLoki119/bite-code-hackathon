package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class CreateTestCaseRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String testCaseName;
	private int appId;
	private int pageId;
	private int envIdSite1;
	private int envIdSite2;
	private List<TestCaseStep> testCaseSteps;
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
	public int getEnvIdSite1() {
		return envIdSite1;
	}
	public void setEnvIdSite1(int envIdSite1) {
		this.envIdSite1 = envIdSite1;
	}
	public int getEnvIdSite2() {
		return envIdSite2;
	}
	public void setEnvIdSite2(int envIdSite2) {
		this.envIdSite2 = envIdSite2;
	}
	public List<TestCaseStep> getTestCaseSteps() {
		return testCaseSteps;
	}
	public void setTestCaseSteps(List<TestCaseStep> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}
	
	
	

}
