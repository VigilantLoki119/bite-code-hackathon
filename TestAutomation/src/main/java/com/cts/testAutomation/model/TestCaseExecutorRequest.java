package com.cts.testAutomation.model;

import java.util.Map;

import com.cts.testAutomation.entity.TestCaseXpath;

public class TestCaseExecutorRequest {
	private String testCaseSessionKey;
	private String siteName;
	private String testCaseName;
	private String url;
	private Map<String, TestCaseXpath> xpathMap;
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
	public Map<String, TestCaseXpath> getXpathMap() {
		return xpathMap;
	}
	public void setXpathMap(Map<String, TestCaseXpath> xpathMap) {
		this.xpathMap = xpathMap;
	}
	
	
	
}
