package com.cts.qaAutomation.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.qaAutomation.model.TestItem;
import com.cts.qaAutomation.model.TestResultDetails;


@Component
public class TestCaseExecutionHelper {
	
	@Autowired
	private DriverConfigurationHelper driverConfigurationHelper;
	
	//@Autowired
	//private WebDriver driver;
	

	public TestResultDetails executeTest(String testCaseName,String url) {
		
		WebDriver driver = driverConfigurationHelper.getDriver(url);
		TestResultDetails testResultDetails = new TestResultDetails();
		
		 List<TestItem> testResults = new ArrayList<>();
		 TestItem testItem = null;
		 List<String> values = null;
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("moortest");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("resort1");
		driver.findElement(By.xpath("//button[@id='rciSignInBtn']")).click();
		
		waitforNextOperation();
		//Dashboard Page
		//Alert alertCancel = driver.switchTo().alert();
		//alertCancel.dismiss();
		driver.findElement(By.xpath("//a[@id='book-collapsible-toggle']")).click();
		waitforNextOperation();
		
		driver.findElement(By.xpath("//a[@title='All Vacations']")).click();
		waitforNextOperation();
		
		
		/* Region name starts*/
		
			driver.findElement(By.xpath("//button[@id='showMore']")).click();
			
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='search-results-information-regions-more']//ul//li//a"));
			
			values = new ArrayList<>();
			
			for(WebElement element : elements) {
				values.add(element.getText());
			}
			testItem = new TestItem();
			testItem.setItemName("Region Details");
			testItem.setValues(values);
			testResults.add(testItem);
	/* Region name ends*/
		
		/* filter dimension name ends*/
	
	
		WebElement webElement = driver.findElement(By.xpath("//div[@id='heading-1-heading']/h4"));
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader1']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-2-heading']/h4")); 
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader2']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-3-heading']/h4")); 
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader3']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-4-heading']/h4")); 
		testItem.setItemName(webElement.getText());

		
		webElement = driver.findElement(By.xpath("//div[@id='heading-5-heading']/h4")); 
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader5']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
	
		driver.findElement(By.xpath("//button[@id='view-advanced-filters-button']")).click();
		waitforNextOperation();
		
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-6-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader6']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-7-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader7']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-8-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader8']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-9-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader9']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-10-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader10']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		
		webElement = driver.findElement(By.xpath("//div[@id='heading-11-heading']")); 
		webElement.click();
		waitforNextOperation();
		elements = driver.findElements(By.xpath("//ul[@id='panelHeader11']//li"));
		values = new ArrayList<>();
		for(WebElement element : elements) {
			values.add(element.getText());
		}
		testItem = new TestItem();
		testItem.setItemName(webElement.getText());
		testItem.setValues(values);
		testResults.add(testItem);
		/* filter dimension name ends*/
		

		elements = driver.findElements(By.xpath("//div[@id='srchResultList1']//section"));
		
		for(int i =1; i<=elements.size() ; i++) {

			String st = "//div[@id='srchResultList1']//section["+i+"]";
			values = new ArrayList<>();
			
			try {
				values.add(driver.findElement(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/header/h1/p")).getText());
			}catch(Exception exp) {
				System.out.println("Exp12");
			}
			
			try {
				values.add(driver.findElement(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/header/h1/a")).getText());
				}catch(Exception exp) {
					System.out.println("Exp11");
				}
				
			
			try {
				values.add(driver.findElement(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/div[1]/a")).getText());
		}catch(Exception exp) {
			System.out.println("Exp13");
		}
			
			try {
			List<WebElement> elements_sub = driver.findElements(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/ul/li"));
			for(WebElement webElement3 : elements_sub) {
				values.add(webElement3.getText());
			}
		}catch(Exception exp) {
			System.out.println("Exp14");
		}
			
			/*try {
				//values.add(driver.findElement(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/div[2]/a")).getText());
		}catch(Exception exp) {System.out.println("Exp15");}*/
			
			try {
				List<WebElement> elements_sub = driver.findElements(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/p"));
			 for(WebElement webElement3 : elements_sub) {
				 values.add(webElement3.getText());
				}
		 }catch(Exception exp) {System.out.println("Exp16");}
			
			try {
				values.add(driver.findElement(By.xpath(st+"/div/div[@class='col-sm-7 col-xs-12 search-result-right']/footer/div[2]/a")).getText());
		 }catch(Exception exp) {System.out.println("Exp17");}
			
			testItem = new TestItem();
			testItem.setItemName("ResortSummary"+i);
			testItem.setValues(values);
			testResults.add(testItem);
		}
		
		testResultDetails.setTestCaseName(testCaseName);
		testResultDetails.setTestResults(testResults);
		testResultDetails.setExecutionStatus("success");
		
		driver.quit();
		
		return testResultDetails;
		
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
