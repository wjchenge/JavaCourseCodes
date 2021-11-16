package com.wjchenge;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author wj
 * @Date 2021/11/15 22:34
 */
@Service
@Import(TransactionConfiguration.class)
public class HomeWork6Service {

    private static final String SQL = "INSERT INTO atomikos_test (user_id) VALUES (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    void init() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS atomikos_test");
        jdbcTemplate.execute("CREATE TABLE `atomikos_test` (\n" +
                "  `id` bigint(20) NOT NULL,\n" +
                "  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',\n" +
                "  PRIMARY KEY (`id`) USING BTREE)");
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType testInsertSuccess(final int count) {
        return jdbcTemplate.execute(SQL, (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            return TransactionTypeHolder.get();
        });
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void testInsertFailed(final int count) {
        jdbcTemplate.execute(SQL, (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            throw new SQLException("mock transaction failed");
        });
    }

    public int selectAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) AS count FROM atomikos_test", Integer.class);
    }

    private void doInsert(final int count, final PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < count; i++) {
            preparedStatement.setObject(1, i);
            preparedStatement.executeUpdate();
        }
    }
}
