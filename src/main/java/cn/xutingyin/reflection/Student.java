package cn.xutingyin.reflection;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Student extends Person {
    public int score;
    private int grade;

    public void play(String str) {
        System.out.println("play ".concat(str));
    }

    public static void show(int age) {
        System.out.println("show " + (age));
    }
}
