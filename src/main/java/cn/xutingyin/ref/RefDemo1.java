package cn.xutingyin.ref;

/**
 * 参考：https://www.bilibili.com/video/BV1e4411c74g?from=search&seid=8817091401845664039
 * 
 * @description: 值传递
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-05 23:08
 **/
public class RefDemo1 {
    public static void main(String[] args) {
        // 实际参数，实参
        int x = 10;
        System.out.println("修改前：" + x);
        call(x);
        System.out.println("修改后：" + x);
    }

    /**
     * 在方法声明中的的参数为形参
     */
    private static void call(int i) {
        // 此时的i 是实参的一个拷贝，即此时的i不是x真正的值，而是它的一个拷贝
        i = 20;
    }
}
