package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestCasesResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int appId;
	private String appName;
	private int pageId;
	private String pageName;
	private List<TestCaseDetails> testCases;
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
	public List<TestCaseDetails> getTestCases() {
		return testCases;
	}
	public void setTestCases(List<TestCaseDetails> testCases) {
		this.testCases = testCases;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	

}
