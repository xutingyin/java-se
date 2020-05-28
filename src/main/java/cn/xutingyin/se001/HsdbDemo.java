package cn.xutingyin.se001;

/**
 * @description:HSDB(HotSpot Debugger)
 * @author: Tingyin.Xu
 * @date: 2020/5/27 9:57
 */

public class HsdbDemo {
    public static void main(String[] args) {
        HsdbDemo lockBean = new HsdbDemo();
        synchronized (lockBean) {
            try {
                Thread.sleep(1000000000000000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
