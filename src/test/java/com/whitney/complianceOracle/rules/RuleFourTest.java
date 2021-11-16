package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleFourTest {
	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void AccredationPassTest() {
		StatelessKieSession kSession6 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		String accreditation = "Y";
        kSession6.setGlobal("errorCodes", errorCodes);

        RequestObj request = new RequestObj();
		RuleFour ruleFour = new RuleFour();
		ruleFour.setAccreditation(accreditation);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setAccreditationStatus("Y");
        investor.setInvestorProfile(investorProfile);
        
		request.setRuleFour(ruleFour);
		request.setInvestor(investor);

        kSession6.execute(request);
		ArrayList code = (ArrayList) kSession6.getGlobals().get("errorCodes");
        assert ((code).contains(4) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void AccredationFailTest() {
		StatelessKieSession kSession7 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		String accreditation = "Y";
		kSession7.setGlobal("errorCodes", errorCodes);

        RequestObj request = new RequestObj();
		RuleFour ruleFour = new RuleFour();
		ruleFour.setAccreditation(accreditation);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setAccreditationStatus("N");
		investor.setInvestorProfile(investorProfile);
        
		request.setRuleFour(ruleFour);
		request.setInvestor(investor);

        kSession7.execute(request);
		ArrayList code = (ArrayList) kSession7.getGlobals().get("errorCodes");
        assert ((code).contains(4) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}
}