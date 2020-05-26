package cn.xutingyin.math;

import java.math.BigDecimal;

/**
 * @description: BigDecimal 类型使用注意事项
 * @author: Tingyin.Xu
 * @date: 2020/5/26 16:37
 * 
 */

public class BigdecimalDemo {
    public static void main(String[] args) {
        // 实际上BigDecimal(double) 会出现精度扩展，不是实际的0.1，而是0.1000000000000000055511151231257827021181583404541015625
        BigDecimal b1 = new BigDecimal(0.1);
        BigDecimal b2 = new BigDecimal("0.1");
        BigDecimal b4 = BigDecimal.valueOf(0.1);
        // 返回false
        System.out.println(b1.equals(b2));
        System.out.println(b2.equals(b4));
        BigDecimal b3 = new BigDecimal("500");
        System.out.println(b1.add(b3));
        System.out.println(b2.add(b3));
        // 总结：使用new BigDecimal()时，尽可能转换为String，或者直接使用BigDecimal.valueOf(double)
    }
}
