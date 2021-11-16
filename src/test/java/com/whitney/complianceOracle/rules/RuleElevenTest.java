package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleElevenTest {

	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void SpecialInvestorAndAuthorizedToTradePassTest() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession13.setGlobal("errorCodes", errorCodes);

        RequestObj request = new RequestObj();
		RuleEleven ruleEleven = new RuleEleven();
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(true);
		investorProfile.setTradeAuthorized(true);
		investor.setInvestorProfile(investorProfile);

		request.setRuleEleven(ruleEleven);
		request.setInvestor(investor);
		ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");

        kSession13.execute(request);

        assert ((code).contains(11) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void SpecialInvestorAndAuthorizedToTradeFailTest1() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession13.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleEleven ruleEleven = new RuleEleven();
		ruleEleven.setRuleEleven(true);

		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(true);
		investorProfile.setTradeAuthorized(false);
        investor.setInvestorProfile(investorProfile);
		request.setRuleEleven(ruleEleven);
		request.setInvestor(investor);
        ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
        
		kSession13.execute(request);

        assert ((code).contains(11) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void SpecialInvestorAndAuthorizedToTradeFailTest2() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession13.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleEleven ruleEleven = new RuleEleven();
        ruleEleven.setRuleEleven(true);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(false);
		investorProfile.setTradeAuthorized(false);
		investor.setInvestorProfile(investorProfile);
		request.setRuleEleven(ruleEleven);
		request.setInvestor(investor);
		ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
        
        kSession13.execute(request);
        
        assert ((code).contains(11) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void SpecialInvestorAndAuthorizedToTradeFailTest3() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession13.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleEleven ruleEleven = new RuleEleven();
        ruleEleven.setRuleEleven(true);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setSpecialInvestor(false);
		investorProfile.setTradeAuthorized(true);
		investor.setInvestorProfile(investorProfile);

		request.setRuleEleven(ruleEleven);
		request.setInvestor(investor);
        ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
        
        kSession13.execute(request);
        
        assert ((code).contains(11) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}
}
