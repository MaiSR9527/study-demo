package com.gdou.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maishuren
 * @date 2019/6/9 10:21
 */
public class DateUtils {
  // 日期转换成字符串
  public static String date2String(Date date, String patt) {
    SimpleDateFormat sdf = new SimpleDateFormat(patt);
    String format = sdf.format(date);
    return format;
  }

  // 字符串转换成日期
  public static Date string2Date(String str, String patt) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat(patt);
    Date parse = sdf.parse(str);
    return parse;
  }

  /**
   * 时间戳转日期
   * @param s 时间戳
   * @return 日期
   */
  public static Date stampToDate(String s) throws ParseException {
    String res;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long lt = new Long(s);
    Date date = new Date(lt);
    res = simpleDateFormat.format(date);
    Date date1 = string2Date(res, "yyyy-MM-dd");
    return date1;
  }

  public static void main(String[] args) throws ParseException {
    Date date = string2Date("2017-06-12", "yyyy-MM-dd");
    long l = date.getTime() + 22 * 86400000;
    String s = Long.toString(l);
    System.out.println(stampToDate(s));

  }
}
