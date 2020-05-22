package cn.xutingyin.volatilep;

public class VolatileTest {
    private static volatile byte b;
    private static char c;
    private static int age;
    private static float f;
    private static double d;
    private static boolean bool;
    private static short s;
    private static long l;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public static void main(String[] args) {
        System.out.println("susan");
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.setName("sus");
    }
}
