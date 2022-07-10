package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findByAccountID(int accountID);

    Account findIdByUserID(int userID);

    BigDecimal getBalance(String balance);

    BigDecimal getAllBalance(BigDecimal balance);

    int removeFromAccount(BigDecimal amount, int accountID);

    int addToAccount(BigDecimal amount, int accountID);


}
