package com.cts.testAutomation.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

import com.cts.testAutomation.model.RunningTestCase;
import com.cts.testAutomation.model.TestCaseExecutionResponse;
import com.cts.testAutomation.model.TestResultDetails;

@Configuration
public class TestResultCache  {

	private static Map<String, List<TestResultDetails>> cachedTestResultMap = new ConcurrentHashMap<>();
	private static Map<String, TestCaseExecutionResponse> cachedFinalTestResultMap = new ConcurrentHashMap<>();
	private static Map<String, List<RunningTestCase>> runningTestCasesMap = new ConcurrentHashMap<>(); 
	
	@Cacheable(value = "runningTestCasesCache")
	public List<RunningTestCase> getRunningTestCasesFromCache(String key) {
		List<RunningTestCase> runningTestCaseList = null;
		try {
			runningTestCaseList = runningTestCasesMap.get(key);
		} catch (Exception exp) {

		}
		return runningTestCaseList;
	}

	@CachePut(value = "runningTestCasesCache")
	public void storerRunningTestCasesInCache(String key, RunningTestCase runningTestCase) {
		try {
			
			List<RunningTestCase> runningTestCasesList = runningTestCasesMap.get(key);
			if(runningTestCasesList == null) {
				runningTestCasesList = new ArrayList<>();
				runningTestCasesList.add(runningTestCase);
				runningTestCasesMap.put(key, runningTestCasesList);
			}else {
				runningTestCasesList.add(runningTestCase);
				runningTestCasesMap.put(key, runningTestCasesList);
			}
		} catch (Exception exp) {

		}
	}
	@Cacheable(value = "testResultCache")
	public List<TestResultDetails> getTestResultFromCache(String testCaseSessionKey) {
		List<TestResultDetails> testResultList = null;
		try {
			testResultList = cachedTestResultMap.get(testCaseSessionKey);
		} catch (Exception exp) {

		}
		return testResultList;
	}
	
	@Cacheable(value = "testResultCache")
	public TestCaseExecutionResponse getFinalTestResultFromCache(String testCaseSessionKey) {
		TestCaseExecutionResponse finalTestResult = null;
		try {
			finalTestResult = cachedFinalTestResultMap.get(testCaseSessionKey);
		} catch (Exception exp) {

		}
		return finalTestResult;
	}

	@CachePut(value = "testResultCache")
	public void storeTestResultInCache(String testCaseSessionKey, TestResultDetails testResult) {
		List<TestResultDetails> testResultList = null;
		try {
			testResultList = cachedTestResultMap.get(testCaseSessionKey);
			if(testResultList == null) {
				testResultList = new ArrayList<>();
				testResultList.add(testResult);
				cachedTestResultMap.put(testCaseSessionKey, testResultList);
			}else {
				testResultList.add(testResult);
				cachedTestResultMap.put(testCaseSessionKey, testResultList);
			}
		} catch (Exception exp) {

		}
	}
	
	@CachePut(value = "testResultCache")
	public void storeFinalTestResultInCache(String testCaseSessionKey, TestCaseExecutionResponse response) {
		try {
			cachedFinalTestResultMap.put(testCaseSessionKey, response);
		} catch (Exception exp) {

		}
	}
	

	@CacheEvict(value = "testResultCache" , key="#testCaseSessionKey")
	public void clearTestResultFromCache(String testCaseSessionKey) {
		try {
				cachedTestResultMap.remove(testCaseSessionKey);
		} catch (Exception exp) {

		}

	}
	@CacheEvict(value = "testResultCache" , key="#testCaseSessionKey")
	public void clearFinalTestResultFromCache(String testCaseSessionKey) {
		try {
			cachedFinalTestResultMap.remove(testCaseSessionKey);
		} catch (Exception exp) {

		}

	}

}

