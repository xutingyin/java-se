package cn.xutingyin.se006;

import java.io.*;

class A implements Serializable {
    int a = 1;
    transient int b = 2;

    // @Override
    // public void writeExternal(ObjectOutput out) throws IOException {
    // System.out.println("writeExternal 进来了");
    // out.writeObject(new A(1));
    // out.writeUTF("dddd");
    // }
    //
    // @Override
    // public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    // System.out.println("readExternal 进来了");
    //
    // }
}

/**
 * @description: 集合Demo
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-23 21:40
 **/
public class IoOperateDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        // 如果A不实现Serializable接口，则会报java.io.NotSerializableException 异常
        outputStream.writeObject(new A());
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        A o = (A)inputStream.readObject();
        // 输入a的值为2
        System.out.println(o.a);
        // 输出b的值，默认为JVM定义int类型的零值 -0 ； 这里加了transient 关键字，则不会进行序列化，
        System.out.println(o.b);
        inputStream.close();

    }
}
