package cn.xutingyin.utils;

import java.time.*;
import java.util.Date;

/*
 *
 * 功能描述：Date 与LocalDate的相互转换
 * 整体思路：通过Instant和ZoneId进行Date和LocalDateTime的相互转换
 * 1、Date 转 LocalDate 之间的相互转换：
 *      获取到LocalDateTime之后，便可以获取LocalDate、LocalTime
 * 2、LocalDate 转 Date
 *
 * @author TingYin.Xu
 * @date 2020/12/14 17:20
 *
 */
public class DateTransLocalDateUtil {
    /*
     * @description: Date转换为LocalDate
     * @param: [date]
     * @return: java.time.LocalDate
     */
    public static LocalDate dateTransLocalDate(Date date) {
        LocalDate localDate = null;
        Instant instant = date.toInstant();
        // 时区
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        localDate = localDateTime.toLocalDate();
        return localDate;
    }

  /*
   * @description:  Date 转LocalDateTime
   * @param: [date]
   * @return: java.time.LocalDateTime
   */
    public static LocalDateTime dateTransLocalDateTime(Date date) {
        LocalDate localDate = null;
        Instant instant = date.toInstant();
        // 时区
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /*
     * @description: LocalDate 转换为 Date
     * @param: [localDate]
     * @return: java.util.Date
     */
    public static Date localDateTransDate(LocalDate localDate){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

   /*
    * @description: LocalDateTime 转 Date
    * @param: [localDateTime]
    * @return: java.util.Date
    */
    public static Date localDateTimeTransDate(LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now());
    }
}
