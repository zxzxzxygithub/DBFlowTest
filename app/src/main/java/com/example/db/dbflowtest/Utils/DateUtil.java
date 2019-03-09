package com.example.db.dbflowtest.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lijian
 * @des
 * @date 2019/3/9 14:19
 **/
public class DateUtil {
    public static final String DATETIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
    public static final String TIME_FORMAT_DEFAULT = "HH:mm:ss";

    public static String getDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}
