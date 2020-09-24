package cn.xutingyin.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: Executors 的使用DEMO
 * @author: xuty
 * @date: 2020/9/24 15:19
 */

public class ExecutorsDemo {
    public static void main(String[] args) {
        // 创建工作窃取线程池，JDK1.8开始才有
        ExecutorService executorService = Executors.newWorkStealingPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        executorService.execute(new Task(100));
        executorService.execute(new Task(200));
        executorService.execute(new Task(300));
        executorService.execute(new Task(400));
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("test2.........");
            }
        });
        executorService.shutdown();
        executorService1.shutdown();
        while (true) {
        }
    }

    static class Task implements Runnable {
        int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
