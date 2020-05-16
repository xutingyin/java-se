package cn.xutingyin.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @description: 通过反射获取字段属性
 * @author: Tingyin.Xu
 * @date: 2020/5/15 9:54
 */

public class Relection_GetFiled {
    public static void main(String[] args) throws Exception {
        Class<Student> stuClass = Student.class;
        // 获取public 属性
        System.out.println(stuClass.getField("score"));
        // 获取继承父类的public 属性
        // System.out.println(stuClass.getField("name"));
        // 获取private 属性
        System.out.println(stuClass.getDeclaredField("grade"));
        Field name = stuClass.getField("name");
        // getField 会返回一个Field 对象，该对象包含了一个字段的所有信息,常用的如下
        // 字段名
        System.out.println(name.getName());
        // 字段类型
        System.out.println(name.getType());
        // 字段修饰符 getModifiers 返回不同的数字，代表不用的修饰符，对应关系
        System.out.println(name.getModifiers());
        int modifiers = name.getModifiers();
        System.out.println("Modifier.isPublic:" + Modifier.isPublic(modifiers));
        System.out.println("Modifier.isPrivate:" + Modifier.isPrivate(modifiers));
        System.out.println("Modifier.isProtected:" + Modifier.isProtected(modifiers));
        System.out.println("Modifier.isFinal:" + Modifier.isFinal(modifiers));
        System.out.println("Modifier.isStatic:" + Modifier.isStatic(modifiers));

        // 获取属性的值
        Person p = new Person();
        p.setSex(1);
        // 正常情况下，Main类无法访问Person类的private字段。要修复错误，可以将private改为public，或者，在调用Object value =
        // f.get(p);前，先写一句：f.setAccessible(true);调用Field.setAccessible(true)的意思是，别管这个字段是不是public，一律允许访问。
        Field nameFiled = p.getClass().getDeclaredField("sex");
        nameFiled.setAccessible(true);
        Object name_value = nameFiled.get(p);
        System.out.println(name_value);

    }
}
