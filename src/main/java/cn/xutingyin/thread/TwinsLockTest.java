package cn.xutingyin.thread;

import java.util.concurrent.locks.Lock;

import org.junit.Test;

/**
 * @description: 自定义同步器测试类
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-10 21:14
 **/
public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        // 每隔一秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.sleep(1);
            System.out.println();
        }
    }
}
