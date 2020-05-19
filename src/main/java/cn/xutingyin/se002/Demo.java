package cn.xutingyin.se002;

/**
 * @description: 各类代码块执行顺序
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-19 22:18
 **/
public class Demo {
    public Demo() {
        System.out.println("构造器代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    {
        // 普通代码块就是实例信息
        System.out.println("普通代码块");
    }

    public static void main(String[] args) {
        new Demo();
    }
}
