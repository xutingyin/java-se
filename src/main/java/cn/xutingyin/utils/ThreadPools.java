package cn.xutingyin.utils;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * 线程池工具类
 */
public class ThreadPools {
    public ThreadPools() {
    }

    public static ExecutorService getExecutorService() {
        //处理器数量
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = availableProcessors * 4;
        int queueCapacity = availableProcessors * 100;
        long keepAliveTime = 60L;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue(queueCapacity);
        ExecutorService executor = new ThreadPoolExecutor(availableProcessors, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.DiscardPolicy());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (Objects.nonNull(executor)) {
                executor.shutdown();
            }

        }));
        return executor;
    }

    public static ExecutorService getExecutorService4CallerRunsPolicy() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int maximumPoolSize = availableProcessors * 4;
        int queueCapacity = availableProcessors * 100;
        long keepAliveTime = 60L;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue(queueCapacity);
        ExecutorService executor = new ThreadPoolExecutor(availableProcessors, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (Objects.nonNull(executor)) {
                executor.shutdown();
            }

        }));
        return executor;
    }
}