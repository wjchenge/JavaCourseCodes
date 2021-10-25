package com.wjchenge.homework10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wj
 * @Date 2021/10/25 22:00
 */
@SpringBootTest
class JDBCDemo3Test {

    @Autowired
    private JDBCDemo3 jdbcDemo3;

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException {

        List<JDBCDemo3.Data> data = jdbcDemo3.getData();
        System.out.println(data);

    }

    @Test
    public void testInset() throws SQLException, ClassNotFoundException {

        jdbcDemo3.insertData();
        this.testSelect();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {

        jdbcDemo3.updateData();
        this.testSelect();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {

        jdbcDemo3.deleteData();
        this.testSelect();
    }
}