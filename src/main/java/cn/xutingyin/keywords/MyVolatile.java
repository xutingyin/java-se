package cn.xutingyin.keywords;
import java.util.concurrent.atomic.AtomicInteger;

/*
 *
 * 功能描述： 结果可能不等于200
 * volatile 的作用：
 * ①内存可见性
 * ②禁止指令重排序，
 * volatile 修饰的变量，是直接拿的主内存的值，就是说这个值永远是最新的，对其他线程是可见的。
 * 而访问非 volatile 变量时，每个线程都会从系统内存（主内存）拷贝变量到工作内存中，然后修改工作内存中的变量值，操控的变量可能不同。
 *
 * 在一个变量被 volatile 修饰后，JVM 会为我们做两件事：
 * 在每个 volatile 写操作前插入 StoreStore 屏障，在写操作后插入 StoreLoad 屏障。（StoreStore-写-StoreLoad）
 * 在每个 volatile 读操作前插入 LoadLoad 屏障，在读操作后插入LoadStore屏障。（LoadLoad-读-LoadStore）
 *
 *
 * -------------------------------------------java 内存屏障------------------------------------------------
 *
 * 内存屏障也称为内存栅栏或栅栏指令，是一种屏障指令，它使CPU或编译器对屏障指令之前和之后发出的内存操作执行一个排序约束。
 * 这通常意味着在屏障之前发布的操作被保证在屏障之后发布的操作之前执行。
 * java 的内存屏障通常所谓的四种即LoadLoad,StoreStore,LoadStore,StoreLoad实际上也是上述两种的组合，完成一系列的屏障和数据同步功能。
 * （Load 指令(也就是从内存读取)，Store指令 (也就是写入内存)。）
 *
 * LoadLoad 屏障：对于这样的语句 Load1; LoadLoad; Load2 ，在 Load2 及后续读取操作要读取的数据被访问前，保证Load1 要读取的数据被读取完毕。
 *
 * StoreStore 屏障：对于这样的语句 Store1; StoreStore; Store2 ，在 Store2 及后续写入操作执行前，保证 Store1 的写入操作对其它处理器可见。
 *
 * LoadStore 屏障：对于这样的语句 Load1; LoadStore; Store2 ，在 Store2 及后续写入操作被刷出前，保证 Load1 要读取的数据被读取完毕。
 *
 * StoreLoad 屏障：对于这样的语句 Store1; StoreLoad; Load2 ，在 Load2 及后续所有读取操作执行前，保证 Store1 的写入对所有处理器可见。它的开销是四种屏障中最大的。在大多数处理器的实现中，这个屏障是个万能屏障，兼具其它三种内存屏障的功能
 *
 * ----------------------------------------------------------------------------------------
 * @author TingYin.Xu
 * @date 2021/3/25 11:53
 *
 */
public class MyVolatile {

    private static volatile int count = 0;
//    private static  AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        count++;// count ++ 不是原子操作，volatile 不能保证线程安全 ，解决方案有两种，一种是使用synchronized 关键字，另一种是使用JUC中的原子类
//                        count.incrementAndGet();// count ++ 不是原子操作，volatile 不能保证线程安全
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
//        System.out.println(count.get());
    }

}