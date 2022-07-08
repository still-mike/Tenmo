package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findByAccountID(int id);

    Account findIdByUserID(int id);

    Integer getByUserID(int id);

    Account findBalanceIdByUserID(int id);

    BigDecimal getBalance(BigDecimal balance);

    BigDecimal getAllBalance(BigDecimal balance);

//    List<Account> getAllBalance();
}
