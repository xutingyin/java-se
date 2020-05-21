package cn.xutingyin.se004;

import lombok.Data;

/**
 * @description: 火车站
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-21 23:17
 **/
@Data
public class RailwayStation {
    private String name;
    private String location;

    public TrainTicket saleTicket() {
        return new TrainTicket();
    }

    public boolean checkTicket() {
        return true;
    }
}
