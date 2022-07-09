package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferDTO {

    private int transferID;
    private int transferTypeID;
    private int transferStatusID;
    private String transferStatusTypeDesc;

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    private String fromUsername;
    private String toUsername;

    private int accountID;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;


//    public TransferDTO(int transferID, int transferTypeID, int transferStatusID, String transferStatusTypeDesc, int accountID, int accountFrom, int accountTo, BigDecimal amount) {
//        this.transferID = transferID;
//        this.transferTypeID = transferTypeID;
//        this.transferStatusID = transferStatusID;
//        this.transferStatusTypeDesc = transferStatusTypeDesc;
//        this.accountID = accountID;
//        this.accountFrom = accountFrom;
//        this.accountTo = accountTo;
//        this.amount = amount;
//    }

    public TransferDTO() {

    }

    public int getTransferID() {
        return transferID;
    }

    public void setTransferID(int transferID) {
        this.transferID = transferID;
    }

    public int getTransferTypeID() {
        return transferTypeID;
    }

    public void setTransferTypeID(int transferTypeID) {
        this.transferTypeID = transferTypeID;
    }

    public int getTransferStatusID() {
        return transferStatusID;
    }

    public void setTransferStatusID(int transferStatusID) {
        this.transferStatusID = transferStatusID;
    }

    public String getTransferStatusTypeDesc() {
        return transferStatusTypeDesc;
    }

    public void setTransferStatusTypeDesc(String transferStatusTypeDesc) {
        this.transferStatusTypeDesc = transferStatusTypeDesc;
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
