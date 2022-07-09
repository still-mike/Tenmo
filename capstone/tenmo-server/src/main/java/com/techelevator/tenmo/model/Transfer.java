package com.techelevator.tenmo.model;

import com.techelevator.tenmo.dao.TransferDao;

import java.math.BigDecimal;

public class Transfer {

    private int transferID;
    private int transferTypeID;
    private int transferStatusID;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;

    public Transfer(int transferID, int transferTypeID, int transferStatusID, int accountFrom, int accountTo, BigDecimal amount) {
        this.transferID = transferID;
        this.transferTypeID = transferTypeID;
        this.transferStatusID = transferStatusID;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public int getAccountFrom() {
        return getAccountFrom();
    }

    public BigDecimal getAmount() {
        return getAmount();
    }

    public int getAccountTo() {
        return getAccountTo();
    }

    public int getTransferStatusID() {
        return getTransferStatusID();
    }

    public void setTransferStatusID(int transferStatusID) {
        this.transferStatusID = transferStatusID;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
