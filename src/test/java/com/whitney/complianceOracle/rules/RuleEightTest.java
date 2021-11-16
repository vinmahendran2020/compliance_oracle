package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleEightTest {

	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void InvestorLimitPassTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
        kSession.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleEight ruleEight = new RuleEight();
		ruleEight.setInvestorLimit(100);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
        investor.setInvestorProfile(investorProfile);
        
		Security security = new Security();
		security.setNumberOfOwners(50);
		request.setRuleEight(ruleEight);
		request.setInvestor(investor);
		request.setSecurity(security);
        ArrayList code = (ArrayList) kSession.getGlobals().get("errorCodes");
        
		kSession.execute(request);

        assert ((code).contains(8) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

    @Test
	void InvestorLimitFailTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		kSession.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleEight ruleEight = new RuleEight();
        ruleEight.setInvestorLimit(50);
        
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investor.setInvestorProfile(investorProfile);
		Security security = new Security();
		security.setNumberOfOwners(100);
		request.setRuleEight(ruleEight);
		request.setInvestor(investor);
        request.setSecurity(security);
        
		ArrayList code = (ArrayList) kSession.getGlobals().get("errorCodes");
		kSession.execute(request);
        assert ((code).contains(8) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}