package com.cts.testAutomation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.testAutomation.Repository.AppConfigRepository;
import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.model.AppConfigDataRequest;

@Repository
public class AppConfigDaoImpl implements AppConfigDao{
	
	@Autowired
	private AppConfigRepository appConfigRepository;
	
	@Autowired
	private EnvConfigRepository envConfigRepository;

	@Override
	public AppConfigDataRequest insertAppConfData(AppConfigDataRequest appConfDataRequest) {
		appConfDataRequest.setAppDetailsList(appConfigRepository.saveAll(appConfDataRequest.getAppDetailsList()));
		appConfDataRequest.setEnvDetailsList(envConfigRepository.saveAll(appConfDataRequest.getEnvDetailsList()));
		
		return appConfDataRequest;
	}

	

}
