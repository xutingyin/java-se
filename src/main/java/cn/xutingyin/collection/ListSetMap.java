package cn.xutingyin.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:List、Set、Map之间的相互转换
 * @author: xuty
 * @date: 2020/9/22 8:55
 */

public class ListSetMap {
    // ---------------------JDK8之前-------------------------------
    public static void mapConvertBeforeJdk8() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "test1");
        map.put("2", "test2");
        // map 转 set
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 或者 map 转 set
        Set sets = new HashSet(map.values());
        // map 转 list
        List arrayList = new ArrayList(map.values());


    }

    public static void listConvertBeforeJdk8() {
        List<User> list = new ArrayList(16);
        list.add(new User(1L, "susan", 20));
        list.add(new User(2L, "lisa", 20));
        // list 转 set
        Set set = new HashSet(list);
        // list 转 map 可以转，但是需要想好使用什么作为key
        Map<Long, User> userMap = new HashMap<>(16);
        for (User user : list) {
            userMap.put(user.getId(), user);
        }
    }

    public static void setConvertBeforeJdk8() {
        Set<User> set = new HashSet(16);
        set.add(new User(1L, "susan", 20));
        set.add(new User(2L, "lisa", 20));
        // set 转 list
        List list = new ArrayList(set);
        // set 转 map
        Map<Long, User> map = new HashMap<>(16);
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            map.put(user.getId(), user);
        }

    }

    // -----------------------------JDK8之后---------------------------------
    public static void mapConvertAfterJdk8(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "test1");
        map.put("2", "test2");
//        map 转set
        Set<Map.Entry<String, String>> set = map.entrySet().stream().collect(Collectors.toSet());
        System.out.println(set);

        List<String> list = map.values().stream().collect(Collectors.toList());
        System.out.println(list);
//        map 转 list
    }
    public static void listConvertAfterJdk8() {
        List<User> list = new ArrayList(16);
        list.add(new User(1L, "susan", 20));
        list.add(new User(2L, "lisa", 20));
        // list 转 map
        Map<Long, User> maps = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        // list 转 set
        Set<User> collect = list.stream().collect(Collectors.toSet());
    }

    public static void setConvertAfterJdk8() {
        Set<User> set = new HashSet(16);
        set.add(new User(1L, "susan", 20));
        set.add(new User(2L, "lisa", 20));
        // set 转 map
        Map<Long, User> maps = set.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        // set 转 set
        List<User> list = set.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        mapConvertAfterJdk8();
    }
}
