package cn.xutingyin.se011;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @description: ArrayList 源码分析
 * @author: xuty
 * @date: 2020/6/1 9:05
 */

public class ArrayListSource {
    public static void main(String[] args) {
        Random random = new Random();
        Map map = new HashMap();
        map.put("1", random.nextInt(10));
        map.put("2", random.nextInt(10));
        HashMap hashMap = new HashMap(map);

        hashMap.putIfAbsent("3", 5);
        hashMap.put("4", 5);
        hashMap.put("4", 10);
        hashMap.put(null, 10);
        hashMap.put(null, null);
        hashMap.forEach((k, v) -> {
            System.out.println(k + "--" + v);
        });

        for (int i = 0; i < 5; i++) {
            System.out.print(i + "= ");
        }
        for (int i = 0; i < 5; ++i) {
            System.out.print(i + "<> ");
        }
    }

}
