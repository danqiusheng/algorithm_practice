package basic.第三章;

import java.util.Scanner;

/**
 * 得分
 * Created by Administrator on 2018/4/7.
 * 题目：有一个客观的测试结果，如“OOXXOXXOOO”，一个“O”表示一个问题的正确答案，一个“X”表示一个错误的答案。
 * 这个测试的每个问题的分数是由它自己计算的，例如，第10个问题的得分是3，它是由它自己和它的前两个连续的O得到的。
 * 因此，“OOXXOXXOOO”的分数是由“1 + 2 + 0 + 0 + 1 + 0 + 0 + 1 + 2 + 3”计算得到的10。
 * 输入：OOXXOXXOOO
 * 输出：10
 * 思路：直接遍历，遇到X重新计算即可
 *
 * @author 丹丘生
 */
public class Score {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String line = read.nextLine();
        int length = line.length();
        char[] chs = line.toCharArray();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (chs[i] == 'X') count = 0;
            if (chs[i] == 'O') count++;
            sum += count;
        }
        System.out.println(sum);
    }
}
