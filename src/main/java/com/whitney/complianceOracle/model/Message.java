package com.whitney.complianceOracle.model;

import com.whitney.complianceOracle.model.Investor;
import com.whitney.complianceOracle.model.Security;
import java.util.ArrayList;


public class Message {
	static ArrayList<Investor> investors = new ArrayList<Investor>();
	static Security security = new Security();
	static String eventType;
	static String tradingVenueName;

    public ArrayList<Investor> getInvestors() {
		return investors;
	}

	public void setInvestors(ArrayList<Investor> pInvestors) {
		investors = pInvestors;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security pSecurity) {
		security = pSecurity;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String pEventType) {
		eventType = pEventType;
	}

	public String getTradingVenueName(){
		return tradingVenueName;
	}

	public void setTradingVenueName(String pTradingVenueName) {
		tradingVenueName = pTradingVenueName;
	}

}