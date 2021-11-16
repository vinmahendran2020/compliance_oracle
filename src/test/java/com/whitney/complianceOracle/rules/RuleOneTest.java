package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleOneTest {
	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void CitizenshipPassTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
        List<Integer> errorCodes = new ArrayList<Integer>();
        
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("USA");
        
        kSession.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleOne ruleOne = new RuleOne();
		ruleOne.setCountries(countries);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setCitizenship("USA");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleOne(ruleOne);
        request.setInvestor(investor);
        
		kSession.execute(request);
		ArrayList<Integer> code = (ArrayList) kSession.getGlobals().get("errorCodes");
        assert ((code).contains(1) == false);
        
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }

	@Test
	void CitizenshipFailTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
        List<Integer> errorCodes = new ArrayList<Integer>();
        
        ArrayList<String> countries = new ArrayList<String>();
        countries.add("USA");
        
        kSession.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleOne ruleOne = new RuleOne();
		ruleOne.setCountries(countries);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setCitizenship("Canada");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleOne(ruleOne);
        request.setInvestor(investor);
        
		kSession.execute(request);
		ArrayList<Integer> code = (ArrayList) kSession.getGlobals().get("errorCodes");
        assert ((code).contains(1) == true);
        
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}