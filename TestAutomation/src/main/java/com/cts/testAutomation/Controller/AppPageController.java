package com.cts.testAutomation.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cts.testAutomation.AppConfiguration;
import com.cts.testAutomation.Repository.AppConfigRepository;
import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.cache.TestResultCache;
import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.dao.AppConfigDao;
import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.helper.AppPageHelper;
import com.cts.testAutomation.model.AppConfigDataRequest;
import com.cts.testAutomation.model.RunningTestCase;
import com.cts.testAutomation.model.TestCaseExecutionResponse;
import com.cts.testAutomation.model.TestCaseRunRequest;
import com.cts.testAutomation.model.TestCaseRunResponse;

@Controller
public class AppPageController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AppPageHelper helper;
	
	@Autowired
	private AppConfigDao appConfigDao;
	
	@Autowired
	private AppConfigRepository appConfigRepository;
	
	@Autowired
	private EnvConfigRepository envConfigRepository;
	
	@Autowired
	private TestResultCache testResultCache;
	
	@Value("${operationCatagory}")
	private String operationCatagory;

	
	@RequestMapping(value = {"/","/index"},  method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		List<ApplicationDetails> appDetailsList = appConfigRepository.findAll();
		List<EnvDetails> envDetailsList = envConfigRepository.findAll();
		
		model.addAttribute(TestCaseConstant.APP_DETAILS, appDetailsList);
		model.addAttribute(TestCaseConstant.ENV_DETAILS, envDetailsList);
		model.addAttribute("testCaseRunRequest", new TestCaseRunRequest());
		return "index";
	}

	
	@RequestMapping(value = "/result",  method = RequestMethod.POST)
	public String showResult(@ModelAttribute("testCaseRunRequest") TestCaseRunRequest testCaseRunRequest,ModelMap model) {
		
		if(null != testCaseRunRequest) {
			String[] testCaseKeyArr = testCaseRunRequest.getSelectedTestCaseName().split(TestCaseConstant.SPILLTER);
			testCaseRunRequest.setSelectedTestCaseId(Integer.parseInt(testCaseKeyArr[0]));
			testCaseRunRequest.setSelectedTestCaseName(testCaseKeyArr[1]);
			
			String[] appKeyArr = testCaseRunRequest.getSelectedApp().split(TestCaseConstant.SPILLTER);
			testCaseRunRequest.setSelectedAppId(Integer.parseInt(appKeyArr[0]));
			testCaseRunRequest.setSelectedApp(appKeyArr[1]);
			
			String[] pageKeyArr = testCaseRunRequest.getSelectedPage().split(TestCaseConstant.SPILLTER);
			testCaseRunRequest.setSelectedPageId(Integer.parseInt(pageKeyArr[0]));
			testCaseRunRequest.setSelectedPage(pageKeyArr[1]);
			
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
			String currentDateAndTime = LocalDateTime.now().format(dateFormatter); 
			testCaseRunRequest.setTestExecutionDate(currentDateAndTime);
			
			TestCaseRunResponse testCaseRunResponse = restTemplate.getForObject(TestCaseConstant.TEST_CASE_RUN_URL+testCaseRunRequest.getSelectedTestCaseId(), TestCaseRunResponse.class);
			RunningTestCase runningTestCase = new RunningTestCase();
			runningTestCase.setTestCaseRunRequest(testCaseRunRequest);
			runningTestCase.setTestCaseRunResponse(testCaseRunResponse);
			testResultCache.storerRunningTestCasesInCache("testResult",runningTestCase);
			List<RunningTestCase> runningTestCaseList = populateModel();
			model.addAttribute("runningTestCaseList",runningTestCaseList);
		}
		
		
		return "result";
	}
	
	private List<RunningTestCase> populateModel() {
		List<RunningTestCase> runningTestCaseList = testResultCache.getRunningTestCasesFromCache("testResult");
		if(null != runningTestCaseList){
			for(RunningTestCase runningTestCase : runningTestCaseList) {
				TestCaseRunResponse testCaseRunResponse = runningTestCase.getTestCaseRunResponse();
				String testCaseSessionId = testCaseRunResponse.getTestCaseSessionKey();
				if(!TestCaseConstant.SUCCESS.equalsIgnoreCase(testCaseRunResponse.getStatus())) {
				TestCaseExecutionResponse testCaseExecutionResponse = restTemplate.getForObject(TestCaseConstant.GET_RESULT_SERVICE_URL+testCaseSessionId, TestCaseExecutionResponse.class);
				testCaseRunResponse.setStatus(testCaseExecutionResponse.getFinalStatus());
				}
				runningTestCase.setTestCaseRunResponse(testCaseRunResponse);
			}
			
		}
		
		return runningTestCaseList;
	}


	@RequestMapping(value = "/result",  method = RequestMethod.GET)
	public String showResult_Get(ModelMap model) {
		List<RunningTestCase> runningTestCaseList = populateModel();
		model.addAttribute("runningTestCaseList",runningTestCaseList);
		return "result";
	}
	
	@RequestMapping(value = "/result/view/{testCaseSessionId}",  method = RequestMethod.GET)
	public String showResult(@PathVariable String testCaseSessionId,ModelMap model) {
		TestCaseExecutionResponse response = restTemplate.getForObject(TestCaseConstant.GET_RESULT_SERVICE_URL+testCaseSessionId, TestCaseExecutionResponse.class);
		model.addAttribute("testResultDetails", response);
		return "resultGridView";
	}
	
	@RequestMapping(value = "/configuration",  method = RequestMethod.GET)
	public String configureApplication() {
		return "configuration";
	}
	@RequestMapping(value = "/upload",  method = RequestMethod.POST)
	public String uploadFile(@RequestParam("appConfFilePath") String appConfFilePath,ModelMap model) {
	
		try {
			AppConfigDataRequest appConfigDataRequest = helper.populateAppConfData(appConfFilePath);
			appConfigDataRequest = appConfigDao.insertAppConfData(appConfigDataRequest);
		     if(null != appConfigDataRequest) {
		    	 model.addAttribute("uploadSuccessMsg","Application Configuration has been completed Successfully") ;
		     }
		} catch (Exception e) {
			System.out.println(e);
		}

		return "configuration";
	}
	
	@RequestMapping(value = "/create-testcase",  method = RequestMethod.GET)
	public String createTestCase(ModelMap model) {
		List<ApplicationDetails> appDetailsList = appConfigRepository.findAll();
		List<EnvDetails> envDetailsList = envConfigRepository.findAll();
		
		model.addAttribute(TestCaseConstant.APP_DETAILS, appDetailsList);
		model.addAttribute(TestCaseConstant.ENV_DETAILS, envDetailsList);
		
		String[] operationCatagoryArr = operationCatagory.split(",");
		
		model.addAttribute(TestCaseConstant.OPERATION_CATAGORY, operationCatagoryArr);
		
		return "createTestCase";
	}
	
}
