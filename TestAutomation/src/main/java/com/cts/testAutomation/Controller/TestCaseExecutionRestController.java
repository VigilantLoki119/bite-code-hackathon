package com.cts.testAutomation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.testAutomation.helper.TestCaseExecutorHelper;
import com.cts.testAutomation.model.TestCaseExecutionResponse;
import com.cts.testAutomation.model.TestCaseRunResponse;

@RestController
@RequestMapping("/testcase/execution")
public class TestCaseExecutionRestController {
	
	@Autowired
	private TestCaseExecutorHelper executorHelper;
	
	
	@GetMapping("/run/{testCaseId}")
	public TestCaseRunResponse executeTestCase(@PathVariable int testCaseId) {
		return executorHelper.runTest(testCaseId);	
	}
	
	@GetMapping("/result/{testCaseSessionKey}")
	public TestCaseExecutionResponse getTestCaseExecutionResult(@PathVariable String testCaseSessionKey) {
		return executorHelper.getTestCaseExecutionResult(testCaseSessionKey);
	}
	

}
