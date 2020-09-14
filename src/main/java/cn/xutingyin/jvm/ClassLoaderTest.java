package cn.xutingyin.jvm;

/**
 * @description: 类加载器测试
 * @author: xuty
 * @date: 2020/9/14 11:41
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest test1 = new ClassLoaderTest();
        ClassLoaderTest test2 = new ClassLoaderTest();
        System.out.println("两实例是否相等：" + (test1 == test2));
        Class class1 = test1.getClass();
        Class class2 = test1.getClass();
        System.out.println("class1类加载器：" + class1.getClassLoader());
        System.out.println("class2类加载器：" + class2.getClassLoader());
        System.out.println("class1是否等于class2：" + (class1 == class2));
    }
}
