package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferDTO {

//    private int transferID;
//    private int transferTypeID;
//    private int transferStatusID;
//    private String transferStatusTypeDesc;

    private int accountID;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;


    public TransferDTO() {
//        this.transferID = transferID;
//        this.transferStatusID = transferStatusID;
//        this.transferStatusID = transferStatusID;
//        this.transferStatusTypeDesc = transferStatusTypeDesc;
        this.accountID = accountID;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
