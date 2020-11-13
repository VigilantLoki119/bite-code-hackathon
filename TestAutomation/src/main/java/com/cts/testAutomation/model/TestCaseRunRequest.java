package com.cts.testAutomation.model;

public class TestCaseRunRequest {
	
	private String selectedApp;
	private String selectedPage;
	private String selectedEnvSite1;
	private String selectedUrlSite1;
	private String selectedEnvSite2;
	private String selectedUrlSite2;
	private boolean loginCredRequired;
	private String username;
	private String password;
	private String selectedTestCaseSite1;
	private String selectedTestCaseSite2;
	public String getSelectedApp() {
		return selectedApp;
	}
	public void setSelectedApp(String selectedApp) {
		this.selectedApp = selectedApp;
	}
	public String getSelectedPage() {
		return selectedPage;
	}
	public void setSelectedPage(String selectedPage) {
		this.selectedPage = selectedPage;
	}
	
	public String getSelectedEnvSite1() {
		return selectedEnvSite1;
	}
	public void setSelectedEnvSite1(String selectedEnvSite1) {
		this.selectedEnvSite1 = selectedEnvSite1;
	}
	public String getSelectedUrlSite1() {
		return selectedUrlSite1;
	}
	public void setSelectedUrlSite1(String selectedUrlSite1) {
		this.selectedUrlSite1 = selectedUrlSite1;
	}
	public String getSelectedEnvSite2() {
		return selectedEnvSite2;
	}
	public void setSelectedEnvSite2(String selectedEnvSite2) {
		this.selectedEnvSite2 = selectedEnvSite2;
	}
	public String getSelectedUrlSite2() {
		return selectedUrlSite2;
	}
	public void setSelectedUrlSite2(String selectedUrlSite2) {
		this.selectedUrlSite2 = selectedUrlSite2;
	}
	public boolean isLoginCredRequired() {
		return loginCredRequired;
	}
	public void setLoginCredRequired(boolean loginCredRequired) {
		this.loginCredRequired = loginCredRequired;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getselectedTestCaseSite1() {
		return selectedTestCaseSite1;
	}
	public void setselectedTestCaseSite1(String selectedTestCaseSite1) {
		this.selectedTestCaseSite1 = selectedTestCaseSite1;
	}
	public String getSelectedTestCaseSite2() {
		return selectedTestCaseSite2;
	}
	public void setSelectedTestCaseSite2(String selectedTestCaseSite2) {
		this.selectedTestCaseSite2 = selectedTestCaseSite2;
	}
	
	

}
