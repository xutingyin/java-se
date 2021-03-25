package cn.xutingyin.keywords;

/*
 *
 * 功能描述： 结果可能不等于200
 * @author TingYin.Xu
 * @date 2021/3/25 11:53
 *
 */
public class MyVolatile {

    private static volatile int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        count++;
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
    
}