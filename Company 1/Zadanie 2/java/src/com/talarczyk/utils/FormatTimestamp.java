package com.talarczyk.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTimestamp {

    public static String format(Timestamp timestamp){
        Date date = new Date();
        date.setTime(timestamp.getTime());
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String format(Timestamp timestamp, String pattern){
        Date date = new Date();
        date.setTime(timestamp.getTime());
        return new SimpleDateFormat(pattern).format(date);
    }
}
