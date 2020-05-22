package cn.xutingyin.se005;

/**
 * @description: 存储Unicode编码测试
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-22 21:19
 **/
public class StringUnicode {
    public static void main(String[] args) {
        String str = "你好世界";
        for (int i = 0; i < str.length(); i++) {
            // Hex 十六进制
            // Octal 十六进制
            System.out.print("\\u" + Integer.toHexString(str.charAt(i)));
            // System.out.print("\\o" + Integer.toOctalString(str.charAt(i)));
        }
        System.out.println();
        System.out.println("\u4f60\u597d\u4e16\u754c");
        String hello = "hello";
        for (int i = 0; i < hello.length(); i++) {

            System.out.print("\\u" + Integer.toHexString(str.charAt(i)));
        }
    }
}
