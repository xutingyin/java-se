package cn.xutingyin.jvm;

public class HelloStackOverFlow {
    private static int counter;

    public void count() {

        System.out.println("the stack frame depth is : " + (++counter));

        count();
    }

    public static void main(String[] args) {
        // -verbose:gc -Xms10M -Xmx10M -Xss105k -XX:+PrintGCDetails
        System.out.println("HelloStackOverFlow");
        HelloStackOverFlow helloStackOverFlow = new HelloStackOverFlow();
        try {
            helloStackOverFlow.count();
        } catch (Exception e) {
            System.out.println("the stack frame depth is : " + (++counter));
            e.printStackTrace();
            throw e;
        }

    }

}