package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController implements TransferDao {


    @Override
    public List<Transfer> findAll() {
        return null;
    }

    @Override
    public Transfer findByTransferID(int id) {
        return null;
    }

    @Override
    public Transfer findByTransferType(int id) {
        return null;
    }

    @Override
    public Transfer findByStatusId(int id) {
        return null;
    }

    @Override
    public Transfer findByTransferStatusDesc(String status) {
        return null;
    }

    @Override
    public Transfer findByAccountFrom(int id) {
        return null;
    }

    @Override
    public Transfer findByAccountTo(int id) {
        return null;
    }

    @Override
    public Transfer getTransferAmount(BigDecimal transferBalance) {
        return null;
    }
}
