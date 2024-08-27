package com.bank.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // Define the desired date format
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Method to format a Date object into a string
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
}
