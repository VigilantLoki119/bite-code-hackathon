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
public class ApplicationDetails {
	@Id
	@GeneratedValue
	private int appId;
	private String appName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="page_record_details",joinColumns = {@JoinColumn(name="appId")},inverseJoinColumns = {@JoinColumn(name="pageId")})
	private List<PageDetails> pageDetails;
	
	
	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public List<PageDetails> getPageDetails() {
		return pageDetails;
	}
	public void setPageDetails(List<PageDetails> pageDetails) {
		this.pageDetails = pageDetails;
	}
	
	

}
