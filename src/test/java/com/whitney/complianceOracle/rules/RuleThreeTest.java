package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleThreeTest {
    static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
    
    @Test
	void StateOfResidencePassTest() {
		StatelessKieSession kSession4 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		ArrayList<String> states = new ArrayList<String>();
		states.add("NY");

        kSession4.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleThree ruleThree = new RuleThree();
		ruleThree.setStates(states);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setResidenceState("NY");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleThree(ruleThree);
        request.setInvestor(investor);
        
		kSession4.execute(request);
		ArrayList code = (ArrayList) kSession4.getGlobals().get("errorCodes");
        assert ((code).contains(3) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

    @Test
	void StateOfResidenceFailTest() {
		StatelessKieSession kSession5 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		ArrayList<String> states = new ArrayList<String>();
        states.add("NY");
        
		kSession5.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleThree ruleThree = new RuleThree();
		ruleThree.setStates(states);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setResidenceState("CA");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleThree(ruleThree);
        request.setInvestor(investor);
        
		kSession5.execute(request);
		ArrayList code = (ArrayList) kSession5.getGlobals().get("errorCodes");
        assert ((code).contains(3) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}