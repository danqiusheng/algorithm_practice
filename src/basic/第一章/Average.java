package basic.第一章;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 输入三个整数，输出他们的平均值，保留3位小数
 * Created by Administrator on 2018/4/2.
 * @author 丹丘生
 * 注意：Java保留3位小数，可以使用C的方式
 */
public class Average {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b =read.nextInt();
        int c = read.nextInt();

        // C进行格式化数据 保留3位数据 %.3f
        System.out.printf("%.3f",(a+b+c)/3.0);

        System.out.println();

        // Java需要定义数据格式化类
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format((a+b+c)/3.0));

        // 字符串格式化输出
        System.out.println(String.format("%.3f", (a+b+c)/3.0));

        //第三种采用BigDecimal进行四舍五入保留
        BigDecimal bg = new BigDecimal((a+b+c)/3.0);
        double f1 = bg.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);

        // 使用NumberFormat
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(3);// 设置保留的位数
        System.out.println(nf.format((a+b+c)/3.0));
    }
}
