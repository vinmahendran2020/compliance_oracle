package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleNineTest {

	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void OwnershipLimitPassTest() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
        kSession13.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleNine ruleNine = new RuleNine();
		ruleNine.setOwnershipLimitPercentage(0.50);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investor.setPostTransactionPercent(0.25);
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleNine(ruleNine);
		request.setInvestor(investor);
        ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
        
        kSession13.execute(request);
        
        assert ((code).contains(9) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void OwnershipLimitFailTest() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession13.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleNine ruleNine = new RuleNine();
        ruleNine.setOwnershipLimitPercentage(0.50);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investor.setPostTransactionPercent(0.75);
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleNine(ruleNine);
		request.setInvestor(investor);
		ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
		kSession13.execute(request);

        assert ((code).contains(9) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}