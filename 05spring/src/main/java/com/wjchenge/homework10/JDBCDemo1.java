package com.wjchenge.homework10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo1 {

    public static void insertData() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO test_1025(`name`, age) VALUES ('wjchenge', 30)";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    public static List<Data> getData() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id, `name`, age FROM test_1025";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Data> list = new ArrayList<>();
        while (resultSet.next()) {
            Data data = new Data();
            data.setId(resultSet.getLong("id"));
            data.setName(resultSet.getString("name"));
            data.setAge(resultSet.getInt("age"));
            list.add(data);
        }

        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }

    public static void updateData() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE test_1025 SET name = 'KK04' WHERE name = 'KK03'";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    public static void deleteData() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM test_1025 WHERE name = 'wjchenge'";

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String address = "jdbc:mysql://localhost:3306/wjchenge_test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(address, user, password);
    }

    @lombok.Data
    public static class Data {
        private Long id;

        private String name;

        private Integer age;
    }


}
