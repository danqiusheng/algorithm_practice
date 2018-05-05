package basic.第二章;

import java.util.Scanner;

/**
 * 输入两个正整数，n<m<10的六次方  输出1/n的平方+1/(n+1)的平方 +....+ 1/m的平方  保留五位小数
 * Created by Administrator on 2018/4/3.
 *
 * @author 丹丘生
 */
public class Subsequence {
    public static void main(String[] args) {
        while (true) {
            Scanner read = new Scanner(System.in);
            long n = read.nextLong();
            long m = read.nextLong();

            if (n == 0 && m == 0) break;

            double sum = 0;
            for (long i = n; i <= m; i++) {
                System.out.println(i);
                sum += 1.0 / (i * i);
            }

            System.out.println(String.format("%.5f", sum));
        }
    }
}
