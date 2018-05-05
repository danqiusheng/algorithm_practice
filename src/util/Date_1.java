package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/4/1.
 * 获取当前年月日的是星期几
 */
public class Date_1 {
    public static void main(String[] args) throws ParseException {
        String str  = "1900-1-1";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(str);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE");
        System.out.println(simpleDateFormat1.format(date));

    }
}
