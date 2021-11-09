package com.wjchenge;

import com.google.common.collect.Lists;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wj
 * @Date 2021/11/8 15:47
 */
public class HomeWork2 {

    private static HikariDataSource DATA_SOURCE = null;

     static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/wjchenge_test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        config.setUsername("root");
        config.setPassword("root");
        config.setMinimumIdle(20);
        config.setMaximumPoolSize(20);
        DATA_SOURCE = new HikariDataSource(config);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        method6();
        method7();
    }


    /**
     * 使用 PreparedStatement 逐条提交插入
     */
    public static void method1() throws SQLException, ClassNotFoundException {
        List<OrderData> list = getOrderData(1000000);
        String sql = "INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        long begin = System.currentTimeMillis();
        for (OrderData orderData : list) {
            ps.setLong(1, orderData.orderNo);
            ps.setLong(2, orderData.userId);
            ps.setLong(3, orderData.shippingId);
            ps.setInt(4, orderData.totalPayment);
            ps.setInt(5, orderData.realPayment);
            ps.setInt(6, orderData.paymentType);
            ps.setInt(7, orderData.postage);
            ps.setInt(8, orderData.status);
            ps.setDate(9, new java.sql.Date(orderData.paymentTime.getTime()));
            ps.setDate(10, new java.sql.Date(orderData.sendTime.getTime()));
            ps.setDate(11, new java.sql.Date(orderData.endTime.getTime()));
            ps.setDate(12, new java.sql.Date(orderData.createTime.getTime()));
            ps.execute();
        }
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        ps.close();
        connection.close();
    }


    /**
     * 使用 PreparedStatement 批量提交插入
     */
    public static void method2() throws SQLException, ClassNotFoundException {
        List<OrderData> list = getOrderData(1000000);
        String sql = "INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        long begin = System.currentTimeMillis();
        for (OrderData orderData : list) {
            ps.setLong(1, orderData.orderNo);
            ps.setLong(2, orderData.userId);
            ps.setLong(3, orderData.shippingId);
            ps.setInt(4, orderData.totalPayment);
            ps.setInt(5, orderData.realPayment);
            ps.setInt(6, orderData.paymentType);
            ps.setInt(7, orderData.postage);
            ps.setInt(8, orderData.status);
            ps.setDate(9, new java.sql.Date(orderData.paymentTime.getTime()));
            ps.setDate(10, new java.sql.Date(orderData.sendTime.getTime()));
            ps.setDate(11, new java.sql.Date(orderData.endTime.getTime()));
            ps.setDate(12, new java.sql.Date(orderData.createTime.getTime()));
            ps.addBatch();
        }
        ps.executeBatch();
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        ps.close();
        connection.close();
    }

    /**
     * 使用 PreparedStatement 分批次批量提交(`每次提交10000条`)插入
     */
    public static void method3() throws SQLException, ClassNotFoundException {
        List<OrderData> list = getOrderData(1000000);
        String sql = "INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        long begin = System.currentTimeMillis();
        int i = 0;
        for (OrderData orderData : list) {
            ++i;
            ps.setLong(1, orderData.orderNo);
            ps.setLong(2, orderData.userId);
            ps.setLong(3, orderData.shippingId);
            ps.setInt(4, orderData.totalPayment);
            ps.setInt(5, orderData.realPayment);
            ps.setInt(6, orderData.paymentType);
            ps.setInt(7, orderData.postage);
            ps.setInt(8, orderData.status);
            ps.setDate(9, new java.sql.Date(orderData.paymentTime.getTime()));
            ps.setDate(10, new java.sql.Date(orderData.sendTime.getTime()));
            ps.setDate(11, new java.sql.Date(orderData.endTime.getTime()));
            ps.setDate(12, new java.sql.Date(orderData.createTime.getTime()));
            ps.addBatch();
            if (i % 10000 == 0) {
                ps.executeBatch();
                i = 0;
            }
        }
        if (i > 0) {
            ps.executeBatch();
        }
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        ps.close();
        connection.close();
    }


    /**
     * 使用 PreparedStatement 多线程批量提交插入(`使用最大线程数为16的线程池,每个线程操作5000条数据`)
     */
    public static void method4() throws InterruptedException {
        List<OrderData> list = getOrderData(1000000);
        String sql = "INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        ExecutorService service = Executors.newFixedThreadPool(16);
        List<List<OrderData>> partition = Lists.partition(list, 5000);
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        long begin = System.currentTimeMillis();
        for (List<OrderData> dataList : partition) {
            Thread thread = new Thread(() -> {
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    connection = getConnection();
                    ps = connection.prepareStatement(sql);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    for (OrderData orderData : dataList) {

                        ps.setLong(1, orderData.orderNo);
                        ps.setLong(2, orderData.userId);
                        ps.setLong(3, orderData.shippingId);
                        ps.setInt(4, orderData.totalPayment);
                        ps.setInt(5, orderData.realPayment);
                        ps.setInt(6, orderData.paymentType);
                        ps.setInt(7, orderData.postage);
                        ps.setInt(8, orderData.status);
                        ps.setDate(9, new java.sql.Date(orderData.paymentTime.getTime()));
                        ps.setDate(10, new java.sql.Date(orderData.sendTime.getTime()));
                        ps.setDate(11, new java.sql.Date(orderData.endTime.getTime()));
                        ps.setDate(12, new java.sql.Date(orderData.createTime.getTime()));
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    ps.close();
                    connection.close();
                    countDownLatch.countDown();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            service.submit(thread);
        }
        countDownLatch.await();
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        service.shutdown();

    }


    /**
     * 使用 PreparedStatement 拼接为1条sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...)
     */
    public static void method5() throws SQLException, ClassNotFoundException {
        List<OrderData> list = getOrderData(1000000);
        StringBuilder sql = new StringBuilder(2000000);
        sql.append("INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) VALUES ");
        Connection connection = getConnection();
        list.forEach(v -> {
            sql.append("(?,?,?,?,?,?,?,?,?,?,?,?),");
        });
        PreparedStatement ps = connection.prepareStatement(sql.substring(0, sql.length() - 1));
        long begin = System.currentTimeMillis();
        int index = 1;
        for (OrderData orderData : list) {
            ps.setLong(index++, orderData.orderNo);
            ps.setLong(index++, orderData.userId);
            ps.setLong(index++, orderData.shippingId);
            ps.setInt(index++, orderData.totalPayment);
            ps.setInt(index++, orderData.realPayment);
            ps.setInt(index++, orderData.paymentType);
            ps.setInt(index++, orderData.postage);
            ps.setInt(index++, orderData.status);
            ps.setDate(index++, new java.sql.Date(orderData.paymentTime.getTime()));
            ps.setDate(index++, new java.sql.Date(orderData.sendTime.getTime()));
            ps.setDate(index++, new java.sql.Date(orderData.endTime.getTime()));
            ps.setDate(index++, new java.sql.Date(orderData.createTime.getTime()));
        }
        ps.execute();
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        ps.close();
        connection.close();
    }


    /**
     * 使用 PreparedStatement 多线程拼接sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...) (`使用最大线程数为16的线程池,每个线程操作5000条数据`)
     */
    public static void method6() throws InterruptedException {
        List<OrderData> list = getOrderData(1000000);
        ExecutorService service = Executors.newFixedThreadPool(16);
        List<List<OrderData>> partition = Lists.partition(list, 1000);
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        long begin = System.currentTimeMillis();
        for (List<OrderData> dataList : partition) {
            Thread thread = new Thread(() -> {
                StringBuilder sql = new StringBuilder(200000);
                sql.append("INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) VALUES ");
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    connection = getConnection();
                    dataList.forEach(v -> {
                        sql.append("(?,?,?,?,?,?,?,?,?,?,?,?),");
                    });
                    ps = connection.prepareStatement(sql.substring(0, sql.length() - 1));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    int index = 1;
                    for (OrderData orderData : dataList) {

                        ps.setLong(index++, orderData.orderNo);
                        ps.setLong(index++, orderData.userId);
                        ps.setLong(index++, orderData.shippingId);
                        ps.setInt(index++, orderData.totalPayment);
                        ps.setInt(index++, orderData.realPayment);
                        ps.setInt(index++, orderData.paymentType);
                        ps.setInt(index++, orderData.postage);
                        ps.setInt(index++, orderData.status);
                        ps.setDate(index++, new java.sql.Date(orderData.paymentTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.sendTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.endTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.createTime.getTime()));
                    }
                    ps.execute();
                    ps.close();
                    connection.close();
                    countDownLatch.countDown();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            service.submit(thread);
        }
        countDownLatch.await();
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        service.shutdown();

    }

    /**
     * 使用 PreparedStatement 使用线程池多线程拼接sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...) (`使用最大线程数为16的线程池,每个线程操作5000条数据`)
     */
    public static void method7() throws InterruptedException {
        List<OrderData> list = getOrderData(1000000);
        ExecutorService service = Executors.newFixedThreadPool(16);
        List<List<OrderData>> partition = Lists.partition(list, 1000);
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        long begin = System.currentTimeMillis();
        for (List<OrderData> dataList : partition) {
            Thread thread = new Thread(() -> {
                StringBuilder sql = new StringBuilder(200000);
                sql.append("INSERT INTO t_order (order_no,user_id,shipping_id,total_payment,real_payment,payment_type,postage,`status`,payment_time,send_time,end_time,create_time) VALUES ");
                Connection connection = null;
                PreparedStatement ps = null;
                try {
                    connection = DATA_SOURCE.getConnection();
                    dataList.forEach(v -> {
                        sql.append("(?,?,?,?,?,?,?,?,?,?,?,?),");
                    });
                    ps = connection.prepareStatement(sql.substring(0, sql.length() - 1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    int index = 1;
                    for (OrderData orderData : dataList) {

                        ps.setLong(index++, orderData.orderNo);
                        ps.setLong(index++, orderData.userId);
                        ps.setLong(index++, orderData.shippingId);
                        ps.setInt(index++, orderData.totalPayment);
                        ps.setInt(index++, orderData.realPayment);
                        ps.setInt(index++, orderData.paymentType);
                        ps.setInt(index++, orderData.postage);
                        ps.setInt(index++, orderData.status);
                        ps.setDate(index++, new java.sql.Date(orderData.paymentTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.sendTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.endTime.getTime()));
                        ps.setDate(index++, new java.sql.Date(orderData.createTime.getTime()));
                    }
                    ps.execute();
                    ps.close();
                    connection.close();
                    countDownLatch.countDown();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            service.submit(thread);
        }
        countDownLatch.await();
        System.out.println("--总耗时 = " + (System.currentTimeMillis() - begin) + "ms");
        service.shutdown();

    }

    private static List<OrderData> getOrderData(int num) {
        List<OrderData> list = new ArrayList<>(num);
        while (num-- > 0) {
            OrderData orderData = new OrderData();
            orderData.setOrderNo(System.currentTimeMillis());
            orderData.setUserId((long) num);
            orderData.setShippingId((long) num);
            orderData.setTotalPayment(num * 3);
            orderData.setRealPayment(num * 2);
            orderData.setPaymentType(1);
            orderData.setPostage(num / 2);
            orderData.setStatus(num % 6);
            Calendar calendar = Calendar.getInstance();
            orderData.setCreateTime(calendar.getTime());
            calendar.add(Calendar.MINUTE, 3);
            orderData.setPaymentTime(calendar.getTime());
            calendar.add(Calendar.HOUR, 2);
            orderData.setSendTime(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 2);
            orderData.setEndTime(calendar.getTime());
            list.add(orderData);
        }
        return list;
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String address = "jdbc:mysql://localhost:3306/wjchenge_test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(address, user, password);
    }

    @Data
    public static class OrderData {
        private Long id;
        private Long orderNo;
        private Long userId;
        private Long shippingId;
        private Integer totalPayment;
        private Integer realPayment;
        private Integer paymentType;
        private Integer postage;
        private Integer status;
        private Date paymentTime;
        private Date sendTime;
        private Date endTime;
        private Date createTime;
    }

}
