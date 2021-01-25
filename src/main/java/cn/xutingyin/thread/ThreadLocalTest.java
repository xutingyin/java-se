package cn.xutingyin.thread;
/*
 *
 * 功能描述：ThreadLocal的使用
 * ThreadLocal 类允许我们创建只能被同一个线程读写的变量。
 * 因此，如果一段代码含有一个ThreadLocal变量的引用，
 * 即使两个线程同时执行这段代码，它们也无法访问到对方的ThreadLocal变量。
 * @author TingYin.Xu
 * @date 2021/1/25 13:47
 *
 */
public class ThreadLocalTest {

    public static class MyRunnable implements Runnable{
        private ThreadLocal threadLocal = new ThreadLocal();
        @Override
        public void run() {
            threadLocal.set((int)(Math.random()* 100D));
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                threadLocal.remove();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }


}
