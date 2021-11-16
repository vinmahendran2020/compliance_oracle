package com.whitney.complianceOracle.model;

import java.util.ArrayList;

import com.whitney.complianceOracle.model.Security;

public class Security {
	public ArrayList<Rules> rules = new ArrayList<Rules>();
	public SecurityMaster securityMaster = new SecurityMaster();
	public Integer numberOfOwners;
	public Boolean pastLockUp;
	public Boolean pastSpecialLockUp;

    public ArrayList<Rules> getRules() {
		return rules;
	}

	public void setRules(ArrayList<Rules> pRules) {
		rules = pRules;
	}    
 

    public SecurityMaster getSecurityMaster() {
		return securityMaster;
	}

	public void setSecurity(SecurityMaster pSecurityMaster) {
		securityMaster = pSecurityMaster;
	}

	public Integer getNumberOfOwners() {
		return numberOfOwners;
	}

	public void setNumberOfOwners(Integer pNumberOfOwners) {
		numberOfOwners = pNumberOfOwners;
	}  

	public Boolean getPastLockUp() {
		return pastLockUp;
	}

	public void setPastLockUp(Boolean pPastLockUp) {
		pastLockUp = pPastLockUp;
	}

	public Boolean getPastSpecialLockUp() {
		return pastSpecialLockUp;
	}
	
	public void setPastSpecialLockUp(Boolean pPastSpecialLockUp) {
		pastSpecialLockUp = pPastSpecialLockUp;
	}
}