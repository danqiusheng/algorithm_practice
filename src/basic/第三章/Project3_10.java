package basic.第三章;

import java.util.Scanner;

/**
 * 环状序列（Circular Sequence)
 * 题目： 长度为n的换证串有n种表示法，分别为从某个位置开始顺时针得到。
 * 有10种表示：CGAGTCAGCT,GAGTCAGCTC,AGTCAGCTCG等。在这些表示法中，字典序最小的成为“最小表示”。
 * 输入一个长度为n(n<=100)的环状DNA串（只包含A，C，G，T）的一种表示法你的任务是输出该环状串的最小表示。例如，CTCC的最小表示是CCCT。ＣＧＡＧＴＣＡＧＣＴ的最小表示为ＡＧＣＴＣＡＧＴＣ。
 * 思路：针对当前的下标，与下一个下标进行票匹配（字符串进行比较）
 * Created by Administrator on 2018/4/7.
 *
 * @author 丹丘生
 */
public class Project3_10 {
    static String str;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        str = read.nextLine();
        int min = 0;
        for (int i = 0; i < str.length(); i++) {
            if (checkIsMin(min, i)) min = i;
        }

        for (int i = 0; i < str.length(); i++) {
            if (checkIsMin(min, i)) min = i;
        }

        // 采用string的切割拼接，字符串进行比较
        for (int i = 0; i < str.length(); i++) {
            if (check(min, i) > 0) min = i;
        }


        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt((i + min) % str.length()));
        }


    }

    public static int check(int min, int index) {
        return str.substring(min).concat(str.substring(0, min)).compareTo(str.substring(index).concat(str.substring(0, index)));
    }

    /**
     * 比较查看最小的数据
     *
     * @param min
     * @param index
     * @return
     */
    private static boolean checkIsMin(int min, int index) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt((i + min) % str.length()) != str.charAt((i + index) % str.length())) {
                return str.charAt((i + min) % str.length()) > str.charAt((i + index) % str.length());
            }
        }
        return false; // 代表相等
    }
}
