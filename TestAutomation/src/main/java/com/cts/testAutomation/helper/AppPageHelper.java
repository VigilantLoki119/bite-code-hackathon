package com.cts.testAutomation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.cts.testAutomation.entity.ApplicationDetails;
import com.cts.testAutomation.entity.EnvDetails;
import com.cts.testAutomation.entity.PageDetails;
import com.cts.testAutomation.model.AppConfigDataRequest;

@Component
public class AppPageHelper {

	public AppConfigDataRequest populateAppConfData(String filePath) throws IOException {
		
		AppConfigDataRequest request = new AppConfigDataRequest();
		
		File file =    new File(filePath);
	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook Workbook = null;
	    //D:\hackathan\applicationDetails.xl
	 

	    if(filePath.contains(".xlsx")){
	    	Workbook = new XSSFWorkbook(inputStream);
	    }else if(filePath.equals(".xls")){
	    	Workbook = new HSSFWorkbook(inputStream);
	    }

		Map<String,List<PageDetails>> pageDetailsMap  = populatePageDetailsMap(Workbook.getSheetAt(0));
	    Set<String> appKeys = pageDetailsMap.keySet();
		List<ApplicationDetails> appDetailsList = new ArrayList<>();
	    ApplicationDetails appDetails = null;
	    for(String appName : appKeys) {
	    	appDetails = new ApplicationDetails();
	    	appDetails.setAppName(appName);
	    	appDetails.setPageDetails(pageDetailsMap.get(appName));
	    	appDetailsList.add(appDetails);
	    }
	    request.setAppDetailsList(appDetailsList);
	    
	    List<EnvDetails> envDetailsList = populateEnvDetailsList(Workbook.getSheetAt(1));
	    request.setEnvDetailsList(envDetailsList);
	   
	    
	    return request;
		
	}

	private List<EnvDetails> populateEnvDetailsList(Sheet sheetEnvDetails) {
		
		List<EnvDetails> envDetailsList = new ArrayList<>();
		EnvDetails envDetails = null;
		int rowCount = sheetEnvDetails.getLastRowNum()-sheetEnvDetails.getFirstRowNum();
	    
	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheetEnvDetails.getRow(i);
	        String envName = row.getCell(0).getStringCellValue();
	        String envUrl = row.getCell(1).getStringCellValue();
	        
	        envDetails = new EnvDetails();
	        envDetails.setEnvName(envName);
	        envDetails.setEnvUrl(envUrl);
	        envDetailsList.add(envDetails);
	        
	    } 
	    
	    return envDetailsList;
	}

	private Map<String, List<PageDetails>> populatePageDetailsMap(Sheet sheetPageDetails) {
		Map<String,List<PageDetails>> dataMap = new HashMap<>();
		List<PageDetails> dataList = new ArrayList<>();
		PageDetails pageDetails = null;
		int rowCount = sheetPageDetails.getLastRowNum()-sheetPageDetails.getFirstRowNum();
	    
	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheetPageDetails.getRow(i);
	        String appName = row.getCell(0).getStringCellValue();
	        String pageName = row.getCell(1).getStringCellValue();
	        if(null != dataMap.get(appName)) {
	        	dataList = dataMap.get(appName);
	        	pageDetails = new PageDetails();
      		    pageDetails.setPageName(pageName);
      		    dataList.add(pageDetails);
      		    dataMap.put(appName, dataList);
      	    }else {
      	    	dataList = new ArrayList<>();
      		    dataMap = new HashMap<>();
      		    pageDetails = new PageDetails();
      		    pageDetails.setPageName(pageName);
      		    dataList.add(pageDetails);
      		    dataMap.put(appName, dataList);
      	    }
	    } 
	    
	    return dataMap;
	}

}
