package cn.xutingyin.se004;

import lombok.Data;

/**
 * @description: 火车
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-21 23:22
 **/
@Data
public class Train {
    private String name;
    private String trainNumber;

    public boolean run() {
        return true;
    }

    public boolean stop() {
        return true;
    }

}
