package com.whitney.complianceOracle.rules;

import com.whitney.complianceOracle.model.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;



public class RuleTwelveTest {
	static KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();

	@Test
	void TradingVenuePassTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
        List<Integer> errorCodes = new ArrayList<Integer>();
        
        ArrayList<String> tradingVenues = new ArrayList<String>();
        tradingVenues.add("ValidTradingVenue");
        
        kSession.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleTwelve ruleTwelve = new RuleTwelve();
        ruleTwelve.setValidTradingVenueNames(tradingVenues);
        request.setTradingVenueName("ValidTradingVenue");
		request.setRuleTwelve(ruleTwelve);
        
		kSession.execute(request);
		ArrayList<Integer> code = (ArrayList) kSession.getGlobals().get("errorCodes");
        assert ((code).contains(12) == false);
        
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }

	@Test
	void TradingVenueFailTest() {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession("unitTesting");
        List<Integer> errorCodes = new ArrayList<Integer>();
        
        ArrayList<String> tradingVenues = new ArrayList<String>();
        tradingVenues.add("ValidTradingVenue");
        
        kSession.setGlobal("errorCodes", errorCodes);
        
		RequestObj request = new RequestObj();
		RuleTwelve ruleTwelve = new RuleTwelve();
        ruleTwelve.setValidTradingVenueNames(tradingVenues);
        request.setTradingVenueName("InValidTradingVenue");
		request.setRuleTwelve(ruleTwelve);
        
		kSession.execute(request);
		ArrayList<Integer> code = (ArrayList) kSession.getGlobals().get("errorCodes");
        assert ((code).contains(12) == true);
        
        //clean-up global error codes
        for(int i =0; i< code.size(); i++){
            code.remove(i);
        }
    }
}