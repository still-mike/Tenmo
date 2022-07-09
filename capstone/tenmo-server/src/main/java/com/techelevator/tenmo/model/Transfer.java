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


    public BigDecimal getAmount() {
        return amount;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public int getTransferStatusID() {
        return transferStatusID;
    }
}
