package com.wjchenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author wj
 * @Date 2021/11/15 14:10
 */
@SpringBootTest
public class HomeWork2 {

    private static final String INSERT_SQL = "INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testInsert() {
        List<Object[]> orders = getOrders(100);
        jdbcTemplate.batchUpdate(INSERT_SQL, orders);

    }

    private static List<Object[]> getOrders(int num) {
        List<Object[]> list = new ArrayList<>(num);
        while (num-- > 0) {
            Object[] objects = new Object[12];
            objects[0] = System.currentTimeMillis();
            objects[1] = num;
            objects[2] = num;
            objects[3] = num * 3;
            objects[4] = num * 2;
            objects[5] = 1;
            objects[6] = num / 2;
            objects[7] = num % 6;
            Calendar calendar = Calendar.getInstance();
            objects[11] = calendar.getTime();
            calendar.add(Calendar.MINUTE, 3);
            objects[8] = calendar.getTime();
            calendar.add(Calendar.HOUR, 2);
            objects[9] = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            objects[10] = calendar.getTime();
            list.add(objects);
        }
        return list;
    }


}
