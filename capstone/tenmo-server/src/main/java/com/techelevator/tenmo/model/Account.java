package com.techelevator.tenmo.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class Account {

    private int accountID;
    private int userID;
    private BigDecimal balance;

    public Account(int accountID, int userID, BigDecimal balance) {
        this.accountID = accountID;
        this.userID = userID;
        this.balance = balance;
    }

    public Account() {
        
    }

    public int getAccountID() {
        return accountID;
    }

    public int getUserID() {
        return userID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setUserID(int userID) {
    }

    public void setAccountID(int accountID) {
    }

    public void add(Account account) {
    }

    public void setBalance(BigDecimal balance) {
    }
}
