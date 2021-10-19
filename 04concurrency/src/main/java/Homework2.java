import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wj
 * @Date 2021/10/15 11:37
 */
public class Homework2 {


    /**
     * 方法1 使用 wait notify/notifyAll 机制拿到结果
     */
    @Test
    public void test1() throws InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        final Object object = new Object();
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        new Thread(() -> {
            result.set(sum1(object));
        }).start();
        synchronized (object) {
            object.wait(TimeUnit.SECONDS.toMillis(1));
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 使用 wait notify/notifyAll 机制拿到结果
     * @param object
     * @return
     */
    private int sum1(Object object) {
        int result;
        synchronized (object) {
            result = fibo(36);
            object.notify();
        }

        return result;
    }


    /**
     * 方法2 使用 await signal/signalAll 机制拿到结果
     */
    @Test
    public void test2() throws InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        new Thread(() -> {
            result.set(sum2(lock, condition));
        }).start();
        lock.lock();
        condition.await(1, TimeUnit.SECONDS);
        lock.unlock();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 使用 await signal/signalAll 机制拿到结果
     * @param lock
     * @param condition
     * @return
     */
    private int sum2(Lock lock, Condition condition) {
        lock.lock();
        int result = fibo(36);
        condition.signal();
        lock.unlock();
        return result;
    }

    /**
     *  方法3 使用 CountDownLatch 机制拿到结果
     */
    @Test
    public void test3() throws InterruptedException {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        new Thread(() -> {
            result.set(sum3(countDownLatch));
        }).start();
        countDownLatch.await(1, TimeUnit.SECONDS);
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 使用 CountDownLatch 机制拿到结果
     * @param countDownLatch
     * @return
     */
    private int sum3(CountDownLatch countDownLatch) {
        int result = fibo(36);
        countDownLatch.countDown();
        return result;
    }

    /**
     * 方法4 使用 LockSupport 机制拿到结果
     */
    @Test
    public void test4() {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        final Thread thread = Thread.currentThread();
        new Thread(() -> {
            result.set(sum4(thread));
        }).start();
        // 确保  拿到result 并输出
        LockSupport.park();
        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 使用 LockSupport 机制拿到结果
     * @param thread
     * @return
     */
    private int sum4(Thread thread) {
        int result = fibo(36);
        LockSupport.unpark(thread);
        return result;
    }

    /**
     * 方法5 使用 CyclicBarrier + ThreadLocal 机制拿到结果
     */
    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+threadLocal.get());

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        });
        new Thread(() -> {
            sum5(cyclicBarrier, threadLocal);
        }).start();

        // 然后退出main线程
    }

    /**
     * 使用 CyclicBarrier + ThreadLocal 机制拿到结果
     * @param cyclicBarrier
     * @param threadLocal
     * @return
     */
    private static void sum5(CyclicBarrier cyclicBarrier, ThreadLocal<Integer> threadLocal) {
        int result = fibo(36);
        try {
            threadLocal.set(result);
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


}
