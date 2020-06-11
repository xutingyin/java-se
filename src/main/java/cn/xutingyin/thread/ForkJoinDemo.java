package cn.xutingyin.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @description: ForkJoin使用示例
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-06-06 10:20
 **/
public class ForkJoinDemo {
    /**
     * 任务阀值
     */

    private static final int THRESHOLD = 2;

    static class Mc extends RecursiveTask<Long> {
        Long sum = Long.valueOf("0");

        private int begin, end;

        public Mc(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // 任务量小于阀值，直接进行计算
            if ((end - begin) <= THRESHOLD) {
                for (int i = begin; i < end; i++) {
                    sum += i;

                }
            } else {
                // 任务拆分为两个
                int mid = (begin + end) / 2;
                Mc left = new Mc(begin, mid);
                left.fork();
                Mc right = new Mc(mid, end);
                right.fork();
                Long l = left.join();
                Long r = right.join();
                sum = r + l;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建他的线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 在线程池中进行计算
        Future<Long> ft = forkJoinPool.submit(new Mc(0, 101));

        System.out.println("计算的结果是：" + ft.get());

        forkJoinPool.shutdown();// 关闭线程池
    }
}
