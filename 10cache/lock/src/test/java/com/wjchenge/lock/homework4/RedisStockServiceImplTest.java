package com.wjchenge.lock.homework4;

import com.wjchenge.lock.homework4.StockService;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.CoreMatchers.is;

/**
 * @Author wj
 * @Date 2021/12/6 21:35
 */
@SpringBootTest
public class RedisStockServiceImplTest {

    private static final long SIZE = 10;

    @Autowired
    private StockService stockService;

    @BeforeEach
    public void init() {
        stockService.init(SIZE);
    }

    /**
     * 单线程减库存测试
     */
    @Test
    public void getAndDecrement() {

        long decrement = 0;
        for (int i = 0; i < SIZE + 1; i++) {
            decrement = stockService.getAndDecrement();
        }

        MatcherAssert.assertThat(decrement, is(-1L));

    }

    /**
     * 多线程环境下减库存测试
     * @throws InterruptedException
     */
    @Test
    public void getAndDecrementForMultiThread() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch((int) SIZE);
        ExecutorService threadPool = Executors.newFixedThreadPool((int) SIZE);
        for (int i = 0; i < SIZE; i++) {
            threadPool.execute(()->{
                long decrement = stockService.getAndDecrement();
                System.out.println("-----" + decrement);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        long decrement = stockService.getAndDecrement();
        MatcherAssert.assertThat(decrement, is(-1L));
    }

}