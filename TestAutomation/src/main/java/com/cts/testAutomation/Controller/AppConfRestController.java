package com.cts.testAutomation.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.testAutomation.Repository.AppConfigRepository;
import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.Repository.TestCaseRepository;
import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.entity.PageDetails;
import com.cts.testAutomation.entity.TestCase;
import com.cts.testAutomation.entity.TestCaseXpath;
import com.cts.testAutomation.model.AppPage;
import com.cts.testAutomation.model.CreateTestCaseRequest;
import com.cts.testAutomation.model.CreateTestCaseResponse;
import com.cts.testAutomation.model.PageDetailsResponse;
import com.cts.testAutomation.model.TestCaseDetails;
import com.cts.testAutomation.model.TestCaseStep;
import com.cts.testAutomation.model.TestCasesResponse;

@RestController
@RequestMapping("/app/conf")
public class AppConfRestController {

	@Autowired
	private AppConfigRepository appConfigRepository;
	
	@Autowired
	private EnvConfigRepository envConfigRepository;
	
	@Autowired
	private TestCaseRepository testCasesRepository;
	
	
	
	
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
		List<TestCase> testCasesList = testCasesRepository.findByAppIdAndPageId(appId, pageId);
		TestCasesResponse response = new TestCasesResponse();
		if(null != testCasesList) {
		List<TestCaseDetails> list = new ArrayList<>();
			for(TestCase testCase : testCasesList) {
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
	
	@RequestMapping(value = "/submit-testcase",  method = RequestMethod.POST)
	public CreateTestCaseResponse createTestCase(@RequestBody CreateTestCaseRequest request) {
		CreateTestCaseResponse response = new CreateTestCaseResponse();
		TestCase testCase = null;
		
		if(null != request) {
			testCase = new TestCase();
			testCase.setAppId(request.getAppId());
			testCase.setPageId(request.getPageId());
			testCase.setTestCaseName(request.getTestCaseName());
			List<TestCaseXpath> testCaseXpathList = new ArrayList<>();
			List<TestCaseStep> testCaseSteps = request.getTestCaseSteps();
			if(null != testCaseSteps) {
				for(TestCaseStep  testStep : testCaseSteps) {
					TestCaseXpath testCaseXpath = new TestCaseXpath();
					testCaseXpath.setTestStepName(testStep.getName_teststep());
					testCaseXpath.setTestCaseXpathStr(testStep.getXpathSite1_teststep());
					testCaseXpath.setOperationName(testStep.getOperationSite1_teststep());
					testCaseXpath.setInputData(testStep.getTestDataSite1_teststep());
					testCaseXpath.setSiteName("site1");
					testCaseXpath.setEnvId(request.getEnvIdSite1());
					testCaseXpath.setTestCase(testCase);
					testCaseXpathList.add(testCaseXpath);
					
					testCaseXpath = new TestCaseXpath();
					testCaseXpath.setTestStepName(testStep.getName_teststep());
					testCaseXpath.setTestCaseXpathStr(testStep.getXpathSite2_teststep());
					testCaseXpath.setOperationName(testStep.getOperationSite2_teststep());
					testCaseXpath.setInputData(testStep.getTestDataSite2_teststep());
					testCaseXpath.setSiteName("site2");
					testCaseXpath.setEnvId(request.getEnvIdSite2());
					testCaseXpath.setTestCase(testCase);
					testCaseXpathList.add(testCaseXpath);
					
				}

				testCase.setTestCaseXpathList(testCaseXpathList);
				
				
				testCase = testCasesRepository.save(testCase);
			}
			
		}
		
		if(testCase != null) {
			response.setStatus(TestCaseConstant.SUCCESS);
			response.setMsg("TestCase : " + testCase.getTestCaseName() +"(" + testCase.getTestCaseId()+") has been created successfully.");
			response.setTestCaseId(testCase.getTestCaseId());
			response.setTestCaseName(testCase.getTestCaseName());
		}
		
		
		return response;
	}
	
}
