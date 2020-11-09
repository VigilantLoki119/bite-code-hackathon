package com.cts.qaAutomation.model;

public class HomeFormData {
	
	private String Application1;
	private String Functionality1;
	private String Environment1;
	private String URL1;
	private String userId1;
	private String pass1;
	private String Application2;
	private String Functionality2;
	private String Environment2;
	private String URL2;
	private String userId2;
	private String pass2;
	
	public HomeFormData() {
		super();
	}
	public HomeFormData(String application1, String functionality1, String environment1, String uRL1, String userId1,
			String pass1, String application2, String functionality2, String environment2, String uRL2, String userId2,
			String pass2) {
		super();
		Application1 = application1;
		Functionality1 = functionality1;
		Environment1 = environment1;
		URL1 = uRL1;
		this.userId1 = userId1;
		this.pass1 = pass1;
		Application2 = application2;
		Functionality2 = functionality2;
		Environment2 = environment2;
		URL2 = uRL2;
		this.userId2 = userId2;
		this.pass2 = pass2;
	}
	public String getApplication1() {
		return Application1;
	}
	public void setApplication1(String application1) {
		Application1 = application1;
	}
	public String getFunctionality1() {
		return Functionality1;
	}
	public void setFunctionality1(String functionality1) {
		Functionality1 = functionality1;
	}
	public String getEnvironment1() {
		return Environment1;
	}
	public void setEnvironment1(String environment1) {
		Environment1 = environment1;
	}
	public String getURL1() {
		return URL1;
	}
	public void setURL1(String uRL1) {
		URL1 = uRL1;
	}
	public String getUserId1() {
		return userId1;
	}
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	public String getPass1() {
		return pass1;
	}
	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}
	public String getApplication2() {
		return Application2;
	}
	public void setApplication2(String application2) {
		Application2 = application2;
	}
	public String getFunctionality2() {
		return Functionality2;
	}
	public void setFunctionality2(String functionality2) {
		Functionality2 = functionality2;
	}
	public String getEnvironment2() {
		return Environment2;
	}
	public void setEnvironment2(String environment2) {
		Environment2 = environment2;
	}
	public String getURL2() {
		return URL2;
	}
	public void setURL2(String uRL2) {
		URL2 = uRL2;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	
}
