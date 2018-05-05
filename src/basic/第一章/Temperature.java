package basic.第一章;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * c=5(f-32)/9 保留3位小数，输入f
 * Created by Administrator on 2018/4/2.
 *
 * @author 丹丘生
 */
public class Temperature {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int f = read.nextInt();
        // String格式化
        System.out.println(String.format("%.3f", 5 * (f - 32) / 9.0));

        // BigDecimal
        BigDecimal bigDecimal = new BigDecimal(5 * (f - 32) / 9.0);
        System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());


        //C
        System.out.printf("%.3f", 5 * (f - 32) / 9.0);

        System.out.println();

        //DecimalFormat
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        System.out.println(decimalFormat.format(5 * (f - 32) / 9.0));

        // NumberFormat格式化
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(3);
        System.out.println(numberFormat.format(5 * (f - 32) / 9.0));
    }
}
