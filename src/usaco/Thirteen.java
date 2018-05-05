package usaco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 题目：13号又是一个星期五。13号在星期五比在其他日子少吗?为了回答这个问题,写一个程序，
 * 要求计算每个月的十三号落在周一到周日的次数。给出N年的一个周期，要求计算1900年1月1日至1900+N-1年12月31日中十三号落在周一到周日的次数，N为正整数且不大于400.
 * Created by Administrator on 2018/3/31.
 *
 * @author 丹丘生
 */
public class Thirteen {
    public static void main(String[] args) throws ParseException {
        int N = 1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int[] arr = new int[7];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 12; j++) {
                int year = 1900 + i;
                String str = year + "-" + j + "-" + 13;
                System.out.println(str);
                Date date = simpleDateFormat.parse(str);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE");
                String key = simpleDateFormat1.format(date);
                System.out.println(key);
                switch (key) {
                    case "星期一":
                        arr[0]++;
                        break;
                    case "星期二":
                        arr[1]++;
                        break;
                    case "星期三":
                        arr[2]++;
                        break;
                    case "星期四":
                        arr[3]++;
                        break;
                    case "星期五":
                        arr[4]++;
                        break;
                    case "星期六":
                        arr[5]++;
                        break;
                    case "星期日":
                        arr[6]++;
                        break;

                }
            }
            // 打印顺序不对
            System.out.println(Arrays.toString(arr));

        }
    }
}