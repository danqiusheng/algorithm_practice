package basic.第三章;

import java.util.Scanner;

/**
 * 周期串
 * 题目：如果一个字符可以由某个长度为k的字符串重复多次得到，则称该字符串以k为周期。例如，abcabcabcabc以3为周期（注意，他也以6和12为周期）。
 * input
 * 1
 * hohoho
 * output
 * 2
 * 思路： 第一种：使用String类的replace方法，第二种，使用间隔进行匹配
 * Created by Administrator on 2018/4/8.
 *
 * @author 丹丘生
 */
public class PeriodicStrings {
    static int length;
    static String str;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        read.nextLine();

        while (n-- > 0) {
            // 获取当前序列
            str = read.next();

            // 遍历获取
            length = str.length();
            int i;
            for (i = 1; i < length; i++) {
                String original = str;
                String replace = str.substring(0, i);
                String replaceStr = original.replaceAll(replace, "");
                if (replaceStr.equals("")) break;
            }

            System.out.println(i);

            int k = 0;
            int j;
            for (j = 1; j < length; j++) { // 遍历间隔
                if (length % j == 0) { //说明这个间隔能够被整除
                    if (check(k, j)) {
                        break;
                    }
                }
            }
            System.out.println(j);
        }
    }

    // 第二种方式
    public static boolean check(int k, int i) {
        char[] chs = str.toCharArray();

        for (int j = 0; j < length; j++) { // 从当前数字加间隔 进行匹配字母，如果不等直接return false
            if (chs[(j + k) % length] != chs[(i + j) % length]) {
                return false;
            }
        }
        return true;
    }

}
