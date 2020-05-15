package cn.xutingyin.reflection;

/**
 * @description: 反射，是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。
 * @author: Tingyin.Xu
 * @date: 2020/5/15 9:11
 */

public class Reflection {
    public static void main(String[] args) {
        Class<Integer> integerClass = int.class;
        Class<String[]> aClass1 = String[].class;
        Class<? extends String> aClass = "".getClass();
        Class<Math> mathClass = Math.class;
        printClassInfo(integerClass);
        printClassInfo(aClass1);
        printClassInfo(aClass);
        printClassInfo(mathClass);

    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name :" + cls.getName());
        System.out.println("Simple name :" + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name:" + cls.getPackage());
        }
        System.out.println("Is enum:" + cls.isEnum());
        System.out.println("Is interface:" + cls.isInterface());
        System.out.println("Is array:" + cls.isArray());
        System.out.println("Is primitive:" + cls.isPrimitive());
        System.out.println();
    }
}
