package cn.xutingyin.math;

public class LongAndInteger {
    private final  static  Integer DEFAULT_VALUE = 0;
    public static void main(String[] args) {
        Long studentCount = 0L;
        System.out.println(studentCount.equals(DEFAULT_VALUE)); // false
        System.out.println(studentCount.intValue() == studentCount); //true
    }
}
