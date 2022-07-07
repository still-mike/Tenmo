package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {

    List<Transfer> findAll();

    Transfer findByTransferID(int id);

    Transfer findByTransferType(int id);

    Transfer findByStatusId(int id);

    Transfer findByTransferStatusDesc(String status);

    Transfer findByAccountFrom(int id);

    Transfer findByAccountTo(int id);

    Transfer getTransferAmount(BigDecimal transferBalance);




}
