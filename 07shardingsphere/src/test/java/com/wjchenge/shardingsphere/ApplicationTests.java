package com.wjchenge.shardingsphere;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class ApplicationTests {

    private static final String SQL_INSERT_NAME = "INSERT INTO shardingsphere_test (`name`) VALUES (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testInsertMaster() {
        jdbcTemplate.update(SQL_INSERT_NAME, "master");
    }

    @Test
    void testInsertSlave() {
        jdbcTemplate.update(SQL_INSERT_NAME, "slave");
    }

}
