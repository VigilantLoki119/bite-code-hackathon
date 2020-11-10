package com.cts.testAutomation.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cts.testAutomation.AppConfiguration;
import com.cts.testAutomation.Repository.AppDetailsDataRepository;
import com.cts.testAutomation.Repository.EnvDetailsDataRepository;
import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.dao.AppConfigDao;
import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.helper.AppPageHelper;
import com.cts.testAutomation.model.AppConfigDataRequest;
import com.cts.testAutomation.model.TestCaseExecutionResponse;

@Controller
public class AppPageController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AppPageHelper helper;
	
	@Autowired
	private AppConfigDao appConfigDao;
	
	
	

	@RequestMapping(value = {"/","/index"},  method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		List<ApplicationDetails> appDetailsList = AppConfiguration.getAppDetailsList();
		List<EnvDetails> envDetailsList = AppConfiguration.getEnvDetailsList();
		
		model.addAttribute(TestCaseConstant.PAGE_DETAILS, appDetailsList);
		model.addAttribute(TestCaseConstant.ENV_DETAILS, envDetailsList);
		return "index";
	}
	
	
	@RequestMapping(value = "/result/{testCaseSessionId}",  method = RequestMethod.GET)
	public String showResult(@PathVariable String testCaseSessionId,ModelMap model) {
		TestCaseExecutionResponse response = restTemplate.getForObject(TestCaseConstant.GET_RESULT_SERVICE_URL+testCaseSessionId, TestCaseExecutionResponse.class);
		model.addAttribute("testResultDetails", response);
		return "result";
	}
	
	@RequestMapping(value = "/configuration",  method = RequestMethod.GET)
	public String configureApplication() {
		return "configuration";
	}
	@RequestMapping(value = "/upload",  method = RequestMethod.POST)
	public String uploadFile(@RequestParam("appConfFilePath") String appConfFilePath) {
		String status = null;
		try {
			AppConfigDataRequest appConfigDataRequest = helper.populateAppConfData(appConfFilePath);
			appConfigDataRequest = appConfigDao.insertAppConfData(appConfigDataRequest);
			AppConfiguration.setAppDetailsList(appConfigDataRequest.getAppDetailsList());
			AppConfiguration.setEnvDetailsList(appConfigDataRequest.getEnvDetailsList());
		} catch (Exception e) {
			System.out.println(e);
		}

		return "uploadConfirm";
	}
}
