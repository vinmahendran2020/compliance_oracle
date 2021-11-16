package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleTwoTest {
    static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void ResidencyPassTest() {
		StatelessKieSession kSession2 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("USA");

        kSession2.setGlobal("errorCodes", errorCodes);

        RequestObj request = new RequestObj();
		RuleTwo ruleTwo = new RuleTwo();
		ruleTwo.setCountries(countries);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setCountryOfResidence("USA");
		investor.setInvestorProfile(investorProfile);
		
		request.setRuleTwo(ruleTwo);
		request.setInvestor(investor);
		kSession2.execute(request);
		ArrayList code = (ArrayList) kSession2.getGlobals().get("errorCodes");
        assert ((code).contains(2) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void ResidencyFailTest() {
		StatelessKieSession kSession3 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
        ArrayList<String> countries = new ArrayList<String>();
        
		countries.add("USA");
		kSession3.setGlobal("errorCodes", errorCodes);

        RequestObj request = new RequestObj();
		RuleTwo ruleTwo = new RuleTwo();
		ruleTwo.setCountries(countries);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setCountryOfResidence("Canada");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleTwo(ruleTwo);
		request.setInvestor(investor);

        kSession3.execute(request);
		ArrayList code = (ArrayList) kSession3.getGlobals().get("errorCodes");
        assert ((code).contains(2) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}
}