package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class PageDetailsResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int appId;
	private String appName;
	private List<AppPage> appPages;
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public List<AppPage> getAppPages() {
		return appPages;
	}
	public void setAppPages(List<AppPage> appPages) {
		this.appPages = appPages;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	

}
