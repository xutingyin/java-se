package cn.xutingyin.se004;

import lombok.Data;

/**
 * @description: 一沐
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-21 23:09
 **/
@Data
public class YiMu {
    /**
     * 属性
     */
    private String name;
    private int idCard;
    private String phone;

    /**
     * 行为
     */
    // 去火车站
    public boolean goToStation() {
        return true;
    }

    // 进站
    public boolean enterStation() {
        return true;
    }

    // 买票
    public boolean buyTicket() {
        return true;
    }

    // 上车
    public boolean upTrain() {
        return true;
    }

    // 下车
    public boolean downTrain() {
        return true;
    }

    // 出站
    public boolean outStation() {
        return true;
    }

}
