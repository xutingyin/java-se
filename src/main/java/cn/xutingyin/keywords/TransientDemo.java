package cn.xutingyin.keywords;

import java.io.*;

/*
 *
 * 功能描述：transient 关键字的使用
 * 添加了transient关键字的字段不会进行序列化操作
 * @author TingYin.Xu
 * @date 2021/1/26 11:37
 *
 */
public class TransientDemo {
    /**
     * 序列化User对象
     */
    public static void serializeUser() throws  Exception {
        User user = new User("苏三",20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:user.txt"));
        oos.writeObject(user);
        oos.close();
        System.out.println("添加了transient关键字序列化，user = " + user.toString());
    }

    /**
     * 反序列化User对象
     */
    public static void deSerializeUser() throws  Exception{

        File file = new File("user.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User user = (User)ois.readObject();
        System.out.println("添加了transient关键字反序列化，user = " + user.toString());
    }

    public static void main(String[] args) throws  Exception {
        serializeUser();
        deSerializeUser();
    }

}
