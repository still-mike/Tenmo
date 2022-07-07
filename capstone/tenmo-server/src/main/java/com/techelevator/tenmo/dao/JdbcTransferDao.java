package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;

public class JdbcTransferDao implements TransferDao{

        private JdbcTemplate jdbcTemplate;

        public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    @Override
    public List<Transfer> findAll() {
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
}
