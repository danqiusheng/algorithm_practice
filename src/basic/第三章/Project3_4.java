package basic.第三章;

import java.util.Scanner;


/**
 * 竖式问题
 * Created by Administrator on 2018/4/4.
 * 题目：
 * 找出所有形如abc*de（三位数乘以两位数）的算式，使得在完整的竖式中，所有数字都属于一个特定的数字集合。
 * 输入数字集合（相邻数字之间没有空格），输出所有竖式。
 * 每个竖式前应有编号，之后应有一个空行。
 * 最后输出解的总数。具体格式见样例输出（为了便于观察，竖式中的空格改用小数点显示，但你的程序应该输出空格，而非小数点）。
 * 样例输入：2357
 * 样例输出：
 * <1>
 * ..775
 * X..33
 * -----
 * .2325
 * 2325.
 * -----
 * 25575
 *
 * @author 丹丘生
 */
public class Project3_4 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String target = read.nextLine();
        // 转换成数组
        int count = 1;
        for (int i = 100; i < 999; i++) {
            for (int j = 10; j < 99; j++) {
                int a = i * (j % 10);
                int b = i * (j / 10);
                int c = i * j;
                // 然后判断abc中是否不存在
                if (check(a, target) || check(b, target) || check(c, target)) {
                        continue;
                }
                printf(count,i,j,a,b,c);
                count++;
            }
        }
        System.out.println(count-1);
    }

    private static void printf(int count,int i, int j, int a, int b, int c) {
        System.out.println("<"+count+">");
        System.out.printf("%5d\nX%4d\n-----\n%5d\n%4d\n-----\n%5d",i,j,a,b,c);
        System.out.println();
    }

    private static boolean check(int a, String current) {
        String target = a + "";
        char[] targets = target.toCharArray();
        for (int i = 0; i < targets.length; i++) {
            if (current.indexOf(targets[i]) < 0) return true; // 没有找到
        }
        return false;
    }
}
