package cn.xutingyin.ref;

/**
 * @description: String, Integer 等不可变类传递
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-05 23:26
 **/
public class RefDemo3 {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("修改前：" + str);
        call(str);
        System.out.println("修改后：" + str);

    }

    static void call(String str) {
        str = "hi";
    }
}
