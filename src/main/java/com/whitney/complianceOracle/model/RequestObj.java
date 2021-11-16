package com.whitney.complianceOracle.model;

import com.whitney.complianceOracle.model.Investor;
import com.whitney.complianceOracle.model.Security;

public class RequestObj {
	static Investor investor = new Investor();
	static Security security = new Security();
	static String tradingVenueName;
	static RuleOne ruleOne = new RuleOne();
	static RuleTwo ruleTwo = new RuleTwo();
	static RuleThree ruleThree = new RuleThree();
	static RuleFour ruleFour = new RuleFour();
	static RuleFive ruleFive = new RuleFive();
    static RuleSix ruleSix = new RuleSix();
	static RuleSeven ruleSeven = new RuleSeven();
    static RuleEight ruleEight = new RuleEight();
	static RuleNine ruleNine = new RuleNine();
	static RuleTen ruleTen = new RuleTen();
	static RuleEleven ruleEleven = new RuleEleven();
	static RuleTwelve ruleTwelve = new RuleTwelve();
	
	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor pInvestor) {
		investor = pInvestor;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security pSecurity) {
		security = pSecurity;
	}

	public RuleOne getRuleOne() {
		return ruleOne;
	}

	public void setRuleOne(RuleOne pRuleOne) {
		ruleOne = pRuleOne;
	}

	public RuleTwo getRuleTwo() {
		return ruleTwo;
	}

	public void setRuleTwo(RuleTwo pRuleTwo) {
		ruleTwo = pRuleTwo;
	}

	public RuleThree getRuleThree() {
		return ruleThree;
	}

	public void setRuleThree(RuleThree pRuleThree) {
		ruleThree = pRuleThree;
	}

	public RuleFour getRuleFour() {
		return ruleFour;
	}

	public void setRuleFour(RuleFour pRuleFour) {
		ruleFour = pRuleFour;
	}

	public RuleFive getRuleFive() {
		return ruleFive;
	}

	public void setRuleFive(RuleFive pRuleFive) {
		ruleFive = pRuleFive;
	}

    public RuleSix getRuleSix() {
		return ruleSix;
	}

	public void setRuleSix(RuleSix pRuleSix) {
		ruleSix = pRuleSix;
	}
	
	public RuleSeven getRuleSeven() {
		return ruleSeven;
	}

	public void setRuleSeven(RuleSeven pRuleSeven) {
		ruleSeven = pRuleSeven;
	}
	
	public RuleEight getRuleEight() {
		return ruleEight;
	}

	public void setRuleEight(RuleEight pRuleEight) {
		ruleEight = pRuleEight;
	}

	public RuleNine getRuleNine() {
		return ruleNine;
	}

	public void setRuleNine(RuleNine pRuleNine) {
		ruleNine = pRuleNine;
	}
	
	public RuleTen getRuleTen() {
		return ruleTen;
	}

	public void setRuleTen(RuleTen pRuleTen) {
		ruleTen = pRuleTen;
	}

	public RuleEleven getRuleEleven() {
		return ruleEleven;
	}

	public void setRuleEleven(RuleEleven pRuleEleven) {
		ruleEleven = pRuleEleven;
	}

	public RuleTwelve getRuleTwelve() {
		return ruleTwelve;
	}

	public void setRuleTwelve(RuleTwelve pRuleTwelve) {
		ruleTwelve = pRuleTwelve;
	}

	public String getTradingVenueName() {
		return tradingVenueName;
	}

	public void setTradingVenueName(String pTradingVenueName) {
		tradingVenueName = pTradingVenueName;
	}

	public void refreshRules(){
		ruleOne = new RuleOne();
		ruleTwo = new RuleTwo();
		ruleThree = new RuleThree();
		ruleFour = new RuleFour();
		ruleFive = new RuleFive();
		ruleSix = new RuleSix();
		ruleSeven = new RuleSeven();
		ruleEight = new RuleEight();
		ruleNine = new RuleNine();
		ruleTen = new RuleTen();
		ruleEleven = new RuleEleven();
		ruleTwelve = new RuleTwelve();
		tradingVenueName = "";
	}
}