package basic.第二章;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Decimal {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while (true) {
            double a = read.nextDouble();
            double b = read.nextDouble();
            int c = read.nextInt();
            if (a == 0 && b == 0 && c == 0) break;
            BigDecimal bigDecimal = new BigDecimal(a  / b);
            System.out.println( bigDecimal.setScale(c, BigDecimal.ROUND_HALF_UP).doubleValue());
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMaximumFractionDigits(c);
            System.out.println(numberFormat.format(a  / b));
        }
    }
}
