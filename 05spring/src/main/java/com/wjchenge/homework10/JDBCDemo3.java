package com.wjchenge.homework10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCDemo3 {

    @Autowired
    private DataSource dataSource;

    public void insertData() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO test_1025(`name`, age) VALUES (?, ?)";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "wjchenge");
        statement.setInt(2, 30);
        statement.execute();
        statement.close();
        connection.close();
    }

    public List<Data> getData() throws SQLException, ClassNotFoundException {
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

    public void updateData() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE test_1025 SET name = ? WHERE name = ?";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"KK04");
        statement.setString(2,"KK03");
        statement.execute();
        statement.close();
        connection.close();
    }

    public void deleteData() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM test_1025 WHERE name = ?";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"wjchenge");
        statement.execute();
        statement.close();
        connection.close();
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    @lombok.Data
    public static class Data {
        private Long id;

        private String name;

        private Integer age;
    }


}
