package cn.xutingyin.jvm;

import java.util.ArrayList;
import java.util.List;

class Person {}

/*
 *
 * 功能描述：OutOfMemoryError 测试，VM参数设置：
 *  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 *
 * -XX:+HeapDumpOnOutOfMemoryError  会生成dump 文件
 * @author TingYin.Xu
 * @date 2021/2/20 17:15
 *
 */
public class HelloHeapOutOfMemory {

    public static void main(String[] args) {
        System.out.println("HelloHeapOutOfMemory");
        List<Person> persons = new ArrayList<Person>();
        int counter = 0;
        while (true) {
            persons.add(new Person());
            System.out.println("Instance: " + (++counter));
        }
    }
}