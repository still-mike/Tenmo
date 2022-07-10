package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class AccountBalance {

    private int accountID;
    private int userID;
    private BigDecimal balance;

    @Override
    public String toString() {
        return "\n Your current account balance is: $" + balance;
    }


    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
