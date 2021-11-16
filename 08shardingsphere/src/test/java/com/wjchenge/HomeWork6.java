package com.wjchenge;

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
class HomeWork6 {

    @Autowired
    private HomeWork6Service homeWork6Service;

    @BeforeEach
    public void setUp() {
        homeWork6Service.init();
    }

    @Test
    public void assertInsertSuccess() {
        MatcherAssert.assertThat(homeWork6Service.testInsertSuccess(10), is(TransactionType.XA));
        MatcherAssert.assertThat(homeWork6Service.selectAll(), is(10));
    }
    @Test
    public void assertInsertFailed() {

        try {
            homeWork6Service.testInsertFailed(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MatcherAssert.assertThat(homeWork6Service.selectAll(), is(0));
    }

}
