package com.whitney.complianceOracle.model;

public class Investor {

    public InvestorProfile investorProfile = new InvestorProfile();
    public Integer tokens;
    public Integer transactionAmount;
    public Integer availableTokensForSale;
    public String currentOwner;
    public Boolean sender;
    public Integer postTransactionAmount; 
    public Double postTransactionPercent;

    public InvestorProfile getInvestorProfile() {
        return investorProfile;
    }

    public void setInvestorProfile(InvestorProfile pInvestorProfile) {
        investorProfile = pInvestorProfile;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setTokens(Integer pTokens) {
        tokens = pTokens;
    }

    public Integer getAvailableTokensForSale() {
        return availableTokensForSale;
    }

    public void setAvailableForSale(Integer pAvailableTokensForSale) {
        availableTokensForSale = pAvailableTokensForSale;
    }

    public String getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(String pCurrentOwner) {
        currentOwner = pCurrentOwner;
    }

    public Boolean getSender() {
        return sender;
    }

    public void setSender(Boolean pSender) {
        sender = pSender;
    }

    public Integer getPostTransactionAmount() {
        return postTransactionAmount;
    }

    public void setPostTransactionAmount(Integer pPostTransactionAmount) {
        postTransactionAmount = pPostTransactionAmount;
    }

    public Double getPostTransactionPercent() {
        return postTransactionPercent;
    }

    public void setPostTransactionPercent(Double pPostTransactionPercent) {
        postTransactionPercent = pPostTransactionPercent;
    }
    
    public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer pTransactionAmount) {
		transactionAmount = pTransactionAmount;
	}
};