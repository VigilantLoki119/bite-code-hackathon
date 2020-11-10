package com.cts.testAutomation.helper;

import com.cts.testAutomation.model.TestCaseExecutorRequest;

public class TestCaseExecutorTask implements Runnable{
	
	private TestCaseExecutorRequest request;
	private TaskExecutorHelper taskHelper;
	
	public void populateTaskParameter(TestCaseExecutorRequest request,TaskExecutorHelper taskHelper) {
		this.request = request;
		this.taskHelper = taskHelper;
	}
	
	
	@Override
	public void run() {
		taskHelper.executeTest(request);              
		
	}


	

}
