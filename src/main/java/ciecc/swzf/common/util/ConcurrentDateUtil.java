package ciecc.swzf.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用ThreadLocal来操作 SimpleDateFormat
 *
 * @author kandigx
 * @create 2017-09-15 9:40
 */
public class ConcurrentDateUtil {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 字符串转换成日期
     * @param dateStr 格式：yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }

}
