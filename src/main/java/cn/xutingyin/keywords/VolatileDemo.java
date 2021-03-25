package cn.xutingyin.keywords;

import java.util.concurrent.atomic.AtomicInteger;

/*
 *
 * 功能描述：volatile 关键字使用
 * @author TingYin.Xu
 * @date 2021/1/26 14:00
 *
 */
public class VolatileDemo {

    private volatile  String MY_NAME = "B";

    public static void main(String[] args) throws Exception {
        for(int i= 0 ;i< 10000;i++){
            Thread.sleep(1000);
            System.out.println(i);
        }


    }
}
