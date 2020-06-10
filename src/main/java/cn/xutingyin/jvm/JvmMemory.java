package cn.xutingyin.jvm;

public class JvmMemory {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("maxMemory:" + byte2Mb(runtime.maxMemory()));
        System.out.println("freeMemory:" + byte2Mb(runtime.freeMemory()));
        System.out.println("totalMemory:" + byte2Mb(runtime.totalMemory()));
    }

    public static long byte2Mb(long byteLength) {
        return byteLength / 1024 / 1024;
    }
}
