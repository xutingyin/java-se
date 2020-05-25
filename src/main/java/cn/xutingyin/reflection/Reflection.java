package cn.xutingyin.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @description: 反射测试类
 * @author: Tingyin.Xu
 * @date: 2020/5/15 9:11
 */

public class Reflection {
    public static void main(String[] args) throws Exception {
        // ----------------- 获取Class对象------------------
        Class<Integer> integerClass = int.class;
        Class<String[]> aClass1 = String[].class;
        Class<? extends String> aClass = "".getClass();
        Class<Math> mathClass = Math.class;
        // ------------------自定义类----------------------
        Class<Student> studentClass = Student.class;
        // 在只知道字符串，不知道类型的情况下的获取方式
        Class<?> stuClass = Class.forName("cn.xutingyin.reflection.Student");
        // printClassInfo(integerClass);
        // printClassInfo(aClass1);
        // printClassInfo(aClass);
        // printClassInfo(mathClass);
        printClassInfo(stuClass);

        // --------------- 通过反射获取Object的所有方法名-------
        Method[] methods = Object.class.getMethods();
        System.out.println("---------------------");
        for (Method m : methods) {
            System.out.println(m.getName());
        }
        // --------------------- 获取修饰符--------------------
        /**
         * 可以通过getModifiers()返回的数值类型，结合Modifier提供的静态判断方法来判断修饰符的类型 Modifier.isAbstract(int modifiers);
         * Modifier.isFinal(int modifiers); Modifier.isInterface(int modifiers); Modifier.isNative(int modifiers);
         * Modifier.isPrivate(int modifiers); Modifier.isProtected(int modifiers); Modifier.isPublic(int modifiers);
         * Modifier.isStatic(int modifiers); Modifier.isStrict(int modifiers); Modifier.isSynchronized(int modifiers);
         * Modifier.isTransient(int modifiers); Modifier.isVolatile(int modifiers);
         */
        int modifiers = stuClass.getModifiers();
        System.out.println("isFinal : " + Modifier.isFinal(modifiers));
        // --------------------------获取包信息-------------------
        System.out.println(stuClass.getPackage());

        // --------------------------获取父类信息------------------
        System.out.println("super Class:" + stuClass.getSuperclass());
        // --------------------------获取注解信息------------------

        Annotation[] annotations = stuClass.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        // --------------------------获取构造器信息------------------
        Constructor<?>[] constructors = stuClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor: " + constructor);
            // 通过构造器创建对象
            Student student = (Student)constructor.newInstance();
            student.setName("一沐");
            System.out.println(student);
        }
        // --------------------------获取属性信息------------------
        // 获取public 修饰的属性 如果不存在该属性，或者不是public 修饰的属性则抛异常NoSuchFieldException
        Field score = stuClass.getField("score");
        System.out.println(score.getName());

        // --------------------------获取方法信息------------------
        System.out.println("--------------------------获取方法信息------------------");
        // 返回所有public修饰的方法，包含父类的
        Method[] methods1 = stuClass.getMethods();
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        // 获取public 修饰的方法，如果没有该方法或者非public 的，则会抛异常NoSuchMethodException
        Method play = stuClass.getMethod("play", String.class);
        System.out.println(play.getName());
        // 非静态方法，第一个参数需要传递一个实例对象
        play.invoke(stuClass.newInstance(), "ping-pong");
        Method show = stuClass.getMethod("show", new Class[] {int.class});
        // 如果是静态方法，则第一个参数，不用传
        show.invoke(null, 20);

        // --------------------------获取 getter、setter 方法------------------
        // TODO

    }

    static void printClassInfo(Class cls) {
        // getName包含包名
        System.out.println("Class name :" + cls.getName());
        // getSimpleName不包含包名，仅仅类名
        System.out.println("Simple name :" + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name:" + cls.getPackage());
        }
        System.out.println("Is enum:" + cls.isEnum());
        System.out.println("Is interface:" + cls.isInterface());
        System.out.println("Is array:" + cls.isArray());
        System.out.println("Is primitive:" + cls.isPrimitive());

    }
}
