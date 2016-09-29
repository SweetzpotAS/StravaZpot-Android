package com.sweetzpot.stravazpot.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public static Date makeDate(int day, int month, int year, int hour, int minute, int second) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getTimeZone("GMT"));
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, day);
        instance.set(Calendar.HOUR_OF_DAY, hour);
        instance.set(Calendar.MINUTE, minute);
        instance.set(Calendar.SECOND, second);
        return instance.getTime();
    }
}
