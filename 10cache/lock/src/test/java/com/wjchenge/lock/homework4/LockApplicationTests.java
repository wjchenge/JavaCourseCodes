package com.wjchenge.lock.homework4;

import com.wjchenge.lock.homework4.RedisLockV1;
import com.wjchenge.lock.homework4.RedisLockV2;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
public class LockApplicationTests {

    @Autowired
    private RedisLockV1 redisLockV1;

    @Autowired
    private RedisLockV2 redisLockV2;

    /**
     * 测试分布式锁v1加锁、解锁过程
     */
    @Test
    public void testRedisLockV1() {
        boolean testLock1 = redisLockV1.getLock("testLock1");
        boolean testLock2 = redisLockV1.getLock("testLock2");
        boolean testUnLock1 = redisLockV1.unLock("testLock1");
        boolean testUnLock2 = redisLockV1.unLock("testLock2");
        MatcherAssert.assertThat(testLock1, is(true));
        MatcherAssert.assertThat(testLock2, is(false));
        MatcherAssert.assertThat(testUnLock1, is(true));
        MatcherAssert.assertThat(testUnLock2, is(false));
    }


    /**
     * 测试分布式锁v1的可重入性
     */
    @Test
    public void testRedisLockV1ForReentrant() {

        boolean testLock1 = redisLockV1.getLock("testLock1");
        boolean testLock2 = redisLockV1.getLock("testLock1");
        boolean testUnLock1 = redisLockV1.unLock("testLock1");
        MatcherAssert.assertThat(testLock1, is(true));
        MatcherAssert.assertThat(testLock2, is(false));
        MatcherAssert.assertThat(testUnLock1, is(true));
    }


    /**
     * 测试分布式锁v2加锁、解锁过程
     * 模拟多线程规避锁重入问题
     */
    @Test
    public void testRedisLockV2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            RLock testLock1 = redisLockV2.getLock();
            System.out.println("testLock1 = " + testLock1);
            countDownLatch.countDown();
        }).start();

        TimeUnit.MILLISECONDS.sleep(1);
        new Thread(() -> {
            long l = System.currentTimeMillis();
            RLock testLock2 = redisLockV2.getLock();
            System.out.println("testLock2 = " + testLock2  + " || 阻塞时长 = " + (System.currentTimeMillis() - l));
            testLock2.unlock();
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
    }


    /**
     * 测试分布式锁v2的可重入性
     */
    @Test
    public void testRedisLockV2ForReentrant() {

        RLock testLock1 = redisLockV2.getLock();
        RLock testLock2 = redisLockV2.getLock();
        System.out.println(testLock1);
        System.out.println(testLock2);
    }

}
