package cn.xutingyin.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: 自定义同步器-只允许两个线程进行共享数据的读取
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-10 21:01
 **/
public class TwinsLock implements Lock {

    /**
     * 一般情况下自定义同步器会被定义为自定义同步组件的内部类
     */

    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        /**
         * 获取当前线程同步状态
         * 
         * @param reduceCount
         * @return
         */
        @Override
        public int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }

        }

        @Override
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        sync.releaseShared(1);
    }

    public Condition newCondition() {
        return null;
    }
}
