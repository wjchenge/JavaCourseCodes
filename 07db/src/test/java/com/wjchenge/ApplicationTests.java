package com.wjchenge;

import com.wjchenge.homework9.DataSourceContextHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootTest
class ApplicationTests {

    private static final String SQL_GET_NAME = "select name from data_source_name";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    void testMaster() {
        DataSourceContextHolder.set(com.wjchenge.homework9.DataSource.MASTER);
        String name = jdbcTemplate.query(SQL_GET_NAME, rowMapper).get(0);
        System.out.println("name = " + name);
    }

    @Test
    void testSlave() {
        DataSourceContextHolder.set(com.wjchenge.homework9.DataSource.SLAVE);
        String name = jdbcTemplate.query(SQL_GET_NAME, rowMapper).get(0);
        System.out.println("name = " + name);
    }

    private static RowMapper<String> rowMapper = (rs, rowNum) -> rs.getString("name");

}
