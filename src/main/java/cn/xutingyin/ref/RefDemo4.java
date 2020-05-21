package cn.xutingyin.ref;

/**
 * @description: 证明Java中只有值传递，不存在引用传递 可以看到两次输出的结果是一样的，所以不存在引用传递
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-05 23:29
 **/
public class RefDemo4 {
    public static void main(String[] args) {
        Person person = new Person(18, "lisa");
        System.out.println("调用前：" + person);
        call(person);
        System.out.println("调用后：" + person);

    }

    private static void call(Person person) {
        person = new Person(20, "susan");
    }
}
