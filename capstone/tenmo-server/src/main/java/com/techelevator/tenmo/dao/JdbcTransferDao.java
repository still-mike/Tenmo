package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transfer> findAll() {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_ status_id, account_from, account_to, amount FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
//            Account account = mapRowToAccount(results);
//            account.add(account);
        }
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

//    private Account mapRowToTransfer(SqlRowSet rs) {
//        Transfer transfer = new Transfer();
//        transfer.setTransferID(rs.getInt("transfer_id"));
//        transfer.setTransferTypeID(rs.getInt("transfer_type_id"));
//        transfer.setTransferStatusID(rs.getInt("transfer_status_id"));
//        transfer.setTransferStatusDesc(rs.getString("transfer_status_desc"));


//        account.setAccountID(rs.getInt("account_id"));
//        account.setBalance(rs.getBigDecimal("balance"));
//        return account;
//    }

//    }
}
