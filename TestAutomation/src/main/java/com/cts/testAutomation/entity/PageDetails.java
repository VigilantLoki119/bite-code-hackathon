package com.cts.testAutomation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PageDetails {
	@Id
	@GeneratedValue
	private int pageId;
	private String pageName;
	
	@ManyToOne
	@JoinColumn(name = "appId")
	private ApplicationDetails appDetails;
	
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public ApplicationDetails getAppDetails() {
		return appDetails;
	}
	public void setAppDetails(ApplicationDetails appDetails) {
		this.appDetails = appDetails;
	}
	

	
	
	

}
