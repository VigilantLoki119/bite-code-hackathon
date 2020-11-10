package com.cts.testAutomation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.dao.AppConfigDao;
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
	public String getIndex() {
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
			status = appConfigDao.insertAppConfData(appConfigDataRequest);
		} catch (Exception e) {
			
		}

		return "uploadConfirm";
	}
}
