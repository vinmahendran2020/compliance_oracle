package com.whitney.complianceOracle.model;

public class Rules {
    public Integer ruleID;
    public String metadata;

    public Integer getRuleID() {
        return ruleID;
    }

    public void setRuleID(Integer pRuleID){
        ruleID = pRuleID;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String pMetadata){
        metadata = pMetadata;
    }
}
