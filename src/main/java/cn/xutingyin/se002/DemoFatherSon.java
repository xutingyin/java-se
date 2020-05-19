package cn.xutingyin.se002;

class Father {
    public Father() {
        System.out.println("Father构造器代码块");
    }

    static {
        System.out.println("Father静态代码块");
    }

    {
        // 普通代码块就是实例信息
        System.out.println("Father普通代码块");
    }
}

class Son extends Father {
    public Son() {
        System.out.println("Son构造器代码块");
    }

    static {
        System.out.println("Son静态代码块");
    }

    {
        // 普通代码块就是实例信息
        System.out.println("Son普通代码块");
    }
}

/**
 * @description: 各类代码块执行顺序
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-19 22:18
 **/
public class DemoFatherSon {

    public static void main(String[] args) {
        new Son();
    }
}
