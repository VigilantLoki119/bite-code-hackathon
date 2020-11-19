package com.cts.testAutomation.model;

import java.io.Serializable;
import java.util.List;

public class TestItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemName;
	private List<String> values;
	private String xpathForException;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public String getXpathForException() {
		return xpathForException;
	}
	public void setXpathForException(String xpathForException) {
		this.xpathForException = xpathForException;
	}
	
	
	
}
