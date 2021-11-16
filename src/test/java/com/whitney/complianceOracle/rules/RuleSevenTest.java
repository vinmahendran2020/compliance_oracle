package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleSevenTest {
	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void NormalLockUpPeriodPassTest() {
		StatelessKieSession kSession9 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession9.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSeven ruleSeven = new RuleSeven();
		ruleSeven.setRuleSeven(true);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(false);
        investor.setInvestorProfile(investorProfile);
        
        Security security = new Security();
		security.setPastLockUp(true);
		request.setRuleSeven(ruleSeven);
		request.setInvestor(investor);
        request.setSecurity(security);
        
		kSession9.execute(request);
		ArrayList code = (ArrayList) kSession9.getGlobals().get("errorCodes");
        assert ((code).contains(7) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void NormalLockUpPeriodFailTest() {
		StatelessKieSession kSession10 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession10.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSeven ruleSeven = new RuleSeven();
        ruleSeven.setRuleSeven(true);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(false);
        investor.setInvestorProfile(investorProfile);
        
		Security security = new Security();
		security.setPastLockUp(false);
		request.setRuleSeven(ruleSeven);
		request.setInvestor(investor);
		request.setSecurity(security);
		kSession10.execute(request);
		ArrayList code = (ArrayList) kSession10.getGlobals().get("errorCodes");
        assert ((code).contains(7) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void SpecialLockUpPeriodPassTest() {
		StatelessKieSession kSession10 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession10.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSeven ruleSeven = new RuleSeven();
        ruleSeven.setRuleSeven(true);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(true);
        investor.setInvestorProfile(investorProfile);
        
        Security security = new Security();
		security.setPastLockUp(true);
		request.setRuleSeven(ruleSeven);
		request.setInvestor(investor);
		request.setSecurity(security);
		ArrayList code = (ArrayList) kSession10.getGlobals().get("errorCodes");

		kSession10.execute(request);
        assert ((code).contains(7) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void SpecialLockUpPeriodFailTest() {
		StatelessKieSession kSession11 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession11.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSeven ruleSeven = new RuleSeven();
        ruleSeven.setRuleSeven(true);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(true);
        investor.setInvestorProfile(investorProfile);
        
		Security security = new Security();
		security.setPastSpecialLockUp(false);
		request.setRuleSeven(ruleSeven);
		request.setInvestor(investor);
		request.setSecurity(security);
		ArrayList code = (ArrayList) kSession11.getGlobals().get("errorCodes");
		kSession11.execute(request);
        assert ((code).contains(7) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}
}