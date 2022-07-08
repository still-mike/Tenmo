package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {

    public TransferDao transferDao;
    public AccountDao accountDao;

    public TransferController(TransferDao transferDao, AccountDao accountDao){
        this.transferDao = transferDao;
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "/username", method = RequestMethod.GET)
    public List<TransferDTO> findAll() {
        return transferDao.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfers", method = RequestMethod.POST)
    @Transactional
    public Integer createTransfer(@Valid @RequestBody Transfer transfer){
        accountDao.removeFromAccount(transfer.getAmount(), transfer.getAccountFrom());
        accountDao.addToAccount(transfer.getAmount(), transfer.getAccountTo());
        return transferDao.createTransfer(transfer.getTransferStatusID(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
    }

//    @RequestMapping(path = "/transfers", method = RequestMethod.GET)
//    public List<Transfer>


}
