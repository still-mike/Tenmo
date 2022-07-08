package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class TransferController {

    public TransferDao transferDao;

    public TransferController(TransferDao transferDao){
        this.transferDao = transferDao;
    }

    @RequestMapping(path = "/username", method = RequestMethod.GET)
    public List<TransferDTO> findAll() {
        return transferDao.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/transfers/{id}", method = RequestMethod.POST)
    public Transfer createTransfer(@Valid @RequestBody Transfer transfer, @PathVariable int id){
        return transferDao.createTransfer();
    }

//    @RequestMapping(path = "/transfers", method = RequestMethod.GET)
//    public List<Transfer>


}
