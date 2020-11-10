package com.cts.testAutomation.model;

import java.util.List;

import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;

public class AppConfigDataRequest {
	
	private List<ApplicationDetails> appDetailsList;
	private List<EnvDetails> envDetailsList;
	public List<ApplicationDetails> getAppDetailsList() {
		return appDetailsList;
	}
	public void setAppDetailsList(List<ApplicationDetails> appDetailsList) {
		this.appDetailsList = appDetailsList;
	}
	public List<EnvDetails> getEnvDetailsList() {
		return envDetailsList;
	}
	public void setEnvDetailsList(List<EnvDetails> envDetailsList) {
		this.envDetailsList = envDetailsList;
	}
	
	

}
