package com.cts.testAutomation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EnvDetails {
	
	@Id
	@GeneratedValue
	private int envId;
	private String envName;
	private String envUrl;
	public int getEnvId() {
		return envId;
	}
	public void setEnvId(int envId) {
		this.envId = envId;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	public String getEnvUrl() {
		return envUrl;
	}
	public void setEnvUrl(String envUrl) {
		this.envUrl = envUrl;
	}
	
	
	

}
