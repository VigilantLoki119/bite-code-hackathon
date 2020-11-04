package com.cts.qaAutomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.qaAutomation.helper.TestCaseExecutionHelper;
import com.cts.qaAutomation.model.TestResultDetails;

@RestController
@RequestMapping("/testcase/execution")
public class TestCaseExecutionController {
	
	@Autowired
	private TestCaseExecutionHelper executionHelper;
	
	
	@GetMapping("/run")
	public TestResultDetails executeTestCase() {
		return executionHelper.executeTest("WOW List View Search - ALL", "https://qaa.rci.com");	
	}

}
