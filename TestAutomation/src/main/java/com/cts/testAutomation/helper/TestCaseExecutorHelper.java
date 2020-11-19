    package com.cts.testAutomation.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.testAutomation.Repository.EnvConfigRepository;
import com.cts.testAutomation.Repository.TestCaseRepository;
import com.cts.testAutomation.cache.TestResultCache;
import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.entity.TestCase;
import com.cts.testAutomation.entity.TestCaseXpath;
import com.cts.testAutomation.model.TestCaseExecutionResponse;
import com.cts.testAutomation.model.TestCaseExecutorRequest;
import com.cts.testAutomation.model.TestCaseRunResponse;
import com.cts.testAutomation.model.TestItem;
import com.cts.testAutomation.model.TestResultDetails;
import com.cts.testAutomation.model.TestResultWithStatus;


@Component
public class TestCaseExecutorHelper {
	

	
	@Autowired
	private TaskExecutorHelper taskHelper;
	
	@Autowired
	private TestResultCache testResultCache;
	
	@Autowired
	private TestCaseRepository testCaseRepository;
	
	@Autowired
	private EnvConfigRepository envConfigRepository;
	

	public TestCaseRunResponse runTest(int testCaseId) {
		TestCaseRunResponse response = new TestCaseRunResponse();
		response.setStatus(TestCaseConstant.RUNNING);
		try {
		TestCase testCaseDetails = testCaseRepository.findByTestCaseId(testCaseId);
			if(null !=testCaseDetails) {
				response.setTestCaseId(Integer.toString(testCaseId));
				response.setTestCaseName(testCaseDetails.getTestCaseName());
				long sessionId = System.currentTimeMillis();
				response.setSessionId(sessionId);
				response.setTestCaseSessionKey(testCaseDetails.getTestCaseName()+"_"+sessionId);
				
				List<TestCaseXpath> testCaseXpathList = testCaseDetails.getTestCaseXpathList();
				if(null != testCaseXpathList) {
					Map<String, TestCaseXpath> xpathMapSite1 = new LinkedHashMap<>();
					Map<String, TestCaseXpath> xpathMapSite2 = new LinkedHashMap<>();
					for(TestCaseXpath xpath : testCaseXpathList) {
						  if(TestCaseConstant.SITE_1.equalsIgnoreCase(xpath.getSiteName())) {
							  xpathMapSite1.put(xpath.getTestStepName(), xpath);
						  }else if(TestCaseConstant.SITE_2.equalsIgnoreCase(xpath.getSiteName())) {
							  xpathMapSite2.put(xpath.getTestStepName(), xpath);
						  }
					}
					
					TestCaseExecutorTask taskForSite1 = populateTaskExecutor(xpathMapSite1,response);
					TestCaseExecutorTask taskForSite2 = populateTaskExecutor(xpathMapSite2,response);
					ExecutorService pool = Executors.newFixedThreadPool(TestCaseConstant.THREAD_COUNT);
					pool.execute(taskForSite1); 
			        pool.execute(taskForSite2); 
			        pool.shutdown();  
					
				}
				
			}
		}catch(Exception exp) {
			response.setStatus(TestCaseConstant.FAIL);
		}
		
		
		return response;
		
	}
	

	private TestCaseExecutorTask populateTaskExecutor(Map<String, TestCaseXpath> xpathMap,TestCaseRunResponse response) {
		TestCaseXpath xpath= null;
		 for (Map.Entry<String, TestCaseXpath> mapElement : xpathMap.entrySet()) { 
			  xpath = mapElement.getValue(); 
			  break;
		 }
	  
		EnvDetails envDetails =  envConfigRepository.findByEnvId(xpath.getEnvId());		
		
		TestCaseExecutorRequest requestForSite = new TestCaseExecutorRequest();
		requestForSite.setTestCaseSessionKey(response.getTestCaseSessionKey());
		requestForSite.setSiteName(xpath.getSiteName());
		requestForSite.setTestCaseName(response.getTestCaseName());
		requestForSite.setUrl(envDetails.getEnvUrl());
		requestForSite.setXpathMap(xpathMap);
		
		TestCaseExecutorTask taskForSite = new TestCaseExecutorTask();
		taskForSite.populateTaskParameter(requestForSite,taskHelper);
		
		return taskForSite;
		
	}


	public TestCaseRunResponse runTest(String testCaseName,String url) {
		TestCaseRunResponse response = new TestCaseRunResponse();
		try {
		long sessionId = System.currentTimeMillis();
		String testCaseSessionKey = "WOW|LISTVIEWSEARCH|ALL"+"_"+sessionId;
		
		response.setSessionId(sessionId);
		response.setTestCaseId("WOW|LISTVIEWSEARCH|ALL");
		response.setTestCaseSessionKey(testCaseSessionKey);
		
		TestCaseExecutorTask taskForSite1 = new TestCaseExecutorTask();
		TestCaseExecutorRequest requestForSite1 = new TestCaseExecutorRequest();
		requestForSite1.setTestCaseSessionKey(testCaseSessionKey);
		requestForSite1.setSiteName("OldSite");
		requestForSite1.setTestCaseName(testCaseName);
		requestForSite1.setUrl(url);
		taskForSite1.populateTaskParameter(requestForSite1,taskHelper);

		TestCaseExecutorTask taskForSite2 = new TestCaseExecutorTask();
		TestCaseExecutorRequest requestForSite2 = new TestCaseExecutorRequest();
		requestForSite2.setTestCaseSessionKey(testCaseSessionKey);
		requestForSite2.setSiteName("NewSite");
		requestForSite2.setTestCaseName(testCaseName);
		requestForSite2.setUrl(url);
		taskForSite2.populateTaskParameter(requestForSite2,taskHelper);
		
		ExecutorService pool = Executors.newFixedThreadPool(TestCaseConstant.THREAD_COUNT);
		pool.execute(taskForSite1); 
        pool.execute(taskForSite2); 
        pool.shutdown();   
		 
		}catch(Exception exp) {
			response.setStatus(TestCaseConstant.FAIL);
		}
		
		response.setStatus(TestCaseConstant.RUNNING);
		return response;
		
	}



	public TestCaseExecutionResponse getTestCaseExecutionResult(String testCaseSessionKey) {
		TestCaseExecutionResponse response = testResultCache.getFinalTestResultFromCache(testCaseSessionKey);
		
		if(null != response) {
			return response;
		}
		response = new TestCaseExecutionResponse();
		List<TestResultWithStatus> testResultWithStatusList = null;
		TestResultWithStatus testResultWithStatus = null;
		List<String> remarks = null;
		
		List<TestResultDetails> testResultList = null;
		TestResultDetails  testResultOldSite = null;
		TestResultDetails  testResultNewSite = null;
		try {
		testResultList = testResultCache.getTestResultFromCache(testCaseSessionKey);
		if(null != testResultList && testResultList.size() == 2) {
			
			testResultWithStatusList = new ArrayList<>();
			
			if(TestCaseConstant.SITE_1.equalsIgnoreCase(testResultList.get(0).getSiteName())){
				testResultOldSite = testResultList.get(0);
				testResultNewSite = testResultList.get(1);
				
			}else{
				testResultOldSite = testResultList.get(1);
				testResultNewSite = testResultList.get(0);
			}
			
			Iterator<TestItem> iterOldSiteIter = testResultOldSite.getTestResults().iterator();
			Iterator<TestItem> iterNewSiteIter = testResultNewSite.getTestResults().iterator();
			
			while(iterNewSiteIter.hasNext()) {
				
				TestItem testItemNew = iterNewSiteIter.next();
				testResultWithStatus = new TestResultWithStatus();
				remarks = new ArrayList<>();
				
				if(testResultOldSite.getTestResults().size() == 0) {
					testResultWithStatus.setTestItemActual(testItemNew);
					remarks.add("Data not availabe in Old site");
					testResultWithStatus.setRemarks(remarks);
					testResultWithStatus.setStatus(TestCaseConstant.FAIL);
					}else {
						boolean dataAvailabeInOldSite = false;
						while(iterOldSiteIter.hasNext()) {
							TestItem testItemOld = iterOldSiteIter.next();
							
							 
							if(testItemOld.getItemName().equals(testItemNew.getItemName())) {
								dataAvailabeInOldSite = true;
								
								testResultWithStatus.setTestItemActual(testItemNew);
								testResultWithStatus.setTestItemExpected(testItemOld);
								
								List<String> itemValuesOld = testItemOld.getValues();
								List<String> itemValuesNew = testItemNew.getValues();
								
								if(null != itemValuesOld && null != itemValuesNew) {
									
									compareItemValues(itemValuesOld,itemValuesNew,remarks,testResultWithStatus);
									
								}else if(null == itemValuesOld && null != itemValuesNew){
									remarks.add("Data doesn't availabe in Old Site");
									testResultWithStatus.setRemarks(remarks);	
									testResultWithStatus.setStatus(TestCaseConstant.FAIL);
								}else if(null != itemValuesOld && null == itemValuesNew) {
									remarks.add("Data doesn't availabe in New Site");
									testResultWithStatus.setRemarks(remarks);	
									testResultWithStatus.setStatus(TestCaseConstant.FAIL);
								}else {
									testResultWithStatus.setStatus(TestCaseConstant.SUCCESS);
								}
								
								iterOldSiteIter.remove();
								iterNewSiteIter.remove();
								break;
							}
							
						}
						
						if(!dataAvailabeInOldSite) {
							testResultWithStatus.setTestItemActual(testItemNew);
							remarks.add("Data doesn't availabe in Old site");
							testResultWithStatus.setRemarks(remarks);
							testResultWithStatus.setStatus(TestCaseConstant.FAIL);	
						}
					
				}
				if(TestCaseConstant.FAIL.equalsIgnoreCase(testResultWithStatus.getStatus())) {
					response.setFinalStatus(testResultWithStatus.getStatus());
				}
				testResultWithStatusList.add(testResultWithStatus);
			}
			
			while(iterOldSiteIter.hasNext()) {
				TestItem testItemOld = iterOldSiteIter.next();
				testResultWithStatus = new TestResultWithStatus();
				testResultWithStatus.setTestItemExpected(testItemOld);
				remarks = new ArrayList<>();
				remarks.add("Data doesn't availabe in New site");
				testResultWithStatus.setRemarks(remarks);
				testResultWithStatus.setStatus(TestCaseConstant.FAIL);
				testResultWithStatusList.add(testResultWithStatus);	
				response.setFinalStatus(TestCaseConstant.FAIL);
			}
			
			if(!TestCaseConstant.FAIL.equalsIgnoreCase(testResultWithStatus.getStatus())) {
				response.setFinalStatus(TestCaseConstant.SUCCESS);
			}
			response.setTestResultWithStatusList(testResultWithStatusList);
			testResultCache.storeFinalTestResultInCache(testCaseSessionKey, response);
			testResultCache.clearTestResultFromCache(testCaseSessionKey);
			
		}else {
			response.setFinalStatus(TestCaseConstant.RUNNING);
		}
		}catch(Exception exp) {
			response.setFinalStatus(TestCaseConstant.ERROR);
		}

		
		return response;
	}



	private void compareItemValues(List<String> itemValuesOld, List<String> itemValuesNew, List<String> remarks, TestResultWithStatus testResultWithStatus) {
		
		for(String valueNew : itemValuesNew) {
			if(itemValuesOld.contains(valueNew)) {
				
				//itemValuesOld.remove(valueNew);
			}else {
				remarks.add("Data '"+ valueNew +"' not availabe in New Site");	
				testResultWithStatus.setStatus(TestCaseConstant.FAIL);
			}
		}
		
		
			for(String valueOld : itemValuesOld) {
				if(!itemValuesNew.contains(valueOld)) {
				remarks.add("Data '"+ valueOld +"' not availabe in Old Site");
				testResultWithStatus.setStatus(TestCaseConstant.FAIL);
				}
			}
		
		
		if(testResultWithStatus.getStatus() == null || !testResultWithStatus.getStatus().equalsIgnoreCase(TestCaseConstant.FAIL)) {
			testResultWithStatus.setStatus(TestCaseConstant.SUCCESS);
		}
		
		testResultWithStatus.setRemarks(remarks);
		
	}



	
}
