package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferStatusDTO {

    private int transferID;
    private int transferTypeID;
    private int transferStatusID;
    private String transferStatusTypeDesc;

    public TransferStatusDTO(int transferID, int transferTypeID, int transferStatusID, String transferStatusTypeDesc) {
        this.transferID = transferID;
        this.transferStatusID = transferStatusID;
        this.transferStatusID = transferStatusID;
        this.transferStatusTypeDesc = transferStatusTypeDesc;
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
}
