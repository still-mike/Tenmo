package com.techelevator.tenmo.controller;


import Exceptions.InsufficientFundsException;
import Exceptions.TransfersToAccountException;
import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {

    public TransferDao transferDao;
    public AccountDao accountDao;
    public UserDao userDao;

    public TransferController(TransferDao transferDao, AccountDao accountDao, UserDao userDao){
        this.transferDao = transferDao;
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/username", method = RequestMethod.GET)
    public List<TransferDTO> findAll() {
        return transferDao.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfers", method = RequestMethod.POST)
    @Transactional
    public Integer createTransfer(@Valid @RequestBody Transfer transfer) throws InsufficientFundsException, TransfersToAccountException {
        accountDao.removeFromAccount(transfer.getAmount(), transfer.getAccountFrom());
        accountDao.addToAccount(transfer.getAmount(), transfer.getAccountTo());
        if (accountDao.getBalance().compareTo(transfer.getAmount()) <= 0) {
            throw new InsufficientFundsException();
        }
        else if (accountDao.getBalance(transfer.getAmount()) > accountDao.getBalance(transfer.getAccountFrom()) {
            throw new InsufficientFundsException();
        }
        else if (accountDao.getByUserID(transfer.getAccountTo()) == accountDao.getByUserID(transfer.getAccountFrom())){
            throw new TransfersToAccountException();
        }
        return transferDao.createTransfer(transfer.getTransferStatusID(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
    }

    @RequestMapping(path = "/transfers", method = RequestMethod.GET)
    public List<TransferDTO> findTransferTypes(Principal principal){
        String username = principal.getName();
        User user = userDao.findByUsername(username);
        Account account = accountDao.findIdByUserID(user.getId().intValue());
        return transferDao.findByAccountID(account.getAccountID());
    }



}
