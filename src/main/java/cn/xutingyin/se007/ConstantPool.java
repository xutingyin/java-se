package cn.xutingyin.se007;

/**
 * @description: 常量池原理
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-26 20:12
 **/
public class ConstantPool {
    public static void main(String[] args) {
        String str1 = "hellopp";
        String str2 = "hello";
        String str3 = str2 + "pp";
        String str4 = "hello" + "pp";
        // false
        System.out.println(str1 == str3);
        // true
        System.out.println(str1 == str3.intern());
        // true
        System.out.println(str1 == str4);
    }
}
