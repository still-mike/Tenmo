package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, user_id, balance FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            accounts.add(mapRowToAccount(results));
        }
        return accounts;
    }

    @Override
    public Account findByAccountID(int accountID) {
        Account accountById = null;
        String sql = "SELECT * FROM account WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountID);
        if (results.next()) {
            accountById = mapRowToAccount(results);
        }
        return accountById;
    }

    @Override
    public Account findIdByUserID(int id) {
        Account accountByUserId = null;
        String sql = "SELECT * " +
                "FROM account a " +
                "JOIN tenmo_user ts " +
                "ON a.user_id = ts.user_id " +
                "WHERE a.user_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            accountByUserId = mapRowToAccount(results);
        }
        return accountByUserId;
    }

//    @Override
//    public Integer getByUserID(int id) {
//        Account account = null;
//        String sql = "SELECT account_id " +
//                "FROM account " +
//                "WHERE user_id = ?;";
//        Integer getAccount;
//        getAccount = jdbcTemplate.queryForObject(sql, Integer.class, id);
//        return getAccount;
//    }

//    @Override
//    public Account findBalanceIdByUserID(int id) {
//        Account balanceByUserId = null;
//        String sql = "SELECT a.balance " +
//                "FROM account a " +
//                "JOIN tenmo_user ts " +
//                "ON a.user_id = ts.user_id " +
//                "WHERE a.user_id = ? ";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
//        if (results.next()) {
//            balanceByUserId = mapRowToAccount(results);
//        }
//        return balanceByUserId;
//    }

    public BigDecimal getBalance(String user) {  //type Account? BigDecimal?
        BigDecimal accountBalance;
        String sql = "SELECT a.balance " +
                "FROM account a " +
                "JOIN tenmo_user ts " +
                "ON a.user_id = ts.user_id " +
                "WHERE ts.username = ? ";
        accountBalance = jdbcTemplate.queryForObject(sql, BigDecimal.class, user);
        return accountBalance;
    }


    public BigDecimal getAllBalance(BigDecimal balance) {
        Account account = null;
        String sql = "SELECT balance " +
                "FROM account;";
        BigDecimal balanceAmount;
        balanceAmount = jdbcTemplate.queryForObject(sql, BigDecimal.class, balance);
        return balance;
    }


    @Override
    public int removeFromAccount(BigDecimal amount, int accountID) {
        Account account = null;
        String sql = "UPDATE account " +
                     "SET balance = balance - ? " +
                     "WHERE account_id = ?;";
        return jdbcTemplate.update(sql, amount, accountID);
    }

    @Override
    public int addToAccount(BigDecimal amount, int accountID) {
        Account account = null;
        String sql = "UPDATE account " +
                     "SET balance = balance + ? " +
                     "WHERE account_id = ?;";
        return jdbcTemplate.update(sql, amount, accountID);
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setUserID(rs.getInt("user_id"));
        account.setAccountID(rs.getInt("account_id"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }

}
