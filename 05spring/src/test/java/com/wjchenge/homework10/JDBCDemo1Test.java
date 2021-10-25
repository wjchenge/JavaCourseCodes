package com.wjchenge.homework10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wj
 * @Date 2021/10/25 15:00
 */
@SpringBootTest
class JDBCDemo1Test {

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException {

        List<JDBCDemo1.Data> data = JDBCDemo1.getData();
        System.out.println(data);

    }

    @Test
    public void testInset() throws SQLException, ClassNotFoundException {

        JDBCDemo1.insertData();
        this.testSelect();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {

        JDBCDemo1.updateData();
        this.testSelect();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {

        JDBCDemo1.deleteData();
        this.testSelect();
    }
}