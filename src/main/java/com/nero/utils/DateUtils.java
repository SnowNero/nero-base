package com.nero.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2022-06-30
 * Time: 11:59
 *
 * @author nero
 */
public class DateUtils {

    /**
     * 年月日
     */
    private static String DATE_FORMAT_DAY = "yyyy-MM-dd";

    public static void main(String[] args) {
        String currentDay = getCurrentDay();
        System.out.println(currentDay);
    }

    /**
     * 获取今天
     *
     * @return
     */
    public static String getCurrentDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_DAY);
        Date date = new Date();
        String res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获取前一天
     *
     * @return
     */
    public static String getPreviousDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_DAY);
        Date date = new Date();
        String res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获取前一天
     *
     * @return
     */
    public static String getNextDay(String dateStr) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_DAY);
        Date date = simpleDateFormat.parse(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //往前一天
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String res = simpleDateFormat.format(calendar.getTime());
        return res;
    }

}
