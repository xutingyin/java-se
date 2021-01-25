package cn.xutingyin.math;

import java.math.BigDecimal;

/**
 * 精度的使用
 */
public class BigDecimalDemo2 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("2.246");
        System.out.println(b1.setScale(1,BigDecimal.ROUND_DOWN));
        System.out.println(b1.setScale(1,BigDecimal.ROUND_HALF_DOWN));

        System.out.println(b1.setScale(1,BigDecimal.ROUND_UP));
        System.out.println(b1.setScale(1,BigDecimal.ROUND_HALF_UP));


    }
}
