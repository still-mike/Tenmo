package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account {

    private int accountID;
    private int userID;
    private BigDecimal balance;

    public Account() {

    }

    public Account(int accountID, int userID, BigDecimal balance) {
        this.accountID = accountID;
        this.userID = userID;
        this.balance = balance;
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
        this.userID = userID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

//    public Account removeFromAccount(Account amount) {
//        this.
//    }

//    public void add(Account account) {
//    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
