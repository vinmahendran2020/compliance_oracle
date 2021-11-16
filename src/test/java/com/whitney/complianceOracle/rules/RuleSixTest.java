package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleSixTest {
	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void KYCSourcePassTest() {
		StatelessKieSession kSession8 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		ArrayList<String> kycSources = new ArrayList<String>();
		kycSources.add("DTCC");
        kycSources.add("Ledger Labs");
		kSession8.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSix ruleSix = new RuleSix();
		ruleSix.setKycSources(kycSources);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setAccreditationSource("DTCC");
		investorProfile.setSubmitter("DTCC");
		investor.setInvestorProfile(investorProfile);
        request.setRuleSix(ruleSix);
        request.setInvestor(investor);
        
        kSession8.execute(request);
        
		ArrayList code = (ArrayList) kSession8.getGlobals().get("errorCodes");
        assert ((code).contains(6) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void KYCSourceFailTest() {
		StatelessKieSession kSession8 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
		ArrayList<String> kycSources = new ArrayList<String>();
		kycSources.add("DTCC");
		kycSources.add("Ledger Labs");
		kSession8.setGlobal("errorCodes", errorCodes);
		RequestObj request = new RequestObj();
		RuleSix ruleSix = new RuleSix();
		ruleSix.setKycSources(kycSources);
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investorProfile.setAccreditationSource("Whitney");
		investorProfile.setSubmitter("DTC");
		investor.setInvestorProfile(investorProfile);
		request.setRuleSix(ruleSix);
        request.setInvestor(investor);
        
		kSession8.execute(request);
		ArrayList code = (ArrayList) kSession8.getGlobals().get("errorCodes");
        assert ((code).contains(6) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}