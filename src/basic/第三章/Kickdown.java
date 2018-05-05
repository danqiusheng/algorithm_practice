package basic.第三章;

import java.util.Scanner;

/**
 * 题目：给出两个长度分别为n1,n2且每列高度只为1或者2的长条，需要将它们放入一个高度为3的容器，问容器的最短长度。
 * 输入：
 * 2112112112
 * 2212112
 * 12121212
 * 21212121
 * 2211221122
 * 21212
 * 输出：
 * 10
 * 8
 * 15
 * 思路：这题很简单，主要就是判断n1和n2的高度不能超出3
 * 第一步：判断输入的n1和n2的长度
 * 第二步：遍历最短的字符串n2，然后同时遍历n1，如果有不满足的高度出现，则将最短字符串n2头部添加'0' 然后重新开始遍历；
 * Created by Administrator on 2018/5/3.
 *
 * @author 丹丘生
 */
public class Kickdown {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String n1 = read.nextLine();
        String n2 = read.nextLine();

        if (n1.length() < n2.length()) {
            String temp = n2;
            n2 = n1;
            n1 = temp;
        }
        StringBuilder sb = new StringBuilder(n2);
        char[] one = n1.toCharArray();
        int one_length = n1.length();
        int length = sb.length();
        int i = 0;
        for (; i < length; i++) {
            // 获取最短的第一个
            if (i < one_length) {
                char l_char = one[i];
                char s_char = sb.charAt(i);
                if (l_char == '2' && s_char == '2') {// 如果超出高度
                    sb.insert(0, "0"); //头部添加一个0
                    length = sb.length();
                    i = 0;// 重新遍历
                }
            }
        }

        if (length < one_length) {
            System.out.println(one_length);
        } else {
            System.out.println(length);
        }


    }
}
