package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {

//    private final TokenProvider tokenProvider;
//    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    public AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

//    private AccountDao accountDao;

//    public AccountController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
//        this.tokenProvider = tokenProvider;
//        this.authenticationManagerBuilder = authenticationManagerBuilder;
//    }

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
    public Account getByAccountId(@PathVariable int id) {
        return accountDao.findByAccountID(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public Account getByUserId(@PathVariable int id) {
        return accountDao.findIdByUserID(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(path = "/account/balance/{id}", method = RequestMethod.GET)
    public BigDecimal getBalance(@PathVariable BigDecimal balance) {
        return accountDao.getBalance(balance);
    }

    @RequestMapping(path = "")
    public String whoAmI(Principal principal) {
        return principal.getName();
    }

}
