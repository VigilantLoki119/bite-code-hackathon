package com.cts.testAutomation.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.testAutomation.Repository.AppConfigRepository;
import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.Repository.TestCasesRepository;
import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.entity.PageDetails;
import com.cts.testAutomation.entity.TestCases;
import com.cts.testAutomation.model.AppPage;
import com.cts.testAutomation.model.PageDetailsResponse;
import com.cts.testAutomation.model.TestCaseDetails;
import com.cts.testAutomation.model.TestCasesResponse;

@RestController
@RequestMapping("/app/conf")
public class AppConfRestController {

	@Autowired
	private AppConfigRepository appConfigRepository;
	
	@Autowired
	private EnvConfigRepository envConfigRepository;
	
	@Autowired
	private TestCasesRepository testCasesRepository;
	
	
	@GetMapping("/page/details/{appId}")
	public PageDetailsResponse getPageDetails(@PathVariable int appId) {
		ApplicationDetails appDetails = appConfigRepository.findByAppId(appId);
		
		PageDetailsResponse response = new PageDetailsResponse();
		if(null != appDetails) {
		List<AppPage> appPages = new ArrayList<>();
		for(PageDetails pageDetails : appDetails.getPageDetails()) {
			AppPage appPage = new AppPage();
			appPage.setPageId(pageDetails.getPageId());
			appPage.setPageName(pageDetails.getPageName());
			appPages.add(appPage);
		}
		response.setAppId(appId);
		response.setAppPages(appPages);
		}
		return response;
	}
	
	@GetMapping("/env/url/{envId}")
	public String getEnvUrl(@PathVariable int envId) {
		EnvDetails envDetails = envConfigRepository.findByEnvId(envId);
		if(null != envDetails) {
		return envDetails.getEnvUrl();
		}
		
		return "";
		
	}
	
	@GetMapping("/testcase/{appId}/{pageId}")
	public TestCasesResponse getAvailabeTestCases(@PathVariable int appId,@PathVariable int pageId) {
		List<TestCases> testCasesList = testCasesRepository.findByAppIdAndPageId(appId, pageId);
		TestCasesResponse response = new TestCasesResponse();
		if(null != testCasesList) {
		List<TestCaseDetails> list = new ArrayList<>();
			for(TestCases testCase : testCasesList) {
				TestCaseDetails testCaseDetails = new TestCaseDetails();
				testCaseDetails.setTestCaseId(testCase.getTestCaseId());
				testCaseDetails.setTestCaseName(testCase.getTestCaseName());
				list.add(testCaseDetails);
			}
			response.setTestCases(list);
			response.setAppId(appId);
			response.setPageId(pageId);
		}
		
		return response;
		
	}
	
}
