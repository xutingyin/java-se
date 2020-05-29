package cn.xutingyin.se010;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description: ArrayList
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-29 20:28
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        // 错误的删除方式
        for (Object o : arrayList) {
            // java.util.ConcurrentModificationException
            if (o.equals(1)) {
                arrayList.remove(o);
            }
        }

        // 正确方式1
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i).equals(1)) {
                arrayList.remove(i);
            }
        }
        arrayList.forEach(out -> {
            System.out.println("---" + out);
        });

        // 正确的方式3
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals(1)) {
                iterator.remove();
            }
        }
        arrayList.forEach(out -> {
            System.out.println("---" + out);
        });
    }
}
