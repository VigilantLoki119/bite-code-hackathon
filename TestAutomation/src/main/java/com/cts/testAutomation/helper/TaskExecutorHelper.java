package com.cts.testAutomation.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.testAutomation.cache.TestResultCache;
import com.cts.testAutomation.constant.TestCaseConstant;
import com.cts.testAutomation.entity.TestCaseXpath;
import com.cts.testAutomation.model.TestCaseExecutorRequest;
import com.cts.testAutomation.model.TestItem;
import com.cts.testAutomation.model.TestResultDetails;

@Component
public class TaskExecutorHelper {
	
	@Autowired
	private DriverConfigurationHelper driverConfigurationHelper;
	
	@Autowired
	private TestResultCache testResultCache;
	
	public void executeTest(TestCaseExecutorRequest request) {
		
		WebDriver driver = driverConfigurationHelper.getDriver(request.getUrl());
		
		TestResultDetails testResultDetails = new TestResultDetails();
		 List<TestItem> testResults = new ArrayList<>();
		
		Map<String,TestCaseXpath> xpathMap = request.getXpathMap();
		
		Set<String>  xpathMapKey= xpathMap.keySet();
		for(String key : xpathMapKey) {
			TestCaseXpath xpath = xpathMap.get(key);
			
			TestItem testItem = new TestItem();
			List<String> values=null;
			try {
			if(TestCaseConstant.CLICK.equalsIgnoreCase(xpath.getOperationName())) {
				driver.findElement(By.xpath(xpath.getTestCaseXpathStr().trim())).click();
				waitforNextOperation();	
			}else if(TestCaseConstant.CHECK_VALUE.equalsIgnoreCase(xpath.getOperationName())) {
				List<WebElement> elements = driver.findElements(By.xpath(xpath.getTestCaseXpathStr().trim()));
				values = new ArrayList<>();
				for(WebElement element : elements) {
					values.add(element.getText());
				}
				
			}else if(TestCaseConstant.INPUT_DATA.equalsIgnoreCase(xpath.getOperationName())) {
				driver.findElement(By.xpath(xpath.getTestCaseXpathStr())).sendKeys(xpath.getInputData().trim());
				
			}
			}catch(Exception exp){
				testItem.setXpathForException(xpath.getTestCaseXpathStr());
			}
			
			testItem.setItemName(xpath.getTestStepName());
			testItem.setValues(values);
			testResults.add(testItem);
			
		}
		
		testResultDetails.setTestCaseSessionKey(request.getTestCaseSessionKey());
		testResultDetails.setSiteName(request.getSiteName());
		testResultDetails.setTestCaseName(request.getSiteName());
		testResultDetails.setTestResults(testResults);
		testResultDetails.setExecutionStatus(TestCaseConstant.SUCCESS);
		testResultCache.storeTestResultInCache(request.getTestCaseSessionKey(), testResultDetails);
		driver.quit();
	
	}
	
	

	private static void waitforNextOperation() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
