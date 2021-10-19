import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wj
 * @Date 2021/10/14 15:10
 */
public class Homework {

    /**
     * 方法1 使用 sleep 等待线程执行完成拿到结果
     */
    @Test
    public void method1() {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        new Thread(() -> {
            result.set(sum());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


    /**
     * 方法2 使用 join 等待线程执行完成拿到结果
     */
    @Test
    public void method2() {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        AtomicInteger result = new AtomicInteger(); //这是得到的返回值
        Thread thread = new Thread(() -> {
            result.set(sum());
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 方法3 使用 自旋机制 拿到结果
     */
    @Test
    public void method3() {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        AtomicInteger result = new AtomicInteger(-1); //这是得到的返回值
        new Thread(() -> {
            result.set(sum());
        }).start();

        while (result.get() < 0) {
            // 自旋等待结果
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 方法4 使用 Future 拿到结果
     */
    @Test
    public void method4() {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> submit = service.submit(() -> sum());
        Integer result = 0;
        try {
            result = submit.get();
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    /**
     * 方法5 使用 阻塞队列 拿到结果
     */
    @Test
    public void method5() {
        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        new Thread(()-> queue.offer(sum())).start();
        int result = 0; //这是得到的返回值
        try {
            result = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
