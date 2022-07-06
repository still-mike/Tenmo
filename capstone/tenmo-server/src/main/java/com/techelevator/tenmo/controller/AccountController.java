package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
//    private AccountDao accountDao;

    public AccountController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }


}
