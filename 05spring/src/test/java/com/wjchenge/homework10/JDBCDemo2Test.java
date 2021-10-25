package com.wjchenge.homework10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wj
 * @Date 2021/10/25 19:00
 */
@SpringBootTest
class JDBCDemo2Test {

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException {

        List<JDBCDemo2.Data> data = JDBCDemo2.getData();
        System.out.println(data);

    }

    @Test
    public void testInset() throws SQLException, ClassNotFoundException {

        JDBCDemo2.insertData();
        this.testSelect();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {

        JDBCDemo2.updateData();
        this.testSelect();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {

        JDBCDemo2.deleteData();
        this.testSelect();
    }
}