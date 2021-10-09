package com.sz.common;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Lyh
 * @date 2021/09/27  17:39
 */

@Component
public class TimeCycle {


    /**
     * 将时间转换为时间戳
     * @param date
     * @return
     */
    public long TimeTOStamp(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime;//将你的日期转换为时间戳
        long time = 0;
        try {
            datetime = sdf.parse(date);
            time = datetime.getTime();
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return time/1000;
    }

    /**
     * 将时间转换
     * @param stamp
     * @return
     */
    static String StampToTime(Long stamp) {

        Date date1 = new Date(stamp);
        long l = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//你要转换成的时间格式,大小写不要变
        String yourtime = sdf.format(date1);//转换你的时间
        System.out.println(yourtime);
        return yourtime;
    }

    public void test1(){

        Long aLong = TimeTOStamp("2021-09-28 09:35:51");
        System.out.println(aLong);
//        String s = StampToTime(new Long(1632808309));
//        System.out.println(s);

    }
    
}
