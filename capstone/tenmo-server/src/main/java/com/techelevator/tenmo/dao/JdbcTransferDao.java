package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDTO;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TransferDTO> findAll() {
        List<TransferDTO> accountToUsers = new ArrayList<>();
        String sql = "SELECT t.account_to, tu.username " +
                "FROM transfer t " +
                "JOIN account a ON t.account_to = a.account_id " +
                "JOIN tenmo_user tu ON tu.user_id = a.user_id; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            accountToUsers.add(mapRowToTransfer(results));
        }
        return accountToUsers;

    }

    @Override
    public TransferDTO findByTransferID(int id) {
        TransferDTO transferByTransferID = null;
        String sql = "SELECT transfer_id " +
                "FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            transferByTransferID = mapRowToTransfer(results);
        }
        return transferByTransferID;
    }


    @Override
    public TransferDTO findByTransferType(int id) {
        TransferDTO transfer = null;
        String sql = "SELECT t.transfer_type_desc " +
                    "FROM transfer t " +
                    "JOIN transfer_type ty " +
                    "ON t.transfer_type_id = ty.transfer_type_id " +
                    "WHERE t.transfer_type_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }

    @Override
    public TransferDTO findByStatusId(int id) {
        TransferDTO transfer = null;
        String sql = "SELECT t.transfer_status_id " +
                    "FROM transfer t " +
                    "JOIN transfer_status ts " +
                    "ON t.transfer_status_id = ts.transfer_status_id " +
                    "WHERE t.transfer_status_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }

    @Override
    public TransferDTO findByTransferStatusDesc(String status) {
        TransferDTO transfer = null;
        String sql = "SELECT ts.transfer_status_desc " +
                     "FROM transfer_status ts " +
                     "JOIN transfer t " +
                     "ON t.transfer_status_id = ts.transfer_status_id " +
                     "WHERE t.transfer_status_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, status);
        if(results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }

    @Override
    public TransferDTO findByAccountFrom(int id) {
        TransferDTO transfer = null;
        String sql = "SELECT t.account_from " +
                     "FROM transfer t " +
                     "JOIN account a " +
                     "ON t.account_from = a.account_id " +
                     "WHERE t.account_from = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }


    @Override
    public TransferDTO findByAccountTo(int id) {
        TransferDTO transfer = null;
        String sql = "SELECT t.account_to " +
                     "FROM transfer t " +
                     "JOIN account a " +
                     "ON t.account_to = a.account_id " +
                     "WHERE t.account_to = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }

    @Override
    public TransferDTO getTransferAmount(BigDecimal transferBalance) {
        TransferDTO transfer = null;
        String sql = "SELECT amount FROM transfer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferBalance);
        if (results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;

    }

    @Override
    public Integer createTransfer(int status_id, int account_from, int account_to, BigDecimal amount) {
        String sql = "INSERT INTO transfer (transfer_status_id, transfer_type_id, account_from, account_to, amount) " +
                "VALUES (2, 2, ?, ?, ?)" +
                "RETURNING transfer_id;";
        return jdbcTemplate.queryForObject(sql, Integer.class, account_from, account_to, amount);
    }


    private TransferDTO mapRowToTransfer(SqlRowSet rs) {
        TransferDTO transfer = new TransferDTO();
//        transfer.setTransferID(rs.getInt("transfer_id"));
//        transfer.setTransferTypeID(rs.getInt("transfer_type_id"));
//        transfer.setTransferStatusID(rs.getInt("transfer_status_id"));
        transfer.setAccountTo(rs.getInt("account_to"));
        transfer.setAccountFrom(rs.getInt("account_from"));
        transfer.setAmount(rs.getBigDecimal("amount"));
//        transfer.setTransferStatusDesc(rs.getString("transfer_status_desc"));
        return transfer;

    }

}

