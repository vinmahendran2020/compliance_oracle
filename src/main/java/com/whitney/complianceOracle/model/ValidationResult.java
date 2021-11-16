package com.whitney.complianceOracle.model;

import java.util.List;

public class ValidationResult {

	private Boolean result; 
	private List<Object> errorCodes;

	public ValidationResult(Boolean result, List<Object> errorCodes){
		this.result = result;
		this.errorCodes = errorCodes;
	};

	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}

	public List<Object> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<Object> errorCodes) {
		this.errorCodes = errorCodes;
	}	
}