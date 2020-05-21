package cn.xutingyin.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description: 睡眠工具类
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-10 21:23
 **/
public class SleepUtils {
    public static void sleep(long seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
