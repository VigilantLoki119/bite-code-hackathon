package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestResultWithStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TestItem testItemExpected;
	private TestItem testItemActual;
	private List<String> remarks;
	private String status;
	public TestItem getTestItemActual() {
		return testItemActual;
	}
	public void setTestItemActual(TestItem testItemActual) {
		this.testItemActual = testItemActual;
	}
	public List<String> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TestItem getTestItemExpected() {
		return testItemExpected;
	}
	public void setTestItemExpected(TestItem testItemExpected) {
		this.testItemExpected = testItemExpected;
	}
	
	

}
