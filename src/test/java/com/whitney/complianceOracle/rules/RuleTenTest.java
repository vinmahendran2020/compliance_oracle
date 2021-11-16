package com.whitney.complianceOracle.rules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.whitney.complianceOracle.model.*;

public class RuleTenTest {

	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void BuySellPeriodPassTest() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
        kSession13.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleTen ruleTen = new RuleTen();
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investor.setAvailableForSale(100);
		investor.setTransactionAmount(50);
		investor.setInvestorProfile(investorProfile);

        
		request.setRuleTen(ruleTen);
		request.setInvestor(investor);
        ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");
        
		kSession13.execute(request);
        assert ((code).contains(10) == false);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
	}

	@Test
	void BuySellPeriodFailTest() {
		StatelessKieSession kSession13 = kieContainer.newStatelessKieSession("unitTesting");
		List<Integer> errorCodes = new ArrayList<Integer>();
        kSession13.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleTen ruleTen = new RuleTen();
		Investor investor = new Investor();
		InvestorProfile investorProfile = new InvestorProfile();
		investor.setAvailableForSale(50);
		investor.setTransactionAmount(100);
        investor.setInvestorProfile(investorProfile);

		request.setRuleTen(ruleTen);
		request.setInvestor(investor);
		ArrayList code = (ArrayList) kSession13.getGlobals().get("errorCodes");

        kSession13.execute(request);

        assert ((code).contains(10) == true);
                
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}