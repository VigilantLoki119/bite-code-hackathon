package com.cts.testAutomation.model;

public class TestCaseExecutorRequest {
	private String testCaseSessionKey;
	private String siteName;
	private String testCaseName;
	private String url;
	public String getTestCaseSessionKey() {
		return testCaseSessionKey;
	}
	public void setTestCaseSessionKey(String testCaseSessionKey) {
		this.testCaseSessionKey = testCaseSessionKey;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
