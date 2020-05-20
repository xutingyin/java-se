package cn.xutingyin.se003;

/**
 * @description: 类准备、解析、初始化详解
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-20 21:17
 **/
public class Hello {
    /**
     * 类变量 ：用static修饰的变量为类变量，可以通过类名. 的方式直接读取
     */

    private static String name = "susan";
    /**
     * 实例变量：未使用static修饰的变量，需要通过创建类的实例，再利用实例才能访问的变量
     */
    private int age = 10;

    public Hello() {
        this.age = 11;
    }

    public static void main(String[] args) {
        // 可以直接访问
        System.out.println(Hello.name);
        // 这样访问不到---[Non-static field 'age' cannot be referenced from a static context]
        // 在静态方法中不能够访问非静态的成员变量,原因是静态方法是存储到方法区中，而非静态变量需要先创建对象，在堆内存中分配空间，通过实例才能进行访问，直接访问肯定访问不到
        // System.out.println(Hello.age);
    }
}
