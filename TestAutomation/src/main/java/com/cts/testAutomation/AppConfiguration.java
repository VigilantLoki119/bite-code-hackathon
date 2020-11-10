package com.cts.testAutomation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cts.testAutomation.Repository.AppConfigRepository;
import com.cts.testAutomation.Repository.AppDetailsDataRepository;
import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.Repository.EnvDetailsDataRepository;
import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;

@Configuration
public class AppConfiguration {
	
	private static List<ApplicationDetails> appDetailsList = new ArrayList<>();
	private static List<EnvDetails> envDetailsList = new ArrayList<>();
	
	@Autowired
	private AppConfigRepository appDetailsDataRepository;
	
	@Autowired
	private EnvConfigRepository envDetailsDataRepository;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public void setAppConfig() {
		
		appDetailsList = appDetailsDataRepository.findAll();
		envDetailsList = envDetailsDataRepository.findAll();
	}

	public static List<ApplicationDetails> getAppDetailsList() {
		return appDetailsList;
	}

	public static void setAppDetailsList(List<ApplicationDetails> appDetailsList) {
		AppConfiguration.appDetailsList = appDetailsList;
	}

	public static List<EnvDetails> getEnvDetailsList() {
		return envDetailsList;
	}

	public static void setEnvDetailsList(List<EnvDetails> envDetailsList) {
		AppConfiguration.envDetailsList = envDetailsList;
	}
	
	
}
