package cn.xutingyin.se005;

/**
 * @description: == 和equals
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-22 21:56
 **/
public class EqualsDemo {
    public static void main(String[] args) {
        Integer integer1 = 127;
        Integer integer2 = 127;
        // true
        System.out.println(integer1 == integer2);
        integer1 = 129;
        integer2 = 129;
        // false
        System.out.println(integer1 == integer2);

        System.out.println(integer1.equals(integer2));

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        // intern 方法返回的是常量池字面值的地址。如果常量池里面没有该字面值，首先会把这个字面值放到常量表中，然后返回常量表的地址。
        System.out.println(str1 == str3.intern());

    }
}
